package com.asej.escaperoom.view.lvl4;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.view.Ventana;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Ordenador extends JPanel {

	private Ventana ventana;
	private JPanel panelTextos;
	private boolean pcEncendido = false;
	private JTextPane txtMensaje;
	private JTextField txtPcPassword;
	private final String PASSWORD = "centro41eus";
	
	//private final String RUTA = "C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\escaperoom\\";
	//private final String RUTA = "D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\";
	private final String RUTA = "";
	
	public Ordenador(Ventana ventana) {
		
		setLayout(null);
		setBounds(0, 0, 1084, 711);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		
		this.ventana = ventana;
		
		JButton btnPcEntrar = new JButton(Ventana.mensajes.getString("btnEntrar"));
		btnPcEntrar.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		btnPcEntrar.setBounds(559, 269, 89, 30);
		add(btnPcEntrar);
		btnPcEntrar.setVisible(false);
		
		txtPcPassword = new JTextField();
		txtPcPassword.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtPcPassword.setBackground(Color.WHITE);
		txtPcPassword.setBounds(375, 269, 174, 30);
		add(txtPcPassword);
		txtPcPassword.setColumns(10);
		txtPcPassword.setVisible(false);
		/*
		txtMensaje = new JTextPane();
		txtMensaje.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		txtMensaje.setBounds(0, 611, 1084, 100);
		txtMensaje.setBackground(Color.DARK_GRAY);
		txtMensaje.setForeground(Color.WHITE);
		txtMensaje.setBorder(new EmptyBorder(20, 20, 20, 20));
		add(txtMensaje);
		txtMensaje.setText("Vaya, parece que está apagado");
		*/
		
		
		JButton btnIzq = new JButton("<");
		btnIzq.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));
		btnIzq.setBounds(10, 350, 70, 65);
		btnIzq.setContentAreaFilled(false); 
		btnIzq.setBorderPainted(false); 
		btnIzq.setFocusable(false);
		add(btnIzq);
		
		JLabel lblIncorrecta = new JLabel("");
		lblIncorrecta.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		lblIncorrecta.setHorizontalAlignment(SwingConstants.CENTER);
		lblIncorrecta.setForeground(Color.DARK_GRAY);
		lblIncorrecta.setBounds(375, 299, 175, 30);
		lblIncorrecta.setText("Contraseña incorrecta");
		add(lblIncorrecta);
		lblIncorrecta.setVisible(false);
		
		JLabel lblOrdenador = new JLabel("");
		lblOrdenador.setBounds(224, 100, 594, 336);
		add(lblOrdenador);
		
		JLabel lblPizarra = new JLabel("");
		lblPizarra.setBounds(300, 250, 379, 132);
		add(lblPizarra);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(RUTA+"resources\\images\\esc5_pc.jpg"));
		lblFondo.setBounds(-150, 0, 1284, 711);
		add(lblFondo);
		
		btnPcEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(PASSWORD.equals(txtPcPassword.getText())) {
					System.out.println("Sesión iniciada");
					ventana.getCardLayout().show(ventana.getPanelPrincipal(),"Escritorio");
					lblFondo.setIcon(new ImageIcon("resources\\images\\esc5_pc.jpg"));
					lblIncorrecta.setVisible(false);
					btnPcEntrar.setVisible(false);
					txtPcPassword.setVisible(false);
					Ventana.quitarTextoPantalla();
					//txtMensaje.setText("Vaya, parece que está apagado");
				} else {
					lblIncorrecta.setVisible(true);
					
				}
				txtPcPassword.setText("");
			}
		});
		
		btnIzq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pcEncendido) {
					lblFondo.setIcon(new ImageIcon("resources\\images\\esc5_pc.jpg"));
					pcEncendido = false;
				} else {
					ventana.getCardLayout().show(ventana.getPanelPrincipal(), "Aula Ordenadores");
					
				}
			}
		});
		
		lblOrdenador.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblOrdenador.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblFondo.setIcon(new ImageIcon("resources\\images\\esc5_pcEncendido.jpg"));
				txtPcPassword.setVisible(true);
				btnPcEntrar.setVisible(true);
				Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("ordenadores"));
				//txtMensaje.setText("¡Genial! Aunque parece que necesita contraseña para iniciar sesión...");
				pcEncendido = true;
			}
		});
		
		lblPizarra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPizarra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
