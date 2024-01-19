package Bibli.java_biblio_LivreV2.métier;

import java.util.ArrayList;

public class Auteur 
{
    private	String				nom;
    private	String				prenom;
    private	int					nbLivreEcrit;
    private	ArrayList<Livre>	tabLivre;


	public Auteur(String nom, String prenom, int nbLivreEcrit, ArrayList<Livre> tabLivre) 
	{
		this.nom = nom;
		this.prenom = prenom;
		this.nbLivreEcrit = nbLivreEcrit;
		this.tabLivre = tabLivre;
	}

	public Auteur(String nom, String prenom) 
	{
		this(nom, prenom, 0, new ArrayList<Livre>());
	}


	public String getNom				() { return nom; }
	public String getPrenom				() { return prenom; }
	public int getNbLivreEcrit			() { return nbLivreEcrit;}
	public ArrayList<Livre> getTabLivre	() {return tabLivre;}

	public void setNom			(String nom) 				{ this.nom = nom; }
	public void setPrenom		(String prenom) 			{ this.prenom = prenom;}
	public void setNbLivreEcrit	(int nbLivreEcrit) 			{ this.nbLivreEcrit = nbLivreEcrit;}
	public void setTabLivre		(ArrayList<Livre> tabLivre)	{this.tabLivre = tabLivre;}

	public void ajouterLivre(Livre bouquin)
	{
		this.nbLivreEcrit = this.nbLivreEcrit + 1;
		this.tabLivre.add(bouquin);
	}

	@Override
	public String toString() {
		return "Auteur [nom=" + nom + ", prenom=" + prenom + ", nbLivreEcrit=" + nbLivreEcrit + ", tabLivre=" + tabLivre
				+ "]";
	}

}