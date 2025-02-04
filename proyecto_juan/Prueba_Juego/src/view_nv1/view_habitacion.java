package view_nv1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class view_habitacion extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tiempo_textField;
	private JTextPane textPane;
	private int contador = 0;
	private int segundos=3600;
    private JTextPane dialogo_textPane; // Declarar como atributo para poder modificarlo desde los botones
    private Clip clipBoton;
	private Clip clipClick;




	
	public view_habitacion() {
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
		
		JButton pasillo_button = new JButton("<");
		pasillo_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirMusicaBoton();
				dispose();
				new view_pasillo();
			}
		});
		pasillo_button.setBounds(10, 344, 46, 64);
		contentPane.add(pasillo_button);
		
		JButton mochila_Button = new JButton("");
		mochila_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirMusicaCoin();
				actualizarDialogo("hasd encontado tu mochila");
			}
		});
		mochila_Button.setOpaque(true); 
		mochila_Button.setContentAreaFilled(false); 
		mochila_Button.setBorderPainted(false); 
		mochila_Button.setBounds(429, 441, 38, 23);
		contentPane.add(mochila_Button);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarDialogo("No hurges la ropa, que la ensucias");

			}
		});
		btnNewButton.setOpaque(true); 
		btnNewButton.setContentAreaFilled(false); 
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(221, 534, 53, 50);
		contentPane.add(btnNewButton);
		
		JButton reloj_Button = new JButton("");
		reloj_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirMusicaReloj();
				actualizarDialogo("Ves las manecillas marcar las 07:25. Debes darte prisa");

			}
		});
		reloj_Button.setOpaque(true); 
		reloj_Button.setContentAreaFilled(false); 
		reloj_Button.setBorderPainted(false); 
		reloj_Button.setBounds(860, 85, 111, 196);
		contentPane.add(reloj_Button);
		
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				actualizarDialogo("No es momento de jugar al LOL");

			}
		});
		btnNewButton_1.setBounds(739, 289, 219, 289);
		btnNewButton_1.setOpaque(true); 
		btnNewButton_1.setContentAreaFilled(false); 
		btnNewButton_1.setBorderPainted(false); 
		contentPane.add(btnNewButton_1);
		
		
		dialogo_textPane = new JTextPane(); // Inicializar el JTextPane
	    dialogo_textPane.setEditable(false);
	    dialogo_textPane.setBounds(310, 580, 605, 120);
	    contentPane.add(dialogo_textPane);
		
		JLabel fondo_Label = new JLabel("");
		fondo_Label.setIcon(new ImageIcon("resources\\images\\habitacion.jpg"));
		fondo_Label.setBounds(0, 0, 1084, 711);
		contentPane.add(fondo_Label);
		
		
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
	                File musica = new File("resources\\audio\\boton.wav");
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
	                File musica = new File("resources\\audio\\click.wav");
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
	    
	    public void reproducirMusicaReloj() {
	        if (clipClick != null && clipClick.isRunning()) {
	        	clipClick.stop(); // Detén la música anterior si está sonando
	        }

	        new Thread(() -> {
	            try {
	                File musica = new File("resources\\audio\\reloj.wav");
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
	                File musica = new File("resources\\audio\\coin.wav");
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
