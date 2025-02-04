package view_nv1;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class view_lore1 extends JFrame{
private static final long serialVersionUID = 1L;
private JPanel contentPane;
private JTextField tiempo_textField;
private JTextPane textPane;
private int contador = 0;
private int segundos=3600;




public view_lore1() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(0, 0, 1100, 750);
	contentPane = new JPanel();
	contentPane.setBackground(Color.BLACK);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	contentPane.setLayout(null);
	
	JButton pasar_Button = new JButton("");
	pasar_Button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
			new view_habitacion();
		}
	});
	pasar_Button.setBounds(310, 580, 605, 120);
	pasar_Button.setOpaque(true);
	pasar_Button.setContentAreaFilled(false);
	pasar_Button.setBorderPainted(false);
	contentPane.add(pasar_Button);
	
	JTextArea dialogo_textArea = new JTextArea("Es una mañana de primavera, bruno se levanta con sueño acompañado de los gritos de su madre.\n"
			+"¡Hijoooooooooooo! a desayunar");
	dialogo_textArea.setEditable(false);
	dialogo_textArea.setBounds(310, 580, 605, 120);
	contentPane.add(dialogo_textArea);
	
}
}
