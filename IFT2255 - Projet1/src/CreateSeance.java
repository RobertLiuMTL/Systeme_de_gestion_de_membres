import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Interface pour la Classe GestionnaireService qui permet la création de Service.
 * 
 * Cette interface propose le module d'interaction avec l'utilisateur en lignes de commande.
 * 
 * Une fois toute l'information recueillie, 
 * Un appel est lancé à : service.addSeance(nomPro,numPro,prix,capaciteMax,dateDebut,
				dateFin,heureDebut,recurrence,commentaire);
 * 
 * @author Robert
 *
 */
public interface CreateSeance {
	
	public default void createSeance(Service service, Pro pro) {
		String nomPro= pro.getNomComplet();
		int numPro = pro.getNumero();
		int prix = 0;
		int capaciteMax=0;
		int capaciteDispo;
		String dateCreation;
		String dateDebut;
		String dateFin;
		String heureDebut;
		String recurrence="";
		String commentaire;
		
		
		System.out.println("================================================================================");
		System.out.println("================================ Création de séance ============================");
		System.out.println("================================================================================");
		System.out.println("\n");

		Scanner sc = new Scanner(System.in);

		System.out.println("Veuillez entrer le prix de la séance");

		// Boucle while qui vérifie que l'entrée est un Integer.
		while (!sc.hasNextInt()) {
			System.out.println("Svp, entrez un montant entre 0 à 100");
			sc.next();
		}
		int input = sc.nextInt();

		boolean ok = false;
		while (ok == false) {
			System.out.println("Le montant entré est :" + input + "\nVoulez-vous poursuivre? "
					+ "\nEntrez 'y' pour continuer ; " + "'n' pour saisir un nouveau nombre.");
			char reponse = sc.next().charAt(0);
			while (reponse != 'y' && reponse != 'n') {
				System.out.println("SVP, faites un choix valide.");
				reponse = sc.next().charAt(0);
			}
			if (reponse == 'y') {
				ok = true;
				prix = input;
			}
			if (reponse == 'n') {
				System.out.println("Entrez un nouveau montant :");
				sc = new Scanner(System.in);
				input = sc.nextInt();
				continue;
			}
			break;
		}

		System.out.println("Veuillez entrer la capacité maximale du cours (0 à 30)");

		// Boucle while qui vérifie que l'entrée est un entier valide.
		while (!sc.hasNextInt() && sc.nextInt() <= 30) {
			System.out.println("Svp, entrez un montant entre 0 à 30");
			sc.next();
		}
		input = sc.nextInt();

		ok = false;
		while (ok == false) {
			System.out.println("La capacité maximale a été fixée à :" + input + "\nVoulez-vous poursuivre? "
					+ "\nEntrez 'y' pour continuer ; " + "'n' pour saisir un nouveau nombre.");
			char reponse = sc.next().charAt(0);
			while (reponse != 'y' && reponse != 'n') {
				System.out.println("SVP, faites un choix valide.");
				reponse = sc.next().charAt(0);
			}
			if (reponse == 'y') {
				ok = true;
				if (input > 30) {
					System.out
							.println("La capacité du cours a été établie à 30 étudiants (Capacité maximale permise).");
					input = 30;
				}
				capaciteMax = input;
				capaciteDispo = input;
			}
			if (reponse == 'n') {
				System.out.println("Entrez un nouveau nombre :");
				sc = new Scanner(System.in);
				input = sc.nextInt();
				continue;
			}
			break;
		}

		sc = new Scanner(System.in);

		System.out.println("Veuillez entrer la Date de début.");
		System.out.println("Veuillez entrer le jour de début de la séance.");
		// Boucle while qui vérifie que l'entrée est un Integer.
		while (!sc.hasNextInt()) {
			System.out.println("Svp, entrez un montant entre 1 à 31");
			sc.next();
		}
		int jour = sc.nextInt();

		System.out.println("Veuillez entrer le mois de début de la séance.");
		// Boucle while qui vérifie que l'entrée est un Integer.
		while (!sc.hasNextInt()) {
			System.out.println("Svp, entrez un montant entre 1 à 12");
			sc.next();
		}
		int mois = sc.nextInt();

		System.out.println("Veuillez entrer l'année de début de la séance.");
		// Boucle while qui vérifie que l'entrée est un Integer.
		while (!sc.hasNextInt()) {
			System.out.println("Svp, entrez une année");
			sc.next();
		}
		int annee = sc.nextInt();

		GregorianCalendar dateCalendar = new GregorianCalendar(annee, mois, jour);
		dateDebut = dateCalendar.get(Calendar.DATE) + "-" + dateCalendar.get(Calendar.MONTH) + "-"
				+ dateCalendar.get(Calendar.YEAR);

		System.out.println("Veuillez entrer la Date de fin.");
		System.out.println("Veuillez entrer le jour de fin de la séance.");
		// Boucle while qui vérifie que l'entrée est un Integer.
		while (!sc.hasNextInt()) {
			System.out.println("Svp, entrez un montant entre 1 à 31");
			sc.next();
		}
		jour = sc.nextInt();

		System.out.println("Veuillez entrer le mois de fin de la séance.");
		// Boucle while qui vérifie que l'entrée est un Integer.
		while (!sc.hasNextInt()) {
			System.out.println("Svp, entrez un montant entre 1 à 12");
			sc.next();
		}
		mois = sc.nextInt();

		System.out.println("Veuillez entrer l'année de fin de la séance.");
		// Boucle while qui vérifie que l'entrée est un Integer.
		while (!sc.hasNextInt()) {
			System.out.println("Svp, entrez une année");
			sc.next();
		}
		annee = sc.nextInt();

		dateCalendar = new GregorianCalendar(annee, mois, jour);
		dateFin = dateCalendar.get(Calendar.DATE) + "-" + dateCalendar.get(Calendar.MONTH) + "-"
				+ dateCalendar.get(Calendar.YEAR);

		System.out.println("Veuillez entrer l'Heure de début de la séance.");
		System.out.println("Veuillez entrer une heure entre 7 à 21.");
		while (!sc.hasNextInt()) {
			System.out.println("Svp, entrez une heure valide entre 7 à 21");
			sc.next();
		}
		int heureInput = sc.nextInt();
		while (heureInput>21 || heureInput<7) {
			System.out.println("Les heures d'ouvertures du GYM sont"
					+ "de 7 am à 23 pm. SVP, entrez une heure valide (7 à 21)");
			heureInput = sc.nextInt();
		}
		System.out.println("Veuillez entrer les minutes (0 à 59).");
		while (!sc.hasNextInt()) {
			System.out.println("Svp, entrez un nombre valide entre 0 à 59");
			sc.next();
		}
		int minuteInput = sc.nextInt();
		while (minuteInput>59 || minuteInput<0) {
			System.out.println("SVP, entrez un nombre entre 0 à 59");
			minuteInput = sc.nextInt();
		}
		heureDebut = ""+heureInput+":"+minuteInput;
		
		
		System.out.println("Veuillez entrer le jour de la semaine de la séance.");
		System.out.println("1:Lundi\n2:Mardi\n3:Mercredi\n4:Jeudi"
				+ "\n5:Vendredi\n6:Samedi\n7:Dimanche\n");
		while (!sc.hasNextInt()) {
			System.out.println("Svp, entrez un nombre valide entre 0 à 7");
			sc.next();
		}
		int jourInput = sc.nextInt();
		while (jourInput>7 || jourInput<1) {
			System.out.println("SVP, entrez un jour valide entre 1 à 7");
			jourInput = sc.nextInt();
		}
		switch(jourInput) {
		case 1:recurrence = "Lundi";
		case 2:recurrence = "Mardi";
		case 3:recurrence = "Mercredi";
		case 4:recurrence = "Jeudi";
		case 5:recurrence = "Vendredi";
		case 6:recurrence = "Samedi";
		case 7:recurrence = "Dimanche";
		}
		
		System.out.println("Veuillez entrer des commentaires, s'il y a lien.");
		commentaire=sc.nextLine();
		while(commentaire.length()>100) {
			System.out.println("Le commentaire ne peut pas dépasser 100 caractères."
					+ "\nEntrez un nouveau commentaire ou appuyez sur ENTER pour poursuivre");
			commentaire=sc.nextLine();
		}
		
		service.addSeance(nomPro,numPro,prix,capaciteMax,dateDebut,
				dateFin,heureDebut,recurrence,commentaire);

	}
	
	
}
