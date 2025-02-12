package com.asej.escaperoom.view.lvl2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.view.Ventana;

public class ZoomTaquillas extends JPanel {

	private Codigo codigo;
	
	public ZoomTaquillas(Ventana ventana) {
		setBounds(0, 0, 1100, 750);
		setLayout(null);

		JButton btnAdivinaContrasena = new JButton("");
		btnAdivinaContrasena.setBounds(592, 32, 193, 668);
		btnAdivinaContrasena.setVisible(true);
		
		JButton btnFlecha = new JButton();
		btnFlecha.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));
		btnFlecha.setBounds(10, 350, 70, 65);
		btnFlecha.setContentAreaFilled(false); 
		btnFlecha.setBorderPainted(false); 
		btnFlecha.setFocusable(false);
		add(btnFlecha);

		btnAdivinaContrasena.setBorderPainted(false);
		btnAdivinaContrasena.setContentAreaFilled(false);
		add(btnAdivinaContrasena);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("resources\\images\\lvl2\\zoomtaquilla.jpg"));
		lblFondo.setBounds(0, 0, 1084, 711);
		add(lblFondo);

		btnAdivinaContrasena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				codigo = new Codigo(ventana);
				codigo.setBackground(Color.DARK_GRAY);
				ventana.getLayeredPane().add(codigo,JLayeredPane.POPUP_LAYER);
				codigo.setBounds(240, 100, 600, 500);
				codigo.setVisible(true);
				
			}
		});

		btnFlecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Taquillas");
				if(codigo!=null) {
					codigo.setVisible(false);
				}
			}
		});
		
		btnFlecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFlecha.setIcon(new ImageIcon("resources\\images\\flechaIzquierdaPintada.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnFlecha.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));
			}
		});
	}
}
