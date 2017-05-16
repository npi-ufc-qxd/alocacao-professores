package ufc.quixada.npi.ap.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ufc.quixada.npi.ap.util.Constants;
import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Disciplina;
import ufc.quixada.npi.ap.model.Empilhamento;
import ufc.quixada.npi.ap.model.Turma;
import ufc.quixada.npi.ap.service.EmpilhamentoService;

@Controller
@RequestMapping(path="/empilhamentos")
public class EmpilhamentoController {

	@Autowired
	EmpilhamentoService empilhamentoService;
	
	//@Autowired
	//DisciplinaService disciplinaService;
	
	@RequestMapping(path = {""})
	public ModelAndView listarEmpilhamentos(){
		ModelAndView model = new ModelAndView(Constants.PAGINA_LISTAR_EMPILHAMENTO);
		List<Empilhamento> empilhamentos =  empilhamentoService.listarEmpilhamentos();
		model.addObject("empilhamentos", empilhamentos);
		return model;
	}
	
	@RequestMapping(path={"/cadastrar"}, method=RequestMethod.GET)
	public ModelAndView cadastrarEmpilhamento(){
		ModelAndView model = new ModelAndView(Constants.PAGINA_FORM_CADASTRAR_EMPILHAMENTO);
		
		List<Disciplina> disciplinas = new ArrayList<Disciplina>();
		List<Turma> turmas = new ArrayList<Turma>();
		
		Disciplina d = new Disciplina();
		d.setNome("Discreta");
		disciplinas.add(d);
		
		Curso c = new Curso();
		c.setNome("Engenharia de Software");
		
		Turma t = new Turma();
		t.setCurso(c);
		t.setSemestre(2);
		turmas.add(t);
		
		model.addObject("disciplinas", disciplinas);
		model.addObject("turmas", turmas);
		model.addObject("empilhamento", new Empilhamento());
		
		return model;
	}
	
	@RequestMapping(path={"/cadastrar"}, method=RequestMethod.POST)
	public String cadastrarEmpilhamento(Integer idTurmaA, Integer idDisciplinaA, 
			Integer idTurmaB, Integer idDisciplinaB){
		empilhamentoService.cadastarEmpilhamento(idTurmaA, idDisciplinaA, idTurmaB, idDisciplinaB);
		return Constants.REDIRECT_PAGINA_LISTAR_EMPILHAMENTO;
	}
	
	@RequestMapping(path={"/{id}/excluir"})
	public String excluirEmpilhamento(@RequestParam Integer id){
		empilhamentoService.excluirEmpilhamento(id);
		return Constants.REDIRECT_PAGINA_LISTAR_EMPILHAMENTO;
	}
	
	@RequestMapping(path = {"/{id}/editar"}, method = RequestMethod.GET)
	public String editarCompartilhamento(@PathVariable(name = "id", required = true) Integer id){
		return Constants.PAGINA_FORM_EDITAR_EMPILHAMENTO;
	}
	
	@RequestMapping(path = {"/{id}/editar"}, method = RequestMethod.POST)
	public ModelAndView editarCompartilhamento(@RequestParam Integer idTurmaA, @RequestParam Integer idDisciplinaA, 
			@RequestParam Integer idTurmaB, @RequestParam Integer idDisciplinaB){
		ModelAndView model = new ModelAndView(Constants.REDIRECT_PAGINA_LISTAR_EMPILHAMENTO);
		return model;
	}
	
	@RequestMapping(path={"/{id}/detalhar"})
	public ModelAndView visualizarEmpilhamento(@PathVariable("id") Integer id, @RequestParam(required=false) String erro){
		ModelAndView model = new ModelAndView(Constants.PAGINA_DETALHAR_EMPILHAMENTO);
		
		Empilhamento empilhamento =  empilhamentoService.visualizarEmpilhamento(id);
	
		model.addObject("empilhamento", empilhamento);
		model.addObject("erro", erro);
		return model;
	}
	
}
