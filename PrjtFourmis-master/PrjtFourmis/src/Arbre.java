import java.io.BufferedReader;
import java.io.IOException;

public class Arbre {
	/**
	 * Chaque noeud de l'arbre est un objet de type comportement.
	 * 
	 * @see Arbre#getNoeud()
	 * @see Arbre#setNoeud(Comportements)
	 * @see Comportements
	 */
	private Comportements valeur;

	/**
	 * Chaque fils gauche/droit est lui m�me un arbre.
	 * 
	 * @see Arbre#getSousArbreDroit()
	 * @see Arbre#setSousArbreGauche(Arbre)
	 * @see Arbre#setSousArbreDroite(Arbre)
	 * @see Arbre#getSousArbreGauche()
	 */
	private Arbre fg, fd;

	// Constructeurs

	/**
	 * Constructeur de base cr�ant un arbre qui est une feuille (pas de fils).
	 * 
	 * @param val Un objet de type Comportement qui sera la valeur du noeud
	 */
	public Arbre(Comportements val) {
		this.valeur = val;
	}

	/**
	 * Constructeur permettant de cr�er un arbre plus complexe puisque l'on
	 * renseigne les fils.
	 * 
	 * @param x Valeur du noeud racine qui est de type Comportement
	 * @param g Un objet de type arbre qui sera le fils gauche
	 * @param d Un objet de type arbre qui sera le fils droit
	 */
	public Arbre(Comportements x, Arbre g, Arbre d) {
		valeur = x;
		fg = g;
		fd = d;
	}

	/**
	 * Constructeur (r�cursif) utilis� pour la cr�ation de comportements al�atoires.
	 * On peut renseigner un taux afin que les arbres pouvant avoir des fils ne
	 * l'aient qu'avec un certain pourcentage de chance. L'arbre cr�� ici ne sera
	 * pas optimal.
	 * 
	 * @param rate Le taux de chance pour qu'en plus de conditions de base
	 *             n�c�ssaires, le noeud sur lequel ce constructeur est appel� ait
	 *             des fils.
	 */
	public Arbre(int rate) {

		int rnd = (int) (Math.random() * (Comportements.values().length - 1));
		this.valeur = Comportements.values()[rnd + 1];
		rnd = (int) (Math.random() * 100);
		if (this.valeur.isQuestion() && rnd < rate) {
			this.fg = new Arbre(rate);// /2
			this.fd = new Arbre(rate);// /2
		}
	}

