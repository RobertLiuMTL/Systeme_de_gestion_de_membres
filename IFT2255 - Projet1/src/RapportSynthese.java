import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class RapportSynthese {
	
	/**
	 * Ce constructeur cree le rapport de synthese ainsi que le folder de celui-ci
	 * @param services liste des services de data center
	 * @param pros	liste des pros du datacenter
	 */
	public RapportSynthese(Service[] services, Pro[] pros){
		Calendar calendrier = new GregorianCalendar();
		int currentWeek = calendrier.get(Calendar.WEEK_OF_YEAR);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		
		Seance[] tabSeance = new Seance[0];
		
		
		int compteurProfit = 0;
		String rapportdelaSynthese = "";
		File dir = new File("Rapport_de_synthese");
		dir.mkdirs();
		File f = new File(dir,"Rapport_de_synthese" + ".txt");
		
		
		
		
			
			for(int j = 0; j < services.length; j++) {
				
			
				for(int e = 0; e < services[j].getSeance().length; e++) {
					
				
					//les deux strings vont contenir la date du debut et de la fin de la seance pour voir si il est
					//donne cette semaine la (la semaine en cours est dans currentWeek)
					String dateDebut = services[j].getSeance()[e].getDebut();
					String dateFin = services[j].getSeance()[e].getFin();
					
					
					// les deux bloc try permettent de trouver la date du debut et de fin du services pour
					//pour voir si la date courante est comprise entre eux
					
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
						
						//Ce bout de code cree un tableau des seances de la semaine 
							
							
							Seance[] temporaire = new Seance[tabSeance.length+1];
							for(int u = 0; u < tabSeance.length; u++) {
								temporaire[u] = tabSeance[u];
							}
							temporaire[tabSeance.length] = services[j].getSeance()[e];
							tabSeance = temporaire;
								
								
								
								
								
								
						
						}
						
						
				}
			}
		
		
		rapportdelaSynthese = rapportdeSyntheseIndi(tabSeance, pros);
		
		try {
			FileWriter fw = new FileWriter(f); 
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write("Total des services données cette semaine: " + tabSeance.length +"\n"
					+"Total des frais cette semaine la: " + totalProfit(tabSeance) +"\n"
					+"Nombre total de professionel qui ont donné un cour cette semaine: " + nbTotalPro(tabSeance)+"\n\n---------------------------\n\n"
					+ rapportdelaSynthese + "\n\n");
			bw.flush();
			fw.close();
		}catch(IOException g){
	        g.printStackTrace();
	        System.out.println("erreur fichier");
        }
		
	}
	
	
	/**
	 * Methode qui prend la liste des seances de la semaine et retourne le total des profits (nb de membre * prix de
	 * chaque seance, pour chaque seance hebdomadaire)
	 * @param seancesHebdo Liste des seances de la semaine
	 * @return int qui correspond aux profits totaux des seances de la semaine
	 */
	
	private int totalProfit(Seance[] seancesHebdo) {
		int profits = 0;
		
		for(int i = 0; i < seancesHebdo.length; i++) {
			int money = seancesHebdo[i].getPrix() * seancesHebdo[i].getListeMembre().length;
			profits += money;
		}
		return profits;
	}
	/**
	 * Cette methodes permet de creer le strings qui correspond au rapport hebdo pour chaque pro individuellement 
	 * @param seancesHebdo
	 * @param pros
	 * @return
	 */
	private String rapportdeSyntheseIndi(Seance[] seancesHebdo, Pro[] pros) {
		
		String leRapportDeLaSynthese = "";
		
		for(int i = 0; i < pros.length; i++) {
			
			int compteurDeSeance = 0;
			String rapportPartiel = pros[i].getNomComplet() + "\n";
			int profits = 0;
			
			for(int j = 0; j < seancesHebdo.length; j++) {
				
				if(pros[i].getNomComplet().equals(seancesHebdo[j].getPro())){
					
					compteurDeSeance++;
					profits =+ (seancesHebdo[j].getListeMembre().length *seancesHebdo[j].getPrix());
					
				}
			}
			
			
			
			rapportPartiel += "Nombre total de services pour cette semaine: "+compteurDeSeance +"\n"
					+"Total des frais: " + profits + "\n\n---------------------------\n";
			
			if(compteurDeSeance == 0) {rapportPartiel = "";}
			
			leRapportDeLaSynthese += rapportPartiel;
		
		
		
		}
		
		return leRapportDeLaSynthese;
	}
	
	
	
	
	/**
	 * prends un tableau des seances hebdo et retourne un int qui correspond aux nombres de professionels unique qui
	 * ont données une seance durant la semaine courante
	 * @param seancesHebdo liste des seances de la semaine
	 * @return nb d'occurence unique d'un pro qui donne une seance
	 */
	
	
	private int nbTotalPro(Seance[] seancesHebdo) {
		String[] nomPro = new String[seancesHebdo.length];
		int occurenceUnique = 0;
		for(int j = 0; j < seancesHebdo.length; j++) {
			nomPro[j] = seancesHebdo[j].getPro();
			
		}
	
		for(int u = 0; u < nomPro.length;u++) {
			if(nomPro[u] == "") {
				
			}
			else{
				occurenceUnique++;
				String yolo = nomPro[u];
				for(int g = 0; g < nomPro.length; g++) {
					if(yolo.equals(nomPro[g])) {
						nomPro[g] = "";
					}
				}
				
			}
		}
		
	
					
			
				
			
		
		
		return occurenceUnique;
	}
}