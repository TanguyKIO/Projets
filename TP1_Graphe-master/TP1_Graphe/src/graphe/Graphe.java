package graphe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Graphe {
	private Map<Sommet, ArrayList<Sommet>> listeAdj;
	private ArrayList<Sommet> listeSommet;

	public Graphe(Map<Sommet, ArrayList<Sommet>> listeAdj, ArrayList<Sommet> listeSommet) {
		this.listeAdj = listeAdj;
		this.listeSommet = listeSommet;
		degre();
	}
	
	public void degre() {
		 Iterator iterator = listeAdj.entrySet().iterator();
	     while (iterator.hasNext()) {
	    	Map.Entry mapentry = (Map.Entry) iterator.next();
	    	int degre=(int)((ArrayList<Sommet>) mapentry.getValue()).size();
	        ((Sommet) mapentry.getKey()).setDegre(degre);
	     } 
	}
	
	public void triDecroissant(ArrayList<Sommet> L) {
		Collections.sort(L);
	}
	
	public ArrayList<Sommet> triAleatoire(ArrayList<Sommet> L){
		ArrayList <Sommet> l_s1 = new ArrayList<>(L);
		ArrayList <Sommet> l_s2 = new ArrayList<>();
		int i;
		
		while (!l_s1.isEmpty()) {
			Random rand = new Random ();
			i= rand.nextInt(l_s1.size());
			
			l_s2.add(l_s1.get(i));
			l_s1.remove(i);
		}
		
		return l_s2;
	}
	
	public void afficherGraphe() {
		Iterator iterator = listeAdj.entrySet().iterator();
	     while (iterator.hasNext()) {
	    	Map.Entry mapentry = (Map.Entry) iterator.next();
	    	System.out.println(mapentry);
	     } 
	     
	}
	
	public void triCroissant(ArrayList<Sommet> L) {
		Collections.sort(L,Collections.reverseOrder());
	}
	
	public void GreedyColoring(int n) {
		Sommet s;
		ArrayList<Sommet> L = listeSommet;
		if(n==1) {
			L=triAleatoire(L);
		}
		if(n==2) {
			triCroissant(L);
		}
		if(n==3) {
			triDecroissant(L);
		}
		Iterator<Sommet> it = L.iterator();
		while(!(L.isEmpty())){
			s=it.next();
			colorer(s);
			it.remove();
		}
	}
	
	public void WelshPowell(int n) {
		Sommet x,y;
		boolean adjacent=false;
		ArrayList<Sommet> L = listeSommet;
		if(n==1) {
			L=triAleatoire(L);
		}
		if(n==2) {
			triCroissant(L);
		}
		if(n==3) {
			triDecroissant(L);
		}
		ArrayList <Sommet> adj=new ArrayList<Sommet>();
		int k=1;
		while(!L.isEmpty()){
			Iterator<Sommet> it = L.iterator();
			x=it.next();
			x.setCouleur(k);
			adj.add(x);
			it.remove();
			while(it.hasNext()) {
				y=it.next();
				for(Sommet s : adj) {
					if(listeAdj.get(y).contains(s)){
						adjacent=true;
					}
				}
				if(!adjacent) {
					adj.add(y);
					y.setCouleur(k);
					it.remove();
				}
				adjacent=false;
				
			}
			
			adj.clear();
			k++;
		}


		
	}
	
	public void DSATUR(int n) {
		Sommet x,y;
		int dsat,dsat_max,deg;
		dsat=-1;
		ArrayList<Sommet> L = listeSommet;
		if(n==1) {
			L=triAleatoire(L);
		}
		if(n==2) {
			triCroissant(L);
		}
		if(n==3) {
			triDecroissant(L);
		}
		x=L.get(0);
		x.setCouleur(1);
		L.remove(x);
		while(!(L.isEmpty())){
			Iterator<Sommet> it = L.iterator();
			y=null;
			deg=-1;		
			dsat_max=-1;
			while(it.hasNext()) {
				x=it.next();
				dsat=DSAT(x);
				if(dsat>dsat_max) {
					y=x;
					dsat_max=dsat;
					deg=y.getDegre();
				}
				else if(dsat==dsat_max) {
					if(x.getDegre()>deg) {
						y=x;
						deg=y.getDegre();
					}
				}
			}
			colorer(y);
			L.remove(y);
		}
	}

	private int DSAT(Sommet s) {
		int nb_couleurs=0;
		int couleur,dsat;
		Sommet x;
		ArrayList<Integer> l_couleurs=new ArrayList<Integer>();
		ArrayList <Sommet> adj=listeAdj.get(s);
		Iterator<Sommet> it = adj.iterator();
		while(it.hasNext()) {
			x=it.next();
			couleur=x.getCouleur();
			if(!(l_couleurs.contains(couleur)) && couleur!=0) {
				l_couleurs.add(couleur);
				nb_couleurs++;
			}
		}
		if(nb_couleurs==0) {
			dsat=s.getDegre();
		}
		else {
			dsat=nb_couleurs;
		}
		return dsat;
		
	}

	private void colorer(Sommet s) {
		int couleur=1;
		int index=1;
		boolean trouve=false;
		ArrayList<Integer> l_couleurs = new ArrayList<Integer>();
		ArrayList <Sommet> adj=listeAdj.get(s);
		Iterator iterator = adj.iterator();
	    for(Sommet s_adj : adj){
	    	if(s_adj.getCouleur()!=0 && !l_couleurs.contains(s_adj.getCouleur())) {
	    		l_couleurs.add(s_adj.getCouleur());
	    	}
	    	
	    }
	    while (!trouve) {
	    	if(!(l_couleurs.contains(index))) {
	    		couleur=index;
	    		trouve=true;
	    	}
	    	else {
	    		index++;
	    	}
	    }
		s.setCouleur(couleur);
	}

	public int getNbCouleur() {
		int compteur=0;
		Sommet s;
		ArrayList<Integer> listeCouleurs=new ArrayList<Integer>();
		Iterator iterator = listeAdj.entrySet().iterator();
		while (iterator.hasNext()) {
	    	Map.Entry mapentry = (Map.Entry) iterator.next();
	    	s=(Sommet) mapentry.getKey();
	    	if(!(listeCouleurs.contains(s.getCouleur()))){
	    		listeCouleurs.add(s.getCouleur());
	    		compteur++;
	    	}
	     }
	     return compteur;
	}
	
	public boolean verif() {
		Sommet s1;
		ArrayList<Sommet> L=new ArrayList<Sommet>();		
		Iterator iterator = listeAdj.entrySet().iterator();
	    while (iterator.hasNext()) {
	    	Map.Entry mapentry = (Map.Entry) iterator.next();
	    	s1=(Sommet) mapentry.getKey();
	    	L=listeAdj.get(s1);
			for(Sommet s_adj : L) {
				if(s1.getCouleur()==s_adj.getCouleur()) {
					return false;
				}
			}
	     }
		return true;
	}
}
