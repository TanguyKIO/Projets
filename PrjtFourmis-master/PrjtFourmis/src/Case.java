
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
	 * Cela sera une chaine de caractères afin de savoir ce qu'il y a sur cette case.
	 * R pour rien
	 * N pour nourriture
	 * F pour fourmilière
	 * A pour fourmi
	 * A + N pour fourmi et nourriture
	 * A + F pour fourmi et fourmilière
	 */
	private char value;
	
	
	//Constructeurs
	
	/**
	 * 
	 *  Constructeur créant une case avec rien dedans aux coordonnées spécifiées en paramètre.
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
	 *  Constructeur créant une case avec pour valeur le paramètre val aux coordonnées spécifiées en paramètre.
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
	 * Constructeur créant une case avec pour valeur le paramètre val.
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
	 * @return L'entier associé à la ligne de la case
	 * @see Case#row
	 */
	public int getRow() {
		return this.row;
	}
	
	/**
	 * Retourne la colonne de la case.
	 * 
	 * @return L'entier associé à la colonne de la case
	 * @see Case#col
	 */
	public int getCol() {
		return this.col;
	}
	
	/**
	 * Retourne la valeur de la case.
	 * 
	 * @return Le caractère associé à la case
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
	 * @param val Caractère remplaçant l'ancien
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
