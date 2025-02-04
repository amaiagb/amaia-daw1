package com.asej.escaperoom.view.lvl1;

import java.awt.Color;
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
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import com.asej.escaperoom.view.Ventana;
import com.asej.escaperoom.view.lvl1.dialogos.respuesta_madre;
import com.asej.escaperoom.view.lvl1.dialogos.respuesta_madre2;
import com.asej.escaperoom.view.lvl1.dialogos.respuesta_madre3;
import com.asej.escaperoom.view.lvl1.dialogos.respuesta_nina;
import com.asej.escaperoom.view.lvl1.dialogos.respuesta_nina2;
import com.asej.escaperoom.view.lvl1.dialogos.respuesta_nina3;
import com.asej.escaperoom.view.lvl1.dialogos.respuesta_padre;
import com.asej.escaperoom.view.lvl1.dialogos.respuesta_padre2;
import com.asej.escaperoom.view.lvl1.dialogos.respuesta_padre3;

public class Cocina extends JPanel {

	private JTextField tiempo_textField;
	private JTextPane textPane;
	private int contador = 0;
	private int contadorPadre =0;
	private int contadorMadre = 0;
	private int contadorHija = 0;
	private int contadorPreguntaPadre =0;
	private int contadorPreguntaMadre =0;
	private int contadorPreguntaHija =0;
	private int segundos=3600;
	private JTextPane dialogo_textPane;
	private Clip clipPrincipal;
	private Clip clipBoton;
	private Clip clipClick;
	private Ventana ventana;
	private JPanel mensajes;
	private JButton padre_Button;
	private JButton madre_Button;
	private JButton hija_Button;
	private JButton btnOpcion1;
	private JButton btnOpcion2;
	private JButton btnOpcion3;
	private boolean padrePeticionHecha = false;
	private boolean madrePeticionHecha = false;
	private boolean hijaPeticionHecha = false;
	private boolean objetoPadre = true;
	private boolean objetoMadre = false;
	private boolean objetoHija = true;
	private String mensajePantalla = "";
	private final int OBJETIVO_MISIONES = 4; //encontrar mochila, entregar objetos a padre, madre e hija.
	private int misionesCompletadas = 0;
	
	
	public Cocina(Ventana ventana) {
		setBounds(0, 0, 1100, 750);
		setLayout(null);
		
		this.ventana = ventana;
		mensajes = ventana.getPanelTextos();
		
		// Borde redondeado y grueso
		Border roundedBorder = new LineBorder(Color.BLACK, 3, true);
		
		JButton sala_Button = new JButton("<");
		sala_Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		sala_Button.setBounds(10, 317, 46, 69);
		add(sala_Button);
		
		dialogo_textPane = new JTextPane();
		dialogo_textPane.setEditable(false);
		dialogo_textPane.setOpaque(false);
		dialogo_textPane.setAlignmentX(CENTER_ALIGNMENT);
		dialogo_textPane.setForeground(Color.white);
		dialogo_textPane.setBounds(0, 45, 745, 60);
		mensajes.add(dialogo_textPane);
		
		btnOpcion1 = new JButton("");
		btnOpcion1.setBounds(750,0,300,40);
		btnOpcion1.setBackground(Color.ORANGE);
		mensajes.add(btnOpcion1);
		btnOpcion1.setVisible(false);
		
		btnOpcion2 = new JButton("");
		btnOpcion2.setBounds(750,45,300,40);
		btnOpcion2.setBackground(Color.ORANGE);
		mensajes.add(btnOpcion2);
		btnOpcion2.setVisible(false);
		/*
		btnOpcion3 = new JButton("");
		btnOpcion3.setBounds(750,90,300,40);
		btnOpcion3.setBackground(Color.ORANGE);
		mensajes.add(btnOpcion3);
		btnOpcion3.setVisible(false);
		*/
		padre_Button = new JButton("");
		padre_Button.setBounds(175, 176, 125, 481);
		padre_Button.setOpaque(true); 
		padre_Button.setContentAreaFilled(false); 
		padre_Button.setBorderPainted(false); 
		add(padre_Button);
		
		madre_Button = new JButton("");
		madre_Button.setBounds(806, 295, 109, 284);
		madre_Button.setOpaque(true); 
		madre_Button.setContentAreaFilled(false); 
		madre_Button.setBorderPainted(false); 
		add(madre_Button);
		
		hija_Button = new JButton("");
		hija_Button.setBounds(342, 317, 84, 264);
		hija_Button.setOpaque(true); 
		hija_Button.setContentAreaFilled(false); 
		hija_Button.setBorderPainted(false); 
		add(hija_Button);
		
		JLabel fondo_Label = new JLabel("");
		fondo_Label.setIcon(new ImageIcon("resources\\images\\cocina.jpg"));
		fondo_Label.setBounds(0, 0, 1084, 711);
		add(fondo_Label);

		sala_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(!btnOpcion1.isVisible()) {
					reproducirMusicaBoton();
					ventana.getCardLayout().show(ventana.getPanelPrincipal(), "Salon");
				}
				
			}
		});

		padre_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarPreguntaPadre();
			}
		});

		madre_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarPreguntaMadre();
			}
		});
		
		hija_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarPreguntaHija();
		    }	
		});
		
		btnOpcion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (mensajePantalla.equals("padre")){
					padre_Button.setEnabled(false);
					dialogo_textPane.setText("Aita: Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					btnOpcion1.setText("¡Claro, ahora mismo!");
					btnOpcion2.setText("No me apetece mucho");
					//btnOpcion3.setText("Zzzzz");
					btnOpcion1.setVisible(true);
					btnOpcion2.setVisible(true);
					//btnOpcion3.setVisible(true);
					mensajePantalla = "";
					
				}else if(mensajePantalla.equals("madre")){
					madre_Button.setEnabled(false);
					dialogo_textPane.setText("Ama: Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					btnOpcion1.setText("¡Claro, ahora mismo!");
					btnOpcion2.setText("No me apetece mucho");
					//btnOpcion3.setText("Zzzzz");
					btnOpcion1.setVisible(true);
					btnOpcion2.setVisible(true);
					//btnOpcion3.setVisible(true);
					mensajePantalla = "";
					
				}else if(mensajePantalla.equals("hija")){
					hija_Button.setEnabled(false);
					dialogo_textPane.setText("Niña: Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					btnOpcion1.setText("¡Claro, ahora mismo!");
					btnOpcion2.setText("No me apetece mucho");
					//btnOpcion3.setText("Zzzzz");
					btnOpcion1.setVisible(true);
					btnOpcion2.setVisible(true);
					//btnOpcion3.setVisible(true);
					mensajePantalla = "";
					
				}else {
					mensajes.setVisible(false);
					btnOpcion1.setVisible(false);
					btnOpcion2.setVisible(false);
					//btnOpcion3.setVisible(false);
					padre_Button.setEnabled(true);
					madre_Button.setEnabled(true);
					hija_Button.setEnabled(true);
				}
			}
		});
		btnOpcion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mensajePantalla.equals("padre")){
					padre_Button.setEnabled(false);
					dialogo_textPane.setText("Aita: Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					btnOpcion1.setText("¡Claro, ahora mismo!");
					btnOpcion2.setText("No me apetece mucho");
					//btnOpcion3.setText("Zzzzz");
					btnOpcion1.setVisible(true);
					btnOpcion2.setVisible(true);
					//btnOpcion3.setVisible(true);
					mensajePantalla = "";
					
				}else if(mensajePantalla.equals("madre")){
					madre_Button.setEnabled(false);
					dialogo_textPane.setText("Ama: Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					btnOpcion1.setText("¡Claro, ahora mismo!");
					btnOpcion2.setText("No me apetece mucho");
					//btnOpcion3.setText("Zzzzz");
					btnOpcion1.setVisible(true);
					btnOpcion2.setVisible(true);
					//btnOpcion3.setVisible(true);
					mensajePantalla = "";
					
				}else if(mensajePantalla.equals("hija")){
					hija_Button.setEnabled(false);
					dialogo_textPane.setText("Niña: Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					btnOpcion1.setText("¡Claro, ahora mismo!");
					btnOpcion2.setText("No me apetece mucho");
					//btnOpcion3.setText("Zzzzz");
					btnOpcion1.setVisible(true);
					btnOpcion2.setVisible(true);
					//btnOpcion3.setVisible(true);
					mensajePantalla = "";
					
				}else {
					mensajes.setVisible(false);
					btnOpcion1.setVisible(false);
					btnOpcion2.setVisible(false);
					//btnOpcion3.setVisible(false);
					padre_Button.setEnabled(true);
					madre_Button.setEnabled(true);
					hija_Button.setEnabled(true);
				}
			}
		});
		/*
		btnOpcion3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mensajePantalla.equals("padre")){
					padre_Button.setEnabled(false);
					dialogo_textPane.setText("Aita: Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					btnOpcion1.setText("¡Claro, ahora mismo!");
					btnOpcion2.setText("No me apetece mucho");
					btnOpcion3.setText("Zzzzz");
					btnOpcion1.setVisible(true);
					btnOpcion2.setVisible(true);
					btnOpcion3.setVisible(true);
					mensajePantalla = "";
					
				}else if(mensajePantalla.equals("madre")){
					madre_Button.setEnabled(false);
					dialogo_textPane.setText("Ama: Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					btnOpcion1.setText("¡Claro, ahora mismo!");
					btnOpcion2.setText("No me apetece mucho");
					btnOpcion3.setText("Zzzzz");
					btnOpcion1.setVisible(true);
					btnOpcion2.setVisible(true);
					btnOpcion3.setVisible(true);
					mensajePantalla = "";
					
				}else if(mensajePantalla.equals("hija")){
					hija_Button.setEnabled(false);
					dialogo_textPane.setText("Niña: Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					btnOpcion1.setText("¡Claro, ahora mismo!");
					btnOpcion2.setText("No me apetece mucho");
					btnOpcion3.setText("Zzzzz");
					btnOpcion1.setVisible(true);
					btnOpcion2.setVisible(true);
					btnOpcion3.setVisible(true);
					mensajePantalla = "";
					
				}else {
					mensajes.setVisible(false);
					btnOpcion1.setVisible(false);
					btnOpcion2.setVisible(false);
					btnOpcion3.setVisible(false);
					padre_Button.setEnabled(true);
					madre_Button.setEnabled(true);
					hija_Button.setEnabled(true);
				}
			}
		});
		*/
		reproducirMusicaPrincipal();
		setVisible(true);
		
	}
	
	public void pasarPreguntaPadre() {
		if (!padrePeticionHecha) {
		   dialogo_textPane.setText("Aita: Hombreeeeee, mi niño favorito, ¡¿Que?! con ganas de ir a clase, se que no, igual que yo al trabajo JAUJAUSJAUSJAUJSUA.\n");
		   btnOpcion1.setText("Ay, qué sueño tengo");
		   btnOpcion2.setText("Egun on aita!");
		   //btnOpcion3.setText("Zzzzz");
		   btnOpcion1.setVisible(true);
		   btnOpcion2.setVisible(true);
		   //btnOpcion3.setVisible(true);
		   padre_Button.setEnabled(false);
		   madre_Button.setEnabled(false);
		   hija_Button.setEnabled(false);
		   padrePeticionHecha = true;
		   mensajePantalla= "padre";
		   
		}else if (padrePeticionHecha && !objetoPadre ){
			mensajes.setVisible(true);
			dialogo_textPane.setText("Aita: Sigo esperando que me traigas la caja de herramientas\n");
			
		} else if (padrePeticionHecha && objetoPadre ){ //Entregar herramientas a padre
			mensajes.setVisible(true);
			dialogo_textPane.setText("Aita: Muchas gracias, cuando vuelvas del colegio, te llevo al cine como recompensa, que seguro ya habre arreglado el coche\n");
			padre_Button.setVisible(false);
		}
	}
	
	public void pasarPreguntaMadre() {
		if (!madrePeticionHecha) {
		   dialogo_textPane.setText("Ama: Hombreeeeee, mi niño favorito, ¡¿Que?! con ganas de ir a clase, se que no, igual que yo al trabajo JAUJAUSJAUSJAUJSUA.\n");
		   btnOpcion1.setText("Ay, qué sueño tengo");
		   btnOpcion2.setText("Egun on aita!");
		   //btnOpcion3.setText("Zzzzz");
		   btnOpcion1.setVisible(true);
		   btnOpcion2.setVisible(true);
		   //btnOpcion3.setVisible(true);
		   padre_Button.setEnabled(false);
		   madre_Button.setEnabled(false);
		   hija_Button.setEnabled(false);
		   madrePeticionHecha = true;
		   mensajePantalla= "madre";
		   
		}else if (madrePeticionHecha && !objetoMadre ){
			mensajes.setVisible(true);
			dialogo_textPane.setText("Ama: Sigo esperando que me traigas la caja de herramientas\n");
			
		} else if (madrePeticionHecha  && objetoMadre ){ //Entregar objeto a madre
			mensajes.setVisible(true);
			dialogo_textPane.setText("Ama: Muchas gracias, cuando vuelvas del colegio, te llevo al cine como recompensa, que seguro ya habre arreglado el coche\n");
			madre_Button.setVisible(false);
		}
	}

	public void pasarPreguntaHija() {
		if (!hijaPeticionHecha) {
		   dialogo_textPane.setText("Hija: Hombreeeeee, mi niño favorito, ¡¿Que?! con ganas de ir a clase, se que no, igual que yo al trabajo JAUJAUSJAUSJAUJSUA.\n");
		   btnOpcion1.setText("Ay, qué sueño tengo");
		   btnOpcion2.setText("Egun on aita!");
		   //btnOpcion3.setText("Zzzzz");
		   btnOpcion1.setVisible(true);
		   btnOpcion2.setVisible(true);
		   //btnOpcion3.setVisible(true);
		   padre_Button.setEnabled(false);
		   madre_Button.setEnabled(false);
		   hija_Button.setEnabled(false);
		   hijaPeticionHecha = true;
		   mensajePantalla= "hija";
		   
		}else if (hijaPeticionHecha && !objetoHija ){
			mensajes.setVisible(true);
			dialogo_textPane.setText("Hija: Sigo esperando que me traigas la caja de herramientas\n");
			
		} else if (hijaPeticionHecha  && objetoHija ){ //Entregar sopa de letras a hija
			mensajes.setVisible(true);
			dialogo_textPane.setText("Hija: Muchas gracias, cuando vuelvas del colegio, te llevo al cine como recompensa, que seguro ya habre arreglado el coche\n");
			hija_Button.setVisible(false);
		}
	}

	
	public void reproducirMusicaPrincipal() {
        if (clipPrincipal != null && clipPrincipal.isRunning()) {
            clipPrincipal.stop(); // Detén la música anterior si está sonando
        }

        new Thread(() -> {
            try {
                File musica = new File("D:\\music\\casa.wav");
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
