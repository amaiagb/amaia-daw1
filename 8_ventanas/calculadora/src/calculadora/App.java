package calculadora;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;

public class App {

	public static void main(String[] args) {
		JFrame ventana = new JFrame("Calculadora");
		ventana.getContentPane().setBackground(new Color(102, 205, 170));
		ventana.setBounds(0, 0, 325, 300);
		ventana.getContentPane().setLayout(null);
		
		JButton btn1 = new JButton("1");
		btn1.setBounds(28, 113, 51, 23);
		ventana.getContentPane().add(btn1);
		
		JLabel lblpantalla = new JLabel("");
		lblpantalla.setHorizontalAlignment(SwingConstants.RIGHT);
		lblpantalla.setForeground(new Color(255, 255, 255));
		lblpantalla.setOpaque(true);
		lblpantalla.setBackground(Color.DARK_GRAY);
		lblpantalla.setBounds(28, 44, 240, 40);
		ventana.getContentPane().add(lblpantalla);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn2.setBounds(92, 113, 51, 23);
		ventana.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setBounds(153, 113, 51, 23);
		ventana.getContentPane().add(btn3);
		
		JButton btn4 = new JButton("4");
		btn4.setBounds(28, 147, 51, 23);
		ventana.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setBounds(92, 147, 51, 23);
		ventana.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setBounds(153, 147, 51, 23);
		ventana.getContentPane().add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.setBounds(28, 181, 51, 23);
		ventana.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setBounds(92, 181, 51, 23);
		ventana.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setBounds(153, 181, 51, 23);
		ventana.getContentPane().add(btn9);
		
		JButton btn0 = new JButton("0");
		btn0.setBounds(92, 215, 51, 23);
		ventana.getContentPane().add(btn0);
		
		JButton btnSumar = new JButton("+");
		btnSumar.setBounds(217, 113, 51, 23);
		ventana.getContentPane().add(btnSumar);
		
		JButton btnRestar = new JButton("-");
		btnRestar.setBounds(217, 147, 51, 23);
		ventana.getContentPane().add(btnRestar);
		
		JButton btnMultiplicar = new JButton("x");
		btnMultiplicar.setBounds(217, 181, 51, 23);
		ventana.getContentPane().add(btnMultiplicar);
		
		JButton btnDividir = new JButton("/");
		btnDividir.setBounds(217, 215, 51, 23);
		ventana.getContentPane().add(btnDividir);
		
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblpantalla.setText("1");
			}
		});
		
		ventana.setVisible(true);

	}
}
