package com.asej.escaperoom.view.lvl4;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.view.Ventana;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class AulaOrdenadores extends JPanel {

	private Ventana ventana;
	private JPanel panelTextos;
	
	//private final String RUTA = "C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\escaperoom\\";
	//private final String RUTA = "D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\";
	private final String RUTA = "";
	
	public AulaOrdenadores(Ventana ventana) {
		
		setLayout(null);
		setBounds(0, 0, 1084, 711);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.ventana = ventana;
		/*
		JTextPane txtMensaje = new JTextPane();
		txtMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtMensaje.setBounds(0, 611, 1084, 100);
		txtMensaje.setBackground(Color.DARK_GRAY);
		txtMensaje.setForeground(Color.WHITE);
		txtMensaje.setBorder(new EmptyBorder(20, 20, 20, 20));
		add(txtMensaje);
		txtMensaje.setText("Igual en la sala de informática encuentro algo que me ayude");
		*/
		Ventana.mostrarTextoPantalla("Igual en la sala de informática encuentro algo que me ayude");
		
		JButton btnIzq = new JButton("");
		btnIzq.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));
		btnIzq.setBounds(10, 350, 70, 65);
		btnIzq.setContentAreaFilled(false); 
		btnIzq.setBorderPainted(false); 
		btnIzq.setFocusable(false);
		add(btnIzq);
		
		JLabel lblOrdenador = new JLabel("");
		lblOrdenador.setBounds(166, 414, 143, 96);
		add(lblOrdenador);
		
		JLabel lblPizarra = new JLabel("");
		lblPizarra.setBounds(300, 250, 379, 132);
		add(lblPizarra);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(RUTA+"resources\\images\\esc5.jpg"));
		lblFondo.setBounds(-150, 0, 1284, 711);
		add(lblFondo);
		
		lblOrdenador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblOrdenador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				ventana.getCardLayout().show(ventana.getPanelPrincipal(), "Ordenador");
				Ventana.mostrarTextoPantalla("Vaya, parece que está apagado");
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
		btnIzq.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIzq.setIcon(new ImageIcon("resources\\images\\flechaIzquierdaPintada.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIzq.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));
			}
		});
		
	}
}
