package ufc.quixada.npi.ap.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.quixada.npi.ap.model.Disciplina;
import ufc.quixada.npi.ap.repository.DisciplinaRepository;
import ufc.quixada.npi.ap.service.DisciplinaService;

@Service
public class DisciplinaServiceImpl implements DisciplinaService{

	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Override
	public void salvar(Disciplina disciplina) {
		disciplinaRepository.save(disciplina);
	
	}

	@Override
	public void atualizar(Disciplina disciplina) {
		
		disciplinaRepository.save(disciplina);
		
	}

}
