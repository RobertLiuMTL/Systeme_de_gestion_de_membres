import java.util.Scanner;

/**
 * Classe qui est instanciée par le Gestionnaire des Membres
 * C'est la méthode de recherche par nom.
 * @author Robert
 *
 */
public class FindMembreByName {
	
	public FindMembreByName (Membre[]liste) {
		Scanner sc = new Scanner(System.in);
		
		//Le résultat de la recherche. Si l'utilisateur annule,
		//le message par défaut est affiché.
		String resultat = "La recherche a été annulée";
		String resultatPositif="";
		System.out.println("Veuillez entrer le nom de famille de la personne.");
		String nomFamille = sc.nextLine();		

		boolean ok = false;
		while (ok == false) {
			System.out.println("\nVoulez-vous poursuivre?"
					+ "\nEntrez 'y' pour continuer ; "
					+ "'n' pour saisir à nouveau"
					+ "'z' pour quitter la recherche.");
			char reponse = sc.next().charAt(0);
			while (reponse != 'y' && reponse != 'n' && reponse!='z') {
				System.out.println("SVP, faites un choix valide.");
				reponse = sc.next().charAt(0);	
			}
			if (reponse=='y') {
				if (liste.length==0) {
					System.out.println("La liste de Membre est vide");
					break;
				}else {
					for (int i = 0; i<liste.length;i++) {
						if (liste[i].getNomFamille().equalsIgnoreCase(nomFamille)) {
							resultatPositif +="*****************************************\n"
								+ "Résultat(s) de la recherche :\n" 
								+"Nom : "+liste[i].getNomComplet() +"\n"
								+"Numéro de membre : "+liste[i].getNumero()+"\n"
								+"Date de naissance : "+liste[i].getNaissance()+"\n"
								+"Adresse : "+liste[i].getAdresse()+"\n"
								+"Courriel : " + liste[i].getCourriel()+"\n"
								+"Numéro de téléphone : " + liste[i].getPhone()+"\n"
								+"Membre suspendu? : "+liste[i].getSuspendu() +"\n"
								+"Membre depuis : " +liste[i].getDateCreation()+"\n"
								+"Commentaires : "+liste[i].getComment();
							ok=true;
						}
					}
					ok=true;
				}
			}
			if (reponse == 'n'){
				System.out.println("Veuillez entre un nouveau nom de Famille");
				nomFamille = sc.nextLine();
				continue;
				
			}
			if(reponse=='z') {
				ok=true;
				break;
			}
		}
		
		//Si la recherche aboutit à résultat, on imprime les membres
		//Sinon, on imprime le message d'échec.
		if (resultatPositif !="") {
			System.out.println(resultatPositif);
		}else {
			System.out.println(resultat);
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
