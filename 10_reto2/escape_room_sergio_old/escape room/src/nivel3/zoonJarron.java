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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class zoonJarron extends JFrame {

	private JPanel contentPane;

	public zoonJarron() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1100, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFlecha = new JButton("");
		btnFlecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnFlecha.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\flechas\\flechaIzquierdaPintada.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnFlecha.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\flechas\\flechaIzquierda.png"));
			}
		});
		btnFlecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clase clase = new clase();
				clase.setVisible(true);
				dispose();
			}
		});
		btnFlecha.setVisible(false);
		btnFlecha.setOpaque(true);
		btnFlecha.setBorderPainted(false);
		btnFlecha.setContentAreaFilled(false);
		btnFlecha.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\flechas\\flechaIzquierda.png"));
		btnFlecha.setBounds(25, 330, 93, 54);
		contentPane.add(btnFlecha);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\jarronazoconllaveeee.png"));
		lblNewLabel.setBounds(0, 0, 1084, 711);
		contentPane.add(lblNewLabel);
		
		JButton btnllave = new JButton("");
		btnllave.setOpaque(true);
		btnllave.setBorderPainted(false);
		btnllave.setContentAreaFilled(false);
		
		btnllave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\jarronazosinllave.png"));
				btnFlecha.setVisible(true);
			}
		});
		btnllave.setBounds(565, 35, 74, 90);
		contentPane.add(btnllave);
		
		
	}
}
