package projet_java.Bibli.java_biblio_LivreV2.métier;

import java.util.ArrayList;



public class Auteur 
{
    private	String				nom;
    private	String				prenom;
    private	int					nbLivreEcrit;


	public Auteur(String nom, String prenom, int nbLivreEcrit) 
	{
		this.nom = nom;
		this.prenom = prenom;
		this.nbLivreEcrit = nbLivreEcrit;
	}

	public Auteur(String nom, String prenom) 
	{
		this(nom, prenom, 0);
	}


	public String getNom				() { return nom; }
	public String getPrenom				() { return prenom; }
	public int getNbLivreEcrit			() { return nbLivreEcrit;}

	public void setNom			(String nom) 				{ this.nom = nom; }
	public void setPrenom		(String prenom) 			{ this.prenom = prenom;}
	public void setNbLivreEcrit	(int nbLivreEcrit) 			{ this.nbLivreEcrit = nbLivreEcrit;}



	public boolean equals(Auteur aut) { return this.equals(aut); }

	@Override
	public String toString() {
		return "Auteur [nom=" + nom + ", prenom=" + prenom + ", nbLivreEcrit=" + nbLivreEcrit
				+ "]";
	}

}