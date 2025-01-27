package cardLayoutTest.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private CardLayout cardLayout;
	private JPanel panelEscenas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		Ventana frame = new Ventana();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public Ventana() {
		setResizable(false);
		setTitle("Escape Room");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 400);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 592, 361);
		contentPane.add(layeredPane);
		
		JPanel panelNavBar = new JPanel();
		panelNavBar.setBackground(Color.GRAY);
		panelNavBar.setBounds(0, 0, 590, 37);
		panelNavBar.setLayout(null);
		layeredPane.add(panelNavBar);
		
		JPanel panelDialogo = new JPanel();
		panelDialogo.setBackground(Color.GRAY);
		panelDialogo.setBounds(0, 287, 590, 76);
		panelDialogo.setLayout(null);
		layeredPane.add(panelDialogo);
		
		JPanel panelInventario = new JPanel();
		panelInventario.setBackground(new Color(95, 158, 160));
		panelInventario.setBounds(103, 80, 369, 161);
		panelInventario.setLayout(null);
		layeredPane.add(panelInventario, JLayeredPane.MODAL_LAYER);
		panelInventario.setVisible(false);
		
		JPanel panelPistas = new JPanel();
		panelPistas.setBounds(200, 50, 179, 228);
		layeredPane.add(panelPistas);
		panelPistas.setBackground(new Color(222, 184, 135));
		panelPistas.setLayout(null);
		layeredPane.add(panelPistas, JLayeredPane.MODAL_LAYER);
		panelPistas.setVisible(false);
		
		panelEscenas = new JPanel();
		panelEscenas.setBounds(0, 0, 590, 363);
		layeredPane.add(panelEscenas);
		
		cardLayout = new CardLayout();
		panelEscenas.setLayout(cardLayout);
		
		panelEscenas.add(new Escena1(this),"Escena 1");
		panelEscenas.add(new Escena2(this),"Escena 2");
		
		
	}
	
	public void cambiarEscena(String nombreEscena) {
		cardLayout.show(panelEscenas, nombreEscena);
	}
}
