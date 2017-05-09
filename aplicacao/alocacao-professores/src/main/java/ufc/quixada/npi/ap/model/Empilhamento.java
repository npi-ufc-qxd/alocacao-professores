package ufc.quixada.npi.ap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Empilhamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	private Turma primeiraTurma;
	
	@ManyToOne
	private Disciplina primeiraDisciplina;
	
	@OneToOne
	private Turma segundaTurma;
	
	@ManyToOne
	private Disciplina segundaDisciplina;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Turma getPrimeiraTurma() {
		return primeiraTurma;
	}

	public void setPrimeiraTurma(Turma primeiraTurma) {
		this.primeiraTurma = primeiraTurma;
	}

	public Disciplina getPrimeiraDisciplina() {
		return primeiraDisciplina;
	}

	public void setPrimeiraDisciplina(Disciplina primeiraDisciplina) {
		this.primeiraDisciplina = primeiraDisciplina;
	}

	public Turma getSegundaTurma() {
		return segundaTurma;
	}

	public void setSegundaTurma(Turma segundaTurma) {
		this.segundaTurma = segundaTurma;
	}

	public Disciplina getSegundaDisciplina() {
		return segundaDisciplina;
	}

	public void setSegundaDisciplina(Disciplina segundaDisciplina) {
		this.segundaDisciplina = segundaDisciplina;
	}
	
}
