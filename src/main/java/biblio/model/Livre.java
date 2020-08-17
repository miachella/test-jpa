package biblio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LIVRE")
public class Livre {
	
	@Id
	private int id ;
	
	@Column(name="TITRE", length=255, nullable=false)
	private String titre;

	@Column(name="AUTEUR", length=50, nullable=false)
	private String auteur;
	
	public Livre() {
		super();
	}
	

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + ", auteur=" + auteur + "]";
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getAuteur() {
		return auteur;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	
	

}
