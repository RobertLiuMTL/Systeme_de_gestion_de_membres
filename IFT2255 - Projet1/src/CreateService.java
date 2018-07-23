import java.util.Scanner;
/**
 * 
 * @author Marc-André
 *La classe c'est juste une methode qui fais la vue pour la creation d'un service
 */
public class CreateService {

	public CreateService() {
		
	}
	
	public void creerService(DataCenter data) {
		System.out.println("================================================================================");
		System.out.println("========================== Menu de création d'un service =======================");
		System.out.println("================================================================================");
		
		String titre; 
		Pro enseignant;  
		String dateDebut; 
		String dateFin;
		String heureDebut;
		String recurrence; 
		int capaciteMax; 
		String commentaire;
		Scanner scanInt = new Scanner(System.in);
		Scanner scanString = new Scanner(System.in);
		System.out.println("Veuillez entrer le titre de votre cours");
		titre = scanString.nextLine();
		
		System.out.println("Veuillez entrer votre numéro d'employé");
		int codetemp = scanInt.nextInt();
		System.out.println(codetemp);
	    int membPos =data.proPosition(codetemp);
	    int compteur = 0;
		
	    while(membPos == -1) {
			System.out.println("Votre numéro est invalide veuillez recommencer");
			compteur++;
			codetemp = scanInt.nextInt();
			membPos =data.proPosition(codetemp);
			
			if(compteur >= 3) {
				System.out.println("trop d'essais, retour au menu principal");
				data.vue.accueil();
			}
	    }
		
	    enseignant = data.proListe[membPos];
		
		
		System.out.println("Tapez la date de debut");
		dateDebut = scanString.nextLine();
		
		System.out.println("Tapez la date de fin");
		dateFin = scanString.nextLine();
		
		System.out.println("Tapez l'heure de début du service");
		heureDebut = scanString.nextLine();
		
		System.out.println("Tapez le jour de la semaine ou l'activité à lieu");
		recurrence = scanString.nextLine();
		
		System.out.println("Tapez la capacité maximale du service");
		capaciteMax = scanInt.nextInt();
		
		System.out.println("Tapez des commentaires liés au cours");
		commentaire = scanString.nextLine();
		
		
		/*data.addService(titre, enseignant, dateDebut, 
				dateFin, heureDebut, recurrence, capaciteMax, commentaire);
		data.vueAccueil();*/
	}
	
}
