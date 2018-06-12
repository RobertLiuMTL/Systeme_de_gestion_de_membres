import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Classe abstraite Personne qui offre les attributs communs aux Membres et Professionnels
 * @author Shado
 *
 */
public abstract class Personne {
	//Les attributs d'une Personne.
	protected String nomFamille;
	protected String prenom;
	protected int numeroMembre;
	protected String adresse;
	protected String naissance;
	protected String phone;
	protected String courriel;
	protected String commentaires="";
	protected String dateCreation;
	protected boolean suspendu = false;
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

	/**
	 * getPrenom retourne le nom et le prénom!
	 * @return Prenom + NomFamille
	 */
	public String getPrenom() {
		String resultat = this.prenom + " "+ this.nomFamille;
		return resultat;
	}
	
	public String getNomFamille() {
		return this.nomFamille;
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
	
	/**
	 * Ajoute un nouveau commentaire au dossier
	 * @param newComment
	 */
	public void setComment(String newComment) {
		this.commentaires+=newComment+"\n";
	}
	
	public boolean getSuspendu() {
		return this.suspendu;
	}
	
	public void setSuspendu(boolean statut) {
		this.suspendu=statut;
	}
	
	public String getDateCreation() {
		return this.dateCreation;
	}
}
