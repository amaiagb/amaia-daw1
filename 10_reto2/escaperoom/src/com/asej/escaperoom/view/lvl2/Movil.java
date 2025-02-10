package com.asej.escaperoom.view.lvl2;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.asej.escaperoom.view.Ventana;

public class Movil extends JPanel {


	public Movil(Ventana ventana) {

		setBounds(0, 0, 1100, 750);
		setLayout(null);
		
		JLabel lblMovil = new JLabel("");
		lblMovil.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\movillllllllllllllllllll.png"));
		lblMovil.setBounds(855, 657, 205, 267);
		add(lblMovil);
		
		JLabel lblColegio = new JLabel("");
		lblColegio.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\afueracolemovil.png"));
		lblColegio.setBounds(0, 0, 1084, 711);
		add(lblColegio);
		
		lblMovil.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblMovil.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\pruebamovil.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblMovil.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\movillllllllllllllllllll.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.showEscena("Movil 2");
			}
		});
	}

}
