package ufc.quixada.npi.ap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ufc.quixada.npi.ap.model.Empilhamento;
import ufc.quixada.npi.ap.service.EmpilhamentoService;

@Controller
@RequestMapping(path="/empilhamentos")
public class EmpilhamentoController {

	@Autowired
	EmpilhamentoService empilhamentoService;
	
	@RequestMapping(path="/")
	public ModelAndView listarEmpilhamentos(){
		ModelAndView model = new ModelAndView("empilhamentos");
		List<Empilhamento> empilhamentos =  empilhamentoService.listarEmpilhamentos();
		model.addObject("empilhamentos", empilhamentos);
		return model;
	}
	
	@RequestMapping(path="/cadastrar", method=RequestMethod.POST)
	public String cadastrarEmpilhamento(@RequestParam Integer idTurmaA, @RequestParam Integer idDisciplinaA, 
			@RequestParam Integer idTurmaB, @RequestParam Integer idDisciplinaB){
		empilhamentoService.cadastarEmpilhamento(idTurmaA, idDisciplinaA, idTurmaB, idDisciplinaB);
		return "redirect:/empilhamento/";
	}
	
	@RequestMapping(path="/{id}/excluir")
	public String excluirEmpilhamento(@RequestParam Integer id){
		empilhamentoService.excluirEmpilhamento(id);
		return "redirect:/empilhamento/";
	}
	 
	@RequestMapping(path="/{id}/detalhar")
	public ModelAndView visualizarEmpilhamento(@PathVariable("id") Integer id, @RequestParam(required=false) String erro){
		ModelAndView model = new ModelAndView("empilhamento");
		
		Empilhamento empilhamento =  empilhamentoService.visualizarEmpilhamento(id);
	
		model.addObject("empilhamento", empilhamento);
		model.addObject("erro", erro);
		return model;
	}
	
}
