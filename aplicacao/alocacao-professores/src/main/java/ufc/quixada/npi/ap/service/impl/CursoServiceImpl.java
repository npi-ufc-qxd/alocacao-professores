package ufc.quixada.npi.ap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Pessoa;
import ufc.quixada.npi.ap.model.Professor;
import ufc.quixada.npi.ap.repository.CursoRepository;
import ufc.quixada.npi.ap.repository.ProfessorRepository;
import ufc.quixada.npi.ap.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private ProfessorRepository professorRepository;

	@Override
	public List<Curso> listar() {
		return cursoRepository.findAll();
	}

	@Override
	public Curso buscarPorCoordenador(Pessoa pessoa) {
		Professor coordenador = professorRepository.findByPessoa(pessoa);
		Curso curso = cursoRepository.findByCoordenador(coordenador);
		
		if(null == curso) {
			curso = cursoRepository.findByViceCoordenador(coordenador);
		}
		
		return curso;
	}

	@Override
	public Curso buscarPorSigla(String sigla) {
		return cursoRepository.findBySigla(sigla);
	}

	@Override
	public Curso buscarPorOferta(Integer idOferta) {
		return cursoRepository.findByOferta(idOferta);
	}

}
