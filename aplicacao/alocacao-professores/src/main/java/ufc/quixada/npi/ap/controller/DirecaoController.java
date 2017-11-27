package ufc.quixada.npi.ap.controller;

import static ufc.quixada.npi.ap.util.Constants.EXPORTAR;
import static ufc.quixada.npi.ap.util.Constants.MSG_PROFESSOR_EDITADO;
import static ufc.quixada.npi.ap.util.Constants.OFERTA_CADASTRADA;
import static ufc.quixada.npi.ap.util.Constants.SWAL_STATUS_SUCCESS;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.ufc.quixada.npi.ldap.model.Usuario;
import br.ufc.quixada.npi.ldap.service.UsuarioService;
import ufc.quixada.npi.ap.annotation.RestricaoDePeriodo;
import ufc.quixada.npi.ap.model.Compartilhamento;
import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Periodo;
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
import ufc.quixada.npi.ap.service.RestricaoHorarioService;
import ufc.quixada.npi.ap.service.TurmaService;
import ufc.quixada.npi.ap.util.Constants;
import ufc.quixada.npi.ap.validation.OfertaValidator;

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
	private RestricaoHorarioService restricaoHorarioService;

	@Autowired
	private CursoService cursoService;

	@Autowired
	private OfertaValidator ofertaValidator;

	private CompartilhamentoService compartilhamentoService;

	@Autowired
	private TurmaService turmaService;

	@ModelAttribute("cursos")
	public List<Curso> todosCursos() {
		return cursoService.buscarTodosCursos();
	}

	@ModelAttribute("professores")
	public List<Professor> todosProfessores() {
		return professorService.buscarTodosProfessores();
	}

	@RequestMapping(path = { "/exportacao" }, method = RequestMethod.GET)
	public String exportar() {
		ModelAndView modelAndView = new ModelAndView(EXPORTAR);

		Periodo periodoAtivo = periodoService.buscarPeriodoAtivo();
		modelAndView.addObject("empilhamentos", restricaoHorarioService.buscarTodasRestricoesHorario());
		modelAndView.addObject("ofertas", ofertaService.buscarPorPeriodo(periodoAtivo));

		return EXPORTAR;
	}

	@RequestMapping(path = { "/oferta-campus" }, method = RequestMethod.GET)
	public ModelAndView listarCompartilhamentos() {
		ModelAndView modelAndView = new ModelAndView(Constants.COMPARTILHAMENTO_LISTAR);

		modelAndView.addObject("periodo", periodoService.buscarPeriodoAtivo());
		modelAndView.addObject("ofertas", ofertaService.buscarOfertasPeriodoAtivo());

		return modelAndView;

	}

	@RequestMapping(value = "/professores", method = RequestMethod.GET)
	public ModelAndView listarProfessores() {
		ModelAndView modelAndView = new ModelAndView(Constants.PROFESSOR_LISTAR);

		List<Professor> professores = professorService.buscarTodosProfessores();

		modelAndView.addObject("professores", professores);
		modelAndView.addObject("cargaHorariaAtual", professores);

		return modelAndView;
	}

	@RequestMapping(value = "/atualizar-professores", method = RequestMethod.GET)
	public ModelAndView atualizarProfessores() {
		ModelAndView modelAndView = new ModelAndView(Constants.PROFESSOR_REDIRECT_LISTAR);

		List<Usuario> usuarios = usuarioService.getByAffiliation(Constants.AFFILIATION_DOCENTE);

		for (Usuario usuario : usuarios) {
			Professor professor = pessoaService.buscarProfessor(usuario.getCpf());

			if (professor == null) {
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

	@RequestMapping(value = "/relatorio-professores", method = RequestMethod.GET)
	public ModelAndView relatorioCargaHorariaProfessores() {
		ModelAndView modelAndView = new ModelAndView(Constants.PROFESSOR_RELATORIO_CARGA_HORARIA);
		
		modelAndView.addObject("relatorio", professorService.gerarRelatorioCargaHorariaProfessores());

		return modelAndView;
	}

	@RequestMapping(value = "/editar-oferta/{id}", method = RequestMethod.GET)
	@RestricaoDePeriodo(Constants.OFERTA_CAMPUS_REDIRECT_LISTAR)
	public ModelAndView editarOferta(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_EDITAR_DIRECAO);

		Oferta oferta = ofertaService.buscarOferta(id);

		modelAndView.addObject("oferta", oferta);
		modelAndView.addObject("cursoAtual", oferta.getTurma().getCurso());
		modelAndView.addObject("disciplinas", disciplinaService.buscarDisciplinasNaoArquivadas());

		return modelAndView;
	}

	private boolean validarLista(List<?> lista) {
		return lista != null && !lista.isEmpty() && !lista.contains(null);
	}

	@RequestMapping(value = "/direcao/ofertas/cadastrar", method = RequestMethod.GET)
	public ModelAndView cadastrarOferta(@ModelAttribute("oferta") Oferta oferta, Authentication auth) {
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_CADASTRAR);
		modelAndView.addObject("disciplinas", disciplinaService.buscarDisciplinasNaoArquivadas());
		modelAndView.addObject("periodoAtivo", periodoService.buscarPeriodoAtivo());

		return modelAndView;
	}

	@RequestMapping(value = "/direcao/ofertas/cadastrar", method = RequestMethod.POST)
	public ModelAndView cadastrarOferta(@ModelAttribute("oferta") @Valid Oferta oferta, BindingResult bindingResult,
			ModelAndView modelAndView, RedirectAttributes redirectAttributes, Authentication auth) {

		ofertaValidator.validate(oferta, bindingResult);
		
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName(Constants.OFERTA_CADASTRAR);
			modelAndView.addObject("disciplinas", disciplinaService.buscarDisciplinasNaoArquivadas());
			modelAndView.addObject("periodoAtivo", periodoService.buscarPeriodoAtivo());

			return modelAndView;
		}

		ofertaService.salvarOfertaPeriodoAtivo(oferta);
		modelAndView.setViewName(Constants.OFERTA_REDIRECT_LISTAR);
		redirectAttributes.addFlashAttribute(SWAL_STATUS_SUCCESS, OFERTA_CADASTRADA);

		return modelAndView;
	}

	@RequestMapping(value = "/direcao/ofertas/{id}/editar", method = RequestMethod.GET)
	public ModelAndView editarOferta(@PathVariable("id") Integer id, Authentication auth) {
		ModelAndView modelAndView = new ModelAndView(Constants.OFERTA_EDITAR);

		Pessoa pessoa = (Pessoa) auth.getPrincipal();
		modelAndView.addObject("cursoAtual", cursoService.buscarCursoPorCoordenador(pessoa));

		modelAndView.addObject("oferta", ofertaService.buscarOferta(id));
		modelAndView.addObject("disciplinas", disciplinaService.buscarDisciplinasNaoArquivadas());

		return modelAndView;
	}

	@RequestMapping(value = "/direcao/ofertas/{id}/editar", method = RequestMethod.POST)
	public ModelAndView editarOferta(@PathVariable(name = "id", required = true) Integer id,
			@ModelAttribute("oferta") @Valid Oferta oferta, BindingResult bindingResult, ModelAndView modelAndView,
			Authentication auth) {

		ofertaValidator.validate(oferta, bindingResult);

		if (bindingResult.hasErrors()) {
			Pessoa pessoa = (Pessoa) auth.getPrincipal();
			modelAndView.addObject("cursoAtual", cursoService.buscarCursoPorCoordenador(pessoa));
			modelAndView.setViewName(Constants.OFERTA_EDITAR);
			modelAndView.addObject("disciplinas", disciplinaService.buscarDisciplinasNaoArquivadas());

			return modelAndView;
		}

		ofertaService.salvarOfertaPeriodoAtivo(oferta);

		modelAndView.setViewName(Constants.OFERTA_REDIRECT_LISTAR);

		return modelAndView;
	}

	@RequestMapping(value = "/editar-compartilhamentos-oferta/", method = RequestMethod.GET)
	public @ResponseBody boolean editarOferta(@RequestParam("idsCompartilhamentos") List<Integer> idsCompartilhamentos,
			@RequestParam("idsTurmas") List<Integer> idsTurmas,
			@RequestParam("vagas") List<Integer> vagasCompartilhamentos) {

		if (validarLista(idsCompartilhamentos) && validarLista(idsTurmas) && validarLista(vagasCompartilhamentos)
				&& idsCompartilhamentos.size() == idsTurmas.size()
				&& idsTurmas.size() == vagasCompartilhamentos.size()) {

			for (int i = 0; i < idsCompartilhamentos.size(); i++) {
				int idCompartilhamento = idsCompartilhamentos.get(i);
				int idTurma = idsTurmas.get(i);
				int vagas = vagasCompartilhamentos.get(i);

				Turma turma = turmaService.buscarTurma(idTurma);
				Compartilhamento compartilhamento = compartilhamentoService.buscarCompartilhamento(idCompartilhamento);

				if (compartilhamento != null && turma != null && vagas > 0) {
					compartilhamento.setVagas(vagas);
					compartilhamento.setTurma(turma);

					compartilhamentoService.salvar(compartilhamento);
				}
			}

			return true;
		}

		return false;
	}

	@RequestMapping(value = "/editar-professor/{id}", method = RequestMethod.GET)
	public ModelAndView editarProfessor(@PathVariable("id") Professor professor) {
		ModelAndView modelAndView = new ModelAndView(Constants.PROFESSOR_EDITAR);
		modelAndView.addObject("professor", professor);
		return modelAndView;
	}

	@RequestMapping(value = "/editar-professor", method = RequestMethod.POST)
	public ModelAndView editarProfessor(@ModelAttribute("professor") Professor professor,
			RedirectAttributes redirectAttributes) {
		ModelAndView modelAndView = new ModelAndView(Constants.PROFESSOR_REDIRECT_LISTAR);
		professorService.salvar(professor);
		redirectAttributes.addFlashAttribute(SWAL_STATUS_SUCCESS, MSG_PROFESSOR_EDITADO);
		return modelAndView;
	}
}