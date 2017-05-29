package ufc.quixada.npi.ap.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.model.Periodo.Status;
import ufc.quixada.npi.ap.repository.PeriodoRepository;
import ufc.quixada.npi.ap.service.PeriodoService;
import ufc.quixada.npi.ap.util.Constants;

@Controller
@RequestMapping(path="/periodos")
public class PeriodoController {
	
	@Autowired
	PeriodoService periodoService;
	
	
	
	@RequestMapping(path="/")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView(Constants.INDEX_PERIODO);
		List<Periodo> periodos = periodoService.listaPeriodos();
		mv.addObject("periodos", periodos);
		return mv;
	}
	
	@RequestMapping(path="/cadastrar", method=RequestMethod.GET)
	public ModelAndView cadastrar(Periodo periodo){
		ModelAndView mv = new ModelAndView(Constants.FORM_CADASTRAR_PERIODO);
		mv.addObject("periodo", periodo);
		
		return mv;
	}
	
	@ModelAttribute("status")
	public List<Periodo.Status> todosStatus(){
		return Arrays.asList(Periodo.Status.values());
	}
	
	@RequestMapping(path="/cadastrar", method=RequestMethod.POST)
	public ModelAndView adicionarPeriodo(Periodo periodo){
		ModelAndView mv = new ModelAndView(Constants.REDIRECT_PAGINA_LISTAR_PERIODO);
		periodo.setStatus(Status.ABERTA);
		periodoService.salvar(periodo);
		
		return mv;
	}
	
	
	
	@RequestMapping(path="/{id}/detalhar")
	public ModelAndView detalhar(@PathVariable ("id") Integer id){
		ModelAndView mv = new ModelAndView(Constants.FORM_DETALHAR_PERIODO);
		return mv;
	}
	
	@RequestMapping(path="/{id}/excluir")
	public ModelAndView excluir(@PathVariable ("id") Integer id){
		ModelAndView mv = new ModelAndView(Constants.REDIRECT_PAGINA_LISTAR_PERIODO);
		periodoService.excluir(periodoService.getPeriodo(id));
		return mv;
	}
	
	@RequestMapping(path="/{id}/editar", method=RequestMethod.GET)
	public ModelAndView editar(@PathVariable ("id") Integer id){
		ModelAndView mv = new ModelAndView(Constants.FORM_EDITAR_PERIODO);
		mv.addObject("periodo", periodoService.getPeriodo(id));
		return mv;
	}
	
	@RequestMapping(path="/{id}/editar", method=RequestMethod.POST)
	public ModelAndView editarPeriodo(@PathVariable ("id") Integer id, @RequestParam("status") Status status ){
		ModelAndView mv = new ModelAndView(Constants.REDIRECT_PAGINA_LISTAR_PERIODO);
		
		Periodo periodo = periodoService.getPeriodo(id);
		periodo.setStatus(status);
		
		periodoService.salvar(periodo);		
		
		return mv;
	}

}
