package com.asej.escaperoom.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.controlador.Controlador;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private PanelOpciones panelOpciones;
	private PanelInstrucciones panelInstrucciones;
	private JTextField txtTimer;
	private Timer timer;
	private int segundos = 3600;
	private static Clip clipPrincipal;
    private Clip clipBoton;
    private static Clip clipClick;
    private JPanel panelTextos;
    private JPanel panelNav;
    private JPanel panelPrincipal;
    private CardLayout cardLayout;

	public Ventana() {
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
		
		Portada portada = new Portada(this);
		layeredPane.add(portada, JLayeredPane.MODAL_LAYER);
		
		panelOpciones = new PanelOpciones();
		layeredPane.add(panelOpciones, JLayeredPane.POPUP_LAYER);
		panelOpciones.setVisible(false);
		
		panelInstrucciones = new PanelInstrucciones();
		layeredPane.add(panelInstrucciones, JLayeredPane.POPUP_LAYER);
		panelInstrucciones.setVisible(false);

		panelNav = new JPanel();
		panelNav.setBounds(0, 0, 1084, 60);
		panelNav.setBackground(Color.DARK_GRAY);
		layeredPane.add(panelNav, JLayeredPane.PALETTE_LAYER);
		
		panelTextos = new JPanel();
		panelTextos.setBounds(0, 630, 1084, 120);
		panelTextos.setBackground(Color.DARK_GRAY);
		layeredPane.add(panelTextos, JLayeredPane.PALETTE_LAYER);
		
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
		
		JLabel btnPista = new JLabel();
		btnPista.setHorizontalAlignment(SwingConstants.CENTER);
		btnPista.setForeground(Color.WHITE);
		btnPista.setBackground(Color.GRAY);
		btnPista.setLocation(860, 10);
		btnPista.setSize(100, 40);
		btnPista.setText("Pista");
		btnPista.setOpaque(true);
		panelNav.add(btnPista);
		
		JLabel btnOpciones = new JLabel();
		btnOpciones.setHorizontalAlignment(SwingConstants.CENTER);
		btnOpciones.setText("Opciones");
		btnOpciones.setForeground(Color.WHITE);
		btnOpciones.setBackground(Color.GRAY);
		btnOpciones.setBounds(970, 10, 100, 40);
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
		
		reproducirMusicaPrincipal();
/*
		Escena1 escena1 = new Escena1(panelTextos);
		panelPrincipal.add(escena1, "Escena 1");
		panelNav.setLayout(null);
		*/
		Escena5 escena5 = new Escena5(this);
		panelPrincipal.add(escena5, "Escena 5");
		
		panelNav.setLayout(null);
		Escena5_pc escena5_pc = new Escena5_pc(this);
		panelPrincipal.add(escena5_pc, "Escena 5 Ordenador");
		panelNav.setLayout(null);
		
		cardLayout.show(panelPrincipal, "Escena 5");

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
	
	public CardLayout getCardLayout() {
		return cardLayout;
	}
	public Timer getTimer() {
		return timer;
	}
	
	

	
}
