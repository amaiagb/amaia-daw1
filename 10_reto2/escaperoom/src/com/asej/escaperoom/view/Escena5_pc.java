package com.asej.escaperoom.view;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Escena5_pc extends JPanel {

	private Ventana ventana;
	private JPanel panelTextos;
	
	public Escena5_pc(Ventana ventana) {
		
		setLayout(null);
		setBounds(0, 0, 1084, 711);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.ventana = ventana;
		
		JTextPane txtMensaje = new JTextPane();
		txtMensaje.setBounds(0, 0, 1000, 100);
		txtMensaje.setBackground(Color.DARK_GRAY);
		txtMensaje.setForeground(Color.WHITE);
		ventana.getPanelTextos().add(txtMensaje);
		
		JButton btnIzq = new JButton("<");
		btnIzq.setBounds(10, 250, 65, 61);
		add(btnIzq);
		
		JLabel lblOrdenador = new JLabel("");
		lblOrdenador.setBounds(224, 100, 594, 336);
		add(lblOrdenador);
		
		JLabel lblPizarra = new JLabel("");
		lblPizarra.setBounds(300, 250, 379, 132);
		add(lblPizarra);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\resources\\images\\esc5_pc.jpg"));
		lblFondo.setBounds(-150, 0, 1284, 711);
		add(lblFondo);
		
		lblOrdenador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblOrdenador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblFondo.setIcon(new ImageIcon("D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\resources\\images\\esc5_pc2.jpg"));
			}
		});
		
		lblPizarra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPizarra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
	}
}
