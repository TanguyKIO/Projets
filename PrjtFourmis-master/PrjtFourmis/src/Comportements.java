
public enum Comportements {
	/**
	 * La fourmi ne fait rien.
	 * Ce comportement ne peut pas être généré aléatoirement, il est simplement utilisé pour la correction des arbres.
	 */
	NOTHING, 
	
	/**
	 * La fourmi va dans une direction aléatoire
	 */
	GO, 
	
	/**
	 * La fourmi va à gauche.
	 */
	GO_LEFT, 
	
	/**
	 * La fourmi va à droite.
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
	 * La fourmi essaie de récolter la nourriture sur sa case.
	 */
	RECOLT, 
	
	/**
	 * La fourmi essaie de déposer la nourriture.
	 */
	DEPOSE, 
	
	/**
	 * La fourmi rentre à se fourmilière la plus proche.
	 */
	GO_HOME, 
	
	/**
	 * La fourmi se demande s'il y a de la nourriture sur sa case.
	 */
	IS_FOOD, 
	
	/**
	 * La fourmi se demande s'il y a une fourmilière sur sa case.
	 */
	IS_HOME;
	
	/**
	 * Permet de savoir si ce le comportement est une question.
	 * A NOTER : La présence de GO_HOME permet à la fourmi de bouger si elle est sur sa fourmilière en le considérant comme une question.
	 * @return Un booléen retournant vrai si c'est une question, faux sinon.
	 */
	public boolean isQuestion() { //Rajouter les comportements IS_....
    	return (this.equals(Comportements.IS_FOOD) || this.equals(Comportements.IS_HOME));
    }
}
