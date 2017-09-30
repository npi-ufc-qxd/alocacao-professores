package ufc.quixada.npi.ap.service.impl;

import static ufc.quixada.npi.ap.util.Constants.PERIODO_INVALIDO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		Periodo periodoAtivo = periodoRepository.periodoAtivo();
		
		if (periodoAtivo != null) {
			oferta.setPeriodo(periodoAtivo);
			ofertaRepository.save(oferta);
		} else
			throw new AlocacaoProfessoresException(PERIODO_INVALIDO);
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
		return ofertaRepository.findOfertasByPeriodoAndTurma_curso(periodo, curso);
	}
	
	@Override
	public List<Oferta> buscarPorPeriodoAndCurso(Periodo periodo, Curso curso) {
		return ofertaRepository.findOfertasByPeriodoAndTurma_curso(periodo, curso);
	}
	
	@Override
	public List<Oferta> buscarOfertasCompartilhadasPorPeriodoAndCurso(Periodo periodo, Curso curso) {
		return ofertaRepository.findOfertasCompartilhadasByPeriodoAndCurso(periodo, curso);
	}

	@Override
	public List<Oferta> buscarOfertasImportadasPorPeriodoAndCurso(Periodo periodo, Curso curso) {
		Periodo periodoAtivo = periodoRepository.periodoAtivo();
		return ofertaRepository.findOfertasImportadasByPeriodoAndCurso(periodo, periodoAtivo, curso);
	}
	
	@Override
	public List<Oferta> buscarOfertasNaoImportadasPorPeriodoAndCurso(Periodo periodo, Curso curso) {
		Periodo periodoAtivo = periodoRepository.periodoAtivo();
		return ofertaRepository.findOfertasNaoImportadasByPeriodoAndCurso(periodo, periodoAtivo, curso);
	}
	
	@Override
	public Map<String, Object> importarOfertas(List<Integer> ofertas) {
		boolean contem;
		boolean adicionado = true;
		
		Periodo periodo = periodoRepository.periodoAtivo();
		
		Map<String, Object> resultado = new HashMap<String, Object>();

		for (Integer id : ofertas) {
			Oferta oferta = ofertaRepository.findOne(id);
			
			if (oferta != null) {
				
				contem = false;
				
				for (Oferta o : ofertaRepository.findOfertaByPeriodo(periodo)) {
					if (o.getDisciplina().equals(oferta.getDisciplina()) 
							&& o.getTurma().equals(oferta.getTurma())) {
						contem = true;
						break;
					}
				}
				
				if (!contem) {
					Oferta novaOferta = this.clonarOferta(oferta);
					
					novaOferta.setPeriodo(periodo);
					
					ofertaRepository.save(novaOferta);
					
					if (adicionado)
						resultado.put("importada", true);
					
					adicionado = false;
				}
			}
		}

		if (adicionado) 
			resultado.put("importada", false);
		
		return resultado;
	}
	
	private Oferta clonarOferta(Oferta o) {
		Oferta oferta = new Oferta();
		
		oferta.setDisciplina(o.getDisciplina());
		oferta.setTurma(o.getTurma());
		oferta.setTurno(o.getTurno());
		oferta.setVagas(o.getVagas());
		oferta.setObservacao(o.getObservacao());

		if (!o.getProfessores().isEmpty()) {
			List<Professor> professores = new ArrayList<>();
			professores.addAll(o.getProfessores());
			
			oferta.setProfessores(professores);
		}
		
		return oferta;
	}
	
	@Override
	public void substituirOferta(List<Integer> idOfertas) {
		Periodo periodoAtivo = periodoRepository.periodoAtivo();
		List<Oferta> novasOfertas = new ArrayList<>();
		
		for (Integer id : idOfertas) {
			Oferta oferta = ofertaRepository.findOne(id);
			
			if (oferta != null) {
				for (Oferta o : ofertaRepository.findOfertaByPeriodo(periodoAtivo)){
					if (o.getDisciplina().equals(oferta.getDisciplina())) {
						ofertaRepository.delete(o);
						
						Oferta novaOferta = clonarOferta(o);
						novaOferta.setPeriodo(periodoAtivo);
						novasOfertas.add(novaOferta);
					}
				}
			}
		}

		ofertaRepository.save(novasOfertas);
	}

}