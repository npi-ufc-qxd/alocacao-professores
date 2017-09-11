package ufc.quixada.npi.ap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ufc.quixada.npi.ap.model.Professor;
import ufc.quixada.npi.ap.service.ProfessorService;

import static ufc.quixada.npi.ap.util.Constants.PROFESSOR_LISTAR;

import java.util.List;

@Controller
public class DirecaoController {

	@Autowired
	private ProfessorService professorService;
	
	@RequestMapping(value = "/professores", method = RequestMethod.GET)
	public ModelAndView listarProfessores() {
		ModelAndView modelAndView = new ModelAndView(PROFESSOR_LISTAR);
		List<Professor> professores = professorService.findAllProfessores();
		modelAndView.addObject("professores", professores);
		return modelAndView;
	}
}
