package ventana_ej3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main {

	public static void main(String[] args) {
		JFrame ventana = new JFrame("Validar número");
		ventana.setBounds(50,50,400,350);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setLayout(null);
		
		JLabel lblTitle = new JLabel("Validar número");
		lblTitle.setBounds(50, 50, 150, 50);
		ventana.add(lblTitle);
		
		JLabel lblNum1 = new JLabel("Escribir Número:");
		lblNum1.setBounds(50, 100, 100, 30);
		ventana.add(lblNum1);
		
		JTextField txtNum = new JTextField();
		txtNum.setBounds(150,100,50,30);
		ventana.add(txtNum);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.setBounds(50,180,100,30);
		ventana.add(btnValidar);
		
		JLabel lblResultado = new JLabel();
		lblResultado.setBounds(50,220,100,30);
		ventana.add(lblResultado);
		
		btnValidar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent event) {

				try {
				int num = Integer.parseInt(txtNum.getText());	
					lblResultado.setText("Es un número");
				
				} catch(NumberFormatException e) {
					lblResultado.setText("No es un número");	
				}
				
				
			}
		});
		
		ventana.setVisible(true);

	}

}
