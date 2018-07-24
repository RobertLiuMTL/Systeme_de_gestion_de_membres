package projet;
/**
 * 
 * DEPRECIE
 * la procedure comptable est maintenant une methode dans datacenter 
 * 
 * 
 * @author Robert
 *
 */


public class ProcedureComptable {
	DataCenter data;
	
	public ProcedureComptable(DataCenter data) {
		this.data = data;
	}
	//La Methode vas nécessiter une implementation plus serieux, pour le moment renvoi seulement un texte
	public static void generateTEF() {
		System.out.print("Nom: John Wick\n" 
						+"Service: Comment protéger son chien \n "
						+"Numéro de Professionnel: 666666666"	
						+"Nombre d'inscrits: 2" + "\n");
		
		System.out.print("Nom: Pablo Escuela\n" 
						+"Service: Comment tuer ses ennemis \n "
						+"Numéro de Professionnel: 555555555"	
						+"Nombre d'inscrits: 3" + "\n");
	}
	
	public static void rapportSemaine() {
		System.out.print("Nom: John Wick\n" 
						+"Montant à payer: 60$ "
		);
		System.out.print("Nom: Pablo Escuela\n" 
						+"Montant à payer: 90$ "
		);
		
		System.out.println("nb total professionel: 2"
						  +"\n"+ "nb total Services: 2 +\n"
						  +"Montant total à payer: 150$");
		
		envoyerRapportGerant("BigBoss@gym.com");
	}
	
	public static void rapportJour() {
		System.out.print("Nom: John Wick\n" 
						+"Montant à payer: 60$ "
		);
		System.out.print("Nom: Pablo Escuela\n" 
						+"Montant à payer: 90$ "
		);
		
		System.out.println("nb total professionel: 2"
						  +"\n"+ "nb total Services: 2 +\n"
						  +"Montant total à payer: 150$");
		
		envoyerRapportGerant("BigBoss@gym.com");
	}
	
	public static void envoyerRapportGerant(String email) {
		System.out.println("Le rapport Hebdo a été envoyé à "+ email);
	}
	
}
