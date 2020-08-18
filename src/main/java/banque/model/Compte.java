package banque.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="COMPTE")
public class Compte {
	
	@Column(name="NUMERO", length=50, nullable=false)
	private String numero;
	
	@Column(name="SOLDE", nullable=false)
	private double solde;

}
