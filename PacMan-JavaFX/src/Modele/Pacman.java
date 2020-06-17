/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.awt.Point;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

/**
 *
 * @author p1920164
 */
public class Pacman extends ModeleEntite implements Runnable{
    private int score, nb_vie, t;

    private Grille g;
    private Direction d, d0;
    private boolean isSuper, gagnant;
    private Point spawn;
    
    String resultat;
    Timeline timeline=new Timeline();
    
    public Pacman(Grille g){
    	this.g=g;
    	nb_vie=3;
    	score=0;
        gagnant=false;
        super.vivant=false;
        super.pause=false;
        started=false;
        spawn=new Point(11,9);
        
    }
    
    public Point getSpawn() {
		return spawn;
	}
    
    public void setDirection(Direction d) {
    	this.d=d;   	
    }
    
    public Direction getDirection() {
    	return d0;
    }
    
    public void run(){
    	super.started=true;
    	while(true) {
    		if(!super.vivant) {
		    	score=0;
		    	nb_vie=3;
		    	d=Direction.NULLE;
		        d0=Direction.NULLE;
		        t=200;
		        isSuper=false;
		    	super.vivant =true;
		    	super.pause=false;
		    	gagnant=false;
    		}
	    	while(!super.pause) { 
	    		 resultat=g.test();
	    		 switch(resultat) {
		 	    	case "pacgomme" :
		 	    		g.Manger();
		 	    		score=score+100;
		 	    		break;
		 	    		
		 	    	case "superpacgomme" :
		 	    		g.Manger();
		 	    		startSuper();
		 	    		score=score+200;
		 	    		break;
		 	    		
		 	    	case "manger" :
		 	    		score=score+400;
		 	    		break;
		 	    		
		 	    	case "contact" :
		 	    		nb_vie--;
		 	    		score=score-1000;
		 	    		g.setPosition(this, spawn);
		 	        	d=Direction.NULLE;
		 	        	d0=Direction.NULLE;
		 	        	if(nb_vie==0){
		 	   	       		defaite();
		 	        	}
		 	    		break;
		 	    	
		 	    	default :
		 	    		break;
		     	}
		         
		         if (g.possible(this,d)){
		             g.deplacer(this,d);
		             d0=d;
		             d=Direction.NULLE;
		         }
		         else if(g.possible(this,d0)){
		             g.deplacer(this,d0);
		         }
	 			 setChanged();
	 	        
	 			 // notification de l'observer
	 	         notifyObservers(); 
	            
	 			    try {
						Thread.sleep(t); // pause 
					} catch (InterruptedException e) {
						e.printStackTrace();
					}  
	         }
	    	while(pause) {
	    		synchronized(this) {
	    			try{
	    				this.wait();
	    			}catch(InterruptedException e){
	    				e.printStackTrace();
	    			}
	    		}
	    	}
    	}
    
    }
    
    
    
    public int getVies(){
    	return nb_vie;  	 
    }
    
    public boolean getEtat() {
    	return isSuper;
    }
    
    
	public void startSuper() {
		timeline.stop();
		t=150;
		isSuper=true;
		timeline = new Timeline(new KeyFrame(
		        Duration.millis(5000),
		        ae -> stopSuper()));
		timeline.play();
		
	}
	
	public String getScore(){
    	return String.valueOf(score);  	 
    }

	private void stopSuper() {
		t=200;
		isSuper=false;		
	}

	public void gagner() {
		super.vivant=false;
		gagnant=true;
       	super.pause=true;
       	g.getF1().setPause(true);
   		g.getF2().setPause(true);
   		g.getF3().setPause(true);
		g.getF4().setPause(true);
	}
	
	public void defaite() {
		super.vivant=false;
   		super.pause=true;
   		g.getF1().setPause(true);
   		g.getF2().setPause(true);
   		g.getF3().setPause(true);
		g.getF4().setPause(true);
	}
	
	
	public boolean aGagne() {
		return gagnant;
	}

	public boolean estFini() {
		return gagnant || !super.vivant;
	}
	
	public void reveil() {
		synchronized(this) {
			this.notify();
			super.pause=false;
		}
	}
}
