/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

/**
 *
 * @author p1920164
 */
public class Case extends ModeleStatique{
	boolean pacgomme, s_pacgomme;
    public Case(int n) {
    	super.mur=false;
    	switch(n) {
	    	case 1:
	    		super.libelle="case";
	    		pacgomme=false;
	    		s_pacgomme=false;
	    		break;
	    	case 2:
	    		pacgomme=true;
	    		s_pacgomme=false;
	    		super.libelle="pacgomme";
	    		break;
	    	case 3:
	    		pacgomme=false;
	    		s_pacgomme=true;
	    		super.libelle="superpacgomme";
	    		break;
	    	default : 
	    		super.libelle="case";
	    		pacgomme=false;
	    		s_pacgomme=false;
	    		break;
    	}
    }
    
    public void vider() {
    	pacgomme=false;
    	s_pacgomme=false;
    	super.libelle="case";
    }
}
