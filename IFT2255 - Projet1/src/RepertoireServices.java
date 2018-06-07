/** 					À FAIRE
 * Le répertoire de Services n'a pas encore été implémenté. 
 * 
 * 
 * La classe du répertoire des Services.
 * @author Robert
 *
 */
public class RepertoireServices {
	DataCenter data;
	
	/**
	 * Constructeur du répertoire des Services
	 * Reçoit en argument la Base de données (contrôleur)
	 * Peut retourner à la vue à partir de la Base de Données
	 * @param data
	 */
	public RepertoireServices(DataCenter data) {
		this.data = data;
	}
}
