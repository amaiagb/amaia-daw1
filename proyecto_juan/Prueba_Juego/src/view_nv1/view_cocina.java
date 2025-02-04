package view_nv1;

import java.awt.Color;  

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import view_respuestas.respuesta_madre;
import view_respuestas.respuesta_madre2;
import view_respuestas.respuesta_madre3;
import view_respuestas.respuesta_nina;
import view_respuestas.respuesta_nina2;
import view_respuestas.respuesta_nina3;
import view_respuestas.respuesta_padre;
import view_respuestas.respuesta_padre2;
import view_respuestas.respuesta_padre3;

import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class view_cocina extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
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




	
	public view_cocina() {
		this.contadorPreguntaPadre = contadorPreguntaPadre;
		this.contadorPadre = contadorPadre;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1100, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
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

		// Borde redondeado y grueso
		Border roundedBorder = new LineBorder(Color.BLACK, 3, true);
		
		JButton sala_Button = new JButton("<");
		sala_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirMusicaBoton();
				dispose();
				new view_sala();
			}
		});
		sala_Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		sala_Button.setBounds(10, 317, 46, 69);
		contentPane.add(sala_Button);
		
		dialogo_textPane = new JTextPane();
		dialogo_textPane.setEditable(false);
		dialogo_textPane.setBounds(310, 580, 605, 120);
		contentPane.add(dialogo_textPane);
		
		JLabel fondo_Label = new JLabel("");
		fondo_Label.setIcon(new ImageIcon("D:\\zImages\\cocina.jpg"));
		fondo_Label.setBounds(0, 0, 1084, 711);
		contentPane.add(fondo_Label);
		
		JButton padre_Button = new JButton("");
		padre_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasarPreguntaPadre();
				  
				  
				  Timer timer = new Timer(4000, new ActionListener() {
				        @Override
				        public void actionPerformed(ActionEvent e) {
						    pasarFrasePadre();

				        }
				    });
				    timer.setRepeats(false); // Asegurarse de que el temporizador solo se ejecute una vez
				    timer.start(); // Iniciar el temporizador
				    pasarNivel();

				   

			    
			}
		});
		padre_Button.setBounds(175, 176, 125, 481);
		padre_Button.setOpaque(true); 
		padre_Button.setContentAreaFilled(false); 
		padre_Button.setBorderPainted(false); 
		contentPane.add(padre_Button);
		
		JButton madre_Button = new JButton("");
		madre_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  try {
			            StyledDocument doc = dialogo_textPane.getStyledDocument();
			            doc.insertString(doc.getLength(), "Que tal cariño, ¿Todo bien?, tienes ahi el desayuno, come rapido que se enfria, venga, que tienes que llegar con tiempo.\n", null);
			        } catch (BadLocationException ex) {
			            ex.printStackTrace();
			        }
				
				  Timer timer = new Timer(3000, new ActionListener() {
				        @Override
				        public void actionPerformed(ActionEvent e) {
				            // Abrir una nueva ventana
				            new respuesta_madre(); // Cambia esto al nombre de tu ventana
				        }
				    });
				    timer.setRepeats(false); // Asegurarse de que el temporizador solo se ejecute una vez
				    timer.start(); // Iniciar el temporizador
				    pasarNivel();

			}
		});
		madre_Button.setBounds(806, 295, 109, 284);
		madre_Button.setOpaque(true); 
		madre_Button.setContentAreaFilled(false); 
		madre_Button.setBorderPainted(false); 
		contentPane.add(madre_Button);
		
		JButton nina_Button = new JButton("");
		nina_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  try {
			            StyledDocument doc = dialogo_textPane.getStyledDocument();
			            doc.insertString(doc.getLength(), "Hholaa!!, has visto mi regalo, jijijijiji.\n", null);
			        } catch (BadLocationException ex) {
			            ex.printStackTrace();
			        }
				  nina_Button.setEnabled(false); // Deshabilitar el botón
				  
				  Timer timer = new Timer(3000, new ActionListener() {
				        @Override
				        public void actionPerformed(ActionEvent e) {
				            // Abrir una nueva ventana
				            new respuesta_nina(); // Cambia esto al nombre de tu ventana
				        }
				    });
				    timer.setRepeats(false); // Asegurarse de que el temporizador solo se ejecute una vez
				    timer.start(); // Iniciar el temporizador
				    
				    pasarNivel();
			    }
			
			
		});
		nina_Button.setBounds(342, 317, 84, 264);
		nina_Button.setOpaque(true); 
		nina_Button.setContentAreaFilled(false); 
		nina_Button.setBorderPainted(false); 
		contentPane.add(nina_Button);
		
		reproducirMusicaPrincipal();
		
		setVisible(true);
		
	}
	public void pasarNivel() {
		contador++;
		if (contador == 9) {
			dispose();
			new view_pasoCocina();
		}
	}
	
	public void pasarPreguntaPadre() {
		contadorPreguntaPadre++;
		if (contadorPreguntaPadre == 1) {
			try {
		        StyledDocument doc = dialogo_textPane.getStyledDocument();
		        doc.insertString(doc.getLength(), "Hombreeeeee, mi niño favorito, ¡¿Que?! con ganas de ir a clase, se que no, igual que yo al trabajo JAUJAUSJAUSJAUJSUA.\n", null);
		    } catch (BadLocationException ex) {
		        ex.printStackTrace();
		    }
		}if (contadorPreguntaPadre==2){
			try {
		        StyledDocument doc = dialogo_textPane.getStyledDocument();
		        doc.insertString(doc.getLength(), "Hijo, ya que estas aqui, hazme un favor, ve al garaje y traeme mi caja de herramientas porfavor, creo que la deje cerca del coche\n", null);
		    } catch (BadLocationException ex) {
		        ex.printStackTrace();
		    }
		}if (contadorPreguntaPadre==3){
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
