package banque.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CLIENT")
public class Client {
	
	@Column(name="NOM", length=50, nullable=false)
	private String nom;
	
	@Column(name="PRENOM", length=50, nullable=false)
	private String prenom;
	
	@Column(name="DATE_NAISSANCE", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date dateNaissance ;
	
	@Embedded
	private Adresse adresse;

}
