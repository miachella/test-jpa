package biblio.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CLIENT")
public class Client {
	
	@Id
	private int id;
	
	@Column(name="NOM", length=50, nullable=false)
	private String nom;
	
	@Column(name="PRENOM", length=50, nullable=false)
	private String prenom;
	
	@OneToMany(mappedBy="idClient")
	private List<Emprunt> listEmprunt;

	public Client() {
		super();
	}

	@Override
	public String toString() {
		return "Client " + id + "[nom=" + nom + ", prenom=" + prenom + ", emprunt=" + listEmprunt + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public List<Emprunt> getListEmprunt() {
		return listEmprunt;
	}

	public void setListEmprunt(List<Emprunt> listEmprunt) {
		this.listEmprunt = listEmprunt;
	}

}
