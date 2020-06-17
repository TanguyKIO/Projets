
public enum Comportements {
	/**
	 * La fourmi ne fait rien.
	 * Ce comportement ne peut pas �tre g�n�r� al�atoirement, il est simplement utilis� pour la correction des arbres.
	 */
	NOTHING, 
	
	/**
	 * La fourmi va dans une direction al�atoire
	 */
	GO, 
	
	/**
	 * La fourmi va � gauche.
	 */
	GO_LEFT, 
	
	/**
	 * La fourmi va � droite.
	 */
	GO_RIGHT, 
	
	/**
	 * La fourmi va en haut.
	 */
	GO_UP, 
	
	/**
	 * La fourmi va en bas.
	 */
	GO_DOWN, 
	
	
	/**
	 * La fourmi essaie de r�colter la nourriture sur sa case.
	 */
	RECOLT, 
	
	/**
	 * La fourmi essaie de d�poser la nourriture.
	 */
	DEPOSE, 
	
	/**
	 * La fourmi rentre � se fourmili�re la plus proche.
	 */
	GO_HOME, 
	
	/**
	 * La fourmi se demande s'il y a de la nourriture sur sa case.
	 */
	IS_FOOD, 
	
	/**
	 * La fourmi se demande s'il y a une fourmili�re sur sa case.
	 */
	IS_HOME;
	
	/**
	 * Permet de savoir si ce le comportement est une question.
	 * A NOTER : La pr�sence de GO_HOME permet � la fourmi de bouger si elle est sur sa fourmili�re en le consid�rant comme une question.
	 * @return Un bool�en retournant vrai si c'est une question, faux sinon.
	 */
	public boolean isQuestion() { //Rajouter les comportements IS_....
    	return (this.equals(Comportements.IS_FOOD) || this.equals(Comportements.IS_HOME));
    }
}
