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
	public void addMembre() {
		CreateMembre cm = new CreateMembre(data);
	}

	/**
	 * Méthode pour rechercher un Membre Deux types de recherche sont disponibles :
	 * Recherche par numéro Recherche par nom de famille
	 */
	public void findMembre() {

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
			FindMembreByNum search = new FindMembreByNum(data.getMembre());
			break;
		case 2:
			System.out.println("Rechercher par nom de famille...");
			FindMembreByName searchName = new FindMembreByName(data.getMembre());
			break;
		}

	}

	/**
	 * Méthode qui prend en entrée la liste de Membres et qui l'affiche en
	 * entièreté.
	 * 
	 * @param liste
	 */
	public void afficherAll(Membre[] liste) {
		String resultatAll = "Voici la liste de tous les membres " + "inscrits au Centre Sportif #GYM : \n\n";

		for (int i = 0; i < liste.length; i++) {
			resultatAll += "*****************************************\n" + "Nom : " + liste[i].getNomComplet() + "\n"
					+ "Numéro de membre : " + liste[i].getNumero() + "\n" + "Date de naissance : "
					+ liste[i].getNaissance() + "\n" + "Adresse : " + liste[i].getAdresse() + "\n" + "Courriel : "
					+ liste[i].getCourriel() + "\n" + "Numéro de téléphone : " + liste[i].getPhone() + "\n"
					+ "Membre suspendu? : " + liste[i].getSuspendu() + "\n" + "Membre depuis : "
					+ liste[i].getDateCreation() + "\n" + "Commentaires : " + liste[i].getComment();
		}
		System.out.println(resultatAll);
	}

	public String suspendMembre(Membre[] liste, int numero) {
		String resultat = "";
		for (int i = 0; i < liste.length; i++) {
			if (liste[i].getNumero() == numero) {
				liste[i].setSuspendu(true);
				resultat = "Le membre " + liste[i].getNomComplet() + " avec le numéro de membre " + numero
						+ " a été suspendu.";
			}
		}
		return resultat;
	}

	public void modifierMembre() {
		System.out.println("================================================================================");
		System.out.println("=========================== Gestionnaire des Membres ===========================");
		System.out.println("=========================== Module de Modification==============================");
		System.out.println("================================================================================");
		System.out.println("\n");
		System.out.println("Veuillez entrer le numéro à 9 chiffres du Membre");
		Scanner sc2 = new Scanner(System.in);

		// S'assurer que l'entrée est un int.
		while (!sc2.hasNextInt()) {
			System.out.println("SVP, entrez un numéro valide à 9 chiffres");
			sc2.next();
		}
		int input2 = sc2.nextInt();
		Membre membreFound =data.identifierMembre(input2); 
		if ( membreFound != null) {
			moduleMod(membreFound);
		}else {
			System.out.println("Le numéro de Membre que vous avez entré n'est pas valide.");
			System.out.println("Retour au menu précédent.");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void moduleMod(Membre membre) {
		System.out.println("================================================================================");
		System.out.println("=========================== Le compte de " + membre.getNomComplet() + "====");
		System.out.println("=========================== Module de Modification==============================");
		System.out.println("================================================================================");
		System.out.println("Sélectionnez une option");
		System.out.println("[0]     Pour quitter le module de modification \n");
		System.out.println("[1]     Modifier l'adresse postale \n");
		System.out.println("[2]     Modifier le numéro de téléphone \n");
		System.out.println("[3]     Modifier l'adresse courriel \n");
		System.out.println("[4]     Ajouter un commentaire \n");
		boolean continuerModification= true;
		Scanner sc2 = new Scanner(System.in);
		int input2;
		while (continuerModification) {
			System.out.println("Veuillez sélectionner une option. Pour quitter, appuyez sur 0");
			// S'assurer que l'entrée est un int.
			while (!sc2.hasNextInt()) {
				System.out.println("SVP, entrez un numéro");
				sc2.next();
			}
			input2 = sc2.nextInt();
			while (input2 != 1 && input2 != 2 && input2 != 0 && input2 != 3 && input2 != 4) {
				System.out.println("SVP, faites un choix valide.");
				input2 = sc2.nextInt();
			}

			switch (input2) {
			case 0:
				System.out.println("Retour au Gestionnaire des Membres...");
				continuerModification = false;
				break;
			case 1:
				System.out.println("Veuillez entrer la nouvelle adresse postale du Membre");
				sc2 = new Scanner(System.in);
				String newAdresse = sc2.nextLine();
				System.out.println("La nouvelle adresse est : " + newAdresse);
				membre.setAdresse(newAdresse);
				break;
			case 2:
				System.out.println("Veuillez entrer le nouveau numéro de téléphone du Membre");
				sc2 = new Scanner(System.in);
				String newPhone = sc2.nextLine();
				System.out.println("Le nouveau numéro de téléphone est : " + newPhone);
				membre.setPhone(newPhone);
				break;
			case 3:
				System.out.println("Veuillez entrer la nouvelle adresse courriel du Membre");
				sc2 = new Scanner(System.in);
				String newCourriel = sc2.nextLine();
				System.out.println("La nouvelle adresse courriel est : " + newCourriel);
				membre.setCourriel(newCourriel);
				break;
			case 4:
				System.out.println("Veuillez entrer le commentaire à ajouter au dossier du Membre");
				sc2 = new Scanner(System.in);
				String newComment = sc2.nextLine();
				System.out.println("Le commentaire entré est : " + newComment);
				membre.setComment(newComment);
				break;
			}
		}

	}

}
