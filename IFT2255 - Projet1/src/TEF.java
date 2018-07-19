import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class TEF {
	
	
	/**
	 * Le constructeur de cette classe genere les fichiers TEF de chaque Pro (ce n'est pas une classe entite mais
	 * une procedure)
	 * La methode trouve pour chaque Pro, les services qu'ils ont données cette semaine 
	 * @param Services
	 * @param Pro
	 */
	public TEF(Service[] Services, Pro[] Pro) {
		System.out.println("yolo");
		Calendar calendrier = new GregorianCalendar();
		int currentWeek = calendrier.get(Calendar.WEEK_OF_YEAR);
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		File container = new File("tp1");
		
		
		for(int i = 0; i < Pro.length; i++) {
			System.out.println("boucle 1");
			for(int j = 0; j < Services.length; j++) {
				System.out.println("boucle 2");
				for(int e = 0; e < Services[j].getSeance().length; e++) {
					System.out.println("boucle 3");
					//Premier if qui verifie si le nom du pro est bien celui qui donne la seance
					if(Pro[i].getNomComplet() == Services[j].getSeance()[e].getPro()) {
						
						
					String dateDebut = Services[j].getSeance()[e].getDebut();
					String dateFin = Services[j].getSeance()[e].getFin();
					
					//mets le calendrier a la date du debut puis a la fin pour calculer leurs semaines dans l'annees
					// par exemple la 34e semaine de l'annee 
					
					
					try {
						calendrier.setTime(sdf.parse(dateDebut));
					} catch (ParseException e1) {
						System.out.println("erreur calendrier");
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int semaineDebut = calendrier.get(Calendar.WEEK_OF_YEAR);
					
					
					
					
					
					try {
						calendrier.setTime(sdf.parse(dateFin));
					} catch (ParseException e1) {
						System.out.println("erreur calendrier");
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					int semaineFin = calendrier.get(Calendar.WEEK_OF_YEAR);
					
					
					
					
						
					
					//2eme if qui verifie si la seance est donnée cette semaine la
						if((semaineDebut < currentWeek && currentWeek < semaineFin && semaineFin > semaineDebut) 
							|| (semaineDebut > semaineFin && (currentWeek > semaineDebut || currentWeek < semaineFin ))) {
							try {
								System.out.println("fichier");
								File f = new File(container,"TEF_" + Pro[i].getNomComplet()+ ".txt");
							
							//3 eme si le fichier TEF du Pro existe deja
								if(f.exists() && !f.isDirectory()) { 
									FileWriter fw = new FileWriter(f); 
									BufferedWriter bw = new BufferedWriter(fw);
									bw.write(Services[j].getSeance()[e].descriptionTEF());
									bw.flush();
									fw.close();
								}
								//si il n'existe pas
								else{
									f.createNewFile();
									FileWriter fw = new FileWriter(f); 
									BufferedWriter bw = new BufferedWriter(fw);
									bw.write(
											
											"Nom du professionnel: " +Pro[i].getNomComplet()
										    +"Numéro du professionnel" + Pro[i].getNumeroMembre()
										    +"Adresse du professionnel" + Pro[i].getAdresse()
										    +"Code postal du professionnel" + Pro[i].getCourriel()
										    +Services[j].getSeance()[e].descriptionTEF());
									bw.flush();
									fw.close();
									
								}
							}catch(IOException g){
						        g.printStackTrace();
						        System.out.println("erreur fichier");
					        }
							
							
						}
					}
					
					
					
				}
				
				
			}
		}
		
		
	}
	

	
}
