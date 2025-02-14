package com.asej.escaperoom.view.lvl2;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.view.Ventana;

public class ColegioExterior extends JPanel {

	public ColegioExterior(Ventana ventana) {
		setBounds(0, 0, 1100, 750);
		setLayout(null);


		JButton btnPuertaColegio = new JButton("");
		btnPuertaColegio.setBounds(511, 443, 75, 82);
		btnPuertaColegio.setOpaque(true);
		btnPuertaColegio.setContentAreaFilled(false);
		btnPuertaColegio.setBorderPainted(false);
		add(btnPuertaColegio);

		JLabel lblImagenColegio = new JLabel("");
		lblImagenColegio.setIcon(new ImageIcon(
				"resources\\images\\lvl2\\colegio-exterior.jpg"));
		lblImagenColegio.setBounds(0, 0, 1084, 711);
		add(lblImagenColegio);

		btnPuertaColegio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPuertaColegio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});

		btnPuertaColegio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Colegio Pasillo");
			}
		});
	}
}
