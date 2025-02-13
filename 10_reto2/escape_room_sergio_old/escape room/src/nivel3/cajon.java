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
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class cajon extends JFrame {

	private JPanel contentPane;

	public cajon() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1100, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnFlecha = new JButton("");
		btnFlecha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clase clase = new clase();
				clase.setVisible(true);
				dispose();
			}
			clase clase = new clase();
		});
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
		btnFlecha.setVisible(true);
		
		JTextArea txtrPareceQueEsta = new JTextArea();
		txtrPareceQueEsta.setText("Parece que esta vacio");
		txtrPareceQueEsta.setBounds(0, 656, 1084, 55);
		contentPane.add(txtrPareceQueEsta);
		
		btnFlecha.setOpaque(true);
		btnFlecha.setBorderPainted(false);
		btnFlecha.setContentAreaFilled(false);
		btnFlecha.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\flechas\\flechaIzquierda.png"));
		btnFlecha.setBounds(34, 327, 100, 55);
		contentPane.add(btnFlecha);
		
		JLabel lblZoomCajon = new JLabel("New label");
		lblZoomCajon.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\Cajon.jpg"));
		lblZoomCajon.setBounds(0, 0, 1100, 711);
		contentPane.add(lblZoomCajon);
		
	}

}
