package Bibli.java_biblio_LivreV2.IHM;

import java.util.ArrayList;
import java.awt.*;
import javax.swing.*;


public class PanelTable extends JPanel
{
	private Controleur ctrl;
	private JTable     tblGrilleDonnees;

	public PanelTable (Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setLayout ( new BorderLayout() );

		JScrollPane spGrilleDonnees;
		JPanel panelTmp = new JPanel ( new BorderLayout() );

		// CrÃ©ation des composants
		this.tblGrilleDonnees = new JTable ( new GrilleDonneesModel(ctrl) );
		this.tblGrilleDonnees.setFillsViewportHeight(true);

		this.tblGrilleDonnees.getColumnModel().getColumn(0).setPreferredWidth(250);
		this.tblGrilleDonnees.getColumnModel().getColumn(1).setPreferredWidth(50);
		this.tblGrilleDonnees.getColumnModel().getColumn(2).setPreferredWidth(50);
		this.tblGrilleDonnees.getColumnModel().getColumn(3).setPreferredWidth(50);
		this.tblGrilleDonnees.getColumnModel().getColumn(4).setPreferredWidth(50);
		this.tblGrilleDonnees.getColumnModel().getColumn(5).setPreferredWidth(50);
		this.tblGrilleDonnees.getColumnModel().getColumn(6).setPreferredWidth(50);
		this.tblGrilleDonnees.getColumnModel().getColumn(7).setPreferredWidth(250);



 		spGrilleDonnees   = new JScrollPane( this.tblGrilleDonnees );

		// positionnement des composants
		this.add ( spGrilleDonnees, BorderLayout.CENTER );
	}

	public void majModele ()
	{
		this.tblGrilleDonnees.setModel( new GrilleDonneesModel(ctrl) );
	}

}