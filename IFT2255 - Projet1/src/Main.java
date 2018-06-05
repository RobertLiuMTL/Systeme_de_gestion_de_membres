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
			System.out.println("Création d'un membre");
			data.addMember("Liu","Robert","4981 Félix-Mclernan", "1987/10/14", "5146213688", "robert.liu@umontreal.ca");
			System.out.println(data.getMembre());
			System.out.println(data.membersListe[0].getPrenom());
			break;
		case 2:
			System.out.println("Ouverture du Répertoire des Services...");

		}
	}
}
//String nomFamille, String prenom, String adresse, String naissance, int phone, String courriel
