package projet;

//import java.awt.desktop.SystemEventListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Centre de Données (DataCenter).
 * 
 * C'est la classe de contrôle qui a accès à la base de données et c'est
 * également la classe à laquelle se réfère toutes les autres classes.
 * 
 * Le Centre de Données crée le pont entre la Vue et le Modèle.
 * 
 * Contient une grande partie de la logique de notre logiciel.
 * 
 * À des fins de tests, certaines données sont encodées au lancement du logiciel
 * (pour simuler la persistance des données)
 * 
 * @author Robert
 *
 */
public class DataCenter implements Identification {

	// Les attributs de la Base de Données
	Membre[] membersListe = new Membre[0];
	static Pro[] proListe = new Pro[0];
	Service[] serviceListe = new Service[0];

	// Les différentes extensions
	Vue vue = new Vue(this);
	GestionnaireMembre gm = new GestionnaireMembre(this);
	GestionnairePro gp = new GestionnairePro(this);
	GestionnaireService gs = new GestionnaireService(this);
	CreateService cs = new CreateService();
	IdentificationServiceSeance is = new IdentificationServiceSeance(this);

	// Dernier numéro de Membre attribué.
	private int lastNumber = 123456789;
	// Dernier numéro du Service attribué
	private int lastService = 1000000;

	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	/**
	 * Constructeur du DataCenter pour nos tests unitaires
	 * @param test
	 */
	public DataCenter(int test) {
		
	}
	
	/**
	 * Constructeur. Au moment d'être instancié, il crée diverses données à des fins
	 * de tests.
	 * 
	 * Permet de faire le pont avec la vue.
	 */
	public DataCenter() {

		// Création d'une liste pour nos tests.
		addMember("Liu", "Robert", "4981 Félix", "14/10/1987", "5146213688", "robert.liu@umontreal.ca", "QC",
				"Montreal", "H8Y123");
		addMember("Lebowski", "The Dude", "1337 Dude Street", "1/1/1981", "5141234567", "thebig@lebowski.ca", "QC",
				"Montreal", "H3A4A5");
		addMember("Wick", "John", "123 The Dog", "12/11/1975", "5144500668", "johnwick@hotmail.com", "QC", "Laval",
				"H3J2A4");
		addMember("Poutine", "Vlad", "123 Kremlin", "11/11/1961", "5141233333", "vladput@russia.ru", "QC", "Dorval",
				"J4K1A4");
		addPro("Badot", "Édouard", "AA-2355", "11/11/1954", "5141311337", "batotedo@iro.umontreal.ca", "Informatique",
				"QC", "Montreal", "J4J4J4");
		addPro("Kessentini", "Wael", "AA-2238", "11/11/1923", "5143333456", "kessentw@iro.umontreal.ca", "Correcteur",
				"QC", "Montréal", "H3C 3J7");
		addPro("Mokaddem", "Chihab ", "AA-2238", "1990", "4503343434", "mokaddec@iro.umontreal.ca", "Démonstrateur",
				"QC", "Montréal", "H3C 3J7");

		// Création de services de base + test de la méthode addService()

		addService("Nutritionniste");
		addService("Orthopédiste");
		addService("Physiothérapeute");
		addService("Massage");
		addService("Acupuncture");
		addService("White Walkers Hunting");
		addService("Soccer professionnel");
		addService("Escalade");
		addService("Esport");

		// Création de Séances test.
		serviceListe[0].addSeance(proListe[0].getNomComplet(), proListe[0].getNumero(), 55, 30, "22/05/2018",
				"30/09/2018", "15:30", "Lundi", "");
		serviceListe[0].addSeance(proListe[2].getNomComplet(), proListe[2].getNumero(), 55, 30, "22/04/2018",
				"30/09/2018", "15:30", "Mardi", "");
		serviceListe[6].addSeance(proListe[1].getNomComplet(), proListe[1].getNumero(), 99, 30, "14/06/2018",
				"14/10/2019", "8:30", "Samedi", "You know nothing");
		serviceListe[8].addSeance(proListe[1].getNomComplet(), proListe[1].getNumero(), 99, 30, "18/07/2018",
				"01/08/2019", "9:30", "Mercredi", "Let's own some noobs");

		// inscription aux seances
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
		System.out.println("code clien: " + membersListe[1].getNumero());
		this.vue.accueil();

	}

