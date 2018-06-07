/**
 * Classe abstraite Personne qui offre les attributs communs aux Membres et Professionnels
 * @author Shado
 *
 */
public abstract class Personne {
	protected String nomFamille;
	protected String prenom;
	protected int numeroMembre;
	protected String adresse;
	protected String naissance;
	protected String phone;
	protected String courriel;
	protected String commentaires;
	protected String statut = "Valide";
	
	public String getPrenom() {
		String resultat = this.prenom + " "+ this.nomFamille;
		return resultat;
	}
	
	public int getNumero() {
		return numeroMembre;
	}
	
	public String getAdresse() {
		return this.adresse;
	}
	
	public void setAdresse(String newAdresse) {
		this.adresse=newAdresse;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public void setPhone(String newPhone) {
		this.phone=newPhone;
	}
	
	public String getCourriel() {
		return this.courriel;
	}
	
	public void setCourriel(String newCourriel) {
		this.courriel=newCourriel;
	}
	
	public String getNaissance() {
		return this.naissance;
	}
	
	public void setNaissance(String newNaissance) {
		this.naissance=newNaissance;
	}
	
	public String getComment() {
		return this.commentaires;
	}
	
	public void setComment(String newComment) {
		this.commentaires=newComment;
	}
	
	public String getStatut() {
		return this.statut;
	}
	
	public void setStatut(String newStatut) {
		this.statut=newStatut;
	}
}
