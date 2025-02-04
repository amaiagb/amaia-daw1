package view_nv1;

import java.awt.Color;
import java.awt.Font;
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
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;
import javax.swing.JLabel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class view_terraza extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tiempo_textField;
	private JTextPane textPane;
	private int contador = 0;
	private int segundos=3600;
	private JTextPane dialogo_textPane;
	private Clip clipBoton;
	private Clip clipClick;




	
	public view_terraza() {
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

		dialogo_textPane = new JTextPane();
		dialogo_textPane.setEditable(false);
		dialogo_textPane.setBounds(310, 580, 605, 120);
		contentPane.add(dialogo_textPane);
		
		JButton sala_Button = new JButton(">");
		sala_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirMusicaBoton();
				dispose();
				new view_pasillo();
			}
		});
		
		JButton dog_Button = new JButton("");
		dog_Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ladrar();
				 try {
			            StyledDocument doc = dialogo_textPane.getStyledDocument();
			            doc.insertString(doc.getLength(),"Guau", null);
			        } catch (BadLocationException ex) {
			            ex.printStackTrace();
			        }
			}
		});
		dog_Button.setBounds(395, 499, 89, 82);
		contentPane.add(dog_Button);
		sala_Button.setFont(new Font("Tahoma", Font.BOLD, 14));
		sala_Button.setBounds(1028, 307, 46, 69);
		dog_Button.setOpaque(true); 
		dog_Button.setContentAreaFilled(false); 
		dog_Button.setBorderPainted(false);
		contentPane.add(sala_Button);
		
		
		JLabel fondo_Label = new JLabel("");
		fondo_Label.setIcon(new ImageIcon("resources\\images\\terraza.jpg"));
		fondo_Label.setBounds(0, 0, 1084, 700);
		contentPane.add(fondo_Label);
		
		
	setVisible(true);	
	}
	public void ladrar(){
		contador++;
		if (contador==3) {
			 try {
		            StyledDocument doc = dialogo_textPane.getStyledDocument();
		            doc.insertString(doc.getLength(),"Miau", null);
		        } catch (BadLocationException ex) {
		            ex.printStackTrace();
		        }
			 contador = 0;
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
