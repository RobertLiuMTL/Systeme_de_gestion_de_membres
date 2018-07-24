package junitTest;

import projet.Service;
import projet.Seance;
import projet.Membre;
import projet.Pro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUNIT_ServiceSeanceTest {
	@Test
	public void testSeance() {
		//Création d'un service pour test
		Service service = new Service("Test", 1000000);
		int nbSeances = service.getSeance().length;
		int codeSeance = 1000000;
		// Vérifier que le nb de séances est à 0 au départ
		assertEquals (nbSeances,0);
		
		// Test de création de séances
		while(nbSeances < 1000) {
			service.addSeance("TestPro", 123456789, 30, 30, "dateDebut", "dateFin", "heureDebut", "recurrence", "comments");
			nbSeances++;
			
			//Tester que le code de la séance correspond bel et bien au numéro de Service + 100/séance + 2 derniers chiffres du num de Pro
			assertEquals(service.getSeance()[nbSeances-1].getCode(),codeSeance+100+(123456789%100));
			codeSeance+=100;
		}
		
	}
	
	@Test
	public void testLimiteInscription() {
		Service service = new Service("test",1000000);
		Membre membre = new Membre(null, null, 123456789, null, null, null, null, null, null, null);
		service.addSeance("TestPro", 123456789, 30, 30, "dateDebut", "dateFin", "heureDebut", "recurrence", "comments");
		int codeSeance = 1000189;
		int compteur = 0;
		//Test que la capacité maximale est bel et bien de 30
		while(compteur<300) {
			if(compteur<30) {
				assertTrue(service.getSeance()[0].inscrireMembre(membre));
			}else {
				assertFalse(service.getSeance()[0].inscrireMembre(membre));
			}
			compteur++;
						
		}
	}

}
