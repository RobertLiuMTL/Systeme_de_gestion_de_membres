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
	Membre [] membersListe = new Membre[0];
	Pro [] proListe = new Pro[0];
	
	Vue vue;
	
	
	GestionnaireMembre gm = new GestionnaireMembre(this);
	GestionnairePro gp = new GestionnairePro(this);
	//Dernier numéro de Membre attribué.
	private int lastNumber = 123456789;
	
	/**
	 * Constructeur. Au moment d'être instancié, il crée la Vue en lui
	 * envoyant en argument this (DataCenter)
	 */
	public DataCenter() {
		this.vue = new Vue(this);
	}

	/**
	 * retourne la liste des membres
	 * @return
	 */
	public Membre[] getMembre() {
		return this.membersListe;
	}
//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////
//Les méthodes en lien avec la Vue
//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Pour accéder à la page principale (Accueil)
	 */
	public void vueAccueil() {
		vue.accueil();
	}
	
	/**
	 * Pour accéder au Centre de Donnéees
	 */
	public void vueDataCenter() {
		vue.dataCenter();
	}
	
	public void vueGestionnaireMembre() {
		vue.accueilGestionnaireMembre();
	}
	
	public void vueGestionnairePro() {
		vue.accueilGestionnairePro();
	}

	
//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////
//Les méthodes qui permettent de mettre à jour les bases de données
//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Accède à la fonction Ajouter un Membre du Gestionnaire
	 */
	public void gestionnaireAddMembre() {
		gm.gestionnaireAddMembre();
	}
	
	/**
	 * Accède à la fonction Rechercher un Membre du Gestionnaire des Membres
	 */
	public void gestionnaireFindMembre() {
		gm.gestionnaireFindMembre();
	}
	
	/**
	 * Accède à la fonction Afficher tous les Membres du Gestionnaire
	 */
	public void gestionnaireAfficherMembre() {
		
	}
	
//////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////
//Les méthodes en lien avec le gestionnaire des membres
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
		Membre[] temporaire = new Membre[longueur+1];
		for (int i = 0;i<longueur-1;i++) {
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
		Thread.sleep(6000);
	}
	
	public void addPro (String nomFamille, String prenom, String adresse, String naissance, String phone, String courriel, String discipline) throws InterruptedException {
		int longueur = proListe.length;
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
		Thread.sleep(6000);
	}

	
	
}
