package tests;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class VentanaInicioInventario extends JFrame {

	private JPanel contentPane;

	public VentanaInicioInventario(ArrayList<Objeto> objetos) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1920, 1080);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JButton btnAbrirInventario = new JButton("Abrir Inventario");
		btnAbrirInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("abrir");
				System.out.println(contentPane.getComponentCount());
				PanelInventario inventario = new PanelInventario(objetos);
				contentPane.add(inventario);
				System.out.println(contentPane.getComponentCount());
				inventario.setVisible(true);
				inventario.setOpaque(true);
				
				
			}
		});
		btnAbrirInventario.setBounds(10, 237, 147, 23);
		contentPane.add(btnAbrirInventario);


	}

}
