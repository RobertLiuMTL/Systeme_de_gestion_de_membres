//import java.awt.desktop.SystemEventListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;




/**
 * Centre de Données (DataCenter). C'est la classe de contrôle qui a accès à la base de données et 
 * c'est également la classe à laquelle se réfère toutes les autres classes.
 * 
 * Le Centre de Données crée le pont entre la Vue et le Modèle.
 * 
 * @author Robert
 *
 */
public class DataCenter implements Identification {
	
	//Les attributs de la Base de Données
	Membre [] membersListe = new Membre[0];
	static Pro [] proListe = new Pro[0];
	Service [] serviceListe = new Service[0];

	
	//Les différentes extensions
	Vue vue = new Vue(this);
	GestionnaireMembre gm = new GestionnaireMembre(this);
	GestionnairePro gp = new GestionnairePro(this);
	GestionnaireService gs = new GestionnaireService(this);
	CreateService cs = new CreateService();
	IdentificationServiceSeance is = new IdentificationServiceSeance(this);
	
	//Dernier numéro de Membre attribué.
	private int lastNumber = 123456789;
	//Dernier numéro du Service attribué
	private int lastService = 1000000;
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	
	/**
	 * Constructeur. Au moment d'être instancié, il crée la Vue en lui
	 * envoyant en argument this (DataCenter)
	 */
	public DataCenter() {
		
		//Création d'une liste pour nos tests.
		addMember ("Liu", "Robert", "4981 Félix", "14/10/1987", "5146213688", "robert.liu@umontreal.ca", "QC", "Montreal", "H8Y123");
		addMember ("Lebowski", "The Dude", "1337 Dude Street", "1/1/1981", "5141234567", "thebig@lebowski.ca", "QC", "Montreal" , "H3A4A5");
		addMember ("Wick", "John", "123 The Dog", "12/11/1975", "5144500668", "johnwick@hotmail.com", "QC", "Laval" , "H3J2A4");
		addMember ("Poutine", "Vlad", "123 Kremlin", "11/11/1961", "5141233333", "vladput@russia.ru", "QC", "Dorval" , "J4K1A4");
		addPro("Badot", "Édouard", "AA-2355", "11/11/1954", "5141311337", "batotedo@iro.umontreal.ca", "Informatique", "QC","Montreal", "J4J4J4");
		addPro("Kessentini", "Wael", "AA-2238", "11/11/1923", "5143333456", "kessentw@iro.umontreal.ca", "Correcteur", "QC","Montréal", "H3C 3J7");
		addPro("Mokaddem", "Chihab ", "AA-2238", "1990", "4503343434", "mokaddec@iro.umontreal.ca", "Démonstrateur", "QC","Montréal", "H3C 3J7");

		//Création de services de base + test de la méthode addService()
		
		addService("Nutritionniste");
		addService("Orthopédiste");
		addService("Physiothérapeute");
		addService("Massage");
		addService("Acupuncture");
		addService("White Walkers Hunting");
		addService("Soccer professionnel");
		addService("Escalade");
		addService("Esport");
		
		//Création de Séances test.
		serviceListe[0].addSeance(proListe[0].getNomComplet(), proListe[0].getNumero(), 55, 30, "22/05/2018", "30/09/2018", "15:30", "Lundi", "");
		serviceListe[0].addSeance(proListe[2].getNomComplet(), proListe[2].getNumero(), 55, 30, "22/04/2018", "30/09/2018", "15:30", "Mardi", "");
		serviceListe[6].addSeance(proListe[1].getNomComplet(),proListe[1].getNumero(), 99, 30, "14/06/2018", "14/10/2019", "8:30", "Samedi", "You know nothing");
		serviceListe[8].addSeance(proListe[1].getNomComplet(),proListe[1].getNumero(), 99, 30, "01/08/2018", "01/08/2019", "9:30", "Mercredi", "Let's own some noobs");

		//inscription aux seances
		serviceListe[0].getSeance()[0].inscrireMembre(membersListe[0]);
		serviceListe[6].getSeance()[0].inscrireMembre(membersListe[0]);
		serviceListe[6].getSeance()[0].inscrireMembre(membersListe[1]);
		serviceListe[6].getSeance()[0].inscrireMembre(membersListe[2]);
		serviceListe[6].getSeance()[0].inscrireMembre(membersListe[3]);
		
		serviceListe[8].getSeance()[0].inscrireMembre(membersListe[0]);
		serviceListe[8].getSeance()[0].inscrireMembre(membersListe[1]);
		serviceListe[8].getSeance()[0].inscrireMembre(membersListe[2]);
		serviceListe[8].getSeance()[0].inscrireMembre(membersListe[3]);



		
		System.out.println("code seance:" + serviceListe[0].getSeance()[0].getCode());
		System.out.println("code clien: "+membersListe[1].getNumero() );
		this.vue.accueil();
		
	}

