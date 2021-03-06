/**
 * Classe des Services
 * 
 * @author Robert
 *
 */
public class Service {

	/**
	 * Classe pour les services offert par les professionnels
	 */
	private String titre;
	private Pro enseignant;
	private Membre[] listeMembre;
	private int codeDuCours;
	private String dateDebut;
	private String dateFin;
	private String heureDebut;
	private String recurrence;
	private int capaciteMax;
	private static int compteur = 1000000;
	private String commentaire;
	
	// Insérer ici l'attribut Séance[] listeSeance
	// avec séance contenant le nom du prof, le numéro du cours, et les informations de dates...?
	// [[Tennis : Prof A, Prof b...],[Médecine sportive : Prof c, Prof d...]...] 
	// Le centre de données contiendra une liste de Service. Dans les services, il y aura ensuite une liste des séances possibles.
	// public void addSeance(Pro enseignant, dates... heures...)
	//Partie en construction2
	Seance[] listeSeance;
	/////////////////////////////////////////////////////////////////
	
	public Service(String titre, Pro enseignant, String dateDebut,
			String dateFin, String heureDebut, String recurrence, int capaciteMax, String commentaire) {
		this.titre = titre;
		this.enseignant = enseignant;
		this.listeMembre = new Membre[0];
		this.codeDuCours = Service.getCode();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.heureDebut = heureDebut;
		this.recurrence = recurrence;
		this.capaciteMax = capaciteMax;
		this.commentaire = commentaire;
	}

	// methode qui permet de format le service dans un String pour des fins de
	// presentation aux membres
	public String membreService() {
		String presentation = 
				"\n\nTitre: " + this.titre + 
			 
				"\nCode du cours: " + this.codeDuCours ;
				 
			
				
				
				
			

		return presentation;
	}

	/**
	 * 
	 * Liste des getter/setter
	 * 
	 * @return
	 */
	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Pro getEnseignant() {
		return enseignant;
	}

	public void setEnseignant(Pro enseignant) {
		this.enseignant = enseignant;
	}

	public Membre[] getListeMembre() {
		return listeMembre;
	}

	public void setListeMembre(Membre[] listeMembre) {
		this.listeMembre = listeMembre;
	}

	public int getCodeDuCours() {
		return codeDuCours;
	}
	// il n'y a pas de methode set codeducours pour eviter les conflits

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public String getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(String heureDebut) {
		this.heureDebut = heureDebut;
	}

	public String getRecurrence() {
		return recurrence;
	}

	public void setRecurrence(String recurrence) {
		this.recurrence = recurrence;
	}

	public int getCapaciteMax() {
		return capaciteMax;
	}

	public void setCapaciteMax(int capaciteMax) {
		this.capaciteMax = capaciteMax;
	}

	/**
	 * methode statique pour retourner le code du prochain cours créé
	 * 
	 * @return
	 */
	private static int getCode() {
		compteur++;
		return compteur;

	}
	
}
