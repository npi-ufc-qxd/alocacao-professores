package ufc.quixada.npi.ap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
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
import ufc.quixada.npi.ap.service.OfertaService;
import ufc.quixada.npi.ap.util.Constants;


@Controller
@RequestMapping(path = "/ofertas")
public class OfertaController {
	
	@Autowired
	private OfertaService ofertaService;
	
	@RequestMapping(value = {"", "/"})
	public ModelAndView listarOfertas(){
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_LISTAR);
		
		modelAndView.addObject("ofertas", ofertaService.findAllOfertas());
		
		return modelAndView;
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.GET)
	public ModelAndView cadastrarOferta(@ModelAttribute("oferta") Oferta oferta){
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_CADASTRAR);
		
		return modelAndView;
	}

	@RequestMapping(value = "/cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastrarOferta(
			@ModelAttribute("oferta") @Valid Oferta oferta,
				BindingResult bindingResult, ModelAndView modelAndView){
		
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
		try {
			ofertaService.excluir(id);
		} catch (EmptyResultDataAccessException e) {
			return false;
		}
		
		return true;
	}

}