package parejas.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.Carta;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class tablero extends JFrame {

	private JPanel contentPane;
	private boolean carta1Cara = false;
	private boolean carta2Cara = false;
	private boolean carta3Cara = false;
	private boolean carta4Cara = false;
	private int cartasLevantadas = 0;
	private int carta1 = 0;
	private int carta2 = 0;
	private int parejasResueltas = 0;
	
	public tablero(ArrayList<Carta> cartas) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 892, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCarta1 = new JLabel("verde");
		lblCarta1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jugar(1,lblCarta1, cartas);
			}			
		});
		lblCarta1.setIcon(new ImageIcon("C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\parejas\\resources\\img0.jpg"));
		lblCarta1.setBounds(70, 70, 154, 137);
		contentPane.add(lblCarta1);
		
		JLabel lblCarta2 = new JLabel("rojo");
		lblCarta2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jugar(2,lblCarta2, cartas);
			}
		});
		lblCarta2.setIcon(new ImageIcon("C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\parejas\\resources\\img0.jpg"));
		lblCarta2.setBounds(243, 70, 154, 137);
		contentPane.add(lblCarta2);
		
		JLabel lblCarta3 = new JLabel("amarillo");
		lblCarta3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jugar(3,lblCarta3, cartas);
			}
		});
		lblCarta3.setIcon(new ImageIcon("C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\parejas\\resources\\img0.jpg"));
		lblCarta3.setBounds(70, 218, 154, 137);
		contentPane.add(lblCarta3);
		
		JLabel lblCarta4 = new JLabel("rojo");
		lblCarta4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jugar(4,lblCarta4, cartas);
			}
		});
		lblCarta4.setIcon(new ImageIcon("C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\parejas\\resources\\img0.jpg"));
		lblCarta4.setBounds(243, 218, 154, 137);
		contentPane.add(lblCarta4);
		

		
	}
	private void jugar(int idCarta, JLabel lblCarta, ArrayList<Carta> cartas) {
		if(carta1 == 0) {
			carta1 = idCarta;
			String imgFile = cartas.get(idCarta-1).getImgFile();
			System.out.println(imgFile);
			System.out.println(cartas.get(idCarta-1).getColor());
			lblCarta.setIcon(new ImageIcon(imgFile));
			cartasLevantadas++;
			System.out.println(cartasLevantadas);
		}else if(carta2 == 0) {
			carta2 = idCarta;
			String imgFile = cartas.get(idCarta-1).getImgFile();
			lblCarta.setIcon(new ImageIcon(imgFile));
			cartasLevantadas++;
			System.out.println(cartasLevantadas);
		}
		if (cartasLevantadas == 2) {
			
			if(cartas.get(carta1-1).getColor().equals(cartas.get(carta2-1).getColor())) {
				parejasResueltas++;
				System.out.println(parejasResueltas);
			}
			
			carta1 = 0;
			carta2 = 0;
			cartasLevantadas = 0;
			
			
		}
		
	}
	private void voltearCarta(JLabel lblCarta) {
		
		if(!carta1Cara) {
			lblCarta.setIcon(new ImageIcon("C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\parejas\\resources\\img1.jpg"));
			carta1Cara = true;
			cartasLevantadas++;
		} else {
			lblCarta.setIcon(new ImageIcon("C:\\Users\\Amaia\\eclipse-workspace\\amaia-daw1\\10_reto2\\parejas\\resources\\img0.jpg"));
			carta1Cara = false;
		}
	}
}
