import java.util.Scanner;

/**
 * La classe Séance contient une liste des membres inscrits.
 * @author Shado
 *
 */
public class Seance {
	
	/**
	 * Les attributs de la classe Séance. La capacité maximale est de 30 membres.
	 */
	private Pro enseignant;
	private int prix =0;
	private int capaciteMax;
	private int capaciteDispo = 30;

	/**
	 * Les formats des dates doivent être modifiés afin de répondre aux consignes
	 */
	private String dateDebut;
	private String dateFin;
	private String heureDebut;
	
	//Le format des récurrences est incertaine en ce moment.
	private String recurrence;
	
	private String commentaire; //100 caractères max
	
	private Membre[] listeMembre = new Membre[30];
	
	/**
	 * Constructeur de la classe Séance qui prend en paramètre
	 * le Professionnel.
	 * @param enseignant
	 */
	public Seance(Pro enseignant) {
		this.enseignant=enseignant;
		System.out.println("================================================================================");
		System.out.println("================================ Création de séance=============================");
		System.out.println("================================================================================");
		System.out.println("\n");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Veuillez entrer le prix de la séance");
		
		// Boucle while qui vérifie que l'entrée est un Integer.
		while (!sc.hasNextInt() || sc.nextInt() < 100 && sc.nextInt() >=0) {
			System.out.println("Svp, entrez un montant entre 0 à 100");
			sc.next();
		}
		int input = sc.nextInt();
		
		boolean ok = false;
		while (ok == false) {
			System.out.println("Le montant entré est :" + input +
					"\nVoulez-vous poursuivre? "
					+ "\nEntrez 'y' pour continuer ; "
					+ "'n' pour saisir un nouveau nombre.");
			char reponse = sc.next().charAt(0);
			while (reponse != 'y' && reponse != 'n') {
				System.out.println("SVP, faites un choix valide.");
				reponse = sc.next().charAt(0);	
			}
			if (reponse=='y') {
				ok = true;
				this.prix = input;
			}
			if (reponse == 'n'){
				System.out.println("Entrez un nouveau montant :");
				sc = new Scanner(System.in);
				sc.nextInt();
				continue;
			}
			break;
		}
		
		System.out.println("Veuillez entrer la capacité maximale du cours (0 à 30)");
		
		// Boucle while qui vérifie que l'entrée est un entier valide.
		while (!sc.hasNextInt() || sc.nextInt() <= 30 && sc.nextInt() > 0) {
			System.out.println("Svp, entrez un montant entre 0 à 100");
			sc.next();
		}
		input = sc.nextInt();
		ok = false;
		while (ok == false) {
			System.out.println("La capacité maximale a été fixée à :" + input +
					"\nVoulez-vous poursuivre? "
					+ "\nEntrez 'y' pour continuer ; "
					+ "'n' pour saisir un nouveau nombre.");
			char reponse = sc.next().charAt(0);
			while (reponse != 'y' && reponse != 'n') {
				System.out.println("SVP, faites un choix valide.");
				reponse = sc.next().charAt(0);	
			}
			if (reponse=='y') {
				ok = true;
				this.capaciteMax = input;
			}
			if (reponse == 'n'){
				System.out.println("Entrez un nouveau nombre :");
				sc = new Scanner(System.in);
				sc.nextInt();
				continue;
			}
			break;
		}
		
	}
	
	/**
	 * Méthode pour inscrire un membre à cette séance.
	 * @param membre
	 */
	public void inscrireMembre(Membre membre) {
		if(capaciteDispo ==0) {
			System.out.println("Désolé, la séanece est complète. "
					+ "Veuillez choisir une autre séance");
		}else {
			//30 - capacité disponible = l'emplacement dans le Array.
			listeMembre[30-capaciteDispo]=membre;
			membre.ajouterSolde(prix);
		}
	}
	
	
}
