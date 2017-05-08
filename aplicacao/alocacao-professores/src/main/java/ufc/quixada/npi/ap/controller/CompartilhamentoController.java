package ufc.quixada.npi.ap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
	public String listarCompartilhamentos(){
		return Constants.COMPARTILHAMENTO_LISTAR;
	}
	
	@RequestMapping(path = {"/cadastrar"}, method = RequestMethod.GET)
	public String cadastrarCompartilhamentos(){
		return Constants.COMPARTILHAMENTO_CADASTRAR;
	}
	
	@RequestMapping(path = {"/cadastrar"}, method = RequestMethod.POST)
	public ModelAndView cadastrarCompartilhamento(Compartilhamento compartilhamento){
		ModelAndView model = new ModelAndView(Constants.COMPARTILHAMENTO_REDIRECT_LISTAR);
		
		compartilhamentoService.salvar(compartilhamento);
		
		return model;
	}
	
	@RequestMapping(path = {"/{id}/detalhar"}, method = RequestMethod.GET)
	public String detalharCompartilhamento(@PathVariable(name = "id", required = true) Integer id){
		return Constants.COMPARTILHAMENTO_DETALHAR;
	}
	
	@RequestMapping(path = {"/{id}/editar"}, method = RequestMethod.GET)
	public String editarCompartilhamento(@PathVariable(name = "id", required = true) Integer id){		
		return Constants.COMPARTILHAMENTO_EDITAR;
	}
	
	@RequestMapping(path = {"/{id}/editar"}, method = RequestMethod.POST)
	public String editarCompartilhamento(Integer turma, Integer oferta, Integer numeroVagas){
		return Constants.COMPARTILHAMENTO_REDIRECT_LISTAR;
	}
	
	@RequestMapping(path = {"/{id}/excluir"}, method = RequestMethod.GET)
	public ModelAndView excluirCompartilhamento(@PathVariable(name = "id", required = true) Integer id){
		ModelAndView model = new ModelAndView(Constants.COMPARTILHAMENTO_REDIRECT_LISTAR);
		return model;
	}
	
}
