import java.util.Scanner;
/**
 * C'est le gestionnaire des Membres.
 * Interagit avec le Centre de données (DataCenter).
 * Toute communication avec la Vue passe par le Centre de Données
 * @author Robert
 *
 */
public class GestionnaireMembre {
	private DataCenter data;
	private Membre[] liste;
	public GestionnaireMembre(DataCenter data) {
		this.data=data;
	}
	
	/**
	 * Méthode pour créer un membre.
	 * Lance l'application de création située dans une classe à part.
	 */
	public void gestionnaireAddMembre() {
		CreateMembre cm = new CreateMembre(data);
	}
	
	public void gestionnaireFindMembre() {
		String resultat = "test";
		
		System.out.println("================================================================================");
		System.out.println("=========================== Gestionnaire des Membres ===========================");
		System.out.println("================================================================================");
		System.out.println("\n");
		System.out.println("Sélectionnez une option");
		System.out.println("[0]     Retour au Gestionnaire des Membres \n");
		System.out.println("[1]     Recherche par numéro de Membre \n");
		System.out.println("[2]     Rechercher par prénom et nom de famille \n");

		Scanner sc2 = new Scanner(System.in);
		int input2 = sc2.nextInt();

		while (input2 != 1 && input2 != 2 && input2 != 0 && input2 != 3) {
			System.out.println("SVP, faites un choix valide.");
			input2 = sc2.nextInt();
		}

		switch (input2) {
		case 0:
			System.out.println("Retour au Gestionnaire des Membres...");
			data.vueGestionnaireMembre();
		case 1:
			System.out.println("Recherche par numéro de membre...");
			GestionnaireMembreFindMembreByNum search = 
					new GestionnaireMembreFindMembreByNum (data.getMembre());
			break;
		case 2:
			System.out.println("Rechercher par prénom et nom de famille...");
			GestionnaireMembreFindMembreByName searchName = 
					new GestionnaireMembreFindMembreByName(data.getMembre());
			break;
		case 3:
			System.out.println("Ouverture du module afficher tous les Membres...");
			data.gestionnaireAfficherMembre();
			break;
		}
		
	}
	
	/**
	 * Démarrer le module de recherche d'un membre par numéro
	 * Crée une instance de la classe GestionnaireMembreFindMembreByNum
	 */
	public void gestionnaireFindMembreByNum() {
		GestionnaireMembreFindMembreByNum search = 
				new GestionnaireMembreFindMembreByNum (data.getMembre());
	}
	
}
