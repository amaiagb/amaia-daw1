package com.asej.escaperoom.view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class Escena5_correo extends JPanel {

	//private final String RUTA = "C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\escaperoom\\";
	private final String RUTA = "D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\";
	
	private Ventana ventana;

	public Escena5_correo(Ventana ventana) {

		this.ventana = ventana;
		setBounds(85, 77, 920, 540);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 758, 522);
		lblFondo.setVerticalAlignment(SwingConstants.TOP);
		lblFondo.setIcon(new ImageIcon("D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\resources\\images\\correo.png"));
		add(lblFondo);
	}

}
