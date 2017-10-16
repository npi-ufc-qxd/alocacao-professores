package ufc.quixada.npi.ap.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import ufc.quixada.npi.ap.util.Constants;
import ufc.quixada.npi.ap.validation.EmpilhamentoValidator;
import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Disciplina;
import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.model.Pessoa;
import ufc.quixada.npi.ap.model.RestricaoHorario;
import ufc.quixada.npi.ap.model.Turma;
import ufc.quixada.npi.ap.service.CursoService;
import ufc.quixada.npi.ap.service.DisciplinaService;
import ufc.quixada.npi.ap.service.EmpilhamentoService;
import ufc.quixada.npi.ap.service.OfertaService;
import ufc.quixada.npi.ap.service.PeriodoService;
import ufc.quixada.npi.ap.service.TurmaService;

@Controller
@RequestMapping(path="/empilhamentos")
public class EmpilhamentoController {

	@Autowired
	EmpilhamentoService empilhamentoService;
	
	@Autowired
	DisciplinaService disciplinaService;
	
	@Autowired
	OfertaService ofertaService;
	
	@Autowired
	CursoService cursoService;
	
	@Autowired
	PeriodoService periodoService;
	
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
		List<RestricaoHorario> restricaoHorarios =  empilhamentoService.listarEmpilhamentos();
		
		ModelAndView model = new ModelAndView(Constants.EMPILHAMENTO_LISTAR);
		model.addObject("restricaoHorarios", restricaoHorarios);
		
		return model;
	}
	
	@RequestMapping(path={"/cadastrar"}, method=RequestMethod.GET)
	public ModelAndView cadastrarEmpilhamento(Authentication auth){
		ModelAndView model = new ModelAndView(Constants.EMPILHAMENTO_CADASTRAR);
		Pessoa coordenador = (Pessoa) auth.getPrincipal();
		Periodo periodoAtivo = periodoService.periodoAtivo();
		Curso curso = cursoService.buscarPorCoordenador(coordenador);
		
		List<Oferta> ofertas = ofertaService.buscarPorPeriodoAndCurso(periodoAtivo, curso);
		List<Turma> turmas = turmaService.listarTurmas();
		
		
		model.addObject("ofertas", ofertas);
		model.addObject("turmas", turmas);
		model.addObject("restricaoHorario", new RestricaoHorario());
		model.addObject("periodoAtivo", periodoService.periodoAtivo());
		
		return model;
	}
	
	@RequestMapping(path={"/cadastrar"}, method=RequestMethod.POST)
	public ModelAndView cadastrarEmpilhamento(@ModelAttribute("restricaoHorario") @Valid RestricaoHorario restricaoHorario, BindingResult result, 
			ModelAndView modelAndView, Authentication auth){
		empilhamentoValidator.validate(restricaoHorario, result);
		
		if(result.hasErrors()){
			Pessoa pessoa = (Pessoa) auth.getPrincipal();
			modelAndView.addObject("cursoAtual", cursoService.buscarPorCoordenador(pessoa));
			modelAndView.setViewName(Constants.EMPILHAMENTO_CADASTRAR);
			return modelAndView;
		}
		
		empilhamentoService.salvarEmpilhamentoPeriodoAtivo(restricaoHorario);
		
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
	public ModelAndView editarCompartilhamento(@PathVariable("id") Integer id, Authentication auth){
		
		Pessoa coordenador = (Pessoa) auth.getPrincipal();
		Periodo periodoAtivo = periodoService.periodoAtivo();
		Curso curso = cursoService.buscarPorCoordenador(coordenador);
		
		List<Oferta> ofertas = ofertaService.buscarPorPeriodoAndCurso(periodoAtivo, curso);
		RestricaoHorario restricaoHorario = empilhamentoService.visualizarEmpilhamento(id);
		
		ModelAndView modelAndView = new ModelAndView(Constants.EMPILHAMENTO_EDITAR);
		modelAndView.addObject("ofertas", ofertas);
		modelAndView.addObject("restricaoHorario", restricaoHorario);
		
		return modelAndView;
	}
	
	@RequestMapping(path = {"/{id}/editar"}, method = RequestMethod.POST)
	public ModelAndView editarCompartilhamento(@PathVariable(name = "id", required = true) Integer id,
												@ModelAttribute("empilhamento") @Valid RestricaoHorario empilhamento, 
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
		RestricaoHorario empilhamento =  empilhamentoService.visualizarEmpilhamento(id);
		
		ModelAndView model = new ModelAndView(Constants.EMPILHAMENTO_DETALHAR);
		model.addObject("empilhamento", empilhamento);
		model.addObject("erro", erro);
		
		return model;
	}
	
}
