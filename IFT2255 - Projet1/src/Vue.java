import java.util.Scanner;

/**
 * La vue de notre Logiciel. C'est l'interface utilisateur.
 * 
 * @author Robert
 *
 */
public class Vue {
	private DataCenter data;
	private RepertoireServices service;
	
	/**
	 * Constructeur de la Vue.
	 * Instancié par le Main de notre Logiciel.
	 * Reçoit le Centre de Données en paramètre.
	 * Appelle séquentiellement accueil pour passer au menu principal
	 * @param data
	 */
	public Vue(DataCenter data) {
		this.data = data;
		accueil();
	}

	/**
	 * Imprime l'écran d'accueil.
	 */
	public void accueil() {
		System.out.println("================================================================================");
		System.out.println("======================= Bienvenue au Centre Sportif #GYM =======================");
		System.out.println("================================================================================");
		System.out.println("                      .-\"\"\"-.\r\n" + "                     /       \\\r\n"
				+ "                    ;_.-\"\"\"-._;\r\n" + " .,_       __,.---.-(=(o)-(o)=)-.---.,__       _,.\r\n"
				+ " '._'--\"```          \\   ^   /          ```\"--'_.'\r\n"
				+ "    ``\"''~---~~%^%^.%.`._0_.'%,^%^%^~~---~''\"``\r\n"
				+ "    ~^~- `^-% ^~.%~%.^~-%-~.%-^.% ~`% ~-`%^`-~^~\r\n" + "       ~^- ~^- `~.^- %`~.%~-'%~^- %~^- ~^");
		menuPrincipal();
	}
	
	/**
	 * Menu principal
	 * Permet une interaction avec l'utilisateur en ligne de commande
	 */
	public void menuPrincipal() {

		System.out.println("================================================================================");
		System.out.println("================================ Menu principal ================================");
		System.out.println("================================================================================");
		System.out.println("\n");

		System.out.println("Sélectionnez une option");
		System.out.println("[0]     Fermer le Système \n");
		System.out.println("[1]     Centre de Données \n");
		System.out.println("[2]     Répertoire des Services \n");
		System.out.println("[3]     Identification du Membre ou Professionnel \n");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		while (input != 1 && input != 2 && input != 0 && input!=3) {
			System.out.println("SVP, faites un choix valide.");
			input = sc.nextInt();
		}

		switch (input) {
		case 0:
			System.out.println("Fermeture du système en cours...");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.exit(0);
		case 1:
			System.out.println("Ouverture du Centre de Données...");
			dataCenter();
			break;
		case 2:
			System.out.println("Ouverture du Répertoire des Services...");
			service = new RepertoireServices(this.data);
			break;
			
		case 3:
			System.out.println("Ouverture du Service d'Identification...");
			System.out.println("================================================================================");
			System.out.println("============================== Identification ==================================");
			System.out.println("================================================================================");
			System.out.println("\n ");
			System.out.println("Veuillez entrer le numéro de Membre à 9 chiffres");
			int numeroMembre = sc.nextInt();
			System.out.println(data.identifier(numeroMembre));
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			menuPrincipal();
			break;
		}

	}
	
	/**
	 * Menu du Centre de données
	 * C'est une des options du menu principal.
	 * Permet une interaction avec l'utilisateur en ligne de commande
	 */
	public void dataCenter() {
		System.out.println("================================================================================");
		System.out.println("============================== Centre de Données ===============================");
		System.out.println("================================================================================");
		System.out.println("\n ");
		Scanner sc = new Scanner(System.in);
		System.out.println("Sélectionnez une option");
		System.out.println("[0]     Retourner au Menu principal \n");
		System.out.println("[1]     Gestionnaire des Membres \n");
		System.out.println("[2]     Gestionnaire des Professionnels \n");
		int input = sc.nextInt();

		while (input != 1 && input != 2 && input != 0) {
			System.out.println("SVP, faites un choix valide.");
			input = sc.nextInt();
		}
		switch (input) {
		case 0:
			System.out.println("Retour au menu principal...");
			menuPrincipal();
			break;
		case 1:
			System.out.println("Ouverture du Gestionnaire des Membres...");
			// Pour simuler le chargement de notre logiciel...
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			accueilGestionnaireMembre();
			break;
		case 2:
			System.out.println("Ouverture du Gestionnaire des employés...");
			// Pour simuler le chargement de notre logiciel...
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			accueilGestionnairePro();

		}
	}
	
