package com.asej.escaperoom.view.lvl5;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.view.Ventana;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Escena5_correo extends JPanel {

	//private final String RUTA = "C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\escaperoom\\";
	//private final String RUTA = "D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\";
	private final String RUTA = "";
	
	private Ventana ventana;

	public Escena5_correo(Ventana ventana) {

		this.ventana = ventana;
		setBounds(85, 77, 920, 540);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblCerrarCorreo = new JLabel("");
		lblCerrarCorreo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCerrarCorreo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		lblCerrarCorreo.setBounds(722, 27, 37, -21);
		add(lblCerrarCorreo);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 758, 522);
		lblFondo.setVerticalAlignment(SwingConstants.TOP);
		lblFondo.setIcon(new ImageIcon("C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\escaperoom\\resources\\images\\email_login.png"));
		add(lblFondo);
	}
}
