import java.util.Scanner;

/**
 * Le module de création de Membre
 * @author Shado
 *
 */
public class CreateMembre {
	
	public String nomFamille;
	public String prenom;
	public String adresse;
	public String naissance;
	public String phone;
	public String courriel;
	Scanner sc = new Scanner(System.in);
	Scanner scString = new Scanner(System.in);
	
	public CreateMembre (DataCenter data) {
		System.out.println("================================================================================");
		System.out.println("========================= Module de création de Membre =========================");
		System.out.println("================================================================================");
		System.out.println("\n \n \n");
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
		
		System.out.println("Entrez le Prénom du Client :");
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
		
		System.out.println("Entrez l'adresse du Client :");
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
		
		
		System.out.println("Entrez la date de naissance du Client :");
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
		
		System.out.println("Entrez le numéro de téléphone du Client :");
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
		
		System.out.println("Entrez l'adresse courriel du Client :");
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
		
		data.addMember(nomFamille, prenom, adresse, naissance, phone, courriel);
	}
}

//String nomFamille, String prenom, String adresse, String naissance, String phone, String courriel
//while(nomFamille!= "" && !ok) {
//System.out.println("Le nom de famille entré est :" + nomFamille +
	//	"\nPoursuivre?");
//String reponse = sc.nextLine();
//if (reponse=="y") {
//	break;
//}else {
//	System.out.println("Entrer un nouveau nom de Famille du Client :");
//	nomFamille = sc.nextLine();
//}
//break;

//}