	/**
	 * Menu du Gestionnaire des Membres
	 * Permet des interactions avec l'utilisateurs.
	 * Les options présentes dans ce menu sont envoyées au Centre de Données (Contrôleur)
	 * Le Centre de Données redirige ensuite les commandes aux bonnes classes.
	 */
	public void accueilGestionnaireMembre() {
		System.out.println("================================================================================");
		System.out.println("=========================== Gestionnaire des Membres ===========================");
		System.out.println("================================================================================");
		System.out.println("\n");
		System.out.println("Sélectionnez une option");
		System.out.println("[0]     Retour au Centre de Données \n");
		System.out.println("[1]     Créer un nouveau Membre \n");
		System.out.println("[2]     Rechercher un Membre \n");
		System.out.println("[3]     Afficher tous les Membres \n");

		Scanner sc2 = new Scanner(System.in);
		int input2 = sc2.nextInt();

		while (input2 != 1 && input2 != 2 && input2 != 0 && input2 != 3) {
			System.out.println("SVP, faites un choix valide.");
			input2 = sc2.nextInt();
		}

		switch (input2) {
		case 0:
			System.out.println("Retour au Centre de Données...");
			dataCenter();
		case 1:
			System.out.println("Ouverture du module de création de Membre...");
			data.gestionnaireAddMembre();
			dataCenter();
			break;
		case 2:
			System.out.println("Ouverture du module recherche de Membre...");
			data.gestionnaireFindMembre();
			accueilGestionnaireMembre();
			break;
		case 3:
			System.out.println("Ouverture du module afficher tous les Membres...");
			data.gestionnaireAfficherMembre();
			accueilGestionnaireMembre();
			break;
		}
	}
	
	
	/**						À FAIRE
	 * On peut recopier la logique du Gestionnaire des Membres (à ma connaissance,
	 * le Gestionnaire des Membres fonctionne assez bien)
	 * 
	 * 
	 * Menu du Gestionnaire des Professionnel
	 * Permet des interactions avec l'utilisateurs.
	 * Les options présentes dans ce menu sont envoyées au Centre de Données (Contrôleur)
	 * Le Centre de Données redirige ensuite les commandes aux bonnes classes.
	 */
	public void accueilGestionnairePro() {
		System.out.println("================================================================================");
		System.out.println("======================== Gestionnaire des Professionnels =======================");
		System.out.println("================================================================================");
		System.out.println("\n");
		Scanner sc = new Scanner(System.in);
		System.out.println("Sélectionnez une option");
		System.out.println("[0]     Retour au Centre de Données \n");
		System.out.println("[1]     Créer un nouveau Professionnel \n");
		System.out.println("[2]     Rechercher un Professionnel \n");
		System.out.println("[3]     Afficher tous les Professionnels \n");
		int input = sc.nextInt();

		while (input != 1 && input != 2 && input != 0 && input != 3) {
			System.out.println("SVP, faites un choix valide.");
			input = sc.nextInt();
		}

		switch (input) {
		case 0:
			System.out.println("Retour au Centre de Données...");
			dataCenter();
		case 1:
			System.out.println("Ouverture du module de création de Professionnel...");
			dataCenter();
			break;
		case 2:
			System.out.println("Ouverture du module recherche de Professionnel...");
			break;
		case 3:
			System.out.println("Ouverture du module afficher tous les Membres...");

			break;
		}
	}

}
