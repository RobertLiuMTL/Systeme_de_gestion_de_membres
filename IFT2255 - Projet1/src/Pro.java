import java.util.Date;

/**
 * Classe du professionnel avec son constructeur.
 * Hérite de la classe abstraite Personne.
 * @author Shado
 *
 */
public class Pro extends Personne{
	//Attributs d'un professionnel

	private String discipline;
	/**
	 * C'est le constructeur d'un professionnel.
	 * Ce constructeur est utilisé dans le DataCenter une fois que l'information requise a été recueillie.
	 * L'information pour la création d'un nouveau Pro est recueillie par le GestionnairePro (en faisant appel à CreatePro).
	 * 
	 * @param nomFamille : String
	 * @param prenom : String
	 * @param numeroPro : int
	 * @param adresse  : String
	 * @param naissance  : String
	 * @param phone : String
	 * @param courriel : String
	 * @param discipline : String
	 * @param province : String
	 * @param city : String
	 * @param postalcode : String
	 */
	public Pro (String nomFamille, String prenom, int numeroPro, String adresse, 
			String naissance, String phone, String courriel, String discipline, String province ,String city , String postalcode) {
		this.nomFamille=nomFamille;
		this.prenom=prenom;
		this.numeroMembre=numeroPro;
		this.adresse=adresse;
		this.naissance=naissance;
		this.phone=phone;
		this.courriel=courriel;
		this.discipline=discipline;
		this.dateCreation = dateFormat.format(new Date());
		this.province = province;
		this.postalCode = postalcode;
		this.city = city;
	}
	public int getNumeroMembre() {
		return this.numeroMembre;
	}
	
	public String getDiscipline() {
		return this.discipline;
	}
	
	//Est-ce que la liste de cours est sauvegardé dans chaque professionnel?
	
}
