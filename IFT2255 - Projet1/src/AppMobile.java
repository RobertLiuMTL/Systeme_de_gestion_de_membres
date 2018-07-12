import java.util.Scanner;

public class AppMobile implements RegexEmail {
	DataCenter data;
	IdentificationCourriel ic = new IdentificationCourriel();

	public AppMobile(DataCenter data) {
		this.data = data;
		accueilPublic();
	}

	/**
	 * Imprime l'écran d'accueil.
	 */
	public void accueilPublic() {
		System.out.println("================================================================================");
		System.out.println("========== Bienvenue à l'application mobile du Centre Sportif #GYM =============");
		System.out.println("================================================================================");
		System.out.println("                      .-\"\"\"-.\r\n" + "                     /       \\\r\n"
				+ "                    ;_.-\"\"\"-._;\r\n" + " .,_       __,.---.-(=(o)-(o)=)-.---.,__       _,.\r\n"
				+ " '._'--\"```          \\   ^   /          ```\"--'_.'\r\n"
				+ "    ``\"''~---~~%^%^.%.`._0_.'%,^%^%^~~---~''\"``\r\n"
				+ "    ~^~- `^-% ^~.%~%.^~-%-~.%-^.% ~`% ~-`%^`-~^~\r\n" + "       ~^- ~^- `~.^- %`~.%~-'%~^- %~^- ~^");

		System.out.println("\n\n\nSélectionnez une option");
		System.out.println("[0]     Quitter l'Application mobile\n");
		System.out.println("[1]     Authentification d'un Membre \n");
		System.out.println("[2]     Authentification d'un Professionnel \n");

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
			break;
		case 1:
			// Validation du membre en 2 étapes.
			// Il faut d'abord entrer une adresse courriel valide
			// Il faut ensuite entrer un numéro valide (qui n'est pas suspendu)

			System.out.println("Veuillez entrer votre adresse courriel de Membre");
			String courriel = "";
			sc = new Scanner(System.in);
			courriel = sc.nextLine();
			while (emailIsValid(courriel) == false) {
				System.out.println("Svp, entrez un courriel valide");
				courriel = sc.nextLine();
			}

			Membre membre = ic.membreCourriel(data.getMembre(), courriel);
			if (membre == null) {
				System.out.println("Il n'existe aucun membre associé à cette adresse courriel.");
				accueilPublic();
			} else {
				System.out.println(
						"Bonjour " + membre.getNomComplet() + ", votre adresse courriel a été validée correctement!");
				System.out.println(
						"Veuillez entrer votre numéro de Membre à 9 chiffres pour compléter l'identification.");
				sc = new Scanner(System.in);
				while (!sc.hasNextInt()) {
					System.out.println("Svp, entrez un numéro valide à 9 chiffres");
					sc.next();
				}
				int attempts = 3;
				int numero = sc.nextInt();

				while (attempts > 0) {
					if (data.identifierMembre(numero) == null) {
						attempts--;
						System.out.println(
								"Numéro invalide. Veuillez réessayer.\nIl vous reste " + attempts + " essais.");
						numero = sc.nextInt();
						continue;
					} else {
						if (membre.getSuspendu() == true) {
							System.out.println("Membre suspendu");
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							System.out.println("Validé. Veuillez patientez pendant que nous accédons à votre compte.");
							accueilMembre(membre);
						}
						break;
					}
				}
			}
			break;
		case 2:

			// Validation du membre en 2 étapes.
			// Il faut d'abord entrer une adresse courriel valide
			// Il faut ensuite entrer un numéro valide (qui n'est pas suspendu)

			System.out.println("Veuillez entrer votre adresse courriel de Professionnel");

			sc = new Scanner(System.in);
			courriel = sc.nextLine();
			// S'assurer que le courriel est bien écrit
			while (emailIsValid(courriel) == false) {
				System.out.println("Svp, entrez un courriel valide");
				courriel = sc.nextLine();
			}
			
			Pro pro = ic.proCourriel(data.getPro(), courriel);
			if (pro == null) {
				System.out.println("Il n'existe aucun Professionnel associé à cette adresse courriel.");
				accueilPublic();
			} else {
				System.out.println(
						"Bonjour " + pro.getNomComplet() + ", votre adresse courriel a été validée correctement!");
				System.out.println(
						"Veuillez entrer votre numéro de Professionnel à 9 chiffres pour compléter l'identification.");
				sc = new Scanner(System.in);
				while (!sc.hasNextInt()) {
					System.out.println("Svp, entrez un numéro valide à 9 chiffres");
					sc.next();
				}
				int attempts = 3;
				int numero = sc.nextInt();

				while (attempts > 0) {
					if (data.identifierPro(numero) == null) {
						attempts--;
						System.out.println(
								"Numéro invalide. Veuillez réessayer.\nIl vous reste " + attempts + " essais.");
						numero = sc.nextInt();
						continue;
					} else {
						if (pro.getSuspendu() == true) {
							System.out.println("Professionnel suspendu");
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							System.out.println("Validé. Veuillez patientez pendant que nous accédons à votre compte.");
							accueilPro(pro);
						}
						break;
					}
				}
			}

			break;
		}

	}

	/**
	 * Le menu d'accueil mobile pour les Membres authentifiés.
	 * TODO : Ajouter les différents SWITCH CASE
	 * @param membre : Prend en argument le compte du Membre qui servira à accéder à ses factures et qui lui permettra de s'inscrire.
	 */
	public void accueilMembre(Membre membre) {
		System.out.println("================================================================================");
		System.out.println("Bienvenue "+ membre.getNomComplet()+" à l'application mobile pour les Membres");
		System.out.println("Votre numéro de Membre est : " +membre.getNumero());
		System.out.println("================================================================================");

		System.out.println("\n\n\nSélectionnez une option");
		System.out.println("[0]     Quitter l'Application mobile pour Membre\n");
		System.out.println("[1]     Voir les Services offerts et s'inscrire à un service \n");
		System.out.println("[2]     Voir mes Services de la semaine\n");
		System.out.println("[3]     Consulter ma facture\n");
		
		
		Scanner sc = new Scanner(System.in);

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
			break;
		case 1:
			data.gestionnaireServiceAff();
		case 2:
		case 3: 
		}
	}
	
	public void accueilPro (Pro pro) {
		System.out.println("================================================================================");
		System.out.println("Bienvenue "+ pro.getNomComplet()+" à l'application mobile pour les Professionnels");
		System.out.println("Votre numéro de Professionnel est : " +pro.getNumero());
		System.out.println("================================================================================");

	}

}
