package ufc.quixada.npi.ap.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	
	public enum Semestre {
		PRIMEIRO("1º", "1"), SEGUNDO("2º", "2"), TERCEIRO("3º", "3"), QUARTO("4º", "4"), QUINTO("5º", "5"), SEXTO("6º", "6"),
		SETIMO("7º", "7"), OITAVO("8º", "8"), NONO("9º", "9"), DECIMO("10º", "10"), DECIMOPRIMEIRO("11º", "11"), DECIMOSEGUNDO("12º", "12");
		
		private String descricao;
		private String numero;

		Semestre(String descricao, String numero){
			this.descricao = descricao;
			this.numero = numero;
		}

		public String getDescricao() {
			return descricao;
		}

		public String getNumero() {
			return numero;
		}
	}
}