	/**
	 * retourne la liste des membres contenue dans la Base de données
	 * @return Une liste de membres
	 */
	public Membre[] getMembre() {
		return this.membersListe;
	}
	
	/**
	 * Retourne la liste des professionnels contenue dans la Base de données
	 * @return
	 */
	public Pro[] getPro() {
		return proListe;
	}
	
	/**
	 * Retourne la liste des Services contenue dans la base de données
	 * @return
	 */
	public Service[] getService() {
		return this.serviceListe;
	}
	

	
	
	
	/**
	 * Méthode qui permet d'identifier le Client.
	 * Prend en paramètre le numéro du Client ainsi que la base de données.
	 * @param numero : Numéro de client à 9 chiffres.
	 * @return
	 */
	public String identifier(int numero) {
		return identifier(this, numero);
	}
	
	/**
	 * Méthode qui permet d'identifier le Client avec son numéo.
	 * 
	 * @param numero
	 * @return Résultat sous forme de Boolean
	 */
	public boolean identifierBool(int numero) {
		return identifierBool(this, numero);
	}
	
	public Membre identifierMembre(int numero) {
		return identifierMembre(this, numero);
	}
	
	public Pro identifierPro (int numero) {
		return identifierPro(this,numero);
	}
//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////
//Les méthodes en lien avec la Vue
//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////
	
	/**Méthode pour passer à la Vue
	 * Pour accéder à la page principale (Accueil)
	 */
	public void vueAccueil() {
		vue.accueil();
	}
	
	/**Méthode pour passer à la Vue
	 * Pour accéder au Centre de Donnéees
	 */
	public void vueDataCenter() {
		vue.dataCenter();
	}
	
	/**Méthode pour passer à la Vue
	 * Pour accéder au Gestionnaire des Membres
	 */
	public void vueGestionnaireMembre() {
		vue.accueilGestionnaireMembre();
	}
	
	/**Méthode pour passer à la Vue
	 * Pour accéder au Gestionnaire des Professionnels
	 */
	public void vueGestionnairePro() {
		vue.accueilGestionnairePro();
	}
	/**méthode pour passer à la vue du Répertoire des service
	 * 
	 * 
	 */
	
//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////
//Les méthodes en lien avec le gestionnaire des membres
//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////
	
	/**Méthode pour passer au Gestionnaire des Membres
	 * Accède à la fonction Ajouter un Membre du Gestionnaire
	 */
	public void gestionnaireAddMembre() {
		gm.addMembre();
	}
	
	/**Méthode pour passer au Gestionnaire des Membres
	 * Accède à la fonction Rechercher un Membre du Gestionnaire des Membres
	 */
	public void gestionnaireFindMembre() {
		gm.findMembre();
	}
	
	/**Méthode pour passer au Gestionnaire des Membres
	 * Accède à la fonction Afficher tous les Membres du Gestionnaire
	 */
	public void gestionnaireAfficherMembre() {
		gm.afficherAll(membersListe);
	}
	
