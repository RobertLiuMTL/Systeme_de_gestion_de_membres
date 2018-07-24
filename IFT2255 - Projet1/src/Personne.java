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
	protected String province;
	protected String city;
	protected String postalCode;
	
	//le compte est un attribut qui permet aux membres de recevoir leurs facture et aux pros de consulter
	//leurs avis de paiement
	protected String compte = "";
	
	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	/**
	 * getPrenom retourne le nom et le prénom!
	 * @return Prenom + NomFamille
	 */
	public String getNomComplet() {
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
	 * @param newComment : String (ajout d'un nouveau commentaire)
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
	public String getPostalCode() {
		return this.postalCode;
	}
	
	public String getcity() {
		return this.city;
	}
	
	public String getprovince() {
		return this.province;
	}
	public String getCompte() {
		return this.compte;
	}
	public void setCompte(String compte) {
		this.compte = compte;
	}
	public int getNumeroMembre() {
		return this.numeroMembre;
	}
}
