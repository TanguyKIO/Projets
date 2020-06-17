
public class Nourriture extends Case{
	/**
	 * Quantité de nourriture sur la case
	 */
	private int quantite;
	
	//Constructeurs
	
	/**
	 * Crée une case de type Nourriture avec une quantité et N comme valeur afin de la reconnaitre
	 * @param quantite La nombre de nourriture sur la case
	 * @param val Un caractère qui sera N pour que l'on voit la nourriture sur la carte.
	 * @see Nourriture#quantite
	 * @see Case#Case(char)
	 */
	public Nourriture (int quantite, char val) {
		super(val);
		this.quantite = quantite;
	}
	
	//Get

	/**
	 * Récupère la quantité de nourriture sur la case
	 * @return La quantité de nourriture
	 * @see Nourriture#quantite
	 */
	public int getQuantite() {
		return quantite;
	}
	
	/**
	 * Permet de modifier la quantité de nourriture sur la case.
	 * 
	 * @see Nourriture#quantite
	 * @param i La nouvelle quantité de nourriture sur la case
	 */
	public void setQuantite(int i) {
		quantite = i;
	}

}
