package ufc.quixada.npi.ap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.quixada.npi.ap.model.Professor;
import ufc.quixada.npi.ap.repository.ProfessorRepository;
import ufc.quixada.npi.ap.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService{

	@Autowired
	private ProfessorRepository professorRepository;
	
	@Override
	public Professor buscarProfessor(Integer id) {
		return professorRepository.findOne(id);
	}
	
	@Override
	public List<Professor> buscarTodosProfessores() {
		return professorRepository.findAll();
	}
	
	@Override
	public Professor salvar(Professor professor) {
		return professorRepository.save(professor);
	}
}