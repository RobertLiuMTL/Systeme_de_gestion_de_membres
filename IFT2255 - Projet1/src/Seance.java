import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * La classe Séance contient une liste des membres inscrits.
 * 
 * @author Robert
 *
 */
public class Seance {

	/**
	 * Les attributs de la classe Séance. La capacité maximale est de 30 membres.
	 */
	String titreService;
	Pro enseignant;
	private String nomComplet;
	private int codeSeance;
	private int prix = 0;
	private int capaciteMax;
	private int capaciteDispo;
	/**
	 * Les formats des dates doivent être modifiés afin de répondre aux consignes
	 */
	private String dateCreation;
	private String dateDebut;
	private String dateFin;
	private String heureDebut;

	// Le format des récurrences est incertaine en ce moment.
	private String recurrence;

	private String commentaire; // 100 caractères max

	public String getPro() {
		return this.nomComplet;
	}

	public int getCode() {
		return this.codeSeance;
	}

	public String getDebut() {
		return this.dateDebut;
	}

	public String getFin() {
		return this.dateFin;
	}
	
	public String getHeure() {
		return this.heureDebut;
	}
	
	public String getRecurrence() {
		return this.recurrence;
	}
	
	public int getPrix() {
		return this.prix;
	}

	// TODO Liste de membre à 30 ou bien nulle?
	private Membre[] listeMembre = new Membre[30];

	public Seance(String nomProf, int numProf, int codeSeance, int cout, int capacite,
			String dateDebut, String dateFin,String heureDebut, String recurrence, 
			String comments,String titreService) {

		// Date de création de la séance
		// Gregorian Calendar = année, mois, jour
		GregorianCalendar date = new GregorianCalendar();
		this.dateCreation = date.get(Calendar.DATE) + "-" + date.get(Calendar.MONTH) + "-" + date.get(Calendar.YEAR);
		this.titreService=titreService;
		this.nomComplet = nomProf;
		this.codeSeance = codeSeance + (numProf % 100);
		this.prix=cout;
		this.capaciteMax=capacite;
		this.capaciteDispo=capacite;
		this.dateDebut=dateDebut;
		this.dateFin=dateFin;
		this.heureDebut=heureDebut;
		this.recurrence=recurrence;
		this.commentaire=comments;
	}

/*Ancienne méthode, désusète
	public Seance(Pro enseignant, int numero) {

		// Date de création de la séance
		// Gregorian Calendar = année, mois, jour
		GregorianCalendar date = new GregorianCalendar();
		this.dateCreation = date.get(Calendar.DATE) + "-" + date.get(Calendar.MONTH) + "-" + date.get(Calendar.YEAR);

		this.enseignant = enseignant;
		this.nomComplet = enseignant.getNomComplet();

		// Le module 100 permet d'obtenir les deux derniers chiffres du numéro du
		// professionnel
		this.codeSeance = numero + enseignant.getNumero() % 100;
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
				this.prix = input;
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
				this.capaciteMax = input;
				this.capaciteDispo = input;
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

		SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");
	}
	*/
	

	/**
	 * Méthode pour inscrire un membre à cette séance.
	 * 
	 * @param membre
	 */
	public void inscrireMembre(Membre membre) {
		if (capaciteDispo == 0) {
			System.out.println("Désolé, la séance est complète. " + "Veuillez choisir une autre séance");
		} else {
			// 30 - capacité disponible = l'emplacement dans le Array.
			listeMembre[capaciteMax - capaciteDispo] = membre;
			capaciteDispo--;
			membre.ajouterSolde(prix);
			System.out.println("Le membre " +membre.getNomComplet() +" s'est inscrit à la séance!");
		}
	}

	/**
	 * Méthode pour désinscrire un Membre à la séance.
	 */
	public void desinscrireMembre(int numeroMembre) {
		Membre[] temporaire = new Membre[30];
		int positionMembre = -1;

		for (int i = 0; i < 30; i++) {
			if (listeMembre[i].getNumero() == numeroMembre) {
				positionMembre = i;
			}
		}
		for (int i = 0; i < positionMembre; i++) {

			temporaire[i] = listeMembre[i];
		}
		for (int i = positionMembre + 1; i < listeMembre.length; i++) {

			temporaire[i - 1] = listeMembre[i];
		}
		listeMembre = temporaire;

		capaciteDispo--;
	}

	/**
	 * Méthode qui affiche les membres inscrits à la présente séance.
	 */
	public String afficherInscription() {
		String msg = "Voici les membres inscrits à la séance de "
	+this.titreService+"\n"+"Nom du professionnel : "+this.nomComplet
	+"\nCode de la séance : "+this.codeSeance+"\n";
		String resultat = "";

		for (int i = 0; i <= capaciteMax - capaciteDispo; i++) {
			if(listeMembre[i]==null) {
				break;
			}else {
				resultat += listeMembre[i].getNomComplet() + "\n"
					+listeMembre[i].getNumero()+"\n";
			}

		}
		
		if (resultat == "") {
			return "Il n'y a aucun membre inscrit à cette séance\n";
		} else {
			return msg+resultat;
		}
	}

}
