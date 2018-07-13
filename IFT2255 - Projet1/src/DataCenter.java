import java.awt.desktop.SystemEventListener;
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
	Membre [] membersListe = new Membre[3];
	static Pro [] proListe = new Pro[3];
	Service [] serviceListe = new Service[1];

	
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
		membersListe[0] = new Membre("Liu", "Robert", 111111111, "4981 félix", "14 octobre", "514621", "robert.liu@umontreal.ca");
		membersListe[0].setSuspendu(true);
		
		membersListe[1] = new Membre("Alarie", "Alexandre", 222222222, "123 UDEM", "13 octobre", "1234567", "alariey@hotmail.com");
		
		membersListe[2] = new Membre("Chabot", "Marc-André", 333333333, "321 allo", "12 octobre", "999123", "marcandrechabot86@gmail.com");
		
		addMember ("nomFamille", "prenom", "adresse", "naissance", "phone", "courriel@test.ca");
		
		proListe[0] = new Pro( "Wick",  "John", 666666666, "John Wick is a dog", 
				 "n10 octobre", "5141234567",  "JohnWick@hotmail.com", "Docteur");
		
		proListe[1] = new Pro( "Escuela",  "Pablo", 555555555, "Yoyo vamos a la playa", 
				 "1999 10 10", "1800-199-2000",  "Pablo@hotmail.com", "Voleur");
		proListe[2] = new Pro( "Snow",  "John", 444444444, "123 St-John Street", 
				 "12/12/2012", "514-5280528",  "johnSnow@hotmail.com", "John knows nothing");
		//Création de services de base + test de la méthode addService()
		serviceListe[0]=new Service("Cours d'autodéfense", this.lastService);
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
		serviceListe[0].addSeance("John Wick", 666666666, 55, 22, "22/10/2018", "30/11/2018", "15:30", "Lundi", "");
		serviceListe[0].addSeance("John Wick", 666666666, 55, 22, "22/10/2018", "30/11/2018", "15:30", "Mardi", "");

		serviceListe[6].addSeance("John Snow", 444444444, 99, 30, "14/10/2018", "14/10/2019", "8:30", "Samedi", "You know nothing");
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
	public void addMember (String nomFamille, String prenom, String adresse, String naissance, String phone, String courriel) {
		int longueur = membersListe.length;
		//Recopier la liste des membres dans la liste temporaire
		Membre[] temporaire = new Membre[longueur+1];
		for (int i = 0;i<longueur;i++) {
			temporaire[i]=membersListe[i];
			}
		temporaire[longueur] = new Membre(nomFamille, prenom, lastNumber, adresse, naissance, phone, courriel);
		membersListe=temporaire;
		System.out.println("Le nouveau Membre a été créé avec succès!\n");
		System.out.println(prenom +" "+ nomFamille + " a le numéro de Membre suivant : "+lastNumber);
		lastNumber++;
		System.out.println("\nVeuillez patienter pendant que le Système "
				+ "imprime la carte de Membre et retourne au Centre de Données..."
				+ "\n\n");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public void addPro (String nomFamille, String prenom, String adresse, String naissance, String phone, String courriel, String discipline) throws InterruptedException {
		int longueur = proListe.length;
		
		//recopier la liste des Professionnels dans la liste temporaire
		Pro[] temporaire = new Pro[longueur+1];
		for (int i = 0;i<=longueur-1;i++) {
			temporaire[i]=proListe[i];		
			}
		temporaire[longueur] = new Pro(nomFamille, prenom, lastNumber, adresse, naissance, phone, courriel, discipline);
		proListe=temporaire;
		System.out.println("Le nouveau Professionnel a été créé avec succès!\n");
		System.out.println(prenom +" "+ nomFamille + " a le numéro de Professionnel suivant : "+lastNumber);
		lastNumber++;
		System.out.println("\nVeuillez patienter pendant que le Système "
				+ "imprime la carte du Professionnel et retourne au Centre de Données..."
				+ "\n\n");
		Thread.sleep(4000);
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
