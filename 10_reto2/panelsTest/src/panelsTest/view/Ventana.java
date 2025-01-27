package panelsTest.view;

import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import panelTest.model.Objeto;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLayeredPane;

public class Ventana extends JFrame{

	private JPanel contentPane;
	private ArrayList<Objeto> objetos = new ArrayList<Objeto>();
	
	public Ventana(ArrayList<Objeto> objetos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 600);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		//setUndecorated(true);
		//getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 1200, 600);
		contentPane.add(layeredPane);
		
		JButton btnIzq = new JButton("<");
		layeredPane.setLayer(btnIzq, 5);
		btnIzq.setBounds(10, 300, 50, 64);
		layeredPane.add(btnIzq);
		
		JButton btnDer = new JButton(">");
		layeredPane.setLayer(btnDer, 5);
		btnDer.setBounds(1000, 300, 50, 64);
		layeredPane.add(btnDer);
		
		JButton btnInventario = new JButton("Inventario");
		layeredPane.setLayer(btnInventario, 5);
		btnInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Inventario: "+objetos.size());
				Inventario inventario = new Inventario(objetos);
				layeredPane.add(inventario);
				layeredPane.setLayer(inventario,5);
				inventario.setVisible(true);
				
			}
		});
		btnInventario.setBounds(10, 10, 100, 40);
		layeredPane.add(btnInventario);
		
		Esc1 esc1 = new Esc1(objetos);
		layeredPane.add(esc1);
		layeredPane.setLayer(esc1, 0);
		esc1.setVisible(true);
		/*
		Inventario inventario = new Inventario(objetos);
		layeredPane.setLayer(inventario,5);
		layeredPane.add(inventario);
		inventario.setVisible(true);
		*/
	}
}
