/**
 * C'est la méthode d'identification du Client.
 * 
 * @author Robert
 *
 */
public class Identification {

	public Identification() {

	}

	/**
	 * Fonction d'identification qui vérifie si le Membre est inscrit Vérifie
	 * également si le Client est suspendu ou non.
	 * 
	 * Prend les listes de la Base de données, ainsi que le numéro entré à l'aide de
	 * l'interface utilisateur.
	 * 
	 * @param data
	 *            : base de données
	 * @param numero
	 *            : Numéro de client à 9 chiffre
	 * @return Le résultat de l'identification sous forme de String
	 */
	public String identifier(DataCenter data, int numero) {
		String resultat = "Numéro invalide.";
		for (int i = 0; i < data.getMembre().length; i++) {
			if (data.getMembre()[i].getNumero() == numero) {
				if (data.getMembre()[i].getSuspendu() == false) {
					resultat = "Validé!";
				} else {
					resultat = "Membre suspendu";
				}
			}
		}
		// Vérifie d'abord la liste des Membres, ensuite celle des Professionnels.
		if (resultat.equalsIgnoreCase("Numéro invalide.")) {
			for (int j = 0; j < data.getPro().length; j++) {
				if (data.getPro()[j].getNumero() == numero) {
					if (data.getPro()[j].getSuspendu() == false) {
						resultat = "Validé!";
					} else {
						resultat = "Professionnel suspendu";
					}
				}
			}
		}
		return resultat;
	}

	/**
	 * Une deuxième version de l'identificateur (Pourrait peut-être servir aux CU
	 * qui nécessitent l'authentification : ex - s'inscrire à un cours) Vérifie si
	 * le Membre est inscrit au #GYM, s'il n'est pas suspendu.
	 * 
	 * Retourne un résultat sous forme de booléenne plutôt que String.
	 * 
	 * @param data
	 *            : base de données
	 * @param numero
	 *            : numéro à 9 chiffres
	 * @return True or False
	 */
	public boolean identifierBool(DataCenter data, int numero) {
		boolean resultat = false;
		boolean trouve = false;
		for (int i = 0; i < data.getMembre().length; i++) {
			if (data.getMembre()[i].getNumero() == numero) {
				trouve = true;
				if (data.getMembre()[i].getSuspendu() == false) {
					resultat = true;
				} else {
					resultat = false;
				}
			}
		}
		// Vérifie d'abord la liste des Membres, ensuite celle des Professionnels.
		if (trouve == false) {
			for (int j = 0; j < data.getPro().length; j++) {
				if (data.getPro()[j].getNumero() == numero) {
					if (data.getPro()[j].getSuspendu() == false) {
						resultat = true;
					} else {
						resultat = false;
					}
				}
			}
		}
		return resultat;
	}
	
	/**
	 * Méthode d'identification qui retourne le compte du membre
	 * @param data
	 * @param numero
	 * @return
	 */
	public Membre identifierMembre(DataCenter data, int numero) {
		Membre resultat = null;
		for (int i = 0; i < data.getMembre().length; i++) {
			if (data.getMembre()[i].getNumero() == numero) {
				resultat = data.getMembre()[i];
			} else {
				System.out.println("Le membre est introuvable");
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return resultat;
	}

}
