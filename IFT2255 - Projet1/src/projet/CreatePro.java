package projet;
import java.util.Scanner;


/**
 * C'est le module de création d'un professionnel.
 * 
 * À l'aide de lignes de commandes, l'utilisateur est invité à entrer toute l'information requise.
 * 
 * Une fois l'information complétée, un appel est lancé via le DataCenter pour ajouter le professionnel.
 * @author Robert
 *
 */
public class CreatePro {
	//les attributs qui seront utilisés pour la création du membre
		private String nomFamille;
		private String prenom;
		private String adresse;
		private String naissance;
		private String phone;
		private String courriel;
		private String discipline;
		private String province;
		private String city;
		private String codepostal;
		Scanner sc = new Scanner(System.in);
		Scanner scString = new Scanner(System.in);
		
		/**
		 * Constructeur qui envoie les lignes de commandes et qui reçoit les résultats
		 * @param data : DAtaCenter
		 */
		public CreatePro (DataCenter data) {
			System.out.println("================================================================================");
			System.out.println("==================== Module de création d'un Professionnel =====================");
			System.out.println("================================================================================");
			System.out.println("\n \n");
			System.out.println("Entrer le nom de Famille du Professionnel :");
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
					System.out.println("Entrez un nouveau nom de Famille du Professionnel :");
					nomFamille = scString.nextLine();
					continue;
					
				}
				break;
			}
			
			System.out.println("\nEntrez le Prénom du Professionnel :");
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
					System.out.println("Entrez le prénom du Professionnel :");
					prenom = scString.nextLine();
					continue;
				}
				break;
			}
			
			System.out.println("\nEntrez l'adresse du Professionnel :");
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
					System.out.println("Entrez à nouveau l'adresse du Professionnel :");
					adresse = scString.nextLine();
					continue;
				}
				break;
			}
			
			
			System.out.println("\nEntrez la date de naissance du Professionnel:");
			System.out.println("\nEntrez le jour de naissance du professionnel (JJ):");
			scString = new Scanner(System.in);
			String jour = scString.nextLine();
			System.out.println("Entrez le mois de naissance du professionnel (MM)");
			String mois = scString.nextLine();
			System.out.println("Entrez l'année de naissance du professionnel (AAAA)");
			String annee = scString.nextLine();
			ok = false;
			while (ok == false) {
				System.out.println("La date de naissance entrée est :" + jour + "-" + mois + "-" + annee +
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
					continue;
				}
				break;
			}
			
			System.out.println("\nEntrez le numéro de téléphone du Professionnel :");
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
					System.out.println("Entrez à nouveau le numéro de téléphone du Professionnel :");
					phone = scString.nextLine();
					continue;
				}
				break;
			}
			
			System.out.println("\nEntrez l'adresse courriel du Professionnel :");
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
					System.out.println("Entrez à nouveau l'adresse courriel du Professionnel :");
					adresse = scString.nextLine();
					continue;
				}
				break;
			}
			
			System.out.println("\nEntrez la discipline du Professionnel:");
			scString = new Scanner(System.in);
			discipline = scString.nextLine();
			ok = false;
			while (ok == false) {
				System.out.println("La discipline entrée est :" + discipline+
						"\nVoulez-vous poursuivre avec cette discipline? "
						+ "\nEntrez 'y' pour continuer ; "
						+ "'n' pour saisir une nouvelle discipline.");
				char reponse = sc.next().charAt(0);
				while (reponse != 'y' && reponse != 'n') {
					System.out.println("SVP, faites un choix valide.");
					reponse = sc.next().charAt(0);	
				}
				if (reponse=='y') {
					ok = true;
					System.out.println("La discipline : " + discipline+ " a été enregistrée.");
				}
				if (reponse == 'n'){
					System.out.println("Entrez à nouveau la discipline du Professionnel:");
					discipline = scString.nextLine();
					continue;
				}
				break;
			}
			
			System.out.println("\nEntrez la province du Professionnel :");
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
					System.out.println("Entrez à nouveau la province du Professionnel :");
					adresse = scString.nextLine();
					continue;
				}
				break;
			}
			
			System.out.println("\nEntrez la ville du Professionnel :");
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
					System.out.println("Entrez à nouveau la ville du Professionnel :");
					adresse = scString.nextLine();
					continue;
				}
				break;
			}
			
			System.out.println("\nEntrez le code postal du Professionnel :");
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
					System.out.println("Entrez à nouveau le code postal du Professionnel :");
					adresse = scString.nextLine();
					continue;
				}
				break;
			}
			
				data.addPro(nomFamille, prenom, adresse, naissance, phone, courriel, discipline, province, city, codepostal);
				System.out.println("le professionnel a été avec succes");
		}
}
