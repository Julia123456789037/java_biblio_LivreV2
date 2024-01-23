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


		try
		{
			scFic = new Scanner ( new FileInputStream ( "../Livres.data" ), "UTF8" );

			while ( scFic.hasNextLine() )
			{
				System.out.println(cpt);
				s = scFic.nextLine().split("\t");
				edit = new Editeur( s[5]);
				
				if( ! s[3].equals("") )
				{
					aut1 = new Auteur(s[3], s[4]);
				}
				bOK = true;

				if( ! s[5].equals("") )
				{
					aut1 = new Auteur(s[5], s[6]);
					for (Auteur aut : this.lstAuteur) { if ( aut.equals(aut1) ) {bOK = false;} }
					if (bOK) { this.lstAuteur.add(aut1); }
				}
				bOK = true;

				if( ! s[7].equals("") )
				{
					edit = new Editeur(s[7]);
					for (Editeur edit1 : this.lstEditeur) { if ( edit.equals(edit1) ) {bOK = false;} }
					if (bOK) { this.lstEditeur.add(edit); }
				}

				if ( s[1].equalsIgnoreCase("roman") )
				{
					//this.lstOuvrage.add ( new Livre ( s[0], s[2], s[3], s[4], Integer.parseInt(s[5]), s[6] ) );
				}
				if ( s[1].equalsIgnoreCase("manga") )
				{
					//this.lstOuvrage.add ( new manga ( s[0], s[2], s[3], s[4], Integer.parseInt(s[5]), s[6] ) );
				}
				if ( s[1].equalsIgnoreCase("série") )
				{
					//this.lstOuvrage.add ( new Serie ( s[0], s[2], s[3], s[4], Integer.parseInt(s[5]), s[6] ) );
				}
				if ( s[1].equalsIgnoreCase("anime") )
				{
					//this.lstOuvrage.add ( new Anime ( s[0], s[2], s[3], s[4], Integer.parseInt(s[5]), s[6] ) );
				}
				
				//System.out.println( s[0] + " " +  s[1] + " " +  s[2] + " " +  s[3] + " " +  s[4] + " " +  Integer.parseInt(s[5]) + " " +  s[6] );

				//titre	roman	auteurN	auteurP	autur22N	autur22P	POCKET	non lu, en cours, terminer	29	ceci est une note perso
				cpt++;
			}
			System.out.println(scFic.hasNextLine());
			System.out.println("final : " + cpt);

			scFic.close();
		}
		catch (Exception e){ e.printStackTrace(); }
	}


	public boolean majStatut ( int ligne, Statut stat )
	{
		return this.lstOuvrage.get(ligne).setStatut ( stat );
	}

	public boolean majNote ( int ligne, int val )
	{
		return this.lstOuvrage.get(ligne).setNote ( val );
	}

	public boolean majDetNot ( int ligne, String val )
	{
		return this.lstOuvrage.get(ligne).setDetailNote ( val );
	}

	public void ajouterLivre (String tit, String ecri1, String ecri2, String edit, String stat, int not, String detNote )
	{
		//this.lstOuvrage.add(new Livre (tit, ecri1, ecri2, edit, stat, not, detNote ));

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


