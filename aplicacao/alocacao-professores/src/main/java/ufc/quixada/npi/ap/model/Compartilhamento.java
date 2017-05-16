package ufc.quixada.npi.ap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Compartilhamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull(message = "O campo Vagas não pode ser nulo!")
	@Min(value = 1, message = "O valor do campo Vagas deve ser maior que 0!")
	private int vagas;
	
	@NotNull(message = "O campo Turma não pode ser nulo!")
	@ManyToOne
	@JoinColumn(name = "turma_id")
	private Turma turma;
	
	@NotNull(message = "O campo Oferta não pode ser nulo!")
	@ManyToOne
	@JoinColumn(name = "oferta_id")
	private Oferta oferta;
	
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

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}
}
