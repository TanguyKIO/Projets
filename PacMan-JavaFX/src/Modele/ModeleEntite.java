/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.awt.Point;
import java.util.Observable;
import java.util.Observer;

import Modele.ModeleEntite.Direction;

/**
 *
 * @author p1920164
 */
public class ModeleEntite extends Observable{
    protected boolean pause, vivant, started;
    
    public enum Direction{
        HAUT,
        BAS,
        GAUCHE,
        DROITE,
        NULLE
    }
    
    public void setPause(boolean f) {
		pause=f;
	}
	
	public boolean getPause() {
		return pause;
	}
	
	public boolean estVivant() {
		return vivant;
	} 
	
	public boolean isStarted() {
		return started;
	}
}
