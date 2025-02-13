package com.asej.escaperoom.view;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class FinDemo extends JPanel {
	
	private Ventana ventana;
	private boolean logoClickado = false;
	
	public FinDemo(Ventana ventana, String tiempoRestante) {
		
		this.ventana = ventana;
		
		setBounds(0, 0, 1084, 711);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblFinDemo = new JLabel(Ventana.mensajes.getString("finDemo"));
		lblFinDemo.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblFinDemo.setForeground(Color.WHITE);
		lblFinDemo.setBackground(Color.DARK_GRAY);
		lblFinDemo.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinDemo.setBounds(275, 300, 550, 111);
		lblFinDemo.setOpaque(true);
		add(lblFinDemo);
		
        /*
		JTextField txtTiempoRestante = new JTextField(tiempoRestante);
		txtTiempoRestante.setHorizontalAlignment(SwingConstants.CENTER);
		txtTiempoRestante.setFont(new Font("Tahoma", Font.PLAIN, 28));
		txtTiempoRestante.setLocation(440, 485);
		txtTiempoRestante.setSize(200, 70);
		txtTiempoRestante.setEditable(false);
		add(txtTiempoRestante);
		*/
		JLabel lblPortadaFondo = new JLabel("");
		lblPortadaFondo.setIcon(new ImageIcon("resources\\images\\title-screen.jpg"));
		lblPortadaFondo.setBounds(0, 0, 1084, 711);
		add(lblPortadaFondo);
		
		lblPortadaFondo.addMouseListener(new MouseAdapter() {	// Abrir panel instrucciones de juego
        	public void mouseClicked(MouseEvent e) {
        		if(!logoClickado) {
        			lblPortadaFondo.setIcon(new ImageIcon("resources\\images\\title-screen-keys.jpg"));
        			logoClickado = true;
        		} else {
        			lblPortadaFondo.setIcon(new ImageIcon("resources\\images\\title-screen.jpg"));
        			logoClickado = false;
        		}
        	}
        });
	}
}
