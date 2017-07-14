package ufc.quixada.npi.ap.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Oferta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private int vagas;

	public enum Turno {
		MANHA("Manhã"), TARDE("Tarde"), NOITE("Noite"), MESMO_DIA("Mesmo dia");

		private String descricao;

		Turno(String descricao) {
			this.descricao = descricao;
		}

		public String getDescricao() {
			return descricao;
		}
	}

	private String observacao;

	@ManyToOne
	@JoinColumn(name = "disciplina_id")
	private Disciplina disciplina;

	@ManyToOne
	@JoinColumn(name = "turma_id")
	@JsonIgnore
	private Turma turma;

	@ManyToOne
	@JoinColumn(name = "periodo_id")
	@JsonIgnore
	private Periodo periodo;

	@Enumerated(EnumType.STRING)
	private Turno turno;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "professor_oferta", joinColumns = @JoinColumn(name = "oferta_id"), inverseJoinColumns = @JoinColumn(name = "professor_id"))
	@JsonIgnore
	private List<Professor> professores;

	@OneToMany(mappedBy = "oferta")
	private List<Compartilhamento> compartilhamentos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getVagas() {
		return vagas;
	}

	public void setVagas(int vagas) {
		this.vagas = vagas;
	}

	public String getObservacao() {
		return null == observacao ? " " : this.observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Periodo getPeriodo() {
		return periodo;
	}

	public void setPeriodo(Periodo periodo) {
		this.periodo = periodo;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public List<Professor> getProfessores() {
		if (null == this.professores) {
			this.professores = new ArrayList<>();
		}
		return this.professores;
	}

	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}

	public List<Compartilhamento> getCompartilhamentos() {
		if (null == this.compartilhamentos) {
			this.compartilhamentos = new ArrayList<>();
		}
		return this.compartilhamentos;
	}

	public void setCompartilhamentos(List<Compartilhamento> compartilhamentos) {
		this.compartilhamentos = compartilhamentos;
	}

	public Compartilhamento getCompartilhamentoPorCurso(String sigla) {
		for (Compartilhamento compartilhamento : this.compartilhamentos) {
			if (compartilhamento.getTurma().getCurso().getSigla().equals(sigla)) {
				return compartilhamento;
			}
		}

		return null;
	}

}