	/**
	 * Fonction r�cursive permettant de t�l�charger un arbre � partir de sa
	 * conversion en cha�ne de caract�res
	 * 
	 * @param indent  Une chaine de caract�res constitu�e d'espaces, utilis�e pour
	 *                l'affichage de l'arbre.
	 * @param lecteur BufferReader contenant l'arbre
	 * @param lineN   Premi�re ligne du BufferReader
	 */
	public Arbre(String indent, BufferedReader lecteur, String lineN) {
		lineN = lineN.split("-")[1];
		this.valeur = Comportements.valueOf(lineN);
		indent += "  ";
		String lineK = "";
		try {
			lecteur.mark(0);
			lineK = lecteur.readLine();
			if (lineK != null) {
				if (lineK.indexOf(indent) == -1) {
					indent = indent.substring(0, indent.length() - 2);
				} else {
					this.setSousArbreGauche(new Arbre(indent, lecteur, lineK));
					lecteur.reset();
					lineK = lecteur.readLine();
					this.setSousArbreDroite(new Arbre(indent, lecteur, lineK));
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(0);
		}
	}

	// Get

	/**
	 * Permet de r�cup�rer le comportement sur le noeud de l'arbre.
	 * 
	 * @return Un objet de type comportement qui est la valeur du noeud de l'arbre
	 */
	public Comportements getNoeud() {
		return (valeur);
	}

	/**
	 * Permet de r�cup�rer le fils gauche de l'arbre.
	 * 
	 * @return Un objet de type arbre qui est le fils gauche de l'arbre.
	 */
	public Arbre getSousArbreGauche() {
		return (fg);
	}

	/**
	 * Permet de r�cup�rer le fils droit de l'arbre.
	 * 
	 * @return Un objet de type arbre qui est le fils droit de l'arbre.
	 */
	public Arbre getSousArbreDroit() {
		return (fd);
	}

	// Set

	/**
	 * Permet de modifier le comportement au noeud de l'arbre.
	 * 
	 * @see Comportements
	 * @param comp Le nouveau comportement qui sera au noeud de l'arbre.
	 */
	public void setNoeud(Comportements comp) {
		this.valeur = comp;
	}

	/**
	 * Permert de modifier le fils gauche de l'arbre.
	 * 
	 * @param ng Le nouveau fils gauche de l'arbre
	 */
	public void setSousArbreGauche(Arbre ng) {
		this.fg = ng;
	}

	/**
	 * Permert de modifier le fils gauche de l'arbre.
	 * 
	 * @param nd Le nouveau fils gauche de l'arbre
	 */
	public void setSousArbreDroite(Arbre nd) {
		this.fd = nd;
	}

	// Tests

	/**
	 * Permet de savoir si l'arbre sur lequel cette fonction est appel�e est une
	 * feuille.
	 * 
	 * @return Un boole�n qui vaut true si l'arbre est une feuille, false sinon.
	 */
	public boolean isFeuille() {
		return (this.fd == null && this.fg == null);
	}

	/**
	 * Permet de savoir si les noeuds des deux fils de l'arbre on le m�me
	 * comportement en valeur.
	 * 
	 * @return Un boole�n qui vaut true si ce sont les m�mes comportements, false
	 *         sinon.
	 */
	public boolean sameKids() {
		return this.fd.valeur.equals(this.fg.valeur);
	}

	/**
	 * Permet de savoir si le comportement du noeud de l'arbre et le comportement de
	 * son fils gauche sont les m�mes.
	 * 
	 * @return Un boole�n qui vaut true si ce sont les m�mes comportements, false
	 *         sinon.
	 */
	public boolean sameParentLeft() {
		return this.valeur.equals(this.fg.valeur);
	}

	/**
	 * Permet de savoir si le comportement du noeud de l'arbre et le comportement de
	 * son fils droit sont les m�mes.
	 * 
	 * @return Un boole�n qui vaut true si ce sont les m�mes comportements, false
	 *         sinon.
	 */
	public boolean sameParentRight() {
		return this.valeur.equals(this.fd.valeur);
	}

	// Corriger l'arbre

	/**
	 * Fonction (r�cursive) tr�s importante permettant de corriger les arbres cr��s
	 * al�atoirement. Ainsi on �vite quelques configurations pathog�nes et on
	 * simplifie les comportements. Si les deux fils sont les m�mes et le noeud est
	 * une question, on remplace le noeud par le comportement des fils. Si le noeud
	 * et un des deux fils sont la m�me question, on remplace le fils en question
	 * par la r�ponse � la question que l'on connait d�j�, et dans le cas o� il n'a
	 * pas de fils on met le comportement NOTHING.
	 * 
	 * @see Comportements
	 * @see Comportements#isQuestion()
	 * @see Arbre#isFeuille()
	 * @see Arbre#sameParentLeft()
	 * @see Arbre#sameKids()
	 * @see Arbre#sameParentRight()
	 */
	public void correctComport() {
		Comportements comp = this.getNoeud();
		if (comp.isQuestion() && !this.isFeuille()) {

			if (this.sameKids() && this.fd.isFeuille() && this.fg.isFeuille()) {

				this.valeur = this.fg.valeur;
				this.fd = null;
				this.fg = null;
			} else {
				if (this.sameParentLeft()) {

					if (this.fg.isFeuille()) {
						this.fg.valeur = Comportements.NOTHING;
					} else {
						this.fg = this.fg.fg;
						this.fg.fg = null;
						this.fg.fd = null;
					}

				}
				if (this.sameParentRight()) {
					if (this.fd.isFeuille()) {
						this.fd.valeur = Comportements.NOTHING;
					} else {
						this.fd.valeur = this.fd.fd.valeur;
						this.fd.fg = null;
						this.fd.fd = null;
					}
				}
				if (this.sameKids()) {

					this.valeur = this.fg.valeur;
					this.fd = null;
					this.fg = null;
				}

				if (this.fd != null) {
					this.fd.correctComport();
				}

				if (this.fg != null) {
					this.fg.correctComport();
				}
			}

		}
	}

	// Affichage de l'arbre

	/**
	 * Fonction qui va appeler la fonction r�cursive toString(String) afin
	 * d'afficher un arbre. Son but est d'offrir un affichage compr�hensible �
	 * l'arbre. L'affichage est pr�fixe et de cette forme : - Racine -fils gauche
	 * -fils gauche -fils droit -fils droit -fils gauche -fils droit
	 * 
	 * @return Une chaine de caract�res comportant l'arbre et pouvant �tre affich�e.
	 * @see Arbre#toString(String)
	 */
	public String toString() {
		return this.toString("");
	}

	/**
	 * Fonction (r�cursive) appel�e par toString() qui met chaque noeud dans une
	 * chaine de caract�re afin d'afficher l'arbre comme vu sur la m�thode cit�e
	 * pr�c�demment.
	 * 
	 * @param indent Une chaine de caract�res constitu�e d'espaces, utilis�e pour
	 *               l'affichage de l'arbre.
	 * @return Une chaine de caract�res permettant d'afficher l'arbre.
	 * @see Arbre#toString()
	 */
	public String toString(String indent) {
		if (this.fg != null) {
			if (this.fd != null) {
				return "-" + this.valeur + "\n" + indent + "  " + this.fg.toString(indent + "  ") + "\n" + indent + "  "
						+ this.fd.toString(indent + "  ");
			}
			else {
				return "-" + this.valeur + "\n" + indent + "  " + this.fg.toString(indent + "  ");
			}
		}
		else if (this.fd != null) {
			return "-" + this.valeur + "\n" + indent + "  " + this.fd.toString(indent + "  ");
		}
		else return "-" + this.valeur;
	}

	// Comparer

	/**
	 * Permet de comparer deux arbres, cette fonction est r�cursive.
	 * 
	 * @param abr L'arbre compar� � celui sur lequel on appelle cette fonction.
	 * @return Un bool�en qui vaut true si les arbres sont les m�mes, false sinon.
	 * @see Arbre#isFeuille()
	 * @see Arbre#sameParentLeft()
	 * @see Arbre#sameKids()
	 * @see Arbre#sameParentRight()
	 */
	public boolean compareTo(Arbre abr) {

		if ((this.fd == null && abr.fd != null) || (this.fd != null && abr.fd == null)
				|| (this.fg == null && abr.fg != null) || (this.fg != null && abr.fg == null)
				|| (this.isFeuille() && !abr.isFeuille()) || (!this.isFeuille() && abr.isFeuille())) {
			return false;
		}

		// Font la m�me chose qu'au dessus
		/*
		 * if(this.fd == null && abr.fd != null) return false; if(this.fd != null &&
		 * abr.fd == null) return false; if(this.fg == null && abr.fg != null) return
		 * false; if(this.fg != null && abr.fg == null) return false;
		 * if(this.isFeuille() && !abr.isFeuille()) return false; if(!this.isFeuille()
		 * && abr.isFeuille()) return false;
		 */

		if (this.isFeuille() && abr.isFeuille()) {
			return this.valeur.equals(abr.valeur);
		}

		if (this.fg == null && abr.fg == null) {
			return (this.valeur.equals(abr.valeur) && this.fd.compareTo(abr.fd));
		} else if (this.fd == null && abr.fd == null) {
			return (this.valeur.equals(abr.valeur) && this.fg.compareTo(abr.fg));
		} else {
			return (this.valeur.equals(abr.valeur) && this.fd.compareTo(abr.fd) && this.fg.compareTo(abr.fg));
		}

	}

}
