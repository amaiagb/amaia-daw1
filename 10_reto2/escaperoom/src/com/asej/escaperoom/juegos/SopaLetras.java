package com.asej.escaperoom.juegos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.view.Ventana;



public class SopaLetras extends JPanel {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField[] palabraFields = new JTextField[6];
    private final Set<String> palabrasCorrectas = Set.of("AMOR", "COOPERAR", "DIVERSION", "ASIGNATURA", "CLASE", "PAZ");
    
    public SopaLetras(Ventana ventana) {
        setBounds(0, 50, 1100, 750);
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);
        
        JButton btnSalir = new JButton("<");
        btnSalir.setBounds(100, 100, 48, 23);
        add(btnSalir);

        JLabel lblSopaLetras = new JLabel(new ImageIcon("resources\\images\\sopaLetras.png"));
        lblSopaLetras.setBounds(63, 140, 380, 387);
        add(lblSopaLetras);

        for (int i = 0; i < 6; i++) {
            palabraFields[i] = new JTextField();
            palabraFields[i].setBounds(500, 154 + (i * 54), 440, 43);
            add(palabraFields[i]);
            palabraFields[i].setColumns(10);
        }

        JButton btnComprobarPalabras = new JButton("Comprobar");
        btnComprobarPalabras.setFont(new Font("Tahoma", Font.BOLD, 14));
        btnComprobarPalabras.setBounds(500, 478, 440, 43);
        add(btnComprobarPalabras);

        JTextArea introduccion_Area = new JTextArea("Has encontrado la sopa de letras de tu hermana");
        introduccion_Area.setBackground(Color.LIGHT_GRAY);
        introduccion_Area.setFont(new Font("Noto Sans Cond", Font.BOLD, 18));
        introduccion_Area.setForeground(Color.BLACK);
        introduccion_Area.setEditable(false);
        introduccion_Area.setBounds(63, 11, 877, 118);
        add(introduccion_Area);
        
        setVisible(true);
        
        btnComprobarPalabras.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Set<String> palabrasIngresadas = new HashSet<>();
                for (JTextField field : palabraFields) {
                    palabrasIngresadas.add(field.getText().trim().toUpperCase());
                }
                if (palabrasIngresadas.equals(palabrasCorrectas)) {
                	
                    ventana.showEscena("Salon");
                    Ventana.mostrarTextoPantalla("¡Enhorabuena! ¡Lo has conseguido!\nLa sopa de letras solucionada se ha añadido al inventario");
                } else {
                	Ventana.mostrarTextoPantalla("Prueba de nuevo");
                }
            }
        });

        btnSalir.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        	}
        });
    }
}
