package ufc.quixada.npi.ap.service;

import java.util.List;

import ufc.quixada.npi.ap.model.Curso;
import ufc.quixada.npi.ap.model.Pessoa;

public interface CursoService {

	public List<Curso> buscarTodosCursos();
	
	public Curso buscarCursoPorCoordenador(Pessoa pessoa);

}
