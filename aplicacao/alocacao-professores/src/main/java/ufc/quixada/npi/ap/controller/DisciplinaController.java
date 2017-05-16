package ufc.quixada.npi.ap.controller;

import static ufc.quixada.npi.ap.util.Constants.CADASTRAR_DISCIPLINA;
import static ufc.quixada.npi.ap.util.Constants.DISCIPLINA_EDITAR;
import static ufc.quixada.npi.ap.util.Constants.DISCIPLINA_LISTAR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ufc.quixada.npi.ap.service.DisciplinaService;


@Controller
@RequestMapping("disciplinas")
public class DisciplinaController {
	
	@Autowired
	public DisciplinaService disciplinaService;
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public ModelAndView cadastrarDisciplina(){
		ModelAndView model = new ModelAndView(CADASTRAR_DISCIPLINA);
		
		return model;
	} 
	
	@RequestMapping(value="/editar", method = RequestMethod.GET)
	public ModelAndView editarDisciplina(){
		ModelAndView model = new ModelAndView(DISCIPLINA_EDITAR);
		
		return model;
	}
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public ModelAndView listarDisciplina(){
		ModelAndView model = new ModelAndView(DISCIPLINA_LISTAR);
		
		model.addObject("disciplinas", disciplinaService.listarNaoArquivada());
		
		
		return model;
	}
	
	
	
}
