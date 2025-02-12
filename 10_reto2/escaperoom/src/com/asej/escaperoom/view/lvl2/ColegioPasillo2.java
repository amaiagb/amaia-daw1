package com.asej.escaperoom.view.lvl2;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.view.Ventana;

public class ColegioPasillo2 extends JPanel {

	static JButton  btnIrFuera;
	static JLabel lblPuertaClase;
	static JButton btnPuertaTaqui;
	
	public ColegioPasillo2(Ventana ventana) {
		setBounds(0, 0, 1100, 750);
		setLayout(null);

		btnPuertaTaqui = new JButton("");
		btnPuertaTaqui.setOpaque(true);
		btnPuertaTaqui.setContentAreaFilled(false);
		btnPuertaTaqui.setBorderPainted(false);
		btnPuertaTaqui.setBounds(120, 251, 39, 287);
		add(btnPuertaTaqui);
		
		btnIrFuera = new JButton();
		btnIrFuera.setIcon(new ImageIcon("resources\\images\\flechaAbajo.png"));
		btnIrFuera.setBounds(510, 550, 70, 65);
		btnIrFuera.setContentAreaFilled(false); 
		btnIrFuera.setBorderPainted(false); 
		btnIrFuera.setFocusable(false);
		btnIrFuera.setVisible(false);
		add(btnIrFuera);

		btnIrFuera.setVisible(false);
		
		lblPuertaClase = new JLabel("");
		lblPuertaClase.setBounds(924, 271, 46, 267);
		add(lblPuertaClase);
		
		JLabel lblPuertaIzquierda = new JLabel("");
		lblPuertaIzquierda.setIcon(new ImageIcon("resources\\images\\lvl2\\pasilloOriginal.jpg"));
		lblPuertaIzquierda.setBounds(0, 0, 1084, 711);
		add(lblPuertaIzquierda);

		lblPuertaClase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.showEscena("Clase");
				Ventana.quitarTextoPantalla();
				//Ventana.mostrarTextoPantalla("Ya hemos encontrado todo lo que hay en clase");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPuertaClase.setIcon(new ImageIcon("resources\\images\\flechaDerechaPintada.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblPuertaClase.setIcon(new ImageIcon("resources\\images\\flechaDerecha.png"));
			}
		});

		btnPuertaTaqui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Taquillas");
				Ventana.quitarTextoPantalla();
			}
		});
		
		btnPuertaTaqui.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPuertaTaqui.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		
		btnIrFuera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.showEscena("Conversacion");
				Ventana.mostrarTextoPantalla("¡He encontrado tu cromo!");
				Conversacion.btnFlechaDerecha.setVisible(false);
			}
		});
		
		btnIrFuera.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIrFuera.setIcon(new ImageIcon("resources\\images\\flechaAbajoPintada.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIrFuera.setIcon(new ImageIcon("resources\\images\\flechaAbajo.png"));
			}
		});
	}

}
