/**
 * Classe des Services
 * 
 * @author Robert
 *
 */
public class Service{

	/**
	 * Classe pour les services offerts par les professionnels
	 */
	private String titre;
	private int codeService;
	Seance[] seances = new Seance[0];
	private int codeSeance;

	
	// Insérer ici l'attribut Séance[] listeSeance
	// avec séance contenant le nom du prof, le numéro du cours, et les informations de dates...?
	// [[Tennis : Prof A, Prof b...],[Médecine sportive : Prof c, Prof d...]...] 
	// Le centre de données contiendra une liste de Service. Dans les services, il y aura ensuite une liste des séances possibles.
	// public void addSeance(Pro enseignant, dates... heures...)
	//Partie en construction2
	Seance[] listeSeance;
	/////////////////////////////////////////////////////////////////
	
	public Service(String titre, int codeService) {
		this.titre=titre;
		this.codeService=codeService;
		this.codeSeance=codeService;

	}

	 /**
	  * methode qui permet de format le service dans un String pour des fins de
	 presentation aux membres
	  * @return
	  */
	public String membreService() {
		return "\n\nTitre: " + this.titre + "\nCode du cours: " + this.codeService;
	}
	
	public void setTitre(String titre) {
		this.titre=titre;
	}
	public String getTitre() {
		return this.titre;
	}

	public int getService() {
		return this.codeService;
	}
	public void setService(int service) {
		this.codeService=service;
	}
	
	public Seance[] getSeance() {
		return this.seances;
	}
	
	
	/**
	 * methode qui permet d'ajouter une seance a la liste des seances dans le dataCenter
	 * @param nomProf
	 * @param numProf
	 * @param cout
	 * @param capacite
	 * @param dateDebut
	 * @param dateFin
	 * @param heureDebut
	 * @param recurrence
	 * @param comments
	 */
	public void addSeance(String nomProf, int numProf, int cout, int capacite,
			String dateDebut, String dateFin,String heureDebut, String recurrence, String comments) {
		int longueur = seances.length;
		
		//Recopier la liste des séances dans la liste temporaire
		Seance[] temporaire = new Seance[longueur+1];
		for (int i = 0;i<=longueur-1;i++) {
			temporaire[i]=seances[i];		
			}
		
		//augmenter la valeur du service
		this.codeSeance+=100;
		System.out.print("Début de la création de la séance pour le Service " +getTitre() +"...\n");
		temporaire[longueur] = new Seance(nomProf,numProf,codeSeance,cout,capacite,
				dateDebut,dateFin,heureDebut,recurrence,comments,this.titre);
		seances = temporaire;
		System.out.println("La nouvelle Séance a été créée avec succès!\n");
		//System.out.println("La Séance est : "+ temporaire[longueur].getTitre());
		//System.out.println("Le code du service est le " + temporaire[longueur].getService());
	}
	/**
	 * enleve une seance de la liste des seances dans datacenter
	 * @param pos position du service dans la liste des services
	 */
	public void removeSeance(int pos) {
		int  longueur = seances.length;
		Seance[] temporaire = new Seance[longueur - 1];
			for(int i = 0; i < pos; i++) {
				temporaire[i] = seances[i];
			}
			for(int j = pos+1; j < seances.length; j++) {
				temporaire[j-1] = seances[j];
			}
			 
		
		seances = temporaire;
	}
	/**
	 * retourne la position d'une seance dans la liste des seances
	 * @param number code de la seance
	 * @return
	 */
	public int seanceposition( int number) {
		int pos = -1;
		for (int i = 0 ; i < seances.length ; i++ ) {
			if (seances[i].getCode() == number) {
				 pos = i;
			}
		}
		return pos;
	}
}
