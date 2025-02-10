package com.asej.escaperoom.view.lvl2;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.view.Ventana;

public class ColegioPasillo2 extends JPanel {

	public ColegioPasillo2(Ventana ventana) {
		setBounds(0, 0, 1100, 750);
		setLayout(null);

		JButton btnPuertaTaqui = new JButton("");
		btnPuertaTaqui.setOpaque(true);
		btnPuertaTaqui.setContentAreaFilled(false);
		btnPuertaTaqui.setBorderPainted(false);
		btnPuertaTaqui.setBounds(120, 251, 39, 287);
		add(btnPuertaTaqui);
		
		JLabel lblNoPasarClase = new JLabel("");
		lblNoPasarClase.setBounds(924, 271, 46, 267);
		add(lblNoPasarClase);
		
		JLabel lblPuertaIzquierda = new JLabel("");
		lblPuertaIzquierda.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\pasilloOriginal.jpg"));
		lblPuertaIzquierda.setBounds(0, 0, 1084, 711);
		add(lblPuertaIzquierda);

		lblNoPasarClase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Ventana.mostrarTextoPantalla("Ya hemos encontrado todo lo que hay en clase");
			}
		});

		btnPuertaTaqui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Taquillas");
				Ventana.quitarTextoPantalla();
			}
		});
		
		btnPuertaTaqui.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPuertaTaqui.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
	}

}
