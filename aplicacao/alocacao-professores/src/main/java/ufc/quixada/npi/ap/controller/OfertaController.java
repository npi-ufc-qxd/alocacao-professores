package ufc.quixada.npi.ap.controller;

import static ufc.quixada.npi.ap.util.Constants.SWAL_STATUS_SUCCESS;
import static ufc.quixada.npi.ap.util.Constants.MSG_OFERTA_CADASTRADA;
import static ufc.quixada.npi.ap.util.Constants.MSG_OFERTA_EDITADA;
import static ufc.quixada.npi.ap.util.Constants.MSG_COMPARTILHAMENTO_SOLICITADO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ufc.quixada.npi.ap.annotation.RestricaoDePeriodo;
import ufc.quixada.npi.ap.annotation.RestricaoDePeriodoAjax;
import ufc.quixada.npi.ap.model.Compartilhamento;
import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Disciplina;
import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.model.Pessoa;
import ufc.quixada.npi.ap.model.Professor;
import ufc.quixada.npi.ap.service.CompartilhamentoService;
import ufc.quixada.npi.ap.service.CursoService;
import ufc.quixada.npi.ap.service.DisciplinaService;
import ufc.quixada.npi.ap.service.OfertaService;
import ufc.quixada.npi.ap.service.PeriodoService;
import ufc.quixada.npi.ap.service.ProfessorService;
import ufc.quixada.npi.ap.service.TurmaService;
import ufc.quixada.npi.ap.util.Constants;
import ufc.quixada.npi.ap.validation.CompartilhamentoValidator;
import ufc.quixada.npi.ap.validation.OfertaValidator;

@Controller
@RequestMapping(value = "/ofertas")
public class OfertaController {

	@Autowired
	private OfertaService ofertaService;

	@Autowired
	private ProfessorService professorService;

	@Autowired
	private TurmaService turmaService;

	@Autowired
	private DisciplinaService disciplinaService;

	@Autowired
	private OfertaValidator ofertaValidator;

	@Autowired
	private PeriodoService periodoService;
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private CompartilhamentoService compartilhamentoService;

	@Autowired
	private CompartilhamentoValidator compartilhamentoValidator;
	

	@ModelAttribute("professores")
	public List<Professor> todosProfessores() {
		return professorService.buscarTodosProfessores();
	}
	
	@ModelAttribute("cursos")
	public List<Curso> todosCursos() {
		return cursoService.buscarTodosCursos();
	}

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ModelAndView listarOfertasIndex(Authentication auth) {
		Pessoa pessoa = (Pessoa) auth.getPrincipal();
		
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_LISTAR);

		Curso cursoAtual = cursoService.buscarCursoPorCoordenador(pessoa);

		if(null  == cursoAtual) {
			cursoAtual = cursoService.buscarPorSigla("SI");
		}

		modelAndView.addObject("cursoAtual", cursoAtual);
		modelAndView.addObject("periodo", periodoService.buscarPeriodoAtivo());
		modelAndView.addObject("periodos", periodoService.buscarPeriodosConsolidados());

		return modelAndView;
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	@RestricaoDePeriodo(Constants.OFERTA_REDIRECT_LISTAR)
	public ModelAndView cadastrarOferta(@ModelAttribute("oferta") Oferta oferta, Authentication auth) {
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_CADASTRAR);
		Pessoa pessoa = (Pessoa) auth.getPrincipal();
		
		modelAndView.addObject("cursoAtual", cursoService.buscarCursoPorCoordenador(pessoa));
		modelAndView.addObject("periodoAtivo", periodoService.buscarPeriodoAtivo());
		modelAndView.addObject("disciplinas", disciplinaService.buscarDisciplinasNaoArquivadas());		
		modelAndView.addObject("turmas", turmaService.buscarTodasTurmas());
		
