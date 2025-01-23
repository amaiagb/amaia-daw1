package escaperoom_prueba.ui;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Escena4 extends JPanel {
	
	private static final String IMG_DIR = System.getProperty("user.dir")+"\\resources\\";
	
	public Escena4(JPanel contentPane) {
		this.setBounds(0, 53, 784, 508);
		contentPane.add(this);
		this.setLayout(null);

		JLabel lblfondo4 = new JLabel("");
		lblfondo4.setIcon(new ImageIcon(IMG_DIR+"bus3.jpg"));
		lblfondo4.setBounds(0, 0, 784, 505);
		this.add(lblfondo4);
		
	}
}
