package com.asej.escaperoom.controlador;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Audio {
	private static String musicaActual;
    private static Clip clipMusica;
    private static Clip clipEfectoSonido;
    public static final String BOTON = "boton.wav";
    public static final String COIN = "coin.wav";
    public static final String CLICK = "click.wav";
    public static final String RELOJ = "reloj.wav";
    public static final String COCHE = "coche.wav";
    public static final String ARMARIO = "armario.wav";
    public static final String CANCION_PRINCIPAL = "op.wav";
    public static boolean sonidoON = true;
	public static boolean musicaON = true;
	public static boolean efectosON = true;

	public static void reproducirMusica(String nombreArchivo) {
		if(musicaON) {
			if (clipMusica != null && clipMusica.isRunning()) {
				clipMusica.stop(); // Detén la música anterior si está sonando
	        }
			
	        new Thread(() -> { //para que se ejecute en segundo plano y no afecte a la interfaz gráfica
	            try {
	                File musica = new File("resources//audio//"+nombreArchivo);
	                if (!musica.exists()) {
	                    System.err.println("El archivo no existe: " + musica.getAbsolutePath());
	                    return;
	                }

	                try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musica)) {
	                    clipMusica = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, audioInputStream.getFormat()));
	                    clipMusica.open(audioInputStream);
	                    clipMusica.loop(Clip.LOOP_CONTINUOUSLY); // Reproduce en bucle
	                    clipMusica.start(); // Inicia la reproducción
	                    musicaActual = nombreArchivo;
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }).start();
		}
	}
	public static void detenerMusica() {
        if (clipMusica != null && clipMusica.isRunning()) {
        	clipMusica.stop();
        }
    }
	public static String obtenerCancionActual() {
		return musicaActual;
	}
	
	
	public static void reproducirEfectoSonido(String nombreArchivo) {
		if(efectosON) {
			if (clipEfectoSonido != null && clipEfectoSonido.isRunning()) {
	        	clipEfectoSonido.stop();
	        }
			
	        new Thread(() -> {
	            try {
	                File musica = new File("resources//audio//"+nombreArchivo);
	                if (!musica.exists()) {
	                    System.err.println("El archivo no existe: " + musica.getAbsolutePath());
	                    return;
	                }

	                try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musica)) {
	                	clipEfectoSonido = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, audioInputStream.getFormat()));
	                	clipEfectoSonido.open(audioInputStream);
	                	clipEfectoSonido.start();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }).start();
		}
        
    }

    public static void detenerEfectoSonido() {
        if (clipEfectoSonido != null && clipEfectoSonido.isRunning()) {
        	clipEfectoSonido.stop();
        }
    }
	
}