	/**NON IMPLÉMENTÉE
	 * Méthode pour passer au Gestionnaire des Membres.
	 * Accède à la fonction de mofication d'un compte de Membre.
	 */ 
	public void gestionnaireModMembre() {
		gm.modifierMembre();
	}
	
	/**
	 * Appel de la méthode du gestionnaire de Membre pour suspendre
	 * un usager. Prend un argument de type int (Numéro reçu par la Vue)
	 * @param numero : Un int représentant le numéro à 9 chiffres
	 * @return : Le résultat de la suspension sous forme de String.
	 * 
	 * Dans une mise-à-jour future, on pourrait ajouter la durée de la 
	 * suspension et la raison.
	 */
	public String gestionnaireSuspendMembre(int numero) {
		return gm.suspendMembre(getMembre(), numero);

	}
	
	/**
	 * Méthode pour supprimer un Membre;
	 * @param numero
	 */
	public void gestionnaireSupMembre(int numero) {
		gm.suppMembre(numero);
	}

	
	
		
//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////
//Les méthodes en lien avec le gestionnaire des professionnels
//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Lance le module d'ajout de Professionnel 
	 * du gestionnaire des professionnels
	 */
	public void gestionnaireAddPro() {
		gp.createPro();
	}
	
	/**
	 * Méthode du Gestionnaire Pro qui lance le module
	 * de recherche de Professionnel.
	 * Le String résultat sera envoyé à la vue
	 * @return : Résultat sous forme de String. 
	 */
	public String gestionnaireFindPro() {
		return gp.findPro();
	}
	
	/**
	 * Méthode pour afficher tous les professionnels.
	 */
	public void gestionnaireAfficherPro() {
		gp.afficherAll(proListe);
	}

	
	
//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////
//Les méthodes en lien avec le gestionnaire des services
//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Méthode pour afficher l'ensemble des services disponibles et leurs séances
	 */
	public void gestionnaireServiceAff() {
		gs.afficherServices();
	}
	
	/**
	 * Méthode pour ajouter un nouveau service
	 */
	public void gestionnaireAddServ() {
		gs.creerService();
	}
	
	/**
	 * Méthode pour créer une nouvelle séance
	 */
	public void gestionnaireAddSeance() {
		gs.creerSeance();
	}
	
