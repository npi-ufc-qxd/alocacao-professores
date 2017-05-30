package ufc.quixada.npi.ap.controller;

import java.util.Arrays;
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
import org.springframework.web.servlet.ModelAndView;

import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.model.Periodo.Status;
import ufc.quixada.npi.ap.service.PeriodoService;
import ufc.quixada.npi.ap.util.Constants;
import ufc.quixada.npi.ap.validation.PeriodoValidator;

@Controller
@RequestMapping(path="/periodo")
public class PeriodoController {
	
	@Autowired
	PeriodoService periodoService;
	
	@Autowired
	PeriodoValidator periodoValidator;
	
	
	@RequestMapping(path="/")
	public ModelAndView listar(){
		ModelAndView mv = new ModelAndView(Constants.PERIODO_LISTAR);
		List<Periodo> periodos = periodoService.listaPeriodos();
		mv.addObject("periodos", periodos);
		return mv;
	}
	
	@RequestMapping(path="/cadastrar", method=RequestMethod.GET)
	public ModelAndView cadastrar(Periodo periodo){
		ModelAndView mv = new ModelAndView(Constants.PERIODO_CADASTRAR);
		mv.addObject("periodo", periodo);
		
		return mv;
	}
	
	@ModelAttribute("status")
	public List<Periodo.Status> todosStatus(){
		return Arrays.asList(Periodo.Status.values());
	}
	
	@RequestMapping( path="/cadastrar", method=RequestMethod.POST)
	public ModelAndView adicionarPeriodo(@ModelAttribute("periodo") @Valid Periodo periodo, BindingResult result, ModelAndView model){
		
		periodoValidator.validate(periodo, result);
		
		if (result.hasErrors()){
			model.setViewName(Constants.PERIODO_CADASTRAR);
			
			return model;
		}
		
		model.setViewName(Constants.PERIODO_REDIRECT_LISTAR_PERIODO);
		
		periodo.setStatus(Status.ABERTA);
		periodoService.salvar(periodo);
		
		return model;
	}
	
	
	
	@RequestMapping(path="/{id}/detalhar")
	public ModelAndView detalhar(@PathVariable ("id") Integer id){
		ModelAndView mv = new ModelAndView(Constants.PERIODO_DETALHAR);
		return mv;
	}
	
	@RequestMapping(path="/{id}/excluir")
	public ModelAndView excluir(@PathVariable ("id") Integer id){
		ModelAndView mv = new ModelAndView(Constants.PERIODO_REDIRECT_LISTAR_PERIODO);
		List<Periodo> periodos = periodoService.listaPeriodos();
		for (Periodo periodo : periodos) {
			if(periodo.getId()==id)
				periodoService.excluir(periodo);
		}
		return mv;
	}

	@RequestMapping(path="/{id}/editar", method=RequestMethod.GET)
	public ModelAndView editar(@PathVariable ("id") Integer id){
		ModelAndView mv = new ModelAndView(Constants.PERIODO_EDITAR);
		mv.addObject("periodo", periodoService.getPeriodo(id));
		return mv;
	}
	
	@RequestMapping(path="/{id}/editar", method=RequestMethod.POST)
	public ModelAndView editarPeriodo(@PathVariable ("id") Integer id, @RequestParam("status") Status status ){
		ModelAndView mv = new ModelAndView(Constants.PERIODO_REDIRECT_LISTAR_PERIODO);
		
		Periodo periodo = periodoService.getPeriodo(id);
		periodo.setStatus(status);
		
		periodoService.salvar(periodo);		
		
		return mv;
	}

}
