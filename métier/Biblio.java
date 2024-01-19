package projet_java.Bibli.java_biblio_LivreV1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.OutputStreamWriter;




public class Biblio
{

	private List<Livre> lstLivre;

	public Biblio()
	{
		this.lstLivre = new ArrayList<Livre>();
		this.initTabLivres();
	}

	public void initTabLivres()
	{
		Scanner     scFic;
		String[]	s;
		int			cpt;
		cpt = 0;


		try
		{
			scFic = new Scanner ( new FileInputStream ( "Livres.data" ), "UTF8" );

			while ( scFic.hasNextLine() )
			{
				System.out.println(cpt);
				s = scFic.nextLine().split("\t");

				this.lstLivre.add ( new Livre ( s[0], s[1], s[2], s[3], s[4], Integer.parseInt(s[5]), s[6] ) );
				System.out.println( s[0] + " " +  s[1] + " " +  s[2] + " " +  s[3] + " " +  s[4] + " " +  Integer.parseInt(s[5]) + " " +  s[6] );
				cpt++;
			}
			System.out.println(scFic.hasNextLine());
			System.out.println("final : " + cpt);

			scFic.close();
		}
		catch (Exception e){ e.printStackTrace(); }
	}


	public boolean majSatut ( int ligne, String val )
	{
		return this.lstLivre.get(ligne).setStatut ( val );
	}

	public boolean majNote ( int ligne, int val )
	{
		return this.lstLivre.get(ligne).setNote ( val );
	}

	public boolean majDetNot ( int ligne, String val )
	{
		return this.lstLivre.get(ligne).setDetailNote ( val );
	}

	public void ajouterLivre (String tit, String ecri1, String ecri2, String edit, String stat, int not, String detNote )
	{
		this.lstLivre.add(new Livre (tit, ecri1, ecri2, edit, stat, not, detNote ));

		this.sauvegarder();

		System.out.println("Livre : OK");


	}

	public void sauvegarder()
	{

		try
		{
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("Livres.data"), "UTF8" ));

			for (Livre liv:this.lstLivre )
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


	public List<Livre> getLivres()
	{
		return new ArrayList<Livre>( this.lstLivre );
	}


	public String toString()
	{
		String sRet = "";

		for ( Livre clt: this.lstLivre )
			sRet += clt.toString() + "\n";

		return sRet;
	}
}


