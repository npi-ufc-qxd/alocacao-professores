package ufc.quixada.npi.ap.controller;

import static ufc.quixada.npi.ap.util.Constants.FORMULARIO_CADASTRAR_DISCIPLINA;
import static ufc.quixada.npi.ap.util.Constants.FORMULARIO_EDITAR_DISCIPLINA;
import static ufc.quixada.npi.ap.util.Constants.LISTAR_DISCIPLINAS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ufc.quixada.npi.ap.model.Disciplina;
import ufc.quixada.npi.ap.service.DisciplinaService;


@Controller
@RequestMapping("disciplinas")
public class DisciplinaController {
	
	@Autowired
	public DisciplinaService disciplinaService;
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public ModelAndView cadastrarDisciplina(Disciplina disciplina){
		ModelAndView model = new ModelAndView(FORMULARIO_CADASTRAR_DISCIPLINA);
		model.addObject("disciplina",disciplina);
		
		//disciplinaService.salvar(disciplina);
		return model;
	}
	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ModelAndView adicionarDisciplina(Disciplina disciplina) {
		ModelAndView modelAndView = new ModelAndView(LISTAR_DISCIPLINAS);
		
		
		
		disciplinaService.salvar(disciplina);
		return modelAndView;
	}
	
	@RequestMapping(value="/editar", method = RequestMethod.GET)
	public ModelAndView editarDisciplina(){
		ModelAndView model = new ModelAndView(FORMULARIO_EDITAR_DISCIPLINA);
		
		return model;
	}
	
	@RequestMapping(value="", method = RequestMethod.GET)
	public ModelAndView listarDisciplina(){
		ModelAndView model = new ModelAndView(LISTAR_DISCIPLINAS);
		
		return model;
	}
	
}
