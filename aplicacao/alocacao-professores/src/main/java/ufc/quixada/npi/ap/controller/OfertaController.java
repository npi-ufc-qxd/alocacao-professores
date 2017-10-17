package ufc.quixada.npi.ap.controller;

import static ufc.quixada.npi.ap.util.Constants.OFERTA_CADASTRADA;
import static ufc.quixada.npi.ap.util.Constants.STATUS_SUCCESS;

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

import ufc.quixada.npi.ap.model.Compartilhamento;
import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.model.Pessoa;
import ufc.quixada.npi.ap.model.Professor;
import ufc.quixada.npi.ap.model.Turma;
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
	

	@ModelAttribute("turmas")
	public List<Turma> todasTurmas() {
		return turmaService.buscarTodasTurmas();
	}

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
		modelAndView.addObject("periodo", periodoService.buscarPeriodoAtivo());
		modelAndView.addObject("periodos", periodoService.buscarPeriodosConsolidados());
		modelAndView.addObject("cursoAtual", cursoService.buscarCursoPorCoordenador(pessoa));

		return modelAndView;
	}
	
	@RequestMapping(value = "/curso/{idCurso}", method = RequestMethod.GET)
	public @ResponseBody ModelMap listarOfertasPorCurso(@PathVariable("idCurso") Curso curso) {
		ModelMap model = new ModelMap();

		Periodo periodoAtivo = periodoService.buscarPeriodoAtivo();

		List<Oferta> ofertas = ofertaService.buscarPorPeriodoAndCurso(periodoAtivo, curso);
		List<Compartilhamento> compartilhamentos = compartilhamentoService.buscarCompartilhamentosPorPeriodoAndCurso(periodoAtivo, curso);

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

		List<Oferta> ofertasCurso = ofertaService.buscarPorPeriodoAndCurso(periodoAtivo, cursoCoordenador);
		List<Compartilhamento> compartilhamentos = compartilhamentoService.buscarCompartilhamentosPorPeriodoAndCurso(periodoAtivo, cursoCoordenador);

		model.addAttribute("ofertas", ofertasCurso);
		model.addAttribute("compartilhamentos", compartilhamentos);

		return model;
	}	

	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public ModelAndView cadastrarOferta(@ModelAttribute("oferta") Oferta oferta, Authentication auth) {
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_CADASTRAR);
		Pessoa pessoa = (Pessoa) auth.getPrincipal();
		
		modelAndView.addObject("disciplinas", disciplinaService.buscarDisciplinasNaoArquivadas());		
		modelAndView.addObject("cursoAtual", cursoService.buscarCursoPorCoordenador(pessoa));
		modelAndView.addObject("periodoAtivo", periodoService.buscarPeriodoAtivo());
		
		return modelAndView;
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastrarOferta(@ModelAttribute("oferta") @Valid Oferta oferta, BindingResult bindingResult,
			ModelAndView modelAndView, RedirectAttributes redirectAttributes, Authentication auth) {

		ofertaValidator.validate(oferta, bindingResult);

		if (bindingResult.hasErrors()) {
			Pessoa pessoa = (Pessoa) auth.getPrincipal();
			
			modelAndView.setViewName(Constants.OFERTA_CADASTRAR);
			modelAndView.addObject("cursoAtual", cursoService.buscarCursoPorCoordenador(pessoa));
			modelAndView.addObject("disciplinas", disciplinaService.buscarDisciplinasNaoArquivadas());
			modelAndView.addObject("periodoAtivo", periodoService.buscarPeriodoAtivo());
			
			return modelAndView;
		}

		ofertaService.salvarOfertaPeriodoAtivo(oferta);
		
		modelAndView.setViewName(Constants.OFERTA_REDIRECT_LISTAR);
		
		redirectAttributes.addFlashAttribute(STATUS_SUCCESS, OFERTA_CADASTRADA);
		
		return modelAndView;
	}

	@RequestMapping(value = "/{id}/editar", method = RequestMethod.GET)
	public ModelAndView editarOferta(@PathVariable("id") Integer id, Authentication auth) {
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_EDITAR);

		Pessoa pessoa = (Pessoa) auth.getPrincipal();
		modelAndView.addObject("cursoAtual", cursoService.buscarCursoPorCoordenador(pessoa));

		modelAndView.addObject("oferta", ofertaService.buscarOferta(id));
		modelAndView.addObject("disciplinas", disciplinaService.buscarDisciplinasNaoArquivadas());

		return modelAndView;
	}

	@RequestMapping(value = "/{id}/editar", method = RequestMethod.POST)
	public ModelAndView editarOferta(@PathVariable(name = "id", required = true) Integer id,
			@ModelAttribute("oferta") @Valid Oferta oferta, BindingResult bindingResult, ModelAndView modelAndView, Authentication auth) {

		ofertaValidator.validate(oferta, bindingResult);

		if (bindingResult.hasErrors()) {
			Pessoa pessoa = (Pessoa) auth.getPrincipal();
			
			modelAndView.setViewName(Constants.OFERTA_EDITAR);
			modelAndView.addObject("cursoAtual", cursoService.buscarCursoPorCoordenador(pessoa));
			modelAndView.addObject("disciplinas", disciplinaService.buscarDisciplinasNaoArquivadas());
			modelAndView.addObject("periodoAtivo", periodoService.buscarPeriodoAtivo());

			return modelAndView;
		}

		ofertaService.salvarOfertaPeriodoAtivo(oferta);

		modelAndView.setViewName(Constants.OFERTA_REDIRECT_LISTAR);

		return modelAndView;
	}

	@RequestMapping(path = { "/{id}/detalhar" }, method = RequestMethod.GET)
	public ModelAndView detalharOferta(@PathVariable("id") Integer id, @RequestParam(required = false) String erro) {
		Oferta oferta = ofertaService.buscarOferta(id);

		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_DETALHAR);
		modelAndView.addObject("oferta", oferta);
		modelAndView.addObject("professores", oferta.getProfessores());
		modelAndView.addObject("erro", erro);

		return modelAndView;
	}

	@RequestMapping(value = "/{id}/excluir", method = RequestMethod.GET)
	public @ResponseBody boolean excluirOferta(@PathVariable(name = "id", required = true) Integer id) {
		try {
			ofertaService.excluir(id);
		} catch (EmptyResultDataAccessException e) {
			return false;
		}

		return true;
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
		model.addAttribute("ofertasCompartilhadas", ofertasCompartilhadas);
		model.addAttribute("ofertasCompartilhadasImportadas", ofertasCompartilhadasImportadas);
		model.addAttribute("ofertasImportadas", ofertasImportadas);
		
		return model;
	}
	
	@RequestMapping(value = "/importar", method = RequestMethod.GET)
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
	
	@RequestMapping(path = {"/{id}/solicitar-compartilhamento"}, method = RequestMethod.GET)
	public ModelAndView cadastrarCompartilhamento(@PathVariable("id") Integer id, @ModelAttribute("compartilhamento") Compartilhamento compartilhamento, Authentication auth){
		ModelAndView modelAndView = new ModelAndView(Constants.COMPARTILHAMENTO_CADASTRAR);

		Pessoa pessoa = (Pessoa) auth.getPrincipal();

		modelAndView.addObject("oferta", ofertaService.buscarOferta(id));
		modelAndView.addObject("turmas", cursoService.buscarCursoPorCoordenador(pessoa).getTurmas());

		return modelAndView;
	}

	@RequestMapping(path = {"/{id}/solicitar-compartilhamento"}, method = RequestMethod.POST)
	public ModelAndView cadastrarCompartilhamento(@PathVariable("id") Integer id, @ModelAttribute("compartilhamento") @Valid Compartilhamento compartilhamento, BindingResult bindingResult, ModelAndView modelAndView, Authentication auth){
		compartilhamentoValidator.validate(compartilhamento, bindingResult);

		Pessoa pessoa = (Pessoa) auth.getPrincipal();

		modelAndView.addObject("oferta", ofertaService.buscarOferta(id));
		modelAndView.addObject("turmas", cursoService.buscarCursoPorCoordenador(pessoa).getTurmas());
		
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

}