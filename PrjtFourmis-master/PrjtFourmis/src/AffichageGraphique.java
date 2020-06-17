public class AffichageGraphique {
	public static Monde m;

	public AffichageGraphique(Monde m) {
		this.m=m;
	}

	public void AffFenetre(int l, int h) {
		Fenetre f = new Fenetre(l,h);
		f.setFrameMenu();
		
	}
}

