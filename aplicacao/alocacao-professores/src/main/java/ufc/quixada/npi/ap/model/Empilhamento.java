package ufc.quixada.npi.ap.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Empilhamento {
	@Id 
	@GeneratedValue
	@Column(name = "id")
	private int id;
}
