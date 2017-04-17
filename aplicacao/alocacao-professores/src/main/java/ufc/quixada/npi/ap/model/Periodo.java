package ufc.quixada.npi.ap.model;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Periodo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String ano;
	
	private String semestre;
	
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
	
	

	enum Status{
		ABERTA("Aberta"), EM_ANALISE("Em análise"), CONSOLIDADA("consolidada");
		
		private String nome;
		private static Map<Status, String> map;
		
		Status(String nome){
			this.nome = nome;
		}
		
		public Map<Status, String> toMap(){
			if (map == null){
				map = new TreeMap<Status, String>();
				
				for (Status s : Status.values())
					map.put(s, s.nome);
			}
			
			return map;
		}
	}
}
