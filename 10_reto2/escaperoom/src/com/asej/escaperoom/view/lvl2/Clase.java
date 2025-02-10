package com.asej.escaperoom.view.lvl2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.asej.escaperoom.view.Ventana;

public class Clase extends JPanel {

	public Clase(Ventana ventana) {

		setBounds(0, 0, 1100, 750);
		setLayout(null);

		JButton btnIrPasillo = new JButton(">");
		btnIrPasillo.setBounds(10, 331, 63, 71);
		add(btnIrPasillo);

		JButton btnJarron = new JButton("");
		btnJarron.setOpaque(true);
		btnJarron.setContentAreaFilled(false);
		btnJarron.setBorderPainted(false);
		btnJarron.setBounds(174, 341, 31, 49);
		add(btnJarron);

		JLabel lblDibujoJuan = new JLabel("");
		lblDibujoJuan.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\cuadroTOP.jpg"));
		lblDibujoJuan.setBounds(271, 145, 500, 400);
		lblDibujoJuan.setVisible(false);
		add(lblDibujoJuan);
		
		JButton btnGuardarCuadro = new JButton("A\u00F1adir al Inventario");
		btnGuardarCuadro.setBounds(601, 505, 156, 29);
		btnGuardarCuadro.setVisible(false);
		add(btnGuardarCuadro);
		
		JButton btnCajon = new JButton("");
		btnCajon.setOpaque(true);
		btnCajon.setBorderPainted(false);
		btnCajon.setContentAreaFilled(false);
		btnCajon.setBounds(842, 471, 126, 43);
		add(btnCajon);

		JButton btnCuadroJuan = new JButton("");
		btnCuadroJuan.setOpaque(true);
		btnCuadroJuan.setContentAreaFilled(false);
		btnCuadroJuan.setBorderPainted(false);
		btnCuadroJuan.setBounds(692, 355, 16, 23);
		add(btnCuadroJuan);
		
		JLabel lblClase = new JLabel("");
		lblClase.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\clase).jpg"));
		lblClase.setBounds(0, 0, 1084, 711);
		add(lblClase);

		btnJarron.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Zoom Jarron");
			}
		});

		btnCajon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Cajon");
				Ventana.mostrarTextoPantalla("Parece que está vacío");
			}
		});
		
		btnIrPasillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Colegio Pasillo2");
				Ventana.quitarTextoPantalla();
			}
		});

		btnCuadroJuan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDibujoJuan.setVisible(true);
				btnGuardarCuadro.setVisible(true);
			}
		});
		btnGuardarCuadro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDibujoJuan.setVisible(false);
				btnGuardarCuadro.setVisible(false);
			}
		});
	}

}