		return modelAndView;
	}
	

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastrarOferta(@ModelAttribute("oferta") @Valid Oferta oferta, BindingResult bindingResult, ModelAndView modelAndView, RedirectAttributes redirectAttributes, Authentication auth) {

		ofertaValidator.validate(oferta, bindingResult);

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName(Constants.OFERTA_CADASTRAR);
			
			Pessoa pessoa = (Pessoa) auth.getPrincipal();
			
			modelAndView.addObject("cursoAtual", cursoService.buscarCursoPorCoordenador(pessoa));
			modelAndView.addObject("periodoAtivo", periodoService.buscarPeriodoAtivo());
			modelAndView.addObject("disciplinas", disciplinaService.buscarDisciplinasNaoArquivadas());
			modelAndView.addObject("turmas", turmaService.buscarTodasTurmas());
			
			return modelAndView;
		}

		ofertaService.salvarOfertaPeriodoAtivo(oferta);
		
		modelAndView.setViewName(Constants.OFERTA_REDIRECT_LISTAR);
		
		redirectAttributes.addFlashAttribute(SWAL_STATUS_SUCCESS, MSG_OFERTA_CADASTRADA);
		
		return modelAndView;
	}

	@RequestMapping(value = "/{id}/editar", method = RequestMethod.GET)
	@RestricaoDePeriodo(Constants.OFERTA_REDIRECT_LISTAR)
	public ModelAndView editarOferta(@PathVariable("id") Integer id, Authentication auth) {
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_EDITAR);

		Oferta oferta = ofertaService.buscarOferta(id);
		
		if (oferta == null) {
			modelAndView.setViewName(Constants.OFERTA_REDIRECT_LISTAR);
			
			return modelAndView;
		}
		
		Pessoa pessoa = (Pessoa) auth.getPrincipal();
		Curso cursoCoordenador = cursoService.buscarCursoPorCoordenador(pessoa);
		List<Disciplina> disciplinas = disciplinaService.buscarDisciplinasNaoArquivadas();
		
		modelAndView.addObject("oferta", oferta);
		modelAndView.addObject("cursoAtual", cursoCoordenador);
		modelAndView.addObject("disciplinas", disciplinas);

		return modelAndView;
	}

	@RequestMapping(value = "/{id}/editar", method = RequestMethod.POST)
	public ModelAndView editarOferta(@ModelAttribute("oferta") @Valid Oferta oferta, BindingResult bindingResult, ModelAndView modelAndView, Authentication auth, RedirectAttributes redirectAttributes) {

		ofertaValidator.validate(oferta, bindingResult);

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName(Constants.OFERTA_EDITAR);
			
			Pessoa pessoa = (Pessoa) auth.getPrincipal();
			Curso cursoCoordenador = cursoService.buscarCursoPorCoordenador(pessoa);
			List<Disciplina> disciplinas = disciplinaService.buscarDisciplinasNaoArquivadas();
			
			modelAndView.addObject("oferta", oferta);
			modelAndView.addObject("cursoAtual", cursoCoordenador);
			modelAndView.addObject("disciplinas", disciplinas);

			return modelAndView;
		}

		ofertaService.salvarOfertaPeriodoAtivo(oferta);
		
		redirectAttributes.addFlashAttribute(SWAL_STATUS_SUCCESS, MSG_OFERTA_EDITADA);

		modelAndView.setViewName(Constants.OFERTA_REDIRECT_LISTAR);

		return modelAndView;
	}

	@RequestMapping(path = { "/{id}/detalhar" }, method = RequestMethod.GET)
	public ModelAndView detalharOferta(@PathVariable("id") Integer id, @RequestParam(required = false) String erro) {
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_DETALHAR);
		
		Oferta oferta = ofertaService.buscarOferta(id);
		
		modelAndView.addObject("oferta", oferta);
		modelAndView.addObject("professores", oferta.getProfessores());
		modelAndView.addObject("erro", erro);

		return modelAndView;
	}

	@RequestMapping(value = "/{id}/excluir", method = RequestMethod.GET)
	@RestricaoDePeriodoAjax
	public @ResponseBody boolean excluirOferta(@PathVariable(name = "id", required = true) Integer id) {
		try {
			ofertaService.excluir(id);
		} catch (EmptyResultDataAccessException e) {
			return false;
		}

		return true;
	}

	@RequestMapping(path = {"/{idOferta}/solicitar-compartilhamento"}, method = RequestMethod.GET)
	@RestricaoDePeriodo(Constants.OFERTA_REDIRECT_LISTAR)
	public ModelAndView solicitarCompartilhamento(@PathVariable("idOferta") Integer id,
			@ModelAttribute("compartilhamento") Compartilhamento compartilhamento, Authentication auth){
		
		ModelAndView modelAndView = new ModelAndView(Constants.COMPARTILHAMENTO_CADASTRAR);

		Pessoa pessoa = (Pessoa) auth.getPrincipal();

		modelAndView.addObject("oferta", ofertaService.buscarOferta(id));
		modelAndView.addObject("turmas", cursoService.buscarCursoPorCoordenador(pessoa).getTurmas());

		return modelAndView;
	}

	@RequestMapping(path = {"/{idOferta}/solicitar-compartilhamento"}, method = RequestMethod.POST)
	public ModelAndView solicitarCompartilhamento(@PathVariable("idOferta") Integer id,
			@ModelAttribute("compartilhamento") @Valid Compartilhamento compartilhamento,
			BindingResult bindingResult, ModelAndView modelAndView, RedirectAttributes redirectAttributes,
			Authentication auth){
		
		Pessoa coordenador = (Pessoa) auth.getPrincipal();
		Curso cursoCoordenador = cursoService.buscarCursoPorCoordenador(coordenador);
		
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("compartilhamento", compartilhamento);
		mapa.put("cursoCoordenador", cursoCoordenador);
		
		compartilhamentoValidator.validate(mapa, bindingResult);
		
		if (bindingResult.hasErrors()){
			modelAndView.setViewName(Constants.COMPARTILHAMENTO_CADASTRAR);
			
			Pessoa pessoa = (Pessoa) auth.getPrincipal();
			
			modelAndView.addObject("oferta", ofertaService.buscarOferta(id));
			modelAndView.addObject("turmas", cursoService.buscarCursoPorCoordenador(pessoa).getTurmas());
			
			return modelAndView;
		}

		compartilhamentoService.salvar(compartilhamento);
		
		redirectAttributes.addFlashAttribute(SWAL_STATUS_SUCCESS, MSG_COMPARTILHAMENTO_SOLICITADO);
		 
		modelAndView.setViewName(Constants.OFERTA_REDIRECT_LISTAR);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/importar", method = RequestMethod.GET)
	@RestricaoDePeriodo(Constants.OFERTA_REDIRECT_LISTAR)
	public ModelAndView importarOfertas(Authentication auth) {
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_IMPORTAR);

		Pessoa pessoa = (Pessoa) auth.getPrincipal();
		List<Periodo> periodosConsolidados = periodoService.buscarPeriodosConsolidados();
		
		modelAndView.addObject("cursoAtual", cursoService.buscarCursoPorCoordenador(pessoa));
		modelAndView.addObject("periodos", periodosConsolidados);
		
		return modelAndView;
	}

	@RequestMapping(value = "/importar-ofertas", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> importarOfertas(@RequestParam("ofertas") List<Integer> ofertas) {
		Periodo periodoAtivo = periodoService.buscarPeriodoAtivo();
		
		return ofertaService.importarOfertas(ofertas, periodoAtivo);
	}
	
	@RequestMapping(value = "/importar-ofertas-compartilhadas", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> importarOfertasCompartilhadas(@RequestParam("compartilhamentos") List<Integer> compartilhamentos, Authentication auth) {
		Pessoa coordenador = (Pessoa) auth.getPrincipal();
		Curso curso = cursoService.buscarCursoPorCoordenador(coordenador);
		Periodo periodoAtivo = periodoService.buscarPeriodoAtivo();
		
		return compartilhamentoService.importarOfertasCompartilhadas(compartilhamentos, periodoAtivo, curso);
	}

	@RequestMapping(value = "/periodo/{idPeriodo}/buscar-ofertas/", method = RequestMethod.GET)
	public @ResponseBody ModelMap buscarOfertas(@PathVariable("idPeriodo") Integer idPeriodo, Authentication auth) {
		ModelMap model = new ModelMap();
		
		Pessoa coordenador = (Pessoa) auth.getPrincipal();
		Curso curso = cursoService.buscarCursoPorCoordenador(coordenador);
		Periodo periodo = periodoService.buscarPeriodo(idPeriodo);
		Periodo periodoAtivo = periodoService.buscarPeriodoAtivo();
		
		List<Oferta> ofertas = ofertaService.buscarOfertasNaoImportadasPeriodoAtivoPorPeriodoAndCurso(periodo, periodoAtivo, curso);
		List<Oferta> ofertasImportadas =  ofertaService.buscarOfertasImportadasPeriodoAtivoPorPeriodoAndCurso(periodo, periodoAtivo, curso);
		List<Compartilhamento> ofertasCompartilhadas = compartilhamentoService.buscarCompartilhamentosNaoImportadosPorPeriodoAndCurso(periodo, periodoAtivo, curso);
		List<Compartilhamento> ofertasCompartilhadasImportadas = compartilhamentoService.buscarCompartilhamentosImportadosPorPeriodoAndCurso(periodo, periodoAtivo, curso);
		
		model.addAttribute("ofertas", ofertas);
		model.addAttribute("ofertasImportadas", ofertasImportadas);
		model.addAttribute("ofertasCompartilhadas", ofertasCompartilhadas);
		model.addAttribute("ofertasCompartilhadasImportadas", ofertasCompartilhadasImportadas);
		
		return model;
	}
	
	@RequestMapping(value = "/curso/{idCurso}/buscar-ofertas/", method = RequestMethod.GET)
	public @ResponseBody ModelMap listarOfertasPorCurso(@PathVariable("idCurso") Curso curso, Authentication auth) {
		ModelMap model = new ModelMap();

		Periodo periodoAtivo = periodoService.buscarPeriodoAtivo();

		List<Oferta> ofertas = ofertaService.buscarPorPeriodoAndCurso(periodoAtivo, curso);
		List<Compartilhamento> compartilhamentos = compartilhamentoService.buscarCompartilhamentosPorPeriodoAndCurso(periodoAtivo, curso);

		Pessoa pessoa = (Pessoa) auth.getPrincipal();
		model.addAttribute("papelDirecao", pessoa.isDirecao());
		model.addAttribute("curso", curso);
		model.addAttribute("ofertas", ofertas);
		model.addAttribute("compartilhamentos", compartilhamentos);

		return model;
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public @ResponseBody ModelMap listarOfertas(Authentication auth) {
		ModelMap model = new ModelMap();
		
		Pessoa coordenador = (Pessoa) auth.getPrincipal();
		Periodo periodoAtivo = periodoService.buscarPeriodoAtivo();
		Curso cursoCoordenador = cursoService.buscarCursoPorCoordenador(coordenador);

		if(null  == cursoCoordenador) {
			cursoCoordenador = cursoService.buscarPorSigla("SI");
		}

		List<Oferta> ofertasCurso = ofertaService.buscarPorPeriodoAndCurso(periodoAtivo, cursoCoordenador);
		List<Compartilhamento> compartilhamentos = compartilhamentoService.buscarCompartilhamentosPorPeriodoAndCurso(periodoAtivo, cursoCoordenador);

		model.addAttribute("papelDirecao", coordenador.isDirecao());
		model.addAttribute("curso", cursoCoordenador);
		model.addAttribute("ofertas", ofertasCurso);
		model.addAttribute("compartilhamentos", compartilhamentos);

		return model;
	}	


	@RequestMapping(value = "/buscar-ofertas/{periodo}", method = RequestMethod.GET)
	public @ResponseBody ModelMap buscarOfertas(@PathVariable("periodo") Periodo periodo, Authentication auth) {
		ModelMap model = new ModelMap();
		
		Pessoa coordenador = (Pessoa) auth.getPrincipal();
		Curso curso = cursoService.buscarCursoPorCoordenador(coordenador);
		Periodo periodoAtivo = periodoService.buscarPeriodoAtivo();
		
		List<Oferta> ofertas = ofertaService.buscarOfertasNaoImportadasPeriodoAtivoPorPeriodoAndCurso(periodo, periodoAtivo, curso);
		List<Oferta> ofertasImportadas =  ofertaService.buscarOfertasImportadasPeriodoAtivoPorPeriodoAndCurso(periodo, periodoAtivo, curso);
		List<Compartilhamento> ofertasCompartilhadas = compartilhamentoService.buscarCompartilhamentosNaoImportadosPorPeriodoAndCurso(periodo, periodoAtivo, curso);
		List<Compartilhamento> ofertasCompartilhadasImportadas = compartilhamentoService.buscarCompartilhamentosImportadosPorPeriodoAndCurso(periodo, periodoAtivo, curso);
		
		model.addAttribute("ofertas", ofertas);
		model.addAttribute("ofertasImportadas", ofertasImportadas);
		model.addAttribute("ofertasCompartilhadas", ofertasCompartilhadas);
		model.addAttribute("ofertasCompartilhadasImportadas", ofertasCompartilhadasImportadas);
		
		return model;
	}

	@RequestMapping(value = "/substituicao-ofertas", method = RequestMethod.GET)
	public @ResponseBody boolean substituirOfertas(@RequestParam("ofertas") List<Integer> ofertas) {
		ofertaService.substituirOferta(ofertas);
		return true;
	}

	@RequestMapping(path = {"/{id}/solicitar-compartilhamento"}, method = RequestMethod.GET)
	public ModelAndView cadastrarCompartilhamento(@PathVariable("id") Integer id, @ModelAttribute("compartilhamento") Compartilhamento compartilhamento, Authentication auth){
		ModelAndView modelAndView = new ModelAndView(Constants.COMPARTILHAMENTO_CADASTRAR);

		Pessoa pessoa = (Pessoa) auth.getPrincipal();

		modelAndView.addObject("oferta", ofertaService.buscarOferta(id));
		
		if(!pessoa.isDirecao()) {
			modelAndView.addObject("turmas", cursoService.buscarCursoPorCoordenador(pessoa).getTurmas());
		}

		return modelAndView;
	}

	@RequestMapping(path = {"/{id}/solicitar-compartilhamento"}, method = RequestMethod.POST)
	public ModelAndView cadastrarCompartilhamento(@PathVariable("id") Integer id, @ModelAttribute("compartilhamento") @Valid Compartilhamento compartilhamento, BindingResult bindingResult, ModelAndView modelAndView, Authentication auth){
		compartilhamentoValidator.validate(compartilhamento, bindingResult);

		Pessoa pessoa = (Pessoa) auth.getPrincipal();

		modelAndView.addObject("oferta", ofertaService.buscarOferta(id));
		
		if(!pessoa.isDirecao()) {
			modelAndView.addObject("turmas", cursoService.buscarCursoPorCoordenador(pessoa).getTurmas());
		}

		if (bindingResult.hasErrors()){
			modelAndView.setViewName(Constants.COMPARTILHAMENTO_CADASTRAR);
			return modelAndView;
		}

		try{
			compartilhamentoService.salvar(compartilhamento);
		} catch(Exception e){
			modelAndView.setViewName(Constants.PAGINA_ERRO_403);
			return modelAndView;
		}
		
		modelAndView.setViewName(Constants.OFERTA_REDIRECT_LISTAR);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/{id}/relacionamentos", method = RequestMethod.GET)
	public @ResponseBody boolean hasRelacionamentos(@PathVariable("id") Oferta oferta) {
		return ofertaService.hasCompartilhamentoOuRestricaoHorario(oferta);
	}

}