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

public class pasillo2 extends JFrame {

	private JPanel contentPane;
 
	public pasillo2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPuertaTaqui = new JButton("");
		btnPuertaTaqui.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnPuertaTaqui.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		btnPuertaTaqui.setOpaque(true);
		btnPuertaTaqui.setContentAreaFilled(false);
		btnPuertaTaqui.setBorderPainted(false);
		btnPuertaTaqui.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				taquillas taquillas = new taquillas();
				taquillas.setVisible(true);
				dispose();
			}
		});
		btnPuertaTaqui.setBounds(120, 251, 39, 287);
		contentPane.add(btnPuertaTaqui);
		
		JLabel lblPuertaIzquierda = new JLabel("New label");
		lblPuertaIzquierda.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\pasilloOriginal.jpg"));
		lblPuertaIzquierda.setBounds(0, 0, 1084, 711);
		contentPane.add(lblPuertaIzquierda);
	}

}
