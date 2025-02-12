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

public class Taquillas extends JPanel {

	public Taquillas(Ventana ventana) {

		setBounds(0, 0, 1100, 750);
		setLayout(null);

		JButton btnAccesoTaquilla = new JButton("");
		btnAccesoTaquilla.setOpaque(true);
		btnAccesoTaquilla.setContentAreaFilled(false);
		btnAccesoTaquilla.setBorderPainted(false);
		btnAccesoTaquilla.setBounds(530, 269, 54, 204);
		add(btnAccesoTaquilla);
		
		JButton btnFlecha = new JButton("");
		btnFlecha.setOpaque(true);
		btnFlecha.setBorderPainted(false);
		btnFlecha.setContentAreaFilled(false);
		btnFlecha.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));
		btnFlecha.setBounds(43, 346, 89, 47);
		add(btnFlecha);

		JLabel lblTaquillas = new JLabel("");
		lblTaquillas.setIcon(new ImageIcon("resources\\images\\lvl2\\pasillo-taquilas.jpg"));
		lblTaquillas.setBounds(0, 0, 1084, 711);
		add(lblTaquillas);

		btnAccesoTaquilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Zoom Taquillas");
			}
		});
		
		btnFlecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Colegio Pasillo2");
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
