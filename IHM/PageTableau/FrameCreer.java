package projet_java.Bibli.java_biblio_LivreV1;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.GregorianCalendar;


public class FrameCreer extends JFrame implements ActionListener
{
	private 	Controleur       	ctrl;
	private 	JPanel 				panel1;
	private 	JPanel 				panel2;

	private		JTextField 			txtTitre;
	private		JTextField 			txtAut1;
	private		JTextField 			txtAut2;
	private		JTextField 			txtEdit;
	private		JTextField 			txtStat;
	private		JTextField 			txtNot;
	private		JTextField 			txtDetNot;


	private  	JButton    			btnSauvegarder;
	private  	JButton    			btnAnnuler;


	public FrameCreer(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setSize ( 500, 250 );


		// CrÃ©ation des composants
		this.panel1 = this.panel1();
		this.panel2 = this.panel2();

		// Positionnement des composants

		this.add ( panel1, BorderLayout.CENTER );
		this.add ( panel2, BorderLayout.SOUTH  );

		this.setVisible ( true );

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JPanel panel1()
	{
		JPanel panel = new JPanel();

		panel.setLayout ( new GridLayout(7,2) );

		int annee = new GregorianCalendar().get ( GregorianCalendar.YEAR );

		// Créations des composants

		JLabel lblTitre		= new JLabel ("Titre : "			);
		JLabel lblAut1		= new JLabel ("Auteur1 : "			);
		JLabel lblAut2		= new JLabel ("Auteur2 : "			);
		JLabel lblEdit		= new JLabel ("Editeur : "			);
		JLabel lblStat		= new JLabel ("Statut : "			);
		JLabel lblNot		= new JLabel ("Note : "			);
		JLabel lblDetNot	= new JLabel ("Détail de Note : "	);

		this.txtTitre	= new JTextField("titre", 25);
		this.txtAut1	= new JTextField("auteur", 25);
		this.txtAut2	= new JTextField("auteur2", 25);
		this.txtEdit	= new JTextField("POCKET", 25);
		this.txtStat	= new JTextField("non lu, en cours, terminer", 25);
		this.txtNot		= new JTextField("29", 4);
		this.txtDetNot	= new JTextField("note personel", 25);


		// Positionnement des composants

		panel.add(lblTitre);
		panel.add(txtTitre);

		panel.add(lblAut1);
		panel.add(txtAut1);

		panel.add(lblAut2);
		panel.add(txtAut2 );

		panel.add(lblEdit);
		panel.add(txtEdit);

		panel.add(lblStat);
		panel.add(txtStat);

		panel.add(lblNot);
		panel.add(txtNot);

		panel.add(lblDetNot);
		panel.add(txtDetNot);

		return panel;
	}

	public JPanel panel2 ()
	{
		JPanel panel = new JPanel();

		this.btnAnnuler     = new JButton ( "Annuler" );
		this.btnSauvegarder = new JButton ( "Sauvegarder" );

		// Positionnement des composants

		panel.add ( this.btnSauvegarder );
		panel.add ( this.btnAnnuler );

		// Activation des composants
		this.btnSauvegarder.addActionListener ( this );
		this.btnAnnuler    .addActionListener ( this );

		return panel;
	}

	public void actionPerformed ( ActionEvent e)
	{
		if (e.getSource() == this.btnAnnuler)
		{
			this.dispose();
		}

		if (e.getSource() == this.btnSauvegarder) 
		{
			String 	tit		= this.txtTitre.getText()	;
			String 	ecri1	= this.txtAut1.getText()	;
			String 	ecri2	= this.txtAut2.getText()	;
			String 	edit	= this.txtEdit.getText()	;
			String 	stat	= this.txtStat.getText()	;
			int 	not		= Integer.parseInt(this.txtNot.getText());
			String 	detNote	= this.txtDetNot.getText()	;


			//System.out.println("FrameCreer : OK");


			this.ctrl.ajouterLivre(tit, ecri1, ecri2, edit, stat, not, detNote );
			this.dispose();
		}
	}
}