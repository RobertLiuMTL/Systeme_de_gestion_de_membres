package junitTest;
import projet.DataCenter;
import projet.Identification;
import projet.Pro;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import projet.Membre;

class identificationTest {


	@Test
	void testIdentifier() {
		DataCenter data = new DataCenter();
		assertEquals(data.identifier(data, 123456793) , "Validé!");
		assertEquals(data.identifier(data, 123456789) , "Validé!");
		assertEquals(data.identifier(data, 123456999) , "Numéro invalide.");
	
	}
	@Test
	void testIdentiferMembre() {
		DataCenter data = new DataCenter();
		assertEquals(data.identifierMembre(data,123456789).getNomComplet() ,"Robert Liu" );
		assertEquals(data.identifierMembre(data,123459999) ,null );
		}
	
	@Test
	void testIdentifierPro() {
		DataCenter data = new DataCenter();
		assertEquals(data.identifierPro(data,123456793).getNomComplet() ,"Édouard Badot" );
		assertEquals(data.identifierPro(data,123459999) ,null );
	}	
		
	
	
}
