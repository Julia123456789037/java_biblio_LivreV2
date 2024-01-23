package Bibli.java_biblio_LivreV2.métier;



public class Ouvrage
{
	private String  titre;
    private String  type;
	private Auteur  ecrivain1;
	private Auteur  ecrivain2;
	private Editeur	editeur;
	private Statut	statut;
	private int		note;
	private String	detailNote;

	public Ouvrage (String tit, String typ, Auteur ecri1, Auteur ecri2, Editeur edit, Statut stat, int not, String detNote )
	{
		this.titre		= tit;
		this.type		= typ;
		this.ecrivain1	= ecri1;
		this.ecrivain2	= ecri2;
		this.editeur	= edit;
		this.statut		= stat;
		this.note		= not;
		this.detailNote	= detNote;

	}

	public String  getTitre			() { return this.titre;			}
	public Auteur  getEcrivain1		() { return this.ecrivain1;		}
	public Auteur  getEcrivain2		() { return this.ecrivain2;		}
	public Editeur  getEditeur		() { return this.editeur;		}
	public Statut  getStatut		() { return this.statut;		}
	public int     getNote			() { return this.note;			}
	public String  getDetailNote	() { return this.detailNote;	}
	public String getType			() { return this.type;			}

	public void setType(String type) {this.type = type;}
	public void setDetailNote(String s)	 { this.detailNote	= s; }

	public void setStatut(Statut s)
	{
		this.statut = s;
	}
	public boolean setNote(int num)			
	{
		if ( ! this.statut.getNom().equals("non lu") && num >= 0 &&  num <= 20 )
		{
			this.note = num;
			return true;
		}
		return false;
	}


	public boolean equals(Livre liv) { return this.equals(liv); }
	
	public String  toString   ()
	{
		String s;
		s = "";
		s = s + String.format ( "%-45s", this.titre			) + ";" +
				String.format ( "%-15s", this.type			) + ";" +
				String.format ( "%-25s", this.ecrivain1		) + ";" +
				String.format ( "%-25s" , this.ecrivain2		) + ";" +
				String.format ( "%-15s" , this.editeur		) + ";" +
				String.format ( "%-15s" , this.statut		) + ";" +
				String.format ( "%5d" , this.note			) + ";" +
				String.format ( "%-25s" , this.detailNote	);

		return s;
	}

}