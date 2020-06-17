
public class Fourmiliere extends Case{
	/**
	 * Le nombre de nourriture stockée dans la fourmilière (ramenée par la fourmi)
	 * Non utilisée mais implémentée si besoin.
	 */
	private int nbNourrStock;
	
	//Constructeurs
	
	/**
	 * Crée une fourmilière avec une quantité de nourriture déjà stockée en paramètre
	 * 
	 * @param nbNourrStock Nombre de nourriture déjà stockée.
	 * @param val Un caractère qui sera F pour que l'on voit la fourmilière sur la carte.
	 * @see Fourmiliere#nbNourrStock
	 * @see Case#Case(char)
	 */
	public Fourmiliere(int nbNourrStock, char val) {
		super(val);
		this.nbNourrStock = nbNourrStock;
	}
	
	//Get
	
	/**
	 * Récupère le nombre de nourriture stockée dans la fourmilière.
	 * @return L'entier associée à la nourriture stockée
	 * @see Fourmiliere#nbNourrStock
	 */
	public int getNourr() {
		return this.nbNourrStock;
	}
	
	//Set
	
	/**
	 * Permet de modifier la quantité de nourriture stockée.
	 * @param nb La nouvelle quantité de nourriture stockée
	 * @see Fourmiliere#nbNourrStock
	 */
	public void setNourr(int nb) {
		nbNourrStock = nb;
	}
}
