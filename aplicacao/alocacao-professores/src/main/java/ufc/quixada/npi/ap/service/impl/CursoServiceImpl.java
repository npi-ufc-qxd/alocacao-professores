package ufc.quixada.npi.ap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Pessoa;
import ufc.quixada.npi.ap.repository.CursoRepository;
import ufc.quixada.npi.ap.service.CursoService;

@Service
public class CursoServiceImpl implements CursoService {

	@Autowired
	private CursoRepository cursoRepository;
	
	@Override
	public Curso buscarCurso(Integer id) {
		return cursoRepository.findOne(id);
	}

	@Override
	public List<Curso> buscarTodosCursos() {
		return cursoRepository.findAll();
	}

	@Override
	public Curso buscarCursoPorCoordenador(Pessoa pessoa) {
		return cursoRepository.findCursoByCoordenador_pessoa(pessoa);
	}
}
