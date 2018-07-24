package projet;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class DATA_FacturesMembre {
	/**
	 * Ce constructeur permet a chaque vendredi durant la procedure comptable de generer la facture pour chacun
	 * des clients inscrits a une seance cette semaine la, cette facture est sauvegarde dans l'attribut compte des 
	 * membres
	 * @param membres prend la liste des membres du Gym en parametre
	 * @param services prend l'ensemble des services du GYm en parametre
	 * 
	 */
	public DATA_FacturesMembre(Membre[] membres, Service[] services) {
		
		Calendar calendrier = new GregorianCalendar();
		int currentWeek = calendrier.get(Calendar.WEEK_OF_YEAR);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		File dir = new File("Factures des membres");
		dir.mkdirs();
		
		
		
		
		for(int i = 0; i < membres.length; i++) {
			
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
					
					
					
					
					
					//si le membre est inscrit
					
						//Si pour la semaine en cours la seance est donnée
						if((semaineDebut < currentWeek && currentWeek < semaineFin && semaineFin > semaineDebut) 
							|| (semaineDebut > semaineFin && (currentWeek > semaineDebut || currentWeek < semaineFin ))) {
							
							//utilisation de membreInscrit pour verifier la seance courant [e]
							if(isMembreInscrit( membres[i], services[j].getSeance()[e] )) {
								
								
								//si le membre est inscrit verifie si la facture du membre est nulle
								
								//si elle l'est
								if(membres[i].getCompte().equals("")) { 
									String newCompt = "\n---------------------------------------\n"
											+ 		  "---------------------------------------"+"\nNom du membre: " + membres[i].getNomComplet() + 
									   "\n"+ "Numéro du membre: " + membres[i].getNumeroMembre() +
									   "\n"+"Adresse du membre: " + membres[i].getAdresse() + 
									   "\n"+ "Ville du membre: " + membres[i].getCity()+  
									   "\n"+ "Province du membre: " + membres[i].getProvince() + 
									   "\n"+ "Code postal du membre: " + membres[i].getPostalCode() +
									   "\n"+ "Service fourni: " + services[j].getTitre()+
									    //cette longue ligne degueu permet de retourner la date de la seance avec le format voulu
									   "\n"+ "Date du service: " + LocalDate.parse(formatter.format(LocalDate.now().plusDays(calcDate(services[j].getSeance()[e].getRecurrence()))),formatter)+
									   "\n"+ "Nom du professionnel: " + services[j].getSeance()[e].getPro()+
									   "\n"+ "Prix : " + services[j].getSeance()[e].getPrix()+"\n\n" ;
									membres[i].setCompte(newCompt);
								}
								//si la facture n'est pas nul
								else{
									String ajoutCompt ="\n---------------------------------------"+"\n\n"+ "Service fourni: " + services[j].getTitre()+
										    //cette longue ligne degueu permet de retourner la date de la seance avec le format voulu
											   "\n"+ "Date du service: " + LocalDate.parse(formatter.format(LocalDate.now().plusDays(calcDate(services[j].getSeance()[e].getRecurrence()))),formatter)+
											   "\n"+ "Nom du professionnel: " + services[j].getSeance()[e].getPro() +
											   "\n"+ "Prix: "+ services[j].getSeance()[e].getPrix() ;
									membres[i].setCompte(membres[i].getCompte() + ajoutCompt);
											
									
								}
							
							
							
						}
						
						
					}
				}
			}
		}
		
		
		for(int e = 0; e < membres.length; e++) {
			try {
				File f = new File(dir,"Facture_" + membres[e].getNomComplet()+ ".txt");
			
			//3 eme si le fichier TEF du Pro existe deja
				
				
				
				
				//si il n'existe pas il est créé
				
					f.createNewFile();
					FileWriter fw = new FileWriter(f); 
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(membres[e].getCompte());
					bw.flush();
					fw.close();
					
				
			}catch(IOException g){
		        g.printStackTrace();
		        System.out.println("erreur fichier");
	        }	
		
		
		}
		
		
		
		
		
	}
	
	
	
	/**
	 * cette methode boboche prend un jour de la semaine en string et return un int qui correspond 
	 * a sa position par rapport au vendredi, elle est utilisé pour parser la date a partir de la date 
	 * de la procedure comptable (vendredi) et de la recurrence de la seance (string day)
	 * @param day string qui correspond au jour de la recurrence de la seance
	 * @return La position de day par rapport au vendredi
	 */
	
	private int calcDate(String day) {
		
		if(day.equals("Dimanche")) {
			return -5;
		}
		if(day.equals("Lundi")) {
			return -4;
		}
		if(day.equals("Mardi")) {
			return -3;
		}
		if(day.equals("Mercredi")) {
			return -2;
		}
		if(day.equals("Jeudi")) {
			return -1;
		}
		if(day.equals("Vendredi")) {
			return 0;
		}
		if(day.equals("Samedi")) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	
	/**
	 * Cette methode prend le membre en question et la seance et dit si le membre est inscrit
	 * a cette seance
	 * 
	 * @param membre Le membre en question
	 * @param seance La seance en question
	 * @return boolean true si le membre est inscrit false sinon
	 */
	private boolean isMembreInscrit( Membre membre, Seance seance) {
		Membre[] listeMembInsc = seance.getListeMembre();
		
		boolean membreInsc = false;
		
		for(int i = 0; i < listeMembInsc.length; i++) {
		 
			
			 if(membre.getNomComplet().equals(listeMembInsc[i].getNomComplet())) {
				

				return true;
				
			}
			
		}
		
		return membreInsc;
	}
	
}
