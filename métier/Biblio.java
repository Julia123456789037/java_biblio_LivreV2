package Bibli.java_biblio_LivreV2.métier;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;




public class Biblio
{

	private ArrayList<Editeur>lstEditeur;
	private ArrayList<Auteur> lstAuteur;
	private ArrayList<Statut> lstStatut;
	private ArrayList<Ouvrage> lstOuvrage;

	public Biblio()
	{
		this.lstOuvrage = new ArrayList<Ouvrage>();
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
					for (Auteur aut : this.lstAuteur) { if ( aut.equals(aut1) ) {bOK = false;} }
					if (bOK) { this.lstAuteur.add(aut1); }
				}
				bOK = true;

				if( ! s[4].equals("") )
				{
					aut2 = new Auteur(s[4], s[5]);
					for (Auteur aut : this.lstAuteur) { if ( aut.equals(aut2) ) {bOK = false;} }
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

				if ( s[1].equalsIgnoreCase("roman") ) { this.lstOuvrage.add ( new Livre ( s[0], aut1, aut2, edit, stat, Integer.parseInt(s[8]), s[9] ) ); }
				if ( s[1].equalsIgnoreCase("manga") ) { this.lstOuvrage.add ( new Manga ( s[0], aut1, aut2, edit, stat, Integer.parseInt(s[8]), s[9] ) ); }
				if ( s[1].equalsIgnoreCase("serie") ) { this.lstOuvrage.add ( new Serie ( s[0], aut1, aut2, edit, stat, Integer.parseInt(s[8]), s[9] ) ); }
				if ( s[1].equalsIgnoreCase("anime") ) { this.lstOuvrage.add ( new Anime ( s[0], aut1, aut2, edit, stat, Integer.parseInt(s[8]), s[9] ) ); }
				
				cpt++;
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
	}


	public void majStatut ( int ligne, Statut stat )
	{
		this.lstOuvrage.get(ligne).setStatut ( stat );
	}

	public boolean majNote ( int ligne, int val )
	{
		return this.lstOuvrage.get(ligne).setNote ( val );
	}

	public void majDetNot ( int ligne, String val )
	{
		this.lstOuvrage.get(ligne).setDetailNote ( val );
	}

	public void ajouterLivre (String tit, String ecri1, String ecri2, String edit, String stat, int not, String detNote )
	{
		this.sauvegarder();

		System.out.println("Livre : OK");

	}


	public void sauvegarder()
	{

		try
		{
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("Livres.data"), "UTF8" ));

			for (Ouvrage liv:this.lstOuvrage )
			{
				pw.println ( liv.getTitre ()		+ "\t" +
							 liv.getType ()		+ "\t" +
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


	public ArrayList<Ouvrage> getOuvrage()
	{
		return new ArrayList<Ouvrage>( this.lstOuvrage );
	}


	public String toString()
	{
		String sRet = "";

		for ( Ouvrage clt: this.lstOuvrage )
			sRet += clt.toString() + "\n";

		return sRet;
	}
}


