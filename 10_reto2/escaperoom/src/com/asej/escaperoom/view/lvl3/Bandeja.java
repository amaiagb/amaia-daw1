package com.asej.escaperoom.view.lvl3;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.asej.escaperoom.view.Ventana;
import javax.swing.JTextField;

public class Bandeja extends JPanel {

	//private final String RUTA = "C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\escaperoom\\";
	//private final String RUTA = "D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom\\";
	private final String RUTA = "";
	private final String CORREO_USER = "aitor2012@centro.eus";
	private final String CORREO_PASS = "2025Docs";
	
	private Ventana ventana;
	private JTextField txtCorreo;
	private JTextField txtPass;

	public Bandeja(Ventana ventana) {

		this.ventana = ventana;
		setBounds(85, 77, 759, 522);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		//lblLoginError.setVisible(true);

		JLabel lblCerrarLogin = new JLabel();
		lblCerrarLogin.setFont(new Font("OCR A Extended", Font.PLAIN, 18));
		lblCerrarLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblCerrarLogin.setBounds(718,0, 40, 40);
		add(lblCerrarLogin);
		//lblCerrarLogin.setVisible(true);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setBounds(0, 0, 758, 522);
		lblFondo.setVerticalAlignment(SwingConstants.TOP);
		lblFondo.setIcon(new ImageIcon("C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\escaperoom\\resources\\images\\bandeja.png"));
		add(lblFondo);
		
	
		lblCerrarLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblCerrarLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				setVisible(false);

			}
		});
		
		
		

	}
}
