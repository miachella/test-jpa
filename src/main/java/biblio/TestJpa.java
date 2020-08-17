package biblio;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.junit.Before;
import org.junit.Test;

import biblio.model.Livre;

public class TestJpa {
	
	private EntityManagerFactory factory = null;
	
	@Before
	public void init() {
		factory = Persistence.createEntityManagerFactory("pu_essai");
	}
	
	@Test
	public void testExtract() {	
		EntityManager em = factory.createEntityManager();

		//Réalisez un find simple permettant d’extraire un livre en fonction de son identifiant et affichez son titre et son auteur
		Livre l = em.find(Livre.class, 1);
		System.out.println(l);
		
		//close connection
		em.close();
		factory.close();
	}
	
	@Test
	public void testInsert() {
		EntityManager em = factory.createEntityManager();

		//Insérez un nouveau Livre de votre choix en base de données
		Livre nouveauLivre = new Livre();
		nouveauLivre.setId(6);
		nouveauLivre.setTitre("La tour des anges");
		nouveauLivre.setAuteur("Philip Pullman");
		
		//maj bdd
		em.getTransaction().begin();
		em.persist(nouveauLivre);
		em.getTransaction().commit();
		System.out.println(nouveauLivre);
		
		//close connection
		em.close();
		factory.close();
	}
	
	@Test
	public void testFind() {
		EntityManager em = factory.createEntityManager();

		////Insérez un nouveau Livre de votre choix en base de données
		Livre l2 = em.find(Livre.class, 5);
		if(l2 != null) {
			l2.setTitre("Du plaisir dans la cuisine");
			
			//maj bdd
			em.getTransaction().begin();
			em.merge(l2);
			em.getTransaction().commit();
			
			//close connection
			em.close();
			factory.close();
		}
	}
	
	@Test
	public void testExtractTitre() {
		EntityManager em = factory.createEntityManager();

		//Faites une requête JPQL pour extraire de la base un livre en fonction de son titre
		TypedQuery<Livre> query = em.createQuery("SELECT l FROM Livre l WHERE l.titre='Germinal'", Livre.class);
		Livre l3 = query.getResultList().get(0);
		System.out.println(l3);
		
		//close connection
		em.close();
		factory.close();
	}
	
	@Test
	public void testExtractAuteur() {
		EntityManager em = factory.createEntityManager();

		//Faites une requête JPQL pour extraire de la base un livre en fonction de son auteur
		TypedQuery<Livre> query2 = em.createQuery("SELECT l FROM Livre l WHERE l.auteur='Emile Zola'", Livre.class);
		Livre l4 = query2.getResultList().get(0);
		System.out.println(l4);
		
		//close connection
		em.close();
		factory.close();
	}
	
	@Test
	public void testDelete() {
		EntityManager em = factory.createEntityManager();

		//Supprimez un livre de votre choix en base de données
		em.getTransaction().begin();
		Livre livreDelete = em.find(Livre.class, 4);
		em.remove(livreDelete);
		em.getTransaction().commit();
		
		//close connection
		em.close();
		factory.close();
	}	
	
	@Test
	public void testDisplay() {
		EntityManager em = factory.createEntityManager();

		//Affichez la liste de tous les livres présents en base de données (titre et auteur)
		TypedQuery<Livre> query3 = em.createQuery("SELECT l FROM Livre l", Livre.class);
		List<Livre> listLivre = query3.getResultList();
		
		for (Livre lvr: listLivre) {
			System.out.println(lvr);
		}
		
		//close connection
		em.close();
		factory.close();
	}

}
