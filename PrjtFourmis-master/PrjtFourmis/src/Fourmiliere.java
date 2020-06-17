
public class Fourmiliere extends Case{
	/**
	 * Le nombre de nourriture stock�e dans la fourmili�re (ramen�e par la fourmi)
	 * Non utilis�e mais impl�ment�e si besoin.
	 */
	private int nbNourrStock;
	
	//Constructeurs
	
	/**
	 * Cr�e une fourmili�re avec une quantit� de nourriture d�j� stock�e en param�tre
	 * 
	 * @param nbNourrStock Nombre de nourriture d�j� stock�e.
	 * @param val Un caract�re qui sera F pour que l'on voit la fourmili�re sur la carte.
	 * @see Fourmiliere#nbNourrStock
	 * @see Case#Case(char)
	 */
	public Fourmiliere(int nbNourrStock, char val) {
		super(val);
		this.nbNourrStock = nbNourrStock;
	}
	
	//Get
	
	/**
	 * R�cup�re le nombre de nourriture stock�e dans la fourmili�re.
	 * @return L'entier associ�e � la nourriture stock�e
	 * @see Fourmiliere#nbNourrStock
	 */
	public int getNourr() {
		return this.nbNourrStock;
	}
	
	//Set
	
	/**
	 * Permet de modifier la quantit� de nourriture stock�e.
	 * @param nb La nouvelle quantit� de nourriture stock�e
	 * @see Fourmiliere#nbNourrStock
	 */
	public void setNourr(int nb) {
		nbNourrStock = nb;
	}
}
