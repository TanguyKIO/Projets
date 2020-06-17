/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VueControleur;
    
import Modele.Fantome;
import Modele.Grille;
import Modele.ModeleEntite;
import Modele.ModeleEntite.Direction;
import Modele.Pacman;
import Modele.SimplePacMan;

import java.awt.Point;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;


import javafx.scene.image.Image;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
 *
 * @author p1923494
 */
public class VueControleur extends Application {
	
	private HashMap<ModeleEntite, Point> positions;
    public final int SIZE_X = 21;
    public final int SIZE_Y = 19;
    private Grille grille;
    private Pacman p;
    private Fantome f1, f2, f3, f4;
    private Thread t_p,t_f1,t_f2,t_f3,t_f4;  
    private int x_pacman,y_pacman,x_f1,x_f2,x_f3,x_f4,y_f1,y_f2,y_f3,y_f4;
    private Direction d;
    private int[][] gr;
    private boolean lance=false;
    
    @Override
    public void start(Stage primaryStage) { 
    	//VUE
    	Stage newWindow = new Stage();
        newWindow.setResizable(false);
    	Image fond= new Image("fondpacaman.png");
        Button btn = new Button();
        btn.setText("Jouer");
        
        Button btn2 = new Button();
        btn2.setText("Quitter");
        
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
            	newWindow.close();
            	lance=true;
            	grille = new Grille();
                gr = grille.getmap(); 
                // initialisation du modèle
                p =grille.getP();
                f1=grille.getF1();
                f2=grille.getF2();
                f3=grille.getF3();
                f4=grille.getF4();
                
                t_p=new Thread(p);
        		t_f1=new Thread(f1);
        		t_f2=new Thread(f2);
        		t_f3=new Thread(f3);
        		t_f4=new Thread(f4);
                
                // création de la grille
                GridPane grid = new GridPane();  
                // préparation des images
                Image imPM_D = new Image("PacmanDroite.png"); 
                Image imPM_G = new Image("PacmanGauche.png");
                Image imPM_H = new Image("PacmanHaut.png");
                Image imPM_B = new Image("PacmanBas.png");
                
                Image imVide = new Image("Vide.png");
                Image imPacGome = new Image("bean.png");
                Image imSpPacGome = new Image("pouvoir.png");
                Image imMur = new Image("mur.png");
                Image imPouvoir = new Image("pouvoir.png");
                Image imFantome1 = new Image("fantome_cyan.png");
                Image imFantome2 = new Image("fantome_orange.png");
                Image imFantome3 = new Image("fantome_rose.png");
                Image imFantome4 = new Image("fantome_rouge.png");
                Image imFantomePeur = new Image("FantomePeur.png");
                
                ImageView imvVie1 = new ImageView();
                ImageView imvVie2 = new ImageView();
                ImageView imvVie3 = new ImageView();
                
                InputStream police = null;
                InputStream police_XL = null;
                InputStream police_L = null;
                try {
					police=new FileInputStream("C://ka1.ttf"); //Chemin à changer par rapport à où vous avez mis la police fourni dans le src
					police_XL=new FileInputStream("C://ka1.ttf"); 
					police_L=new FileInputStream("C://ka1.ttf"); 
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
                
                Font f= Font.loadFont(police, 24);
                Font f_XL= Font.loadFont(police_XL,96);
                Font f_L= Font.loadFont(police_L,40);
                
                Text score = new Text();
                Text scoreT = new Text("Score : ");
                
                Text debut= new Text("Appuyez pour commencer");
                Text vie = new Text("Vies :");
                Text win=new Text("Victoire");
                Text loose= new Text("Defaite");
                Text pause= new Text("Pause");
                
                score.setFill(Color.WHITE);
                scoreT.setFill(Color.WHITE);
                vie.setFill(Color.WHITE);
                debut.setFill(Color.WHITE);
                win.setFill(Color.LIMEGREEN);
                loose.setFill(Color.RED);
                pause.setFill(Color.WHITE);
                
                score.setFont(f);
                scoreT.setFont(f);
                vie.setFont(f);
                debut.setFont(f);
                win.setFont(f_XL);
                loose.setFont(f_XL);
                pause.setFont(f_L);
                
                win.setVisible(false);
                loose.setVisible(false);
                pause.setVisible(false);
                
                StackPane root = new StackPane();
                BackgroundFill bf=new BackgroundFill(Color.BLACK,null,null);
                Background b=new Background(bf);
                root.setBackground(b);
                root.getChildren().add(grid);
              
                //Position par rapport au centre de l'image
                score.setTranslateX(-80);
                score.setTranslateY(312);
                root.getChildren().add(score);

                scoreT.setTranslateX(-200);
                scoreT.setTranslateY(310);
                root.getChildren().add(scoreT);
                
                vie.setTranslateX(80);
                vie.setTranslateY(310);
                root.getChildren().add(vie);
                
                
                win.setTranslateY(-250);
                loose.setTranslateY(-250);
                debut.setTranslateY(-50);
                
                root.getChildren().add(debut);
                root.getChildren().add(win);
                root.getChildren().add(loose);
                
                pause.setTranslateY(-50);
                root.getChildren().add(pause);
                
                //Gestion de la vie
                imvVie1.setTranslateX(210);
                imvVie1.setTranslateY(315);
                imvVie2.setTranslateX(178);
                imvVie2.setTranslateY(315);
                imvVie3.setTranslateX(146);
                imvVie3.setTranslateY(315);
                
                root.getChildren().add(imvVie1);
                root.getChildren().add(imvVie2);
                root.getChildren().add(imvVie3);
                
                btn2.setTranslateY(365);
                root.getChildren().add(btn2);
                
                Scene scene = new Scene(root, 608,784);
                scene.getStylesheets().add("button.css");
                primaryStage.setTitle("Pacman");
                primaryStage.setScene(scene);
                primaryStage.setResizable(false);
                primaryStage.show();
                
                // tableau permettant de récupérer les cases graphiques lors du rafraichissement
                ImageView[][] tab = new ImageView[SIZE_X][SIZE_Y]; 

                // initialisation de la grille (sans image)
                for (int i = 0; i < SIZE_X; i++) { 
                    for (int j = 0; j < SIZE_Y; j++) {
                        ImageView img = new ImageView();
                        tab[i][j] = img;
                        grid.add(img, j, i);
                    }        
                }
                
                for (int i = 0; i < SIZE_X; i++) { 
                    for (int j = 0; j < SIZE_Y; j++) {
                        if (gr[i][j] == 0) { 
                            tab[i][j].setImage(imMur); 
                        }
                        else if (gr[i][j] == 1) { 
                            tab[i][j].setImage(imVide); 
                        }
                        else if(gr[i][j] == 2){
                            tab[i][j].setImage(imPacGome);                            
                        }
                        else if(gr[i][j] == 3){
                            tab[i][j].setImage(imSpPacGome);                            
                        }
                        else {
                            tab[i][j].setImage(imVide);
                        } 
                    }
            	}
                score.setText(p.getScore());
                tab[(int) p.getSpawn().getX()][(int) p.getSpawn().getY()].setImage(imPM_D);
                tab[(int) f1.getSpawn().getX()][(int) f1.getSpawn().getY()].setImage(imFantome1);
                tab[(int) f2.getSpawn().getX()][(int) f2.getSpawn().getY()].setImage(imFantome2);
                tab[(int) f3.getSpawn().getX()][(int) f3.getSpawn().getY()].setImage(imFantome3);
                tab[(int) f4.getSpawn().getX()][(int) f4.getSpawn().getY()].setImage(imFantome4);
                
                imvVie3.setImage(imPM_D);
                imvVie2.setImage(imPM_D);
                imvVie1.setImage(imPM_D);
                
                Observer o =  new Observer() {// l'observer observe l'obervable (update est exécuté dès notifyObservers() est appelé côté modèle )
                    @Override
                    
                    public void update(Observable o, Object arg) {
                    	gr = grille.getmap(); 
                    	for (int i = 0; i < SIZE_X; i++) { 
                            for (int j = 0; j < SIZE_Y; j++) {
                                if (gr[i][j] == 0) { 
                                    tab[i][j].setImage(imMur); 
                                }
                                else if (gr[i][j] == 1) { 
                                    tab[i][j].setImage(imVide); 
                                }
                                else if(gr[i][j] == 2){
                                    tab[i][j].setImage(imPacGome);                            
                                }
                                else if(gr[i][j] == 3){
                                    tab[i][j].setImage(imSpPacGome);                            
                                }
                                else {
                                    tab[i][j].setImage(imVide);
                                } 
                            }
                    	}
                    	positions=grille.getMap_position();
                    	
                    	if(!p.estFini()) {
        	            	x_pacman = (int) positions.get(p).getX();
        	            	y_pacman=(int) positions.get(p).getY();
        	            	d=p.getDirection();
        	            	switch(d) {
        	            	case HAUT :
        	            		tab[x_pacman][y_pacman].setImage(imPM_H);
        	        			break;
        	        		case BAS :
        	        			tab[x_pacman][y_pacman].setImage(imPM_B);
        	        			break;
        	        		case DROITE :
        	        			tab[x_pacman][y_pacman].setImage(imPM_D);
        	        			break;
        	        		case GAUCHE :
        	        			tab[x_pacman][y_pacman].setImage(imPM_G);
        	        			break;
        	        		default : 
        	        			tab[x_pacman][y_pacman].setImage(imPM_D);
        	        			break;
        	            	}
                    	}
                    	
                    	x_f1=(int) positions.get(f1).getX();
                    	x_f2=(int) positions.get(f2).getX();
                    	x_f3=(int) positions.get(f3).getX();
                    	x_f4=(int) positions.get(f4).getX();
                    	y_f1=(int) positions.get(f1).getY();
                    	y_f2=(int) positions.get(f2).getY();
                    	y_f3=(int) positions.get(f3).getY();
                    	y_f4=(int) positions.get(f4).getY();
                    	
                    	if(p.getEtat()) {
                    		tab[x_f1][y_f1].setImage(imFantomePeur);
        	            	tab[x_f2][y_f2].setImage(imFantomePeur);
        	            	tab[x_f3][y_f3].setImage(imFantomePeur);
        	            	tab[x_f4][y_f4].setImage(imFantomePeur);
                    	} else {
                    		tab[x_f1][y_f1].setImage(imFantome1);
        	            	tab[x_f2][y_f2].setImage(imFantome2);
        	            	tab[x_f3][y_f3].setImage(imFantome3);
        	            	tab[x_f4][y_f4].setImage(imFantome4);
                    	}
                    	
                    	score.setText(p.getScore());
                    	
                    	switch(p.getVies()) {
                    		case 0:
                    			loose.setVisible(true);
                            	debut.setVisible(true);
                            	imvVie3.setImage(imVide);
                            	imvVie2.setImage(imVide);
        	                    imvVie1.setVisible(false);
        	                    
        	                case 1:
        	                    imvVie3.setImage(imVide);
        	                    imvVie2.setImage(imVide);
        	                    imvVie1.setImage(imPM_D);
        	                    break;
        	                case 2:
        	                	imvVie1.setVisible(true);
        	                    imvVie3.setImage(imVide);
        	                    imvVie2.setImage(imPM_D);
        	                    imvVie1.setImage(imPM_D);
        	                    break;
        	                case 3:
        	                	imvVie1.setVisible(true);
        	                    imvVie3.setImage(imPM_D);
        	                    imvVie2.setImage(imPM_D);
        	                    imvVie1.setImage(imPM_D);
        	                    break;
        	                default:
        	                    break;
                    	}
                    	if(p.aGagne()) {
    	            		win.setVisible(true);
    	            		debut.setVisible(true);
    	            	}
                    } 
                };
                
        //CONTROLEUR
                p.addObserver(o);
            	root.setOnKeyPressed(new EventHandler<javafx.scene.input.KeyEvent>() { // on écoute le clavier
                    
                    @Override
                    public void handle(javafx.scene.input.KeyEvent event) {
                    	KeyCode key=event.getCode();
                    	debut.setVisible(false);
                    	win.setVisible(false);
                    	loose.setVisible(false);
	                    
                    	if(!p.isStarted() && !key.equals(key.ESCAPE)) {
                    		grille.init();
                    		t_p.start();
                    		t_f1.start();
                    		t_f2.start();
                    		t_f3.start();
                    		t_f4.start();	
                    	}
                    	else if(p.estFini()) {
                    		grille.init();
                    		p.reveil();
                    		f1.reveil();
                    		f2.reveil();
                    		f3.reveil();
                    		f4.reveil();
                    	}
                    	if(!p.estFini()) {
	                    	pause.setVisible(false);
	                    	if(p.getPause() && p.estVivant()) p.reveil();	                    	
	                    	if(f1.getPause() && f1.estVivant()) f1.reveil();              	
	                    	if(f2.getPause() && f2.estVivant()) f2.reveil();	                    	
	                    	if(f3.getPause() && f3.estVivant()) f3.reveil();	                    	
	                    	if(f4.getPause() && f4.estVivant()) f4.reveil();
                    	}
                    	switch(key) {
                    	case ESCAPE:
                    		pause.setVisible(true);
                    		p.setPause(true);
                    		f1.setPause(true);
                    		f2.setPause(true);
                    		f3.setPause(true);
                    		f4.setPause(true);
                    		break;
                		case UP :                			
                			p.setDirection(Direction.HAUT);
                			break;
                		case DOWN :                			
                			p.setDirection(Direction.BAS);
                			break;
                		case LEFT :	
                			p.setDirection(Direction.GAUCHE);
                			break;
                		case RIGHT :
                			p.setDirection(Direction.DROITE);
                			break;
                		default : break;
                	}
                    }
                });
                
                grid.requestFocus();  
            }
        });	
        
        
        btn2.setOnAction(new EventHandler<ActionEvent>() {
        	@Override
        	public void handle(ActionEvent event) {
        		System.exit(0);
        	}
        });
        
        StackPane root_menu = new StackPane();
        btn.setTranslateY(10);
        btn2.setTranslateY(110);
        root_menu.getChildren().add(btn);
        root_menu.getChildren().add(btn2);
        
        Scene menu = new Scene(root_menu, 500, 500, Color.BLACK);
        menu.getStylesheets().add("button.css");
        BackgroundImage bi=new BackgroundImage(fond,BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        root_menu.setBackground(new Background(bi));
        newWindow.setTitle("PacMan");
        newWindow.setScene(menu);
        newWindow.show();
        
        
    }  

    public static void main(String[] args) {
        Application.launch(args);
    }  
}
