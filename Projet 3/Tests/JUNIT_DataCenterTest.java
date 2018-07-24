package junitTest;
import projet.DataCenter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;


/**
 * Test des trois principales fonctions du DataCenter (ajouter Membre, Pro et Service).
 * J'en profite également pour vérifier tester la méthode d'identification qui retourne une booléenne.
 * 
 * @author Robert
 *
 */
class JUNIT_DataCenterTest {
	@Test
	public void testListeMembre() {
		//Test sur la liste de Membres
		DataCenter data = new DataCenter(1);

		int lengthMembre = data.getMembre().length;
		
		// Vérifier que la liste est bel et bien vide
		assertEquals(lengthMembre, 0);
		
		int numeroMembre = 123456789;
		//Créons un nombre arbitraire de Membre pour voir si la liste se brise ou non.
		while(lengthMembre<800) {
			data.addMember("testnom", "testprenom", "testadresse", "testnaissance", "testphone", "test@courriel.com", "testprovince", "testcity", "postalcode");
			lengthMembre++;
			assertEquals(data.getMembre().length,lengthMembre);
			
			//Vérifier l'identification
			assertTrue (data.identifierBool(numeroMembre));
			
			//Vérifier que le compteur de # membre est correct
			assertEquals(data.getMembre()[lengthMembre-1].getNumero(), numeroMembre);
			numeroMembre++;
		}
	}
	
	@Test
	public void testListePro() {
		//Test sur la liste de Pro
		DataCenter data = new DataCenter(1);

		int lengthPro = data.getPro().length;
		int numeroMembre = 123456789;
		//Vérifier que la liste est nulle
		assertEquals(lengthPro,0);

		//Créons un nombre arbitraire de Pro pour voir si la liste se brise ou non.
		while(lengthPro<800) {
			
			//Vérifier que la liste augmente correctement
			data.addPro("testnom", "testprenom", "testadresse", "testnaissance", "testphone", "test@courriel.com","testdiscipline", "testprovince", "testcity", "postalcode");
			lengthPro++;
			assertEquals(data.getPro().length,lengthPro);
			
			//Vérifier que le numéro est bien assigné
			assertEquals(data.getPro()[lengthPro-1].getNumero(),numeroMembre);
			//Vérifier que l'identification du pro marche
			assertTrue(data.identifierBool(numeroMembre));
			numeroMembre++;
			
		}
	}
	
	@Test
	public void testListeService() {
		//Test sur la liste de services
		DataCenter data = new DataCenter(1);
		int service = data.getService().length;
		//On vérifie que la liste de service est nulle	
		assertEquals(service, 0);
		
		int lastService = 1010000;
		while(service<1000) {
			//Vérifier que la liste de Service augmente correctement
			data.addService("test");
			service++;
			assertEquals(data.getService().length,service);
			
			//Vérifier que le numéro est bien assigné
			assertEquals(data.getService()[service-1].getService(),lastService);
			lastService += 10000;
			
		}
		
	}

}
