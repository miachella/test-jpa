package biblio.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="EMPRUNT")
public class Emprunt {
	
	@Id
	@Column(name="ID")
	private int id;
	
	@Column(name="DATE_DEBUT", nullable=false)
    @Temporal(TemporalType.DATE)
    private Date dateDebut ;
	
	@Column(name="DELAI")
	private int dalai;
	
	@Column(name="DATE_FIN")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
	
	@ManyToOne
	@JoinColumn(name="ID_CLIENT")
	private Client idClient;
	
	@ManyToMany
	@JoinTable(name="COMPO", 
			joinColumns=@JoinColumn(name="ID_EMP"), 
			inverseJoinColumns=@JoinColumn(name="ID_LIV"))
	private Set<Livre> livres;

	public Emprunt() {
		super();
	}

	@Override
	public String toString() {
		return "Emprunt " + id + "[dateDebut=" + dateDebut + ", dalai=" + dalai + ", dateFin=" + dateFin
				+ ", livres associés " + livres + "]";
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public int getDalai() {
		return dalai;
	}

	public void setDalai(int dalai) {
		this.dalai = dalai;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public Client getIdClient() {
		return idClient;
	}

	public void setIdClient(Client idClient) {
		this.idClient = idClient;
	}

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}
	
	

}
