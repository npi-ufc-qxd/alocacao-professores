package ufc.quixada.npi.ap.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
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

	private Integer vagas;
	
	private boolean mesmoDia;
	
	private Integer aulasEmLaboratorio;
	
	private Integer numeroProfessores;
	
	
	public enum Turno {
		MANHA("Manhã"), TARDE("Tarde"), NOITE("Noite");

		private String descricao;

		Turno(String descricao) {
			this.descricao = descricao;
		}

		public String getDescricao() {
			return descricao;
		}
	}
	
	public enum HorarioInicio{
		AB("AB"),CD("CD");
		
		private String descricao;
		
		HorarioInicio(String descricao){
			this.descricao = descricao;
		}
		
		public String getDescricao(){
			return descricao;
		}
	}
	

	private String observacao;

	@ManyToOne
	@JoinColumn(name = "disciplina_id")
	private Disciplina disciplina;

	@ManyToOne
	@JoinColumn(name = "turma_id")
	private Turma turma;

	@ManyToOne
	@JoinColumn(name = "periodo_id")
	private Periodo periodo;

	@Enumerated(EnumType.STRING)
	private Turno turno;
	
	@Enumerated(EnumType.STRING)
	private HorarioInicio horarioInicio;

	@ManyToMany
	@JoinTable(name = "professor_oferta", joinColumns = @JoinColumn(name = "oferta_id"), inverseJoinColumns = @JoinColumn(name = "professor_id"))
	private List<Professor> professores;

	@OneToMany(mappedBy = "oferta")
	@JsonIgnore
	private List<Compartilhamento> compartilhamentos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVagas() {
		return vagas;
	}

	public void setVagas(Integer vagas) {
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

	public boolean isMesmoDia() {
		return mesmoDia;
	}

	public void setMesmoDia(boolean mesmoDia) {
		this.mesmoDia = mesmoDia;
	}

	public Integer getAulasEmLaboratorio() {
		return aulasEmLaboratorio;
	}

	public void setAulasEmLaboratorio(Integer aulasEmLaboratorio) {
		this.aulasEmLaboratorio = aulasEmLaboratorio;
	}

	public HorarioInicio getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(HorarioInicio horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	
	public Integer getNumeroProfessores() {
		return numeroProfessores;
	}

	public void setNumeroProfessores(Integer numeroProfessores) {
		this.numeroProfessores = numeroProfessores;
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

	public int getTotalVagas() {
		int totalVagas = this.vagas;

		for (Compartilhamento compartilhamento : getCompartilhamentos()) {
			totalVagas += compartilhamento.getVagas();
		}

		return totalVagas;
	}

}
