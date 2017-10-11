package ufc.quixada.npi.ap.controller;

import static ufc.quixada.npi.ap.util.Constants.COMPARTILHAMENTO_LISTAR;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.ufc.quixada.npi.ldap.model.Usuario;
import br.ufc.quixada.npi.ldap.service.UsuarioService;
import ufc.quixada.npi.ap.model.Compartilhamento;
import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Pessoa;
import ufc.quixada.npi.ap.model.Professor;
import ufc.quixada.npi.ap.model.Turma;
import ufc.quixada.npi.ap.service.CompartilhamentoService;
import ufc.quixada.npi.ap.service.CursoService;
import ufc.quixada.npi.ap.service.DisciplinaService;
import ufc.quixada.npi.ap.service.OfertaService;
import ufc.quixada.npi.ap.service.PeriodoService;
import ufc.quixada.npi.ap.service.PessoaService;
import ufc.quixada.npi.ap.service.ProfessorService;
import ufc.quixada.npi.ap.service.TurmaService;
import ufc.quixada.npi.ap.util.Constants;

@Controller
public class DirecaoController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PessoaService pessoaService;
	
	@Autowired
	private ProfessorService professorService;
	
	@Autowired
	private PeriodoService periodoService;
	
	@Autowired
	private OfertaService ofertaService;
	
	@Autowired
	private DisciplinaService disciplinaService;
	
	@Autowired
	private CompartilhamentoService compartilhamentoService;
	
	@Autowired
	private CursoService cursoService;
	
	@Autowired
	private TurmaService turmaService;
	
	@RequestMapping(path = {"/oferta-campus"}, method = RequestMethod.GET)
	public String listarCompartilhamentos(Model model){
		model.addAttribute("periodo", periodoService.buscarPeriodoAtivo());
		model.addAttribute("ofertas", ofertaService.buscarOfertasPeriodoAtivo());
		return COMPARTILHAMENTO_LISTAR;
	}

	@RequestMapping(value = "/professores", method = RequestMethod.GET)
	public ModelAndView listarProfessores() {
		ModelAndView modelAndView = new ModelAndView(Constants.PROFESSOR_LISTAR);
		List<Professor> professores = professorService.buscarTodosProfessores();
		modelAndView.addObject("professores", professores);
		return modelAndView;
	}
	
	@RequestMapping(value = "/atualizar-professores", method = RequestMethod.GET)
	public ModelAndView atualizarProfessores(){
		ModelAndView modelAndView = new ModelAndView(Constants.PROFESSOR_REDIRECT_LISTAR);
		
		List<Usuario> usuarios = usuarioService.getByAffiliation(Constants.AFFILIATION_DOCENTE);
		
		for (Usuario usuario : usuarios){
			Professor professor = pessoaService.buscarProfessor(usuario.getCpf());
			
			if (professor == null){
				Pessoa pessoa = new Pessoa();
				
				pessoa.setCpf(usuario.getCpf());
				pessoa.setEmail(usuario.getEmail());
				pessoa.setNome(usuario.getNome());
				
				pessoa = pessoaService.salvar(pessoa);
				
				professor = new Professor();
				professor.setPessoa(pessoa);
				professor.setApelido(usuario.getNome());
				
				professorService.salvar(professor);
			}
			
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value = "/editar-oferta/{id}", method = RequestMethod.GET)
	public ModelAndView editarOferta(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_EDITAR_DIRECAO);

		Oferta oferta = ofertaService.buscarOferta(id);
		
		modelAndView.addObject("oferta", oferta);
		modelAndView.addObject("cursoAtual", oferta.getTurma().getCurso());
		modelAndView.addObject("disciplinas", disciplinaService.buscarDisciplinasNaoArquivadas());

		return modelAndView;
	}

	@RequestMapping(value = "/editar-compartilhamentos-oferta/", method = RequestMethod.GET)
	public @ResponseBody boolean editarOferta(@RequestParam("idsCompartilhamentos") List<Integer> idsCompartilhamentos,
			@RequestParam("idsTurmas") List<Integer> idsTurmas, @RequestParam("vagas") List<Integer> vagasCompartilhamentos) {
		
		if (idsCompartilhamentos != null && idsTurmas != null && vagasCompartilhamentos != null
				&& !idsCompartilhamentos.isEmpty() && !idsTurmas.isEmpty() && !vagasCompartilhamentos.isEmpty() 
				&& idsCompartilhamentos.size() == idsTurmas.size() && idsTurmas.size() == vagasCompartilhamentos.size()){
		
			for (int i = 0; i < idsCompartilhamentos.size(); i++){
				int idCompartilhamento = idsCompartilhamentos.get(i);
				int idTurma = idsTurmas.get(i);
				int vagas = vagasCompartilhamentos.get(i);
				
				Turma turma = turmaService.buscarTurma(idTurma);
				
				Compartilhamento compartilhamento = compartilhamentoService.buscarCompartilhamento(idCompartilhamento);
				
				if (turma != null && compartilhamento != null && vagas > 0){
					compartilhamento.setVagas(vagas);
					compartilhamento.setTurma(turma);
					
					compartilhamentoService.salvar(compartilhamento);
					
				}
			}
			
			return true;
		}
		
		return false;
	}
	
	@RequestMapping(path = {"/buscar-turmas/{idCurso}"}, method = RequestMethod.GET)
	public @ResponseBody List<Turma> buscarCompartilhamentosOferta(@PathVariable("idCurso") Integer idCurso){
		Curso curso = cursoService.buscarCurso(idCurso);
		
		if (curso != null)
			return curso.getTurmas();
		
		return null;
	}
}
