package ufc.quixada.npi.ap.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
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

	private boolean horarioInicio;
	
	private boolean turnoManha;
	
	private boolean turnoTarde;
	
	private boolean turnoNoite;
	
	private boolean turnoLivre;

	@ManyToMany
	@JoinTable(name = "professor_oferta", joinColumns = @JoinColumn(name = "oferta_id"), inverseJoinColumns = @JoinColumn(name = "professor_id"))
	private List<Professor> professores;

	@OneToMany(mappedBy = "oferta", cascade = {CascadeType.REMOVE, CascadeType.MERGE})
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

	public boolean isMesmoDia() {
		return mesmoDia;
	}

	public void setMesmoDia(boolean mesmoDia) {
		this.mesmoDia = mesmoDia;
	}

	public Integer getAulasEmLaboratorio() {
		return aulasEmLaboratorio == null ? 0 : aulasEmLaboratorio;
	}

	public void setAulasEmLaboratorio(Integer aulasEmLaboratorio) {
		this.aulasEmLaboratorio = aulasEmLaboratorio;
	}

	public boolean getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(boolean horarioInicio) {
		this.horarioInicio = horarioInicio;
	}
	
	public Integer getNumeroProfessores() {
		return numeroProfessores == null ? 0 : numeroProfessores;
	}

	public void setNumeroProfessores(Integer numeroProfessores) {
		this.numeroProfessores = numeroProfessores;
	}
	
	public boolean isTurnoManha() {
		return turnoManha;
	}

	public void setTurnoManha(boolean turnoManha) {
		this.turnoManha = turnoManha;
	}

	public boolean isTurnoTarde() {
		return turnoTarde;
	}

	public void setTurnoTarde(boolean turnoTarde) {
		this.turnoTarde = turnoTarde;
	}

	public boolean isTurnoNoite() {
		return turnoNoite;
	}

	public void setTurnoNoite(boolean turnoNoite) {
		this.turnoNoite = turnoNoite;
	}

	public boolean isTurnoLivre() {
		return turnoLivre;
	}

	public void setTurnoLivre(boolean turnoLivre) {
		this.turnoLivre = turnoLivre;
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
	
	public String getCompartilhamentoIndice(int indice) {
		if(getCompartilhamentos().size() == indice + 1) {
			return "" + getCompartilhamentos().get(indice).getTurma().getCurso().getSigla() + "-" + getCompartilhamentos().get(indice).getTurma().getSemestre().getNumero();
		}
		return "";
	}
	
	/*public String getSlot() {
		return turno.descricao + " " + (disciplina.getCreditos() / 2) + " aula(s)";
	}*/

	public int getTotalVagas() {
		int totalVagas = this.vagas;

		for (Compartilhamento compartilhamento : getCompartilhamentos()) {
			totalVagas += compartilhamento.getVagas();
		}

		return totalVagas;
	}
	
}
