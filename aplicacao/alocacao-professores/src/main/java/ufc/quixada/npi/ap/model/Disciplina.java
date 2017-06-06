package ufc.quixada.npi.ap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Disciplina {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;

	private String codigo;

	private int creditos;
	
	private int cargaHorariaTeorica;
	
	private int cargaHorariaPratica;
	
	private boolean arquivada;	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public int getCargaHorariaTeorica() {
		return cargaHorariaTeorica;
	}

	public void setCargaHorariaTeorica(int cargaHorariaTeorica) {
		this.cargaHorariaTeorica = cargaHorariaTeorica;
	}

	public int getCargaHorariaPratica() {
		return cargaHorariaPratica;
	}

	public void setCargaHorariaPratica(int cargaHorariaPratica) {
		this.cargaHorariaPratica = cargaHorariaPratica;
	}

	public boolean getArquivada() {
		return arquivada;
	}

	public void setArquivada(boolean arquivada) {
		this.arquivada = arquivada;
	}
	
}
