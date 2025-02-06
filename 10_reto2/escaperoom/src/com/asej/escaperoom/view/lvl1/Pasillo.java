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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import com.asej.escaperoom.view.Ventana;

public class Pasillo extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tiempo_textField;
	private JTextPane textPane;
	private int contador = 0;
	private int segundos=3600;
	private Clip clipBoton;
	private Clip clipClick;
	
	public Pasillo(Ventana ventana) {
		
		setBounds(0, 0, 1100, 750);
		setLayout(null);
		
		JButton btnIrHabitacion = new JButton(">");
		btnIrHabitacion.setBounds(1038, 344, 46, 64);
		add(btnIrHabitacion);
		
		JButton btnTerraza = new JButton("<");
		btnTerraza.setBounds(10, 344, 46, 64);
		add(btnTerraza);
		
		JButton btnSalon = new JButton("^");
		btnSalon.setBounds(519, 540, 46, 35);
		add(btnSalon);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("resources\\images\\pasillo.jpg"));
		lblFondo.setBounds(0, 0, 1084, 723);
		add(lblFondo);
	

		btnIrHabitacion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirMusicaBoton();
				ventana.showEscena("Habitacion");
			}
		});
		
		btnTerraza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirMusicaBoton();
				ventana.showEscena("Terraza");
			}
		});		

		btnSalon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirMusicaBoton();
				ventana.showEscena("Salon");
			}
		});
		
		setVisible(true);
	}
	

	    public void reproducirMusicaBoton() {
	        if (clipBoton != null && clipBoton.isRunning()) {
	        	clipBoton.stop(); // Detén la música anterior si está sonando
	        }

	        new Thread(() -> {
	            try {
	                File musica = new File("resources\\audio\\boton.wav");
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
	                File musica = new File("resources\\audio\\click.wav");
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