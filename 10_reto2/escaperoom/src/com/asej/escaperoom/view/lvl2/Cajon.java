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
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.model.Objeto;
import com.asej.escaperoom.view.Ventana;

public class Cajon extends JPanel {

	public Cajon(Ventana ventana) {

		setBounds(0, 0, 1100, 750);
		setLayout(null);

		JButton btnFlecha = new JButton("");
		btnFlecha.setOpaque(true);
		btnFlecha.setBorderPainted(false);
		btnFlecha.setContentAreaFilled(false);
		btnFlecha.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));
		btnFlecha.setBounds(10, 350, 70, 65);
		add(btnFlecha);
		btnFlecha.setVisible(true);
		
		JLabel lblNota = new JLabel("");
		lblNota.setBounds(147, 234, 309, 208);
		add(lblNota);
		
		JLabel lblZoomCajon = new JLabel("");
		lblZoomCajon.setIcon(new ImageIcon("resources\\images\\lvl2\\Cajon.png"));
		lblZoomCajon.setBounds(0, 0, 1100, 711);
		add(lblZoomCajon);
		
		btnFlecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventana.showEscena("Clase");
				Ventana.quitarTextoPantalla();
			}
		});

		lblNota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblZoomCajon.setIcon(new ImageIcon("resources\\images\\lvl2\\Cajon.jpg"));
				ventana.getObjetosInventario().add(new Objeto("nota","note.png", Ventana.mensajes.getString("cajon")));
			}
		});
		
		btnFlecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFlecha.setIcon(new ImageIcon("resources\\images\\lvl2\\flechaIzquierdaPintada.png"));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btnFlecha.setIcon(new ImageIcon("resources\\images\\flechaIzquierda.png"));
			}
		});

	}

}
