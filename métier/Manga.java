package projet_java.Bibli.java_biblio_LivreV2.métier;


public class Manga extends Ouvrage
{
	public Manga (String tit, Auteur ecri1, Auteur ecri2, Editeur edit, Statut stat, int not, String detNote )
	{
		super(tit, "Manga", ecri1, ecri2, edit, stat, not, detNote);
	}
}