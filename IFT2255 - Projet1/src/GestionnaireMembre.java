import java.util.Scanner;

/**
 * C'est le gestionnaire des Membres. Interagit avec le Centre de données
 * (DataCenter). Toute communication avec la Vue passe par le Centre de Données
 * 
 * @author Robert
 *
 */
public class GestionnaireMembre {
	private DataCenter data;

	public GestionnaireMembre(DataCenter data) {
		this.data = data;
	}

	/**
	 * Méthode pour créer un membre. Lance l'application de création située dans une
	 * classe à part.
	 */
	public void gestionnaireAddMembre() {
		CreateMembre cm = new CreateMembre(data);
	}

	/**
	 * Méthode pour rechercher un Membre Deux types de recherche sont disponibles :
	 * Recherche par numéro Recherche par nom de famille
	 */
	public void gestionnaireFindMembre() {
		String resultat = "test";

		System.out.println("================================================================================");
		System.out.println("=========================== Gestionnaire des Membres ===========================");
		System.out.println("=========================== Module de Recherche ================================");
		System.out.println("================================================================================");
		System.out.println("\n");
		System.out.println("Sélectionnez une option");
		System.out.println("[0]     Retour au Gestionnaire des Membres \n");
		System.out.println("[1]     Recherche par numéro de Membre \n");
		System.out.println("[2]     Rechercher par nom de famille \n");

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
			GestionnaireMembreFindMembreByNum search = new GestionnaireMembreFindMembreByNum(data.getMembre());
			break;
		case 2:
			System.out.println("Rechercher par nom de famille...");
			GestionnaireMembreFindMembreByName searchName = new GestionnaireMembreFindMembreByName(data.getMembre());
			break;
		}

	}

	/**
	 * Méthode qui prend en entrée la liste de Membres et qui l'affiche en
	 * entièreté.
	 * 
	 * @param liste
	 */
	public void gestionnaireAfficherAll(Membre[] liste) {
		String resultatAll = "Voici la liste de tous les membres " + "inscrits au Centre Sportif #GYM : \n\n";

		for (int i = 0; i < liste.length; i++) {
			resultatAll += "*****************************************\n" + "Nom : " + liste[i].getPrenom() + "\n"
					+ "Numéro de membre : " + liste[i].getNumero() + "\n" + "Date de naissance : "
					+ liste[i].getNaissance() + "\n" + "Adresse : " + liste[i].getAdresse() + "\n" + "Courriel : "
					+ liste[i].getCourriel() + "\n" + "Numéro de téléphone : " + liste[i].getPhone() + "\n"
					+ "Membre suspendu? : " + liste[i].getSuspendu() + "\n" + "Membre depuis : "
					+ liste[i].getDateCreation() + "\n" + "Commentaires : " + liste[i].getComment();
		}
		System.out.println(resultatAll);
	}
	
	public String suspendMembre (Membre[]liste,int numero) {
		String resultat="";
		for (int i = 0; i<liste.length;i++) {
			if (liste[i].getNumero()== numero) {
				liste[i].setSuspendu(true);
				resultat = "Le membre "+liste[i].getPrenom() +" avec le numéro de membre "
						+ numero + " a été suspendu.";
			}
		}
		return resultat;
	}
	
}
