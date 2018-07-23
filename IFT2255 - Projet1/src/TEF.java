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
	 * La cette classe prend pour acquis que les seances sont donnees une fois semaine max 
	 * @param Services
	 * @param Pro
	 */
	public TEF(Service[] Services, Pro[] Pro) {
		
		Calendar calendrier = new GregorianCalendar();
		int currentWeek = calendrier.get(Calendar.WEEK_OF_YEAR);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		File dir = new File("Fichier_TEF");
		dir.mkdirs();
		
		for(int i = 0; i < Pro.length; i++) {
			
			
			for(int j = 0; j < Services.length; j++) {
				
				
				for(int e = 0; e < Services[j].getSeance().length; e++) {
					
					
					


					//Premier if qui verifie si le nom du pro est bien celui qui donne la seance
					if(Pro[i].getNomComplet().equals(Services[j].getSeance()[e].getPro())) {

						
					String dateDebut = Services[j].getSeance()[e].getDebut();
					String dateFin = Services[j].getSeance()[e].getFin();
					
					//mets le calendrier a la date du debut puis a la fin de la seance pour calculer leurs semaines dans l'annees
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

					
					
					
						
					
					//Si pour la semaine en cours la seance est donnée
						if((semaineDebut < currentWeek && currentWeek < semaineFin && semaineFin > semaineDebut) 
							|| (semaineDebut > semaineFin && (currentWeek > semaineDebut || currentWeek < semaineFin ))) {
							
							try {
								File f = new File(dir,"TEF_" + Pro[i].getNomComplet()+ ".txt");
							
							//3 eme si le fichier TEF du Pro existe deja
								
								boolean check = f.exists();
								
								if(check) { 
									FileWriter fw = new FileWriter(f,true); 
									BufferedWriter bw = new BufferedWriter(fw);
									bw.write(Services[j].getSeance()[e].descriptionTEF());
									bw.flush();
									fw.close();
								}
								//si il n'existe pas il est créé
								else{
									f.createNewFile();
									FileWriter fw = new FileWriter(f); 
									BufferedWriter bw = new BufferedWriter(fw);
									bw.write(
											
											"Nom du professionnel: " +Pro[i].getNomComplet() +"\n"
										    +"Numéro du professionnel: " + Pro[i].getNumeroMembre()+"\n"
										    +"Adresse du professionnel: " + Pro[i].getAdresse()+"\n"
										    +"Code postal du professionnel: " + Pro[i].getCourriel()+"\n"
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
