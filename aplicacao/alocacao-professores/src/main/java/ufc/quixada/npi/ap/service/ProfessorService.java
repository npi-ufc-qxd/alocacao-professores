package ufc.quixada.npi.ap.service;

import java.util.List;

import ufc.quixada.npi.ap.model.Professor;

public interface ProfessorService {
	public Professor findProfessor(Integer id);

	public List<Professor> findAllProfessores();

}

