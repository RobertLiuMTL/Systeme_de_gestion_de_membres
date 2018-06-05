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
	
	/**
	 * Puisque le Centre de Données contient la liste de Membre,
	 * la méthode pour ajouter un membre aboutit ultimement ici
	 * (Main fait appel à CreateMembre, qui envoie les données du Membre
	 * au Centre de données (DataCenter)
	 * 
	 * Tous les arguments sont en format String (amélioration possible : introduire
	 * les integer pour le numéro de téléphone, et la naissance)
	 * 
	 * @param nomFamille
	 * @param prenom
	 * @param adresse
	 * @param naissance
	 * @param phone
	 * @param courriel
	 * @throws InterruptedException
	 */
	public void addMember (String nomFamille, String prenom, String adresse, String naissance, String phone, String courriel) throws InterruptedException {
		int longueur = membersListe.length;
		Membre[] temporaire = new Membre[longueur+1];
		for (int i = 0;i<longueur-1;i++) {
			temporaire[i]=membersListe[i];		
			}
		temporaire[longueur] = new Membre(nomFamille, prenom, lastNumber, adresse, naissance, phone, courriel);
		membersListe=temporaire;
		System.out.println("Le nouveau Membre a été crée avec succès!\n");
		System.out.println(prenom +" "+ nomFamille + " a le numéro de Membre suivant : "+lastNumber);
		lastNumber++;
		System.out.println("\nVeuillez patienter pendant que le Système "
				+ "imprime la carte de Membre et retourne au Centre de Données..."
				+ "\n\n\n\n\n\n");
		Thread.sleep(6000);
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
	
	/**
	 * retourne la liste des noms et prénoms de tous les membres
	 * @return
	 */
	public String getMembre() {
		String resultat="";
		for (int i = 0;i<membersListe.length;i++) {
			resultat= resultat + membersListe[i].getPrenom();
		}
		return resultat;
	}
}
