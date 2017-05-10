package ufc.quixada.npi.ap.controller;

import java.util.List;

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
	public ModelAndView listarCompartilhamentos(){
		ModelAndView model = new ModelAndView(Constants.COMPARTILHAMENTO_LISTAR);
		
		List<Compartilhamento> compartilhamentos = compartilhamentoService.findAllCompartilhamentos();
		
		model.addObject("compartilhamentos", compartilhamentos);
		
		return model;
	}
	
	@RequestMapping(path = {"/cadastrar"}, method = RequestMethod.GET)
	public ModelAndView cadastrarCompartilhamentos(){
		ModelAndView model = new ModelAndView(Constants.COMPARTILHAMENTO_CADASTRAR);

		return model;
	}
	
	@RequestMapping(path = {"/cadastrar"}, method = RequestMethod.POST)
	public ModelAndView cadastrarCompartilhamento(Compartilhamento compartilhamento){
		ModelAndView model = new ModelAndView(Constants.COMPARTILHAMENTO_REDIRECT_LISTAR);
		
		compartilhamentoService.salvar(compartilhamento);
		
		return model;
	}
	
	@RequestMapping(path = {"/{id}/detalhar"}, method = RequestMethod.GET)
	public ModelAndView detalharCompartilhamento(@PathVariable(name = "id", required = true) Integer id){
		ModelAndView model = new ModelAndView(Constants.COMPARTILHAMENTO_DETALHAR);
		
		Compartilhamento compartilhamento = compartilhamentoService.findCompartilhamento(id);
		
		if (compartilhamento != null)
			model.addObject("compartilhamento");
		
		return model;
	}
	
	@RequestMapping(path = {"/{id}/editar"}, method = RequestMethod.GET)
	public ModelAndView editarCompartilhamento(@PathVariable(name = "id", required = true) Integer id){
		ModelAndView model;
		
		Compartilhamento compartilhamento = compartilhamentoService.findCompartilhamento(id);
		
		
		if (compartilhamento != null){
			model = new ModelAndView(Constants.COMPARTILHAMENTO_EDITAR);
			model.addObject("compartilhamento", compartilhamento);
		}
		else{
			model = new ModelAndView(Constants.PAGINA_ERRO_404);
		}
		
		return model;
	}
	
	@RequestMapping(path = {"/{id}/editar"}, method = RequestMethod.POST)
	public ModelAndView editarCompartilhamento(Compartilhamento compartilhamento){
		ModelAndView model = new ModelAndView(Constants.COMPARTILHAMENTO_REDIRECT_LISTAR);
		
		compartilhamentoService.salvar(compartilhamento);
		
		return model;
	}
	
	@RequestMapping(path = {"/{id}/excluir"}, method = RequestMethod.GET)
	public ModelAndView excluirCompartilhamento(@PathVariable(name = "id", required = true) Integer id){
		ModelAndView model = new ModelAndView(Constants.COMPARTILHAMENTO_REDIRECT_LISTAR);
		
		return model;
	}

}
