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
	//Dernier numéro de Membre attribué.
	private int lastNumber = 123456789;
	
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	
	/**
	 * Constructeur. Au moment d'être instancié, il crée la Vue en lui
	 * envoyant en argument this (DataCenter)
	 */
	public DataCenter() {
		this.vue = new Vue(this);
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
	
	public void gestionnaireModMembre() {
		
	}
	
	public void gestionnaireSuspendMembre() {
		
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
		System.out.println(prenom +" "+ nomFamille + " a le numéro du Professionnel suivant : "+lastNumber);
		lastNumber++;
		System.out.println("\nVeuillez patienter pendant que le Système "
				+ "imprime la carte du Professionnel et retourne au Centre de Données..."
				+ "\n\n");
		Thread.sleep(4000);
	}	
	
	public void addService(String titre, Pro enseignant, Membre[] listeMembre, int codeDuCours, String dateDebut, String dateFin
			, String heureDebut, String recurrence, int capaciteMax) {
		
		int longueur = serviceListe.length;
		
		//Recopier la liste des services dans la liste temporaire
		Service[] temporaire = new Service[longueur+1];
		for (int i = 0;i<longueur-1;i++) {
			temporaire[i]=serviceListe[i];		
			}
		temporaire[longueur] = new Service(titre, enseignant, listeMembre, codeDuCours, dateDebut,heureDebut, recurrence, recurrence, capaciteMax);
		serviceListe = temporaire;
		System.out.println("Le nouveau Service a été créé avec succès!\n");
		System.out.println("Le Service est : "+ titre);
		System.out.println("Il sera donné du : " + dateDebut + " jusqu'au "+dateFin );
		System.out.println(" ");
		System.out.println("Le Service est :");
		System.out.println("Le Service est :");
		System.out.println("Le Service est :");
		
		lastNumber++;
		System.out.println("\nVeuillez patienter pendant que le Système "
				+ "imprime la carte du Professionnel et retourne au Centre de Données..."
				+ "\n\n");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}
