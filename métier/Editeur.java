package Bibli.java_biblio_LivreV2.métier;

import java.util.ArrayList;

public class Editeur 
{
    private	String				nom;
    private	int					nbLivre;
    private	ArrayList<Livre>	tabLivre;


	public Editeur(String nom, int nbLivre, ArrayList<Livre> tabLivre) 
	{
		this.nom = nom;
		this.nbLivre = nbLivre;
		this.tabLivre = tabLivre;
	}

	public Editeur(String nom) 
	{
		this(nom, 0, new ArrayList<Livre>());
	}


	public String getNom				() { return nom; }
	public int getNbLivreEcrit			() { return nbLivre;}
	public ArrayList<Livre> getTabLivre	() {return tabLivre;}

	public void setNom			(String nom) 				{ this.nom = nom; }
	public void setNbLivreEcrit	(int nbLivre) 			{ this.nbLivre = nbLivre;}
	public void setTabLivre		(ArrayList<Livre> tabLivre)	{this.tabLivre = tabLivre;}

	public void ajouterLivre(Livre bouquin)
	{
		this.nbLivre = this.nbLivre + 1;
		this.tabLivre.add(bouquin);
	}

	
	public boolean equals(Editeur edt) { return this.nom.equalsIgnoreCase(edt.nom); }

	@Override
	public String toString() {
		return "Auteur [nom=" + nom + ", prenom=" + ", nbLivre=" + nbLivre + ", tabLivre=" + tabLivre
				+ "]";
	}

}