	public void gestionnaireModService() {
		gs.modifierService();
	}
//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////
//Les méthodes qui permettent de mettre à jour les bases de données
//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Puisque le Centre de Données contient la liste de Membre,
	 * la méthode pour ajouter un membre aboutit ultimement ici
	 * (Main fait appel à CreateMembre, qui envoie les données du Membre
	 * au Centre de données (DataCenter)
	 * 
	 * Tous les arguments sont en format String (amélioration possible : introduire
	 * les integer pour le numéro de téléphone, et la naissance)
	 * 
	 * @param nomFamille
	 * @param prenom
	 * @param adresse
	 * @param naissance
	 * @param phone
	 * @param courriel
	 * @throws InterruptedException
	 */
	public void addMember (String nomFamille, String prenom, String adresse, String naissance, String phone, String courriel, String province, String city, String postalcode) {
		int longueur = membersListe.length;
		//Recopier la liste des membres dans la liste temporaire
		Membre[] temporaire = new Membre[longueur+1];
		for (int i = 0;i<longueur;i++) {
			temporaire[i]=membersListe[i];
			}
		temporaire[longueur] = new Membre(nomFamille, prenom, lastNumber, adresse, naissance, phone, courriel, province, city, postalcode);
		membersListe=temporaire;
		System.out.println("Le nouveau Membre a été créé avec succès!\n");
		System.out.println(prenom +" "+ nomFamille + " a le numéro de Membre suivant : "+lastNumber);
		lastNumber++;
		System.out.println("\nVeuillez patienter pendant que le Système "
				+ "imprime la carte de Membre et retourne au Centre de Données..."
				+ "\n\n");
		
	}
	
	
	
	/**
	 * Méthode pour créer un professionnel.
	 * @param nomFamille String
	 * @param prenom String
	 * @param adresse String
	 * @param naissance String
	 * @param phone String
	 * @param courriel String
	 * @param discipline String
	 * @throws InterruptedException
	 */
	public void addPro (String nomFamille, String prenom, String adresse, String naissance, String phone, String courriel, String discipline, String province,String city, String postalcode )  {
		int longueur = proListe.length;
		
		//recopier la liste des Professionnels dans la liste temporaire
		Pro[] temporaire = new Pro[longueur+1];
		for (int i = 0;i<=longueur-1;i++) {
			temporaire[i]=proListe[i];		
			}
		temporaire[longueur] = new Pro(nomFamille, prenom, lastNumber, adresse, naissance, phone, courriel, discipline, province , city , postalcode);
		proListe=temporaire;
		System.out.println("Le nouveau Professionnel a été créé avec succès!\n");
		System.out.println(prenom +" "+ nomFamille + " a le numéro de Professionnel suivant : "+lastNumber);
		lastNumber++;
		System.out.println("\nVeuillez patienter pendant que le Système "
				+ "imprime la carte du Professionnel et retourne au Centre de Données..."
				+ "\n\n");
		
	}	
	
	
	/**
	 * Méthode pour ajouter un nouveau Service à la banque de données
	 * @param titre
	 */
	public void addService(String titre) {
		
		int longueur = serviceListe.length;
		
		//Recopier la liste des services dans la liste temporaire
		Service[] temporaire = new Service[longueur+1];
		for (int i = 0;i<=longueur-1;i++) {
			temporaire[i]=serviceListe[i];		
			}
		
		//augmenter la valeur du service
		this.lastService+=10000;
		
		temporaire[longueur] = new Service(titre, this.lastService);
		serviceListe = temporaire;
		System.out.println("Le nouveau Service a été créé avec succès!\n");
		System.out.println("Le Service est : "+ temporaire[longueur].getTitre());
		System.out.println("Le code du service est le " + temporaire[longueur].getService());

	
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//Les méthodes qui permettent de manipuler les inscriptions/désinscription d'une activité
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	
	
	/**
	 * retourne le numero qui correspond a la position du membre dans la liste des membres
	 * si le membre n'existe pas, retourne -1
	 * @param num
	 * @return
	 */
	
	public int membrePosition(int num) {
		int code = -1;
		for(int i = 0; i < this.membersListe.length; i++ ) {
			if(num == membersListe[i].getNumero()) {
				code = i;
			}
		}
		
		return code;
	}
	/**
	 * retourne le numero qui correspond a la position du membre dans la liste des membres
	 * si le membre n'existe pas, retourne -1
	 * @param num
	 * @return
	 */
	
	public int proPosition(int num) {
		int code = -1;
		for(int i = 0; i < this.proListe.length; i++ ) {
			if(num == proListe[i].getNumeroMembre()) {
				code = i;
			}
		}
		
		return code;
	}
	/**
	 * cette methode permet de realiser la procedure comptable les methodes qui suivent celle-ci sont celle qui implementent les 
	 * parties de cette procedure.
	 * 
	 */
	public void procedureComptable() {
		genererRapportMembre();
		genererRapportPro();
		genererRapportDeSynthese();
		genererRapportTEF();
		
		vue.accueil();
		
	}
	
	public int servicePosition(  int number  ) {
		int pos = -1;
		for (int i = 0 ; i < this.serviceListe.length ; i++ ) {
			if (this.serviceListe[i].getService() == number) {
				 pos = i;
			}
		}
		return pos;
	}
	
	/**
	 * genere le rapport de synthese
	 */
	public void genererRapportDeSynthese() {
		RapportSynthese rapportSynth = new RapportSynthese(serviceListe, proListe);
	}
	
	/**
	 * methode prive utilise par la procedure comptable pour generer les rapports a envoyer aux pros
	 */
	private void genererRapportPro(){
		RapportPro rapportPro = new RapportPro(proListe, this.serviceListe);
	}
	/**
	 * methode prive utilise par la procedure comptable pour generer les rapports a envoyer aux Membres
	 */
	private void genererRapportMembre() {
		FacturesMembre facturesDesMembres = new FacturesMembre(this.getMembre(),this.getService());
	}
	/**
	 * genere le rapport TEF a partir de la procedure comptable
	 *
	 */
	private void genererRapportTEF() {
		TEF tef = new TEF(this.getService(), this.getPro());
	}
	
	/**
	 * permet d'ajouter un membre dans la liste des inscrit d'un service, retourne  -1 si le membre n'existe pas
	 * @param positionServ la position du service dans le tableau de service
	 * @param positionMemb la position du membre dans la liste des membres dans le data center
	 */
	/*
	public void inscrireMembre(int positionServ, int positionMemb) {
		
		Service service = this.serviceListe[positionServ];
		
		//fake choix de seance au cas ou on aurait pas le temps de l'implanter
		System.out.println("Choisissez une séance");
		System.out.println("[1] 9 juillet 2018 à 20h00");
		System.out.println("[2] 16 juillet 2018 à 20h00");
		System.out.println("[3] 23 juillet 2018 à 20h00");
		Scanner yolo = new Scanner(System.in);
		int choix = yolo.nextInt();	
		System.out.println("Vous vous êtes bien inscrit à la séance "+ choix );
		
		Membre [] listemembre = service.getListeMembre();
		Membre [] temporaire = new Membre[listemembre.length+1];
		
		for(int i = 0; i < listemembre.length; i++) {
			temporaire[i] = listemembre[i];
		}
		temporaire[listemembre.length] = this.getMembre()[positionMemb];
		
		this.serviceListe[positionServ].setListeMembre(temporaire);
		
	}
	*/
	
	/*
	public void desinscrireMembre(int codeDuMemb, int codeDuCours) {
		int estPresent = -1;
		int membPosition = membrePosition(codeDuMemb);
		int servPosition = servicePosition(codeDuCours);
		Membre[] listMembDuService = serviceListe[servPosition].getListeMembre();
		
		for(int i = 0; i <listMembDuService.length; i++) {
			if(listMembDuService[i] == membersListe[membPosition] ) {
				estPresent = i;
				
			}
			
		}
		if(estPresent == -1) {
			System.out.println("Vous n'êtes pas inscrit à ce cours");
			vue.menuRepertoireServices();
			
			}
		else {
			
			Membre[] temporaire = new Membre[listMembDuService.length-1];			
			for(int j = 0; j < estPresent; j++) {
				temporaire[j] = listMembDuService[j];
				
			}
			for(int k = estPresent + 1; k < listMembDuService.length; k++ ) {
				temporaire[k-1] = listMembDuService[k];
			}
			serviceListe[servPosition].setListeMembre(temporaire);
		}
		
		
	}
	*/
	
	/**
	 * enleve le service dans la liste de service de data
	 * @param codePosService int qui correspond a la position du service a retirer dans la liste de service
	 */
	/*
	public void removeService(int codePosService) {
		
		
		Service[] temporaire = new Service[serviceListe.length-1];
		
		for(int i = 0; i < codePosService; i++) {
			temporaire[i] = serviceListe[i];
		}
		for(int j = codePosService + 1; j < serviceListe.length;j++ ) {
			temporaire[j-1] = serviceListe[j];
		}
		this.serviceListe = temporaire;
	}
	
	public void consulterInscription(int codeDuService) {
		System.out.println("information sur le cours " + codeDuService);
		System.out.println("Liste des inscrits: \n");
		
		Membre[] listeMemb = serviceListe[servicePosition(codeDuService)].getListeMembre();
		
		for(int i = 0; i < listeMemb.length; i++) {
			System.out.println(listeMemb[i].getNomComplet());
			}
	
		System.out.println(serviceListe[servicePosition(codeDuService)].membreService());
	}
	
	*/
	
	
	
}
