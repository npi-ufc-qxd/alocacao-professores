package ufc.quixada.npi.ap.controller;

import static ufc.quixada.npi.ap.util.Constants.CADASTRAR_DISCIPLINA;
import static ufc.quixada.npi.ap.util.Constants.DISCIPLINA_LISTAR;
import static ufc.quixada.npi.ap.util.Constants.DISCIPLINA_EDITAR;

import static ufc.quixada.npi.ap.util.Constants.REDIRECT_LISTAR_DISCIPLINA;


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

import ufc.quixada.npi.ap.model.Disciplina;
import ufc.quixada.npi.ap.service.DisciplinaService;
import ufc.quixada.npi.ap.validation.DisciplinaValidator;

@Controller
@RequestMapping("disciplinas")
public class DisciplinaController {

	@Autowired
	private DisciplinaValidator disciplinaValidator;

	@Autowired
	public DisciplinaService disciplinaService;

	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public ModelAndView listarDisciplina() {
		
		ModelAndView model = new ModelAndView(DISCIPLINA_LISTAR);
		
		model.addObject("disciplinas", disciplinaService.listarNaoArquivada());
		
		return model;
		
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public ModelAndView cadastrarDisciplina(Disciplina disciplina) {
		ModelAndView model = new ModelAndView(CADASTRAR_DISCIPLINA);
		model.addObject("disciplina", disciplina);
		return model;
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)

	public ModelAndView adicionarDisciplina(@ModelAttribute("disciplina") @Valid Disciplina disciplina,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView(REDIRECT_LISTAR_DISCIPLINA);
		disciplinaValidator.validate(disciplina, result);

		if (result.hasErrors()) {
			modelAndView = new ModelAndView(CADASTRAR_DISCIPLINA);
		} else {
			disciplinaService.salvar(disciplina);
		}

		return modelAndView;
	}

	@RequestMapping(value = "/{idDisciplina}/editar/", method = RequestMethod.GET)
	public ModelAndView editarDisciplina(@PathVariable("idDisciplina") Disciplina disciplina) {
		ModelAndView modelAndView = new ModelAndView(DISCIPLINA_EDITAR);
		modelAndView.addObject("disciplina", disciplina);
		
		return modelAndView;
	}

	@RequestMapping(value = "/editar", method = RequestMethod.POST)

	public ModelAndView editarDisciplina(@ModelAttribute("disciplina") @Valid Disciplina disciplina,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView(REDIRECT_LISTAR_DISCIPLINA);
		disciplinaValidator.validate(disciplina, result);

		if (result.hasErrors()) {
			modelAndView = new ModelAndView(DISCIPLINA_EDITAR);
		} else {
			disciplinaService.salvar(disciplina);
		}

		return modelAndView;
	}
	
	
	@RequestMapping(value="/{id}/arquivar", method = RequestMethod.GET)
	public @ResponseBody boolean arquivarDisciplina(@PathVariable("id") Integer id){
		
		return disciplinaService.arquivarDisciplina(id);

	}
}
