/**
 * Classe des Services
 * 
 * @author Robert
 *
 */
public class Service {

	/**
	 * Classe pour les services offerts par les professionnels
	 */
	private String titre;
	private int codeService;
	private Membre[] listeMembre;

	
	// Insérer ici l'attribut Séance[] listeSeance
	// avec séance contenant le nom du prof, le numéro du cours, et les informations de dates...?
	// [[Tennis : Prof A, Prof b...],[Médecine sportive : Prof c, Prof d...]...] 
	// Le centre de données contiendra une liste de Service. Dans les services, il y aura ensuite une liste des séances possibles.
	// public void addSeance(Pro enseignant, dates... heures...)
	//Partie en construction2
	Seance[] listeSeance;
	/////////////////////////////////////////////////////////////////
	
	public Service(String titre, int codeService) {;
		this.codeService=codeService;

	}

	// methode qui permet de format le service dans un String pour des fins de
	// presentation aux membres
	public String membreService() {
		return "\n\nTitre: " + this.titre + "\nCode du cours: " + this.codeService;
	}
	
	public void setTitre(String titre) {
		this.titre=titre;
	}
	public String getTitre() {
		return this.titre;
	}
	
	public Membre[] getListeMembre() {
		return listeMembre;
	}

	public void setListeMembre(Membre[] listeMembre) {
		this.listeMembre = listeMembre;
	}

	public int getService() {
		return codeService;
	}
	public void setService(int service) {
		this.codeService=service;
	}
	
	
}
