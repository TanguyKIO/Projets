/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modele;

public class ModeleStatique {
	public boolean mur;
	public String libelle;
    
	public boolean estFranchissable() {
		return !mur;
	}
	
	public String getLibelle() {
		return libelle;
	}
	
}
