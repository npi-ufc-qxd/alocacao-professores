package ufc.quixada.npi.ap.model;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

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

@Entity
public class Oferta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private int vagas;
	
	private String observacao;
	
	@ManyToOne
	private Disciplina disciplina;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "professor_oferta", joinColumns = @JoinColumn(name = "oferta_id"), inverseJoinColumns = @JoinColumn(name = "professor_id"))
	private List<Professor> professores;
	
	@ManyToOne
	private Turma turma;
	
	// Tirar duvida com o líder de projeto sobre Turma e Oferta
	
	@Enumerated(EnumType.STRING)
	private Turno turno;
	
	// TODO: compartilhamentos

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
		return observacao;
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


	public List<Professor> getProfessores() {
		return professores;
	}


	public void setProfessores(List<Professor> professores) {
		this.professores = professores;
	}	
	

	public Turma getTurma() {
		return turma;
	}


	public void setTurma(Turma turma) {
		this.turma = turma;
	}


	public Turno getTurno() {
		return turno;
	}


	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	enum Turno{
		MANHA("Manhã"), TARDE("Tarde"), NOITE("Noite"), MESMO_DIA("Mesmo dia");
		
		private String nome;
		private static Map<Turno, String> map;
		
		Turno(String nome){
			this.nome = nome;
		}
		
		public static Map<Turno, String> toMap() {
			if (map == null) {
				map = new TreeMap<Turno, String>(); // Usar TreeMap para ficar ordenado
				
				for (Turno c : Turno.values()) {
					map.put(c, c.nome);
				}
			}
			
			return map;
		}
	}
}
