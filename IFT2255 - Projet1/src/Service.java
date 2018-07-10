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
	
	public String test() {
		return "allo";
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
	
	public void addSeance(Pro pro) {
		int longueur = seances.length;
		
		//Recopier la liste des séances dans la liste temporaire
		Seance[] temporaire = new Seance[longueur+1];
		for (int i = 0;i<=longueur-1;i++) {
			temporaire[i]=seances[i];		
			}
		
		//augmenter la valeur du service
		this.codeSeance+=100;
		
		temporaire[longueur] = new Seance(pro, this.codeSeance);
		seances = temporaire;
		System.out.println("La nouvelle Séance a été créée avec succès!\n");
		//System.out.println("La Séance est : "+ temporaire[longueur].getTitre());
		//System.out.println("Le code du service est le " + temporaire[longueur].getService());
	}
}
