/**
 * Classe qui offre une méthode pour authentifier un membre ou professionnel par son Courriel
 * @author Robert
 *
 */
public class IdentificationCourriel {
	
	/**
	 * Méthode pour vérifier si le courriel de Membre est valide ou non.
	 * @param liste : Liste de Membre[]
	 * @param courriel : courriel entré
	 * @return : La réponse retournée est un Membre ou Null.
	 */
	public Membre membreCourriel(Membre[]liste, String courriel){
		for (int i =0;i<liste.length;i++) {
			if(liste[i].getCourriel().equals(courriel)) {
				return liste[i];
			}
		}
		return null;
	}
	
	/**
	 * Méthode qui permet  de vérifier si le courriel du Pro existe ou non.
	 * @param liste : Prend en paramètre la liste des Professionnels du GYM
	 * @param courriel : Prend en entrée le courriel entré.
	 * @return : Retourne le Pro ou null.
	 */
	public Pro proCourriel(Pro[]liste, String courriel){
		for (int i =0;i<liste.length;i++) {
			if(liste[i].getCourriel().equals(courriel)) {
				return liste[i];
			}
		}
		return null;
	}
}
