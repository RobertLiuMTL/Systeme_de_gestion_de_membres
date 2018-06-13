/**
 * 
 * 
 * @author Marc-André
 *module qui permet à l'utilisateur de s'inscrire à un service
 */
import java.util.Scanner;

public class InscriptionService {
	
	/**
	 * Cette classe c'est juste une methode(extension de vue)
	 * elle verifie les codes tapé (no membre et no de Service) pour voir si c'est correct
	 * si oui alors elle utilise la methode inscrireMembre() de datacenter
	 * 
	 * BUG ne detecte pas la capacite maximale
	 */
	
	public InscriptionService(){
		
	}
	
	public void inscrireMembre(DataCenter data){
		System.out.println("================================================================================");
		System.out.println("======================== Menu d'inscription à un service =====================");
		System.out.println("================================================================================");
		System.out.println("\nTapez le code du cours pour vous inscrire à celui-ci");
		
		Scanner scan = new Scanner(System.in);
		int code = scan.nextInt();
		Service[] services = data.serviceListe;
		
		//verifie si le service existe
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
		
		System.out.println("Veuillez entrer le numéro de membre (9 chiffres)");
		
		int codeMemb = scan.nextInt();
		int compteur = 0;
		
		//verifie si le membre existe
		while(data.membrePosition(codeMemb) == -1) {
			System.out.println("Le code de membre entré est invalide, veuillez recommencer.");
			codeMemb = scan.nextInt();
			compteur++;
			
			if(compteur >= 3) {
				System.out.println("Trop d'essais");
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				data.vue.menuRepertoireServices();
			}
		}
		// verifie si le membre est suspendu
		if(data.getMembre()[data.membrePosition(codeMemb)].getSuspendu()) {
			System.out.println("Échec de l'inscription : Le Membre est suspendu. ");
			data.vue.menuRepertoireServices();
			
		}
		else {
			data.inscrireMembre(data.servicePosition(code), data.membrePosition(codeMemb));
			System.out.println("L'inscription a été réussie pour le cour " + data.serviceListe[data.servicePosition(code)].getTitre());
			data.vue.menuRepertoireServices();
		}
		
		
		
		
		
		
		
		
		
		
	}
}
	
