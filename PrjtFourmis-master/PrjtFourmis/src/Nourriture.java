
public class Nourriture extends Case{
	/**
	 * Quantit� de nourriture sur la case
	 */
	private int quantite;
	
	//Constructeurs
	
	/**
	 * Cr�e une case de type Nourriture avec une quantit� et N comme valeur afin de la reconnaitre
	 * @param quantite La nombre de nourriture sur la case
	 * @param val Un caract�re qui sera N pour que l'on voit la nourriture sur la carte.
	 * @see Nourriture#quantite
	 * @see Case#Case(char)
	 */
	public Nourriture (int quantite, char val) {
		super(val);
		this.quantite = quantite;
	}
	
	//Get

	/**
	 * R�cup�re la quantit� de nourriture sur la case
	 * @return La quantit� de nourriture
	 * @see Nourriture#quantite
	 */
	public int getQuantite() {
		return quantite;
	}
	
	/**
	 * Permet de modifier la quantit� de nourriture sur la case.
	 * 
	 * @see Nourriture#quantite
	 * @param i La nouvelle quantit� de nourriture sur la case
	 */
	public void setQuantite(int i) {
		quantite = i;
	}

}
