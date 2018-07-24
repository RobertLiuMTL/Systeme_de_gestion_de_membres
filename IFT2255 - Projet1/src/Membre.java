import java.util.Date;

/**
 * Classe pour les Membres du Gym.
 * Hérite de la classe Abstraite Personne.
 * @author Robert
 *
 */
public class Membre extends Personne{
	
	/**
	 * * Constructeur du Membre 
	 * L'information requise pour la création d'un nouveau Membre est obtenue en faisant appel à la classe CreateMembre (appelée depuis le GestionnaireMembre - Vue).
	 * C'est le DataCenter qui crée la nouvelle instance d'un Membre.
	 * 
	 * @param nomFamille : String
	 * @param prenom: String
	 * @param numeroMembre : int
	 * @param adresse: String
	 * @param naissance: String
	 * @param phone: String
	 * @param courriel: String
	 * @param province: String
	 * @param city: String
	 * @param postalcode: String
	 */
	public Membre (String nomFamille, String prenom, int numeroMembre, String adresse, String naissance, String phone, String courriel , String province ,String city , String postalcode) {
		this.nomFamille=nomFamille;
		this.prenom=prenom;
		this.numeroMembre=numeroMembre;
		this.adresse=adresse;
		this.naissance=naissance;
		this.phone=phone;
		this.courriel=courriel;
		this.dateCreation = dateFormat.format(new Date());
		this.province = province;
		this.postalCode = postalcode;
		this.city = city;
		this.compte = "";
	}
	
	/**
	 * Constructeur pour le membre.
	 * 
	 * @param nomFamille : String
	 * @param prenom : String
	 * @param adresse : String
	 * @param naissance : String
	 * @param phone : String
	 * @param courriel : String
	 * @param province : String
	 * @param city : String
	 * @param postalcode : String
	 */
	public Membre (String nomFamille, String prenom, String adresse, String naissance, String phone, String courriel, String province ,String city , String postalcode) {
		this.nomFamille=nomFamille;
		this.prenom=prenom;
		this.adresse=adresse;
		this.naissance=naissance;
		this.phone=phone;
		this.courriel=courriel;
		this.dateCreation = dateFormat.format(new Date());
		this.province = province;
		this.postalCode = postalcode;
		this.city = city;
	}
	
	private int facture = 0;
	

	/**Méthode pour ajouter un montant à la facture globale du client
	 * 
	 * @param montant : Montant en int
	 */
	public void ajouterSolde(int montant) {
		this.facture+= montant;
	}
	
	/**
	 * Méthode pour vérifier l'état du solde. En ce moment, si le montant dû est plus grand ou égal 50$
	 * le membre est suspendu
	 * @return : Retourne la facture (sous forme de int)
	 */
	public int verifierSolde () {
		return facture;
	}
	
	/**
	 * Méthode qui prend en argument un montant payé par le client.
	 * Ce montant est soustrait de la facture globale du client.
	 * Si la solde dûe est inférieure à 50$, la suspension du membre est levée.
	 * @param montant : Montant sous forme de int
	 */
	public void payerSolde (int montant) {
		facture-=montant;
		if(facture< 50) {
			this.suspendu=false;
		}else {
			System.out.println("Le compte est en souffrance. Un montant de : " + facture + " est dû.");
		}
	}
	
	
}
