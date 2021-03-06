package projet;
import java.util.Scanner;

/**
 * C'est le module de recherche d'un Membre par son numéro. Cette classe est
 * créée par le Gestionnaire des Membres
 * 
 * Une fois instanciée, cette classe interagit avec l'utilisateur via les lignes de commande. 
 * L'information recueillie permet de faire une recherche du membre.
 * 
 * @author Robert
 *
 */
public class FindMembreByNum {

	/**
	 * Une amélioration possible serait de déplacer la fonction de recherche à une
	 * méthode à l'extérieur du Constructeur de cette classe.
	 * 
	 * @param liste : Liste de Membres
	 */
	public FindMembreByNum(Membre[] liste) {
		Scanner sc = new Scanner(System.in);

		// Le résultat de la recherche. Si l'utilisateur annule,
		// le message par défaut est affiché.
		String resultat = "La recherche a été annulée";
		System.out.println("Veuillez entrer le numéro de Membre à 9 chiffres");

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
				if (liste.length==0) {
					System.out.println("La liste de Membre est vide... Retour au menu précédent.");
					break;
				}
				for (int i = 0; i < liste.length; i++) {
					if (liste[i].getNumero() == numeroMembre) {
						resultat = "Résultat de la recherche :\n" + "Nom : " + liste[i].getNomComplet() + "\n"
								+ "Numéro de membre : " + liste[i].getNumero() + "\n" + "Date de naissance : "
								+ liste[i].getNaissance() + "\n" + "Adresse : " + liste[i].getAdresse() + "\n"
								+ "Courriel : " + liste[i].getCourriel() + "\n" + "Numéro de téléphone : "
								+ liste[i].getPhone() + "\n" + "Membre suspendu? : " + liste[i].getSuspendu() + "\n"
								+ "Membre depuis : " + liste[i].getDateCreation() + "\n" + "Commentaires : "
								+ liste[i].getComment();
						ok = true;
					}					
				}
				//Si la recherche n'aboutit pas.
				ok = true;
			}
			if (reponse == 'n') {
				System.out.println("Veuillez entrer un nouveau numéro :");
				numeroMembre = sc.nextInt();
				continue;
			}
			if (reponse == 'z') {
				break;
			}
		}
		System.out.println(resultat);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
