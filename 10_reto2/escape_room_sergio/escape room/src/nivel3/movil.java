package nivel3;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class movil extends JFrame {

	private JPanel contentPane;

	public movil() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1100, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\movillllllllllllllllllll.png"));
		lblNewLabel.setBounds(855, 657, 205, 267);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\pruebamovil.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\movillllllllllllllllllll.png"));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				movil2 movil2 = new movil2();
				movil2.setVisible(true);
				dispose();
			}
		});
		contentPane.add(lblNewLabel);
		
		
		
		JLabel lblColegio = new JLabel("");
		
		lblColegio.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\afueracolemovil.png"));
		lblColegio.setBounds(0, 0, 1084, 711);
		contentPane.add(lblColegio);
	}
}
