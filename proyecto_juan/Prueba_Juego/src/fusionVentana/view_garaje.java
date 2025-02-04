package fusionVentana;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class view_garaje extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tiempo_textField;
	private JTextPane textPane;
	private int contador = 0;
	private int segundos=3600;
	
	public view_garaje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1100, 750);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		
		JTextPane dialogo_textPane = new JTextPane();
		dialogo_textPane.setEditable(false);
		dialogo_textPane.setBounds(310, 580, 605, 120);
		contentPane.add(dialogo_textPane);
		
		JButton garaje_button = new JButton(">");
		garaje_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new view_sala();
			}
		});
		garaje_button.setBounds(1028, 344, 46, 64);
		contentPane.add(garaje_button);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\zImages\\garaje.jpg"));
		lblNewLabel.setBounds(0, 0, 1084, 711);
		contentPane.add(lblNewLabel);
		
		
		setVisible(true);

		
	}
}
