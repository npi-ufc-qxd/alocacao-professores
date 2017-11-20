package ufc.quixada.npi.ap.controller;

import static ufc.quixada.npi.ap.util.Constants.COMPARTILHAMENTO_LISTAR;
import static ufc.quixada.npi.ap.util.Constants.OFERTA_CADASTRADA;
import static ufc.quixada.npi.ap.util.Constants.STATUS_ERROR;
import static ufc.quixada.npi.ap.util.Constants.STATUS_SUCCESS;
import static ufc.quixada.npi.ap.util.Constants.EXPORTAR;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.quixada.npi.ldap.model.Usuario;
import br.ufc.quixada.npi.ldap.service.UsuarioService;
import ufc.quixada.npi.ap.exception.AlocacaoProfessoresException;
import ufc.quixada.npi.ap.model.Compartilhamento;
import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Empilhamento;
import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.model.Pessoa;
import ufc.quixada.npi.ap.model.Professor;
import ufc.quixada.npi.ap.service.CompartilhamentoService;
import ufc.quixada.npi.ap.service.CursoService;
import ufc.quixada.npi.ap.service.DisciplinaService;
import ufc.quixada.npi.ap.service.EmpilhamentoService;
import ufc.quixada.npi.ap.service.OfertaService;
import ufc.quixada.npi.ap.service.PeriodoService;
import ufc.quixada.npi.ap.service.PessoaService;
import ufc.quixada.npi.ap.service.ProfessorService;
import ufc.quixada.npi.ap.util.Constants;
import ufc.quixada.npi.ap.validation.CompartilhamentoValidator;
import ufc.quixada.npi.ap.validation.OfertaValidator;

@Controller
public class DirecaoController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private CompartilhamentoService compartilhamentoService;

	@Autowired
	private PeriodoService periodoService;
	
	@Autowired
	private OfertaService ofertaService;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@Autowired
	private CompartilhamentoValidator compartilhamentoValidator;

	@Autowired
	private CursoService cursoService;

	@Autowired
	private OfertaValidator ofertaValidator;

	@Autowired
	private EmpilhamentoService empilhamentoService;
	
	@ModelAttribute("cursos")
	public List<Curso> todosCursos() {
		return cursoService.listar();
	}

	@ModelAttribute("professores")
	public List<Professor> todosProfessores() {
		return professorService.findAllProfessores();
	}
	
