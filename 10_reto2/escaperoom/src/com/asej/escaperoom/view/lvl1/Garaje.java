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

import com.asej.escaperoom.model.Objeto;
import com.asej.escaperoom.view.Ventana;

public class Garaje extends JPanel {

	 private JTextField tiempo_textField;
	    private JTextPane dialogo_textPane; // Declarar como atributo para poder modificarlo desde los botones
	    private int contador = 0;
	    private int segundos = 3600;
	    private Clip clipBoton;
		private Clip clipClick;
	
	public Garaje(Ventana ventana) {
		
		setBounds(0, 0, 1100, 750);
		setLayout(null);

        JButton btnCoche = new JButton("");
        btnCoche.setBounds(455, 344, 224, 206);
        btnCoche.setOpaque(true);
        btnCoche.setContentAreaFilled(false);
        btnCoche.setBorderPainted(false);
        add(btnCoche);

        JButton btnNevera = new JButton("");
        btnNevera.setBounds(695, 306, 89, 215);
        btnNevera.setOpaque(true);
        btnNevera.setContentAreaFilled(false);
        btnNevera.setBorderPainted(false);
        add(btnNevera);

        JButton btnLimpieza = new JButton("");
        btnLimpieza.setBounds(895, 436, 46, 101);
        btnLimpieza.setOpaque(true);
        btnLimpieza.setContentAreaFilled(false);
        btnLimpieza.setBorderPainted(false);
        add(btnLimpieza);

        JButton btnHerramientas = new JButton("");
        btnHerramientas.setBounds(327, 436, 36, 23);
        btnHerramientas.setOpaque(true);
        btnHerramientas.setContentAreaFilled(false);
        btnHerramientas.setBorderPainted(false);
        add(btnHerramientas);

        JButton btnIrSalon = new JButton(">");
        btnIrSalon.setBounds(1028, 344, 46, 64);
        add(btnIrSalon);

        JLabel lblFondo = new JLabel("");
        lblFondo.setIcon(new ImageIcon("resources\\images\\garaje.jpg"));
        lblFondo.setBounds(0, 0, 1084, 711);
        add(lblFondo);

        btnIrSalon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				reproducirMusicaBoton();
				Ventana.quitarTextoPantalla();
				ventana.showEscena("Salon");
            }
        });

        btnCoche.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	reproducirMusicaCar();
            	Ventana.mostrarTextoPantalla("El coche de papá está averiado. Será mejor que hoy coja el bus.");
            }
        });

        btnNevera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	reproducirMusicaArmario();
            	Ventana.mostrarTextoPantalla("¿Por qué solo hay alcohol?");
            }
        });

        btnLimpieza.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	reproducirMusicaArmario();
            	Ventana.mostrarTextoPantalla("Solo son productos de limpieza del coche, no me sirve.");
            }
        });
        
        btnHerramientas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	reproducirMusicaCoin();
            	Ventana.mostrarTextoPantalla("¡Las herramientas de aita! Se han añadido al inventario");
                btnHerramientas.setEnabled(false);
                ventana.getObjetosInventario().add(new Objeto("destornillador","destornillador.png", "Un destornillador, siempre es útil tener herramientas"));
            }
        });

        setVisible(true);
    }

    // Método para actualizar el diálogo y borrar el texto anterior
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
    
    public void reproducirMusicaCoin() {
        if (clipClick != null && clipClick.isRunning()) {
        	clipClick.stop(); // Detén la música anterior si está sonando
        }

        new Thread(() -> {
            try {
                File musica = new File("D:\\music\\coin.wav");
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
    
    public void reproducirMusicaCar() {
        if (clipClick != null && clipClick.isRunning()) {
        	clipClick.stop(); // Detén la música anterior si está sonando
        }

        new Thread(() -> {
            try {
                File musica = new File("D:\\music\\coche.wav");
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
    
    public void reproducirMusicaArmario() {
        if (clipClick != null && clipClick.isRunning()) {
        	clipClick.stop(); // Detén la música anterior si está sonando
        }

        new Thread(() -> {
            try {
                File musica = new File("D:\\music\\armario.wav");
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
