package ufc.quixada.npi.ap.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ufc.quixada.npi.ap.util.Constants;


@Controller
@RequestMapping(path = "/ofertas")
public class OfertaController {
	
	@RequestMapping(value = "/")
	public ModelAndView listar(){
		ModelAndView mv = new ModelAndView(Constants.LISTAR_OFERTA);

		return mv;
	}

	@RequestMapping(value = "/cadastrar")
	public ModelAndView cadastrar(){
		ModelAndView mv = new ModelAndView(Constants.FORM_CADASTRAR_OFERTA);

		return mv;
	}
	
	@RequestMapping(value = "/{id}/editar")
	public ModelAndView editar(){
		ModelAndView mv = new ModelAndView(Constants.FORM_EDITAR_OFERTA);

		return mv;
	}

	@RequestMapping(value = "/{id}/detalhar")
	public ModelAndView detalhar(){
		ModelAndView mv = new ModelAndView(Constants.DETALHAR_OFERTA);

		return mv;
	}

	@RequestMapping(value= "/{id}/excluir")
	public void excluir(){
	
	}

}
