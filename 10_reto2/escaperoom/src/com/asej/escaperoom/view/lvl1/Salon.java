package com.asej.escaperoom.view.lvl1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.asej.escaperoom.view.Ventana;

public class Salon extends JPanel {

	private JTextField tiempo_textField;
	private JTextPane textPane;
	private int contador = 0;
	private int segundos=3600;
    private JTextPane dialogo_textPane; // Declarar como atributo para poder modificarlo desde los botones
    private Clip clipBoton;
	private Clip clipClick;
	
	public Salon(Ventana ventana) {

		setBounds(0, 0, 1100, 750);
		setLayout(null);

		JButton btnIrPasillo = new JButton("v");
		btnIrPasillo.setBounds(516, 540, 46, 35);
		add(btnIrPasillo);
		
		JButton btnIrCocina = new JButton(">");
		btnIrCocina.setBounds(1028, 344, 46, 64);
		add(btnIrCocina);
		
		JButton btnIrGaraje = new JButton("<");
		btnIrGaraje.setBounds(10, 344, 46, 64);
		add(btnIrGaraje);
		
		JButton btnSopaLetras = new JButton("");
		btnSopaLetras.setBounds(412, 563, 63, 15);
		btnSopaLetras.setOpaque(true); 
		btnSopaLetras.setContentAreaFilled(false); 
		btnSopaLetras.setBorderPainted(false); 
		add(btnSopaLetras);
		
		JButton btnTerraza = new JButton("");
		btnTerraza.setBounds(458, 211, 151, 329);
		btnTerraza.setOpaque(true); 
		btnTerraza.setContentAreaFilled(false); 
		btnTerraza.setBorderPainted(false); 
		add(btnTerraza);
		
		JButton btnCuadro = new JButton("");
		btnCuadro.setBounds(107, 188, 39, 212);
		btnCuadro.setOpaque(true); 
		btnCuadro.setContentAreaFilled(false); 
		btnCuadro.setBorderPainted(false); 
		add(btnCuadro);
		
		JButton btnSillon = new JButton("");
		btnSillon.setBounds(607, 440, 116, 142);
		btnSillon.setOpaque(true); 
		btnSillon.setContentAreaFilled(false); 
		btnSillon.setBorderPainted(false); 
		add(btnSillon);

		JLabel lblFondo = new JLabel("New label");
		lblFondo.setIcon(new ImageIcon("resources\\images\\salon.jpg"));
		lblFondo.setBounds(0, 0, 1084, 711);
		add(lblFondo);
		

		btnIrPasillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirMusicaBoton();
				Ventana.quitarTextoPantalla();
				ventana.showEscena("Pasillo");
			}
		});

		btnIrCocina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirMusicaBoton();
				Ventana.quitarTextoPantalla();
				ventana.showEscena("Cocina");
			}
		});

		btnIrGaraje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirMusicaBoton();
				Ventana.quitarTextoPantalla();
				ventana.showEscena("Garaje");
			}
		});

		btnSopaLetras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Sopa de letras");
			}
		});

		btnTerraza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana.mostrarTextoPantalla("La otra terraza de la casa, tiene mejores vistas");
			}
		});

		btnCuadro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana.mostrarTextoPantalla("El cuadro favorito de mama, un dia casi lo rompo de un balonazo. Sentia la muerte sobre mis hombros");
			}
		});

		btnSillon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Ventana.mostrarTextoPantalla("Tiene la marca del culo de mi padre, ya le vale");
			}
		});
		
		setVisible(true);
		
	}
	 public void actualizarDialogo(String mensaje) {
	        dialogo_textPane.setText(""); // Borra el mensaje anterior
	        dialogo_textPane.setText(mensaje); // Muestra el nuevo mensaje
	    }
	
	    public void reproducirMusicaBoton() {
	        if (clipBoton != null && clipBoton.isRunning()) {
	        	clipBoton.stop(); // Detén la música anterior si está sonando
	        }

	        new Thread(() -> {
	            try {
	                File musica = new File("D:\\music\\boton.wav");
	                if (!musica.exists()) {
	                    System.err.println("El archivo no existe: " + musica.getAbsolutePath());
	                    return;
	                }

	                try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musica)) {
	                	clipBoton = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, audioInputStream.getFormat()));
	                	clipBoton.open(audioInputStream);
	                	clipBoton.start();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }).start();
	    }
	    
	    public void reproducirMusicaClick() {
	        if (clipClick != null && clipClick.isRunning()) {
	        	clipClick.stop(); // Detén la música anterior si está sonando
	        }

	        new Thread(() -> {
	            try {
	                File musica = new File("D:\\music\\click.wav");
	                if (!musica.exists()) {
	                    System.err.println("El archivo no existe: " + musica.getAbsolutePath());
	                    return;
	                }

	                try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musica)) {
	                	clipClick = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, audioInputStream.getFormat()));
	                	clipClick.open(audioInputStream);
	                	clipClick.start();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }).start();
	    }
}
