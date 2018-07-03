import java.util.Date;

/**
 * Classe pour les Membres du Gym.
 * @author Robert
 *
 */
public class Membre extends Personne{
	
	public Membre (String nomFamille, String prenom, int numeroMembre, String adresse, String naissance, String phone, String courriel) {
		this.nomFamille=nomFamille;
		this.prenom=prenom;
		this.numeroMembre=numeroMembre;
		this.adresse=adresse;
		this.naissance=naissance;
		this.phone=phone;
		this.courriel=courriel;
		this.dateCreation = dateFormat.format(new Date());
	}
	
	public int getNumeroMembre() {
		return this.numeroMembre;
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
		if (facture>=50) {
			this.suspendu= true;
		}
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
			System.out.println("Le compte est toujours en souffrance. Un montant de : " + facture + " est dû.");
		}
	}
	
}
