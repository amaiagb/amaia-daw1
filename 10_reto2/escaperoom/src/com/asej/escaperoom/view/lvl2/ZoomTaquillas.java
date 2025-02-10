package com.asej.escaperoom.view.lvl2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.view.Ventana;

public class ZoomTaquillas extends JPanel {

	public ZoomTaquillas(Ventana ventana) {
		setBounds(0, 0, 1100, 750);
		setLayout(null);

		JButton btnAdivinaContrasena = new JButton("");
		btnAdivinaContrasena.setBounds(592, 32, 193, 668);
		btnAdivinaContrasena.setVisible(true);
		btnAdivinaContrasena.setBorderPainted(false);
		btnAdivinaContrasena.setContentAreaFilled(false);
		add(btnAdivinaContrasena);
		
		JButton lblFlecha = new JButton("");
		lblFlecha.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));
		lblFlecha.setBounds(29, 430, 89, 49);
		lblFlecha.setOpaque(true);
		lblFlecha.setBorderPainted(false);
		lblFlecha.setContentAreaFilled(false);
		add(lblFlecha);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\zoomtaquilla.jpg"));
		lblFondo.setBounds(0, 0, 1084, 711);
		add(lblFondo);

		btnAdivinaContrasena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Codigo");
			}
		});
		lblFlecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Taquillas");
			}
		});
		lblFlecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblFlecha.setIcon(new ImageIcon("resources\\images\\flechaIzquierdaPintada.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblFlecha.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));
			}
		});
	}
}
