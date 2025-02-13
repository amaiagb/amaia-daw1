package com.asej.escaperoom.view.lvl2;

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

import com.asej.escaperoom.controlador.Audio;
import com.asej.escaperoom.model.Objeto;
import com.asej.escaperoom.view.Ventana;

public class ZoomJarron extends JPanel {

	public ZoomJarron(Ventana ventana) {
		
		setBounds(0, 0, 1080, 711);
		setLayout(null);

		JButton btnFlecha = new JButton("");
		btnFlecha.setVisible(false);
		btnFlecha.setOpaque(true);
		btnFlecha.setBorderPainted(false);
		btnFlecha.setContentAreaFilled(false);
		btnFlecha.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));
		btnFlecha.setBounds(10, 350, 70, 65);
		add(btnFlecha);

		JButton btnllave = new JButton("");
		btnllave.setOpaque(true);
		btnllave.setBorderPainted(false);
		btnllave.setContentAreaFilled(false);
		btnllave.setBounds(552, 88, 93, 100);
		add(btnllave);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("resources\\images\\lvl2\\jarron-con-llave.png"));
		lblFondo.setBounds(0, 60, 1084, 711);
		add(lblFondo);

		btnllave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Audio.reproducirEfectoSonido(Audio.COIN);
				lblFondo.setIcon(new ImageIcon("resources\\images\\lvl2\\jarron-sin-llave.png"));
				ventana.getObjetosInventario().add(new Objeto("llave","llave.png", "La llave que encontré en el jarrón"));
				btnFlecha.setVisible(true);
			}
		});

		btnFlecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Clase");
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
