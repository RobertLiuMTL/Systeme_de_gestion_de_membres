import java.util.Scanner;

public class Main {
	static DataCenter data = new DataCenter();
	RepertoireService service = new RepertoireService();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		accueil();
		menuPrincipal();
	}

	public static void accueil() {
		System.out.println("================================================================================");
		System.out.println("======================= Bienvenue au Centre Sportif #GYM =======================");
		System.out.println("================================================================================");
		System.out.println("                      .-\"\"\"-.\r\n" + "                     /       \\\r\n"
				+ "                    ;_.-\"\"\"-._;\r\n" + " .,_       __,.---.-(=(o)-(o)=)-.---.,__       _,.\r\n"
				+ " '._'--\"```          \\   ^   /          ```\"--'_.'\r\n"
				+ "    ``\"''~---~~%^%^.%.`._0_.'%,^%^%^~~---~''\"``\r\n"
				+ "    ~^~- `^-% ^~.%~%.^~-%-~.%-^.% ~`% ~-`%^`-~^~\r\n" + "       ~^- ~^- `~.^- %`~.%~-'%~^- %~^- ~^");
	}

	public static void menuPrincipal() {
		boolean ouvert = true;

		System.out.println("================================================================================");
		System.out.println("================================ Menu principal ================================");
		System.out.println("================================================================================");
		System.out.println("\n \n \n");

		Scanner sc = new Scanner(System.in);
		System.out.println("Sélectionnez une option");
		System.out.println("[0]     Fermer le Système \n");
		System.out.println("[1]     Centre de Données \n");
		System.out.println("[2]     Répertoire des Services \n");
		int input = sc.nextInt();

		while (input != 1 && input != 2 && input != 0) {
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
			break;
		}

	}

	public static void dataCenter() {
		System.out.println("================================================================================");
		System.out.println("============================== Centre de Données ===============================");
		System.out.println("================================================================================");
		System.out.println("\n \n \n");
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
		case 1:
			System.out.println("Ouverture du Gestionnaire des Membres...");
			System.out.println("================================================================================");
			System.out.println("=========================== Gestionnaire des Membres ===========================");
			System.out.println("================================================================================");
			System.out.println("\n \n \n");
			Scanner sc2 = new Scanner(System.in);
			System.out.println("Sélectionnez une option");
			System.out.println("[0]     Retour au Centre de Données \n");
			System.out.println("[1]     Créer un nouveau Membre \n");
			System.out.println("[2]     Rechercher un Membre \n");
			System.out.println("[3]     Afficher tous les Membres \n");
			int input2 = sc.nextInt();

			while (input2 != 1 && input2 != 2 && input2 != 0 && input2 != 3) {
				System.out.println("SVP, faites un choix valide.");
				input2 = sc.nextInt();	
			}

			switch (input2) {
			case 0:
				System.out.println("Retour au Centre de Données...");
				dataCenter();
			case 1:
				System.out.println("Ouverture du module de création de Membre...");
				CreateMembre cm = new CreateMembre (data);
				dataCenter();
				break;
			case 2:
				System.out.println("Ouverture du module recherche de Membre...");
				break;
			case 3:
				System.out.println("Ouverture du module afficher tous les Membres...");
				data.getMembre();
				break;
			}
		case 2:
			System.out.println("Ouverture du Répertoire des Services...");

		}
	}
}
//String nomFamille, String prenom, String adresse, String naissance, int phone, String courriel