@RequestMapping(path = {"/oferta-campus"}, method = RequestMethod.GET)
public String listarCompartilhamentos(Model model){
	model.addAttribute("periodo", periodoService.periodoAtivo());
	model.addAttribute("ofertas", compartilhamentoService.listarCompartilhamentoOfertas());
	return COMPARTILHAMENTO_LISTAR;
}

	@RequestMapping(path = { "/exportacao" }, method = RequestMethod.GET)
	public String exportar(Model model) {
		Periodo periodoAtivo = periodoService.periodoAtivo();
		
		List<Empilhamento> empilhamentos =  empilhamentoService.listarEmpilhamentos();
		
		model.addAttribute("empilhamentos", empilhamentos);
		model.addAttribute("ofertas", ofertaService.buscarPorPeriodo(periodoAtivo));

		return EXPORTAR;
	}

	@RequestMapping(value = "/professores", method = RequestMethod.GET)
	public ModelAndView listarProfessores() {
		ModelAndView modelAndView = new ModelAndView(Constants.PROFESSOR_LISTAR);
		List<Professor> professores = professorService.findAllProfessores();
		modelAndView.addObject("professores", professores);
		return modelAndView;
	}
	
	@RequestMapping(value = "/atualizar-professores", method = RequestMethod.GET)
	public ModelAndView atualizarProfessores(){
		ModelAndView modelAndView = new ModelAndView(Constants.PROFESSOR_REDIRECT_LISTAR);
		
		List<Usuario> usuarios = usuarioService.getByAffiliation(Constants.AFFILIATION_DOCENTE);
		
		for (Usuario usuario : usuarios){
			Professor professor = pessoaService.findProfessor(usuario.getCpf());
			
			if (professor == null){
				Pessoa pessoa = new Pessoa();
				
				pessoa.setCpf(usuario.getCpf());
				pessoa.setEmail(usuario.getEmail());
				pessoa.setNome(usuario.getNome());
				
				pessoa = pessoaService.salvar(pessoa);
				
				professor = new Professor();
				professor.setPessoa(pessoa);
				professor.setApelido(usuario.getNome());
				
				professorService.salvar(professor);
			}
			
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/editar-oferta/{id}", method = RequestMethod.GET)
	public ModelAndView editarOferta(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_EDITAR_DIRECAO);

		Oferta oferta = ofertaService.findOferta(id);
		modelAndView.addObject("cursoAtual", oferta.getTurma().getCurso());

		modelAndView.addObject("oferta", oferta);
		modelAndView.addObject("disciplinas", disciplinaService.listarNaoArquivada());

		return modelAndView;
	}

	@RequestMapping(value = "/editar-oferta/{id}", method = RequestMethod.POST)
	public ModelAndView editarOferta(@PathVariable("id") Integer id, @ModelAttribute("oferta") Oferta oferta, 
									BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		
		for(Compartilhamento compartilhamento : oferta.getCompartilhamentos()) {
			compartilhamentoValidator.validate(compartilhamento, bindingResult);
		}
		if (bindingResult.hasErrors()) {
			oferta = ofertaService.findOferta(id);
			modelAndView.addObject("cursoAtual", oferta.getTurma().getCurso());
			modelAndView.addObject("oferta", oferta);
			modelAndView.addObject("disciplinas", disciplinaService.listarNaoArquivada());
			modelAndView.setViewName("redirect:/editar-oferta/"+oferta.getId());
			return modelAndView;
		}
		
		Oferta ofertaSalva = ofertaService.findOferta(id);
		ofertaSalva.setCompartilhamentos(oferta.getCompartilhamentos());
		try {
			ofertaService.salvar(ofertaSalva);
		} catch (AlocacaoProfessoresException e) {
			e.printStackTrace();
		}

		modelAndView.setViewName("redirect:/editar-oferta/"+oferta.getId());

		return modelAndView;
	}
	
	@RequestMapping(value = "/direcao/ofertas/cadastrar", method = RequestMethod.GET)
	public ModelAndView cadastrarOferta(@ModelAttribute("oferta") Oferta oferta, Authentication auth) {
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_CADASTRAR);
		modelAndView.addObject("disciplinas", disciplinaService.listarNaoArquivada());		
		modelAndView.addObject("periodoAtivo", periodoService.periodoAtivo());

		return modelAndView;
	}

	@RequestMapping(value = "/direcao/ofertas/cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastrarOferta(@ModelAttribute("oferta") @Valid Oferta oferta, BindingResult bindingResult,
			ModelAndView modelAndView, RedirectAttributes redirectAttributes, Authentication auth) {

		ofertaValidator.validate(oferta, bindingResult);

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName(Constants.OFERTA_CADASTRAR);
			modelAndView.addObject("disciplinas", disciplinaService.listarNaoArquivada());
			modelAndView.addObject("periodoAtivo", periodoService.periodoAtivo());

			return modelAndView;
		}

		try {
			ofertaService.salvar(oferta);
			modelAndView.setViewName(Constants.OFERTA_REDIRECT_LISTAR);
			redirectAttributes.addFlashAttribute(STATUS_SUCCESS, OFERTA_CADASTRADA);
		} catch (AlocacaoProfessoresException e) {
			modelAndView.setViewName(Constants.OFERTA_REDIRECT_LISTAR);
			redirectAttributes.addFlashAttribute(STATUS_ERROR, e.getMessage());
			redirectAttributes.addFlashAttribute("oferta", oferta);
		}

		return modelAndView;
	}

	@RequestMapping(value = "/direcao/ofertas/{id}/editar", method = RequestMethod.GET)
	public ModelAndView editarOferta(@PathVariable("id") Integer id, Authentication auth) {
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_EDITAR);

		Pessoa pessoa = (Pessoa) auth.getPrincipal();
		modelAndView.addObject("cursoAtual", cursoService.buscarPorCoordenador(pessoa));

		modelAndView.addObject("oferta", ofertaService.findOferta(id));
		modelAndView.addObject("disciplinas", disciplinaService.listarNaoArquivada());

		return modelAndView;
	}

	@RequestMapping(value = "/direcao/ofertas/{id}/editar", method = RequestMethod.POST)
	public ModelAndView editarOferta(@PathVariable(name = "id", required = true) Integer id,
			@ModelAttribute("oferta") @Valid Oferta oferta, BindingResult bindingResult, ModelAndView modelAndView, Authentication auth) {

		ofertaValidator.validate(oferta, bindingResult);

		if (bindingResult.hasErrors()) {
			Pessoa pessoa = (Pessoa) auth.getPrincipal();
			modelAndView.addObject("cursoAtual", cursoService.buscarPorCoordenador(pessoa));
			modelAndView.setViewName(Constants.OFERTA_EDITAR);
			modelAndView.addObject("disciplinas", disciplinaService.listarNaoArquivada());

			return modelAndView;
		}

		try {
			ofertaService.salvar(oferta);
		} catch (AlocacaoProfessoresException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		modelAndView.setViewName(Constants.OFERTA_REDIRECT_LISTAR);

		return modelAndView;
	}
	
}
