import java.util.Scanner;

/** 					À FAIRE
 * Le répertoire de Services n'a pas encore été implémenté. 
 * 
 * 
 * La classe du répertoire des Services.
 * @author Robert
 *
 */
public class RepertoireServices {
	DataCenter data;
	
	/**
	 * Constructeur du répertoire des Services
	 * Reçoit en argument la Base de données (contrôleur)
	 * Peut retourner à la vue à partir de la Base de Données
	 * @param data
	 */
	public RepertoireServices(DataCenter data) {
		this.data = data;
	}
	
	public void menuRepertoireServices() {
		System.out.println("================================================================================");
		System.out.println("=========================== Répertoire des Services ============================");
		System.out.println("================================================================================");
		System.out.println("\n");
		System.out.println("Sélectionnez une option");
		System.out.println("[0]     Retour au Menu principal \n");
		System.out.println("[1]     Voir les services offerts \n");
		System.out.println("[2]     Créer un nouveau service \n");
		System.out.println("[3]     Désinscrire un membre \n");
		
		Scanner sc2 = new Scanner(System.in);
		int input2 = sc2.nextInt();

		while (input2 != 1 && input2 != 2 && input2 != 0 && input2 != 3) {
			System.out.println("SVP, faites un choix valide.");
			input2 = sc2.nextInt();
		}

		switch (input2) {
		case 0:
			System.out.println("Retour au Menu Principal");
		
			data.vueAccueil();
		case 1:
			System.out.println("Voici les services offerts présentement");
			
			for(int i = 0; i < data.getService().length; i++) {
				System.out.println(data.getService()[i].membreService());
			}
			System.out.println("Désirez-vous vous inscrire à un service\n (y/n)");
			
			Scanner scanner = new Scanner(System.in);
			char input3 = scanner.nextLine().charAt(0);
			
			while(input3 != 'y' && input3 != 'n') {
				System.out.println("tapez une entrée valide");
			    input3 = scanner.nextLine().charAt(0);
			    System.out.println(input3);
			    
			}
			
			if(input3 == 'y') {
				data.is.inscrireMembre(data);
			}else if(input3 == 'n') {
				System.out.println("retour au répertoire des services");
				
				menuRepertoireServices();
			}
			break;
		case 2:
			
			break;
		case 3:
			
			break;
	   }
	}
}
