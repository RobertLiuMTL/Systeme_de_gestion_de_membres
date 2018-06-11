import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Centre de Données (DataCenter). C'est la classe de contrôle qui a accès à la base de données et 
 * c'est également la classe à laquelle se réfère toutes les autres classes.
 * 
 * Le Centre de Données crée le pont entre la Vue et le Modèle.
 * 
 * @author Robert
 *
 */
public class DataCenter {
	
	//Les attributs de la Base de Données
	Membre [] membersListe = new Membre[0];
	Pro [] proListe = new Pro[0];
	Service [] serviceListe = new Service[0];
	Vue vue;
	RepertoireServices rs = new RepertoireServices(this);
	GestionnaireMembre gm = new GestionnaireMembre(this);
	GestionnairePro gp = new GestionnairePro(this);
	Identification id = new Identification();
	InscriptionService is = new InscriptionService();
	CreationService cs = new CreationService();

	//Dernier numéro de Membre attribué.
	private int lastNumber = 123456789;
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	
	/**
	 * Constructeur. Au moment d'être instancié, il crée la Vue en lui
	 * envoyant en argument this (DataCenter)
	 */
	public DataCenter() {
		this.vue = new Vue(this);
		
		
		/**Création d'une liste pour nos tests.
		membersListe[0].prenom = "Robert";
		membersListe[0].nomFamille="Liu";
		membersListe[0].numeroMembre=000000001;
		membersListe[0].setAdresse("123 Terre");
		membersListe[0].naissance="123456";
		membersListe[0].setPhone("5141234567");
		membersListe[0].courriel="alariey@hotmail.com";
		membersListe[0].commentaires="Test subject";
		membersListe[0].dateCreation="1234567";
		
		membersListe[1].prenom="Marc-André";
		membersListe[1].nomFamille="Chabot";
		membersListe[1].numeroMembre=000000002;
		membersListe[1].courriel="alariey@hotmail.com";
		membersListe[1].setPhone("5141234567");
		membersListe[1].dateCreation="1234567";
		membersListe[1].naissance="123456";
		membersListe[1].commentaires="Test subject";
		membersListe[1].setAdresse("123 Terre");
		
		membersListe[2].prenom="Alexandre";
		membersListe[2].nomFamille="Alarie";
		membersListe[2].numeroMembre=000000003;
		membersListe[2].courriel="alariey@hotmail.com";
		membersListe[2].setPhone("5141234567");
		membersListe[2].dateCreation="1234567";
		membersListe[2].naissance="123456";
		membersListe[2].commentaires="Test subject";
		membersListe[2].setAdresse("123 Terre");
		*/
		
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
		return this.proListe;
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
		return id.identifier(this, numero);
	}
	
	/**
	 * Méthode qui permet d'identifier le Client avec son numéo.
	 * 
	 * @param numero
	 * @return Résultat sous forme de Boolean
	 */
	public boolean identifierBool(int numero) {
		return id.identifierBool(this, numero);
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
		gm.gestionnaireAddMembre();
	}
	
	/**Méthode pour passer au Gestionnaire des Membres
	 * Accède à la fonction Rechercher un Membre du Gestionnaire des Membres
	 */
	public void gestionnaireFindMembre() {
		gm.gestionnaireFindMembre();
	}
	
	/**Méthode pour passer au Gestionnaire des Membres
	 * Accède à la fonction Afficher tous les Membres du Gestionnaire
	 */
	public void gestionnaireAfficherMembre() {
		gm.gestionnaireAfficherAll(membersListe);
	}
	
	/**NON IMPLÉMENTÉE
	 * Méthode pour passer au Gestionnaire des Membres.
	 * Accède à la fonction de mofication d'un compte de Membre.
	 */
	public void gestionnaireModMembre() {
		gm.gestionnaireModMembre();
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
	
	public void gestionnaireAfficherPro() {
		gp.afficherAll(proListe);
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
	public void addMember (String nomFamille, String prenom, String adresse, String naissance, String phone, String courriel) throws InterruptedException {
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
		Thread.sleep(4000);
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
		for (int i = 0;i<longueur-1;i++) {
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
	
	public void addService(String titre, Pro enseignant, String dateDebut, String dateFin
			, String heureDebut, String recurrence, int capaciteMax, String commentaire) {
		
		int longueur = serviceListe.length;
		
		//Recopier la liste des services dans la liste temporaire
		Service[] temporaire = new Service[longueur+1];
		for (int i = 0;i<longueur-1;i++) {
			temporaire[i]=serviceListe[i];		
			}
		temporaire[longueur] = new Service(titre, enseignant, dateDebut,heureDebut, recurrence, recurrence, capaciteMax, commentaire);
		serviceListe = temporaire;
		System.out.println("Le nouveau Service a été créé avec succès!\n");
		System.out.println("Le Service est : "+ titre);
		System.out.println("Il sera donné du : " + dateDebut + " jusqu'au "+dateFin );
		System.out.println("Le " + recurrence);
		System.out.println("à " + heureDebut);
		System.out.println("Il y a "+ capaciteMax + " places");
		System.out.println("Le code du service est le " + temporaire[longueur].getCodeDuCours());

		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	//Les méthodes qui permettent de manipuler les inscriptions/désinscription d'une activité
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * 
	 * @param codeDuCours
	 * @return retourne -1 si le service n'existe pas, sinon retourne la position i dans la serviceListe 
	 * de data, du service correspondant au code
	 */
	public int servicePosition(int codeDuCours) {
		int code = -1;
		for(int i = 0; i <this.serviceListe.length; i++) {
			if(codeDuCours == serviceListe[i].getCodeDuCours()) {
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
	
	public int membrePosition(int num) {
		int code = -1;
		for(int i = 0; i < this.membersListe.length; i++ ) {
			if(num == membersListe[i].getNumeroMembre()) {
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
	 * permet d'ajouter un membre dans la liste des inscrit d'un service
	 * @param positionServ la position du service dans le tableau de service
	 * @param positionMemb la position du membre dans la liste des membres dans le data center
	 */
	public void inscrireMembre(int positionServ, int positionMemb) {
		
		Service service = this.serviceListe[positionServ];
		Membre [] listemembre = service.getListeMembre();
		Membre [] temporaire = new Membre[listemembre.length+1];
		
		for(int i = 0; i < listemembre.length; i++) {
			temporaire[i] = listemembre[i];
		}
		temporaire[listemembre.length+1] = this.getMembre()[positionMemb];
	}
	
	
	
}
