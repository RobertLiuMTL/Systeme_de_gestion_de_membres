package junitTest;

import projet.DataCenter;
import projet.IdentificationCourriel;
import projet.Membre;
import projet.Pro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class JUNIT_IdentificationCourrielTest extends IdentificationCourriel {

	@Test
	void testMembre() {
		DataCenter data = new DataCenter(1);
		int courrielPart1 = 1000;
		String courrielPart2 = "@gmail.com";
		
		int compteur = 0;
		
		//Test sur la fonction de validation de courriel sur une adresse continuellement changeante.
		while(compteur<1000) {
			data.addMember(null, null, null, null, null, courrielPart1+courrielPart2, null, null, null);
			assertNotNull(membreCourriel(data.getMembre(),courrielPart1+courrielPart2));
			compteur++;
			courrielPart1+=100;
		}
		
		
	}
	
	@Test
	void testPro() {
		DataCenter data = new DataCenter(1);
		int courrielPart1 = 1000;
		String courrielPart2 = "@gmail.com";
		
		int compteur = 0;
		
		//Test sur la fonction de validation de courriel sur une adresse continuellement changeante.
		while(compteur<1000) {
			data.addPro(null, null, null, null, null, courrielPart1+courrielPart2, null, null, null, null);
			assertNotNull(proCourriel(data.getPro(),courrielPart1+courrielPart2));
			compteur++;
			courrielPart1+=100;
		}
		
		
	}

}
