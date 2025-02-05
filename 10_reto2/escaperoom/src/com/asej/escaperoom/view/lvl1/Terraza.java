package com.asej.escaperoom.view.lvl1;

import java.awt.Font;
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
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import com.asej.escaperoom.view.Ventana;

public class Terraza extends JPanel {

	private JTextField tiempo_textField;
	private JTextPane textPane;
	private int contador = 0;
	private int segundos=3600;
	private Clip clipBoton;
	private Clip clipClick;
	
	public Terraza(Ventana ventana) {
		
		setBounds(0, 0, 1100, 750);
		setLayout(null);
		
		JButton btnIrPasillo = new JButton(">");
		btnIrPasillo.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIrPasillo.setBounds(1028, 307, 46, 69);
		add(btnIrPasillo);
		
		JButton btnPerro = new JButton("");
		btnPerro.setBounds(395, 499, 89, 82);
		btnPerro.setOpaque(true); 
		btnPerro.setContentAreaFilled(false); 
		btnPerro.setBorderPainted(false);
		add(btnPerro);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("resources\\images\\terraza.jpg"));
		lblFondo.setBounds(0, 0, 1084, 700);
		add(lblFondo);
		

		btnIrPasillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirMusicaBoton();
				Ventana.mostrarTextoPantalla("");
				ventana.showEscena("Pasillo");
			}
		});

		btnPerro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ladrar();
				
			}
		});
		
	setVisible(true);	
	}
	public void ladrar(){
		contador++;
		if (contador % 3 == 0) {
			Ventana.mostrarTextoPantalla("¡Miau!");
			contador = 0;
		} else {
			Ventana.mostrarTextoPantalla("¡Guau!");
		}
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
