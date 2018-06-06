/**
 * Le gestionnaire des professionnels. 
 * Contient les méthodes qui touchent à cette catégorie de membre.
 * @author Shado
 *
 */
public class GestionnairePro {
	DataCenter data;
	public GestionnairePro(DataCenter data) {
		this.data = data;
	}
	/**
	 * Méthode pour créer un nouveau Professionnel
	 * Ne prend aucun argument et fait appel à la méthode de création 
	 * contenu dans la classe CreatePro (séparée pour faciliter la maintenance)
	 */
	public void createPro() {
		CreatePro cp = new CreatePro(data);
	}
	
	/** -------------------À IMPLÉMENTER--------------------------
	 * 
	 * Méthode qui ne prend aucun argument et qui retourne la liste
	 * de tous les professionnels
	 * @return
	 */
	public String afficherTout() {
		String resultat="";
		return resultat;
	}
}
