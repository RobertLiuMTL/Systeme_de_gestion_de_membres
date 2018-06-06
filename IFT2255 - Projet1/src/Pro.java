
public class Pro extends Personne{
	//Attributs d'un professionnel

	private String discipline;
	
	public Pro (String nomFamille, String prenom, int numeroPro, String adresse, 
			String naissance, String phone, String courriel, String discipline) {
		this.nomFamille=nomFamille;
		this.prenom=prenom;
		this.numeroMembre=numeroPro;
		this.adresse=adresse;
		this.naissance=naissance;
		this.phone=phone;
		this.courriel=courriel;
		this.discipline=discipline;
	}
	

}
