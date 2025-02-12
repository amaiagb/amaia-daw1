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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.asej.escaperoom.view.Ventana;

import com.asej.escaperoom.controlador.Audio;
import com.asej.escaperoom.view.Ventana;


public class SopaLetras extends JPanel{
    private static final long serialVersionUID = 1L;
    private JTextField[] palabraFields = new JTextField[6];
    private final Set<String> palabrasCorrectas = Set.of("ACOSO", "AGRESION", "DAÑO", "INSULTO", "MIEDO", "BULLYING");
    private final Set<String> palabrasCorrectasIngles = Set.of("HARASSMENT","ASSAULT","DAMAGE", "OFFENSE", "FEAR", "BULLYING");
    private final Set<String> palabrasEncontradas = new HashSet<>();

    public SopaLetras(Ventana ventana) {
        setBounds(0, 50, 1100, 750);
        setLayout(null);

        JButton btnSalir = new JButton();
        btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnSalir.setIcon(new ImageIcon("resources\\images\\flechaIzquierdaPintada.png"));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnSalir.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));

			}
		});
        btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Audio.reproducirEfectoSonido(Audio.BOTON);
					Ventana.quitarTextoPantalla();
					ventana.showEscena("Salon");
			}
		});
        btnSalir.setIcon(new ImageIcon("D:resources\\images\\flechaIzquierda.png"));
        btnSalir.setBounds(-11, 112, 85, 56);
        btnSalir.setContentAreaFilled(false);
        btnSalir.setFocusable(false);
		add(btnSalir);

        JLabel lblSopaLetras = new JLabel(new ImageIcon("resources\\images\\sopa2.jpg"));
        lblSopaLetras.setBounds(73, 297, 380, 361);
        add(lblSopaLetras);

        for (int i = 0; i < palabraFields.length; i++) {
            palabraFields[i] = new JTextField();  
            palabraFields[i].setBounds(500, 300 + (i * 54), 440, 43);
            palabraFields[i].setBorder(new LineBorder(Color.BLACK, 2));

            add(palabraFields[i]);
        }

        JButton btnComprobarPalabras = new JButton("Comprobar");
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
                            field.setBackground(Color.GREEN);
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
        btnComprobarPalabras.setForeground(Color.BLACK);
        btnComprobarPalabras.setBackground(SystemColor.controlHighlight);
        btnComprobarPalabras.setFont(new Font("Noto Sans Cond", Font.BOLD, 20));
        btnComprobarPalabras.setBounds(500, 615, 440, 43);
        btnComprobarPalabras.setBorder(new LineBorder(Color.BLACK, 3));
        add(btnComprobarPalabras);

        JTextArea introduccionArea = new JTextArea("Definiciön de las palabras a encontrar:\n"
        		+"  -Perseguir, sin darle tregua ni reposo, a un animal o a una persona.\n"
        		+"  -Causar detrimento, perjuicio, menoscabo, dolor o molestia.\n"
        		+"  -Acto de acometer a alguien para matarlo, herirlo o hacerle daño.\n"
        		+"  -Angustia por un riesgo o daño real o imaginario.\n"
        		+"  -Ofender a alguien provocándolo e irritándolo con palabras o acciones.\n"
        		+"  -Serie de amenazas hostiles, físicas o verbales que se repiten, angustiando a la víctima y estableciendo un desequilibrio de poder entre ella y su acosador");
        introduccionArea.setEditable(false);
        introduccionArea.setBackground(SystemColor.info);
        introduccionArea.setFont(new Font("Noto Sans Cond", Font.PLAIN, 14));
        introduccionArea.setForeground(Color.BLACK);
        introduccionArea.setBorder(new LineBorder(Color.BLACK, 1));
        introduccionArea.setBounds(73, 116, 877, 144);
        add(introduccionArea);
        
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("resources//images//fondoSopaL.jpg"));
        lblNewLabel.setBounds(0, 0, 1084, 711);
        add(lblNewLabel);

       

        setVisible(true);
    }
}



