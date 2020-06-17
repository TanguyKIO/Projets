import java.io.*;

public class Monde {
	/**
	 * La taille du monde, le nombre de cases Nourriutre, Fourmilière, et le nombre d'actions autorisées pour la fourmi.
	 */
	private int taille, nbNourriture, nbFourmilliere;
	
	/**
	 * Le monde est un tableau 2D de Cases.
	 * @see Case
	 */
	private Case tab[][];

	
	//Constructeurs
	
	/**
	 * Constructeur avec tous les paramètres possibles
	 * @param taille Taille du monde (carré)
	 * @param nbNourriture Nombre de cases Nourriture
	 * @param nbFourmilliere Nombre de cases Fourmilière
	 * @see Monde#nbFourmilliere
	 * @see Monde#nbNourriture
	 * @see Monde#taille
	 * @see Monde#tab
	 */
	public Monde(int taille, int nbNourriture, int nbFourmilliere) {
		this.taille = taille;
		tab = new Case[taille][taille];
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				tab[i][j] = new Case(i, j, 'R');
			}
		}
		this.nbFourmilliere = nbFourmilliere;
		this.nbNourriture = nbNourriture;
	}

	/**
	 * Constructeur par copie afin de garder le monde sur lequel une fourmi joue
	 * 
	 * @param m Le monde copié
	 * @see Monde#nbFourmilliere
	 * @see Monde#nbNourriture
	 * @see Monde#taille
	 * @see Monde#tab
	 */
	public Monde(Monde m) {
		this.taille = m.taille;
		this.nbFourmilliere = m.nbFourmilliere;
		this.nbNourriture = m.nbNourriture;
		this.tab = new Case[taille][taille];
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				this.tab[i][j] = new Case(i, j, m.tab[i][j].getValue());
			}
		}
	}

	/**
	 * Construit un monde vide avec des valeurs nulles pour les paramètres, d'une taille précisée
	 * @param taille La taille du monde
	 * @see Monde#nbFourmilliere
	 * @see Monde#nbNourriture
	 * @see Monde#taille
	 * @see Monde#tab
	 */
	public Monde(int taille) { // monde vide
		tab = new Case[taille][taille];
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				tab[i][j] = new Case(i, j, 'R');
			}
		}
		this.nbFourmilliere = 0;
		this.nbNourriture = 0;
	}

	/**
	 * Génération d'un Monde à partir d'une sauvegarde dans un fichier
	 * @param filepath chermin du fichier
	 */
	public Monde(String filepath) {
		BufferedReader lecteur = null;
		try {
			lecteur = new BufferedReader(new FileReader(filepath));
			String line = lecteur.readLine();
			taille = line.length() / 8;
			Monde m = new Monde(taille);
			for (int y = 2; y <= taille * 2 + 1; y++) { //y correspond au numéro de la ligne en lecture
				line = lecteur.readLine();
				if (y % 2 == 0) {//On ne récupère pas les lignes composé de tirets
					int row = y / 2 - 1;
					line = line.substring(4, line.length() - 4);
					String[] line_spl = line.split("\\s{3}\\|\\s{3}"); // Split (" | ")
					for (int col = 0; col < line_spl.length; col++) {
						if (line_spl[col].compareTo("F") == 0) {
							m.tab[row][col] = new Fourmiliere(0, 'F');
							nbFourmilliere++;
						} else if (line_spl[col].compareTo("F") != 0 && line_spl[col].compareTo(" ") != 0) {
							try {
								int nbNour = Integer.parseInt(line_spl[col]);
								m.tab[row][col] = new Nourriture(nbNour, 'N');
								nbNourriture++;
							} catch (java.lang.NumberFormatException e) {
								System.out.println(
										"Objet non reconnue ! x =" + row + "y =  " + y + ": !" + line_spl[col] + "! ");
							}
						}
					}
				}
			}
			this.tab = m.tab;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	//Gestion du monde
	
	/**
	 * Génération du monde :
	 * On place des fourmilières puis de la nourriture à des emplacements aléatoires
	 * @see Monde#nbFourmilliere
	 * @see Monde#nbNourriture
	 * @see Monde#taille
	 * @see Monde#tab
	 * @see Case#getValue()
	 * @see Nourriture#Nourriture(int, char)
	 * @see Fourmiliere#Fourmiliere(int, char)
	 */
	public void generer() {
		int nbCountNour = nbNourriture;
		int nbCountFour = nbFourmilliere;
		while (!(nbCountNour == 0 && nbCountFour == 0)) {
			int x = (int) (Math.random() * taille);
			int y = (int) (Math.random() * taille);
			int z = (int) (Math.random()*9);

			if (tab[x][y].getValue() == 'R') {
				if (nbCountNour == 0) {
					tab[x][y] = new Fourmiliere(0, 'F');
					nbCountFour--;
				} else {
					tab[x][y] = new Nourriture(z, 'N');
					nbCountNour--;
				}
			}
		}
	}

	/**
	 * Initialisation du monde, toutes les cases ont une valeur de R, elles sont donc vides
	 * @see Monde#taille
	 * @see Monde#tab
	 * @see Case#Case(int, int, char)
	 */
	public void initialiser() {
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				tab[i][j] = new Case(i, j, 'R');
			}
		}
	}

	//Affichage
	
	/**
	 * Affichage du monde
	 * Les cases ayant R pour valeur apparaissent vides, les autres voient leur valeur affichée	
	 * @see Monde#taille
	 * @see Monde#tab
	 * @see Case#afficherCase()
	 */
	public void afficher() {
		String ligne_sep = "";
		for (int i = 0; i < 8 * taille + 1; i++) {
			ligne_sep += "-";
		}
		System.out.println(ligne_sep);
		for (int row = 0; row < taille; row++) {
			System.out.print("|   ");
			for (int col = 0; col < taille; col++) {
				if (tab[row][col].getValue() != 'R')
					tab[row][col].afficherCase();
				else
					System.out.print(" ");
				if (col < taille - 1)
					System.out.print("   |   ");
			}
			System.out.println("   |");
			System.out.println(ligne_sep);
		}
	}

	/**
	 * Affichage du monde avec une fourmi dedans, utilisée pour le mode texte
	 * Les cases ayant R pour valeur apparaissent vides, les autres voient leur valeur affichée	et la fourmi est affichée avec un A
	 * @see Monde#taille
	 * @see Monde#tab
	 * @see Case#afficherCase()
	 * 
	 * @param f La fourmi à afficher dans le monde
	 */
	public void afficher(Fourmi f) {
		String ligne_sep = "";
		for (int i = 0; i < 8 * taille + 1; i++) {
			ligne_sep += "-";
		}
		System.out.println(ligne_sep);
		for (int row = 0; row < taille; row++) {
			System.out.print("|  ");
			for (int col = 0; col < taille; col++) {
				if (tab[row][col].getValue() != 'R') {
					if (f.getPositionX() == row && f.getPositionY() == col) {
						System.out.print("A + ");
					}
					tab[row][col].afficherCase();
				} else if (f.getPositionX() == row && f.getPositionY() == col)
					System.out.print("A");
				System.out.print(" ");
				if (col < taille - 1)
					System.out.print("   |   ");
			}
			System.out.println("   |");
			System.out.println(ligne_sep);
		}
	}

	/**
	 * La fonction download télécharge le monde dans un fichier texte
	 * @param path Un dossier permettant la sauvegarde
	 * @param filename Le nom du fichier (sans extension)
	 * @see Monde
	 */
	public void download(String path, String filename) {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter(path + "\\" + filename + ".txt", "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String ligne_sep = "";
		for (int i = 0; i < 8 * taille + 1; i++) {
			ligne_sep += "-";
		}
		writer.println(ligne_sep);
		for (int row = 0; row < taille; row++) {
			writer.print("|   ");
			for (int col = 0; col < taille; col++) {
				if (tab[row][col].getValue() != 'R') {
					if (tab[row][col].getValue() == 'F')
						writer.print('F');
					else if (tab[row][col].getValue() == 'N') {
						Nourriture nour_case = (Nourriture) tab[row][col]; // downcast pour récupérer le nombre de nourriture sur la case;
						writer.print(nour_case.getQuantite());
					}
				} else
					writer.print(" ");
				if (col < taille - 1)
					writer.print("   |   ");
			}
			writer.println("   |");
			writer.println(ligne_sep);
		}
		writer.close();
	}

	
	//Get
	
	/**
	 * Récupère le nombre de cases de Nourriture dans le monde.
	 * @return Le nombre de cases de Nourriture dans le monde
	 * @see Monde#nbNourriture
	 */
	public int getNbNourriture() {
		return nbNourriture;
	}

	/**
	 * Récupère le nombre de cases de Fourmilières dans le monde.
	 * @see Monde#nbFourmilliere
	 * @return Le nombre de cases de Fourmilières dans le monde
	 */
	public int getNbFourmiliere() {
		return nbFourmilliere;
	}

	/**
	 * Récupère la taille du monde (carré)
	 * @see Monde#taille
	 * @return La taille du monde
	 */
	public int getTaille() {
		return taille;
	}

	/**
	 * Récupère la case aux coordonnées en paramètre
	 * 
	 * @param i Ligne de la case
	 * @param j Colonne de la case
	 * @return L'objet Case en (i,j)
	 * @see Case
	 */
	public Case getTable(int i, int j) {
		return this.tab[i][j];
	}
	
	//Set
	//Tests
	
	/**
	 * Teste si la case en (x,y) est de la nourriture
	 * @param x La ligne de la case
	 * @param y La colonne de la case
	 * @return Un booléen qui vaut true si c'est le cas, false sinon
	 * @see Case#getValue()
	 */
	public boolean estNourriture(int x, int y) {
			if (tab[x][y].getValue() == 'N' || tab[x][y].getValue() == 'A' + '+' + 'N') {
				return true;
			}
		return false;

	}


	/**
	 * Teste si la case en (x,y) est une fourmilière
	 * @param x La ligne de la case
	 * @param y La colonne de la case
	 * @return Un booléen qui vaut true si c'est le cas, false sinon
	 * @see Case#getValue()
	 */
	public boolean estFourmiliere(int x, int y) {
			if (tab[x][y].getValue() == 'F' || tab[x][y].getValue() == 'A' + '+' + 'F') {
				return true;
			}
		
		return false;
	}

	//Actions sur les fourmilières
	
	/**
	 * Récupère toutes les fourmilières du monde
	 * @param f La fourmi dans le monde, utilisée pour récupérer sa distance aux fourmilières
	 * @return Un tableau avec les coordonnées de chaque fourmilière et leur distance à la fourmi
	 * @see Monde#nbFourmilliere
	 * @see Fourmi#getPositionX()
	 * @see Fourmi#getPositionY()
	 */
	public int[][] recupFourmiliere(Fourmi f) {
		int tableau[][] = new int[nbFourmilliere][3];
		int ligne = 0;
		for (int i = 0; i < taille; i++) {
			for (int j = 0; j < taille; j++) {
				if (estFourmiliere(i, j)) {
					tableau[ligne][0] = i;
					tableau[ligne][1] = j;
					tableau[ligne][2] = (Math.abs(i - f.getPositionX()) + Math.abs(j - f.getPositionY()));
					ligne++;
				}
			}
		}
		return tableau;
	}

	/**
	 * Récupère la fourmilière la plus proche
	 * 
	 * @param f La fourmi dans le monde
	 * @param c La case qui est de type Fourmilière qui sera la plus proche (donnée résultat)
	 * @see Monde#recupFourmiliere(Fourmi)
	 * @see Case#setCol(int)
	 * @see Case#setRow(int)
	 * @see Monde#nbFourmilliere
	 */
	public void recupFourmiliereLaPlusProche(Fourmi f, Case c) {
		int temp = 0;
		int tabFourm[][] = recupFourmiliere(f);
		for (int i = 1; i < nbFourmilliere; i++) {
			if (tabFourm[temp][2] > tabFourm[i][2]) {
				temp = i;
			}
		}
		int x = tabFourm[temp][0];
		int y = tabFourm[temp][1];
		c.setCol(y);
		c.setRow(x);
		;

	}

}
