import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
 
public class Fenetre extends JFrame implements ActionListener{
	private int largeur, hauteur;
	private JButton bt_jouer = new JButton("Commencer");
	private JButton bt_param = new JButton("Paramètres");
	private JButton bt_lancer = new JButton("Lancer");

	public Fenetre(int l, int h){  
		this.largeur=l;
		this.hauteur=h;
		this.setTitle("Simulation Fourmis");
		this.setSize(largeur, hauteur);
		this.setLocationRelativeTo(null);               
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	
	
	public void setFrameMenu() {

		
		Panneau cell1 = new Panneau();
		cell1.setPanneau(1,0);
	    cell1.setBackground(Color.red);
	    cell1.setPreferredSize(new Dimension(400, 225));		
	    
	    JPanel cell2 = new JPanel();
	    cell2.setBackground(Color.red);
	    cell2.setPreferredSize(new Dimension(400, 50));
	    cell2.add(bt_jouer);
	    bt_jouer.addActionListener(this);
	    
	    JPanel cell3 = new JPanel();
	    cell3.setBackground(Color.red);
	    cell3.setPreferredSize(new Dimension(400, 50));
	    cell3.add(bt_param);
	    
	    JPanel content = new JPanel();
	    content.setPreferredSize(new Dimension(500, 500));
	    content.setBackground(Color.red);

	    content.setLayout(new GridBagLayout());
	    
	    GridBagConstraints gbc = new GridBagConstraints();
	    
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridheight = 1;
	    gbc.gridwidth = 1;
	    content.add(cell1, gbc);
	    gbc.gridwidth = GridBagConstraints.REMAINDER; 
	    
	    gbc.gridy = 1;	
	    content.add(cell2, gbc);
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
	    
	    gbc.gridy = 2;	
	    content.add(cell3, gbc);
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
    
	    this.setContentPane(content);
	}
	
	public void setFrameParam() {
		JFormattedTextField map = new JFormattedTextField(NumberFormat.getIntegerInstance());
		JLabel map_lb = new JLabel("Taille de la carte : ");
		map_lb.setPreferredSize(new Dimension(250, 30));
		map.setPreferredSize(new Dimension(50, 30));
		
		JFormattedTextField nb = new JFormattedTextField(NumberFormat.getIntegerInstance());
		JLabel nb_lb = new JLabel("Nombre de fourmis (au départ) : ");
		nb_lb.setPreferredSize(new Dimension(250, 30));
		nb.setPreferredSize(new Dimension(50, 30));
		
		JFormattedTextField time = new JFormattedTextField(NumberFormat.getIntegerInstance());
		JLabel lb_time = new JLabel("Temps entre chaque action (en ms): ");
		lb_time.setPreferredSize(new Dimension(250, 30));
		time.setPreferredSize(new Dimension(50, 30));
		
		JFormattedTextField nb_actions = new JFormattedTextField(NumberFormat.getIntegerInstance());
		JLabel nb_actions_lb = new JLabel("Nombre d'actions : ");
		nb_actions_lb.setPreferredSize(new Dimension(250, 30));
		nb_actions.setPreferredSize(new Dimension(50, 30));
		
		ButtonGroup bg = new ButtonGroup();
		JRadioButton check1 = new JRadioButton("Voir la simulation");
		check1.setPreferredSize(new Dimension(150, 30));
		JRadioButton check2 = new JRadioButton("Voir eulement les réultats");
		check2.setPreferredSize(new Dimension(150, 30));
		bg.add(check1);
		bg.add(check2);
		
		bt_lancer.addActionListener(this);
		
		JPanel content = new JPanel();
	    content.setPreferredSize(new Dimension(500, 500));
	    
	    content.setLayout(new GridBagLayout());
	    GridBagConstraints gbc = new GridBagConstraints();
		
	    gbc.gridx = 0;
	    gbc.gridy = 0;
	    gbc.gridwidth = 1;
	    gbc.gridheight = 1;
	    content.add(map_lb,gbc);
	    gbc.gridx = 1;
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
	    content.add(map,gbc);    
	    
	    gbc.gridx = 0;
	    gbc.gridy = 1;
	    content.add(nb_lb,gbc);
	    gbc.gridx = 1;
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
	    content.add(nb,gbc);    
	    
	    gbc.gridx = 0;
	    gbc.gridy = 2;
	    content.add(lb_time,gbc);
	    gbc.gridx = 1;
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
	    content.add(time,gbc);
	        
	    gbc.gridx = 0;
	    gbc.gridy = 3;
	    content.add(nb_actions_lb,gbc);
	    gbc.gridx = 1;
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
	    content.add(nb_actions,gbc);
	    
	    gbc.gridx=0;
	    gbc.gridy=4;
	    content.add(check1,gbc);
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
	    content.add(check2,gbc);
	    

	    
	    gbc.gridx=0;
	    gbc.gridy=6;
	    gbc.gridwidth = GridBagConstraints.REMAINDER;
	    content.add(bt_lancer,gbc);
	    
	    this.setContentPane(content);
	}
	
	public void setFrameMap(int taille, int nb_f, int time, int nb_a) {	
		Color m_color = new Color(20, 148, 20);
		Color n_color = new Color(253, 238, 0);
		Color f_color = new Color(47, 27, 12);
		JPanel content = new JPanel();
		GridLayout g = new GridLayout(taille,taille,1,1);
		content.setLayout(g);
	    content.setPreferredSize(new Dimension(800, 800));
		
		int dim=(this.largeur)/taille;
		Panneau[][] Grid=new Panneau[taille][taille];
	    for(int i=0;i<taille;i++) {
		   for(int j=0;j<taille;j++) {
			   Grid[i][j]=new Panneau();
			   Grid[i][j].setPanneau(2,dim);
			   Grid[i][j].setPreferredSize(new Dimension(dim,dim));
			   Grid[i][j].setBackground(m_color);

		   }
	   }
	   int[][] map= new int[taille][taille];
	   map[5][5]=1;
	   map[7][2]=1;
	   map[1][8]=1;
	   map[3][7]=2;
	   map[8][4]=2;
	    for(int i=0;i<taille;i++) {
			for(int j=0;j<taille;j++) {
				if(map[i][j]==1) {
					Grid[i][j].setPanneau(3,dim);
					content.add(Grid[i][j]);
				}
				if(map[i][j]==2) {
					Grid[i][j].setPanneau(4,dim);
					content.add(Grid[i][j]);
				}
				else {
					content.add(Grid[i][j]);
				}
			}
	    }
	    
	    
	    this.setContentPane(content);
	}

	public void actionPerformed(ActionEvent e) {
		Object src=e.getSource();
		if(src==bt_jouer) {
			this.dispose();
			Fenetre fen=new Fenetre(500,300);
			fen.setFrameParam();		
		}
		if(src==bt_lancer) {
			this.dispose();
			Fenetre f=new Fenetre(800,800);
			f.setFrameMap(10, 10, 1000, 100);//<3
		}
	}     
}