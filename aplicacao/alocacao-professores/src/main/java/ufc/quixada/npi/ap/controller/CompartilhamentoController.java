package ufc.quixada.npi.ap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ufc.quixada.npi.ap.util.Constants;


@Controller
@RequestMapping(path = "/compartilhamentos")
public class CompartilhamentoController {
	
	@RequestMapping(path = {""}, method = RequestMethod.GET)
	public String listarCompartilhamentos(){
		return Constants.PAGINA_LISTAR_COMPARTILHAMENTO;
	}
	
	@RequestMapping(path = {"/cadastrar"}, method = RequestMethod.GET)
	public String cadastrarCompartilhamentos(){
		return Constants.PAGINA_FORM_CADASTRAR_COMPARTILHAMENTO;
	}
	
	@RequestMapping(path = {"/cadastrar"}, method = RequestMethod.POST)
	public ModelAndView cadastrarCompartilhamento(Integer turma, Integer oferta, Integer numeroVagas){
		ModelAndView model = new ModelAndView(Constants.REDIRECT_PAGINA_LISTAR_COMPARTILHAMENTO);
		return model;
	}
	
	@RequestMapping(path = {"/{id}/detalhar"}, method = RequestMethod.GET)
	public String detalharCompartilhamento(@PathVariable(name = "id", required = true) Integer id){
		return Constants.PAGINA_DETALHAR_COMPARTILHAMENTO;
	}
	
	@RequestMapping(path = {"/{id}/editar"}, method = RequestMethod.GET)
	public String editarCompartilhamento(@PathVariable(name = "id", required = true) Integer id){
		return Constants.PAGINA_FORM_EDITAR_COMPARTILHAMENTO;
	}
	
	@RequestMapping(path = {"/editar"}, method = RequestMethod.POST)
	public ModelAndView editarCompartilhamento(Integer turma, Integer oferta, Integer numeroVagas){
		ModelAndView model = new ModelAndView(Constants.REDIRECT_PAGINA_LISTAR_COMPARTILHAMENTO);
		return model;
	}
	
	@RequestMapping(path = {"/{id}/excluir"}, method = RequestMethod.GET)
	public ModelAndView excluirCompartilhamento(@PathVariable(name = "id", required = true) Integer id){
		ModelAndView model = new ModelAndView(Constants.REDIRECT_PAGINA_LISTAR_COMPARTILHAMENTO);
		return model;
	}
	
}
