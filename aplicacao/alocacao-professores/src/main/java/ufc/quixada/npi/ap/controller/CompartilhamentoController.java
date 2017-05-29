package ufc.quixada.npi.ap.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ufc.quixada.npi.ap.model.Compartilhamento;
import ufc.quixada.npi.ap.model.Turma;
import ufc.quixada.npi.ap.service.CompartilhamentoService;
import ufc.quixada.npi.ap.service.TurmaService;
import ufc.quixada.npi.ap.util.Constants;
import ufc.quixada.npi.ap.validation.CompartilhamentoValidator;


@Controller
@RequestMapping(path = "/compartilhamentos")
public class CompartilhamentoController {
	
	@Autowired
	private CompartilhamentoValidator compartilhamentoValidator;
	
	@Autowired
	private CompartilhamentoService compartilhamentoService;
	
	@Autowired
	private TurmaService turmaService;
	
	@RequestMapping(path = {""}, method = RequestMethod.GET)
	public ModelAndView listarCompartilhamentos(){
		ModelAndView model = new ModelAndView(Constants.COMPARTILHAMENTO_LISTAR);
		
		List<Compartilhamento> compartilhamentos = compartilhamentoService.findAllCompartilhamentos();
		
		model.addObject("compartilhamentos", compartilhamentos);
		
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
		
		compartilhamentoValidator.validate(compartilhamento, bindingResult);
		
		if (bindingResult.hasErrors()){
			model.setViewName(Constants.COMPARTILHAMENTO_CADASTRAR);
			
			return model;
		}
		
		
		try{
			compartilhamentoService.salvar(compartilhamento);
		} catch(Exception e){
			model.setViewName(Constants.PAGINA_ERRO_403);
			
			return model;
		}
		
		model.setViewName(Constants.COMPARTILHAMENTO_REDIRECT_LISTAR);
		
		return model;
	}

	@RequestMapping(path = {"/{id}/detalhar"}, method = RequestMethod.GET)
	public ModelAndView detalharCompartilhamento(@PathVariable(name = "id", required = true) Integer id){
		ModelAndView model = new ModelAndView(Constants.COMPARTILHAMENTO_DETALHAR);
		
		return model;
	}
	
	@RequestMapping(path = {"/{id}/editar"}, method = RequestMethod.GET)
	public ModelAndView editarCompartilhamento(@PathVariable(name = "id", required = true) Integer id, 
												@ModelAttribute("compartilhamento") Compartilhamento compartilhamento){
		
		ModelAndView model = new ModelAndView(Constants.COMPARTILHAMENTO_EDITAR);
		
		compartilhamento = compartilhamentoService.findCompartilhamento(id);
		
		if (compartilhamento == null){
			model.setViewName(Constants.COMPARTILHAMENTO_REDIRECT_LISTAR);
			
			return model;
		}
		
		model.addObject("compartilhamento", compartilhamento);
		
		return model;
	}
	
	@RequestMapping(path = {"/{id}/editar"}, method = RequestMethod.POST)
	public ModelAndView editarCompartilhamento(@PathVariable(name = "id", required = true) Integer id,
												@ModelAttribute("compartilhamento") @Valid Compartilhamento compartilhamento,
													BindingResult bindingResult, ModelAndView model){
		
		compartilhamentoValidator.validate(compartilhamento, bindingResult);
		
		if (bindingResult.hasErrors()){
			model.setViewName(Constants.COMPARTILHAMENTO_EDITAR);
			
			return model;
		}
		
		try{
			compartilhamentoService.salvar(compartilhamento);
		} catch(Exception e){
			model.setViewName(Constants.PAGINA_ERRO_403);
			
			return model;
		}
		
		model.setViewName(Constants.COMPARTILHAMENTO_REDIRECT_LISTAR);
		
		return model;
	}
	
	@RequestMapping(path = {"/{id}/excluir"}, method = RequestMethod.GET)
	public @ResponseBody boolean excluirCompartilhamento(@PathVariable(name = "id", required = true) Integer id){
		try{
			compartilhamentoService.excluir(id);
		}catch(EmptyResultDataAccessException ex){
			return false;
		}
		
		return true;
	}
	
	@ModelAttribute("turmas")
	public List<Turma> todasTurmas(){
		return turmaService.listarTurmas();
	}
	
}