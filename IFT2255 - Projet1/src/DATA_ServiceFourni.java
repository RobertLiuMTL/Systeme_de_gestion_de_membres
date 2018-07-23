import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**TODO : Doit être produit à chaque fois qu'un membre confirme sa présence à une séance.
 */
public class DATA_ServiceFourni {
    //Date et heure actuelles
	private String dateHeure;
    //Date à laquelle du service qui sera fourni
	private String dateService;
	//    Numéro du professionnel
	private int numPro;
    //Numéro du membre
	private int numMembre;
	//Code du service
	private int codeService;
    //Commentaires (facultatif).
	private String comment;
	
	DateFormat fullDate = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	DateFormat dateOnly = new SimpleDateFormat("yyyy/MM/dd");
	
	public DATA_ServiceFourni(String dateService, int numPro, int numMembre, int codeService, String comment) {
		//heure de confirmation
		this.dateHeure = fullDate.format(new Date());
		
		this.dateService=dateService;
		this.numPro=numPro;
		this.numMembre=numMembre;
		this.codeService=codeService;
		this.comment=comment;
		
	}
}