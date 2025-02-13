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
		txtInstrucciones.setText(Ventana.mensajes.getString("panel"));
		txtInstrucciones.setBounds(258, 239, 580, 351);
		txtInstrucciones.setBorder(new EmptyBorder(20, 20,20, 20));
		add(txtInstrucciones);
		
		JButton btnCerrarInstrucciones = new JButton(Ventana.mensajes.getString("btnVolver"));
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
