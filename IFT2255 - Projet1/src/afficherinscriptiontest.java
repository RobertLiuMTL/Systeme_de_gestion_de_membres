import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.Before;
class afficherinscriptiontest {
	@Before
	void prepare() {
		
		Membre me = new Membre("Alarie", "Alexandre", 123456789, "22 sainte-louis", "11-11-1991", "4564564566", "jojo@hotmail.com", "qc", "joliette", "j0k3a0");
	}
	
	@Test
	void testaucunmembre() {
		Seance se = new Seance("George Pompidou", 111111111, 1234567, 25, 25, "11-09-2018", "11-11-2018", "19:00", "lundi", "", "soccer");
		
		assertEquals("Il n'y a aucun membre inscrit à la séance de " + se.titreService + "\n"
					+ "Nom du professionnel : " + se.getPro() + "\nCode de la séance  : " + se.getCode() + "\n" , 
					se.afficherInscription() );
	}
	
	@Test
	void testavecmembre() {
		Seance se = new Seance("George Pompidou", 111111111, 1234567, 25, 25, "11-09-2018", "11-11-2018", "19:00", "lundi", "", "soccer");
		Membre me = new Membre("Alarie", "Alexandre", 123456789, "22 sainte-louis", "11-11-1991", "4564564566", "jojo@hotmail.com", "qc", "joliette", "j0k3a0");
		se.inscrireMembre(me);
		assertEquals(se.afficherInscription() , "\n================================================================================\n"+
	"Voici les membres inscrits à la séance de " + se.titreService + "\n" + "Nom du professionnel : "
				+ se.getPro() + "\nCode de la séance    : " + se.getCode()+ "\n"
						+ "================================================================================\n\n" +  "Nom du membre    : " + me.getNomComplet() + "\n"
				+ "Numéro de Membre : " + me.getNumero() + "\n" );
	}
	
	@Test
	void testplusieursmembre() {
		Seance se = new Seance("George Pompidou", 111111111, 1234567, 25, 25, "11-09-2018", "11-11-2018", "19:00", "lundi", "", "soccer");
		Membre me = new Membre("Alarie", "Alexandre", 123456789, "22 sainte-louis", "11-11-1991", "4564564566", "jojo@hotmail.com", "qc", "joliette", "j0k3a0");
		Membre me2 = new Membre("Alarie2", "Alexandre2", 123456780, "23 sainte-louis", "11-11-1990", "4564564566", "jiji@hotmail.com", "qc", "joliette", "j0k3a0");
		se.inscrireMembre(me);
		se.inscrireMembre(me2);
		assertEquals(se.afficherInscription() , "\n================================================================================\n"+
				"Voici les membres inscrits à la séance de " + se.titreService + "\n" + "Nom du professionnel : "
							+ se.getPro() + "\nCode de la séance    : " + se.getCode()+ "\n"
									+ "================================================================================\n\n" +  "Nom du membre    : " + me.getNomComplet() + "\n"
							+ "Numéro de Membre : " + me.getNumero() + "\n" + "Nom du membre    : " + me2.getNomComplet() + "\n"
							+ "Numéro de Membre : " + me2.getNumero() + "\n");
	}
}
