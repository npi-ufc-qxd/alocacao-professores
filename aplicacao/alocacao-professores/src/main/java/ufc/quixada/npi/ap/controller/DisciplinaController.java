package ufc.quixada.npi.ap.controller;

import static ufc.quixada.npi.ap.util.Constants.DISCIPLINA_CADASTAR_TITULO_SUCCESS;
import static ufc.quixada.npi.ap.util.Constants.DISCIPLINA_CADASTRADA;
import static ufc.quixada.npi.ap.util.Constants.DISCIPLINA_CADASTRAR;
import static ufc.quixada.npi.ap.util.Constants.DISCIPLINA_CADASTRAR_EXISTENTE;
import static ufc.quixada.npi.ap.util.Constants.DISCIPLINA_CADASTRAR_TITULO_ERROR;
import static ufc.quixada.npi.ap.util.Constants.DISCIPLINA_EDITAR;
import static ufc.quixada.npi.ap.util.Constants.DISCIPLINA_LISTAR;
import static ufc.quixada.npi.ap.util.Constants.DISCIPLINA_REDIRECT_LISTAR;
import static ufc.quixada.npi.ap.util.Constants.STATUS_ERROR;
import static ufc.quixada.npi.ap.util.Constants.STATUS_SUCCESS;
import static ufc.quixada.npi.ap.util.Constants.DISCIPLINA_REDIRECT_CADASTRAR;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ufc.quixada.npi.ap.model.Disciplina;
import ufc.quixada.npi.ap.service.DisciplinaService;
import ufc.quixada.npi.ap.validation.DisciplinaValidator;

@Controller
@RequestMapping("/disciplinas")
public class DisciplinaController {

	@Autowired
	private DisciplinaValidator disciplinaValidator;

	@Autowired
	public DisciplinaService disciplinaService;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String listarDisciplinas(Model model) {
		model.addAttribute("disciplinas", disciplinaService.listarNaoArquivada());
		return DISCIPLINA_LISTAR;
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public String cadastrarDisciplina(Disciplina disciplina, Model model) {
		model.addAttribute("disciplina", disciplina);
		return DISCIPLINA_CADASTRAR;
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public String cadastrarDisciplina(@ModelAttribute("disciplina") @Valid Disciplina disciplina, BindingResult result, RedirectAttributes redirect) {
		disciplinaValidator.validate(disciplina, result);
		
		if (result.hasErrors()) {
			return DISCIPLINA_CADASTRAR;
		} 
		
		try {
			disciplinaService.salvar(disciplina);
			redirect.addFlashAttribute("status", STATUS_SUCCESS);
			redirect.addFlashAttribute("titulo", DISCIPLINA_CADASTAR_TITULO_SUCCESS);
			redirect.addFlashAttribute("mensagem", DISCIPLINA_CADASTRADA);
		} catch (Exception e) {
			if(e.getMessage().equals(DISCIPLINA_CADASTRAR_EXISTENTE)) {
				redirect.addFlashAttribute("disciplina", disciplina);
				redirect.addFlashAttribute("status", STATUS_ERROR);
				redirect.addFlashAttribute("titulo", DISCIPLINA_CADASTRAR_TITULO_ERROR);
				redirect.addFlashAttribute("mensagem", DISCIPLINA_CADASTRAR_EXISTENTE);
			}
			
			return DISCIPLINA_REDIRECT_CADASTRAR;
			
			
		}
		
		return DISCIPLINA_REDIRECT_LISTAR;
	}

	@RequestMapping(value = "/{idDisciplina}/editar", method = RequestMethod.GET)
	public String editarDisciplina(@PathVariable("idDisciplina") Disciplina disciplina, Model model) {
		model.addAttribute("disciplina", disciplina);
		return DISCIPLINA_EDITAR;
	}

	@RequestMapping(value = "/editar", method = RequestMethod.POST)
	public String editarDisciplina(@ModelAttribute("disciplina") @Valid Disciplina disciplina,
			BindingResult result) throws Exception {
		disciplinaValidator.validate(disciplina, result);
		if (result.hasErrors()) {
			return DISCIPLINA_EDITAR;
		} else {
			disciplinaService.salvar(disciplina);
		}
		return DISCIPLINA_REDIRECT_LISTAR;
	}

	@RequestMapping(value = "/{id}/arquivar", method = RequestMethod.GET)
	public @ResponseBody boolean arquivarDisciplina(@PathVariable("id") Integer id) {
		return disciplinaService.arquivarDisciplina(id);
	}

}
