package Bibli.java_biblio_LivreV2.IHM.PageMenu;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import Bibli.java_biblio_LivreV2.métier.Controleur;


public class FrameMenu extends JFrame implements ActionListener
{
	private 	Controleur       	ctrl;
	private 	JPanel 				panel1;
	private 	JPanel 				panel2;

    private  	JButton    			btnToutOuvrage;
    private  	JButton    			btnLivre;
    private  	JButton    			btnVideo;
    private  	JButton    			btnRequete;


	private  	JButton    			btnQuitter;


	public FrameMenu(Controleur ctrl)
	{
		this.ctrl = ctrl;
		this.setSize ( 500, 250 );


		// Création des composants
		this.panel1 = new JPanel();
		this.panel2 = new JPanel();

        this.btnToutOuvrage	= new JButton ( "Ouvrage" );
        this.btnLivre		= new JButton ( "Livre" );
        this.btnVideo		= new JButton ( "Video" );
		this.btnQuitter		= new JButton ( "QUITTER" );

		// Positionnement des composants

		this.add ( panel1, BorderLayout.CENTER );
		this.add ( panel2, BorderLayout.NORTH  );

        

		// Positionnement des composants

		this.panel1.add ( this.btnToutOuvrage );
		this.panel1.add ( this.btnLivre );
		this.panel1.add ( this.btnVideo );
		this.panel1.add ( this.btnQuitter );

		// Activation des composants
		this.btnToutOuvrage	.addActionListener ( this );
		this.btnLivre		.addActionListener ( this );
		this.btnVideo		.addActionListener ( this );
		this.btnQuitter		.addActionListener ( this );



		this.setVisible ( true );

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public void actionPerformed ( ActionEvent e)
	{
		if (e.getSource() == this.btnToutOuvrage) { this.dispose(); }
		if (e.getSource() == this.btnLivre) { this.dispose(); }
		if (e.getSource() == this.btnVideo) { this.dispose(); }
		if (e.getSource() == this.btnQuitter) { this.dispose(); }
	}
}