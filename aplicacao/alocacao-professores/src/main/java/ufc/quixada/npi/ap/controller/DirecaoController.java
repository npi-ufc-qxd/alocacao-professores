package ufc.quixada.npi.ap.controller;

import static ufc.quixada.npi.ap.util.Constants.COMPARTILHAMENTO_LISTAR;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.quixada.npi.ldap.model.Usuario;
import br.ufc.quixada.npi.ldap.service.UsuarioService;
import ufc.quixada.npi.ap.exception.AlocacaoProfessoresException;
import ufc.quixada.npi.ap.model.Compartilhamento;
import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Pessoa;
import ufc.quixada.npi.ap.model.Professor;
import ufc.quixada.npi.ap.service.CompartilhamentoService;
import ufc.quixada.npi.ap.service.DisciplinaService;
import ufc.quixada.npi.ap.service.OfertaService;
import ufc.quixada.npi.ap.service.PeriodoService;
import ufc.quixada.npi.ap.service.PessoaService;
import ufc.quixada.npi.ap.service.ProfessorService;
import ufc.quixada.npi.ap.util.Constants;
import ufc.quixada.npi.ap.util.RestricaoDePeriodo;
import ufc.quixada.npi.ap.validation.CompartilhamentoValidator;

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
	
	@RequestMapping(path = {"/oferta-campus"}, method = RequestMethod.GET)
	public String listarCompartilhamentos(Model model){
		model.addAttribute("periodo", periodoService.periodoAtivo());
		model.addAttribute("ofertas", compartilhamentoService.listarCompartilhamentoOfertas());
		return COMPARTILHAMENTO_LISTAR;
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
	@RestricaoDePeriodo(Constants.OFERTA_CAMPUS_REDIRECT_LISTAR)
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
}
