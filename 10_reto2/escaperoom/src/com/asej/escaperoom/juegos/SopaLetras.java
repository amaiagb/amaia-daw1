package com.asej.escaperoom.juegos;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.asej.escaperoom.controlador.Audio;
import com.asej.escaperoom.model.Objeto;
import com.asej.escaperoom.view.Ventana;



public class SopaLetras extends JPanel {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField[] palabraFields = new JTextField[5];  
    private final Set<String> palabrasCorrectas = Set.of("ACOSO", "DAÑO", "INSULTO", "MIEDO", "BULLYING");
    private final Set<String> palabrasCorrectasIngles = Set.of("HARASSMENT","DAMAGE", "OFFENSE", "FEAR", "BULLYING");
    private final Set<String> palabrasEncontradas = new HashSet<>();
   
    
    
    public SopaLetras(Ventana ventana) {
        setBounds(0, 50, 1100, 750);
        setLayout(null);
        
        JLabel btnSalir = new JLabel();
        btnSalir.setIcon(new ImageIcon("resources\\images\\flecha.png"));
        btnSalir.setBounds(44, 90, 85, 56);
        btnSalir.setOpaque(false);
		add(btnSalir);
		/*
		JLabel lblSopaLetras = new JLabel(new ImageIcon("resources\\images\\sopa2.jpg"));
        lblSopaLetras.setBounds(73, 225, 500, 433);
        add(lblSopaLetras);
        */

        for (int i = 0; i < palabraFields.length; i++) {
            palabraFields[i] = new JTextField();  
            palabraFields[i].setBounds(686, 322 + (i * 54), 250, 45);
            palabraFields[i].setBorder(new LineBorder(Color.DARK_GRAY, 1));
            palabraFields[i].setOpaque(false);
            palabraFields[i].setHorizontalAlignment(JTextField.CENTER);
            palabraFields[i].setFont(new Font("Tahoma",0,16));

            add(palabraFields[i]);
        }

        JButton btnComprobarPalabras = new JButton();
        btnComprobarPalabras.setBounds(686, 613, 250, 45);
        btnComprobarPalabras.setBorder(null);
        btnComprobarPalabras.setOpaque(false);
        btnComprobarPalabras.setBorderPainted(false);
        btnComprobarPalabras.setContentAreaFilled(false);
        add(btnComprobarPalabras);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("resources\\images\\sopaLetras2.jpg"));
        lblNewLabel.setBounds(0, 0, 1084, 711);
        add(lblNewLabel);
        setVisible(true);
        
        btnComprobarPalabras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Set<String> palabrasIngresadas = new HashSet<>();
                for (JTextField field : palabraFields) {
                    String texto = field.getText().trim().toUpperCase();
                    if (!texto.isEmpty()) {
                        palabrasIngresadas.add(texto);
                    }
                }
                
                for (JTextField field : palabraFields) {
                    String texto = field.getText().trim().toUpperCase();
                    if(field.isEditable()) {
                    	if (palabrasCorrectas.contains(texto) && !palabrasEncontradas.contains(texto)) {
                            palabrasEncontradas.add(texto);
                            field.setEditable(false);
                            field.setBorder(new LineBorder(new Color(0,150,0), 3));
                            if(palabrasEncontradas.size() == palabrasCorrectas.size()) {
                            	ventana.showEscena("Salon");
                            	Audio.reproducirEfectoSonido(Audio.COIN);
                            	ventana.getObjetosInventario().add(new Objeto("revista","revista.png", "La revista de mi hermana con su sopa de letras resuelta"));
                            	Ventana.mostrarTextoPantalla("¡Genial! La revista con la sopa de letras resuelta se ha añadido al inventario");
                            }
                        } else {
                            field.setText("");
                        }
                    }
                }
                if (palabrasIngresadas.equals(palabrasCorrectas)) {
                  System.out.println("bien");
              } else {
                 System.out.println("mal");
              }
            }
        });
        
        btnSalir.addMouseListener(new MouseAdapter() {
        	public void  mouseClicked(MouseEvent e)  {
        		ventana.showEscena("Salon");
        		Audio.reproducirEfectoSonido(Audio.BOTON);
        		Ventana.quitarTextoPantalla();
        	}
        });
        btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSalir.setIcon(new ImageIcon("resources\\images\\flecha2.png"));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSalir.setIcon(new ImageIcon("resources\\images\\flecha.png"));

			}
		});
    }
}
