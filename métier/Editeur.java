package projet_java.Bibli.java_biblio_LivreV2.métier;

import java.util.ArrayList;

public class Editeur 
{
    private	String				nom;
    private	int					nbLivre;


	public Editeur(String nom, int nbLivre) 
	{
		this.nom = nom;
		this.nbLivre = nbLivre;
	}

	public Editeur(String nom) 
	{
		this(nom, 0);
	}


	public String getNom				() { return nom; }
	public int getNbLivreEcrit			() { return nbLivre;}

	public void setNom			(String nom) 				{ this.nom = nom; }
	public void setNbLivreEcrit	(int nbLivre) 			{ this.nbLivre = nbLivre;}


	
	public boolean equals(Editeur edt) { return this.nom.equalsIgnoreCase(edt.nom); }

	@Override
	public String toString() {
		return "Auteur [nom=" + nom + ", prenom=" + ", nbLivre=" + nbLivre
				+ "]";
	}

}