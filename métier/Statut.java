package Bibli.java_biblio_LivreV2.métier;

public class Statut 
{
    private String nom;


    public Statut(String nom) 
    {
        this.nom = nom;
    }

    public String getNom() { return nom;}
    public void setNom(String nom) {this.nom = nom;}

    @Override
    public String toString() {return "Statut [nom=" + nom + "]";}
  
}
