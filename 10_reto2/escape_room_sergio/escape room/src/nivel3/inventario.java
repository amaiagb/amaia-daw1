package nivel3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class inventario extends JFrame{

	private JPanel contentPane;
	private JTextField textField;
	
	public inventario () {
	
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(0, 0, 400, 300);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JButton btnSalirInventario = new JButton("Volver al juego");
	btnSalirInventario.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	});
	btnSalirInventario.setBounds(248, 227, 126, 23);
	contentPane.add(btnSalirInventario);
	
	JLabel lblNewLabel = new JLabel("New label");
	lblNewLabel.setIcon(new ImageIcon("D:\\SERGIO\\escape room\\inventariooo final.jpg"));
	lblNewLabel.setBounds(0, 0, 384, 261);
	contentPane.add(lblNewLabel);
	setVisible(true);
	
	
	}
}
