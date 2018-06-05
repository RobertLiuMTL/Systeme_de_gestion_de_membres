import java.util.Scanner;

/**
 * Le module de création de Membre
 * @author Shado
 *
 */
public class CreateMembre {
	public CreateMembre (DataCenter data, Scanner sc) {
		System.out.println("================================================================================");
		System.out.println("========================= Module de création de Membre =========================");
		System.out.println("================================================================================");
		System.out.println("\n \n \n");
		System.out.println("Entrer le nom de Famille du Client :");
		String nomFamille = sc.next();
		boolean ok = false;
		while (nomFamille != " " || ok == false) {
			System.out.println("Le nom de famille entré est :" + nomFamille +
					"\nPoursuivre?");
			String reponse = sc.next();
			if (reponse=="y") {
				ok = true;
				break;
			}else if (reponse == "n"){
				System.out.println("Entrer un nouveau nom de Famille du Client :");
				nomFamille = sc.next();
				
			}
			break;
		}
		
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
