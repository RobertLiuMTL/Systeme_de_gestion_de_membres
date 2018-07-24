package projet;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;

public class DATA_RapportPro {

	/**
	 * Constructeur qui cree les fichiers hebdomadaires que les membres recoivent
	 * lors de la procedure comptable (cette classe est invoque quand la procedure
	 * comptable est enclenche
	 * 
	 * @param pros
	 *            liste des pros du gym
	 * @param services
	 *            liste des services du gym
	 */
	public DATA_RapportPro(Pro[] pros, Service[] services) {
		Calendar calendrier = new GregorianCalendar();
		int currentWeek = calendrier.get(Calendar.WEEK_OF_YEAR);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");

		File dir = new File("Rapport_des_professionels");
		dir.mkdirs();

		for (int i = 0; i < pros.length; i++) {

			for (int j = 0; j < services.length; j++) {

				for (int e = 0; e < services[j].getSeance().length; e++) {

					// les deux strings vont contenir la date du debut et de la fin de la seance
					// pour voir si il est
					// donne cette semaine la (la semaine en cours est dans currentWeek)
					String dateDebut = services[j].getSeance()[e].getDebut();
					String dateFin = services[j].getSeance()[e].getFin();

					// les deux bloc try permettent de trouver la date du debut et de fin du
					// services pour
					// pour voir si la date courante est comprise entre eux

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

					// Si pour la semaine en cours la seance est donnée
					if ((semaineDebut < currentWeek && currentWeek < semaineFin && semaineFin > semaineDebut)
							|| (semaineDebut > semaineFin
									&& (currentWeek > semaineDebut || currentWeek < semaineFin))) {

						// verifie si le pro donne la seance
						if (services[j].getSeance()[e].getPro().equals(pros[i].getNomComplet())) {

							// si le membre est inscrit verifie si la facture du membre est nulle

							// si elle l'est
							if (pros[i].getCompte().equals("")) {

								String listeMember = getListeMembre(services[j].getSeance()[e]);
								if (listeMember.equals("")) {
									listeMember = "aucuns membres d'inscrits";
								}

								String newCompt = "\n---------------------------------------\n"
										+ "---------------------------------------" + "\n\nNom du Professionel: "
										+ pros[i].getNomComplet() + "\n" + "Numéro du professionel: "
										+ pros[i].getNumeroMembre() + "\n" + "Adresse du professionel: "
										+ pros[i].getAdresse() + "\n" + "Ville du professionel: " + pros[i].getCity()
										+ "\n" + "Province du professionel: " + pros[i].getProvince() + "\n"
										+ "Code postal du professionel: " + pros[i].getPostalCode() + "\n"
										+ "Service fourni: " + services[j].getTitre() +
										// cette longue ligne degueu permet de retourner la date de la seance avec le
										// format voulu
										"\n" + "Date de création: " + services[j].getSeance()[e].getDateCreation()
										+ "\n" + "Date du service: "
										+ LocalDate.parse(
												formatter.format(LocalDate.now().plusDays(
														calcDate(services[j].getSeance()[e].getRecurrence()))),
												formatter)
										+ "\nCode de la séance: " + services[j].getSeance()[e].getCode()
										+ "\nListe des membres de la séance: " + listeMember + "\n";

								pros[i].setCompte(newCompt);
							}
							// si la facture n'est pas nul
							else {
								String listeMember = getListeMembre(services[j].getSeance()[e]);
								if (listeMember.equals("")) {
									listeMember = "aucuns membres d'inscrits";
								}
								String newCompt = "\n---------------------------------------\n"
										+ "---------------------------------------" + "\n\nNom du Professionel: "
										+ pros[i].getNomComplet() + "\n" + "Numéro du professionel: "
										+ pros[i].getNumeroMembre() + "\n" + "Adresse du professionel: "
										+ pros[i].getAdresse() + "\n" + "Ville du professionel: " + pros[i].getCity()
										+ "\n" + "Province du professionel: " + pros[i].getProvince() + "\n"
										+ "Code postal du professionel: " + pros[i].getPostalCode() + "\n"
										+ "Service fourni: " + services[j].getTitre() +
										// cette longue ligne degueu permet de retourner la date de la seance avec le
										// format voulu
										"\n" + "Date de création: " + services[j].getSeance()[e].getDateCreation()
										+ "\n" + "Date du service: "
										+ LocalDate.parse(
												formatter.format(LocalDate.now().plusDays(
														calcDate(services[j].getSeance()[e].getRecurrence()))),
												formatter)
										+ "\nCode de la séance: " + services[j].getSeance()[e].getCode()
										+ "\nListe des membres de la séance: " + listeMember + "\n";

								pros[i].setCompte(pros[i].getCompte() + newCompt);

							}

						}

					}
				}
			}
		}
		for (int e = 0; e < pros.length; e++) {
			try {
				File f = new File(dir, "Rapport_" + pros[e].getNomComplet() + ".txt");

				// 3 eme si le fichier TEF du Pro existe deja

				// si il n'existe pas il est créé

				f.createNewFile();
				FileWriter fw = new FileWriter(f);
				BufferedWriter bw = new BufferedWriter(fw);
				bw.write(pros[e].getCompte());
				bw.flush();
				fw.close();

			} catch (IOException g) {
				g.printStackTrace();
				System.out.println("erreur fichier");
			}

		}

	}

	/**
	 * Cette methode est utilisé par rapportPro, elle permet de trouver la date
	 * exacte, car la date des seances est d'abord calculé par semaine, et par
	 * defaut c'est le vendredi, cette methode permet de soustraire ou d'ajouter les
	 * bons jours a la date en utilisant les recurrences des seances
	 * 
	 * @param day
	 *            String qui correspond a la recurrence d'une seance
	 * @return : retourne un int.
	 */
	private int calcDate(String day) {

		if (day.equals("Dimanche")) {
			return -5;
		}
		if (day.equals("Lundi")) {
			return -4;
		}
		if (day.equals("Mardi")) {
			return -3;
		}
		if (day.equals("Mercredi")) {
			return -2;
		}
		if (day.equals("Jeudi")) {
			return -1;
		}
		if (day.equals("Vendredi")) {
			return 0;
		}
		if (day.equals("Samedi")) {
			return 1;
		} else {
			return 0;
		}
	}

	/**
	 * Cette methode permet de prendre une seance et d'avoir la liste des membres
	 * formatté avec leurs noms et leurs numero
	 * 
	 * @param seance
	 *            la seance en question
	 * @return : Retourne la liste des membres sous forme de String
	 */
	public String getListeMembre(Seance seance) {
		String listeMembre = "";
		for (int i = 0; i < seance.getListeMembre().length; i++) {
			listeMembre += "\n\nNom du membre: " + seance.getListeMembre()[i].getNomComplet() + "\nNuméro du membre: "
					+ seance.getListeMembre()[i].getNumero();
		}
		return listeMembre;
	}
}
