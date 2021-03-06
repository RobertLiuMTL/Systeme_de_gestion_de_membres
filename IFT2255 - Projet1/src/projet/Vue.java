package projet;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * La vue de notre Logiciel. C'est l'interface utilisateur en ligne de commande.
 * Une grande partie de l'affichage se trouve ici. Cependant, afin d'alléger cette Classe
 * et afin de mieux diviser le rôle des classes, certains éléments visuels sont contenus dans d'autres classes.
 * Cela facilite, de notre avis, la maintenance.
 * 
 * La logique des options proposées se trouve généralement ailleurs. Souvent, l'option choisie par l'utilisateur dans la Vue
 * lance un appel au DataCenter qui appelle ensuite la bonne méthode.
 * Ce couplage, un peu fort, permet de bien séparer le rôle des différentes classes de notre projet.
 * 
 * @author Robert
 *
 */
public class Vue {
	private DataCenter data;


	/**
	 * Constructeur de la Vue. Instancié par le Main de notre Logiciel. Reçoit le
	 * Centre de Données en paramètre. Appelle séquentiellement accueil pour passer
	 * au menu principal
	 * 
	 * @param data : DataCenter
	 */
	public Vue(DataCenter data) {
		this.data = data;

	}

	/**
	 * Imprime l'écran d'accueil. 
	 * Deux choix sont proposés à l'utilisateur : L'application mobile ou le logiciel
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
		
		System.out.println("\n\n\nSélectionnez une option");
		System.out.println("[0]     Fermer le Système \n");
		System.out.println("[1]     Logiciel #GYM \n");
		System.out.println("[2]     Application mobile \n");
		
		
		Scanner sc = new Scanner(System.in);

		// Boucle while qui vérifie que l'entrée est un Integer.
		while (!sc.hasNextInt()) {
			System.out.println("Svp, entrez un numéro");
			sc.next();
		}
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
			menuPrincipal();
			break;
		case 2:
			AppMobile app = new AppMobile(data);
			accueil();
			break;
		}
		
	}

	/**
	 * Menu principal Permet une interaction avec l'utilisateur en ligne de commande
	 */
	public void menuPrincipal() {

		System.out.println("================================================================================");
		System.out.println("================================ Menu principal ================================");
		System.out.println("================================================================================");
		System.out.println("\n");

		System.out.println("Sélectionnez une option");
		System.out.println("[0]     Retourner à l'accueil \n");
		System.out.println("[1]     Centre de Données \n");
		System.out.println("[2]     Répertoire des Services \n");
		System.out.println("[3]     Identification du Membre pour accès au GYM \n");
		System.out.println("[4]     Procédure comptable \n");
		Scanner sc = new Scanner(System.in);

		// Boucle while qui vérifie que l'entrée est un Integer.
		while (!sc.hasNextInt()) {
			System.out.println("Svp, entrez un numéro");
			sc.next();
		}
		int input = sc.nextInt();

		while (input != 1 && input != 2 && input != 0 && input != 3 && input != 4) {
			System.out.println("SVP, faites un choix valide.");
			input = sc.nextInt();
		}

		switch (input) {
		case 0:
			accueil();
			break;
		case 1:
			System.out.println("Ouverture du Centre de Données...");
			dataCenter();
			break;
		case 2:

			menuRepertoireServices();
			break;

		case 3:
			System.out.println("Ouverture du Service d'Identification...");
			System.out.println("================================================================================");
			System.out.println("============================== Identification ==================================");
			System.out.println("================================================================================");
			System.out.println("\n ");
			System.out.println("Veuillez entrer le numéro de Membre à 9 chiffres");

			// Boucle while qui vérifie que l'entrée est un Integer.
			while (!sc.hasNextInt()) {
				System.out.println("Svp, entrez un numéro");
				sc.next();
			}

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
		case 4:
			menuComptable();
			break;
		}

	}

