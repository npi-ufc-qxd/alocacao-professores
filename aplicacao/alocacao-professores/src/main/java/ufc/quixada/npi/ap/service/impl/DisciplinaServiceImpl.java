package ufc.quixada.npi.ap.service.impl;

import static ufc.quixada.npi.ap.util.Constants.DISCIPLINA_CADASTRAR_EXISTENTE;

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

	@Override
	public void salvar(Disciplina disciplina) throws Exception {
		Disciplina disciplinaRecuperada = disciplinaRepository.findByCodigo(disciplina.getCodigo());	
		
		if(disciplinaRecuperada != null) {
			throw new Exception(DISCIPLINA_CADASTRAR_EXISTENTE);
		}
		
		disciplinaRepository.save(disciplina);

	}
	
	@Override
	public void editar(Disciplina disciplina) {
		disciplinaRepository.save(disciplina);
	}

	@Override
	public List<Disciplina> listarNaoArquivada() {
		return disciplinaRepository.findByArquivadaFalse();
	}

	@Override
	public boolean arquivarDisciplina(Integer id) {
		Disciplina disciplina = disciplinaRepository.findById(id);
		if (disciplina == null) {
			return false;
		}
		disciplina.setArquivada(true);
		disciplinaRepository.save(disciplina);

		return true;
	}

	@Override
	public Disciplina findDisciplina(Integer id) {
		return disciplinaRepository.findOne(id);
	}

}