import java.util.Scanner;

/**
 * C'est le gestionnaire des Services (incomplet en date de la remise du TP2). 
 * 
 * TODO : Migrer les opérations sur les services et séances dans ce gestionnaire.
 * Hérite d'une interface de création de Séance
 * @author Robert
 *
 */
public class GestionnaireService implements CreateSeance, InscriptionSeance{
	private DataCenter data;

	public GestionnaireService(DataCenter data) {
		this.data = data;
	}
	
	public void afficherServices() {
		Service[]liste=data.getService();
		String resultatAll = "Voici la liste de tous les Services : \n\n";

		for (int i = 0; i < liste.length; i++) {
			resultatAll += "\n*******************************************************"
					+ "\n*******************************************************\n" 
					+ "Titre du service           : " + liste[i].getTitre() + "\n"
					+ "Code de service            : " + liste[i].getService() + "\n";
			
			if(liste[i].getSeance().length==0) {
				resultatAll+= "Aucune séance n'est disponible pour ce Service.\n";
			}else {
				resultatAll+="\n-------------------------------------------------"+
							"\nVoici les séances disponibles pour ce service :";
				for(int j = 0; j <liste[i].getSeance().length;j++) {
					resultatAll+="\n-------------------------------------------------"+
							"\nNom du professeur           : "+liste[i].getSeance()[j].getPro()+
							"\nNuméro de Séance            : "+liste[i].getSeance()[j].getCode()+"\n"
							+"Prix de la séance           : "+liste[i].getSeance()[j].getPrix()+"$\n"
							+"Jour de la semaine          : " +liste[i].getSeance()[j].getRecurrence()+
							"\nHeure de début de la séance : "+liste[i].getSeance()[j].getHeure()
							+"\nDate de début               : "+liste[i].getSeance()[j].getDebut()+"\n"
							+"Date de fin                 : "+liste[i].getSeance()[j].getFin()+"\n";
				}
			}
		}
		System.out.println(resultatAll);
	}
	
	
	/**
	 * Méthode pour afficher la liste des Membres inscrits
	 * à une séance.
	 * @param codeSeance
	 */
	public void afficherInscription(int codeSeance) {
		Seance seance = data.is.findSeance(codeSeance);
		if(seance!= null) {
			System.out.print(seance.afficherInscription());
		}else {
			System.out.println("La séance est introuvable");
		}
	}
	
	
	/**
	 * Méthode pour créer un service à partir du gestionnaire de Service.
	 */
	public void creerService() {
		System.out.println("================================================================================");
		System.out.println("========================== Menu de création d'un service =======================");
		System.out.println("================================================================================");
		
		String titre; 
	
		Scanner scanInt = new Scanner(System.in);
		Scanner scanString = new Scanner(System.in);
		System.out.println("Veuillez entrer le titre du service");
		titre = scanString.nextLine();
				
		
		data.addService(titre);
	}
	
	
	public void creerSeance() {
		System.out.println("================================================================================");
		System.out.println("========================== Menu de création d'une séance =======================");
		System.out.println("================================================================================");

		Scanner sc = new Scanner(System.in);
		
		//Authentification du Professionnel
		System.out.println("Veuillez entrer le numéro d'employé à 9 chiffres");
		while(!sc.hasNextInt()) {
			System.out.println("Veuillez entrer un numéro valide à 9 chiffres");
			sc.next();
		}
		int numero = sc.nextInt();
		
		Pro pro = data.identifierPro(this.data, numero);
		if(pro != null) {
			
			afficherServices();
			System.out.println("Le numéro entré est valide. Veuillez entrer le numéro du Service à "
					+ "7 chiffres pour lequel le Professionnel aimerait donner une séance. ");
			sc = new Scanner(System.in);
			while(!sc.hasNextInt()) {
				System.out.println("Veuillez entrer un numéro de service valide à 7 chiffres");
				sc.next();
			}
			numero = sc.nextInt();
			Service temp = null;
			for(int i = 0 ; i<data.getService().length;i++) {
				if (data.getService()[i].getService()==numero) {
					temp = data.getService()[i];
					break;
				}
			}
			
			//Si le Pro a été trouvé et que le Service existe, on crée la séance
			if(temp != null) {
				createSeance(temp,pro);
			}else {
				System.out.println("Le numéro de service n'existe pas");
			}
		}else {
			System.out.println("Erreur : Le Système n'a pas été en mesure d'identifier "
					+ "un professionnel associé au numéro suivant : " + numero);
		}	
		
	}
	
	
	
	
	public void modifierService() {
		System.out.println("================================================================================");
		System.out.println("=========================== Gestionnaire des Services ==========================");
		System.out.println("=========================== Module de Modification==============================");
		System.out.println("================================================================================");
		System.out.println("\n");
		System.out.println("Veuillez entrer le numéro à 7 chiffres de la Seance");
		Scanner sc2 = new Scanner(System.in);

		// S'assurer que l'entrée est un int.
		while (!sc2.hasNextInt()) {
			System.out.println("SVP, entrez un numéro valide à 7 chiffres");
			sc2.next();
		}
		int input2 = sc2.nextInt();
		Seance temp = null;
		for(int i = 0 ; i < data.getService().length; i++) {
			for(int j = 0 ; j < data.getService()[i].getSeance().length ; j++ )
			if(data.getService()[i].getSeance()[j].getCode() == input2) {
				temp = data.getService()[i].getSeance()[j];
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
	
	public void moduleMod(Seance seance) {
		System.out.println("================================================================================");
		System.out.println("=========================== Modification de la séance " + seance.getCode() + "==");
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
				System.out.println("Veuillez entrer l'année (AAAA)");
				sc2 = new Scanner(System.in);
				int annee  = sc2.nextInt();
				System.out.println("Veuillez entrer le mois (MM)");
				int mois = sc2.nextInt();
				System.out.println("Veuillez entrer la journée (JJ)");
				int jour = sc2.nextInt();
				System.out.println("La nouvelle date de fin est : " + annee + "-" + mois + "-" + jour);
				seance.setDebut(annee, mois , jour);
				continuerModification = false;
				break;
			case 2:
				System.out.println("Veuillez entrer la nouvelle date de fin");
				System.out.println("Veuillez entrer l'année (AAAA)");
				sc2 = new Scanner(System.in);
				int annee2  = sc2.nextInt();
				System.out.println("Veuillez entrer le mois (MM)");
				int mois2 = sc2.nextInt();
				System.out.println("Veuillez entrer la journée (JJ)");
				int jour2 = sc2.nextInt();
				System.out.println("La nouvelle date de fin est : " + annee2 + "-" + mois2 + "-" + jour2);
				seance.setFin(annee2, mois2 , jour2);
				continuerModification = false;
				break;
			case 3:
				System.out.println("Veuillez entrer la nouvelle heure de début (HH)");
				sc2 = new Scanner(System.in);
				int heureDebut = sc2.nextInt();
				System.out.println("Veuillez entrer la nouvelle minute de début (MM)");
				sc2 = new Scanner(System.in);
				int minuteDebut = sc2.nextInt();
				System.out.println("La nouvelle heure de début est : " + heureDebut + ":" + minuteDebut);
				seance.setHeure(heureDebut, minuteDebut);
				continuerModification = false;
				break;
			case 4:
				System.out.println("Veuillez entrer la nouvelle récurrence");
				sc2 = new Scanner(System.in);
				System.out.println("Veuillez entrer l'année (AAAA)");
				int annee3  = sc2.nextInt();
				System.out.println("Veuillez entrer le mois (MM)");
				int mois3 = sc2.nextInt();
				System.out.println("Veuillez entrer la journée (JJ)");
				int jour3 = sc2.nextInt();
				System.out.println("La nouvelle récurrence est : " + jour3 + "-" + mois3 + "-"  + annee3);
				seance.setRecurrence(jour3,mois3,annee3);
				continuerModification = false;
				break;
			case 5:
				System.out.println("Veuillez entrer la nouvelle capacié maximale");
				sc2 = new Scanner(System.in);
				int capaciteMax= sc2.nextInt();
				while (capaciteMax > 30) {
					System.out.println("La capacité maximale est de 30 membres. Veuillez"
							+ "entrer une nouvelle capacité");
					capaciteMax = sc2.nextInt();
				}
				System.out.println("La nouvelle capacité est : " + capaciteMax);
				seance.setCapaciteMax(capaciteMax);
				continuerModification = false;
				break;
			}
		}

	}
	
	
}
