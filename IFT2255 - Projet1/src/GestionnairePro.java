/**
 * Le gestionnaire des professionnels. 
 * Contient les méthodes qui touchent à cette catégorie de membre.
 * @author Shado
 *
 */
public class GestionnairePro {
	//Attributs du gestionnaire des professionnels
	private DataCenter data;
	
	private FindPro find = new FindPro();

	
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
	
	/**
	 * Méthode de recherche d'un professionnel par numéro. 
	 *
	 * @return Résultat sous forme de String
	 */
	public String findPro() {
		return find.rechercheParNum(data.getPro());
	}
	
	/**
	 * Méthode pour afficher tous les professionnels inscrits au Centre
	 * La réponse est retournée sous forme de lignes de commande.
	 * En cas de modification du Système en faveur d'un UI graphique,
	 * supprimer les print et remplacer Void par String.
	 * 
	 * @param liste (liste de Pro[])
	 */
	public void afficherAll(Pro[]liste) {
		String resultatAll = "Voici la liste de tous les professionnels " 
	+ "inscrits au Centre Sportif #GYM : \n\n";

		for (int i = 0; i < liste.length; i++) {
			resultatAll += "*****************************************\n" + "Nom : " + liste[i].getNomComplet() + "\n"
					+ "Numéro de Professionnel : " + liste[i].getNumero() + "\n" + "Date de naissance : "
					+ liste[i].getNaissance() + "\n" + "Adresse : " + liste[i].getAdresse() + "\n" + "Courriel : "
					+ liste[i].getCourriel() + "\n" + "Numéro de téléphone : " + liste[i].getPhone() + "\n"
					+ "Professionnel suspendu? : " + liste[i].getSuspendu() + "\n" + "Professionnel depuis : "
					+ liste[i].getDateCreation() + "\n" + "Commentaires : " + liste[i].getComment();
		}
		System.out.println(resultatAll);
	
	}
	
}
