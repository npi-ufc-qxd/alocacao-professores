package ufc.quixada.npi.ap.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ufc.quixada.npi.ap.model.Empilhamento;
import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.service.OfertaService;
import ufc.quixada.npi.ap.util.Constants;


@Controller
@RequestMapping(path = "/ofertas")
public class OfertaController {
	
	@Autowired
	OfertaService ofertaService;
	
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

	@RequestMapping(path = {"/{id}/detalhar"}, method = RequestMethod.GET)
	public ModelAndView detalharOferta(@PathVariable("id") Integer id, @RequestParam(required=false) String erro){
		
		Oferta oferta=  ofertaService.visualizarOferta(id);
		
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_DETALHAR);
		modelAndView.addObject("oferta", oferta);
		modelAndView.addObject("professores",oferta.getProfessores());
		modelAndView.addObject("erro", erro);
		return modelAndView;
	}

	@RequestMapping(value= "/{id}/excluir")
	public void excluirOferta(){
	
	}
	
}
