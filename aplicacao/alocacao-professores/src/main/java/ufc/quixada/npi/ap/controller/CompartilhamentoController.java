package ufc.quixada.npi.ap.controller;

import static ufc.quixada.npi.ap.util.Constants.COMPARTILHAMENTO_LISTAR;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import ufc.quixada.npi.ap.service.PeriodoService;
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

	@Autowired
	private PeriodoService periodoService;
	
	@ModelAttribute("turmas")
	public List<Turma> todasTurmas(){
		return turmaService.listarTurmas();
	}
	
	@RequestMapping(path = {"", "/"}, method = RequestMethod.GET)
	public String listarCompartilhamentos(Model model){
		model.addAttribute("periodo", periodoService.periodoAtivo());
		model.addAttribute("ofertas", compartilhamentoService.listarCompartilhamentoOfertas());
		return COMPARTILHAMENTO_LISTAR;
	}
	
	@RequestMapping(path = {"/cadastrar"}, method = RequestMethod.GET)
	public ModelAndView cadastrarCompartilhamento(@ModelAttribute("compartilhamento") Compartilhamento compartilhamento){
		ModelAndView modelAndView = new ModelAndView(Constants.COMPARTILHAMENTO_CADASTRAR);
		
		return modelAndView;
	}
	
	@RequestMapping(path = {"/cadastrar"}, method = RequestMethod.POST)
	public ModelAndView cadastrarCompartilhamento(
			@ModelAttribute("compartilhamento") @Valid Compartilhamento compartilhamento,
				BindingResult bindingResult, ModelAndView modelAndView){
		
		compartilhamentoValidator.validate(compartilhamento, bindingResult);
		
		if (bindingResult.hasErrors()){
			modelAndView.setViewName(Constants.COMPARTILHAMENTO_CADASTRAR);
			
			return modelAndView;
		}
		
		
		try{
			compartilhamentoService.salvar(compartilhamento);
		} catch(Exception e){
			modelAndView.setViewName(Constants.PAGINA_ERRO_403);
			
			return modelAndView;
		}
		
		modelAndView.setViewName(Constants.COMPARTILHAMENTO_REDIRECT_LISTAR);
		
		return modelAndView;
	}

	@RequestMapping(path = {"/{id}/detalhar"}, method = RequestMethod.GET)
	public ModelAndView detalharCompartilhamento(@PathVariable(name = "id", required = true) Integer id){
		ModelAndView modelAndView = new ModelAndView(Constants.COMPARTILHAMENTO_DETALHAR);
		
		return modelAndView;
	}
	
	@RequestMapping(path = {"/{id}/editar"}, method = RequestMethod.GET)
	public ModelAndView editarCompartilhamento(@PathVariable(name = "id", required = true) Integer id, 
												@ModelAttribute("compartilhamento") Compartilhamento compartilhamento){
		
		ModelAndView modelAndView = new ModelAndView(Constants.COMPARTILHAMENTO_EDITAR);
		
		compartilhamento = compartilhamentoService.findCompartilhamento(id);
		
		if (compartilhamento == null){
			modelAndView.setViewName(Constants.COMPARTILHAMENTO_REDIRECT_LISTAR);
			
			return modelAndView;
		}
		
		modelAndView.addObject("compartilhamento", compartilhamento);
		
		return modelAndView;
	}
	
	@RequestMapping(path = {"/{id}/editar"}, method = RequestMethod.POST)
	public ModelAndView editarCompartilhamento(@PathVariable(name = "id", required = true) Integer id,
												@ModelAttribute("compartilhamento") @Valid Compartilhamento compartilhamento,
													BindingResult bindingResult, ModelAndView modelAndView){
		
		compartilhamentoValidator.validate(compartilhamento, bindingResult);
		
		if (bindingResult.hasErrors()){
			modelAndView.setViewName(Constants.COMPARTILHAMENTO_EDITAR);
			
			return modelAndView;
		}
		
		try{
			compartilhamentoService.salvar(compartilhamento);
		} catch(Exception e){
			modelAndView.setViewName(Constants.PAGINA_ERRO_403);
			
			return modelAndView;
		}
		
		modelAndView.setViewName(Constants.COMPARTILHAMENTO_REDIRECT_LISTAR);
		
		return modelAndView;
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
	
}
