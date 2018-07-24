/**Classe qui représente l'enregistrement sur le Disque pour l'inscription à un service
 * 
 * Date et heure actuelles (JJ-MM-AAAA HH:MM:SS)
    Jour de la recurrence (JJ-MM-AAAA)
    Numéro du professionnel (9 chiffres)
    Numéro du membre (9 chiffres)
    Code de la séance (7 chiffres)
    Commentaires (100 caractères) (facultatif)
 * @author Robert
 *
 */
public class DATA_InscriptionService {
	private String dateHeure;
	private String recurrence;
	private int numPro;
	private int numMembre;
	private int numSeance;
	private String comment;
	
	/**
	 * Constructeur de la Donnée InscriptionService
	 * @param dateHeure : String
	 * @param reccurrence  : String
	 * @param numPro : numéro à 9 chiffres 
	 * @param numMembre : numéro à 9 chiffres
	 * @param numSeance : numéro à 7 chiffres
	 * @param comment : string
	 */
	public DATA_InscriptionService(String dateHeure, String reccurrence, int numPro,
			int numMembre, int numSeance, String comment) {
		this.dateHeure=dateHeure;
		this.recurrence=reccurrence;
		this.numPro=numPro;
		this.numMembre=numMembre;
		this.numSeance=numSeance;
		this.comment=comment;
		
	}
	
	
	public String getDate() {
		return this.dateHeure;
	}
	
	public String getReccurence() {
		return this.recurrence;
	}
	
	public int getPro() {
		return this.numPro;
	}
	
	public int getMembre() {
		return this.numMembre;
	}
	
	public int getSeance() {
		return this.numSeance;
	}
}
