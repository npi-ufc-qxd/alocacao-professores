package ufc.quixada.npi.ap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import static ufc.quixada.npi.ap.util.Constants.*;


@Controller
@RequestMapping("disciplinas")
public class DisciplinaController {
	
	
	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public ModelAndView cadastrarDisciplina(){
		ModelAndView model = new ModelAndView(FORMULARIO_CADASTRAR_DISCIPLINA);
		
		return model;
	} 
	
	@RequestMapping(value="/editar", method = RequestMethod.GET)
	public ModelAndView editarDisciplina(){
		ModelAndView model = new ModelAndView(FORMULARIO_EDITAR_DISCIPLINA);
		
		return model;
	}
	
	@RequestMapping(value="/listar", method = RequestMethod.GET)
	public ModelAndView listarDisciplina(){
		ModelAndView model = new ModelAndView(LISTAR_DISCIPLINAS);
		
		return model;
	}
	
}
