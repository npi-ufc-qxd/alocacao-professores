package ufc.quixada.npi.ap.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ufc.quixada.npi.ap.util.Constants;


@Controller
@RequestMapping(path = "/ofertas")
public class OfertaController {
	
	@RequestMapping(value = {""}, method = RequestMethod.GET)
	public String listar(){
		
		return Constants.OFERTA_LISTAR;
	}

	@RequestMapping(value = {"/cadastrar"}, method = RequestMethod.GET)
	public String cadastrarOfertas(){

		return Constants.OFERTA_CADASTRAR;
	}
	
	@RequestMapping(value = {"/cadastrar"}, method = RequestMethod.POST)
	public ModelAndView cadastrarOferta(){

		ModelAndView model = new ModelAndView(Constants.OFERTA_LISTAR);
		return model;
	}
	
	@RequestMapping(value = "/{id}/editar")
	public ModelAndView editar(){
		ModelAndView mv = new ModelAndView(Constants.OFERTA_FORM_EDITAR);

		return mv;
	}

	@RequestMapping(value = "/{id}/detalhar")
	public ModelAndView detalhar(){
		ModelAndView mv = new ModelAndView(Constants.OFERTA_DETALHAR);

		return mv;
	}

	@RequestMapping(value= "/{id}/excluir")
	public void excluir(){
	
	}

}
