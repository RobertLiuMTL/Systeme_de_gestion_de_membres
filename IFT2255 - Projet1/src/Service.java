/**
 * Classe des Services
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
	private static int codeDuCours = 0; 
	private String dateDebut; 
	private String dateFin;
	private String heureDebut;
	private String recurrence; 
	private int capaciteMax;
	

	public Service(String titre, Pro enseignant, Membre[] listeMembre, int codeDuCours, String dateDebut, String dateFin
					, String heureDebut, String recurrence, int capaciteMax){
		this.titre = titre;
		this.enseignant = enseignant;
		this.listeMembre = listeMembre;
		this.codeDuCours = Service.getCode();
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.heureDebut = heureDebut;
		this.recurrence = recurrence;
		this.capaciteMax = listeMembre.length;
		
	}
	/**
	 * 
	 * Liste des getter/setter
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

	public static int getCodeDuCours() {
		return codeDuCours;
	}
    //il n'y a pas de methode set codeducours pour eviter les conflits

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
	 * @return
	 */
	public static int getCode() {
		codeDuCours++;
		return codeDuCours;
		
	}
}
