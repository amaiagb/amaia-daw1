package escaperoom_prueba.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import tests.PanelInventario;

public class Escena4 extends JPanel {
	
	private static final String IMG_DIR = System.getProperty("user.dir")+"\\resources\\";
	
	public Escena4(JPanel contentPane) {
		this.setBounds(0, 53, 784, 508);
		contentPane.add(this);
		this.setLayout(null);

		JButton btnAbrirInventario = new JButton("Abrir Inventario");
		btnAbrirInventario.setBounds(100, 100, 147, 23);
		this.add(btnAbrirInventario);
		
		JLabel lblfondo4 = new JLabel("");
		lblfondo4.setIcon(new ImageIcon(IMG_DIR+"bus3.jpg"));
		lblfondo4.setBounds(0, 0, 784, 505);
		this.add(lblfondo4);
		
		
		
	}
}
