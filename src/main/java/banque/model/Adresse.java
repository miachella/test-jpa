package banque.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Adresse {
	
	@Column(name="NUMERO",  nullable=false)
	private int numero;
	
	@Column(name="RUE", length=50, nullable=false)
	private String rue;
	
	@Column(name="CODE_POSTAL", length=50, nullable=false)
	private String codePostal;

	@Column(name="VILLE", length=50, nullable=false)
	private String ville;
	
	
}
