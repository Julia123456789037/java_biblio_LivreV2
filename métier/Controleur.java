package Bibli.java_biblio_LivreV2.métier;

import java.util.List;

import Bibli.java_biblio_LivreV1.FrameCreer;
import Bibli.java_biblio_LivreV1.FrameTable;

public class Controleur 
{
    private FrameTable ihm;
	private Biblio  metier;
	private FrameCreer creer;

	public Controleur ()
	{
		this.metier = new Biblio ();
		this.ihm    = new FrameTable(this);
	}


	// Accesseurs
	public List<Livre> getLivres() { return this.metier.getLivres(); }


	// Modificateurs
	public boolean majSatut ( int ligne, String val ) { return this.metier.majSatut ( ligne, val ); }

	public boolean majNote ( int ligne, int val ) { return this.metier.majNote ( ligne, val ); }

	public boolean majDetNot ( int ligne, String val ) { return this.metier.majDetNot ( ligne, val ); }

	public void ajouterLivre(String tit, String ecri1, String ecri2, String edit, String stat, int not, String detNote )
	{
		metier.ajouterLivre(tit, ecri1, ecri2, edit, stat, not, detNote );

		//System.out.println("Controleur : OK");

		this.ihm.majModele();

	}


	// Autres MÃ©thodes
	public void sauvegarder()
	{
		this.metier.sauvegarder();
	}

	public void creer ()
	{
		this.creer = new FrameCreer(this); 
	}

	public void supp(int val)
	{
		//this.metier.removeRow(val);
	}

	public static void main(String[] a){ new Controleur(); }
}
