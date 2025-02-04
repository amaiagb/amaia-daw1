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
	private JTextPane dialogo_textPane;
	private Clip clipBoton;
	private Clip clipClick;
	
	public Terraza(Ventana ventana) {
		setBounds(0, 0, 1100, 750);
		setLayout(null);
		
		dialogo_textPane = new JTextPane();
		dialogo_textPane.setEditable(false);
		dialogo_textPane.setBounds(310, 580, 605, 120);
		add(dialogo_textPane);
		
		JButton pasillo_Button = new JButton(">");
		pasillo_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirMusicaBoton();
				setVisible(false);
				ventana.getCardLayout().show(ventana.getPanelPrincipal(), "Pasillo");
			}
		});
		
		JButton dog_Button = new JButton("");
		dog_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ladrar();
				 try {
			            StyledDocument doc = dialogo_textPane.getStyledDocument();
			            doc.insertString(doc.getLength(),"Guau", null);
			        } catch (BadLocationException ex) {
			            ex.printStackTrace();
			        }
			}
		});
		dog_Button.setBounds(395, 499, 89, 82);
		add(dog_Button);
		pasillo_Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		pasillo_Button.setBounds(1028, 307, 46, 69);
		dog_Button.setOpaque(true); 
		dog_Button.setContentAreaFilled(false); 
		dog_Button.setBorderPainted(false);
		add(pasillo_Button);
		
		
		JLabel fondo_Label = new JLabel("");
		fondo_Label.setIcon(new ImageIcon("resources\\images\\terraza.jpg"));
		fondo_Label.setBounds(0, 0, 1084, 700);
		add(fondo_Label);
		
		
	setVisible(true);	
	}
	public void ladrar(){
		contador++;
		if (contador==3) {
			 try {
		            StyledDocument doc = dialogo_textPane.getStyledDocument();
		            doc.insertString(doc.getLength(),"Miau", null);
		        } catch (BadLocationException ex) {
		            ex.printStackTrace();
		        }
			 contador = 0;
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
