package ufc.quixada.npi.ap.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@RequestMapping(path = {""})
	public ModelAndView listarEmpilhamentos(){
		List<Empilhamento> empilhamentos =  empilhamentoService.listarEmpilhamentos();
		
		ModelAndView model = new ModelAndView(Constants.PAGINA_LISTAR_EMPILHAMENTO);
		model.addObject("empilhamentos", empilhamentos);
		
		return model;
	}
	
	@RequestMapping(path={"/cadastrar"}, method=RequestMethod.GET)
	public ModelAndView cadastrarEmpilhamento(){
		ModelAndView model = new ModelAndView(Constants.PAGINA_FORM_CADASTRAR_EMPILHAMENTO);
		
		List<Disciplina> disciplinas = disciplinaService.listar();
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
			ModelAndView model = new ModelAndView(Constants.PAGINA_FORM_CADASTRAR_EMPILHAMENTO);
			return model;
		}
		
		empilhamentoService.salvarEmpilhamento(empilhamento);
		
		ModelAndView modelRetorno = new ModelAndView(Constants.REDIRECT_PAGINA_LISTAR_EMPILHAMENTO);
		return modelRetorno;
	}
	
	//
	@RequestMapping(path={"/{id}/excluir"})
	public String excluirEmpilhamento(@PathVariable("id") Integer id){
		empilhamentoService.excluirEmpilhamento(id);
		return Constants.REDIRECT_PAGINA_LISTAR_EMPILHAMENTO;
	}
	
	@RequestMapping(path = {"/{id}/editar"}, method = RequestMethod.GET)
	public ModelAndView editarCompartilhamento(@PathVariable("id") Integer id){
		
		List<Disciplina> disciplinas = disciplinaService.listar();
		List<Turma> turmas = turmaService.listarTurmas();
		Empilhamento empilhamentos = empilhamentoService.visualizarEmpilhamento(id);
		
		ModelAndView model = new ModelAndView(Constants.PAGINA_FORM_EDITAR_EMPILHAMENTO);
		model.addObject("empilhamento", empilhamentos);
		model.addObject("disciplinas", disciplinas);
		model.addObject("turmas", turmas);
		return model;
	}
	
	@RequestMapping(path = {"/{id}/editar"}, method = RequestMethod.POST)
	public ModelAndView editarCompartilhamento(Empilhamento empilhamento){
	
		ModelAndView model = new ModelAndView(Constants.REDIRECT_PAGINA_LISTAR_EMPILHAMENTO);
		try{
			empilhamentoService.salvarEmpilhamento(empilhamento);
		}catch(Exception e){
			model.addObject("erro", e.getMessage());
		}
		
		return model;
	}
	
	@RequestMapping(path={"/{id}/detalhar"})
	public ModelAndView visualizarEmpilhamento(@PathVariable("id") Integer id, @RequestParam(required=false) String erro){
		Empilhamento empilhamento =  empilhamentoService.visualizarEmpilhamento(id);
		
		ModelAndView model = new ModelAndView(Constants.PAGINA_DETALHAR_EMPILHAMENTO);
		model.addObject("empilhamento", empilhamento);
		model.addObject("erro", erro);
		
		return model;
	}
	
}