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
	private int idClient;
	
	@ManyToMany
	@JoinTable(name="COMPO", 
			joinColumns=@JoinColumn(name="ID_EMP", referencedColumnName = "ID"), 
			inverseJoinColumns=@JoinColumn(name="ID_LIVRE", referencedColumnName = "ID"))
	private Set<Livre> livres;

	public Emprunt() {
		super();
	}

	@Override
	public String toString() {
		return "Emprunt [id=" + id + ", dateDebut=" + dateDebut + ", dalai=" + dalai + ", dateFin=" + dateFin
				+ ", cliId=" + idClient + "]";
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

	public int getCliId() {
		return idClient;
	}

	public void setCliId(int idClient) {
		this.idClient = idClient;
	}
	
	

}
