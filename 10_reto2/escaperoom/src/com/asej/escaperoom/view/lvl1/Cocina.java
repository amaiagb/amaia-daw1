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
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.Timer;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
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
	private JTextPane txtDialogo;
	private Clip clipPrincipal;
	private Clip clipBoton;
	private Clip clipClick;
	private Ventana ventana;
	private JPanel mensajes;
	private JButton btnPadre;
	private JButton btnMadre;
	private JButton btnHija;
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
		ventana.getPanelTextos().setVisible(false);
		System.out.println(ventana.getPanelTextos().isVisible());
		
		Border roundedBorder = new LineBorder(Color.BLACK, 3, true);
		
		JButton btnSalon = new JButton("<");
		btnSalon.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSalon.setBounds(10, 317, 46, 69);
		add(btnSalon);
		
		
		ventana.getPanelTextos().setBounds(0,640,0,10);
		/*
		ventana.getTxtDialogo().setBounds(0,10,1084,70);
		*/
		
		mensajes = new JPanel();
		mensajes.setBounds(0, 600, 1084, 130);
		mensajes.setBackground(Color.DARK_GRAY);
		add(mensajes, JLayeredPane.PALETTE_LAYER);
		mensajes.setLayout(null);
		
		txtDialogo = new JTextPane();
		txtDialogo.setEditable(false);
		txtDialogo.setOpaque(false);
		txtDialogo.setAlignmentX(CENTER_ALIGNMENT);
		txtDialogo.setForeground(Color.white);
		txtDialogo.setBounds(0, 0, 745, 60);
		mensajes.add(txtDialogo);
		StyledDocument doc = txtDialogo.getStyledDocument();
	    SimpleAttributeSet center = new SimpleAttributeSet();
	    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
	    doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
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
		btnPadre = new JButton("");
		btnPadre.setBounds(175, 176, 125, 481);
		btnPadre.setOpaque(true); 
		btnPadre.setContentAreaFilled(false); 
		btnPadre.setBorderPainted(false); 
		add(btnPadre);
		
		btnMadre = new JButton("");
		btnMadre.setBounds(806, 295, 109, 284);
		btnMadre.setOpaque(true); 
		btnMadre.setContentAreaFilled(false); 
		btnMadre.setBorderPainted(false); 
		add(btnMadre);
		
		btnHija = new JButton("");
		btnHija.setBounds(342, 317, 84, 264);
		btnHija.setOpaque(true); 
		btnHija.setContentAreaFilled(false); 
		btnHija.setBorderPainted(false); 
		add(btnHija);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("resources\\images\\cocina.jpg"));
		lblFondo.setBounds(0, 0, 1084, 711);
		add(lblFondo);

		btnSalon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!btnOpcion1.isVisible()) {
					reproducirMusicaBoton();
					ventana.showEscena("Salon");
				}
			}
		});

		btnPadre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarPreguntaPadre();
			}
		});

		btnMadre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarPreguntaMadre();
			}
		});
		
		btnHija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarPreguntaHija();
		    }	
		});
		
		btnOpcion1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (mensajePantalla.equals("padre")){
					btnPadre.setEnabled(false);
					txtDialogo.setText("Aita: Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					btnOpcion1.setText("¡Claro, ahora mismo!");
					btnOpcion2.setText("No me apetece mucho");
					//btnOpcion3.setText("Zzzzz");
					btnOpcion1.setVisible(true);
					btnOpcion2.setVisible(true);
					//btnOpcion3.setVisible(true);
					mensajePantalla = "";
					
				}else if(mensajePantalla.equals("madre")){
					btnMadre.setEnabled(false);
					txtDialogo.setText("Ama: Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					btnOpcion1.setText("¡Claro, ahora mismo!");
					btnOpcion2.setText("No me apetece mucho");
					//btnOpcion3.setText("Zzzzz");
					btnOpcion1.setVisible(true);
					btnOpcion2.setVisible(true);
					//btnOpcion3.setVisible(true);
					mensajePantalla = "";
					
				}else if(mensajePantalla.equals("hija")){
					btnHija.setEnabled(false);
					txtDialogo.setText("Niña: Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
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
					btnPadre.setEnabled(true);
					btnMadre.setEnabled(true);
					btnHija.setEnabled(true);
				}
			}
		});
		btnOpcion2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mensajePantalla.equals("padre")){
					btnPadre.setEnabled(false);
					txtDialogo.setText("Aita: Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					btnOpcion1.setText("¡Claro, ahora mismo!");
					btnOpcion2.setText("No me apetece mucho");
					//btnOpcion3.setText("Zzzzz");
					btnOpcion1.setVisible(true);
					btnOpcion2.setVisible(true);
					//btnOpcion3.setVisible(true);
					mensajePantalla = "";
					
				}else if(mensajePantalla.equals("madre")){
					btnMadre.setEnabled(false);
					txtDialogo.setText("Ama: Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					btnOpcion1.setText("¡Claro, ahora mismo!");
					btnOpcion2.setText("No me apetece mucho");
					//btnOpcion3.setText("Zzzzz");
					btnOpcion1.setVisible(true);
					btnOpcion2.setVisible(true);
					//btnOpcion3.setVisible(true);
					mensajePantalla = "";
					
				}else if(mensajePantalla.equals("hija")){
					btnHija.setEnabled(false);
					txtDialogo.setText("Niña: Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
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
					btnPadre.setEnabled(true);
					btnMadre.setEnabled(true);
					btnHija.setEnabled(true);
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
		System.out.println("padre");
		
		if (!padrePeticionHecha) {
		   txtDialogo.setText("Aita: Hombreeeeee, mi niño favorito, ¡¿Que?! con ganas de ir a clase, se que no, igual que yo al trabajo JAUJAUSJAUSJAUJSUA.\n");
		   btnOpcion1.setText("Ay, qué sueño tengo");
		   btnOpcion2.setText("Egun on aita!");
		   //btnOpcion3.setText("Zzzzz");
		   btnOpcion1.setVisible(true);
		   btnOpcion2.setVisible(true);
		   //btnOpcion3.setVisible(true);
		   btnPadre.setEnabled(false);
		   btnMadre.setEnabled(false);
		   btnHija.setEnabled(false);
		   padrePeticionHecha = true;
		   mensajePantalla= "padre";
		   
		}else if (padrePeticionHecha && !objetoPadre ){
			mensajes.setVisible(true);
			txtDialogo.setText("Aita: Sigo esperando que me traigas la caja de herramientas\n");
			
		} else if (padrePeticionHecha && objetoPadre ){ //Entregar herramientas a padre
			mensajes.setVisible(true);
			txtDialogo.setText("Aita: Muchas gracias, cuando vuelvas del colegio, te llevo al cine como recompensa, que seguro ya habre arreglado el coche\n");
			btnPadre.setVisible(false);
		}
	}
	
	public void pasarPreguntaMadre() {
		if (!madrePeticionHecha) {
		   txtDialogo.setText("Ama: Hombreeeeee, mi niño favorito, ¡¿Que?! con ganas de ir a clase, se que no, igual que yo al trabajo JAUJAUSJAUSJAUJSUA.\n");
		   btnOpcion1.setText("Ay, qué sueño tengo");
		   btnOpcion2.setText("Egun on aita!");
		   //btnOpcion3.setText("Zzzzz");
		   btnOpcion1.setVisible(true);
		   btnOpcion2.setVisible(true);
		   //btnOpcion3.setVisible(true);
		   btnPadre.setEnabled(false);
		   btnMadre.setEnabled(false);
		   btnHija.setEnabled(false);
		   madrePeticionHecha = true;
		   mensajePantalla= "madre";
		   
		}else if (madrePeticionHecha && !objetoMadre ){
			mensajes.setVisible(true);
			txtDialogo.setText("Ama: Sigo esperando que me traigas la caja de herramientas\n");
			
		} else if (madrePeticionHecha  && objetoMadre ){ //Entregar objeto a madre
			mensajes.setVisible(true);
			txtDialogo.setText("Ama: Muchas gracias, cuando vuelvas del colegio, te llevo al cine como recompensa, que seguro ya habre arreglado el coche\n");
			btnMadre.setVisible(false);
		}
	}

	public void pasarPreguntaHija() {
		if (!hijaPeticionHecha) {
		   txtDialogo.setText("Hija: Hombreeeeee, mi niño favorito, ¡¿Que?! con ganas de ir a clase, se que no, igual que yo al trabajo JAUJAUSJAUSJAUJSUA.\n");
		   btnOpcion1.setText("Ay, qué sueño tengo");
		   btnOpcion2.setText("Egun on aita!");
		   //btnOpcion3.setText("Zzzzz");
		   btnOpcion1.setVisible(true);
		   btnOpcion2.setVisible(true);
		   //btnOpcion3.setVisible(true);
		   btnPadre.setEnabled(false);
		   btnMadre.setEnabled(false);
		   btnHija.setEnabled(false);
		   hijaPeticionHecha = true;
		   mensajePantalla= "hija";
		   
		}else if (hijaPeticionHecha && !objetoHija ){
			mensajes.setVisible(true);
			txtDialogo.setText("Hija: Sigo esperando que me traigas la caja de herramientas\n");
			
		} else if (hijaPeticionHecha  && objetoHija ){ //Entregar sopa de letras a hija
			mensajes.setVisible(true);
			txtDialogo.setText("Hija: Muchas gracias, cuando vuelvas del colegio, te llevo al cine como recompensa, que seguro ya habre arreglado el coche\n");
			btnHija.setVisible(false);
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
