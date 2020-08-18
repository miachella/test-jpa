package banque.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BANQUE")
public class Banque {
	
	@Column(name="NOM", length=50, nullable=false)
	private String nom;

}
