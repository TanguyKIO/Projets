package graphe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class Sommet implements Comparable<Sommet>{
	private int num;
	private int couleur;
	private int DSAT;
	private int degre;
	
	public Sommet(int num) {
		this.num=num;
		couleur=0;
		setDSAT(0);
	}
	
	public int getNum() {
		return num;
	}

	public void setLabel(int num) {
		this.num = num;
	}

	public int getCouleur() {
		return couleur;
	}

	public void setCouleur(int couleur) {
		this.couleur = couleur;
	}
	
	public int getDegre() {
		return degre;
	}

	public void setDegre(int degre) {
		this.degre = degre;
	}
	
	public int compareTo(Sommet s) {
		int resultat=0;
		if(this.degre<s.getDegre()) resultat=1;
		if(this.degre>s.getDegre()) resultat=-1;
		if(this.degre==s.getDegre()) resultat= 0;
		return resultat;
	}

	public int getDSAT() {
		return DSAT;
	}

	public void setDSAT(int dSAT) {
		DSAT = dSAT;
	}
	
	public String toString() {
		return String.valueOf(num);
	}
	
	public boolean equals(Sommet s) {
		return(s.getNum()==this.getNum());
	}


}
