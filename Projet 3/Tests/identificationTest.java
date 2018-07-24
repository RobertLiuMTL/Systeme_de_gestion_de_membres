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
		DataCenter data = new DataCenter(1);
		assertEquals(data.identifier(data, 123456793) , "Numéro invalide.");
		assertEquals(data.identifier(data, 123456789) , "Validé!");
		assertEquals(data.identifier(data, 123456999) , "Numéro invalide.");
	
	}
	@Test
	void testIdentiferMembre() {
		DataCenter data = new DataCenter(1);
		data.addMember("Liu", "Robert", null,null,null,null,null,null,null);
		assertEquals(data.identifierMembre(data,123456789).getNomComplet() ,"Robert Liu" );
		assertEquals(data.identifierMembre(data,123459999) ,null );
		}
	
	@Test
	void testIdentifierPro() {
		DataCenter data = new DataCenter(1);
		data.addPro("Liu", "Robert", null,null,null,null,null,null,null, null);

		assertEquals(data.identifierPro(data,123456789).getNomComplet() ,"Robert Liu" );
		assertEquals(data.identifierPro(data,123459999) ,null );
	}	
		
	
	
}
