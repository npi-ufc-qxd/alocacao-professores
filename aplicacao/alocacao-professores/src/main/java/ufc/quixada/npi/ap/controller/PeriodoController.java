package ufc.quixada.npi.ap.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

@Controller
@RequestMapping(path="/periodos")
public class PeriodoController {
	
	@Autowired
	PeriodoService periodoService;

	@ModelAttribute("status")
	public List<Periodo.Status> todosStatus(){
		return Arrays.asList(Periodo.Status.values());
	}
	
	@RequestMapping(path = {"", "/"})
	public ModelAndView listarPeriodos(){
		ModelAndView modelAndView = new ModelAndView(Constants.PERIODO_LISTAR);
		List<Periodo> periodos = periodoService.listaPeriodos();
		modelAndView.addObject("periodos", periodos);
		
		return modelAndView;
	}
	
	@RequestMapping(path="/cadastrar", method=RequestMethod.GET)
	public ModelAndView cadastrarPeriodo(Periodo periodo){
		ModelAndView modelAndView = new ModelAndView(Constants.PERIODO_CADASTRAR);
		modelAndView.addObject("periodo", periodo);
		
		return modelAndView;
	}
	
	@RequestMapping(path="/cadastrar", method=RequestMethod.POST)
	public ModelAndView adicionarPeriodo(Periodo periodo){
		ModelAndView modelAndView = new ModelAndView(Constants.PERIODO_REDIRECT_LISTAR);
		periodo.setStatus(Status.ABERTA);
		periodoService.salvar(periodo);
		
		return modelAndView;
	}

	@RequestMapping(path="/{id}/detalhar")
	public ModelAndView detalhar(@PathVariable ("id") Integer id){
		ModelAndView modelAndView = new ModelAndView(Constants.PERIODO_DETALHAR);
		return modelAndView;
	}
	
	@RequestMapping(path="/{id}/excluir")
	public ModelAndView excluir(@PathVariable ("id") Integer id){
		ModelAndView modelAndView = new ModelAndView(Constants.PERIODO_REDIRECT_LISTAR);
		periodoService.excluir(periodoService.getPeriodo(id));
		return modelAndView;
	}
	
	@RequestMapping(path="/{id}/editar", method=RequestMethod.GET)
	public ModelAndView editar(@PathVariable ("id") Integer id){
		ModelAndView modelAndView = new ModelAndView(Constants.PERIODO_EDITAR);
		modelAndView.addObject("periodo", periodoService.getPeriodo(id));
		return modelAndView;
	}
	
	@RequestMapping(path="/{id}/editar", method=RequestMethod.POST)
	public ModelAndView editarPeriodo(@PathVariable ("id") Integer id, @RequestParam("status") Status status ){
		ModelAndView modelAndView = new ModelAndView(Constants.PERIODO_REDIRECT_LISTAR);
		
		Periodo periodo = periodoService.getPeriodo(id);
		periodo.setStatus(status);
		
		periodoService.salvar(periodo);		
		
		return modelAndView;
	}

}
