package ufc.quixada.npi.ap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 INSERT INTO public.disciplina (carga_Horaria_Pratica, carga_Horaria_Teorica, codigo, nome, creditos) VALUES ( 0, 0, 'QXD0095', 'PROJETO INTEGRADO EM REDES DE COMPUTADORES', 0); 
 */

@Entity
public class Disciplina {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private int creditos;
	
	private int cargaHorariaTeorica;
	
	private int cargaHorariaPratica;
	
	String codigo;
	
	String nome;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
