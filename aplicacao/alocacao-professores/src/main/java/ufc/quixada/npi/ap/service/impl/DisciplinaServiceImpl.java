package ufc.quixada.npi.ap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.quixada.npi.ap.model.Disciplina;
import ufc.quixada.npi.ap.repository.DisciplinaRepository;
import ufc.quixada.npi.ap.service.DisciplinaService;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Override
	public List<Disciplina> listar() {	
		
		return disciplinaRepository.findAll();
		
	}
	
	
}
