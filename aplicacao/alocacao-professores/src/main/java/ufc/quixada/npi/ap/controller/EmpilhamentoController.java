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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ufc.quixada.npi.ap.util.Constants;
import ufc.quixada.npi.ap.validation.EmpilhamentoValidator;
import ufc.quixada.npi.ap.model.Disciplina;
import ufc.quixada.npi.ap.model.Empilhamento;
import ufc.quixada.npi.ap.model.Turma;
import ufc.quixada.npi.ap.service.DisciplinaService;
import ufc.quixada.npi.ap.service.EmpilhamentoService;
import ufc.quixada.npi.ap.service.TurmaService;

@Controller
@RequestMapping(path="/empilhamentos")
public class EmpilhamentoController {

	@Autowired
	EmpilhamentoService empilhamentoService;
	
	@Autowired
	DisciplinaService disciplinaService;
	
	@Autowired 
	TurmaService turmaService;
	
	@Autowired
	EmpilhamentoValidator empilhamentoValidator;
	
	@ModelAttribute("turmas")
	public List<Turma> todasTurmas(){
		return turmaService.listarTurmas();
	}
	
	@RequestMapping(path = {""})
	public ModelAndView listarEmpilhamentos(){
		List<Empilhamento> empilhamentos =  empilhamentoService.listarEmpilhamentos();
		
		ModelAndView model = new ModelAndView(Constants.EMPILHAMENTO_LISTAR);
		model.addObject("empilhamentos", empilhamentos);
		
		return model;
	}
	
	@RequestMapping(path={"/cadastrar"}, method=RequestMethod.GET)
	public ModelAndView cadastrarEmpilhamento(){
		ModelAndView model = new ModelAndView(Constants.EMPILHAMENTO_CADASTRAR);
		
		List<Disciplina> disciplinas = disciplinaService.listarNaoArquivada();
		List<Turma> turmas = turmaService.listarTurmas();
		
		model.addObject("disciplinas", disciplinas);
		model.addObject("turmas", turmas);
		model.addObject("empilhamento", new Empilhamento());
		
		return model;
	}
	
	@RequestMapping(path={"/cadastrar"}, method=RequestMethod.POST)
	public ModelAndView cadastrarEmpilhamento(@ModelAttribute("empilhamento") @Valid Empilhamento empilhamento, BindingResult bindingResult){
		empilhamentoValidator.validate(empilhamento, bindingResult);
		
		if(bindingResult.hasErrors()){
			ModelAndView model = new ModelAndView(Constants.EMPILHAMENTO_CADASTRAR);
			return model;
		}
		
		empilhamentoService.salvarEmpilhamento(empilhamento);
		
		ModelAndView modelRetorno = new ModelAndView(Constants.EMPILHAMENTO_REDIRECT_LISTAR);
		return modelRetorno;
	}
	
	@RequestMapping(path = {"/{id}/excluir"}, method = RequestMethod.GET)
	public @ResponseBody boolean excluirEmpilhamento(@PathVariable(name = "id", required = true) Integer id){
		try{
			empilhamentoService.excluirEmpilhamento(id);
		}catch(EmptyResultDataAccessException ex){
			return false;
		}
		
		return true;
	}
	
	@RequestMapping(path = {"/{id}/editar"}, method = RequestMethod.GET)
	public ModelAndView editarCompartilhamento(@PathVariable("id") Integer id){
		List<Disciplina> disciplinas = disciplinaService.listarNaoArquivada();
		Empilhamento empilhamento = empilhamentoService.visualizarEmpilhamento(id);
		
		ModelAndView modelAndView = new ModelAndView(Constants.EMPILHAMENTO_EDITAR);
		modelAndView.addObject("disciplinasNaoArquivadas", disciplinas);
		modelAndView.addObject("empilhamento", empilhamento);
		
		return modelAndView;
	}
	
	@RequestMapping(path = {"/{id}/editar"}, method = RequestMethod.POST)
	public ModelAndView editarCompartilhamento(@PathVariable(name = "id", required = true) Integer id,
												@ModelAttribute("empilhamento") @Valid Empilhamento empilhamento, 
													BindingResult bindingResult, ModelAndView modelAndView){
		
		empilhamentoValidator.validate(empilhamento, bindingResult);
		
		if (bindingResult.hasErrors()){
			modelAndView.setViewName(Constants.EMPILHAMENTO_EDITAR);
			
			List<Disciplina> disciplinas = disciplinaService.listarNaoArquivada();
			modelAndView.addObject("disciplinasNaoArquivadas	", disciplinas);
			
			return modelAndView;
		}
		
		try{
			empilhamentoService.salvarEmpilhamento(empilhamento);
		}catch(Exception e){
			modelAndView.setViewName(Constants.PAGINA_ERRO_403);
			
			return modelAndView;
		}
		
		modelAndView.setViewName(Constants.EMPILHAMENTO_REDIRECT_LISTAR);
		
		return modelAndView;
	}
	
	@RequestMapping(path={"/{id}/detalhar"})
	public ModelAndView visualizarEmpilhamento(@PathVariable("id") Integer id, @RequestParam(required=false) String erro){
		Empilhamento empilhamento =  empilhamentoService.visualizarEmpilhamento(id);
		
		ModelAndView model = new ModelAndView(Constants.EMPILHAMENTO_DETALHAR);
		model.addObject("empilhamento", empilhamento);
		model.addObject("erro", erro);
		
		return model;
	}
	
}
