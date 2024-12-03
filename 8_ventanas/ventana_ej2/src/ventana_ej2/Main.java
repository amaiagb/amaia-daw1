package ventana_ej2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

	public static void main(String[] args) {
		
		JFrame ventana = new JFrame("Cambiar color de fondo");
		ventana.setBounds(50,50,400,350);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLayout(null);
		
		JLabel lblTitle = new JLabel("Cambiar color de fondo:");
		lblTitle.setBounds(50, 50, 150, 30);
		ventana.add(lblTitle);
		
		JButton btnRojo = new JButton("Rojo");
		btnRojo.setBounds(50,100,100,30);
		ventana.add(btnRojo);

		JButton btnVerde = new JButton("Verde");
		btnVerde.setBounds(150,100,100,30);
		ventana.add(btnVerde);

		JButton btnAzul = new JButton("Azul");
		btnAzul.setBounds(250,100,100,30);
		ventana.add(btnAzul);

		
		btnRojo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.getContentPane().setBackground(Color.RED);
			}
		});
		
		btnVerde.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.getContentPane().setBackground(Color.GREEN);
			}
		});
		
		btnAzul.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.getContentPane().setBackground(Color.BLUE);
			}
		});
		
		ventana.setVisible(true);

	}

}
