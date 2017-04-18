package ufc.quixada.npi.ap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.quixada.npi.ap.model.Empilhamento;
import ufc.quixada.npi.ap.repository.EmpilhamentoRepository;
import ufc.quixada.npi.ap.service.EmpilhamentoService;

@Service
public class EmpilhamentoServiceImpl implements EmpilhamentoService {

	@Autowired
	EmpilhamentoRepository empilhamentoRepository;
	
	//@Autowired
	//DisciplinaRepository disciplinaRepository;
	
	//@Autowired
	//TurmaRespository turmaRepository;
	
	@Override
	public Empilhamento cadastarEmpilhamento(Integer idTurmaA, Integer idDisciplinaA, Integer idTurmaB, Integer idDisciplinaB) {
		Empilhamento empilhamento = new Empilhamento();
		
	/*	Turma turmaA = turmaRepository.findOne(idTurmaA);
		Turma turmaB = turmaRepository.findOne(idTurmaB);
		Disciplina disciplinaA = disciplinaRepository.findOne(idDisciplinaA);
		Disciplina disciplinaB = disciplinaRepository.findOne(idDisciplinaB);
		
		empilhamento.setTurmaA(turmaA);
		empilhamento.setTurmaB(turmaB);
		empilhamento.setDisciplinaA(disciplinaA);
		empilhamento.setDisciplinaB(disciplinaB);*/
		
		return empilhamentoRepository.save(empilhamento);
	}

	@Override
	public List<Empilhamento> listarEmpilhamentos() {
		//return (List<Empilhamento>) empilhamentoRepository.findAll();
		return null;
	}

	@Override
	public void excluirEmpilhamento(Integer idEmpilhamento) {
		//empilhamentoRepository.delete(idEmpilhamento);
	}

	@Override
	public Empilhamento visualizarEmpilhamento(Integer idEmpilhamento) {
		//return empilhamentoRepository.findOne(idEmpilhamento);
		return null;
	}

}
