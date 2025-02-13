package com.asej.escaperoom.view.lvl3;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.controlador.Audio;
import com.asej.escaperoom.view.FinDemo;
import com.asej.escaperoom.view.Ventana;
import com.asej.escaperoom.view.lvl2.Conversacion;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class AulaOrdenadores extends JPanel {

	private Ventana ventana;
	private JPanel panelTextos;
	static JButton btnSalir;
	static JLabel lblOrdenador;
	
	public AulaOrdenadores(Ventana ventana) {
		
		setLayout(null);
		setBounds(0, 0, 1084, 711);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.ventana = ventana;

		btnSalir = new JButton();
		btnSalir.setIcon(new ImageIcon("resources\\images\\flechaAbajo.png"));
		btnSalir.setBounds(510, 550, 70, 65);
		btnSalir.setContentAreaFilled(false); 
		btnSalir.setBorderPainted(false); 
		btnSalir.setFocusable(false);
		btnSalir.setVisible(false);
		add(btnSalir);
		btnSalir.setVisible(false);
		
		lblOrdenador = new JLabel("");
		lblOrdenador.setBounds(166, 414, 143, 96);
		add(lblOrdenador);
		
		JLabel lblPizarra = new JLabel("");
		lblPizarra.setBounds(300, 250, 379, 132);
		add(lblPizarra);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("resources\\images\\esc5.jpg"));
		lblFondo.setBounds(-150, 0, 1284, 711);
		add(lblFondo);
		
		lblOrdenador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblOrdenador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.showEscena("Ordenador");
				Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("aulaOrdenadores1"));
			}
		});
		
		lblPizarra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPizarra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.showEscena("Pizarra");
				Ventana.quitarTextoPantalla();
			}
		});
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				ventana.showEscena("Fin Demo");
				ventana.getTimer().stop();
				Ventana.segundos = Ventana.txtTimer.getText();
				*/
				ventana.getTimer().stop();
				String tiempoRestante = Ventana.txtTimer.getText();
				ventana.getPanelPrincipal().add(new FinDemo(ventana, tiempoRestante), "Fin Demo");
				ventana.showEscena("Fin Demo");
				Ventana.quitarTextoPantalla();
				Audio.detenerMusica();
			}
		});
		
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSalir.setIcon(new ImageIcon("resources\\images\\flechaAbajoPintada.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSalir.setIcon(new ImageIcon("resources\\images\\flechaAbajo.png"));
			}
		});
		
	}

}
