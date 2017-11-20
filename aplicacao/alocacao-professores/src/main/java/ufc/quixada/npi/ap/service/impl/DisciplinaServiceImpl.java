package ufc.quixada.npi.ap.service.impl;

import static ufc.quixada.npi.ap.util.Constants.MSG_DISCIPLINA_CADASTRAR_EXISTENTE;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.quixada.npi.ap.exception.AlocacaoProfessorException;
import ufc.quixada.npi.ap.model.Disciplina;
import ufc.quixada.npi.ap.repository.DisciplinaRepository;
import ufc.quixada.npi.ap.service.DisciplinaService;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Override
	public List<Disciplina> buscarTodasDisciplinas() {
		return disciplinaRepository.findAll();
	}

	@Override
	public void salvar(Disciplina disciplina) throws AlocacaoProfessorException {
		Disciplina disciplinaRecuperada = disciplinaRepository.findDisciplinaByCodigo(disciplina.getCodigo());	
		
		if(disciplinaRecuperada != null) {
			throw new AlocacaoProfessorException(MSG_DISCIPLINA_CADASTRAR_EXISTENTE);
		}
		
		disciplina.setNome(disciplina.getNome().toUpperCase());
		
		disciplinaRepository.save(disciplina);
	}
	
	@Override
	public void editar(Disciplina disciplina) {
		disciplina.setNome(disciplina.getNome().toUpperCase());
		disciplinaRepository.save(disciplina);
	}

	@Override
	public List<Disciplina> buscarDisciplinasNaoArquivadas() {
		return disciplinaRepository.findDisciplinaByArquivadaFalse();
	}

	@Override
	public boolean arquivarDisciplina(Integer id) {
		Disciplina disciplina = disciplinaRepository.findOne(id);
		if (disciplina == null) {
			return false;
		}
		disciplina.setArquivada(true);
		disciplinaRepository.save(disciplina);

		return true;
	}

	@Override
	public Disciplina buscarDisciplina(Integer id) {
		return disciplinaRepository.findOne(id);
	}

}