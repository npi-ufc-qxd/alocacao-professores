package ufc.quixada.npi.ap.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ufc.quixada.npi.ap.util.Constants;

@Controller
@RequestMapping(path="/periodos")
public class PeriodoController {
	
	@RequestMapping(path="/")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView(Constants.INDEX_PERIODO); 
		return mv;
	}
	
	@RequestMapping(path="/cadastrar")
	public ModelAndView cadastrar(){
		ModelAndView mv = new ModelAndView(Constants.FORM_CADASTRAR_PERIODO);
		
		return mv;
	}
	
	
	@RequestMapping(path="/{id}/detalhar")
	public ModelAndView detalhar(@PathVariable ("id") Integer id){
		ModelAndView mv = new ModelAndView(Constants.FORM_DETALHAR_PERIODO);
		return mv;
	}
	
	@RequestMapping(path="/{id}/excluir")
	public ModelAndView excluir(@PathVariable ("id") Integer id){
		ModelAndView mv = new ModelAndView(Constants.EXCLUIR_PERIODO);
		return mv;
	}
	
	@RequestMapping(path="/{id}/editar")
	public ModelAndView editar(@PathVariable ("id") Integer id){
		ModelAndView mv = new ModelAndView(Constants.FORM_EDITAR_PERIODO);
		return mv;
	}

}
