package ufc.quixada.npi.ap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ufc.quixada.npi.ap.service.OfertaService;
import ufc.quixada.npi.ap.util.Constants;

@Controller
@RequestMapping(path = "/ofertas")
public class OfertaController {

	@Autowired
	public OfertaService ofertaService;

	@RequestMapping(value = { "" }, method = RequestMethod.GET)
	public ModelAndView listar() {

		ModelAndView model = new ModelAndView(Constants.OFERTA_LISTAR);

		model.addObject("ofertas", ofertaService.listar());

		return model;

	}

	@RequestMapping(value = { "/cadastrar" }, method = RequestMethod.GET)
	public String cadastrarOfertas() {

		return Constants.OFERTA_CADASTRAR;
	}

	@RequestMapping(value = { "/cadastrar" }, method = RequestMethod.POST)
	public ModelAndView cadastrarOferta() {

		ModelAndView model = new ModelAndView(Constants.OFERTA_LISTAR);
		return model;
	}

	@RequestMapping(value = "/{id}/editar")
	public ModelAndView editar() {
		ModelAndView mv = new ModelAndView(Constants.OFERTA_FORM_EDITAR);

		return mv;
	}

	@RequestMapping(value = "/{id}/detalhar")
	public ModelAndView detalhar() {
		ModelAndView mv = new ModelAndView(Constants.OFERTA_DETALHAR);

		return mv;
	}

	@RequestMapping(value = "/{id}/excluir")
	public void excluir() {

	}

}
