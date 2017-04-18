package ufc.quixada.npi.ap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/compartilhamentos")
public class CompartilhamentoController {
	
	@RequestMapping(path = {""}, method = RequestMethod.GET)
	public String listarCompartilhamentos(){
		return "compartilhamento/listar-compartilhamento";
	}
	
	@RequestMapping(path = {"/cadastrar"}, method = RequestMethod.GET)
	public String cadastrarCompartilhamentos(){
		return "compartilhamento/cadastrar-compartilhamento";
	}
	
	@RequestMapping(path = {"/cadastrar"}, method = RequestMethod.POST)
	public ModelAndView cadastrarCompartilhamento(Integer turma, Integer oferta, Integer numeroVagas){
		ModelAndView model = new ModelAndView("redirect:/compartilhamentos?sucessoCadastro");
		return model;
	}
	
	@RequestMapping(path = {"/{id}/detalhar"}, method = RequestMethod.GET)
	public String detalharCompartilhamento(@PathVariable(name = "id", required = true) Integer id){
		
		return "compartilhamento/detalhar-compartilhamento";
	}
	
	@RequestMapping(path = {"/{id}/editar"}, method = RequestMethod.GET)
	public String editarCompartilhamento(@PathVariable(name = "id", required = true) Integer id){
		return "compartilhamento/editar-compartilhamento";
	}
	
	@RequestMapping(path = {"/editar"}, method = RequestMethod.POST)
	public ModelAndView editarCompartilhamento(Integer turma, Integer oferta, Integer numeroVagas){
		ModelAndView model = new ModelAndView("redirect:/compartilhamentos?sucessoEdicao");
		return model;
	}
	
	@RequestMapping(path = {"/{id}/excluir"}, method = RequestMethod.GET)
	public String excluirCompartilhamento(@PathVariable(name = "id", required = true) Integer id){
		return "compartilhamento/excluir-compartilhamento";
	}
	
}
