package view_nv1;

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
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.awt.event.ActionEvent;

public class view_garaje extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField tiempo_textField;
    private JTextPane dialogo_textPane; // Declarar como atributo para poder modificarlo desde los botones
    private int contador = 0;
    private int segundos = 3600;
    private Clip clipBoton;
	private Clip clipClick;

    public view_garaje() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1100, 750);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

		contentPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reproducirMusicaClick(); // Llama al método para reproducir el sonido
            }
        });

        dialogo_textPane = new JTextPane(); // Inicializar el JTextPane
        dialogo_textPane.setEditable(false);
        dialogo_textPane.setBounds(310, 580, 605, 120);
        contentPane.add(dialogo_textPane);

        JButton coche_Button = new JButton("");
        coche_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	reproducirMusicaCar();
                actualizarDialogo("El coche de papá está averiado. Será mejor que hoy coja el bus.");
            }
        });
        coche_Button.setBounds(455, 344, 224, 206);
        coche_Button.setOpaque(true);
        coche_Button.setContentAreaFilled(false);
        coche_Button.setBorderPainted(false);
        contentPane.add(coche_Button);

        JButton nevera_Button = new JButton("");
        nevera_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	reproducirMusicaArmario();
                actualizarDialogo("¿Por qué solo hay alcohol?");
            }
        });
        nevera_Button.setBounds(695, 306, 89, 215);
        nevera_Button.setOpaque(true);
        nevera_Button.setContentAreaFilled(false);
        nevera_Button.setBorderPainted(false);
        contentPane.add(nevera_Button);

        JButton limpieza_Button = new JButton("");
        limpieza_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	reproducirMusicaArmario();
                actualizarDialogo("Solo son productos de limpieza del coche, no me sirve.");
            }
        });
        limpieza_Button.setBounds(895, 436, 46, 101);
        limpieza_Button.setOpaque(true);
        limpieza_Button.setContentAreaFilled(false);
        limpieza_Button.setBorderPainted(false);
        contentPane.add(limpieza_Button);

        JButton herramientas_Button = new JButton("");
        herramientas_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	reproducirMusicaCoin();
                actualizarDialogo("¿Quién guarda una caja de herramientas en un cajón?");
                herramientas_Button.setEnabled(false);

            }
        });
        herramientas_Button.setBounds(327, 436, 36, 23);
        herramientas_Button.setOpaque(true);
        herramientas_Button.setContentAreaFilled(false);
        herramientas_Button.setBorderPainted(false);
        contentPane.add(herramientas_Button);

        JButton garaje_button = new JButton(">");
        garaje_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
				reproducirMusicaBoton();
                dispose();
                new view_sala();
            }
        });
        garaje_button.setBounds(1028, 344, 46, 64);
        contentPane.add(garaje_button);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("resources\\images\\garaje.jpg"));
        lblNewLabel.setBounds(0, 0, 1084, 711);
        contentPane.add(lblNewLabel);

        setVisible(true);
    }

    // Método para actualizar el diálogo y borrar el texto anterior
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
    
    public void reproducirMusicaCoin() {
        if (clipClick != null && clipClick.isRunning()) {
        	clipClick.stop(); // Detén la música anterior si está sonando
        }

        new Thread(() -> {
            try {
                File musica = new File("D:\\music\\coin.wav");
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
    
    public void reproducirMusicaCar() {
        if (clipClick != null && clipClick.isRunning()) {
        	clipClick.stop(); // Detén la música anterior si está sonando
        }

        new Thread(() -> {
            try {
                File musica = new File("D:\\music\\coche.wav");
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
    
    public void reproducirMusicaArmario() {
        if (clipClick != null && clipClick.isRunning()) {
        	clipClick.stop(); // Detén la música anterior si está sonando
        }

        new Thread(() -> {
            try {
                File musica = new File("D:\\music\\armario.wav");
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
