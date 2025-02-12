package com.asej.escaperoom.view.lvl2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.asej.escaperoom.controlador.Audio;
import com.asej.escaperoom.view.PanelInventario;
import com.asej.escaperoom.view.Ventana;

public class Conversacion extends JPanel {

	private JLabel lblFondo;
	private String objetoManuel = "cromo";
	
	public Conversacion(Ventana ventana) {
		
		setBounds(0, 0, 1100, 750);
		setLayout(null);
		
		JLabel lblManuel = new JLabel("");
		lblManuel.setBounds(397, 110, 361, 601);
		add(lblManuel);
		
		JButton btnFlechaDerecha = new JButton();
		btnFlechaDerecha.setIcon(new ImageIcon("resources\\images\\flechaDerecha.png"));
		btnFlechaDerecha.setBounds(1000, 350, 70, 65);
		btnFlechaDerecha.setContentAreaFilled(false); 
		btnFlechaDerecha.setBorderPainted(false); 
		btnFlechaDerecha.setFocusable(false);
		add(btnFlechaDerecha);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\resources\\images\\lvl2\\manuel-bg.jpg"));
		lblFondo.setBounds(0, 0, 1084, 711);
		add(lblFondo);
		
		lblManuel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(objetoManuel.equals(PanelInventario.objetoSeleccionado)) {
					ventana.entregarObjeto(PanelInventario.objetoSeleccionadoId);
					Audio.reproducirEfectoSonido(Audio.COIN);
					lblFondo.setIcon(new ImageIcon("resources\\images\\lvl2\\manuel-bg2.png"));
					Ventana.mostrarTextoPantalla("¡Jo, muchas gracias!");
				}
			}
		});
		
		btnFlechaDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Colegio Exterior");
				}
		});
		btnFlechaDerecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFlechaDerecha.setIcon(new ImageIcon("resources\\images\\flechaDerechaPintada.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnFlechaDerecha.setIcon(new ImageIcon("resources\\images\\flechaDerecha.png"));
			}
		});		
	}
	
	public JLabel getFondo() {
		return lblFondo;
	}
}
