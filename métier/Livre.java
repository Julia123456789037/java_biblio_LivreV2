package Bibli.java_biblio_LivreV2.métier;


import java.util.GregorianCalendar;

public class Livre
{
	private String  titre;
    private TypeLivre type;
	private Auteur  ecrivain1;
	private Auteur  ecrivain2;
	private Editeur  editeur;
	private Statut	statut;
	private int		note;
	private String	detailNote;

	public Livre (String tit, String ecri1, String ecri2, String edit, String stat, int not, String detNote )
	{
		this.titre		= tit;
		this.ecrivain1	= ecri1;
		this.ecrivain2	= ecri2;
		this.editeur	= edit;
		this.statut		= stat;
		this.note		= not;
		this.detailNote	= detNote;

		if (ecri2.equals('n') )
		{
			this.ecrivain2	= null;
		}

		if (stat.equals('n') )
		{
			this.statut	= null;
		}

		if (detNote.equals('n') )
		{
			this.detailNote	= null;
		}
	}

	public String  getTitre			() { return this.titre;		}
	public String  getEcrivain1		() { return this.ecrivain1;	}
	public String  getEcrivain2		() { return this.ecrivain2;	}
	public String  getEditeur		() { return this.editeur;		}
	public String  getStatut		() { return this.statut;		}
	public int     getNote			() { return this.note;		}
	public String  getDetailNote	() { return this.detailNote;	}


	public boolean setStatut(String s)
	{
		this.statut		= s;
		return true;
	}
	public boolean setNote(int num)			
	{
		if ( !this.statut.equals("non lu"))
		{
			this.note			= num;
			return true;
		}
		return false;
	}
	public boolean setDetailNote(String s)	
	{
		if (  !this.statut.equals("non lu") )
		{
			this.detailNote	= s;
			return true;
		}
		return false;
	}
	

	public String  toString   ()
	{
		String s;
		s = "";
		s = s + String.format ( "%-45s", this.titre			) + ";" +
				String.format ( "%-25s", this.ecrivain1		) + ";" +
				String.format ( "%-25s" , this.ecrivain2		) + ";" +
				String.format ( "%-15s" , this.editeur		) + ";" +
				String.format ( "%-15s" , this.statut		) + ";" +
				String.format ( "%5d" , this.note			) + ";" +
				String.format ( "%-25s" , this.detailNote	);

		return s;
	}

}