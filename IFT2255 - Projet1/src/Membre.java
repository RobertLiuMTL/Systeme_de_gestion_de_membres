/**
 * Classe pour les Membres du Gym.
 * @author Robert
 *
 */
public class Membre {
	private String nomFamille;
	private String prenom;
	private int numeroMembre;
	private String adresse;
	private String naissance;
	private String phone;
	private String courriel;
	
	public Membre (String nomFamille, String prenom, int numeroMembre, String adresse, String naissance, String phone, String courriel) {
		this.nomFamille=nomFamille;
		this.prenom=prenom;
		this.numeroMembre=numeroMembre;
		this.adresse=adresse;
		this.naissance=naissance;
		this.phone=phone;
		this.courriel=courriel;
	}
	
	public String getPrenom() {
		String resultat = this.prenom + " "+ this.nomFamille;
		return resultat;
	}
}
