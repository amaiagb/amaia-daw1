package com.asej.escaperoom.view.lvl2;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.asej.escaperoom.controlador.Audio;
import com.asej.escaperoom.view.PanelInventario;
import com.asej.escaperoom.view.PanelPistas;
import com.asej.escaperoom.view.Ventana;

public class Conversacion2 extends JPanel {

	private JLabel lblFondo;
	//private String objetoManuel = "cromo";
	static JButton btnFlechaDerecha;
	
	public Conversacion2(Ventana ventana) {
		
		setBounds(0, 0, 1100, 750);
		setLayout(null);
		
		JLabel lblManuel = new JLabel("");
		lblManuel.setBounds(397, 110, 361, 601);
		add(lblManuel);
		
		btnFlechaDerecha = new JButton();
		btnFlechaDerecha.setIcon(new ImageIcon("resources\\images\\flechaDerecha.png"));
		btnFlechaDerecha.setBounds(1000, 350, 70, 65);
		btnFlechaDerecha.setContentAreaFilled(false); 
		btnFlechaDerecha.setBorderPainted(false); 
		btnFlechaDerecha.setFocusable(false);
		add(btnFlechaDerecha);
		/*
		JButton btnLeerMas = new JButton("+");
		btnLeerMas.setBackground(Color.LIGHT_GRAY);
		btnLeerMas.setForeground(Color.DARK_GRAY);
		btnLeerMas.setFont(new Font("Tahoma",0,16));
		btnLeerMas.setBounds(950, 650, 200, 65);
		add(btnLeerMas);
		btnLeerMas.setVisible(false);
		*/
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("resources\\images\\lvl2\\manuel-bg.jpg"));
		lblFondo.setBounds(0, 0, 1084, 711);
		add(lblFondo);
		
		Ventana.mostrarTextoPantalla("Vale, te lo has ganado. Ayer vi a Aitor en el aula de informática y estaba muy raro, como... triste. \nAlgo raro pasa, tú que eres su amigo deberías averiguarlo"); 
		lblManuel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		/*
		btnLeerMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Juego ppt");
				Ventana.quitarTextoPantalla();
				}
		});
		*/
		btnFlechaDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Aula Ordenadores");
				Ventana.nivelActual=3;
            	PanelPistas.resetearPistas(Ventana.nivelActual);
				Ventana.mostrarTextoPantalla("Si aquí es donde vieron a Aitor la última vez, igual puedo encontrar alguna pista");
				}
		});
		btnFlechaDerecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFlechaDerecha.setIcon(new ImageIcon("resources\\images\\flechaDerechaPintada.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnFlechaDerecha.setIcon(new ImageIcon("resources\\images\\flechaDerecha.png"));
			}
		});		
	}
	
	public JLabel getFondo() {
		return lblFondo;
	}
}
