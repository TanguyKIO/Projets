import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Panneau extends JPanel {
	private int i,dim;
	
	public void setPanneau(int i, int dim) {
		this.i=i;
		this.dim=dim;
	}
	public void paintComponent(Graphics g){
		if(i==1) {
			try {
				Font font = new Font("Courier", Font.BOLD, 30);
			    g.setFont(font);
				g.drawString("Simulation Fourmis", 35, 30);
				Image img = ImageIO.read(new File("fermite.png"));
				g.drawImage(img, 40, -30,300, 300, this);
	
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(i==2) {
			try {
				Image grass= ImageIO.read(new File("grass.jpg"));
				g.drawImage(grass,0,0,dim,dim,this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(i==3) {
			try {
				Image wheat= ImageIO.read(new File("wheat.jpg"));
				g.drawImage(wheat,0,0,dim,dim,this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(i==4) {
			try {
				Image fourmilliere= ImageIO.read(new File("fourmilliere.jpg"));
				g.drawImage(fourmilliere,0,0,dim,dim,this);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(i==5) {
			try {
				Image fermite= ImageIO.read(new File("fermite.png"));
				g.drawImage(fermite,0,0,dim,dim,this);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	
}