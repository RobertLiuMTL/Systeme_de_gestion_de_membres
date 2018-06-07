import java.util.Scanner;

public class GestionnaireMembreFindMembreByName {
	
	public GestionnaireMembreFindMembreByName (Membre[]liste) {
		Scanner sc = new Scanner(System.in);
		
		//Le résultat de la recherche. Si l'utilisateur annule,
		//le message par défaut est affiché.
		String resultat = "La recherche a été annulée";
		
		int numeroMembre = sc.nextInt();
		boolean ok = false;
		while (ok == false) {
			System.out.println("Le numéro entré est : " + numeroMembre +
					"\nVoulez-vous poursuivre avec ce numéro?"
					+ "\nEntrez 'y' pour continuer ; "
					+ "'n' pour saisir un nouveau numéro"
					+ "'z' pour quitter la recherche.");
			char reponse = sc.next().charAt(0);
			while (reponse != 'y' && reponse != 'n' && reponse!='z') {
				System.out.println("SVP, faites un choix valide.");
				reponse = sc.next().charAt(0);	
			}
			if (reponse=='y') {
				for (int i = 0; i<liste.length;i++) {
					if (liste[i].getNumero()== numeroMembre) {
						resultat ="Résultat de la recherche :\n" 
								+"Nom : "+liste[i].getPrenom() +"\n"
								+"Numéro de membre : "+liste[i].getNumero()+"\n"
								+"Date de naissance : "+liste[i].getNaissance()+"\n"
								+"Adresse : "+liste[i].getAdresse()+"\n"
								+"Courriel : " + liste[i].getCourriel()+"\n"
								+"Numéro de téléphone : " + liste[i].getPhone()+"\n"
								+"Statut : "+liste[i].getStatut();
						ok=true;
					}else {
						resultat = "Le numéro entré est introuvable";
						ok = true;
					}
				}
			}
			if (reponse == 'n'){
				System.out.println("Veuillez entrer un nouveau numéro :");
				numeroMembre= sc.nextInt();
				continue;
				
			}
			if(reponse=='z') {
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
