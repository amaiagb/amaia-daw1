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
import javax.swing.JTextArea;

public class conversacion extends JFrame {

	private JPanel contentPane;

	public conversacion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1100, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				colegiofuera colegio = new colegiofuera();
				colegio.setVisible(true);
				dispose();
			}
			
			
		});
		
		JTextArea txtrManuelBrunoNecesito = new JTextArea();
		txtrManuelBrunoNecesito.setText(" Manuel:\r\n Bruno, necesito encontrar el cromo como sea, empezaremos buscando por la clase de  informatica y si no encontramos nada, tendremos que ir a mirar en las taquillas.\r\n Vamos!!");
		txtrManuelBrunoNecesito.setBounds(0, 642, 940, 69);
		contentPane.add(txtrManuelBrunoNecesito);
		btnNewButton.setBounds(969, 660, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\manuell.jpg"));
		lblNewLabel.setBounds(0, 0, 1084, 711);
		contentPane.add(lblNewLabel);
	}
}
