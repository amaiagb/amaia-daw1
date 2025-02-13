package com.asej.escaperoom.view.lvl2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.asej.escaperoom.controlador.Audio;
import com.asej.escaperoom.view.Ventana;

public class Clase extends JPanel {

	public Clase(Ventana ventana) {

		setBounds(0, 0, 1100, 750);
		setLayout(null);

		JButton btnIrPasillo = new JButton("");
		btnIrPasillo.setOpaque(false);
		btnIrPasillo.setBorderPainted(false);
		btnIrPasillo.setContentAreaFilled(false);
		btnIrPasillo.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));
		btnIrPasillo.setBounds(10, 350, 70, 65);
		add(btnIrPasillo);
		
		JButton btnJarron = new JButton("");
		btnJarron.setOpaque(true);
		btnJarron.setContentAreaFilled(false);
		btnJarron.setBorderPainted(false);
		btnJarron.setBounds(174, 341, 31, 49);
		add(btnJarron);

		JButton btnGuardarCuadro = new JButton(Ventana.mensajes.getString("clase1"));
		btnGuardarCuadro.setBounds(440, 556, 156, 29);
		btnGuardarCuadro.setVisible(false);
		add(btnGuardarCuadro);
		
		JLabel lblDibujoJuan = new JLabel("");
		lblDibujoJuan.setIcon(new ImageIcon("resources\\images\\lvl2\\cuadroTOP.jpg"));
		lblDibujoJuan.setBounds(271, 145, 500, 400);
		lblDibujoJuan.setVisible(false);
		add(lblDibujoJuan);
		
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
		btnCuadroJuan.setBounds(657, 313, 60, 77);
		add(btnCuadroJuan);
		
		JLabel lblClase = new JLabel("");
		lblClase.setIcon(new ImageIcon("resources\\images\\lvl2\\clase.jpg"));
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
				Audio.reproducirEfectoSonido(Audio.ARMARIO);
				Ventana.mostrarTextoPantalla("¡Anda! Una nota, puede que nos sirva luego");
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
				Audio.reproducirEfectoSonido(Audio.COIN);
				Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("clase3"));
			}
		});
		btnGuardarCuadro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDibujoJuan.setVisible(false);
				btnGuardarCuadro.setVisible(false);
			}
		});
		
		btnIrPasillo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIrPasillo.setIcon(new ImageIcon("resources\\images\\flechaIzquierdaPintada.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIrPasillo.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));
			}
		});
	}

}