package projet;
import java.util.regex.Pattern;

/**
 * Interface qui offre une méthode pour valider le format d'une adresse courriel. 
 * Ne contient qu'une seule méthode qui fait appel à une REGEX.
 * 
 * Cette interface est utilisée notamment lors de la création des Membres et professionnels (pour s'assurer d'une bonne adresse).
 * Est également utilisée pour valider les courriels utilisés au moment de l'identification (AppMobile)
 * @author Robert
 *
 */
public interface RegexEmail {

	// Source pour une REGEX de vérification simple de courriel
	// https://www.geeksforgeeks.org/check-email-address-valid-not-java/
	/**
	 * Méthode qui valide qu'une adresse courriel est bien écrite.
	 * @param email : Prend en paramètre une adresse courriel en format String
	 * @return : Retourne la réponse sous forme de booléenne
	 */
	public default boolean emailIsValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}
}
