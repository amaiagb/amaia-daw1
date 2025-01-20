package ventanas.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;

public class juego extends JFrame {

	private JPanel contentPane;
	private JTextField txtPlayer1;
	private JTextField txtPlayer2;
	private JLabel lblP1Img;
	private JLabel lblP2Img;
	private JLabel lblP1Puntos;
	private JTextField txtP1Puntos;
	private JLabel lblP2Puntos;
	private JTextField txtP2Puntos;
	private JLabel lblSeleccion;
	private JLabel lblP1Gana;
	private JLabel lblP2Gana;
	private int p1Seleccion;
	private String p1SeleccionTxt;
	private String p2SeleccionTxt;
	private int ganador;

	public juego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 605);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbltitulo = new JLabel("Piedra, papel o tijera");
		lbltitulo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lbltitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lbltitulo.setBounds(10, 11, 697, 43);
		contentPane.add(lbltitulo);

		txtPlayer1 = new JTextField();
		txtPlayer1.setEditable(false);
		txtPlayer1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPlayer1.setBackground(Color.LIGHT_GRAY);
		txtPlayer1.setText("Player 1");
		txtPlayer1.setBounds(150, 110, 176, 34);
		contentPane.add(txtPlayer1);
		txtPlayer1.setColumns(10);

		txtPlayer2 = new JTextField();
		txtPlayer2.setEditable(false);
		txtPlayer2.setText("Computer");
		txtPlayer2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPlayer2.setColumns(10);
		txtPlayer2.setBackground(Color.LIGHT_GRAY);
		txtPlayer2.setBounds(407, 110, 176, 34);
		contentPane.add(txtPlayer2);

		lblP1Img = new JLabel("");
		lblP1Img.setBackground(Color.WHITE);
		lblP1Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblP1Img.setBounds(150, 155, 176, 170);
		lblP1Img.setOpaque(true);
		contentPane.add(lblP1Img);

		lblP2Img = new JLabel("");
		lblP2Img.setOpaque(true);
		lblP2Img.setHorizontalAlignment(SwingConstants.CENTER);
		lblP2Img.setBackground(Color.WHITE);
		lblP2Img.setBounds(407, 155, 176, 170);
		contentPane.add(lblP2Img);

		lblP1Puntos = new JLabel("Puntos:");
		lblP1Puntos.setBounds(150, 336, 46, 23);
		contentPane.add(lblP1Puntos);

		txtP1Puntos = new JTextField();
		txtP1Puntos.setText("0");
		txtP1Puntos.setEditable(false);
		txtP1Puntos.setBounds(206, 336, 86, 23);
		contentPane.add(txtP1Puntos);
		txtP1Puntos.setColumns(10);

		lblP2Puntos = new JLabel("Puntos:");
		lblP2Puntos.setBounds(407, 336, 46, 23);
		contentPane.add(lblP2Puntos);

		txtP2Puntos = new JTextField();
		txtP2Puntos.setText("0");
		txtP2Puntos.setEditable(false);
		txtP2Puntos.setColumns(10);
		txtP2Puntos.setBounds(463, 336, 86, 23);
		contentPane.add(txtP2Puntos);

		lblSeleccion = new JLabel("Selecciona tu pr\u00F3xima arma:");
		lblSeleccion.setForeground(Color.WHITE);
		lblSeleccion.setBackground(Color.DARK_GRAY);
		lblSeleccion.setOpaque(true);
		lblSeleccion.setBounds(150, 401, 433, 23);
		contentPane.add(lblSeleccion);

		JButton btnPiedra = new JButton("Piedra");
		btnPiedra.setBounds(217, 434, 89, 50);
		contentPane.add(btnPiedra);

		JButton btnPapel = new JButton("Papel");
		btnPapel.setBounds(316, 434, 89, 50);
		contentPane.add(btnPapel);

		JButton btnTijera = new JButton("Tijera");
		btnTijera.setBounds(415, 434, 89, 50);
		contentPane.add(btnTijera);

		lblP1Gana = new JLabel("Gana");
		lblP1Gana.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblP1Gana.setHorizontalAlignment(SwingConstants.CENTER);
		lblP1Gana.setBounds(150, 65, 176, 34);
		contentPane.add(lblP1Gana);
		lblP1Gana.setVisible(false);

		lblP2Gana = new JLabel("Gana");
		lblP2Gana.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblP2Gana.setHorizontalAlignment(SwingConstants.CENTER);
		lblP2Gana.setBounds(407, 65, 176, 34);
		contentPane.add(lblP2Gana);
		lblP2Gana.setVisible(false);

		btnPiedra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1Seleccion = 1;
				lblP1Img.setIcon(new ImageIcon(System.getProperty("user.dir")+"\\src\\resources\\piedra_img.png"));
				hacerBatalla(p1Seleccion);
			}
		});
		
		btnPapel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1Seleccion = 2;
				lblP1Img.setIcon(new ImageIcon(System.getProperty("user.dir")+"\\src\\resources\\papel_img.png"));
				hacerBatalla(p1Seleccion);
			}
		});
		
		btnTijera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				p1Seleccion = 3;
				lblP1Img.setIcon(new ImageIcon(System.getProperty("user.dir")+"\\src\\resources\\tijeras_img.png"));
				hacerBatalla(p1Seleccion);
			}
		});
	}

	private void hacerBatalla(int p1Seleccion) {
		
		//resetear
		lblP1Gana.setVisible(false);
		lblP2Gana.setVisible(false);
		lblP1Gana.setText("Gana");
		lblP2Gana.setText("Gana");
		txtPlayer1.setBackground(Color.LIGHT_GRAY);
		txtPlayer2.setBackground(Color.LIGHT_GRAY);
		
		// mostrar seleccion de p1
		
		p1SeleccionTxt = obtenerTxtSeleccion(p1Seleccion);
		lblP1Img.setText(p1SeleccionTxt);

		// generar seleccion de p2 aleatoriamente
		int p2Seleccion;
		Random random = new Random();
		p2Seleccion = random.nextInt(3) + 1;
		p2SeleccionTxt = obtenerTxtSeleccion(p2Seleccion);
		lblP2Img.setText(p2SeleccionTxt);
		mostrarImagen(p2Seleccion);
		
		// comparar

		if (p1Seleccion == 1) { // piedra
			if (p2Seleccion == 2) { // papel
				ganador = 2;
			} else if (p2Seleccion == 3) { // tijera
				ganador = 1;
			} else {
				ganador = 0;
			}
		} else if (p1Seleccion == 2) { // papel
			if (p2Seleccion == 1) { // piedra
				ganador = 1;
			} else if (p2Seleccion == 3) { // tijera
				ganador = 2;
			} else {
				ganador = 0;
			}
		} else if (p1Seleccion == 3) { // tijera
			if (p2Seleccion == 1) { // piedra
				ganador = 2;
			} else if (p2Seleccion == 2) { // papel
				ganador = 1;
			} else {
				ganador = 0;
			}
		}

		// gestionar ganador
		switch (ganador) {
		case 1 -> { //gana P1
			int puntos = Integer.parseInt(txtP1Puntos.getText())+1;
			txtP1Puntos.setText(String.valueOf(puntos));
			lblP1Gana.setVisible(true);
			txtPlayer1.setBackground(Color.ORANGE);
			
		}
		case 2 -> { //gana P2
			int puntos = Integer.parseInt(txtP2Puntos.getText())+1;
			txtP2Puntos.setText(String.valueOf(puntos));
			lblP2Gana.setVisible(true);
			txtPlayer2.setBackground(Color.ORANGE);
		}
		case 0 -> { //empate
			lblP1Gana.setText("Empate");
			lblP2Gana.setText("Empate");
			lblP1Gana.setVisible(true);
			lblP2Gana.setVisible(true);
		}
		}

	}

	private String obtenerTxtSeleccion(int seleccion) {
		String seleccionTxt = "";
		switch (seleccion) {
		case 1 -> {
			seleccionTxt = "Piedra";
		}
		case 2 -> {
			seleccionTxt = "Papel";
		}
		case 3 -> {
			seleccionTxt = "Tijera";
		}
		case 0 -> {
			seleccionTxt = "Error";
		}
		}
		return seleccionTxt;

	}
	private void mostrarImagen(int seleccion){
		switch(seleccion) {
		case 1->{
			lblP2Img.setIcon(new ImageIcon(System.getProperty("user.dir")+"\\src\\resources\\piedra_img.png"));
		}
		case 2->{
			lblP2Img.setIcon(new ImageIcon(System.getProperty("user.dir")+"\\src\\resources\\papel_img.png"));
		}
		case 3->{
			lblP2Img.setIcon(new ImageIcon(System.getProperty("user.dir")+"\\src\\resources\\tijeras_img.png"));
		}
		}
	}
}
