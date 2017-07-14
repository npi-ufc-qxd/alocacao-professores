package ufc.quixada.npi.ap.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Turma {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;
	
	@Enumerated(EnumType.STRING)
	private Semestre semestre;
	
	@OneToMany(mappedBy = "turma")
	@JsonIgnore
	private List<Compartilhamento> compartilhamentos;

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public List<Compartilhamento> getCompartilhamentos() {
		return compartilhamentos;
	}

	public void setCompartilhamentos(List<Compartilhamento> compartilhamentos) {
		this.compartilhamentos = compartilhamentos;
	}	
	
	public enum Semestre {
		PRIMEIRO("1º"), SEGUNDO("2º"), TERCEIRO("3°"), QUARTO("4°"), QUINTO("5°"), SEXTO("6°"),
		SETIMO("7°"), OITAVO("8°"), NONO("9°"), DECIMO("10°"), DECIMOPRIMEIRO("11°"), DECIMOSEGUNDO("12°");
		
		private String descricao;

		Semestre(String descricao){
			this.descricao = descricao;
		}

		public String getDescricao() {
			return descricao;
		}
	}
}
