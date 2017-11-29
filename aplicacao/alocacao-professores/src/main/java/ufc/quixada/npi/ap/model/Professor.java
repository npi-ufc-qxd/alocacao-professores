package ufc.quixada.npi.ap.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Professor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String apelido;
	
	private Integer cargaHorariaMinima;
	
	private Integer cargaHorariaMaxima;
	
	@Transient
	private Integer cargaHorariaAtual;
	
	@OneToOne(optional = false, cascade = CascadeType.MERGE)
	private Pessoa pessoa;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getApelido() {
		return apelido;
	}

	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	public Integer getCargaHorariaMinima() {
		return cargaHorariaMinima;
	}
	
	public void setCargaHorariaMinima(Integer cargaHorariaMinima) {
		this.cargaHorariaMinima = cargaHorariaMinima;
	}
	
	public Integer getCargaHorariaMaxima() {
		return cargaHorariaMaxima;
	}
	
	public void setCargaHorariaMaxima(Integer cargaHorariaMaxima) {
		this.cargaHorariaMaxima = cargaHorariaMaxima;
	}
	
	public Pessoa getPessoa() {
		return pessoa;
	}
	
	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public Integer getCargaHorariaAtual() {
		return cargaHorariaAtual;
	}
	
	public void setCargaHorariaAtual(Integer cargaHorariaAtual) {
		this.cargaHorariaAtual = cargaHorariaAtual;
	}
}
