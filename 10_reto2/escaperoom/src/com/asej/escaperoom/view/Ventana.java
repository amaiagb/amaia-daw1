package com.asej.escaperoom.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import com.asej.escaperoom.model.Objeto;
import com.asej.escaperoom.view.lvl1.Cocina;
import com.asej.escaperoom.view.lvl1.Garaje;
import com.asej.escaperoom.view.lvl1.Habitacion;
import com.asej.escaperoom.view.lvl1.Pasillo;
import com.asej.escaperoom.view.lvl1.Salon;
import com.asej.escaperoom.view.lvl1.Terraza;
import com.asej.escaperoom.view.lvl5.Escena5;
import com.asej.escaperoom.view.lvl5.Escena5_escritorio;
import com.asej.escaperoom.view.lvl5.Escena5_pc;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private PanelOpciones panelOpciones;
	private PanelInstrucciones panelInstrucciones;
	private PanelInventario panelInventario;
	private PanelPistas panelPistas;
	private static JPanel panelTextos;
    private JPanel panelNav;
    private JPanel panelPrincipal;
    private CardLayout cardLayout;
    private static JTextPane txtDialogo;
    private JTextField txtTimer;
	private Timer timer;
	private int segundos = 3600;
    private ResourceBundle mensajes;
    
    private static Clip clipPrincipal;
    private Clip clipBoton;
    private static Clip clipClick;

	public Ventana(Locale locale) {
		
		mensajes = ResourceBundle.getBundle("com.asej.escaperoom.language.Mensajes", locale);
		ArrayList<Objeto> objetosInventario = new ArrayList<>();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1100, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1084, 711);
		contentPane.add(layeredPane);
		setLocationRelativeTo(null);
		//	LayeredPane layers: 
		//	Default -> Palette -> Modal -> Popup -> Drag
		
		Portada portada = new Portada(this);
		layeredPane.add(portada, JLayeredPane.MODAL_LAYER);
		
		panelOpciones = new PanelOpciones();
		layeredPane.add(panelOpciones, JLayeredPane.POPUP_LAYER);
		panelOpciones.setVisible(false);
		
		panelInstrucciones = new PanelInstrucciones();
		layeredPane.add(panelInstrucciones, JLayeredPane.POPUP_LAYER);
		panelInstrucciones.setVisible(false);
		
		panelInventario = new PanelInventario(objetosInventario);
		layeredPane.add(panelInventario, JLayeredPane.MODAL_LAYER);
		panelInventario.setVisible(false);

		panelPistas = new PanelPistas();
		layeredPane.add(panelPistas, JLayeredPane.MODAL_LAYER);
		panelPistas.setVisible(false);
		
		panelNav = new JPanel();
		panelNav.setBounds(0, 0, 1084, 60);
		panelNav.setBackground(Color.DARK_GRAY);
		layeredPane.add(panelNav, JLayeredPane.PALETTE_LAYER);
		panelNav.setLayout(null);
		
		panelTextos = new JPanel();
		//panelTextos.setBounds(0, 650, 1084, 70);
		panelTextos.setBackground(Color.DARK_GRAY);
		layeredPane.add(panelTextos, JLayeredPane.PALETTE_LAYER);
		panelTextos.setLayout(null);
		panelTextos.setVisible(false);
		panelTextos.setBounds(0, 650, 1084, 0);
		
		txtDialogo = new JTextPane(); 
		txtDialogo.setFont(new Font("Tahoma", Font.PLAIN, 16));
	    txtDialogo.setEditable(false);
	    txtDialogo.setOpaque(false);
	    txtDialogo.setForeground(Color.white);
	    txtDialogo.setBounds(0, 10, 1084, 70);
	    StyledDocument doc = txtDialogo.getStyledDocument();
	    SimpleAttributeSet center = new SimpleAttributeSet();
	    StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
	    doc.setParagraphAttributes(0, doc.getLength(), center, false);
		panelTextos.add(txtDialogo);
		//txtDialogo.setVisible(false);
	    
		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(0, 0, 1084, 711);
		layeredPane.add(panelPrincipal, JLayeredPane.DEFAULT_LAYER);
		cardLayout = new CardLayout();
		panelPrincipal.setLayout(cardLayout);
		
		txtTimer = new JTextField();
		txtTimer.setEnabled(false);
		txtTimer.setBackground(Color.BLACK);
		txtTimer.setForeground(Color.RED);
		txtTimer.setDisabledTextColor(Color.RED);
		txtTimer.setFont(new Font("OCR A Extended", Font.PLAIN, 36));
		txtTimer.setHorizontalAlignment(SwingConstants.CENTER);
		txtTimer.setOpaque(true);
		txtTimer.setEditable(false);
		txtTimer.setBounds(10, 10, 180, 40);
		panelNav.add(txtTimer);
		txtTimer.setColumns(10);
		
		JLabel btnInventario = new JLabel();
		btnInventario.setHorizontalAlignment(SwingConstants.CENTER);
		btnInventario.setForeground(Color.WHITE);
		btnInventario.setBackground(Color.GRAY);
		btnInventario.setLocation(800, 10);
		btnInventario.setSize(100, 40);
		btnInventario.setText(mensajes.getString("btnInventario"));
		btnInventario.setOpaque(true);
		panelNav.add(btnInventario);
		
		JLabel btnPista = new JLabel();
		btnPista.setHorizontalAlignment(SwingConstants.CENTER);
		btnPista.setForeground(Color.WHITE);
		btnPista.setBackground(Color.GRAY);
		btnPista.setLocation(910, 10);
		btnPista.setSize(100, 40);
		btnPista.setText(mensajes.getString("btnPista"));
		btnPista.setOpaque(true);
		panelNav.add(btnPista);
		
		JLabel btnOpciones = new JLabel();
		btnOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		btnOpciones.setIcon(new ImageIcon("resources\\images\\ajuste.png"));
		btnOpciones.setForeground(Color.WHITE);
		btnOpciones.setBackground(Color.GRAY);
		btnOpciones.setBounds(1020, 10, 60, 40);
		btnOpciones.setOpaque(true);
		panelNav.add(btnOpciones);
		
		timer = new Timer(1000, new ActionListener() { // Se ejecuta cada segundo
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(segundos > 0) {
            		segundos--;
                    String time = String.format("%02d:%02d", segundos / 60, segundos % 60);
                    txtTimer.setText(time);
            	} else {
            		timer.stop();
            		JOptionPane.showMessageDialog(txtTimer,"FIN","Mensaje",JOptionPane.INFORMATION_MESSAGE);
            	}
            	
                
            }
        });
		
		//reproducirMusicaPrincipal();

		Escena5 escena5 = new Escena5(this);
		panelPrincipal.add(escena5, "Escena 5");
		
		Escena5_pc escena5_pc = new Escena5_pc(this);
		panelPrincipal.add(escena5_pc, "Escena 5 Ordenador");
		
		Escena5_escritorio escena5_escritorio = new Escena5_escritorio(this);
		panelPrincipal.add(escena5_escritorio, "Pantalla ordenador");
		
		Habitacion habitacion = new Habitacion(this);
		panelPrincipal.add(habitacion, "Habitacion");
		
		Pasillo pasillo = new Pasillo(this);
		panelPrincipal.add(pasillo, "Pasillo");
		
		Terraza terraza = new Terraza(this);
		panelPrincipal.add(terraza, "Terraza");
		
		Salon salon = new Salon(this);
		panelPrincipal.add(salon, "Salon");
		
		Cocina cocina = new Cocina(this);
		panelPrincipal.add(cocina, "Cocina");
		
		Garaje garaje = new Garaje(this);
		panelPrincipal.add(garaje, "Garaje");
		
		//cardLayout.show(panelPrincipal, "Cocina");
		

		btnInventario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});

	}
	
	public PanelOpciones getPanelOpciones() {
		return panelOpciones;
	}
	
	public PanelInstrucciones getPanelInstrucciones() {
		return panelInstrucciones;
	}
	
	public JPanel getPanelPrincipal() {
		return panelPrincipal;
	}
	
	public JPanel getPanelTextos() {
		return panelTextos;
	}
	
	public JTextPane getTxtDialogo() {
		return txtDialogo;
	}
	
	public CardLayout getCardLayout() {
		return cardLayout;
	}
	public Timer getTimer() {
		return timer;
	}
	public static void mostrarTextoPantalla(String mensaje) {
		panelTextos.setSize(1084,60);
		panelTextos.setVisible(true);
		txtDialogo.setText(mensaje);
	}
	public static void quitarTextoPantalla() {
		panelTextos.setVisible(false);
		txtDialogo.setText("");
	}
	
	public void showEscena(String escena) {
		cardLayout.show(panelPrincipal, escena);
	}

	public static void reproducirMusicaPrincipal() {
		if (clipPrincipal != null && clipPrincipal.isRunning()) {
            clipPrincipal.stop(); // Detén la música anterior si está sonando
        }

        new Thread(() -> {
            try {
                File musica = new File("resources//audio//op.wav");
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
	public static void detenerMusicaPrincipal() {
        if (clipPrincipal != null && clipPrincipal.isRunning()) {
        	clipPrincipal.stop();
        }
    }
	
	public void reproducirMusicaBoton() {
        if (clipBoton != null && clipBoton.isRunning()) {
        	clipBoton.stop(); // Detén la música anterior si está sonando
        }

        new Thread(() -> {
            try {
                File musica = new File("resources//audio//boton.wav");
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

    public void detenerMusicaBoton() {
        if (clipBoton != null && clipBoton.isRunning()) {
        	clipBoton.stop();
        }
    }
    
    
    public void reproducirMusicaClick() {
        if (clipClick != null && clipClick.isRunning()) {
        	clipClick.stop(); // Detén la música anterior si está sonando
        }

        new Thread(() -> {
            try {
                File musica = new File("resources//audio//click.wav");
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

    public static void detenerMusicaClick() {
        if (clipClick != null && clipClick.isRunning()) {
        	clipClick.stop();
        }
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
