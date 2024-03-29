package Bibli.java_biblio_LivreV2;

import java.util.ArrayList;
import java.util.List;

import Bibli.java_biblio_LivreV2.métier;
import Bibli.java_biblio_LivreV2.métier.Editeur;
import Bibli.java_biblio_LivreV2.métier.Ouvrage;
import Bibli.java_biblio_LivreV2.métier.Statut;
import Bibli.java_biblio_LivreV2.métier.Auteur;
import Bibli.java_biblio_LivreV2.métier.Biblio;
import Bibli.java_biblio_LivreV2.IHM.PageMenu.FrameMenu;
/* 
import Bibli.java_biblio_LivreV2.IHM.PageTableau.FrameCreer.;
import Bibli.java_biblio_LivreV2.IHM.PageTableau.GrilleDonneesModel;
import Bibli.java_biblio_LivreV2.IHM.PageTableau.PanelTable;
*/

public class Controleur 
{
    private FrameTable ihm;
	private Biblio  metier;
	private FrameCreer creer;

	public Controleur ()
	{
		this.metier = new Biblio ();
		this.ihm    = new FrameMenu(this);
	}


	// Accesseurs
	public ArrayList<Ouvrage> getOuvrage() { return this.metier.getOuvrage(); }


	// Modificateurs
	public void majStatut ( int ligne, Statut val ) { this.metier.majStatut ( ligne, val ); }

	public boolean majNote ( int ligne, int val ) { return this.metier.majNote ( ligne, val ); }

	public void majDetNot ( int ligne, String val ) { this.metier.majDetNot ( ligne, val ); }

	public void ajouterOuvrage(String tit, String type, Auteur ecri1, Auteur ecri2, Editeur edit, Statut stat, int not, String detNote )
	{
		metier.ajouterOuvrage(tit, type, ecri1, ecri2, edit, stat, not, detNote );

		System.out.println("Controleur : OK");
		//this.ihm.majModele();

	}


	// Autres MÃ©thodes
	public void sauvegarder()
	{
		this.metier.sauvegarder();
	}

	//public void creer (){ this.creer = new FrameCreer(this); }

	public void supp(int val)
	{
		//this.metier.removeRow(val);
	}

	public static void main(String[] a){ new Controleur(); }
}
