package com.asej.escapeRoom.view;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ButtonGroup;    
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.applet.AudioClip;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class view_guia extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	 private Clip clipPrincipal;
	    private Clip clipBoton;
	    private Clip clipClick;


	public view_guia(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1120, 1120);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		contentPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reproducirMusicaClick(); // Llama al método para reproducir el sonido
            }
        });
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBackground(Color.LIGHT_GRAY);
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirMusicaBoton();
				
				dispose();
				new view_portada();
			}
		});
		btnVolver.setBounds(145, 444, 124, 36);
		contentPane.add(btnVolver);
		
		JTextArea textArea = new JTextArea("Guía de Juego: Aventura Épica\n"
				+ "\r\n"
				+"1. Mejora tus habilidades\n"
				+ "\r\n"
				+"2. Mueve a tu personaje con las teclas de dirección o el joystick. Usa el botón A (o X) para atacar, el botón B (o O) para esquivar y el botón Y (o Cuadrado) para interactuar con objetos.\r\n"
				+ "\r\n"
				+"3. Accede al menú de inventario presionando Start.\r\n"
				+ "\r\n"
				+"4. El entorno de juego tiene elementos interactivos. Puedes usar barriles explosivos o trampas del terreno para atacar a los enemigos de forma estratégica.\r\n"
				+ "\r\n"
				+"5. El mapa está lleno de lugares secretos y objetos valiosos. Asegúrate de investigar cada rincón.\r\n"
				+ "\r\n"
				+"6. Algunas misiones secundarias desbloquean áreas secretas o personajes que te ayudan en tu aventura.\r\n"
				+ "\r\n"
				+"7. Guarda tu progreso frecuentemente\r\n"
				+ "\r\n"
			);
		textArea.setFont(new Font("Noto Serif Cond", Font.BOLD, 13));
		textArea.setBackground(Color.WHITE);
		
		textArea.setBounds(10, 11, 414, 422);
		textArea.setLineWrap(true); // Habilitar ajuste de línea
		textArea.setWrapStyleWord(true); // Ajustar por palabras
		textArea.setEditable(false); // Hacerlo no editable si solo es para mostrar texto
		contentPane.add(textArea);
		
		setVisible(true);
	}
	public void reproducirMusicaPrincipal() {
        if (clipPrincipal != null && clipPrincipal.isRunning()) {
            clipPrincipal.stop(); // Detén la música anterior si está sonando
        }

        new Thread(() -> {
            try {
                File musica = new File("D:\\music\\op.wav");
                if (!musica.exists()) {
                    System.err.println("El archivo no existe: " + musica.getAbsolutePath());
                    return;
                }

                try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musica)) {
                    clipPrincipal = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, audioInputStream.getFormat()));
                    clipPrincipal.open(audioInputStream);
                    clipPrincipal.loop(Clip.LOOP_CONTINUOUSLY); // Reproduce en bucle
                    clipPrincipal.start(); // Inicia la reproducción
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

    public void detenerMusicaPrincipal() {
        if (clipPrincipal != null && clipPrincipal.isRunning()) {
        	clipPrincipal.stop();
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

    public void detenerMusicaBoton() {
        if (clipBoton != null && clipBoton.isRunning()) {
        	clipBoton.stop();
        }
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

    public void detenerMusicaClick() {
        if (clipClick != null && clipClick.isRunning()) {
        	clipClick.stop();
        }
    }
}