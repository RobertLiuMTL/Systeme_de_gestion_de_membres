import java.util.Scanner;

/**
 * Le module de création de Membre.
 * 
 * Interagit avec l'utilisateur sous formes de lignes de commande.
 * Une fois toute l'information recueillie, on fait appel à la fonciton de création de Membre contenue dans le DataCenter.
 * 
 * @author Robert
 *
 */
public class CreateMembre implements RegexEmail {
	//les attributs qui seront utilisés pour la création du membre
	private String nomFamille;
	private String prenom;
	private String adresse;
	private String naissance;
	private String phone;
	private String courriel;
	private String province;
	private String city;
	private String codepostal;
	
	Scanner sc = new Scanner(System.in);
	Scanner scString = new Scanner(System.in);
	
	/**
	 * Constructeur qui envoie les lignes de commandes et qui reçoit les résultats
	 * @param data
	 */
	public CreateMembre (DataCenter data) {
		System.out.println("================================================================================");
		System.out.println("========================= Module de création de Membre =========================");
		System.out.println("================================================================================");
		System.out.println("\n");
		System.out.println("Entrer le nom de Famille du Client :");
		nomFamille = scString.nextLine();
		boolean ok = false;
		while (ok == false) {
			System.out.println("Le nom de famille entré est :" + nomFamille +
					"\nVoulez-vous poursuivre avec ce nom de famille?"
					+ "\nEntrez 'y' pour continuer ; "
					+ "'n' pour saisir un nouveau nom de famille ");
			char reponse = sc.next().charAt(0);
			while (reponse != 'y' && reponse != 'n') {
				System.out.println("SVP, faites un choix valide.");
				reponse = sc.next().charAt(0);	
			}
			if (reponse=='y') {
				ok = true;
				System.out.println("Le nom de famille : " + nomFamille + " a été enregistré.");
			}
			if (reponse == 'n'){
				System.out.println("Entrez un nouveau nom de Famille du Client :");
				nomFamille = scString.nextLine();
				continue;
				
			}
			break;
		}
		
		System.out.println("\nEntrez le Prénom du Client :");
		prenom = scString.nextLine();
		ok = false;
		while (ok == false) {
			System.out.println("Le prénom entré est :" + prenom +
					"\nVoulez-vous poursuivre avec ce prénom? "
					+ "\nEntrez 'y' pour continuer ; "
					+ "'n' pour saisir un nouveau prénom.");
			char reponse = sc.next().charAt(0);
			while (reponse != 'y' && reponse != 'n') {
				System.out.println("SVP, faites un choix valide.");
				reponse = sc.next().charAt(0);	
			}
			if (reponse=='y') {
				ok = true;
				System.out.println("Le prénom : " + prenom + " a été enregistré.");
			}
			if (reponse == 'n'){
				System.out.println("Entrez le prénom du Client :");
				prenom = scString.nextLine();
				continue;
			}
			break;
		}
		
		System.out.println("\nEntrez l'adresse du Client :");
		scString = new Scanner(System.in);
		adresse = scString.nextLine();
		ok = false;
		while (ok == false) {
			System.out.println("L'adresse entrée est :" + adresse+
					"\nVoulez-vous poursuivre avec cette adresse? "
					+ "\nEntrez 'y' pour continuer ; "
					+ "'n' pour saisir une nouvelle adresse.");
			char reponse = sc.next().charAt(0);
			while (reponse != 'y' && reponse != 'n') {
				System.out.println("SVP, faites un choix valide.");
				reponse = sc.next().charAt(0);	
			}
			if (reponse=='y') {
				ok = true;
				System.out.println("L'adresse : " + adresse+ " a été enregistrée.");
			}
			if (reponse == 'n'){
				System.out.println("Entrez à nouveau l'adresse du Client :");
				adresse = scString.nextLine();
				continue;
			}
			break;
		}
		
		
		System.out.println("\nEntrez la date de naissance du Client :");
		scString = new Scanner(System.in);
		naissance = scString.nextLine();
		ok = false;
		while (ok == false) {
			System.out.println("La date de naissance entrée est :" + naissance+
					"\nVoulez-vous poursuivre avec cette date de naissance? "
					+ "\nEntrez 'y' pour continuer ; "
					+ "'n' pour saisir une nouvelle date de naissance.");
			char reponse = sc.next().charAt(0);
			while (reponse != 'y' && reponse != 'n') {
				System.out.println("SVP, faites un choix valide.");
				reponse = sc.next().charAt(0);	
			}
			if (reponse=='y') {
				ok = true;
				System.out.println("La date de naissance " + naissance+ " a été enregistrée.");
			}
			if (reponse == 'n'){
				System.out.println("Entrez à nouveau la date de naissance du Client :");
				naissance = scString.nextLine();
				continue;
			}
			break;
		}
		
		System.out.println("\nEntrez le numéro de téléphone du Client :");
		scString = new Scanner(System.in);
		phone = scString.nextLine();
		ok = false;
		while (ok == false) {
			System.out.println("Le numéro de téléphone entré est :" + phone+
					"\nVoulez-vous poursuivre avec ce numéro? "
					+ "\nEntrez 'y' pour continuer ; "
					+ "'n' pour saisir un nouveau numéro de télépohne.");
			char reponse = sc.next().charAt(0);
			while (reponse != 'y' && reponse != 'n') {
				System.out.println("SVP, faites un choix valide.");
				reponse = sc.next().charAt(0);	
			}
			if (reponse=='y') {
				ok = true;
				System.out.println("Le numéro de téléphone : " + phone+ " a été enregistré.");
			}
			if (reponse == 'n'){
				System.out.println("Entrez à nouveau le numéro de téléphone du Client :");
				phone = scString.nextLine();
				continue;
			}
			break;
		}
		
		System.out.println("\nEntrez l'adresse courriel du Client :");
		scString = new Scanner(System.in);
		courriel = scString.nextLine();
		ok = false;
		while (ok == false) {
			System.out.println("L'adresse courriel entrée est :" + courriel+
					"\nVoulez-vous poursuivre avec cette adresse courriel? "
					+ "\nEntrez 'y' pour continuer ; "
					+ "'n' pour saisir une nouvelle adresse courriel.");
			char reponse = sc.next().charAt(0);
			while (reponse != 'y' && reponse != 'n') {
				System.out.println("SVP, faites un choix valide.");
				reponse = sc.next().charAt(0);	
			}
			if (reponse=='y') {
				ok = true;
				System.out.println("L'adresse courriel : " + courriel+ " a été enregistrée.");
			}
			if (reponse == 'n'){
				System.out.println("Entrez à nouveau l'adresse courriel du Client :");
				adresse = scString.nextLine();
				continue;
			}
			break;
		}
		
		System.out.println("\nEntrez la province du Client :");
		scString = new Scanner(System.in);
		province = scString.nextLine();
		ok = false;
		while (ok == false) {
			System.out.println("L'adresse courriel entrée est :" + province +
					"\nVoulez-vous poursuivre avec cette province? "
					+ "\nEntrez 'y' pour continuer ; "
					+ "'n' pour saisir une nouvelle province.");
			char reponse = sc.next().charAt(0);
			while (reponse != 'y' && reponse != 'n') {
				System.out.println("SVP, faites un choix valide.");
				reponse = sc.next().charAt(0);	
			}
			if (reponse=='y') {
				ok = true;
				System.out.println("La province : " + province + " a été enregistrée.");
			}
			if (reponse == 'n'){
				System.out.println("Entrez à nouveau la province du Client :");
				adresse = scString.nextLine();
				continue;
			}
			break;
		}
		
		System.out.println("\nEntrez la ville du Client :");
		scString = new Scanner(System.in);
		city = scString.nextLine();
		ok = false;
		while (ok == false) {
			System.out.println("La ville entrée est :" + city+
					"\nVoulez-vous poursuivre avec cette ville? "
					+ "\nEntrez 'y' pour continuer ; "
					+ "'n' pour saisir une nouvelle ville.");
			char reponse = sc.next().charAt(0);
			while (reponse != 'y' && reponse != 'n') {
				System.out.println("SVP, faites un choix valide.");
				reponse = sc.next().charAt(0);	
			}
			if (reponse=='y') {
				ok = true;
				System.out.println("La ville: " + city + " a été enregistrée.");
			}
			if (reponse == 'n'){
				System.out.println("Entrez à nouveau la ville du Client :");
				adresse = scString.nextLine();
				continue;
			}
			break;
		}
		
		System.out.println("\nEntrez le code postal du Client :");
		scString = new Scanner(System.in);
		codepostal = scString.nextLine();
		ok = false;
		while (ok == false) {
			System.out.println("Le code postal entrée est :" + codepostal +
					"\nVoulez-vous poursuivre avec ce code postal? "
					+ "\nEntrez 'y' pour continuer ; "
					+ "'n' pour saisir un nouveau code postal.");
			char reponse = sc.next().charAt(0);
			while (reponse != 'y' && reponse != 'n') {
				System.out.println("SVP, faites un choix valide.");
				reponse = sc.next().charAt(0);	
			}
			if (reponse=='y') {
				ok = true;
				System.out.println("Le code postal : " + codepostal+ " a été enregistré.");
			}
			if (reponse == 'n'){
				System.out.println("Entrez à nouveau le code postal du Client :");
				adresse = scString.nextLine();
				continue;
			}
			break;
		}
		
		//Une fois toute l'informations recueillie, le processus de création de Membre se poursuit avec le Centre de Données
		data.addMember(nomFamille, prenom, adresse, naissance, phone, courriel, province, city, codepostal);
	}
}

