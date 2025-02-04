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
	private JButton nina_Button;
	private JButton btnOpcion1;
	private JButton btnOpcion2;
	private JButton btnOpcion3;
	
	public Cocina(Ventana ventana) {
		setBounds(0, 0, 1100, 750);
		setLayout(null);
		
		this.ventana = ventana;
		mensajes = ventana.getPanelTextos();
		
		// Borde redondeado y grueso
				Border roundedBorder = new LineBorder(Color.BLACK, 3, true);
				
				JButton sala_Button = new JButton("<");
				sala_Button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						reproducirMusicaBoton();
						ventana.getCardLayout().show(ventana.getPanelPrincipal(), "Salon");
					}
				});
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
				
				btnOpcion3 = new JButton("");
				btnOpcion3.setBounds(750,90,300,40);
				btnOpcion3.setBackground(Color.ORANGE);
				mensajes.add(btnOpcion3);
				btnOpcion3.setVisible(false);
				
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
				
				nina_Button = new JButton("");
				nina_Button.setBounds(342, 317, 84, 264);
				nina_Button.setOpaque(true); 
				nina_Button.setContentAreaFilled(false); 
				nina_Button.setBorderPainted(false); 
				add(nina_Button);
				
				JLabel fondo_Label = new JLabel("");
				fondo_Label.setIcon(new ImageIcon("resources\\images\\cocina.jpg"));
				fondo_Label.setBounds(0, 0, 1084, 711);
				add(fondo_Label);
				

				padre_Button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pasarPreguntaPadre();
						pasarNivel(); // Contador para desbloquear salida
					}
				});

				madre_Button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						pasarPreguntaMadre();
						//pasarNivel();

					}
				});
				
				nina_Button.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						nina_Button.setEnabled(false); // Deshabilitar el botón
						pasarNivel();
				    }
					
					
				});
				
				btnOpcion1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(contadorPreguntaPadre == 1) {
							pasarPreguntaPadre();
						}else if(contadorPreguntaPadre == 2) {
							mensajes.setVisible(false);
							btnOpcion1.setVisible(false);
							btnOpcion2.setVisible(false);
							btnOpcion3.setVisible(false);
						}
						padre_Button.setEnabled(true);
					}
				});
				btnOpcion2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(contadorPreguntaPadre == 1) {
							pasarPreguntaPadre();
						}else if(contadorPreguntaPadre == 2) {
							mensajes.setVisible(false);
							btnOpcion1.setVisible(false);
							btnOpcion2.setVisible(false);
							btnOpcion3.setVisible(false);
						}
						padre_Button.setEnabled(true);
					}
				});
				btnOpcion3.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(contadorPreguntaPadre == 1) {
							pasarPreguntaPadre();
						}else if(contadorPreguntaPadre == 2) {
							mensajes.setVisible(false);
							btnOpcion1.setVisible(false);
							btnOpcion2.setVisible(false);
							btnOpcion3.setVisible(false);
						}
						padre_Button.setEnabled(true);
					}
				});
					
				reproducirMusicaPrincipal();
				
				setVisible(true);
				
			}

			public void pasarNivel() {
				contador++;
				if (contador == 9) {
					//dispose();
					//new view_pasoCocina();
				}
			}
			
			public void pasarPreguntaPadre() {
				contadorPreguntaPadre++;
				System.out.println(contadorPreguntaPadre);
				if (contadorPreguntaPadre == 1) {
					
				   dialogo_textPane.setText("Hombreeeeee, mi niño favorito, ¡¿Que?! con ganas de ir a clase, se que no, igual que yo al trabajo JAUJAUSJAUSJAUJSUA.\n");
				   btnOpcion1.setText("Ay, qué sueño tengo");
				   btnOpcion2.setText("Egun on aita!");
				   btnOpcion3.setText("Zzzzz");
				   btnOpcion1.setVisible(true);
				   btnOpcion2.setVisible(true);
				   btnOpcion3.setVisible(true);
				   padre_Button.setEnabled(false);
				    
				}else if (contadorPreguntaPadre==2){
					padre_Button.setEnabled(false);
					dialogo_textPane.setText("Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					btnOpcion1.setText("¡Claro, ahora mismo!");
					btnOpcion2.setText("No me apetece mucho");
					btnOpcion3.setText("Zzzzz");
					btnOpcion1.setVisible(true);
					btnOpcion2.setVisible(true);
					btnOpcion3.setVisible(true);
					//padre_Button.setEnabled(false);
					
				}else if (contadorPreguntaPadre==3){
					mensajes.setVisible(true);
					dialogo_textPane.setText("Muchas gracias, cuando vuelvas del colegio, te llevo al cine como recompensa, que seguro ya habre arreglado el coche\n");
				} else {
					mensajes.setVisible(false);
				}

			}
			public void pasarPreguntaMadre() {
				contadorPreguntaMadre++;
				if (contadorPreguntaMadre == 1) {
					
				   dialogo_textPane.setText("Ama: Hombreeeeee, mi niño favorito, ¡¿Que?! con ganas de ir a clase, se que no, igual que yo al trabajo JAUJAUSJAUSJAUJSUA.\n");
				   btnOpcion1.setText("Ay, qué sueño tengo");
				   btnOpcion2.setText("Egun on aita!");
				   btnOpcion3.setText("Zzzzz");
				   btnOpcion1.setVisible(true);
				   btnOpcion2.setVisible(true);
				   btnOpcion3.setVisible(true);
				    
				}else if (contadorPreguntaMadre==2){
					dialogo_textPane.setText("Ama: Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n");
					btnOpcion1.setText("¡Claro, ahora mismo!");
					btnOpcion2.setText("No me apetece mucho");
					btnOpcion3.setText("Zzzzz");
					btnOpcion1.setVisible(true);
					btnOpcion2.setVisible(true);
					btnOpcion3.setVisible(true);
					
				}else if (contadorPreguntaMadre==3){
					mensajes.setVisible(true);
					dialogo_textPane.setText("Ama: Muchas gracias, cuando vuelvas del colegio, te llevo al cine como recompensa, que seguro ya habre arreglado el coche\n");
				} else {
					mensajes.setVisible(false);
				}

			}
			/*
			public void pasarPreguntaMadre() {
				contadorPreguntaMadre++;
				if (contadorPreguntaMadre == 1) {
					try {
				        StyledDocument doc = dialogo_textPane.getStyledDocument();
				        doc.insertString(doc.getLength(), "Hombreeeeee, mi niño favorito, ¡¿Que?! con ganas de ir a clase, se que no, igual que yo al trabajo JAUJAUSJAUSJAUJSUA.\n", null);
				    } catch (BadLocationException ex) {
				        ex.printStackTrace();
				    }
				}if (contadorPreguntaMadre==2){
					try {
				        StyledDocument doc = dialogo_textPane.getStyledDocument();
				        doc.insertString(doc.getLength(), "Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n", null);
				    } catch (BadLocationException ex) {
				        ex.printStackTrace();
				    }
				}if (contadorPreguntaMadre==3){
					try {
				        StyledDocument doc = dialogo_textPane.getStyledDocument();
				        doc.insertString(doc.getLength(), "Muchas gracias, cuando vuelvas del colegio, te llevo al cine como recompensa, que seguro ya habre arreglado el coche\n", null);
				    } catch (BadLocationException ex) {
				        ex.printStackTrace();
				    }
				}
			}
			*/
			public void pasarPreguntaHija() {
				contadorPreguntaHija++;
				if (contadorPreguntaHija == 1) {
					try {
				        StyledDocument doc = dialogo_textPane.getStyledDocument();
				        doc.insertString(doc.getLength(), "Hombreeeeee, mi niño favorito, ¡¿Que?! con ganas de ir a clase, se que no, igual que yo al trabajo JAUJAUSJAUSJAUJSUA.\n", null);
				    } catch (BadLocationException ex) {
				        ex.printStackTrace();
				    }
				}if (contadorPreguntaHija==2){
					try {
				        StyledDocument doc = dialogo_textPane.getStyledDocument();
				        doc.insertString(doc.getLength(), "Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n", null);
				    } catch (BadLocationException ex) {
				        ex.printStackTrace();
				    }
				}if (contadorPreguntaHija==3){
					try {
				        StyledDocument doc = dialogo_textPane.getStyledDocument();
				        doc.insertString(doc.getLength(), "Muchas gracias, cuando vuelvas del colegio, te llevo al cine como recompensa, que seguro ya habre arreglado el coche\n", null);
				    } catch (BadLocationException ex) {
				        ex.printStackTrace();
				    }
				}

			}
	
			public void pasarFrasePadre() {
				contadorPadre++;
				if (contadorPadre == 1) {
					new respuesta_padre();
				}if (contadorPadre==2){
					new respuesta_padre2();
				}if (contadorPadre==3){
				new respuesta_padre3();
				}
			}
			public void pasarFraseMadre() {
				contadorMadre++;
				if (contadorMadre == 1) {
					new respuesta_madre();
				}if (contadorMadre==2){
					new respuesta_madre2();
				}if (contadorMadre==3){
				new respuesta_madre3();
				}
			}
			public void pasarFraseHija() {
				contadorHija++;
				if (contadorHija == 1) {
					new respuesta_nina();
				}if (contadorHija==2){
					new respuesta_nina2();
				}if (contadorHija==3){
				new respuesta_nina3();
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
