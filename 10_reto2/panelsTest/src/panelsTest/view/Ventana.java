package panelsTest.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class Ventana extends JFrame{

	private JPanel contentPane;
	
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1500, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		contentPane.setLayout(null);
		setContentPane(contentPane);
		//setUndecorated(true);
		//getRootPane().setWindowDecorationStyle(JRootPane.NONE);
		
		JButton btnIzq = new JButton("<");
		btnIzq.setBounds(10, 446, 50, 64);
		contentPane.add(btnIzq);
		
		JButton btnDer = new JButton(">");
		btnDer.setBounds(1400, 446, 50, 64);
		contentPane.add(btnDer);
		
		Esc1 esc1 = new Esc1();
		contentPane.add(esc1);
		esc1.setVisible(true);
	}
	
}
