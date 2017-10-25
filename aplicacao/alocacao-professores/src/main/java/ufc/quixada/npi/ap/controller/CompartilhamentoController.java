package ufc.quixada.npi.ap.controller;

import static ufc.quixada.npi.ap.util.Constants.MSG_COMPARTILHAMENTO_EDITADO;
import static ufc.quixada.npi.ap.util.Constants.SWAL_STATUS_SUCCESS;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ufc.quixada.npi.ap.model.Compartilhamento;
import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Pessoa;
import ufc.quixada.npi.ap.service.CompartilhamentoService;
import ufc.quixada.npi.ap.service.CursoService;
import ufc.quixada.npi.ap.service.TurmaService;
import ufc.quixada.npi.ap.util.Constants;
import ufc.quixada.npi.ap.util.RestricaoDePeriodo;
import ufc.quixada.npi.ap.util.RestricaoDePeriodoAjax;
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
	private CursoService cursoService;
	
	@RequestMapping(path = {"/cadastrar"}, method = RequestMethod.GET)
	public ModelAndView cadastrarCompartilhamento(@ModelAttribute("compartilhamento") Compartilhamento compartilhamento){
		ModelAndView modelAndView = new ModelAndView(Constants.COMPARTILHAMENTO_CADASTRAR);
		
		modelAndView.addObject("turmas", turmaService.buscarTodasTurmas());
		
		return modelAndView;
	}
	
	@RequestMapping(path = {"/cadastrar"}, method = RequestMethod.POST)
	public ModelAndView cadastrarCompartilhamento(
			@ModelAttribute("compartilhamento") @Valid Compartilhamento compartilhamento,
				BindingResult bindingResult, ModelAndView modelAndView, RedirectAttributes redirectAttributes){
		
		compartilhamentoValidator.validate(compartilhamento, bindingResult);
		
		if (bindingResult.hasErrors()){
			modelAndView.setViewName(Constants.COMPARTILHAMENTO_CADASTRAR);
			
			modelAndView.addObject("turmas", turmaService.buscarTodasTurmas());
			
			return modelAndView;
		}
		
		compartilhamentoService.salvar(compartilhamento);
		
		modelAndView.setViewName(Constants.COMPARTILHAMENTO_REDIRECT_LISTAR);
		
		return modelAndView;
	}

	@RequestMapping(path = {"/{id}/detalhar"}, method = RequestMethod.GET)
	public ModelAndView detalharCompartilhamento(@PathVariable(name = "id", required = true) Integer id){
		ModelAndView modelAndView = new ModelAndView(Constants.COMPARTILHAMENTO_DETALHAR);
		
		return modelAndView;
	}
	
	@RequestMapping(path = {"/{id}/editar"}, method = RequestMethod.GET)
	@RestricaoDePeriodo(Constants.OFERTA_REDIRECT_LISTAR)
	public ModelAndView editarCompartilhamento(@PathVariable(name = "id", required = true) Integer id, 
												@ModelAttribute("compartilhamento") Compartilhamento compartilhamento){
		
		ModelAndView modelAndView = new ModelAndView(Constants.COMPARTILHAMENTO_EDITAR);
		
		compartilhamento = compartilhamentoService.buscarCompartilhamento(id);
		
		if (compartilhamento == null){
			modelAndView.setViewName(Constants.COMPARTILHAMENTO_REDIRECT_LISTAR);
			
			return modelAndView;
		}
		
		modelAndView.addObject("compartilhamento", compartilhamento);
		
		return modelAndView;
	}
	
	@RequestMapping(path = {"/{id}/editar"}, method = RequestMethod.POST)
	public ModelAndView editarCompartilhamento(@ModelAttribute("compartilhamento") @Valid Compartilhamento compartilhamento,
			BindingResult bindingResult, ModelAndView modelAndView, Authentication auth,
			RedirectAttributes redirectAttributes){
		
		Pessoa coordenador = (Pessoa) auth.getPrincipal();
		Curso cursoCoordenador = cursoService.buscarCursoPorCoordenador(coordenador);
		
		Map<String, Object> mapa = new HashMap<>();
		mapa.put("compartilhamento", compartilhamento);
		mapa.put("cursoCoordenador", cursoCoordenador);
		
		compartilhamentoValidator.validate(mapa, bindingResult);
		
		if (bindingResult.hasErrors()){
			modelAndView.setViewName(Constants.COMPARTILHAMENTO_EDITAR);
			
			return modelAndView;
		}
		
		compartilhamentoService.salvar(compartilhamento);
		
		modelAndView.setViewName(Constants.OFERTA_REDIRECT_LISTAR);
		
		redirectAttributes.addFlashAttribute(SWAL_STATUS_SUCCESS, MSG_COMPARTILHAMENTO_EDITADO);
		
		return modelAndView;
	}
	
	@RequestMapping(path = {"/{id}/excluir"}, method = RequestMethod.GET)
	@RestricaoDePeriodoAjax
	public @ResponseBody boolean excluirCompartilhamento(@PathVariable(name = "id", required = true) Integer id){
		try{
			compartilhamentoService.excluir(id);
		}catch(EmptyResultDataAccessException ex){
			return false;
		}
		
		return true;
	}
	
}
