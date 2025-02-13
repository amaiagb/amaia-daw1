package com.asej.escaperoom.view.lvl2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.asej.escaperoom.view.Ventana;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Movil2 extends JPanel {

	private static Timer timer;
	private static Timer timer2;

	public Movil2(Ventana ventana) {

		setBounds(0, 0, 1100, 750);
		setLayout(null);

		JButton btnFlecha = new JButton("");
		btnFlecha.setIcon(new ImageIcon("resources\\images\\flechaDerecha.png"));
		btnFlecha.setOpaque(true);
		btnFlecha.setBorderPainted(false);
		btnFlecha.setContentAreaFilled(false);
		btnFlecha.setBounds(1000, 350, 70, 65);
		btnFlecha.setVisible(false);
		add(btnFlecha);

		JLabel lblMovil = new JLabel("");
		lblMovil.setIcon(new ImageIcon("resources\\images\\lvl2\\conversacion-1a.png"));
		lblMovil.setBounds(293, 95, 360, 548);
		add(lblMovil);

		JButton btnEscribirMensaje = new JButton(Ventana.mensajes.getString("btnMovil"));
		btnEscribirMensaje.setBackground(new Color(138, 225, 140));
		btnEscribirMensaje.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnEscribirMensaje.setBounds(706, 350, 192, 51);
		btnEscribirMensaje.setBorder(new LineBorder(new Color(118, 205, 120), 2, true));
		add(btnEscribirMensaje);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("resources\\images\\lvl2\\parque-difuminado.png"));
		lblFondo.setBounds(0, 0, 1084, 711);
		add(lblFondo);
		

		timer2 = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				lblMovil.setIcon(new ImageIcon("resources\\images\\lvl2\\conversacion-3a.png"));
				timer2.stop();
			}
		});

		timer = new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				lblMovil.setIcon(new ImageIcon("resources\\images\\lvl2\\conversacion-4a.png"));
				btnFlecha.setVisible(true);
				timer.stop();
			}
		});

		btnEscribirMensaje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblMovil.setIcon(new ImageIcon("resources\\images\\lvl2\\conversacion-2a.png"));
				btnEscribirMensaje.setVisible(false);
				timer.start();
				timer2.start();
			}
		});
		
		btnFlecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Conversacion");
				Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("movil2"));
				
			}
		});
		
		btnFlecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFlecha.setIcon(new ImageIcon("resources\\images\\flechaderechaPintada.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnFlecha.setIcon(new ImageIcon("resources\\images\\flechaDerecha.png"));
			}

		});

	}

}