	/**
	 * retourne la liste des membres contenue dans la Base de données
	 * 
	 * @return Une liste de membres
	 */
	public Membre[] getMembre() {
		return this.membersListe;
	}

	/**
	 * Retourne la liste des professionnels contenue dans la Base de données
	 * 
	 * @return : Retourne la liste de Pro
	 */
	public Pro[] getPro() {
		return proListe;
	}

	/**
	 * Retourne la liste des Services contenue dans la base de données
	 * 
	 * @return : Retourne la liste de Services
	 */
	public Service[] getService() {
		return this.serviceListe;
	}

	/**
	 * Méthode qui permet d'identifier le Client. Prend en paramètre le numéro du
	 * Client ainsi que la base de données.
	 * 
	 * @param numero
	 *            : Numéro de client à 9 chiffres.
	 * @return : Retourne un message si le membre est identifié
	 */
	public String identifier(int numero) {
		return identifier(this, numero);
	}

	/**
	 * Méthode qui permet d'identifier le Client avec son numéo.
	 * 
	 * @param numero : Prend le numéro du membre à 9 chioffres
	 * @return Résultat sous forme de Boolean
	 */
	public boolean identifierBool(int numero) {
		return identifierBool(this, numero);
	}

	/**
	 * Méthode qui permet d'identifier le Membre et de retourner, s'il existe, son
	 * compte (Membre).
	 * 
	 * @param numero
	 *            : Prend en entrée le numéro de membre à 9 chiffres
	 * @return : Retourne le résultat de la méthode identifierMembre de l'interface
	 *         Identification
	 */
	public Membre identifierMembre(int numero) {
		return identifierMembre(this, numero);
	}

	/**
	 * Méthode qui permet d'identifier le Pro et de retourner, s'il existe, son
	 * compte (Pro).
	 * 
	 * @param numero
	 *            : Prend en entrée le numéro de pro à 9 chiffres
	 * @return : Retourne le résultat de la méthode identifierPro de l'Interface
	 *         Identification
	 */
	public Pro identifierPro(int numero) {
		return identifierPro(this, numero);
	}
	//////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////
	// Les méthodes en lien avec la Vue
	//////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////

	/**
	 * Méthode pour passer à la Vue Pour accéder à la page principale (Accueil)
	 */
	public void vueAccueil() {
		vue.accueil();
	}

	/**
	 * Méthode pour passer à la Vue Pour accéder au Centre de Donnéees
	 */
	public void vueDataCenter() {
		vue.dataCenter();
	}

	/**
	 * Méthode pour passer à la Vue Pour accéder au Gestionnaire des Membres
	 */
	public void vueGestionnaireMembre() {
		vue.accueilGestionnaireMembre();
	}

	/**
	 * Méthode pour passer à la Vue Pour accéder au Gestionnaire des Professionnels
	 */
	public void vueGestionnairePro() {
		vue.accueilGestionnairePro();
	}

	//////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////
	// Les méthodes en lien avec le gestionnaire des membres
	//////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////

	/**
	 * Méthode pour passer au Gestionnaire des Membres Accède à la fonction Ajouter
	 * un Membre du Gestionnaire
	 */
	public void gestionnaireAddMembre() {
		gm.addMembre();
	}

	/**
	 * Méthode pour passer au Gestionnaire des Membres Accède à la fonction
	 * Rechercher un Membre du Gestionnaire des Membres
	 */
	public void gestionnaireFindMembre() {
		gm.findMembre();
	}

	/**
	 * Méthode pour passer au Gestionnaire des Membres Accède à la fonction Afficher
	 * tous les Membres du Gestionnaire
	 */
	public void gestionnaireAfficherMembre() {
		gm.afficherAll(membersListe);
	}

	/**
	 * NON IMPLÉMENTÉE Méthode pour passer au Gestionnaire des Membres. Accède à la
	 * fonction de mofication d'un compte de Membre.
	 */
	public void gestionnaireModMembre() {
		gm.modifierMembre();
	}

