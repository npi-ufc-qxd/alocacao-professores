package ufc.quixada.npi.ap.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Periodo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String ano;
	
	@Enumerated(EnumType.STRING)
	private Semestre semestre;

	@Enumerated(EnumType.STRING)
	private Status status;

	@OneToMany(mappedBy = "periodo")
	private List<Oferta> ofertas;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy", iso = ISO.DATE)
	private Date inicioPeriodoCoordenacao;

	@DateTimeFormat(pattern = "dd/MM/yyyy", iso = ISO.DATE)
	private Date fimPeriodoCoordenacao;

	@DateTimeFormat(pattern = "dd/MM/yyyy", iso = ISO.DATE)
	private Date inicioPeriodoDirecao;

	@DateTimeFormat(pattern = "dd/MM/yyyy", iso = ISO.DATE)
	private Date fimPeriodoDirecao;

	@DateTimeFormat(pattern = "dd/MM/yyyy", iso = ISO.DATE)
	private Date inicioPeriodoAjuste;

	@DateTimeFormat(pattern = "dd/MM/yyyy", iso = ISO.DATE)
	private Date fimPeriodoAjuste;
	
	private Boolean ativo;

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Date getInicioPeriodoCoordenacao() {
		return inicioPeriodoCoordenacao;
	}

	public void setInicioPeriodoCoordenacao(Date inicioPeriodoCoordenacao) {
		this.inicioPeriodoCoordenacao = inicioPeriodoCoordenacao;
	}

	public Date getFimPeriodoCoordenacao() {
		return fimPeriodoCoordenacao;
	}

	public void setFimPeriodoCoordenacao(Date fimPeriodoCoordenacao) {
		this.fimPeriodoCoordenacao = fimPeriodoCoordenacao;
	}

	public Date getInicioPeriodoDirecao() {
		return inicioPeriodoDirecao;
	}

	public void setInicioPeriodoDirecao(Date inicioPeriodoDirecao) {
		this.inicioPeriodoDirecao = inicioPeriodoDirecao;
	}

	public Date getFimPeriodoDirecao() {
		return fimPeriodoDirecao;
	}

	public void setFimPeriodoDirecao(Date fimPeriodoDirecao) {
		this.fimPeriodoDirecao = fimPeriodoDirecao;
	}

	public Date getInicioPeriodoAjuste() {
		return inicioPeriodoAjuste;
	}

	public void setInicioPeriodoAjuste(Date inicioPeriodoAjuste) {
		this.inicioPeriodoAjuste = inicioPeriodoAjuste;
	}

	public Date getFimPeriodoAjuste() {
		return fimPeriodoAjuste;
	}

	public void setFimPeriodoAjuste(Date fimPeriodoAjuste) {
		this.fimPeriodoAjuste = fimPeriodoAjuste;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public Semestre getSemestre() {
		return semestre;
	}

	public void setSemestre(Semestre semestre) {
		this.semestre = semestre;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public List<Oferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(List<Oferta> ofertas) {
		this.ofertas = ofertas;
	}

	public enum Status {
		ABERTO("Aberto"), EM_ANALISE("Em análise"), CONSOLIDADO("Consolidado");

		private String descricao;

		Status(String descricao) {
			this.descricao = descricao;
		}

		public String getDescricao() {
			return descricao;
		}
	}

	public enum Semestre {
		PRIMEIRO("1º"), SEGUNDO("2º");
		
		private String descricao;

		Semestre(String descricao){
			this.descricao = descricao;
		}

		public String getDescricao() {
			return descricao;
		}
	}
}
