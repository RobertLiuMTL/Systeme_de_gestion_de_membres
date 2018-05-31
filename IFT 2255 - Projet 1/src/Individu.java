/**
 * Classe abstraite qui permet l'héritage
 * @author Robert
 *
 */
public abstract class Individu {
	private String nomFamille;
	private String prenom;
	
	//Chaque personne a un statut non-suspendu par d�faut.
	//La modifcation de cet �tat s'effectue dans une autre classe.
	private boolean suspendu = false;
	private String commentaire;
	
	public Individu (String nomFamille, String prenom) {
		this.nomFamille=nomFamille;
		this.prenom=prenom;
	}
	
	public String getIdentity() {
		String resultat = prenom + nomFamille;
		return resultat;
	}
	
	public void modifyName (String nom, String prenom) {
		this.nomFamille = nom;
		this.prenom=prenom;
	}
	
}
