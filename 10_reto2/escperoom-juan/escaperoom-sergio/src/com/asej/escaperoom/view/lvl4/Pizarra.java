package com.asej.escaperoom.view.lvl4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.view.Ventana;

public class Pizarra extends JPanel {

	public Pizarra(Ventana ventana) {
		setLayout(null);
		setBounds(0, 0, 1084, 711);
		
		//this.ventana = ventana;
		
		JButton btnIrAula = new JButton();
		btnIrAula.setBounds(10, 350, 70, 65);
		btnIrAula.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));
		btnIrAula.setContentAreaFilled(false); 
		btnIrAula.setBorderPainted(false); 
		btnIrAula.setFocusable(false);
		add(btnIrAula);
	
		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("resources\\images\\pizarra.png"));
		lblFondo.setBounds(0, 0, 1080, 711);
		add(lblFondo);
		
		btnIrAula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Aula Ordenadores");
			}
		});
		
		btnIrAula.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnIrAula.setIcon(new ImageIcon("resources\\images\\flechaIzquierdaPintada.png"));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnIrAula.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));

			}
		});
	}

}
