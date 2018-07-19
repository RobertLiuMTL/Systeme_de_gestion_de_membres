import java.util.Date;

/**
 * Classe pour les Membres du Gym.
 * @author Robert
 *
 */
public class Membre extends Personne{
	
	/**
	 * Constructeur du Membre qui acquitte ses frais d'inscription
	 * @param nomFamille
	 * @param prenom
	 * @param numeroMembre
	 * @param adresse
	 * @param naissance
	 * @param phone
	 * @param courriel
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
	}
	
	/**
	 * Constructeur pour un membre qui n'acquitte pas de ses frais de membre
	 * @param nomFamille
	 * @param prenom
	 * @param adresse
	 * @param naissance
	 * @param phone
	 * @param courriel
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
	
	/**
	 * Créer les attributs nécessaires pour les paiements, et montant dûs
	 * 
	 */
	private int facture = 0;
	
	/**
	 * Méthode pour ajouter un montant à la facture globale du client
	 * @param montant
	 */
	public void ajouterSolde(int montant) {
		this.facture+= montant;
	}
	
	/**
	 * Méthode pour vérifier l'état du solde. En ce moment, si le montant dû est >= 50$
	 * le membre est suspendu
	 */
	public int verifierSolde () {
		return facture;
	}
	
	/**
	 * Méthode qui prend en argument un montant payé par le client.
	 * Ce montant est soustrait de la facture globale du client.
	 * Si la solde dûe est inférieure à 50$, la suspension du membre est levée.
	 * @param montant
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
