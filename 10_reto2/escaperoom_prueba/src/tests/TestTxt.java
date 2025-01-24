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
import javax.swing.ImageIcon;

public class TestTxt extends JFrame {
	
	private String idioma = "ES";
	private JTextPane txtMensaje;
	private JTextPane txtPersonaje;
	private Mensaje m = null;
	private AccesoDBEscaperoom bd= null;
	private JPanel panelMensajes;
	
	public TestTxt(AccesoDBEscaperoom bd) throws ClassNotFoundException, SQLException {
		this.bd = bd;	
		m = bd.getMensaje(1, idioma);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelMensajes = new JPanel();
		panelMensajes.setBounds(0, 0, 800, 600);
		panelMensajes.setLayout(null);
		contentPane.add(panelMensajes);
		
		JButton btnES = new JButton("");
		btnES.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idioma = "ES";
				cambiarIdioma(m);
			}
		});
		btnES.setIcon(new ImageIcon("D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom_prueba\\resources\\spain.png"));
		btnES.setBounds(114, 122, 59, 40);
		panelMensajes.add(btnES);
		
		JButton btnEN = new JButton("");
		btnEN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				idioma = "EN";
				cambiarIdioma(m);
			}

		});
		btnEN.setIcon(new ImageIcon("D:\\amaia\\programacion\\amaia-daw1\\10_reto2\\escaperoom_prueba\\resources\\united-kingdom.png"));
		btnEN.setBounds(181, 122, 59, 40);
		panelMensajes.add(btnEN);
		
		txtMensaje = new JTextPane();
		txtMensaje.setBounds(124, 222, 465, 127);
		panelMensajes.add(txtMensaje);		
		txtMensaje.setText(m.getTexto());
		
		txtPersonaje = new JTextPane();
		txtPersonaje.setEditable(false);
		txtPersonaje.setForeground(Color.BLACK);
		txtPersonaje.setBackground(Color.WHITE);
		txtPersonaje.setText((String) null);
		txtPersonaje.setBounds(114, 173, 243, 40);
		panelMensajes.add(txtPersonaje);
		txtPersonaje.setText(m.getLocutor());
	    txtPersonaje.setBorder(new CompoundBorder(BorderFactory.createLineBorder(Color.BLUE, 2, true),  new EmptyBorder(10,10,10,10)));
		
		JButton btnMas = new JButton(">");
		btnMas.setBounds(555, 348, 41, 35);
		panelMensajes.add(btnMas);
		
		btnMas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idMsg = m.getId();
				idMsg++;
				try {
					m = bd.getMensaje(idMsg, idioma);
					if(m!=null) {
						mostrarMensaje(m);
					} else {
						cerrarMensajes();
					}
					
				} catch (ClassNotFoundException | SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblMsgFondo = new JLabel("");
		lblMsgFondo.setBackground(Color.WHITE);
		lblMsgFondo.setBounds(114, 214, 482, 169);
		lblMsgFondo.setOpaque(true);
		//TitledBorder title;
		//title = BorderFactory.createTitledBorder(loweredBevel, m.getLocutor());
		//lblMsgFondo.setBorder(BorderFactory.createTitledBorder(m.getLocutor()));
		lblMsgFondo.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2, true));
		panelMensajes.add(lblMsgFondo);
		
			
			
	}

	protected void cerrarMensajes() {
		panelMensajes.setVisible(false);
		
	}

	public void cambiarIdioma(Mensaje m) {
		int idMsg = m.getId();
		try {
			m = bd.getMensaje(idMsg, idioma);
			mostrarMensaje(m);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}

	public void mostrarMensaje(Mensaje m) {
		txtMensaje.setText(m.getTexto());
		txtPersonaje.setText(m.getLocutor());
	}
}
