/**
 * Le gestionnaire des professionnels. 
 * Contient les méthodes qui touchent à cette catégorie de membre.
 * @author Shado
 *
 */
public class GestionnairePro {
	DataCenter data;
	public GestionnairePro(DataCenter data) {
		this.data = data;
	}
	
	public void createPro() {
		CreatePro cp = new CreatePro(data);
	}
}
