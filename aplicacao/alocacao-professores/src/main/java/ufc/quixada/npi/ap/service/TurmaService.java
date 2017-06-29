package ufc.quixada.npi.ap.service;

import java.util.List;

import ufc.quixada.npi.ap.model.Turma;

public interface TurmaService {
	
	public List<Turma> listarTurmas();
	
	public Turma findTurma(Integer id);
}