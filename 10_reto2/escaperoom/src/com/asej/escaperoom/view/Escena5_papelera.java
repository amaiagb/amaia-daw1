package com.asej.escaperoom.view;

import java.awt.Cursor;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Escena5_papelera extends JPanel {

	private Ventana ventana;
	
	public Escena5_papelera(Ventana ventana) {
		
		this.ventana = ventana;
		setBounds(85, 77, 920, 540);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblCerrarPapelera = new JLabel("");
		lblCerrarPapelera.setBounds(722, 0, 36, 35);
		add(lblCerrarPapelera);
		
		JLabel lblDocSecreto = new JLabel("");
		lblDocSecreto.setBounds(57, 95, 140, 123);
		add(lblDocSecreto);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 758, 522);
		lblFondo.setVerticalAlignment(SwingConstants.TOP);
		lblFondo.setIcon(new ImageIcon("C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\escaperoom\\resources\\images\\papelera.png"));
		add(lblFondo);
		

		lblDocSecreto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblDocSecreto.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		

		lblCerrarPapelera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCerrarPapelera.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});

	}

}
