package tests;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import db.AccesoDBEscaperoom;
import db.Mensaje;
import escaperoom_prueba.ui.Ventana1;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JLabel;

public class TestTxt extends JFrame {
	
	private String idioma = "ES";
	private JTextPane textPane;
	private JTextPane txtPersonaje;
	
	public TestTxt(AccesoDBEscaperoom bd) throws ClassNotFoundException, SQLException {
			
		Mensaje m = bd.getMensaje(1, idioma);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textPane = new JTextPane();
		textPane.setBounds(124, 222, 465, 127);
		contentPane.add(textPane);		
		textPane.setText(m.getTexto());
		
		txtPersonaje = new JTextPane();
		txtPersonaje.setEditable(false);
		txtPersonaje.setForeground(Color.BLACK);
		txtPersonaje.setBackground(Color.WHITE);
		txtPersonaje.setText((String) null);
		txtPersonaje.setBounds(114, 173, 243, 40);
		contentPane.add(txtPersonaje);
		txtPersonaje.setText(m.getLocutor());
	    txtPersonaje.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.BLUE, 2, true),  new EmptyBorder(10,10,10,10)));
		
		JButton btnMas = new JButton(">");
		btnMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idMsg = m.getId();
				idMsg++;
				try {
					Mensaje m2 = bd.getMensaje(idMsg, idioma);
					mostrarMensaje(m2);
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnMas.setBounds(555, 348, 41, 35);
		contentPane.add(btnMas);
		
		JLabel lblMsgFondo = new JLabel("");
		lblMsgFondo.setBackground(Color.WHITE);
		lblMsgFondo.setBounds(114, 214, 482, 169);
		lblMsgFondo.setOpaque(true);
		//TitledBorder title;
		//title = BorderFactory.createTitledBorder(loweredBevel, m.getLocutor());
		//lblMsgFondo.setBorder(BorderFactory.createTitledBorder(m.getLocutor()));
		lblMsgFondo.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
		contentPane.add(lblMsgFondo);
		
			
			
	}

	protected void mostrarMensaje(Mensaje m) {
		textPane.setText(m.getTexto());
		txtPersonaje.setText(m.getLocutor());
	}
}
