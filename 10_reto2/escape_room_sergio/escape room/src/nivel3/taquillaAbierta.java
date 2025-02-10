package nivel3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class taquillaAbierta extends JFrame {

	private JPanel contentPane;


	public taquillaAbierta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1100, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFlecha = new JButton("");
		btnFlecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taquillas taquillas = new taquillas();
				taquillas.setVisible(true);
			}
		});
		btnFlecha.setOpaque(true);
		btnFlecha.setBorderPainted(true);
		btnFlecha.setContentAreaFilled(false);
		btnFlecha.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\flechas\\flechaIzquierda.png"));
		btnFlecha.setBounds(36, 320, 107, 71);
		contentPane.add(btnFlecha);
		
		JLabel lblChincheta = new JLabel("");
		lblChincheta.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\chincheta.png"));
		lblChincheta.setBounds(331, 272, 30, 24);
		contentPane.add(lblChincheta);
		
		JLabel lblCromo = new JLabel("");
		lblCromo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblCromo.setVisible(false);
			}
		});
		lblCromo.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\iniestataq.png"));
		lblCromo.setBounds(282, 287, 79, 40);
		contentPane.add(lblCromo);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\taquillaAbierta.jpg"));
		lblNewLabel.setBounds(0, 0, 1084, 711);
		contentPane.add(lblNewLabel);
	}
}