	/**
	 * Menu du Centre de données C'est une des options du menu principal. Permet une
	 * interaction avec l'utilisateur en ligne de commande
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

		// Boucle while qui vérifie que l'entrée est un Integer.
		while (!sc.hasNextInt()) {
			System.out.println("Svp, entrez un numéro");
			sc.next();
		}
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
	 * Menu du Gestionnaire des Membres Permet des interactions avec l'utilisateurs.
	 * Les options présentes dans ce menu sont envoyées au Centre de Données
	 * (Contrôleur) Le Centre de Données redirige ensuite les commandes aux bonnes
	 * classes.
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
		System.out.println("[4]     Modifier un Membre \n");
		System.out.println("[5]     Suspendre un Membre \n");
		System.out.println("[6]     Supprimer un Membre \n");

		Scanner sc2 = new Scanner(System.in);

		// Boucle while qui vérifie que l'entrée est un Integer.
		while (!sc2.hasNextInt()) {
			System.out.println("Svp, entrez un numéro");
			sc2.next();
		}

		int input2 = sc2.nextInt();

		// Boucle qui vérifie que l'integer est une des option.
		while (input2 != 1 && input2 != 2 && input2 != 0 && input2 != 3 && input2 != 4 && input2 != 5 && input2 != 6) {
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
		case 4:
			System.out.println("Ouverture du module de modification d'un Membre...");
			data.gestionnaireModMembre();
			accueilGestionnaireMembre();
			break;
		case 5:
			System.out.println("Ouverture du module de suspension d'un Membre...");
			System.out.println("Veuillez entrer le numéro à 9 chiffres du Membre à suspendre");
			while (!sc2.hasNextInt()) {
				System.out.println("SVP, entrez un numéro à 9 chiffres");
				sc2.next();
			}
			int numero = sc2.nextInt();
			if (data.identifierBool(numero)) {
				System.out.println("Êtes-vous certain de vouloir suspendre " + numero
						+ " ?\nEntrez 'y' pour suspendre.\nEntrez 'n' pour quitter.");
				char reponse = sc2.next().charAt(0);
				while (reponse != 'y' && reponse != 'n') {
					System.out.println("SVP, faites un choix valide.");
					reponse = sc2.next().charAt(0);
				}
				if (reponse == 'y') {
					System.out.println(data.gestionnaireSuspendMembre(numero));
				}
				if (reponse == 'n') {
					System.out.println("Retour au au menu Gestionnaire de Membres...");
				}

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("Le numéro de membre entré : " + numero + " est invalide");

				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			accueilGestionnaireMembre();
			break;

		case 6:
			System.out.println("Ouverture du module de supression de Membre...");
			System.out.println("Veuillez entrer le numéro à 9 chiffres du Membre à suspendre");
			sc2 = new Scanner(System.in);
			while (!sc2.hasNextInt()) {
				System.out.println("SVP, entrez un numéro à 9 chiffres");
				sc2.next();
			}
			numero = sc2.nextInt();
			if (data.identifierBool(numero)) {
				System.out.println("Êtes-vous certain de vouloir supprimer le membre avec le numéro : " + numero
						+ " ?\nEntrez 'y' pour suspendre.\nEntrez 'n' pour quitter.");
				char reponse = sc2.next().charAt(0);
				while (reponse != 'y' && reponse != 'n') {
					System.out.println("SVP, faites un choix valide.");
					reponse = sc2.next().charAt(0);
				}
				if (reponse == 'y') {
					data.gestionnaireSupMembre(numero);
					System.out.println("Le membre a été supprimé");
				}
				if (reponse == 'n') {
					System.out.println("Retour au au menu Gestionnaire de Membres...");
				}

				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("Le numéro de membre entré : " + numero + " est invalide");

				try {
					Thread.sleep(1500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			accueilGestionnaireMembre();
			break;
		}
	}

	/**
	 * À FAIRE On peut recopier la logique du Gestionnaire des Membres (à ma
	 * connaissance, le Gestionnaire des Membres fonctionne assez bien)
	 * 
	 * 
	 * Menu du Gestionnaire des Professionnel Permet des interactions avec
	 * l'utilisateurs. Les options présentes dans ce menu sont envoyées au Centre de
	 * Données (Contrôleur) Le Centre de Données redirige ensuite les commandes aux
	 * bonnes classes.
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

		// Boucle while qui vérifie que l'entrée est un Integer.
		while (!sc.hasNextInt()) {
			System.out.println("Svp, entrez un numéro");
			sc.next();
		}
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
			data.gestionnaireAddPro();
			accueilGestionnairePro();
			break;
		case 2:
			System.out.println("Ouverture du module recherche de Professionnel...");
			// Imprime le résultat de la recherche du pro
			System.out.println(data.gestionnaireFindPro());
			accueilGestionnairePro();
			break;
		case 3:
			System.out.println("Ouverture du module afficher tous les Membres...");
			data.gestionnaireAfficherPro();
			accueilGestionnairePro();
			break;
		}
	}

	/**
	 * La méthode pour appeler le Menu des Services.
	 * De nombreuses options s'offrent à l'utilisateur. Selon son choix, 
	 * le GestionnaireService est sollicité (en passant, toujours, par le DataCenter)
	 */
	public void menuRepertoireServices() {

		// menu principal du repertoire services
		System.out.println("================================================================================");
		System.out.println("=========================== Répertoire des Services ============================");
		System.out.println("================================================================================");
		System.out.println("\n");
		System.out.println("Sélectionnez une option");
		System.out.println("[0]     Retour au Menu principal \n");
		System.out.println("[1]     Voir les services offerts \n");
		System.out.println("[2]     Créer un nouveau service \n");
		System.out.println("[3]     Créer une nouvelle séance\n");
		System.out.println("[4]     Annuler une séance   \n");
		System.out.println("[5]     Confirmer sa  présence \n");
		System.out.println("[6]     Consulter inscriptions \n");
		System.out.println("[7]     Modifier Seance\n");

		Scanner sc2 = new Scanner(System.in);
		// Boucle while qui vérifie que l'entrée est un Integer.
		while (!sc2.hasNextInt()) {
			System.out.println("Svp, entrez un numéro");
			sc2.next();
		}
		int input2 = sc2.nextInt();

		while (input2 != 1 && input2 != 2 && input2 != 0 && input2 != 3 && input2 != 4 && input2 != 5 && input2 != 6
				&& input2 != 7) {
			System.out.println("SVP, faites un choix valide.");
			input2 = sc2.nextInt();
		}

		switch (input2) {

		case 0:
			System.out.println("Retour au Menu Principal");

			accueil();
			break;

		case 1:
			data.gestionnaireServiceAff();
			System.out.println("Le Membre désire-t-il s'inscrire à une séance?\n (y/n)");

			sc2 = new Scanner(System.in);

			char input3 = sc2.nextLine().charAt(0);

			while (input3 != 'y' && input3 != 'n') {
				System.out.println("tapez une entrée valide");
				input3 = sc2.nextLine().charAt(0);
				System.out.println(input3);

			}

			if (input3 == 'y') {
				data.gs.inscrireMembre(data);
				menuRepertoireServices();

			} else if (input3 == 'n') {
				System.out.println("retour au répertoire des services");
				menuRepertoireServices();
			}

			break;

		case 2:
			data.gestionnaireAddServ();
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			menuRepertoireServices();
			break;
			
		case 3:
			data.gestionnaireAddSeance();
			menuRepertoireServices();
			break;


		case 4:
			System.out.println("Veuillez entrer le numéro de service (7 chiffres)");
			Scanner scanna = new Scanner(System.in);
			int numbServ4 = scanna.nextInt();

			while (data.servicePosition(numbServ4) == -1) {
				System.out.println("Le Service n'existe pas, veuillez recommencer");
				numbServ4 = scanna.nextInt();
			}
			 int servicenumb = data.servicePosition(numbServ4);
			System.out.println("Veuillez taper votre numéro de séance (7 chiffres)");
			int numbMemb4 = scanna.nextInt();

			while (data.getService()[servicenumb].seanceposition(numbMemb4) == -1) {
				System.out.println("Le code de séance  n'existe pas, veuillez recommencer");
				numbMemb4 = scanna.nextInt();
			}
			 int seancenumb = data.getService()[servicenumb].seanceposition(numbMemb4);
			data.getService()[servicenumb].removeSeance(seancenumb);
			System.out.println("La séance a été retirée de l'offre de Services. Veuillez en aviser les Membres");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			menuRepertoireServices();
			break;

		case 5:
			
			
			System.out.println(
					"Veuillez entrer le code de la séance (7 chiffres) pour laquelle vous voulez confirmer la présence du Membre");
			sc2 = new Scanner(System.in);
			int reponse = sc2.nextInt();
			System.out.println("Veuillez taper le numéro de membre");
			while (!sc2.hasNextInt()) {
				System.out.println("Svp, entrez un numéro");
				reponse = sc2.nextInt();
			}
			int compteur = 0;
			
			
			
			Seance seanceEnCours = data.is.findSeance(reponse);
			if(seanceEnCours == null) {data.vue.accueil();}
			
			
			
			int user = sc2.nextInt();
			compteur = 0;

			while (data.membrePosition(user) == -1) {
				System.out.println("Le numéro de membre est invalide, veuillez recommencer");
				compteur++;
				user = sc2.nextInt();
				if (compteur >= 3) {
					System.out.println("Trop d'essais, retour au répertoire de services");
					menuRepertoireServices();
				}
			}

			boolean estPresent = false;
			Membre[] listeMembServ = seanceEnCours.getListeMembre();

			for (int i = 0; i < listeMembServ.length; i++) {
				if (user == listeMembServ[i].getNumero()) {
					estPresent = true;
				}
			}
			if (estPresent) {
				
				LocalDateTime now = LocalDateTime.now();
				String format1 = now.format(DateTimeFormatter.ISO_DATE_TIME);
				String identification = ("La présence du Membre est confirmée pour le cours suivant : \n"
						+ seanceEnCours.getTitreService() + "\n" + "Numéro du membre : "
						+ user + "\n" + "Nom du Professionel : "
						+ seanceEnCours.getPro() + "\n"
						+ "Code de la seance : " + seanceEnCours.getCode() + "\n" + "Commentaire : ")
						+"\nheure de la confirmation: " + format1; 
						
						
				
						
				System.out.println(identification);
				File dir = new File("Confirmation de présence");
				dir.mkdirs();
				
				try {
					File f = new File(dir,"Confirmation_" + user+ ".txt");
				
			
					
						f.createNewFile();
						FileWriter fw = new FileWriter(f); 
						BufferedWriter bw = new BufferedWriter(fw);
						bw.write(identification);
						bw.flush();
						fw.close();
						
					
				}catch(IOException g){
			        g.printStackTrace();
			        System.out.println("erreur fichier");
		        }	
			} else {
				System.out.println("Le Membre : " + user + " n'est pas inscrit au cours : "
						+ data.serviceListe[data.servicePosition(reponse)].getTitre());
				
			}
			menuRepertoireServices();
			break;

			
		case 6:
			System.out.println("Veuillez entrer le numéro de cours (7 chiffres) à consulter");
			sc2 = new Scanner(System.in);
			while (!sc2.hasNextInt()) {
				System.out.println("Svp, entrez un numéro de cours valide (7 chiffres)");
				sc2.next();
			}
			int codeSeance = sc2.nextInt();


			data.gs.afficherInscription(codeSeance);
			System.out.println("Retour au répertoire des services");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			menuRepertoireServices();
			break;
			
		case 7:
			data.gestionnaireModService();
			menuRepertoireServices();
			break;
			
			
			
		}
		

	}
/**
 * Methode qui permet d'acceder a la vue du menu pour la procedure comptable et la creation du rapport de synthese
 */
	public void menuComptable() {
		System.out.println("================================================================================");
		System.out.println("=========================== Procédure comptable =================================");
		System.out.println("================================================================================");
		System.out.println("\n");
		System.out.println("Sélectionnez une option");
		System.out.println("[0]     Quitter la procédure comptable \n");
		System.out.println("[1]     Générer les enregistrements TEF \n");
		System.out.println("[2]     Produire un rapport de synthèse \n");

		Scanner sc4 = new Scanner(System.in);

		while (!sc4.hasNextInt()) {
			System.out.println("Svp, entrez un numéro");
			sc4.next();
		}
		int input4 = sc4.nextInt();

		while (input4 != 1 && input4 != 2 && input4!=3 && input4 != 0) {
			System.out.println("SVP, faites un choix valide.");
			input4 = sc4.nextInt();
		}

		switch (input4) {

		case 0:
			System.out.println("Retour au Menu Principal");
			accueil();
		case 1:
			data.procedureComptable();
			accueil();
		case 2:
			data.genererRapportDeSynthese();
			accueil();
		}
	}
}