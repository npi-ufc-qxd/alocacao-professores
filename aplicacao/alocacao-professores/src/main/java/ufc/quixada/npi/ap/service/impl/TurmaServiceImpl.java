package ufc.quixada.npi.ap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.quixada.npi.ap.model.Turma;
import ufc.quixada.npi.ap.repository.TurmaRepository;
import ufc.quixada.npi.ap.service.TurmaService;

@Service
public class TurmaServiceImpl implements TurmaService {

	@Autowired
	private TurmaRepository turmaRepository;
	
	@Override
	public List<Turma> listarTurmas() {
		return turmaRepository.findAll();
	}

}
