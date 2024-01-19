package Bibli.java_biblio_LivreV2.métier;

import java.util.ArrayList;

public class TypeLivre 
{
	private String type;
	private ArrayList<Livre> tabLivre;

	public TypeLivre(String type, ArrayList<Livre> tabLivre) 
	{
		this.type = type;
		this.tabLivre = tabLivre;
	}

	public TypeLivre(String type) 
	{
		this(type, new ArrayList<Livre>());
	}

	public String getType() { return type;}
	public void setType(String type) {this.type = type; }
	public ArrayList<Livre> getTabLivre() {return tabLivre;}
	public void setTabLivre(ArrayList<Livre> tabLivre) {this.tabLivre = tabLivre;}

	public boolean ajouterLivre(Livre bouquin)
	{
		for (Livre livre : tabLivre) {
			if (bouquin.equals(livre)) {return false;}
		}
		this.tabLivre.add(bouquin);
		return true;
	}

	@Override
	public String toString() { return "TypeLivre [type=" + type + ", tabLivre=" + tabLivre + "]";}

}
