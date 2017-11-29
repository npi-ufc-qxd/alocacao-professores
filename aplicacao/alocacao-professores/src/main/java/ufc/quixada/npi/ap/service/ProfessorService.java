package ufc.quixada.npi.ap.service;

import java.util.List;

import ufc.quixada.npi.ap.model.Professor;
import ufc.quixada.npi.ap.model.RelatorioCargaHorariaProfessor;

public interface ProfessorService {
	
	public Professor salvar(Professor professor);
	
	public Professor buscarProfessor(Integer id);

	public List<Professor> buscarTodosProfessores();
	
	public RelatorioCargaHorariaProfessor gerarRelatorioCargaHorariaProfessores();
	
}

