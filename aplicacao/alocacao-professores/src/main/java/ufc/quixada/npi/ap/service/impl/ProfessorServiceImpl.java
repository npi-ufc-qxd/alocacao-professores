package ufc.quixada.npi.ap.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ufc.quixada.npi.ap.model.Oferta;
import ufc.quixada.npi.ap.model.Professor;
import ufc.quixada.npi.ap.model.RelatorioCargaHorariaProfessor;
import ufc.quixada.npi.ap.repository.ProfessorRepository;
import ufc.quixada.npi.ap.service.OfertaService;
import ufc.quixada.npi.ap.service.ProfessorService;

@Service
public class ProfessorServiceImpl implements ProfessorService{

	@Autowired
	private ProfessorRepository professorRepository;
	
	@Autowired
	private OfertaService ofertaService;
	
	@Override
	public Professor salvar(Professor professor) {
		return professorRepository.save(professor);
	}
	
	@Override
	public Professor buscarProfessor(Integer id) {
		return professorRepository.findOne(id);
	}
	
	@Override
	public List<Professor> buscarTodosProfessores() {
		return professorRepository.findAll();
	}
	
	@Override
	public RelatorioCargaHorariaProfessor gerarRelatorioCargaHorariaProfessores() {
		RelatorioCargaHorariaProfessor relatorio = new RelatorioCargaHorariaProfessor();
		
		List<Professor> professores = professorRepository.findAll();
		
		for (Professor professor : professores){
			List<Oferta> ofertasProfessor = ofertaService.buscarOfertasPeriodoAtivoPorProfessor(professor);
			
			Integer cargaHorariaAtual = 0;
			
			for (Oferta o : ofertasProfessor){
				cargaHorariaAtual += o.getDisciplina().getCreditos();
			}
			
			professor.setCargaHorariaAtual(cargaHorariaAtual);
			
			if (professor.getCargaHorariaAtual() < professor.getCargaHorariaMinima()){
				relatorio.addProfessorCargaHorariaInsuficiente(professor);
			}
			else if (professor.getCargaHorariaAtual() > professor.getCargaHorariaMaxima()){
				relatorio.addProfessorCargaHorariaExcedida(professor);
			}
			else{
				relatorio.addProfessorCargaHorariaNormal(professor);
			}
		}
		
		return relatorio;
	}
}