package com.asej.escapeRoom.view;

import javax.sound.sampled.AudioInputStream;    
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.asej.escapeRoom.view.view_ajustes;
import com.asej.escapeRoom.view.view_guia;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class view_portada extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Clip clipPrincipal;
    private Clip clipBoton;
    private Clip clipClick;
    
    private view_guia guiaWindow;
    private view_ajustes ajustesWindow;

   

//    private Clip clip; // Variable de clase para controlar el audio

    public view_portada() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1120, 1120);
        contentPane = new JPanel();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setForeground(Color.BLACK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        contentPane.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                reproducirMusicaClick(); // Llama al método para reproducir el sonido
            }
        });
        
//        JButton btnNewButton = new JButton("");
//        btnNewButton.addActionListener(new ActionListener() {
//        	
//        btnNewButton.setIcon(new ImageIcon("D:\\zImages\\ajuste.png"));
//        btnNewButton.setBounds(1045, 11, 49, 36);
//        contentPane.add(btnNewButton);
        
        ImageIcon icono2 = new ImageIcon("images/ajuste.png");
        Image img4 = icono2.getImage();
        Image img3 = img4.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
        ImageIcon imgEscalado2 = new ImageIcon(img3);
        
        JButton btnNewButton = new JButton(imgEscalado2);
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		reproducirMusicaBoton();
           	 dispose();

                 
                 // Verifica si la ventana de la guía ya está abierta
                 if (ajustesWindow != null && ajustesWindow.isVisible()) {
                     // Si ya está abierta, la cerramos
                	 ajustesWindow.dispose();
                 } else {
                     // Si no está abierta, la abrimos
                	 ajustesWindow = new view_ajustes();
                 }
             }
         });
        btnNewButton.setBounds(1045, 11, 49, 36);
        contentPane.add(btnNewButton);
        
        JLabel Label_Titulo = new JLabel("DigiDoor");
        Label_Titulo.setForeground(new Color(255, 153, 51));
        Label_Titulo.setFont(new Font("Noto Serif Cond", Font.BOLD, 80));
        Label_Titulo.setHorizontalAlignment(SwingConstants.CENTER);
        Label_Titulo.setBounds(70, 307, 435, 220);
        contentPane.add(Label_Titulo);

        JButton play_button = new JButton("Jugar");
        play_button.setFont(new Font("Arial", Font.BOLD, 16));
        play_button.setBackground(new Color(255, 102, 0));
        play_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	detenerMusicaPrincipal();
                dispose(); // Cierra la ventana actual
            }
        });
        play_button.setBounds(510, 576, 130, 51);
        contentPane.add(play_button);

        JButton guia_button = new JButton("Guia");
        guia_button.setFont(new Font("Noto Sans Cond", Font.BOLD, 17));
        guia_button.setBackground(new Color(192, 192, 192));
        guia_button.setForeground(Color.WHITE);
        guia_button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 reproducirMusicaBoton();
            	 dispose();
                 
                 // Verifica si la ventana de la guía ya está abierta
                 if (guiaWindow != null && guiaWindow.isVisible()) {
                     // Si ya está abierta, la cerramos
                     guiaWindow.dispose();
                 } else {
                     // Si no está abierta, la abrimos
                     guiaWindow = new view_guia();
                 }
             }
         });
        guia_button.setBounds(10, 11, 99, 36);
        contentPane.add(guia_button);

        JLabel lblNewLabel = new JLabel("The Escape School");
        lblNewLabel.setForeground(new Color(255, 255, 0));
        lblNewLabel.setFont(new Font("Noto Sans Cond", Font.ITALIC, 75));
        lblNewLabel.setBounds(303, 450, 543, 140);
        contentPane.add(lblNewLabel);
        
        ImageIcon icono = new ImageIcon("images/portada.jpg");
        Image img = icono.getImage();
        Image img2 = img.getScaledInstance(1120, 1120, Image.SCALE_SMOOTH);
        ImageIcon imgEscalado = new ImageIcon(img2);
        
        JLabel ajustes_Button = new JLabel(imgEscalado);
        ajustes_Button.setBounds(0, 0, 1104, 749);
        contentPane.add(ajustes_Button);
        
        reproducirMusicaPrincipal();

        setVisible(true);
    }
    public void reproducirMusicaPrincipal() {
        if (clipPrincipal != null && clipPrincipal.isRunning()) {
            clipPrincipal.stop(); // Detén la música anterior si está sonando
        }

        new Thread(() -> {
            try {
                File musica = new File("music/op.wav");
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

    public void detenerMusicaPrincipal() {
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
                File musica = new File("music/boton.wav");
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
                File musica = new File("music/click.wav");
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

    public void detenerMusicaClick() {
        if (clipClick != null && clipClick.isRunning()) {
        	clipClick.stop();
        }
    }
}


