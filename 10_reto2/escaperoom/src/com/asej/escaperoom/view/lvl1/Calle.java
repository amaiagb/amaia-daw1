package com.asej.escaperoom.view.lvl1;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.asej.escaperoom.controlador.Audio;
import com.asej.escaperoom.view.Ventana;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Calle extends JPanel{

	public Calle(Ventana ventana) {
		
		setBounds(0, 0, 1100, 750);
		setLayout(null);
		
		JLabel lblFinNivel = new JLabel("FIN DEL NIVEL 1");
		lblFinNivel.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblFinNivel.setHorizontalAlignment(SwingConstants.CENTER);
		lblFinNivel.setBackground(Color.DARK_GRAY);
		lblFinNivel.setForeground(Color.WHITE);
		lblFinNivel.setOpaque(true);
		lblFinNivel.setBounds(263, 245, 570, 203);
		add(lblFinNivel);
		lblFinNivel.setVisible(false);
		
		JLabel lblBus = new JLabel("");
		lblBus.setBounds(667, 311, 253, 99);
		add(lblBus);

		JLabel lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon("C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\escaperoom\\resources\\images\\calle_autobus.jpg"));
		lblFondo.setBounds(0, 0, 1084, 723);
		add(lblFondo);

		lblBus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblFinNivel.setVisible(true);
				Audio.reproducirEfectoSonido(Audio.COIN);
			}
		});
	}

}
