/**
 * 
 * 
 * @author Marc-André
 *module qui permet à l'utilisateur de s'inscrire à un service
 */
import java.util.Scanner;

public interface InscriptionSeance {
	
	/**
	 * Cette classe c'est juste une methode(extension de vue)
	 * elle verifie les codes tapé (no membre et no de Service) pour voir si c'est correct
	 * si oui alors elle utilise la methode inscrireMembre() de datacenter
	 * 
	 * BUG ne detecte pas la capacite maximale
	 */
	
	/**
	 * Méthode d'inscription du membre à une séance pour l'application mobile
	 * @param data DataCenter
	 * @param membre Membre
	 */
	public default void inscrireMembreMobile(DataCenter data, Membre membre) {
		System.out.println("================================================================================");
		System.out.println("======================== Menu d'inscription à une séance =======================");
		System.out.println("================================================================================");
		System.out.println("\nTapez le code du cours pour vous inscrire à celui-ci");
		
		Scanner scan = new Scanner(System.in);
		while(!scan.hasNextInt()) {
			System.out.println("SVP, entrez un numéro de SÉANCE valide à 7 chiffres");
			scan.next();
		}
		int code = scan.nextInt();
		Seance seance = data.is.findSeance(code);
		if (seance!= null) {
			seance.inscrireMembre(membre);
		}else {
			System.out.println("Aucune séance n'est associée au numéro de séance "+code);
		}
	}
	
	/**
	 * Méthode d'inscription du Membre pour le Logiciel (demande une authentification du Membre)
	 * @param data
	 */
	public default void inscrireMembre(DataCenter data){
		System.out.println("================================================================================");
		System.out.println("======================== Menu d'inscription à un service =====================");
		System.out.println("================================================================================");
		System.out.println("\nTapez le code du cours pour vous inscrire à celui-ci");
		
		Scanner scan = new Scanner(System.in);
		while(!scan.hasNextInt()) {
			System.out.println("SVP, entrez un numéro de SÉANCE valide à 7 chiffres");
			scan.next();
		}
		int code = scan.nextInt();
		Seance seance = data.is.findSeance(code);
		if (seance!= null) {
			System.out.println("SVP, entrez le numéro du membre à 9 chiffres pour confirmer");
			while(!scan.hasNextInt()) {
				System.out.println("SVP, entrez un numéro valide à 9 chiffres");
				scan.next();
			}
			int codeMembre = scan.nextInt();
			
			Membre membre = data.identifierMembre(codeMembre);
			if(membre != null && membre.getSuspendu()==false) {
				seance.inscrireMembre(membre);	
			}else if (membre == null) {
				System.out.println("Échec de l'inscription. Le numéro de Membre est invalide");
			}else {
				System.out.println("Échec de l'inscription. Le membre est suspendu");
				}
					
		}else {
			System.out.println("Aucune séance n'est associée au numéro de séance "+code);
		}
		
	}
}
	
