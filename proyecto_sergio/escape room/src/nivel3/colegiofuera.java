package nivel3;

import java.awt.BorderLayout;
import java.awt.Cursor;
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

public class colegiofuera extends JFrame {

	private JPanel contentPane;

	public colegiofuera() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPuertaColegio = new JButton("");
		btnPuertaColegio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPuertaColegio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnPuertaColegio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pasillo pasillo = new pasillo();
				pasillo.setVisible(true);
				dispose();
			}
		});
		btnPuertaColegio.setBounds(511, 443, 75, 82);
		btnPuertaColegio.setOpaque(true);
		btnPuertaColegio.setContentAreaFilled(false);
		btnPuertaColegio.setBorderPainted(false);
		contentPane.add(btnPuertaColegio);
		
		
		JLabel lblImagenColegio = new JLabel("New label");
		lblImagenColegio.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\Leonardo_Phoenix_10_estilo_animado_3d_de_un_instituto_moderno_0.jpg"));
		lblImagenColegio.setBounds(0, 0, 1084, 711);
		contentPane.add(lblImagenColegio);
	}
}
