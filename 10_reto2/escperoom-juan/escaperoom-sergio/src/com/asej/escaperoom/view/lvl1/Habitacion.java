package com.asej.escaperoom.view.lvl1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.asej.escaperoom.controlador.Audio;
import com.asej.escaperoom.view.Ventana;

public class Habitacion extends JPanel {

	//private JPanel contentPane;
	//private JTextField tiempo_textField;
	//private JTextPane textPane;
	//private int contador = 0;
	//private int segundos=3600;
    //private JTextPane txtDialogo;
    //private Clip clipBoton;
	//private Clip clipClick;
	private Ventana ventana;
	static JButton btnCama;
	
	public Habitacion(Ventana ventana) {
		
		this.ventana = ventana;
		
		setBounds(0, 0, 1100, 750);
		setLayout(null);
		
		JButton btnIrPasillo = new JButton();
		btnIrPasillo.setBounds(10, 350, 70, 65);
		btnIrPasillo.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));
		btnIrPasillo.setContentAreaFilled(false); 
		btnIrPasillo.setBorderPainted(false); 
		btnIrPasillo.setFocusable(false);
		add(btnIrPasillo);
		
		btnCama = new JButton("");
		btnCama.setOpaque(true); 
		btnCama.setContentAreaFilled(false); 
		btnCama.setBorderPainted(false); 
		btnCama.setBounds(307, 529, 306, 101);
		add(btnCama);
		btnCama.setVisible(false);
		
		JButton btnCajon = new JButton("");
		btnCajon.setOpaque(true); 
		btnCajon.setContentAreaFilled(false); 
		btnCajon.setBorderPainted(false);
		btnCajon.setBounds(221, 534, 53, 50);
		add(btnCajon);
		
		JButton btnReloj = new JButton("");
		btnReloj.setOpaque(true); 
		btnReloj.setContentAreaFilled(false); 
		btnReloj.setBorderPainted(false); 
		btnReloj.setBounds(860, 85, 111, 196);
		add(btnReloj);
		
		JButton btnOrdenador = new JButton("");
		btnOrdenador.setBounds(739, 289, 219, 289);
		btnOrdenador.setOpaque(true); 
		btnOrdenador.setContentAreaFilled(false); 
		btnOrdenador.setBorderPainted(false); 
		add(btnOrdenador);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("resources\\images\\habitacion.jpg"));
		lblFondo.setBounds(0, 0, 1084, 711);
		add(lblFondo);
		
		btnIrPasillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Audio.reproducirEfectoSonido(Audio.BOTON);
				Ventana.quitarTextoPantalla();
				ventana.showEscena("Pasillo");
			}
		});

		btnCajon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("habitacion1"));
			}
		});

		btnReloj.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("habitacion2"));
			}
		});

		btnOrdenador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("habitacion3"));
			}
		});

		btnCama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Cama");
			}
		});

		btnIrPasillo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIrPasillo.setIcon(new ImageIcon("resources\\images\\flechaIzquierdaPintada.png"));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIrPasillo.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));

			}
		});
		
		setVisible(true);

	}


}
