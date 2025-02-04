package view_nv1;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Font;

public class view_pasoCocina extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public view_pasoCocina() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(125, 150, 400, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Ir a la cocina");
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new view_cocina();
			}
		});
		btnNewButton.setBounds(123, 217, 122, 33);
		contentPane.add(btnNewButton);
		
		JTextArea textArea = new JTextArea("Al acabar de vestirte, escuchas a tu madre desde la cocina:\n"
				+ "\r\n"
				+"-Cariñooo a desayunar.\n"
				+ "\r\n"
				+"-Voyyy!!!.\r\n"
				+ "\r\n"
				+"Gritaste a toda voz tras salir del salon");
		textArea.setForeground(SystemColor.activeCaptionText);
		textArea.setFont(new Font("Noto Sans Cond", Font.PLAIN, 16));
		textArea.setBackground(Color.LIGHT_GRAY);
		textArea.setBounds(10, 11, 364, 196);
		contentPane.add(textArea);
			
		setVisible(true);
	}
}
