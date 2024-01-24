package Bibli.java_biblio_LivreV2.IHM;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;
import Bibli.java_biblio_LivreV2.métier.Ouvrage;

public class GrilleDonneesModel extends AbstractTableModel
{
	private Controleur ctrl;

	private String[]   tabEntetes;
	private Object[][] tabDonnees;

	public GrilleDonneesModel (Controleur ctrl)
	{
		this.ctrl = ctrl;

		Livre liv;
		ArrayList<Ouvrage> lstOuvrage = ctrl.getOuvrage();

		tabDonnees = new Object[lstOuvrage.size()][7];

		for ( int lig = 0; lig<lstOuvrage.size(); lig++)
		{
			ouv = lstOuvrage.get(lig);

			tabDonnees[lig][0] = ouv.getTitre ();
			tabDonnees[lig][1] = ouv.getType ();
			tabDonnees[lig][2] = ouv.getEcrivain1 ();
			tabDonnees[lig][3] = ouv.getEcrivain2 ();
			tabDonnees[lig][4] = ouv.getEditeur ();
			tabDonnees[lig][5] = ouv.getStatut ();
			tabDonnees[lig][6] = ouv.getNote ();
			tabDonnees[lig][7] = ouv.getDetailNote ();
		}

		this.tabEntetes = new String[]   {   "Titre", "Type", "Ecrivain1", "Ecrivain2", "Editeur", "Statut", "Note", "Detail de Note"  };
	}

	public int    getColumnCount()                 { return this.tabEntetes.length;      }
	public int    getRowCount   ()                 { return this.tabDonnees.length;      }
	public String getColumnName (int col)          { return this.tabEntetes[col];        }
	public Object getValueAt    (int row, int col) { return this.tabDonnees[row][col];   }
	public Class  getColumnClass(int c)            { return getValueAt(0, c).getClass(); }

	public boolean isCellEditable(int row, int col)
	{
		return col == 5 || col == 6 || col == 7;
	}

	public void setValueAt(Object value, int row, int col)
	{
		boolean bRet;

		if ( col == 5 )
		{
			this.tabDonnees[row][col] = value;
			this.fireTableCellUpdated(row, col);
		}

		if ( col == 6 )
		{
			this.tabDonnees[row][col] = value;
			this.fireTableCellUpdated(row, col);
		}

		if ( col == 7 )
		{
			this.tabDonnees[row][col] = value;
			this.fireTableCellUpdated(row, col);
		}
	}
}