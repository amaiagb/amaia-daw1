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

public class taquillas extends JFrame {

	private JPanel contentPane;

	public taquillas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAccesoTaquilla = new JButton("");
		 btnAccesoTaquilla.setOpaque(true);
		 btnAccesoTaquilla.setContentAreaFilled(false);
		 btnAccesoTaquilla.setBorderPainted(false);
		btnAccesoTaquilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zoomtaquilla zoomtaquilla = new zoomtaquilla();
				zoomtaquilla.setVisible(true);
				dispose();
			}
		});
		btnAccesoTaquilla.setBounds(530, 269, 54, 204);
		contentPane.add(btnAccesoTaquilla);
		
		JLabel lblTaquillas = new JLabel("New label");
		lblTaquillas.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\pasillo con taquilas.jpg"));
		lblTaquillas.setBounds(0, 0, 1084, 711);
		contentPane.add(lblTaquillas);
	}

}
