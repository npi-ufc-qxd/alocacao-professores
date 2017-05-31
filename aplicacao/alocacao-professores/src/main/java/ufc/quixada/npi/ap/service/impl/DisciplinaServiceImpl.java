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
	
	public void salvar(Disciplina disciplina) {
		disciplinaRepository.save(disciplina);


	}

	@Override
	public List<Disciplina> listarNaoArquivada() {

		return disciplinaRepository.findByArquivarFalse();

	}

	@Override
	public boolean arquivarDisciplina(Integer id) {

		Disciplina disciplina = disciplinaRepository.findById(id);

		if (disciplina == null) {
			return false;
		}

		disciplina.setArquivar(true);
		disciplinaRepository.save(disciplina);

		return true;
	}
}
