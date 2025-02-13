package com.asej.escaperoom.view.lvl2;

import java.awt.Color;
import java.awt.Font;
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
	static JButton btnFlechaDerecha;
	
	public Conversacion(Ventana ventana) {
		
		setBounds(0, 0, 1100, 750);
		setLayout(null);
		
		JLabel lblManuel = new JLabel("");
		lblManuel.setBounds(397, 110, 361, 601);
		add(lblManuel);
		
		btnFlechaDerecha = new JButton();
		btnFlechaDerecha.setIcon(new ImageIcon("resources\\images\\flechaDerecha.png"));
		btnFlechaDerecha.setBounds(1000, 350, 70, 65);
		btnFlechaDerecha.setContentAreaFilled(false); 
		btnFlechaDerecha.setBorderPainted(false); 
		btnFlechaDerecha.setFocusable(false);
		add(btnFlechaDerecha);
		
		JButton btnJugar = new JButton(Ventana.mensajes.getString("btnJugar1"));
		btnJugar.setBackground(Color.ORANGE);
		btnJugar.setForeground(Color.BLACK);
		btnJugar.setFont(new Font("Tahoma",0,16));
		btnJugar.setBounds(890, 350, 200, 65);
		add(btnJugar);
		btnJugar.setVisible(false);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("resources\\images\\lvl2\\manuel-bg.jpg"));
		lblFondo.setBounds(0, 0, 1084, 711);
		add(lblFondo);
		
		lblManuel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(objetoManuel.equals(PanelInventario.objetoSeleccionado)) {
					System.out.println(PanelInventario.objetoSeleccionadoId);
					System.out.println(PanelInventario.objetoSeleccionado);
					ventana.entregarObjeto(PanelInventario.objetoSeleccionadoId);
					Audio.reproducirEfectoSonido(Audio.COIN);
					lblFondo.setIcon(new ImageIcon("resources\\images\\lvl2\\manuel-bg2.png"));
					Ventana.mostrarTextoPantalla(Ventana.mensajes.getString("conversacion1"));
					btnJugar.setVisible(true);
					ventana.getBtnSoltarObjeto().setVisible(false);
				}
			}
		});
		
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Juego ppt");
				Ventana.quitarTextoPantalla();
				}
		});
		
		btnFlechaDerecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Colegio Exterior");
				Ventana.quitarTextoPantalla();
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
