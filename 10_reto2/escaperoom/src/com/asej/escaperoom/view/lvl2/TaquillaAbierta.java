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

public class TaquillaAbierta extends JPanel {

	public TaquillaAbierta(Ventana ventana) {
		setBounds(0, 0, 1100, 750);
		setLayout(null);

		JButton btnFlecha = new JButton("");
		btnFlecha.setOpaque(true);
		btnFlecha.setBorderPainted(true);
		btnFlecha.setContentAreaFilled(false);
		btnFlecha.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\flechas\\flechaIzquierda.png"));
		btnFlecha.setBounds(36, 320, 107, 71);
		add(btnFlecha);

		JLabel lblChincheta = new JLabel("");
		lblChincheta.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\chincheta.png"));
		lblChincheta.setBounds(331, 272, 30, 24);
		add(lblChincheta);

		JLabel lblCromo = new JLabel("");
		lblCromo.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\iniestataq.png"));
		lblCromo.setBounds(282, 287, 79, 40);
		add(lblCromo);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\taquillaAbierta.jpg"));
		lblFondo.setBounds(0, 0, 1084, 711);
		add(lblFondo);
		
		btnFlecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Taquillas");
			}
		});
		
		lblCromo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblCromo.setVisible(false);
			}
		});
	}
}
