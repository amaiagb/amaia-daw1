package com.asej.escaperoom.view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class Escena1 extends JPanel {
	private JPanel panelTextos;
	
	public Escena1(JPanel panelTextos) {
		
		setLayout(null);
		setBounds(0, 0, 1084, 711);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.panelTextos = panelTextos;
		
		JTextPane txtMensaje = new JTextPane();
		txtMensaje.setBounds(0, 0, 7, 20);
		panelTextos.add(txtMensaje);
		
		JButton btnIzq = new JButton("<");
		btnIzq.setBounds(10, 250, 65, 61);
		add(btnIzq);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("resources\\images\\esc1.jpg"));
		lblFondo.setBounds(-150, 0, 1284, 711);
		add(lblFondo);
		
		
		
	}
}
