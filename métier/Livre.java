package Bibli.java_biblio_LivreV2.métier;



public class Livre extends Ouvrage
{
	public Livre (String tit, Auteur ecri1, Auteur ecri2, Editeur edit, Statut stat, int not, String detNote )
	{
		super(tit, "roman", ecri1, ecri2, edit, stat, not, detNote);
	}


}