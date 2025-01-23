package audioTest.ui;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	private JPanel contentPane;
	private Clip clip;

	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 513, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reproducirMusica();
			}
		});
		btnPlay.setBounds(201, 173, 89, 23);
		contentPane.add(btnPlay);
		
		
	}
	 
	 public void reproducirMusica() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }

        new Thread(() -> {
            try {
                File musica = new File(System.getProperty("user.dir")+"\\audio\\loop.wav");
                if (!musica.exists()) {
                    System.err.println("El archivo no existe: " + musica.getAbsolutePath());
                    return;
                }

                try (AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(musica)) {
                    clip = (Clip) AudioSystem.getLine(new DataLine.Info(Clip.class, audioInputStream.getFormat()));
                    clip.open(audioInputStream);
                    clip.start();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

}
