import java.util.Scanner;

/**
 * C'est le gestionnaire des Services (incomplet en date de la remise du TP2). 
 * 
 * TODO : Migrer les opérations sur les services et séances dans ce gestionnaire.
 * @author Robert
 *
 */
public class GestionnaireService {
	private DataCenter data;

	public GestionnaireService(DataCenter data) {
		this.data = data;
	}
	
	
	public void modifierService() {
		System.out.println("================================================================================");
		System.out.println("=========================== Gestionnaire des Services ==========================");
		System.out.println("=========================== Module de Modification==============================");
		System.out.println("================================================================================");
		System.out.println("\n");
		System.out.println("Veuillez entrer le numéro à 7 chiffres du Service");
		Scanner sc2 = new Scanner(System.in);

		// S'assurer que l'entrée est un int.
		while (!sc2.hasNextInt()) {
			System.out.println("SVP, entrez un numéro valide à 7 chiffres");
			sc2.next();
		}
		int input2 = sc2.nextInt();
		Service temp = null;
		for(int i = 0 ; i< data.getService().length;i++) {
			if(data.getService()[i].getCodeDuCours()==input2) {
				temp = data.getService()[i];
			}
		}
		
		if (temp !=null) {
			moduleMod(temp);
		}else {
			System.out.println("Le numéro de cours que vous avez entré n'est pas valide.");
			System.out.println("Retour au menu précédent.");
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void moduleMod(Service service) {
		System.out.println("================================================================================");
		System.out.println("=========================== Modification du cours " + service.getTitre() + "====");
		System.out.println("=========================== Module de Modification==============================");
		System.out.println("================================================================================");
		System.out.println("Sélectionnez une option");
		System.out.println("[0]     Pour quitter le module de modification \n");
		System.out.println("[1]     Modifier la date de début \n");
		System.out.println("[2]     Modifier la date de fin\n");
		System.out.println("[3]     Modifier l'heure de début \n");
		System.out.println("[4]     Modifier la récurrence du cours \n");
		System.out.println("[5]     Modifier la capacité maximale du cours \n");
		boolean continuerModification= true;
		
		Scanner sc2 = new Scanner(System.in);
		int input2;
		while (continuerModification) {
			System.out.println("Veuillez sélectionner une option. Pour quitter, appuyez sur 0");
			// S'assurer que l'entrée est un int.
			while (!sc2.hasNextInt()) {
				System.out.println("SVP, entrez un numéro");
				sc2.next();
			}
			input2 = sc2.nextInt();
			while (input2 != 1 && input2 != 2 && input2 != 0 && input2 != 3 
					&& input2 != 4 && input2 != 5) {
				System.out.println("SVP, faites un choix valide.");
				input2 = sc2.nextInt();
			}

			switch (input2) {
			case 0:
				System.out.println("Retour au Répertoire des Services...");
				continuerModification = false;
				break;
			case 1:
				System.out.println("Veuillez entrer la nouvelle date de début");
				sc2 = new Scanner(System.in);
				String dateDebut= sc2.nextLine();
				System.out.println("La nouvelle date est : " + dateDebut);
				service.setDateDebut(dateDebut);
				break;
			case 2:
				System.out.println("Veuillez entrer la nouvelle date de fin");
				sc2 = new Scanner(System.in);
				String dateFin = sc2.nextLine();
				System.out.println("La nouvelle date de fin est : " + dateFin);
				service.setDateFin(dateFin);
				break;
			case 3:
				System.out.println("Veuillez entrer la nouvelle heure de début");
				sc2 = new Scanner(System.in);
				String heureDebut = sc2.nextLine();
				System.out.println("La nouvelle heure de début est : " + heureDebut);
				service.setHeureDebut(heureDebut);
				break;
			case 4:
				System.out.println("Veuillez entrer la nouvelle récurrence");
				sc2 = new Scanner(System.in);
				String recurrence = sc2.nextLine();
				System.out.println("La nouvelle récurrence est : " + recurrence);
				service.setRecurrence(recurrence);
				break;
			case 5:
				System.out.println("Veuillez entrer la nouvelle récurrence");
				sc2 = new Scanner(System.in);
				int capaciteMax= sc2.nextInt();
				while (capaciteMax > 30) {
					System.out.println("La capacité maximale est de 30 membres. Veuillez"
							+ "entrer une nouvelle capacité");
					capaciteMax = sc2.nextInt();
				}
				System.out.println("La nouvelle capacité est : " + capaciteMax);
				service.setCapaciteMax(capaciteMax);
				break;
			}
		}

	}
	
}
