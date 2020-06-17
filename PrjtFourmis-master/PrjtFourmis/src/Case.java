
public class Case {
	/**
	 * La valeur de la ligne du monde sur laquelle se situe la case.
	 */
	protected int row;
	
	/**
	 * La valeur de la colonne du monde sur laquelle se situe la case.
	 */
	protected int col;
	
	/**
	 * La valeur de la case du monde sur laquelle se situe la case.
	 * Cela sera une chaine de caract�res afin de savoir ce qu'il y a sur cette case.
	 * R pour rien
	 * N pour nourriture
	 * F pour fourmili�re
	 * A pour fourmi
	 * A + N pour fourmi et nourriture
	 * A + F pour fourmi et fourmili�re
	 */
	private char value;
	
	
	//Constructeurs
	
	/**
	 * 
	 *  Constructeur cr�ant une case avec rien dedans aux coordonn�es sp�cifi�es en param�tre.
	 *  
	 * @param x Ligne de la case 
	 * @param y Colonne de la case
	 * @see Case#col
	 * @see Case#row
	 */
	public Case(int x, int y) {
		row = x;
		col = y;
		value = 'R';
	}
	
	/**
	 *  Constructeur cr�ant une case avec pour valeur le param�tre val aux coordonn�es sp�cifi�es en param�tre.
	 *  
	 * @param x Ligne de la case 
	 * @param y Colonne de la case
	 * @param val Valeur de la case
	 * @see Case#value
	 * @see Case#col
	 * @see Case#row
	 * @see Case#Case(int, int)
	 */
	public Case(int x, int y, char val) {
		this(x,y);
		value = val;
	}
	
	/**
	 * Constructeur cr�ant une case avec pour valeur le param�tre val.
	 * @param val Valeur de la case
	 * @see Case#value
	 */
	public Case(char val) {
		value = val;
	}
	
	
	//Get
	
	/**
	 * Retourne la ligne de la case.
	 * 
	 * @return L'entier associ� � la ligne de la case
	 * @see Case#row
	 */
	public int getRow() {
		return this.row;
	}
	
	/**
	 * Retourne la colonne de la case.
	 * 
	 * @return L'entier associ� � la colonne de la case
	 * @see Case#col
	 */
	public int getCol() {
		return this.col;
	}
	
	/**
	 * Retourne la valeur de la case.
	 * 
	 * @return Le caract�re associ� � la case
	 * @see Case#value
	 */
	public char getValue() {
		return this.value;
	}
	
	
	//Set
	
	/**
	 * Permet de modifier la ligne de la case.
	 * 
	 * @param x Entier, nouvelle ligne
	 * @see Case#row
	 */
	public void setRow(int x) {
		this.row = x;
	}
	
	/**
	 * Permet de modifier la colonne de la case.
	 * 
	 * @param y Entier, nouvelle colonne
	 * @see Case#col
	 */
	public void setCol(int y) {
		this.col = y;
	}
	
	/**
	 * Permet de modifier la valeur de la case.
	 * 
	 * @param val Caract�re rempla�ant l'ancien
	 * @see Case#value
	 */
	public void setVal(char val) {
		this.value = val;
	}
	
	/**
	 * Permet de modifier la case
	 * 
	 * @param c Case, qui sera la nouvelle case
	 */
	public void setCase(Case c) {
		this.col=c.getCol();
		this.row=c.getRow();
		this.value=c.getValue();
	}
	
	
	//Affichage
	
	/**
	 * Permet d'afficher la valeur de la case
	 * Utile pour le mode texte
	 * @see Case#value
	 */
	public void afficherCase() {
		System.out.print(this.value);
	}
	
	
}
