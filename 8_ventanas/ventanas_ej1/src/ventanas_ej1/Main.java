package ventanas_ej1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {
		
		JFrame ventana = new JFrame("Calculadora de suma");
		ventana.setBounds(50,50,400,350);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLayout(null);
		
		JLabel lblTitle = new JLabel("Calculadora de suma");
		lblTitle.setBounds(50, 50, 150, 50);
		ventana.add(lblTitle);
		
		JLabel lblNum1 = new JLabel("Número 1:");
		lblNum1.setBounds(50, 100, 100, 30);
		ventana.add(lblNum1);
		
		JTextField txtNum1 = new JTextField();
		txtNum1.setBounds(150,100,50,30);
		ventana.add(txtNum1);
		
		JLabel lblNum2 = new JLabel("Número 2:");
		lblNum2.setBounds(50, 130, 100, 50);
		ventana.add(lblNum2);
		
		JTextField txtNum2 = new JTextField();
		txtNum2.setBounds(150,130,50,30);
		ventana.add(txtNum2);
		
		JButton btnSumar = new JButton("Sumar");
		btnSumar.setBounds(50,180,100,30);
		ventana.add(btnSumar);
		
		JLabel lblResultado = new JLabel();
		lblResultado.setBounds(50,220,100,30);
		ventana.add(lblResultado);
		
		btnSumar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int num1 = Integer.parseInt(txtNum1.getText());
				int num2 = Integer.parseInt(txtNum2.getText());
				lblResultado.setText(Integer.toString(num1+num2));
			}
		});
		
		ventana.setVisible(true);

	}

}
