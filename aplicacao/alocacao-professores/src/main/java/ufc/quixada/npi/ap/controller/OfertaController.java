package ufc.quixada.npi.ap.controller;

import static ufc.quixada.npi.ap.util.Constants.OFERTA_CADASTRADA;
import static ufc.quixada.npi.ap.util.Constants.STATUS_ERROR;
import static ufc.quixada.npi.ap.util.Constants.STATUS_SUCCESS;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ufc.quixada.npi.ap.exception.AlocacaoProfessoresException;
import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.model.Pessoa;
import ufc.quixada.npi.ap.model.Professor;
import ufc.quixada.npi.ap.model.Turma;
import ufc.quixada.npi.ap.service.DisciplinaService;
import ufc.quixada.npi.ap.service.OfertaService;
import ufc.quixada.npi.ap.service.PeriodoService;
import ufc.quixada.npi.ap.service.ProfessorService;
import ufc.quixada.npi.ap.service.TurmaService;
import ufc.quixada.npi.ap.util.Constants;
import ufc.quixada.npi.ap.validation.OfertaValidator;

@Controller
@RequestMapping(path = "/ofertas")
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

	@ModelAttribute("turmas")
	public List<Turma> todasTurmas() {
		return turmaService.listarTurmas();
	}

	@ModelAttribute("professores")
	public List<Professor> todosProfessores() {
		return professorService.findAllProfessores();
	}

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ModelAndView listarOfertas() {
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_LISTAR);
		modelAndView.addObject("periodos", periodoService.periodosConsolidados());
		return modelAndView;
	}
	
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public @ResponseBody List<Oferta> listarOfertas(Authentication auth) {
		Pessoa pessoa = (Pessoa) auth.getPrincipal();
		List<Oferta> ofertas = ofertaService.buscarPorPeriodoAndCurso(periodoService.periodoAtivo(), pessoa);
		return ofertas;
	}	

	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public ModelAndView cadastrarOferta(@ModelAttribute("oferta") Oferta oferta) {
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_CADASTRAR);
		modelAndView.addObject("disciplinas", disciplinaService.listarNaoArquivada());
		return modelAndView;
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastrarOferta(@ModelAttribute("oferta") @Valid Oferta oferta, BindingResult bindingResult,
			ModelAndView modelAndView, RedirectAttributes redirectAttributes) {

		ofertaValidator.validate(oferta, bindingResult);

		if (bindingResult.hasErrors()) {
			modelAndView.setViewName(Constants.OFERTA_CADASTRAR);
			modelAndView.addObject("disciplinas", disciplinaService.listarNaoArquivada());
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

	@RequestMapping(value = "/{id}/editar", method = RequestMethod.GET)
	public ModelAndView editarOferta(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_EDITAR);

		modelAndView.addObject("oferta", ofertaService.findOferta(id));
		modelAndView.addObject("disciplinas", disciplinaService.listarNaoArquivada());

		return modelAndView;
	}

	@RequestMapping(value = "/{id}/editar", method = RequestMethod.POST)
	public ModelAndView editarOferta(@PathVariable(name = "id", required = true) Integer id,
			@ModelAttribute("oferta") @Valid Oferta oferta, BindingResult bindingResult, ModelAndView modelAndView) {

		ofertaValidator.validate(oferta, bindingResult);

		if (bindingResult.hasErrors()) {
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

	@RequestMapping(path = { "/{id}/detalhar" }, method = RequestMethod.GET)
	public ModelAndView detalharOferta(@PathVariable("id") Integer id, @RequestParam(required = false) String erro) {

		Oferta oferta = ofertaService.visualizarOferta(id);

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
	public @ResponseBody List<Oferta> buscarOfertas(@PathVariable("periodo") Periodo periodo, Authentication auth) {
		Pessoa logada = (Pessoa) auth.getPrincipal();
		List<Oferta> ofertas = ofertaService.buscarPorPeriodoAndCurso(periodo, logada);
		return ofertas;
	}

	@RequestMapping(value = "/importar", method = RequestMethod.GET)
	public @ResponseBody Map<String, Object> importarOfertas(@RequestParam("ofertas") List<Integer> ofertas) {
		return ofertaService.importarOfertas(ofertas);
	}

	@RequestMapping(value = "/substituicao-ofertas", method = RequestMethod.GET)
	public @ResponseBody boolean substituirOfertas(@RequestParam("ofertas") List<Integer> ofertas) {
		ofertaService.substituirOferta(ofertas);
		return true;
	}

}