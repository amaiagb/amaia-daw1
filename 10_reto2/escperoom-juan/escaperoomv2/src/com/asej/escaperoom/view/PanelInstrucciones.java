package com.asej.escaperoom.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

public class PanelInstrucciones extends JPanel{

	public PanelInstrucciones() {
		
		setBounds(0, 0, 1084, 711);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblTitulo = new JLabel(Ventana.mensajes.getString("instrucciones"));
		lblTitulo.setForeground(Color.WHITE);
        //lblTitulo.setBackground(Color.LIGHT_GRAY);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 36));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitulo.setBounds(392, 66, 300, 100);
        add(lblTitulo);
        
        JTextPane txtInstrucciones = new JTextPane();
        txtInstrucciones.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        txtInstrucciones.setEditable(false);
		txtInstrucciones.setText("\u00A1Estás a punto de embarcarte en una misi\u00F3n emocionante, donde tu ingenio y habilidades ser\u00E1n clave para escapar. Tienes una hora para resolver todos los misterios, y el reloj en pantalla te ayudar\u00E1 a llevar la cuenta del tiempo.\r\n\r\n\u00BFC\u00F3mo jugar?\r\n\r\n    Explora: Haz clic en diferentes objetos para interactuar con ellos. \u00A1No dejes nada sin revisar!\r\n    Objetos e inventario: Si encuentras algo interesante, lo tendr\u00E1s en tu inventario. Usa estos objetos para resolver acertijos y avanzar.\r\n    Habla con personajes: Algunos personajes pueden darte pistas o informaci\u00F3n importante. \u00A1No dudes en hacerles preguntas!\r\n    Pistas: Si te quedas atascado, puedes pedir pistas. Solo recuerda que el tiempo sigue corriendo.\r\n\r\n\u00A1Tu aventura comienza ahora! La cuenta regresiva ha comenzado, \u00A1buena suerte!");
		txtInstrucciones.setBounds(258, 239, 580, 351);
		txtInstrucciones.setBorder(new EmptyBorder(20, 20,20, 20));
		add(txtInstrucciones);
		
		JButton btnCerrarInstrucciones = new JButton("Volver");
		btnCerrarInstrucciones.setBounds(25, 28, 167, 57);
		btnCerrarInstrucciones.setBackground(Color.WHITE);
		btnCerrarInstrucciones.setForeground(Color.DARK_GRAY);
        add(btnCerrarInstrucciones);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("resources\\images\\portada_blurred.png"));
		lblFondo.setBounds(0, 0, 1084, 711);
		lblFondo.setOpaque(true);
		add(lblFondo);
		
		btnCerrarInstrucciones.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        	}
        });
		
	}
}
