package Bibli.java_biblio_LivreV2.métier;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;


import Bibli.java_biblio_LivreV2.métier.Editeur;
import Bibli.java_biblio_LivreV2.métier.Ouvrage;
import Bibli.java_biblio_LivreV2.métier.Statut;
import Bibli.java_biblio_LivreV2.métier.Auteur;


public class Biblio
{

	private ArrayList<Editeur>lstEditeur;
	private ArrayList<Auteur> lstAuteur;
	private ArrayList<Statut> lstStatut;
	private ArrayList<Ouvrage> lstOuvrage;

	public Biblio()
	{
		this.lstOuvrage = new ArrayList<Ouvrage>();
		this.lstEditeur = new ArrayList<Editeur>();
		this.lstAuteur = new ArrayList<Auteur>();
		this.lstStatut = new ArrayList<Statut>();

		this.initStat();
		this.initTabLivres();
	}

	public void initTabLivres()
	{
		Scanner     scFic;
		String[]	s;
		int			cpt;
		cpt = 0;
		boolean bOK;

		Ouvrage ouv;
		Editeur edit;
		Auteur aut1, aut2;
		Statut stat;

		bOK = true;
		edit = null;
		aut1 = aut2  = null;
		stat = null;

		try
		{
			scFic = new Scanner ( new FileInputStream ( "../Livres.data" ), "UTF8" );

			while ( scFic.hasNextLine() )
			{
				System.out.println(cpt);
				s = scFic.nextLine().split("\t");
				
				if( ! s[2].equals("") )
				{
					aut1 = new Auteur(s[2], s[3]);
					for (Auteur aut : this.lstAuteur) { if ( (aut.getNom() + aut.getPrenom()).equals(aut1.getNom() + aut1.getPrenom()) ) {bOK = false;} }
					if (bOK) { this.lstAuteur.add(aut1); }
				}
				bOK = true;

				if( ! s[4].equals("") )
				{
					aut2 = new Auteur(s[4], s[5]);
					for (Auteur aut : this.lstAuteur) { if ( (aut.getNom() + aut.getPrenom()).equals(aut2.getNom() + aut2.getPrenom()) ) {bOK = false;} }
					if (bOK) { this.lstAuteur.add(aut2); }
				}
				bOK = true;

				if( ! s[6].equals("") )
				{
					edit = new Editeur(s[6]);
					for (Editeur edit1 : this.lstEditeur) { if ( edit.equals(edit1) ) {bOK = false;} }
					if (bOK) { this.lstEditeur.add(edit); }
				}
				bOK = true;

				if( ! s[7].equals("") )
				{
					stat = new Statut(s[6]);
					for (Statut stat1 : this.lstStatut) { if ( stat.equals(stat1) ) {bOK = false;} }
					if (bOK) { this.lstStatut.add(stat); }
				}

				if ( s[1].equalsIgnoreCase("roman") ) { ajouterLivre( s[0], aut1, aut2, edit, stat, Integer.parseInt(s[8]), s[9] ); }
				if ( s[1].equalsIgnoreCase("manga") ) { ajouterManga( s[0], aut1, aut2, edit, stat, Integer.parseInt(s[8]), s[9] ); }
				if ( s[1].equalsIgnoreCase("serie") ) { ajouterSerie( s[0], aut1, aut2, edit, stat, Integer.parseInt(s[8]), s[9] ); }
				if ( s[1].equalsIgnoreCase("anime") ) { ajouterAnime( s[0], aut1, aut2, edit, stat, Integer.parseInt(s[8]), s[9] ); }
				
				cpt++;
				System.out.println("+1 : " + cpt);
			}
			System.out.println(scFic.hasNextLine());
			System.out.println("final : " + cpt);

			scFic.close();
		}
		catch (Exception e){ e.printStackTrace(); }
	}

	public void initStat()
	{
		this.lstStatut.add(new Statut("non commencer"));
		this.lstStatut.add(new Statut("en cours"));
		this.lstStatut.add(new Statut("pause"));
		this.lstStatut.add(new Statut("fini"));

		System.out.println("fin init STatat");
	}

	public void majStatut ( int ligne, Statut stat ) { this.lstOuvrage.get(ligne).setStatut ( stat ); }
	public boolean majNote ( int ligne, int val ) { return this.lstOuvrage.get(ligne).setNote ( val ); }
	public void majDetNot ( int ligne, String val ) { this.lstOuvrage.get(ligne).setDetailNote ( val ); }

	public void ajouterOuvrage (String tit, String type, Auteur ecri1, Auteur ecri2, Editeur edit, Statut stat, int not, String detNote )
	{
		switch( type )
		{
			case "Roman" -> ajouterLivre( tit, ecri1, ecri2, edit, stat, not, detNote );
			case "Manga" -> ajouterManga( tit, ecri1, ecri2, edit, stat, not, detNote );
			case "Serie" -> ajouterSerie( tit, ecri1, ecri2, edit, stat, not, detNote );
			case "Anime" -> ajouterAnime( tit, ecri1, ecri2, edit, stat, not, detNote );
		}
		this.sauvegarder();
		System.out.println("Livre : OK");
	}

	private void ajouterLivre(String tit, Auteur ecri1, Auteur ecri2, Editeur edit, Statut stat, int not, String detNote )
	{
		this.lstOuvrage.add ( new Livre ( tit, ecri1, ecri2, edit, stat, not, detNote ) ); 
	}

	private void ajouterManga(String tit, Auteur ecri1, Auteur ecri2, Editeur edit, Statut stat, int not, String detNote )
	{
		this.lstOuvrage.add ( new Manga ( tit, ecri1, ecri2, edit, stat, not, detNote ) ); 
	}

	private void ajouterAnime(String tit, Auteur ecri1, Auteur ecri2, Editeur edit, Statut stat, int not, String detNote )
	{
		this.lstOuvrage.add ( new Anime ( tit, ecri1, ecri2, edit, stat, not, detNote ) ); 
	}

	private void ajouterSerie(String tit, Auteur ecri1, Auteur ecri2, Editeur edit, Statut stat, int not, String detNote )
	{
		this.lstOuvrage.add ( new Serie ( tit, ecri1, ecri2, edit, stat, not, detNote ) ); 
	}

	public void sauvegarder()
	{

		try
		{
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("Livres.data"), "UTF8" ));

			for (Ouvrage liv:this.lstOuvrage )
			{
				pw.println ( liv.getTitre ()		+ "\t" +
							 liv.getType ()			+ "\t" +
				             liv.getEcrivain1 ()	+ "\t" +
				             liv.getEcrivain2 ()	+ "\t" +
							 liv.getEditeur ()		+ "\t" +
							 liv.getStatut ()		+ "\t" +
							 liv.getNote ()			+ "\t" +
				             liv.getDetailNote () );
			}
			pw.close();
		}
		catch (Exception e){ e.printStackTrace(); }
	}

	public ArrayList<Ouvrage> getOuvrage(){return new ArrayList<Ouvrage>( this.lstOuvrage );}

	public String toString()
	{
		String sRet = "";

		for ( Ouvrage clt: this.lstOuvrage )
			sRet += clt.toString() + "\n";

		return sRet;
	}

	public static void main(String[] a){ new Biblio(); }
}


