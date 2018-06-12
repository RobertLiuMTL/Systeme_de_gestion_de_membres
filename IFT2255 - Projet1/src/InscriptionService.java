/**
 * 
 * 
 * @author Marc-André
 *module qui permet à l'utilisateur de s'inscrire à un service
 */
import java.util.Scanner;

public class InscriptionService {
	
	
	
	public InscriptionService(){
		
	}
	
	public void inscrireMembre(DataCenter data){
		System.out.println("================================================================================");
		System.out.println("======================== Menu d'inscription à un service =====================");
		System.out.println("================================================================================");
		System.out.println("\nTapez le code du cours pour vous inscrire à celui-ci");
		
		Scanner scan = new Scanner(System.in);
		int code = scan.nextInt();
		Service[] services = data.getService();
		
		if(data.servicePosition(code) == -1) {
			System.out.println("Le code tapé n'existe pas");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			data.vue.menuRepertoireServices();
		}
		if(services[data.servicePosition(code)].getCapaciteMax() <= 
				services[data.servicePosition(code)].getListeMembre().length) {
			System.out.println("Le cours est plein, veuillez choisir une autre activité");
			data.vue.menuRepertoireServices();
		}
		
		System.out.println("Veuillez taper votre numéro de membre");
		
		int codeMemb = scan.nextInt();
		int compteur = 0;
		while(data.membrePosition(codeMemb) == -1) {
			System.out.println("Le code de membre entré est invalide, veuillez recommencer.");
			codeMemb = scan.nextInt();
			compteur++;
			if(compteur >= 3) {
				data.vueDataCenter();
			}
		}
		
		if(data.getMembre()[codeMemb].getSuspendu()) {
			System.out.println("Vous etes suspendu, contacter l'agent pour plus de renseignement");
			data.vueAccueil();
			
		}
		else {
			data.inscrireMembre(code, codeMemb);
			
		}
		
		
		
		
		
		
		
		
		
		
	}
}
	
