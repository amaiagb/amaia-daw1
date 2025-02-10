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

import com.asej.escaperoom.view.Ventana;

public class ZoomJarron extends JPanel {

	public ZoomJarron(Ventana ventana) {
		
		setBounds(0, 0, 1100, 750);
		setLayout(null);

		JButton btnFlecha = new JButton("");
		btnFlecha.setVisible(false);
		btnFlecha.setOpaque(true);
		btnFlecha.setBorderPainted(false);
		btnFlecha.setContentAreaFilled(false);
		btnFlecha.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\flechas\\flechaIzquierda.png"));
		btnFlecha.setBounds(25, 330, 93, 54);
		add(btnFlecha);

		JButton btnllave = new JButton("");
		btnllave.setOpaque(true);
		btnllave.setBorderPainted(false);
		btnllave.setContentAreaFilled(false);
		btnllave.setBounds(565, 35, 74, 90);
		add(btnllave);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\jarronazoconllaveeee.png"));
		lblFondo.setBounds(0, 0, 1084, 711);
		add(lblFondo);

		btnllave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblFondo.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\jarronazosinllave.png"));
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
				btnFlecha.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\flechas\\flechaIzquierdaPintada.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnFlecha.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\flechas\\flechaIzquierda.png"));
			}
		});
	}
}
