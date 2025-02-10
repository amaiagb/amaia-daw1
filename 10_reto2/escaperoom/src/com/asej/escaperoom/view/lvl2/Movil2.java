package com.asej.escaperoom.view.lvl2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.asej.escaperoom.view.Ventana;

public class Movil2 extends JPanel {

	private static Timer timer;
	private static Timer timer2;

	public Movil2(Ventana ventana) {

		setBounds(0, 0, 1100, 750);
		setLayout(null);

		JButton btnFlecha = new JButton("");
		btnFlecha.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\flechas\\flechaDerecha.png"));
		btnFlecha.setOpaque(true);
		btnFlecha.setBorderPainted(false);
		btnFlecha.setContentAreaFilled(false);
		btnFlecha.setBounds(960, 331, 89, 51);
		btnFlecha.setVisible(false);
		add(btnFlecha);

		JLabel lblMovil = new JLabel("");
		lblMovil.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\conversacion 1a.png"));
		lblMovil.setBounds(293, 95, 360, 548);
		add(lblMovil);

		JButton btnEscribirMensaje = new JButton("Preguntar a Manuel donde esta");
		btnEscribirMensaje.setBounds(706, 274, 133, 51);
		add(btnEscribirMensaje);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\parque difuminado.png"));
		lblFondo.setBounds(0, 0, 1084, 711);
		add(lblFondo);
		

		timer2 = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				lblMovil.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\conversacion 3a.png"));
				timer2.stop();
			}
		});

		timer = new Timer(6000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				lblMovil.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\conversacion 4a.png"));
				btnFlecha.setVisible(true);
				timer.stop();
			}
		});

		btnEscribirMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMovil.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\conversacion 2a.png"));
				btnEscribirMensaje.setVisible(false);
				timer.start();
				timer2.start();
			}
		});
		
		btnFlecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Conversacion");
			}
		});
		
		btnFlecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFlecha.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\flechas\\flechaderechaPintada.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnFlecha.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\flechas\\flechaDerecha.png"));
			}

		});

	}

}
