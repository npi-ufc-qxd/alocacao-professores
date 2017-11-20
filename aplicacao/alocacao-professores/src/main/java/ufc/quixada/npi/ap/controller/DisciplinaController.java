package ufc.quixada.npi.ap.controller;

import static ufc.quixada.npi.ap.util.Constants.MSG_DISCIPLINA_CADASTRADA;
import static ufc.quixada.npi.ap.util.Constants.MSG_DISCIPLINA_EDITADA;
import static ufc.quixada.npi.ap.util.Constants.MSG_DISCIPLINA_CADASTRAR_TITULO_SUCCESS;
import static ufc.quixada.npi.ap.util.Constants.MSG_DISCIPLINA_CADASTRAR_EXISTENTE;
import static ufc.quixada.npi.ap.util.Constants.MSG_DISCIPLINA_CADASTRAR_TITULO_ERROR;
import static ufc.quixada.npi.ap.util.Constants.MSG_DISCIPLINA_EDITAR_TITULO_SUCCESS;
import static ufc.quixada.npi.ap.util.Constants.SWAL_STATUS_ERROR;
import static ufc.quixada.npi.ap.util.Constants.SWAL_STATUS_SUCCESS;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ufc.quixada.npi.ap.exception.AlocacaoProfessorException;
import ufc.quixada.npi.ap.model.Disciplina;
import ufc.quixada.npi.ap.service.DisciplinaService;
import ufc.quixada.npi.ap.util.Constants;
import ufc.quixada.npi.ap.validation.DisciplinaValidator;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {

	@Autowired
	public DisciplinaService disciplinaService;
	
	@Autowired
	private DisciplinaValidator disciplinaValidator;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public ModelAndView listarDisciplinas() {
		ModelAndView modelAndView = new ModelAndView(Constants.DISCIPLINA_LISTAR);
		
		modelAndView.addObject("disciplinas", disciplinaService.buscarDisciplinasNaoArquivadas());
		
		return modelAndView;
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public ModelAndView cadastrarDisciplina(@ModelAttribute("disciplina") Disciplina disciplina) {
		ModelAndView modelAndView = new ModelAndView(Constants.DISCIPLINA_CADASTRAR);
		
		return modelAndView;
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastrarDisciplina(@ModelAttribute("disciplina") @Valid Disciplina disciplina, BindingResult result, RedirectAttributes redirectAttributes, ModelAndView modelAndView) {
		
		disciplinaValidator.validate(disciplina, result);
		
		if (result.hasErrors()) {
			modelAndView.setViewName(Constants.DISCIPLINA_CADASTRAR);
			
			return modelAndView;
		} 
		
		try {
			disciplinaService.salvar(disciplina);
		} catch (AlocacaoProfessorException e) {
			modelAndView.setViewName(Constants.DISCIPLINA_REDIRECT_CADASTRAR);
			
			if(e.getMessage().equals(MSG_DISCIPLINA_CADASTRAR_EXISTENTE)) {
				redirectAttributes.addFlashAttribute("disciplina", disciplina);
				redirectAttributes.addFlashAttribute("status", SWAL_STATUS_ERROR);
				redirectAttributes.addFlashAttribute("titulo", MSG_DISCIPLINA_CADASTRAR_TITULO_ERROR);
				redirectAttributes.addFlashAttribute("mensagem", MSG_DISCIPLINA_CADASTRAR_EXISTENTE);
			}
			
			
			return modelAndView;
		}
		
		modelAndView.setViewName(Constants.DISCIPLINA_REDIRECT_LISTAR);
		
		redirectAttributes.addFlashAttribute("status", SWAL_STATUS_SUCCESS);
		redirectAttributes.addFlashAttribute("titulo", MSG_DISCIPLINA_CADASTRAR_TITULO_SUCCESS);
		redirectAttributes.addFlashAttribute("mensagem", MSG_DISCIPLINA_CADASTRADA);
		
		return modelAndView;
	}

	@RequestMapping(value = "/{id}/editar", method = RequestMethod.GET)
	public ModelAndView editarDisciplina(@PathVariable("id") Integer idDisciplina) {
		ModelAndView modelAndView = new ModelAndView(Constants.DISCIPLINA_EDITAR);
		
		Disciplina disciplina = disciplinaService.buscarDisciplina(idDisciplina);
		
		if (disciplina == null){
			modelAndView.setViewName(Constants.DISCIPLINA_REDIRECT_LISTAR);

			return modelAndView;
		}
		
		modelAndView.addObject("disciplina", disciplina);
		
		return modelAndView;
	}

	@RequestMapping(value = "/{id}/editar", method = RequestMethod.POST)
	public ModelAndView editarDisciplina(@ModelAttribute("disciplina") @Valid Disciplina disciplina,
			BindingResult result, RedirectAttributes redirect, ModelAndView modelAndView) throws Exception {
		
		disciplinaValidator.validate(disciplina, result);
		
		if (result.hasErrors()) {
			modelAndView.setViewName(Constants.DISCIPLINA_EDITAR);
			
			modelAndView.addObject("disciplina", disciplina);
			
			return modelAndView;
		}
		
		disciplinaService.editar(disciplina);
		
		modelAndView.setViewName(Constants.DISCIPLINA_REDIRECT_LISTAR);
		
		redirect.addFlashAttribute("status", SWAL_STATUS_SUCCESS);
		redirect.addFlashAttribute("titulo", MSG_DISCIPLINA_EDITAR_TITULO_SUCCESS);
		redirect.addFlashAttribute("mensagem", MSG_DISCIPLINA_EDITADA);
		
		return modelAndView;
	}

	@RequestMapping(value = "/{id}/arquivar", method = RequestMethod.GET)
	public @ResponseBody boolean arquivarDisciplina(@PathVariable("id") Integer id) {
		return disciplinaService.arquivarDisciplina(id);
	}
}
