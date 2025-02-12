package com.asej.escaperoom.controlador;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Audio {

    private static Clip clipMusica;
    private static Clip clipEfectoSonido;
    public static final String BOTON = "boton.wav";
    public static final String COIN = "coin.wav";
    public static final String CLICK = "click.wav";
    public static final String RELOJ = "reloj.wav";
    public static final String COCHE = "coche.wav";
    public static final String ARMARIO = "armario.wav";
    public static final String ORDENADOR = "ordenador.wav";
    public static final String BOCATA = "bocata.wav";
    public static final String GATO = "gato.wav";
    public static final String PERRO = "perro.wav";
    public static final String LLAVE = "llave.wav";
    public static final String PAPEL = "papel.wav";
    public static final String TIJERAS = "tijeras.wav";
    public static final String ROCA = "roca.wav";
    public static final String ROCK = "rock.wav";
    public static final String PUERTA = "puerta.wav";
    public static final String TAQUILLA = "taquilla.wav";



    
    public static final String CANCION_PRINCIPAL = "op.wav";
    public static final String CANCION_NIVEL3 = "casa.wav";
    public static final String CANCION_NIVEL2 = "casa2.wav";
    public static final String CANCION_NIVEL1 = "casa3.wav";


    

	public static void reproducirMusica(String nombreArchivo) {
		
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
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
		
	}
	public static void detenerMusica() {
        if (clipMusica != null && clipMusica.isRunning()) {
        	clipMusica.stop();
        }
    }

	
	
	public static void reproducirEfectoSonido(String nombreArchivo) {

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

    public static void detenerEfectoSonido() {
        if (clipEfectoSonido != null && clipEfectoSonido.isRunning()) {
        	clipEfectoSonido.stop();
        }
    }
	
}
