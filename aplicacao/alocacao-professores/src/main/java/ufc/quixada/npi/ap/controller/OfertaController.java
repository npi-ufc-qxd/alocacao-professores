package ufc.quixada.npi.ap.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Professor;
import ufc.quixada.npi.ap.model.Turma;
import ufc.quixada.npi.ap.service.DisciplinaService;
import ufc.quixada.npi.ap.service.OfertaService;
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
	
	@ModelAttribute("turmas")
	public List<Turma> todasTurmas(){
		return turmaService.listarTurmas();
	}
	
	@ModelAttribute("professores")
	public List<Professor> todosProfessores(){
		return professorService.findAllProfessores();
	}

	
	@RequestMapping(value = {"", "/"})
	public ModelAndView listarOfertas(){
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_LISTAR);
		
		return modelAndView;
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public ModelAndView cadastrarOferta(@ModelAttribute("oferta") Oferta oferta){
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_CADASTRAR);
		
		modelAndView.addObject("disciplinas", disciplinaService.listarNaoArquivada());
		
		return modelAndView;
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastrarOferta(
			@ModelAttribute("oferta") @Valid Oferta oferta,
				BindingResult bindingResult, ModelAndView modelAndView){
		
		ofertaValidator.validate(oferta, bindingResult);
		
		if (bindingResult.hasErrors()){
			modelAndView.setViewName(Constants.OFERTA_CADASTRAR);
			modelAndView.addObject("disciplinas", disciplinaService.listarNaoArquivada());
			
			return modelAndView;
		}
		
		ofertaService.salvar(oferta);
		
		modelAndView.setViewName(Constants.OFERTA_REDIRECT_LISTAR);
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/{id}/editar", method = RequestMethod.GET)
	public ModelAndView editarOferta(@PathVariable("id") Integer id){
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_EDITAR);

		return modelAndView;
	}

	@RequestMapping(path = {"/{id}/detalhar"}, method = RequestMethod.GET)
	public ModelAndView detalharOferta(@PathVariable("id") Integer id, @RequestParam(required=false) String erro){
		
		Oferta oferta=  ofertaService.visualizarOferta(id);
		
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_DETALHAR);
		modelAndView.addObject("oferta", oferta);
		modelAndView.addObject("professores",oferta.getProfessores());
		modelAndView.addObject("erro", erro);
		return modelAndView;
	}

	@RequestMapping(value= "/{id}/excluir")
	public void excluirOferta(){
		
	}
	
	@RequestMapping(value = "/{id}/editar", method = RequestMethod.POST)
	public ModelAndView editarOferta(
			@PathVariable(name = "id", required = true) Integer id,
				@ModelAttribute("oferta") @Valid Oferta oferta, 
					BindingResult bindingResult, ModelAndView modelAndView){
		
		modelAndView.setViewName(Constants.OFERTA_EDITAR);

		return modelAndView;
	}

	@RequestMapping(value= "/{id}/excluir", method = RequestMethod.GET)
	public @ResponseBody boolean excluirOferta(@PathVariable(name = "id", required = true) Integer id){
		return false;
	}
	
}