	/**
	 * Appel de la méthode du gestionnaire de Membre pour suspendre un usager. Prend
	 * un argument de type int (Numéro reçu par la Vue)
	 * 
	 * @param numero
	 *            : Un int représentant le numéro à 9 chiffres
	 * @return : Le résultat de la suspension sous forme de String.
	 */
	public String gestionnaireSuspendMembre(int numero) {
		return gm.suspendMembre(getMembre(), numero);

	}

	/**
	 * Méthode pour supprimer un Membre;
	 * 
	 * @param numero
	 *            : Numéro du membre à 9 chiffres.
	 */
	public void gestionnaireSupMembre(int numero) {
		gm.suppMembre(numero);
	}

	//////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////
	// Les méthodes en lien avec le gestionnaire des professionnels
	//////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////

	/**
	 * Lance le module d'ajout de Professionnel du gestionnaire des professionnels
	 */
	public void gestionnaireAddPro() {
		gp.createPro();
	}

	/**
	 * Méthode du Gestionnaire Pro qui lance le module de recherche de
	 * Professionnel. Le String résultat sera envoyé à la vue
	 * 
	 * @return : Résultat sous forme de String.
	 */
	public String gestionnaireFindPro() {
		return gp.findPro();
	}

	/**
	 * Méthode pour afficher tous les professionnels. Fait appel à la méthode
	 * afficherAll du GestionnairePro
	 */
	public void gestionnaireAfficherPro() {
		gp.afficherAll(proListe);
	}

	//////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////
	// Les méthodes en lien avec le gestionnaire des services
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

	/**
	 * Méthode pour modifier un service.
	 */
	public void gestionnaireModService() {
		gs.modifierService();
	}
	//////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////
	// Les méthodes qui permettent de mettre à jour les bases de données
	//////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////

	/**
	 * Puisque le Centre de Données contient la liste de Membre, la méthode pour
	 * ajouter un membre aboutit ultimement ici (Main fait appel à CreateMembre, qui
	 * envoie les données du Membre au Centre de données (DataCenter)
	 * 
	 * Tous les arguments proviennent du module de Création de Membre qui aura été
	 * lancé par la Vue.
	 * @param nomFamille : String
	 * @param prenom : String
	 * @param adresse : String
	 * @param naissance : String
	 * @param phone : String
	 * @param courriel : String
	 * @param province : String
	 * @param city : String
	 * @param postalcode : String
	 */
	public void addMember(String nomFamille, String prenom, String adresse, String naissance, String phone,
			String courriel, String province, String city, String postalcode) {
		int longueur = membersListe.length;
		// Recopier la liste des membres dans la liste temporaire
		Membre[] temporaire = new Membre[longueur + 1];
		for (int i = 0; i < longueur; i++) {
			temporaire[i] = membersListe[i];
		}
		temporaire[longueur] = new Membre(nomFamille, prenom, lastNumber, adresse, naissance, phone, courriel, province,
				city, postalcode);
		membersListe = temporaire;
		System.out.println("Le nouveau Membre a été créé avec succès!\n");
		System.out.println(prenom + " " + nomFamille + " a le numéro de Membre suivant : " + lastNumber);
		lastNumber++;
		System.out.println("\nVeuillez patienter pendant que le Système "
				+ "imprime la carte de Membre et retourne au Centre de Données..." + "\n\n");

	}

	/**
	 *  Méthode pour créer un professionnel.
	 * 
	 * Prend en entrée l'information qui aura été, au préalable, recueillie par le
	 * Module de création d'un Pro (appelé par la VUE)
	 * @param nomFamille : String
	 * @param prenom : String
	 * @param adresse : String
	 * @param naissance : String
	 * @param phone : String
	 * @param courriel : String
	 * @param discipline : String
	 * @param province : String 
	 * @param city : String
	 * @param postalcode : String
	 */
	public void addPro(String nomFamille, String prenom, String adresse, String naissance, String phone,
			String courriel, String discipline, String province, String city, String postalcode) {
		int longueur = proListe.length;

		// recopier la liste des Professionnels dans la liste temporaire
		Pro[] temporaire = new Pro[longueur + 1];
		for (int i = 0; i <= longueur - 1; i++) {
			temporaire[i] = proListe[i];
		}
		temporaire[longueur] = new Pro(nomFamille, prenom, lastNumber, adresse, naissance, phone, courriel, discipline,
				province, city, postalcode);
		proListe = temporaire;
		System.out.println("Le nouveau Professionnel a été créé avec succès!\n");
		System.out.println(prenom + " " + nomFamille + " a le numéro de Professionnel suivant : " + lastNumber);
		lastNumber++;
		System.out.println("\nVeuillez patienter pendant que le Système "
				+ "imprime la carte du Professionnel et retourne au Centre de Données..." + "\n\n");

	}

