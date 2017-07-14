package ufc.quixada.npi.ap.service.impl;

import static ufc.quixada.npi.ap.util.Constants.PERIODO_INVALIDO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.quixada.npi.ap.exception.AlocacaoProfessoresException;
import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Periodo;
import ufc.quixada.npi.ap.model.Pessoa;
import ufc.quixada.npi.ap.model.Professor;
import ufc.quixada.npi.ap.repository.CursoRepository;
import ufc.quixada.npi.ap.repository.OfertaRepository;
import ufc.quixada.npi.ap.repository.PeriodoRepository;
import ufc.quixada.npi.ap.repository.ProfessorRepository;
import ufc.quixada.npi.ap.service.OfertaService;

@Service
public class OfertaServiceImpl implements OfertaService {

	@Autowired
	private OfertaRepository ofertaRepository;

	@Autowired
	private PeriodoRepository periodoRepository;

	@Autowired
	private CursoRepository cursoRepository;

	@Autowired
	private ProfessorRepository professorRepository;

	@Override
	public void salvar(Oferta oferta) throws AlocacaoProfessoresException {
		Periodo periodoAtivo = periodoRepository.pediodoAtivo();
		if (periodoAtivo != null) {
			oferta.setPeriodo(periodoAtivo);
			ofertaRepository.save(oferta);
		} else {
			throw new AlocacaoProfessoresException(PERIODO_INVALIDO);
		}
	}

	@Override
	public Oferta findOferta(Integer id) {
		return ofertaRepository.findOne(id);
	}

	@Override
	public List<Oferta> findAllOfertas() {
		return ofertaRepository.findAll();
	}

	@Override
	public void excluir(Integer id) {
		ofertaRepository.delete(id);
	}

	@Override
	public Oferta visualizarOferta(Integer idOferta) {
		return ofertaRepository.findOne(idOferta);
	}

	@Override
	public List<Oferta> buscarPorPeriodoAndCurso(Periodo periodo, Pessoa coordenador) {
		Professor professor = professorRepository.findByPessoa(coordenador);
		Curso curso = cursoRepository.findByCoordenador(professor);
		return ofertaRepository.findByPeriodoAndCurso(periodo, curso);
	}

	@Override
	public List<Oferta> importarOfertas(List<Integer> ofertas) {
		List<Oferta> ofertasContidas = new ArrayList<>();
		boolean contem = false;
		Periodo periodo = periodoRepository.pediodoAtivo();
		for (Integer id : ofertas) {
			Oferta oferta = ofertaRepository.findOne(id);
			if (oferta != null) {
				contem = false;
				for (Oferta o : periodo.getOfertas()) {
					if (o.getDisciplina().equals(oferta.getDisciplina())) {
						ofertasContidas.add(oferta);
						contem = true;
					}
				}
				if (!contem) {
					Oferta newOferta = this.clonarOferta(oferta);
					newOferta.setPeriodo(periodo);
					ofertaRepository.save(newOferta);
				}
			}
		}
		return ofertasContidas;
	}

	private Oferta clonarOferta(Oferta o) {
		Oferta oferta = new Oferta();
		oferta.setDisciplina(o.getDisciplina());
		oferta.setTurma(o.getTurma());
		oferta.setTurno(o.getTurno());
		oferta.setVagas(o.getVagas());
		oferta.setObservacao(o.getObservacao());
		
		List<Professor> professores = new ArrayList<>();
		for (Professor professor : o.getProfessores()) {
			professores.add(professor);
		}
		oferta.setProfessores(professores);
		
		return oferta;
	}

}