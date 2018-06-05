/**
 * Centre de Données
 * @author Robert
 *
 */
public class DataCenter {
	Membre [] membersListe = new Membre[0];
	Pro [] proList;
	//Dernier numéro de Membre attribué.
	private int lastNumber = 123456789;
	
	
	public void addMember (String nomFamille, String prenom, String adresse, String naissance, String phone, String courriel) {
		int longueur = membersListe.length;
		Membre[] temporaire = new Membre[longueur+1];
		for (int i = 0;i<longueur-1;i++) {
			temporaire[i]=membersListe[i];		
			}
		lastNumber++;
		temporaire[longueur] = new Membre(nomFamille, prenom, lastNumber, adresse, naissance, phone, courriel);
		membersListe=temporaire;
	}
	/**
	 * Méthode qui génère un numéro de Membre à 9 chiffres. 
	 * Met également à jour l'attribut lastNumber
	 * @return 
	 */
	public int issueNumber() {
		lastNumber++;
		return lastNumber;
	}
	
	public String getMembre() {
		String resultat="";
		for (int i = 0;i<membersListe.length;i++) {
			resultat= resultat + membersListe[i].getPrenom();
		}
		return resultat;
	}
}