	/**
	 * Méthode pour ajouter un nouveau Service à la banque de données
	 * 
	 * 
	 * @param titre
	 *            : String
	 */
	public void addService(String titre) {

		int longueur = serviceListe.length;

		// Recopier la liste des services dans la liste temporaire
		Service[] temporaire = new Service[longueur + 1];
		for (int i = 0; i <= longueur - 1; i++) {
			temporaire[i] = serviceListe[i];
		}

		// augmenter la valeur du service
		this.lastService += 10000;

		temporaire[longueur] = new Service(titre, this.lastService);
		serviceListe = temporaire;
		System.out.println("Le nouveau Service a été créé avec succès!\n");
		System.out.println("Le Service est : " + temporaire[longueur].getTitre());
		System.out.println("Le code du service est le " + temporaire[longueur].getService());

	}

	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////
	// Les méthodes qui permettent de manipuler les inscriptions/désinscription
	////////////////////////////////////////////////////////////////////////////////////////// d'une
	////////////////////////////////////////////////////////////////////////////////////////// activité
	//////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * retourne le numero qui correspond a la position du membre dans la liste des
	 * membres si le membre n'existe pas, retourne -1
	 * 
	 * @param num : Prend un int en argument
	 * @return : La position du membre
	 */

	public int membrePosition(int num) {
		int code = -1;
		for (int i = 0; i < this.membersListe.length; i++) {
			if (num == membersListe[i].getNumero()) {
				code = i;
			}
		}

		return code;
	}

	/**
	 * retourne le numero qui correspond a la position du membre dans la liste des
	 * membres si le membre n'existe pas, retourne -1
	 * 
	 * @param num : Prend en argument un numéro int
	 * @return : Position du pro sous forme de int
	 */

	public int proPosition(int num) {
		int code = -1;
		for (int i = 0; i < this.proListe.length; i++) {
			if (num == proListe[i].getNumeroMembre()) {
				code = i;
			}
		}

		return code;

	}

	/**
	 * cette methode permet de realiser la procedure comptable les methodes qui
	 * suivent celle-ci sont celle qui implementent les parties de cette procedure.
	 * 
	 */
	public void procedureComptable() {
		genererRapportMembre();
		genererRapportPro();
		genererRapportDeSynthese();
		genererRapportTEF();
		vue.menuComptable();

	}

	public int servicePosition(int number) {
		int pos = -1;
		for (int i = 0; i < this.serviceListe.length; i++) {
			if (this.serviceListe[i].getService() == number) {
				pos = i;
			}
		}
		return pos;
	}

	/**
	 * Méthode qui permet de créer le rapport de synthese en créant une nouvelle
	 * instance de RapportSynthese
	 */
	public void genererRapportDeSynthese() {
		DATA_RapportSynthese rapportSynth = new DATA_RapportSynthese(serviceListe, proListe);
	}

	/**
	 * Méthode lancée par la procedure comptable pour générer les rapports à envoyer
	 * aux Pros.
	 */
	private void genererRapportPro() {
		DATA_RapportPro rapportPro = new DATA_RapportPro(proListe, this.serviceListe);
	}

	/**
	 * methode prive utilise par la procedure comptable pour generer les rapports a
	 * envoyer aux Membres
	 */
	private void genererRapportMembre() {
		DATA_FacturesMembre facturesDesMembres = new DATA_FacturesMembre(this.getMembre(), this.getService());
	}

	/**
	 * genere le rapport TEF a partir de la procedure comptable
	 *
	 */
	private void genererRapportTEF() {
		DATA_TEF tef = new DATA_TEF(this.getService(), this.getPro());
	}

}
