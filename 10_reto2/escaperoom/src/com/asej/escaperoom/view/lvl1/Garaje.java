package com.asej.escaperoom.view.lvl1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

import com.asej.escaperoom.controlador.Audio;
import com.asej.escaperoom.model.Objeto;
import com.asej.escaperoom.view.Ventana;

public class Garaje extends JPanel {

	//private JTextField tiempo_textField;
    //private JTextPane dialogo_textPane; // Declarar como atributo para poder modificarlo desde los botones
    //private int contador = 0;
    //private int segundos = 3600;
    //private Clip clipBoton;
	//private Clip clipClick;
	
	public Garaje(Ventana ventana) {
		
		setBounds(0, 0, 1100, 750);
		setLayout(null);

        JButton btnCoche = new JButton("");
        btnCoche.setBounds(455, 344, 224, 206);
        btnCoche.setOpaque(true);
        btnCoche.setContentAreaFilled(false);
        btnCoche.setBorderPainted(false);
        add(btnCoche);

        JButton btnNevera = new JButton("");
        btnNevera.setBounds(695, 306, 89, 215);
        btnNevera.setOpaque(true);
        btnNevera.setContentAreaFilled(false);
        btnNevera.setBorderPainted(false);
        add(btnNevera);

        JButton btnLimpieza = new JButton("");
        btnLimpieza.setBounds(895, 436, 46, 101);
        btnLimpieza.setOpaque(true);
        btnLimpieza.setContentAreaFilled(false);
        btnLimpieza.setBorderPainted(false);
        add(btnLimpieza);

        JButton btnHerramientas = new JButton("");
        btnHerramientas.setBounds(285, 436, 78, 85);
        btnHerramientas.setOpaque(true);
        btnHerramientas.setContentAreaFilled(false);
        btnHerramientas.setBorderPainted(false);
        add(btnHerramientas);

        JButton btnIrSalon = new JButton();
        btnIrSalon.setIcon(new ImageIcon("resources\\images\\flechaDerecha.png"));
        btnIrSalon.setBounds(1000, 350, 70, 65);
        btnIrSalon.setContentAreaFilled(false); 
        btnIrSalon.setBorderPainted(false); 
        btnIrSalon.setFocusable(false);
        add(btnIrSalon);

        JLabel lblFondo = new JLabel("");
        lblFondo.setIcon(new ImageIcon("resources\\images\\garaje.jpg"));
        lblFondo.setBounds(0, 0, 1084, 711);
        add(lblFondo);

        btnIrSalon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Audio.reproducirEfectoSonido(Audio.BOTON);
				Ventana.quitarTextoPantalla();
				ventana.showEscena("Salon");
            }
        });

        btnCoche.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Audio.reproducirEfectoSonido(Audio.COCHE);
            	Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("garage1"));
                }
        });

        btnNevera.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Audio.reproducirEfectoSonido(Audio.ARMARIO);
            	Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("garage2"));
                }
        });

        btnLimpieza.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Audio.reproducirEfectoSonido(Audio.ARMARIO);
            	Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("garage3"));
                 }
        });
        
        btnHerramientas.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Audio.reproducirEfectoSonido(Audio.COIN);
            	Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("garage4"));
                btnHerramientas.setEnabled(false);
                ventana.getObjetosInventario().add(new Objeto("destornillador","destornillador.png", Ventana.mensajes.getString("garage5")));
            }
        });
        
        btnIrSalon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIrSalon.setIcon(new ImageIcon("resources\\images\\flechaDerechaPintada.png"));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIrSalon.setIcon(new ImageIcon("resources\\images\\flechaDerecha.png"));

			}
		});

        setVisible(true);
    }

}
