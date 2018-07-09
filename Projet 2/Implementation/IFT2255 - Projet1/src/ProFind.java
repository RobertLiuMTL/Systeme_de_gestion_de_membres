import java.util.Scanner;

public class ProFind {

	public String rechercheParNum(Pro[] liste) {
		Scanner sc = new Scanner(System.in);

		// Le résultat de la recherche. Si l'utilisateur annule,
		// le message par défaut est affiché.
		String resultat = "La recherche n'a donné aucun résultat.";
		System.out.println("Veuillez entrer le numéro de Professionnel à 9 chiffres");
		
		// Boucle while qui vérifie que l'entrée est un Integer.
		while (!sc.hasNextInt()) {
			System.out.println("Svp, entrez un numéro à 9 chiffres");
			sc.next();
		}
		int numeroMembre = sc.nextInt();
		boolean ok = false;
		while (ok == false) {
			System.out.println("Le numéro entré est : " + numeroMembre + "\nVoulez-vous poursuivre avec ce numéro?"
					+ "\nEntrez 'y' pour continuer ; " + "'n' pour saisir un nouveau numéro"
					+ "'z' pour quitter la recherche.");
			char reponse = sc.next().charAt(0);
			while (reponse != 'y' && reponse != 'n' && reponse != 'z') {
				System.out.println("SVP, faites un choix valide.");
				reponse = sc.next().charAt(0);
			}
			if (reponse == 'y') {
				for (int i = 0; i < liste.length; i++) {
					if (liste[i].getNumero() == numeroMembre) {
						System.out.println("OUI");
						resultat = "Résultat de la recherche :\n" + "Nom : " + liste[i].getNomComplet() + "\n"
								+ "Numéro de Professionnel : " + liste[i].getNumero() + "\n" + "discipline : " 
								+ liste[i].getDiscipline() + "\n" + "Date de naissance : "
								+ liste[i].getNaissance() + "\n" + "Adresse : " + liste[i].getAdresse() + "\n"
								+ "Courriel : " + liste[i].getCourriel() + "\n" + "Numéro de téléphone : "
								+ liste[i].getPhone() + "\n" + "Professionnel suspendu? : " + liste[i].getSuspendu()
								+ "\n" + "Membre depuis : " + liste[i].getDateCreation() + "\n" + "Commentaires : "
								+ liste[i].getComment();
						ok = true;
						break;
					
					}
					
				}
				ok = true;
			}
			if (reponse == 'n') {
				System.out.println("Veuillez entrer un nouveau numéro :");
				numeroMembre = sc.nextInt();
				continue;
			}
			if (reponse == 'z') {
				resultat = "La recherche a été annulée.";
				break;
			}
		}
		return resultat;
	}

}
