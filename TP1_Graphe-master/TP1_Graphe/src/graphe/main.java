package graphe;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class main {
	
	static Graphe EcritureGraphe(String chemin) {
		BufferedReader lecteur;
        String filepath = chemin;

        try {
            lecteur = new BufferedReader(new InputStreamReader( new FileInputStream(filepath), "UTF8"));
            String ligne;
            char c;
            int nb_sommet=0;
            boolean tableau_genere=false;
            String [] mots;
            String all_lines = "";
            String[] lignes=null;
            while(!tableau_genere){ //
            	ligne = lecteur.readLine();
            	mots=ligne.split(" ");
            	c=ligne.charAt(0);
            	if(c=='p') {
            		nb_sommet=Integer.parseInt(mots[2]);
            		tableau_genere=true;
            	}     
            }

            Map<Integer,Sommet> map=new HashMap();
            ArrayList<Sommet> ls=new ArrayList<Sommet>();
            Map<Sommet,ArrayList<Sommet>> map_graphe=new HashMap();
            Sommet s1,s2;
            for(int i=1;i<=nb_sommet;i++) { // Boucle qui lit tous les sommets et qui les mets dans une map avec comme clé luer numéro
            	s1=new Sommet(i);
            	map.put(i, s1);
            	map_graphe.put(s1,new ArrayList<Sommet>());
            	ls.add(s1);
            }
            
            int a,b;
            ArrayList<Sommet> l_s1=new ArrayList<Sommet>();
            ArrayList<Sommet> l_s2=new ArrayList<Sommet>();
            while((ligne=lecteur.readLine()) != null){ //Boucle qui lit et écrit les arcs en récupérant les sommets par leur numéro grâce à la map
            		c=ligne.charAt(0);
            		mots=ligne.split(" ");
                	if(c=='e') {
                		a=Integer.parseInt(mots[1]);
                		b=Integer.parseInt(mots[2]);
                		s1=map.get(a);
                		s2=map.get(b);
                		l_s1=(map_graphe.get(s1));
                		l_s1.add(s2);
                		l_s2=(map_graphe.get(s2));
                		l_s2.add(s1);
                		map_graphe.put(s1,l_s1);
                		map_graphe.put(s2,l_s2);
            	}
            }
            
			lecteur.close();
			Graphe g=new Graphe(map_graphe,ls);
			return g;
			
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
		
	}

	public static void main(String[] args) {
		
		String fichier="C:\\Users\\loko6\\IdeaProjects\\TP1_Graphe\\TP1_Graphe\\src\\GrapheAColorer";

		File file = new File(fichier);
		File[] files = file.listFiles();
		long start;
		long end;

		PrintWriter writer = null;
		try {
			writer = new PrintWriter("C:\\Users\\loko6\\IdeaProjects\\TP1_Graphe\\TP1_Graphe\\src\\" + "resultats" + ".csv", "UTF-8");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		for (int i = 0; i < files.length; i++) { //Parcour tout les fichiers
			try {
				System.out.println("  Fichier: " + files[i].getName());
				String s = "C:\\Users\\loko6\\IdeaProjects\\TP1_Graphe\\TP1_Graphe\\src\\GrapheAColorer\\" + files[i].getName();
				Graphe g1 = EcritureGraphe(s);
				Graphe g2 = EcritureGraphe(s);
				Graphe g3 = EcritureGraphe(s);
				Graphe g4 = EcritureGraphe(s);
				Graphe g5 = EcritureGraphe(s);
				Graphe g6 = EcritureGraphe(s);
				Graphe g7 = EcritureGraphe(s);
				Graphe g8 = EcritureGraphe(s);
				Graphe g9 = EcritureGraphe(s);

				//Gready coloring
				start = System.currentTimeMillis();
				g1.GreedyColoring(1);
				end = System.currentTimeMillis();
				long t1 = end - start;

				start = System.currentTimeMillis();
				g2.GreedyColoring(2);
				end = System.currentTimeMillis();
				long t2 = end - start;

				start = System.currentTimeMillis();
				g3.GreedyColoring(3);
				end = System.currentTimeMillis();
				long t3 = end - start;

				//DSATUR
				start = System.currentTimeMillis();
				g4.DSATUR(1);
				end = System.currentTimeMillis();
				long t4 = end - start;

				start = System.currentTimeMillis();
				g5.DSATUR(2);
				end = System.currentTimeMillis();
				long t5 = end - start;

				start = System.currentTimeMillis();
				g6.DSATUR(3);
				end = System.currentTimeMillis();
				long t6 = end - start;

				//WelshPowell
				start = System.currentTimeMillis();
				g7.WelshPowell(1);
				end = System.currentTimeMillis();
				long t7 = end - start;

				start = System.currentTimeMillis();
				g8.WelshPowell(2);
				end = System.currentTimeMillis();
				long t8 = end - start;

				start = System.currentTimeMillis();
				g9.WelshPowell(3);
				end = System.currentTimeMillis();
				long t9 = end - start;

				int n1 = g1.getNbCouleur();
				int n2 = g2.getNbCouleur();
				int n3 = g3.getNbCouleur();
				int n4 = g4.getNbCouleur();
				int n5 = g5.getNbCouleur();
				int n6 = g6.getNbCouleur();
				int n7 = g7.getNbCouleur();
				int n8 = g8.getNbCouleur();
				int n9 = g9.getNbCouleur();

				writer.println(files[i].getName() + ";" + n1 + ";" + n2 + ";" + n3 + ";" + n4 + ";" + n5 + ";" + n6 + ";" + n7 + ";" + n8 + ";" + n9);
				writer.println(";" + t1 + ";" + t2 + ";" + t3 + ";" + t4 + ";" + t5 + ";" + t6 + ";" + t7 + ";" + t8 + ";" + t9);
			}catch (NullPointerException e){
				System.out.println("Erreur sur le fichier : "+files[i].getName()+"\n"+e);
			}catch (Exception e){
				System.out.println("Erreur sur le fichier : "+files[i].getName()+"\n"+e);
			}
		}
		writer.close();
	}



}
