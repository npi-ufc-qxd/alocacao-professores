package ufc.quixada.npi.ap.model;

import java.util.ArrayList;
import java.util.List;

public class RelatorioCargaHorariaProfessor {
	private List<Professor> professoresCargaHorariaInsuficiente;
	private List<Professor> professoresCargaHorariaNormal;
	private List<Professor> professoresCargaHorariaExcedida;
	
	public RelatorioCargaHorariaProfessor() {
		this.professoresCargaHorariaInsuficiente = new ArrayList<>();
		this.professoresCargaHorariaNormal = new ArrayList<>();
		this.professoresCargaHorariaExcedida = new ArrayList<>();
	}
	
	public void addProfessorCargaHorariaInsuficiente(Professor professor){
		this.professoresCargaHorariaInsuficiente.add(professor);
	}
	
	public void addProfessorCargaHorariaNormal(Professor professor){
		this.professoresCargaHorariaNormal.add(professor);
	}
	
	public void addProfessorCargaHorariaExcedida(Professor professor){
		this.professoresCargaHorariaExcedida.add(professor);
	}
	
	public List<Professor> getProfessoresCargaHorariaInsuficiente() {
		return professoresCargaHorariaInsuficiente;
	}
	
	public List<Professor> getProfessoresCargaHorariaNormal() {
		return professoresCargaHorariaNormal;
	}
	
	public List<Professor> getProfessoresCargaHorariaExcedida() {
		return professoresCargaHorariaExcedida;
	}
}
