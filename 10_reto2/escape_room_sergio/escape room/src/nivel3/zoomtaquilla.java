package nivel3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class zoomtaquilla extends JFrame {

	private JPanel contentPane;
	
	public zoomtaquilla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1100, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnAdivinaContrasena = new JButton("");
		btnAdivinaContrasena.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adivinaCodigo AdivinaCodigo = new adivinaCodigo();
				AdivinaCodigo.setVisible(true);
				AdivinaCodigo.setLocationRelativeTo(null);
			}
		});
		btnAdivinaContrasena.setBounds(592, 32, 193, 668);
		btnAdivinaContrasena.setVisible(true);
		
		JButton btnFlecha = new JButton("");
		btnFlecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taquillas taquillas = new taquillas();
				taquillas.setVisible(true);
				dispose();
			}
		});
		btnFlecha.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\flechas\\flechaIzquierda.png"));
		btnFlecha.setBounds(29, 430, 89, 49);
		btnFlecha.setOpaque(true);
		btnFlecha.setBorderPainted(false);
		btnFlecha.setContentAreaFilled(false);
		contentPane.add(btnFlecha);
		btnAdivinaContrasena.setBorderPainted(false);
		btnAdivinaContrasena.setContentAreaFilled(false);
		contentPane.add(btnAdivinaContrasena);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\zoomtaquilla.jpg"));
		lblNewLabel.setBounds(0, 0, 1084, 711);
		contentPane.add(lblNewLabel);
	
		
	}
}
