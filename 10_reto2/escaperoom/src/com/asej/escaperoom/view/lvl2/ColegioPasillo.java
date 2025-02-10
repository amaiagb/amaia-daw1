package com.asej.escaperoom.view.lvl2;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.view.Ventana;

public class ColegioPasillo extends JPanel {

	public ColegioPasillo(Ventana ventana) {
		setBounds(0, 0, 1100, 750);
		setLayout(null);

		JButton btnPuertaClase = new JButton("");
		btnPuertaClase.setBounds(919, 263, 48, 265);
		btnPuertaClase.setOpaque(true);
		btnPuertaClase.setContentAreaFilled(false);
		btnPuertaClase.setBorderPainted(false);
		add(btnPuertaClase);

		JLabel lblFlecha = new JLabel("");
		lblFlecha.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\flechonblanco.png"));
		lblFlecha.setBounds(778, 371, 131, 84);
		add(lblFlecha);
		lblFlecha.setVisible(false);

		JButton btnMensaje = new JButton("");
		btnMensaje.setBounds(119, 251, 48, 277);
		btnMensaje.setOpaque(true);
		btnMensaje.setContentAreaFilled(false);
		btnMensaje.setBorderPainted(false);
		add(btnMensaje);

		JLabel lblPasillo = new JLabel("New label");
		lblPasillo.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\pasilloOriginal.jpg"));
		lblPasillo.setBounds(0, 0, 1084, 711);
		add(lblPasillo);
		

		btnPuertaClase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPuertaClase.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnPuertaClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Clase");
				Ventana.quitarTextoPantalla();
			}
		});

		btnMensaje.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnMensaje.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}
		});
		btnMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana.mostrarTextoPantalla("Deberíamos entrar primero a clase ");
				lblFlecha.setVisible(true);
			}
		});

		lblFlecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFlecha.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\flechonamarilla.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblFlecha.setIcon(new ImageIcon("C:\\Users\\Alumno\\Downloads\\flechonblanco.png"));
			}
		});
		
		
	}
}
