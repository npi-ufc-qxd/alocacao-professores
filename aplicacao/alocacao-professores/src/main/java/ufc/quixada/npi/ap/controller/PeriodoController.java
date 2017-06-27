package ufc.quixada.npi.ap.controller;

import java.util.Arrays;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.model.Periodo.Status;
import ufc.quixada.npi.ap.service.PeriodoService;
import ufc.quixada.npi.ap.util.Constants;
import ufc.quixada.npi.ap.validation.PeriodoValidator;

@Controller
@RequestMapping(path="/periodos")
public class PeriodoController {
	
	@Autowired
	PeriodoService periodoService;

	@Autowired
	PeriodoValidator periodoValidator;
	
	@RequestMapping(path = {"","/"}, method=RequestMethod.GET)
	public ModelAndView listarPeriodos(){
		ModelAndView modelAndView = new ModelAndView(Constants.PERIODO_LISTAR);
		List<Periodo> periodos = periodoService.listaPeriodos();
		modelAndView.addObject("periodos", periodos);
		
		return modelAndView;
	}
	
	@ModelAttribute("status")
	public List<Periodo.Status> getAllStatus(){
		return Arrays.asList(Periodo.Status.values());
	}
	
	@RequestMapping(path="/cadastrar", method=RequestMethod.GET)
	public ModelAndView cadastrarPeriodo(@ModelAttribute("periodo") Periodo periodo){
		ModelAndView modelAndView = new ModelAndView(Constants.PERIODO_CADASTRAR);
		modelAndView.addObject("periodo", periodo);		
		return modelAndView;
	}
	
	@RequestMapping( path="/cadastrar", method=RequestMethod.POST)
	public ModelAndView cadastrarPeriodo(@ModelAttribute("periodo") @Valid Periodo periodo, BindingResult result, ModelAndView modelAndView){		
		periodoValidator.validate(periodo, result);		
		if (result.hasErrors()){
			modelAndView.setViewName(Constants.PERIODO_CADASTRAR);			
			return modelAndView;
		}		
		modelAndView.setViewName(Constants.PERIODO_REDIRECT_LISTAR);
		periodo.setStatus(Status.ABERTO);
		periodoService.salvar(periodo);		
		return modelAndView;
	}
	
	@RequestMapping(path="/{id}/detalhar")
	public ModelAndView detalhar(@PathVariable ("id") Integer id){
		ModelAndView modelAndView = new ModelAndView(Constants.PERIODO_DETALHAR);
		return modelAndView;
	}
	
	@RequestMapping(path="/{id}/excluir")
	public @ResponseBody boolean excluir(@PathVariable ("id") Integer id){
		try {
			periodoService.excluir(periodoService.getPeriodo(id));
		} catch (EmptyResultDataAccessException ex) {
			return false;
		}
		return true;
	}
	
	@RequestMapping(path="/{id}/editar", method=RequestMethod.GET)
	public ModelAndView editarPeriodo(@PathVariable ("id") Integer id, @ModelAttribute("periodo") Periodo periodo){
		ModelAndView modelAndView = new ModelAndView(Constants.PERIODO_EDITAR);
		modelAndView.addObject("periodo", periodoService.getPeriodo(id));
		return modelAndView;
	}	
	
	@RequestMapping(path="/{id}/editar", method=RequestMethod.POST)
	public ModelAndView editarPeriodo(@ModelAttribute("periodo") @Valid Periodo periodo, BindingResult result){
		ModelAndView modelAndView = new ModelAndView();
		periodoValidator.validate(periodo, result);
		
		System.out.println(result.getErrorCount());
		
		if (result.hasErrors()){
			modelAndView.setViewName(Constants.PERIODO_EDITAR);			
			return modelAndView;
		}		
		
		modelAndView.setViewName(Constants.PERIODO_REDIRECT_LISTAR);
		periodoService.salvar(periodo);		
		
		return modelAndView;
	}
	
	
	@RequestMapping(path="/{id}/detalhar", method=RequestMethod.GET)
	public ModelAndView detalharPeriodo(@PathVariable ("id") Integer id, @ModelAttribute("periodo") Periodo periodo){
		ModelAndView modelAndView = new ModelAndView(Constants.PERIODO_DETALHAR);
		modelAndView.addObject("periodo", periodoService.getPeriodo(id));
		return modelAndView;
	}

}
