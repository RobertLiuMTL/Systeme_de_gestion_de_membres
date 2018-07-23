/**
 * Classe qui offre les méthodes pour trouver un service ou une séance
 * 
 * Cette classe est disponible dans le DataCenter
 * 
 * @author Robert
 *
 */
public class IdentificationServiceSeance {
	DataCenter data;

	public IdentificationServiceSeance(DataCenter data) {
		this.data = data;
	}

	/**
	 * Méthode qui trouve un Service à l'aide d'un numéro à 7 chiffres
	 * 
	 * @param numeroService : Int, numéro de service
	 * @return : Service si existant.
	 */
	public Service findService(int numeroService) {
		Service[] liste = data.getService();
		for (int i = 0; i <= liste.length - 1; i++) {
			if (liste[i].getService() == numeroService) {
				return liste[i];
			}
		}
		return null;
	}
	
	/**
	 * Méthode qui permet de trouver une Séance à l'aide de son numéro de séance à 7 chiffres.
	 * 
	 * Si la séance est trouvée, on retourne la Séance.
	 * @param numero : int, numéro à 7 chiffres
	 * @return : Seance si elle est trouvée.
	 */
	public Seance findSeance(int numero) {
		Service[] liste = data.getService();
		for (int i = 0; i <= liste.length - 1; i++) {
			if (numero - liste[i].getService() > 0 && numero - liste[i].getService() < 10000) {
				Seance[] listeS = liste[i].getSeance();
				for (int j = 0; j <= listeS.length; j++) {
					if (numero == listeS[j].getCode()) {
						return listeS[j];
					}
				}

			}
		}
		return null;
	}

}
