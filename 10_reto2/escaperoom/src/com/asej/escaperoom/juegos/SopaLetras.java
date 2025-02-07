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
        setBounds(0, 0, 1100, 750);
        setBackground(Color.WHITE);
        setBorder(new EmptyBorder(5, 5, 5, 5));
        setLayout(null);

        JLabel imagenSL_Label = new JLabel(new ImageIcon("resources\\images\\sopaLetras.png"));
        imagenSL_Label.setBounds(63, 140, 380, 387);
        add(imagenSL_Label);

        for (int i = 0; i < 6; i++) {
            palabraFields[i] = new JTextField();
            palabraFields[i].setBounds(500, 154 + (i * 54), 440, 43);
            add(palabraFields[i]);
            palabraFields[i].setColumns(10);
        }

        JButton comprobar_Button = new JButton("Comprobar");
        comprobar_Button.setFont(new Font("Tahoma", Font.BOLD, 14));
        comprobar_Button.setBounds(500, 478, 440, 43);
        comprobar_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Set<String> palabrasIngresadas = new HashSet<>();
                for (JTextField field : palabraFields) {
                    palabrasIngresadas.add(field.getText().trim().toUpperCase());
                }
                if (palabrasIngresadas.equals(palabrasCorrectas)) {
                    //dispose();
                    //new view_sala();
                } else {
                    String fallo = JOptionPane.showInputDialog(null, "Prueba otra vez");
                }
            }
        });
        add(comprobar_Button);

        JTextArea introduccion_Area = new JTextArea("Has encontrado la sopa de letras de tu hermana");
        introduccion_Area.setBackground(Color.LIGHT_GRAY);
        introduccion_Area.setFont(new Font("Noto Sans Cond", Font.BOLD, 18));
        introduccion_Area.setForeground(Color.BLACK);
        introduccion_Area.setEditable(false);
        introduccion_Area.setBounds(63, 11, 877, 118);
        add(introduccion_Area);
        
        JButton salir_Button = new JButton("<");
        salir_Button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		//dispose();
        		//new view_sala();
        	}
        });
        salir_Button.setBounds(10, 11, 48, 23);
        add(salir_Button);
        
        setVisible(true);
    }
}
