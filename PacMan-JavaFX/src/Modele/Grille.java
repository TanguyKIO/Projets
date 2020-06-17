/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import Modele.ModeleEntite.Direction;

/**
 *
 * @author p1920124
 */
public class Grille {
    public Pacman p;
    private int x_max;
    private int y_max;
    private int nb_pg;
    private HashMap<Point, ModeleStatique> hm= new HashMap<Point, ModeleStatique>();
    private HashMap<ModeleEntite,Point> map_position = new HashMap<ModeleEntite, Point>();
    private HashMap<ModeleEntite, Point> positions_preced = new HashMap<ModeleEntite, Point>();
    private Fantome f1,f2,f3,f4;
    private final int[][] init_map= 
    	   {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 2, 2, 2, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 0},
            {0, 3, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 3, 0},
            {0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0},
            {0, 2, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 2, 0},
            {0, 2, 2, 2, 2, 0, 2, 2, 2, 0, 2, 2, 2, 0, 2, 2, 2, 2, 0},
            {0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0},
            {0, 0, 0, 0, 2, 0, 2, 2, 2, 2, 2, 2, 2, 0, 2, 0, 0, 0, 0},
            {0, 0, 0, 0, 2, 0, 2, 0, 0, 1, 0, 0, 2, 0, 2, 0, 0, 0, 0},
            {2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 1, 0, 2, 2, 2, 2, 2, 2, 2},
            {0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0},
            {0, 0, 0, 0, 2, 0, 2, 2, 2, 1, 2, 2, 2, 0, 2, 0, 0, 0, 0},
            {0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0},
            {0, 2, 2, 2, 2, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 0},
            {0, 3, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 3, 0},
            {0, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 2, 2, 0},
            {0, 0, 2, 0, 2, 0, 2, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0, 0},
            {0, 2, 2, 2, 2, 0, 2, 2, 2, 0, 2, 2, 2, 0, 2, 2, 2, 2, 0},
            {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0},
            {0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},};
    
    int[][]map=init_map.clone();
    Point pt, pt_theorique;
    boolean franchissable;
    ModeleStatique ms;
    String s;
    int n;
    Point p_spawn;
	Point f1_spawn;
	Point f2_spawn;
	Point f3_spawn;
	Point f4_spawn;
    ModeleStatique[] cases = new ModeleStatique[500];
	Point[] pts=new Point[500];
	String test;
    
	public Grille() {
    	p=new Pacman(this);
    	f1=new Fantome(this,1);
    	f2=new Fantome(this,2);
    	f3=new Fantome(this,3);
    	f4=new Fantome(this,4);
    }

	public void init() {
		for(int i=0;i<init_map.length;i++) {
			map[i]=Arrays.copyOf(init_map[i], init_map[i].length);
		}
		positions_preced.clear();
		map_position.clear();
		hm.clear();
		
		p_spawn= new Point(p.getSpawn());
		f1_spawn= new Point(f1.getSpawn());
		f2_spawn= new Point(f2.getSpawn());
		f3_spawn= new Point(f3.getSpawn());
		f4_spawn= new Point(f4.getSpawn());
    	
    	map_position.put(p, p_spawn);
    	map_position.put(f1, f1_spawn);
    	map_position.put(f2, f2_spawn);
    	map_position.put(f3, f3_spawn);
    	map_position.put(f4, f4_spawn);
    	
    	y_max=map[0].length-1;
    	x_max=map.length-1;
    	n = 0;
    	nb_pg=0;
    	
    	for(int i=0;i<map.length;i++) {
    		for(int j=0;j<map[i].length;j++) {
    			pts[n]=new Point(i,j);
    			if(map[i][j]==0) {
    				cases[n]=new Mur();
    				hm.put(pts[n],cases[n]);
    			}
    			if(map[i][j]==1) {
    				cases[n]=new Case(1);
    				hm.put(pts[n],cases[n]);
    			}
    			if(map[i][j]==2) {
    				cases[n]=new Case(2);
    				hm.put(pts[n],cases[n]);
    				nb_pg++;
    			}
    			if(map[i][j]==3) {
    				cases[n]=new Case(3);
    				hm.put(pts[n],cases[n]);
    				nb_pg++;
    			}
    			n++;
    		}
    	}
	}
	synchronized public String test() {
		pt=map_position.get(p);
		if(test=="contact")return test;
		test="";
    	if(pt.equals(map_position.get(f1)) || (pt.equals(positions_preced.get(f1)) && p.getDirection()==f1.getInvDirection())) {
    		if(p.getEtat()) {
    			Manger();
    			f1.kill();
    			return "mange";
    		}
    		else {
    			return "contact";
    		}
    	}
    	else if(pt.equals(map_position.get(f2)) || (pt.equals(positions_preced.get(f2)) && p.getDirection()==f2.getInvDirection())) {
    		if(p.getEtat()) {
    			f2.kill();
    			Manger();
    			return "mange";
    		}
    		else {
    			return "contact";
    		}    	
    		
		}
    	else if(pt.equals(map_position.get(f3)) || (pt.equals(positions_preced.get(f3)) && p.getDirection()==f3.getInvDirection())) {
    		if(p.getEtat()) {
    			f3.kill();
    			Manger();
    			return "mange";
    		}
    		else {
    			return "contact";
    		}
		}
    	else if(pt.equals(map_position.get(f4)) || (pt.equals(positions_preced.get(f4)) && p.getDirection()==f4.getInvDirection())) {
    		if(p.getEtat()) {
    			f4.kill();
    			Manger();
    			return "mange";
    		}
    		else {
    			return "contact";
    			
    		}
		}
    	else {
    		return hm.get(map_position.get(p)).getLibelle();
    	}	
    }
	
	synchronized public boolean possible(ModeleEntite m,Direction d) {
    	pt=map_position.get(m);
    	Point pt_theorique=(Point) pt.clone();
    	int x=(int) pt_theorique.getX();
    	int y=(int) pt_theorique.getY();
 
    	switch(d) {
	    	case HAUT:
	    		if(x==0) {
	    			pt_theorique.translate(x_max,y);
	    		}
	    		else {
	    			pt_theorique.translate(-1,0);
	    		}
	    		franchissable=hm.get(pt_theorique).estFranchissable();
	    		return franchissable;
	    		
	    	case BAS:
	    		if(x==x_max) {
	    			pt_theorique.move(0,y);
	    		}
	    		else {
	    			pt_theorique.translate(1,0);
	    		}
	    		franchissable=hm.get(pt_theorique).estFranchissable();
	    		return franchissable;
	    		
	    	case GAUCHE:
	    		if(y==0) {
	    			pt_theorique.move(x,y_max);
	    		}
	    		else {
	    			pt_theorique.translate(0,-1);
	    		}
	    		franchissable=hm.get(pt_theorique).estFranchissable();
	    		return franchissable;
	    		
	    	case DROITE:
	    		if(y==y_max) {
	    			pt_theorique.move(x,0);
	    		}
	    		else {
	    			pt_theorique.translate(0,1);
	    		}
	    		franchissable=hm.get(pt_theorique).estFranchissable();
	    		return franchissable;
	    		
	    	default:
	    		return false;
    	}
    	
    }
    
    synchronized public void deplacer(ModeleEntite m, Direction d) {
    	pt=map_position.get(m);
    	Point pt_precedent=new Point(pt);
    	positions_preced.put(m,pt_precedent);
    	switch (d) {
    		case HAUT :
    			if(pt.getX()!=0) {
	    			pt.setLocation(pt.getX()-1, pt.getY());
    			}
    			else {
    				pt.setLocation(x_max, pt.getY());
    			}
    			break;
    		case BAS :
    			if(pt.getX()!=x_max) {
	    			pt.setLocation(pt.getX()+1, pt.getY());
    			}
    			else {
    				pt.setLocation(0, pt.getY());
    			}
    			break;
    		case DROITE :
    			if(pt.getY()!=y_max) {
	    			pt.setLocation(pt.getX(), pt.getY()+1);
    			}
    			else {
    				pt.setLocation(pt.getX(), 0);
    			}
    			break;
    		case GAUCHE :
    			if(pt.getY()!=0) {
    				pt.setLocation(pt.getX(), pt.getY()-1);
    			}
    			else {
    				pt.setLocation(pt.getX(), y_max);
    			}
    			break;
    		default : break;
    	}
    }

	synchronized public void Manger() {
		pt=map_position.get(p);
		ms=hm.get(pt);
		if(ms instanceof Case && ms.getLibelle()!="case") {
			((Case) ms).vider();
			map[(int) pt.getX()][(int) pt.getY()]=1;
			nb_pg--;
			if(nb_pg==0) {
				p.gagner();
			}
		}
	}
   
	public HashMap<ModeleEntite, Point> getMap_position() {
		return map_position;
	}
	
	public int[][] getmap(){
		return map;
	}
	
	public Pacman getP() {
		return p;
	}

	public Fantome getF1() {
		return f1;
	}

	public Fantome getF2() {
		return f2;
	}

	public Fantome getF3() {
		return f3;
	}

	public Fantome getF4() {
		return f4;
	}

	synchronized public void setPosition(ModeleEntite m, Point point) {
		pt=map_position.get(m);
		pt.move((int) point.getX(), (int) point.getY());
	}
}
