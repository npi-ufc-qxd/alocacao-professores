package ufc.quixada.npi.ap.model;

import java.util.ArrayList;
import java.util.Collections;
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
	
	public void adicionarProfessorCargaHorariaInsuficiente(Professor professor){
		this.professoresCargaHorariaInsuficiente.add(professor);
	}
	
	public void adicionarProfessorCargaHorariaNormal(Professor professor){
		this.professoresCargaHorariaNormal.add(professor);
	}
	
	public void adicionarProfessorCargaHorariaExcedida(Professor professor){
		this.professoresCargaHorariaExcedida.add(professor);
	}
	
	public List<Professor> getProfessoresCargaHorariaInsuficiente() {
		return Collections.unmodifiableList(professoresCargaHorariaInsuficiente);
	}
	
	public List<Professor> getProfessoresCargaHorariaNormal() {
		return Collections.unmodifiableList(professoresCargaHorariaNormal);
	}
	
	public List<Professor> getProfessoresCargaHorariaExcedida() {
		return Collections.unmodifiableList(professoresCargaHorariaExcedida);
	}
}
