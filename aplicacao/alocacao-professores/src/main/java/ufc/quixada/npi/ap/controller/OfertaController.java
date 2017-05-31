package ufc.quixada.npi.ap.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ufc.quixada.npi.ap.util.Constants;


@Controller
@RequestMapping(path = "/ofertas")
public class OfertaController {
	
	@RequestMapping(value = {"", "/"})
	public ModelAndView listarOfertas(){
		ModelAndView mv = new ModelAndView(Constants.OFERTA_LISTAR);

		return mv;
	}

	@RequestMapping(value = "/cadastrar")
	public ModelAndView cadastrarOferta(){
		ModelAndView mv = new ModelAndView(Constants.OFERTA_CADASTRAR);

		return mv;
	}
	
	@RequestMapping(value = "/{id}/editar")
	public ModelAndView editarOferta(){
		ModelAndView mv = new ModelAndView(Constants.OFERTA_EDITAR);

		return mv;
	}

	@RequestMapping(value = "/{id}/detalhar")
	public ModelAndView detalharOferta(){
		ModelAndView mv = new ModelAndView(Constants.OFERTA_DETALHAR);

		return mv;
	}

	@RequestMapping(value= "/{id}/excluir")
	public void excluirOferta(){
	
	}
	
}
