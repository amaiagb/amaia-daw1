package view_nv1;

import java.awt.Color; 

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import games.SopaLetras;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionEvent;

public class view_sala extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tiempo_textField;
	private JTextPane textPane;
	private int contador = 0;
	private int segundos=3600;
    private JTextPane dialogo_textPane; // Declarar como atributo para poder modificarlo desde los botones
    private Clip clipBoton;
	private Clip clipClick;

	
	public view_sala() {
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
		
		JButton pasillo_button = new JButton("v");
		pasillo_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirMusicaBoton();
				dispose();
				new view_pasillo();
			}
		});
		pasillo_button.setBounds(516, 38, 46, 35);
		contentPane.add(pasillo_button);
		
		dialogo_textPane = new JTextPane(); // Inicializar el JTextPane
		dialogo_textPane.setEditable(false);
		dialogo_textPane.setBounds(310, 580, 605, 120);
		contentPane.add(dialogo_textPane);
		
		JButton garaje_button = new JButton(">");
		garaje_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirMusicaBoton();
				dispose();
				new view_cocina();
			}
		});
		garaje_button.setBounds(1028, 344, 46, 64);
		contentPane.add(garaje_button);
		
		JButton cocina_button = new JButton("<");
		cocina_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirMusicaBoton();
				dispose();
				new view_garaje( );
			}
		});
		cocina_button.setBounds(10, 344, 46, 64);
		contentPane.add(cocina_button);
		
		JButton sopaLetras_Button = new JButton("");
		sopaLetras_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new SopaLetras();
			}
		});
		sopaLetras_Button.setBounds(412, 563, 63, 15);
		sopaLetras_Button.setOpaque(true); 
		sopaLetras_Button.setContentAreaFilled(false); 
		sopaLetras_Button.setBorderPainted(false); 
		contentPane.add(sopaLetras_Button);
		
		JButton terraza2_Button = new JButton("");
		terraza2_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  actualizarDialogo("La otra terraza de la casa, tiene mejores vistas");
			}
		});
		terraza2_Button.setBounds(458, 211, 151, 329);
		terraza2_Button.setOpaque(true); 
		terraza2_Button.setContentAreaFilled(false); 
		terraza2_Button.setBorderPainted(false); 
		contentPane.add(terraza2_Button);
		
		JButton cuadro_Button = new JButton("");
		cuadro_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  actualizarDialogo("El cuadro favorito de mama, un dia casi lo rompo de un balonazo. Sentia la muerte sobre mis hombros");
			}
		});
		cuadro_Button.setBounds(107, 188, 39, 212);
		cuadro_Button.setOpaque(true); 
		cuadro_Button.setContentAreaFilled(false); 
		cuadro_Button.setBorderPainted(false); 
		contentPane.add(cuadro_Button);
		
		JButton sillon_Button = new JButton("");
		sillon_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  actualizarDialogo("Tiene la marca del culo de mi padre, ya le vale");
			}
		});
		sillon_Button.setBounds(607, 440, 116, 142);
		sillon_Button.setOpaque(true); 
		sillon_Button.setContentAreaFilled(false); 
		sillon_Button.setBorderPainted(false); 
		contentPane.add(sillon_Button);
		
		JButton sofa_Button = new JButton("");
		sofa_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcion = JOptionPane.showConfirmDialog(
                        view_sala.this,
                        "¿Te apetece tumbarte?",
                        "Confirmación",
                        JOptionPane.YES_NO_OPTION
                );

                if (opcion == JOptionPane.YES_OPTION) {
                    System.exit(0); // Cierra toda la aplicación
                } else if (opcion == JOptionPane.NO_OPTION) {
                    actualizarDialogo("No es momento para tumbarse, mejor cuando vuelva");
                }
            }
        });
		sofa_Button.setBounds(0, 450, 309, 250);
		sofa_Button.setOpaque(true); 
		sofa_Button.setContentAreaFilled(false); 
		sofa_Button.setBorderPainted(false); 
		contentPane.add(sofa_Button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("resources\\images\\salon.jpg"));
		lblNewLabel.setBounds(0, 0, 1084, 711);
		contentPane.add(lblNewLabel);
		
		
		setVisible(true);
		
	}
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
}
