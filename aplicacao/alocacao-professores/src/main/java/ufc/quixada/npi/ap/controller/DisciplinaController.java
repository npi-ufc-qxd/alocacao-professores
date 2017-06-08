package ufc.quixada.npi.ap.controller;


import ufc.quixada.npi.ap.util.Constants;


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
	public ModelAndView listarDisciplinas() {
		
		ModelAndView model = new ModelAndView(Constants.DISCIPLINA_LISTAR);
		
		model.addObject("disciplinas", disciplinaService.listarNaoArquivada());
		
		return model;
		
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public ModelAndView cadastrarDisciplina(Disciplina disciplina) {
		ModelAndView model = new ModelAndView(Constants.DISCIPLINA_CADASTRAR_);
		model.addObject("disciplina", disciplina);
		return model;
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)

	public ModelAndView cadastrarDisciplina(@ModelAttribute("disciplina") @Valid Disciplina disciplina,
			BindingResult result) {

		ModelAndView modelAndView = new ModelAndView(Constants.DISCIPLINA_LISTAR);
		disciplinaValidator.validate(disciplina, result);

		if (result.hasErrors()) {
			modelAndView = new ModelAndView(Constants.DISCIPLINA_CADASTRAR_);
		} else {
			disciplinaService.salvar(disciplina);
		}

		return modelAndView;
	}


	@RequestMapping(value = "/{idDisciplina}/editar", method = RequestMethod.GET)
	public ModelAndView editarDisciplina(@PathVariable("idDisciplina") Disciplina disciplina) {
		ModelAndView modelAndView = new ModelAndView(Constants.DISCIPLINA_EDITAR);
		modelAndView.addObject("disciplina", disciplina);
		
		return modelAndView;


	}

	@RequestMapping(value = "/editar", method = RequestMethod.POST)

	public ModelAndView editarDisciplina(@ModelAttribute("disciplina") @Valid Disciplina disciplina,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView(Constants.DISCIPLINA_REDIRECT_LISTAR);
		disciplinaValidator.validate(disciplina, result);

		if (result.hasErrors()) {
			modelAndView = new ModelAndView(Constants.DISCIPLINA_EDITAR);
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
