package ufc.quixada.npi.ap.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ufc.quixada.npi.ap.model.Compartilhamento;
import ufc.quixada.npi.ap.service.CompartilhamentoService;
import ufc.quixada.npi.ap.util.Constants;


@Controller
@RequestMapping(path = "/compartilhamentos")
public class CompartilhamentoController {
	
	@Autowired
	private CompartilhamentoService compartilhamentoService;
	
	@RequestMapping(path = {""}, method = RequestMethod.GET)
	public ModelAndView listarCompartilhamentos(){
		ModelAndView model = new ModelAndView(Constants.COMPARTILHAMENTO_LISTAR);
		
		return model;
	}
	
	@RequestMapping(path = {"/cadastrar"}, method = RequestMethod.GET)
	public ModelAndView cadastrarCompartilhamentos(@ModelAttribute("compartilhamento") Compartilhamento compartilhamento){
		ModelAndView model = new ModelAndView(Constants.COMPARTILHAMENTO_CADASTRAR);

		return model;
	}
	
	@RequestMapping(path = {"/cadastrar"}, method = RequestMethod.POST)
	public ModelAndView cadastrarCompartilhamento(
			@ModelAttribute("compartilhamento") @Valid Compartilhamento compartilhamento,
				BindingResult bindingResult, ModelAndView model){

		if (bindingResult.hasErrors()){
			model.setViewName(Constants.COMPARTILHAMENTO_CADASTRAR);
			return model;
		}
	
		compartilhamentoService.salvar(compartilhamento);
		model.setViewName(Constants.COMPARTILHAMENTO_REDIRECT_LISTAR);
		return model;
	}

	@RequestMapping(path = {"/{id}/detalhar"}, method = RequestMethod.GET)
	public ModelAndView detalharCompartilhamento(@PathVariable(name = "id", required = true) Integer id){
		ModelAndView model = new ModelAndView(Constants.COMPARTILHAMENTO_DETALHAR);
		
		return model;
	}
	
	@RequestMapping(path = {"/{id}/editar"}, method = RequestMethod.GET)
	public ModelAndView editarCompartilhamento(@PathVariable(name = "id", required = true) Integer id){		
		ModelAndView model = new ModelAndView(Constants.COMPARTILHAMENTO_EDITAR);
		
		return model;
	}
	
	@RequestMapping(path = {"/{id}/editar"}, method = RequestMethod.POST)
	public ModelAndView editarCompartilhamento(Integer turma, Integer oferta, Integer numeroVagas){
		ModelAndView model = new ModelAndView(Constants.COMPARTILHAMENTO_EDITAR);

		return model;
	}
	
	@RequestMapping(path = {"/{id}/excluir"}, method = RequestMethod.GET)
	public ModelAndView excluirCompartilhamento(@PathVariable(name = "id", required = true) Integer id){
		ModelAndView model = new ModelAndView(Constants.COMPARTILHAMENTO_REDIRECT_LISTAR);
		
		return model;
	}
	
}
