package com.asej.escaperoom.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class PanelPistas extends JPanel {

	private JLabel lblPistasTitle;
	private static JLabel lblPista1;
	private static JLabel lblPista2;
	private static JLabel lblPista3;
	public static String[] pistas;
	private static JTextPane txtPista1;
	private static JTextPane txtPista2;
	private static JTextPane txtPista3;

	public PanelPistas() {
		
		setLayout(null);
		setBounds(208, 120, 664, 493);
		setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		
		txtPista1 = new JTextPane();
		txtPista1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		//txtPista1.setBackground(Color.DARK_GRAY);
		txtPista1.setOpaque(false);
		txtPista1.setForeground(Color.WHITE);
		txtPista1.setBounds(32, 114, 600, 56);
		centrarTexto(txtPista1);
		add(txtPista1);
		txtPista1.setVisible(false);
		
		lblPista1 = new JLabel("Desbloquear Pista 1");
		lblPista1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPista1.setBackground(Color.DARK_GRAY);
		lblPista1.setForeground(Color.WHITE);
		lblPista1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPista1.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblPista1.setOpaque(true);
		lblPista1.setBounds(32, 77, 600, 119);
		add(lblPista1);
		
		txtPista2 = new JTextPane();
		txtPista2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPista2.setBackground(Color.DARK_GRAY);
		txtPista2.setOpaque(false);
		txtPista2.setForeground(Color.WHITE);
		txtPista2.setBounds(32, 240, 600, 56);
		//txtPista2.setText("Para poder salir de casa necesitas completar las tareas de tu familia. \nBusca bien en el garaje y en el salón.");
		add(txtPista2);
		txtPista2.setVisible(false);
		centrarTexto(txtPista2);
		
		lblPista2 = new JLabel("Desbloquear Pista 2");
		lblPista2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPista2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPista2.setBackground(Color.DARK_GRAY);
		lblPista2.setForeground(Color.WHITE);
		lblPista2.setBounds(32, 207, 600, 119);
		lblPista2.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblPista2.setOpaque(true);
		add(lblPista2);
		
		txtPista3 = new JTextPane();
		txtPista3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		txtPista3.setBackground(Color.DARK_GRAY);
		txtPista3.setOpaque(false);
		txtPista3.setForeground(Color.WHITE);
		txtPista3.setBounds(32, 374, 600, 56);
		//txtPista3.setText("Las palabras que tienes que encontrar en la sopa de letras son: \n A _ _ _ _, B _ _ _ _ _ _ _, I _ _ _ _ _ _, D _ _ _, M _ _ _ _.");
		add(txtPista3);
		txtPista3.setVisible(false);
		centrarTexto(txtPista3);
		
		lblPista3 = new JLabel("Desbloquear Pista 3");
		lblPista3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPista3.setHorizontalAlignment(SwingConstants.CENTER);
		lblPista3.setBackground(Color.DARK_GRAY);
		lblPista3.setForeground(Color.WHITE);
		lblPista3.setBounds(32, 337, 600, 119);
		lblPista3.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblPista3.setOpaque(true);
		add(lblPista3);
		
		lblPista1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPista1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblPista1.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
				lblPista1.setText("");
				txtPista1.setVisible(true);
				txtPista1.setText(cargarPistas(Ventana.nivelActual)[0]);
			}
		});

		lblPista2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPista2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblPista2.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
				lblPista2.setText("");
				txtPista2.setVisible(true);
				txtPista2.setText(cargarPistas(Ventana.nivelActual)[1]);
			}
		});
		lblPista3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblPista3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				lblPista3.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
				lblPista3.setText("");
				txtPista3.setVisible(true);
				txtPista3.setText(cargarPistas(Ventana.nivelActual)[2]);
			}
		});
		
		JButton btnCerrarPistas = new JButton("x");
		btnCerrarPistas.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCerrarPistas.setBackground(Color.WHITE);
		btnCerrarPistas.setForeground(Color.BLACK);
		btnCerrarPistas.setBounds(618, 0, 45, 30);
		btnCerrarPistas.setOpaque(true);
		add(btnCerrarPistas);
		
		lblPistasTitle = new JLabel("Pistas");
		lblPistasTitle.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPistasTitle.setBackground(Color.BLACK);
		lblPistasTitle.setForeground(Color.WHITE);
		lblPistasTitle.setBounds(0, 0, 663, 30);
		lblPistasTitle.setBorder(new EmptyBorder(5, 10, 5, 5));
		lblPistasTitle.setOpaque(true);
		add(lblPistasTitle);
		
		JLabel lblFondo = new JLabel("");
		//lblFondo.setIcon(new ImageIcon("resources\\images\\esc5.jpg"));
		lblFondo.setBackground(Color.DARK_GRAY);
		lblFondo.setOpaque(true);
		lblFondo.setBounds(0, 0, 663, 493);
		add(lblFondo);
		
		btnCerrarPistas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
	}

	private void centrarTexto(JTextPane txtPista) {
		StyledDocument doc = txtPista.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
	}
	
	public static String[] cargarPistas(int nivelActual) {
		String[] pistas = new String[3];
		switch(nivelActual) {
		case 1 -> {
			pistas[0] = "Si no encuentras la mochila mira bien en tu habitación, cerca de la cama"; 
			pistas[1] = "Para poder salir de casa necesitas completar las tareas de tu familia. \nBusca bien en el garaje y en el salón.";
			pistas[2] = "Las palabras que tienes que encontrar en la sopa de letras son: \n A _ _ _ _, B _ _ _ _ _ _ _, I _ _ _ _ _ _, D _ _ _, M _ _ _ _.";
		}
		case 2 -> {
			pistas[0] = "Encuentra a Manuel y habla con él"; 
			pistas[1] = "Parece que algo brilla en el jarrón de la clase";
			pistas[2] = "Tal vez deberías mirar en las taquillas";
		}
		case 3 -> {
			pistas[0] = "Puede que en la pizarra encuentres algo que te ayude"; 
			pistas[1] = "Revisa la papelera de reciclaje y la galería de fotos. \n Parece que las fotos tienen todas algún número visible.";
			pistas[2] = "En los documentos encontrarás las credenciales necesarias para acceder al email";
		}
		}
		return pistas;
	}
	public static void resetearPistas(int nivelActual) {
		lblPista1.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblPista2.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblPista3.setBorder(BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
		lblPista1.setText("Desbloquear pista 1");
		lblPista2.setText("Desbloquear pista 2");
		lblPista3.setText("Desbloquear pista 3");
		txtPista1.setVisible(false);
		txtPista2.setVisible(false);
		txtPista3.setVisible(false);
		txtPista1.setText(cargarPistas(Ventana.nivelActual)[0]);
		txtPista2.setText(cargarPistas(Ventana.nivelActual)[1]);
		txtPista3.setText(cargarPistas(Ventana.nivelActual)[2]);
		
	}
}
