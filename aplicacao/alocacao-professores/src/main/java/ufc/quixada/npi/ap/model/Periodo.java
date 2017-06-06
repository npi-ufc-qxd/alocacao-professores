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

@Entity
public class Periodo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	private String ano;
	
	private String semestre;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date inicioPeriodoCoordenacao;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fimPeriodoCoordenacao;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date inicioPeriodoDirecao;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fimPeriodoDirecao;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date inicioPeriodoAjuste;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date fimPeriodoAjuste;
	
	
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

	@Enumerated(EnumType.STRING)
	private Status status;
	
	@OneToMany(mappedBy = "periodo")
	private List<Oferta> ofertas;

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

	public String getSemestre() {
		return semestre;
	}

	public void setSemestre(String semestre) {
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
	
	public enum Status{
		ABERTA("Aberta"), EM_ANALISE("Em análise"), CONSOLIDADA("consolidada");
		
		private String descricao;
		
		Status(String descricao){
			this.descricao = descricao;
		}

		public String getDescricao() {
			return descricao;
		}		
	}	
}
