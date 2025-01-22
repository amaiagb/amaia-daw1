

	import javax.swing.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class timer {
	    private static int segundos = 3600; // Contador de segundos
	    private static Timer timer; // Temporizador

	    public static void main(String[] args) {
	        // Crear la ventana (JFrame)
	        JFrame ventana = new JFrame("Cron�metro");
	        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        ventana.setSize(300, 200);
	        ventana.setLayout(null);

	        // Crear el JLabel para mostrar el tiempo
	        JLabel labelTiempo = new JLabel("Tiempo: 0 segundos");
	        labelTiempo.setBounds(50, 50, 200, 30);

	        // Bot�n para iniciar el cron�metro
	        JButton btnIniciar = new JButton("Iniciar");
	        btnIniciar.setBounds(50, 100, 80, 30);

	        // Bot�n para detener el cron�metro
	        JButton btnDetener = new JButton("Detener");
	        btnDetener.setBounds(150, 100, 80, 30);
	        btnDetener.setEnabled(false); // Comienza deshabilitado

	        // Crear el Timer
	        timer = new Timer(1000, new ActionListener() { // Se ejecuta cada segundo
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                segundos--;
	                String time = String.format("%02d:%02d", segundos / 60, segundos % 60);
	                labelTiempo.setText(time);
	            }
	        });

	        // Acci�n al hacer clic en "Iniciar"
	        btnIniciar.addActionListener(e -> {
	            timer.start(); // Iniciar el cron�metro
	            btnIniciar.setEnabled(false);
	            btnDetener.setEnabled(true);
	        });

	        // Acci�n al hacer clic en "Detener"
	        btnDetener.addActionListener(e -> {
	            timer.stop(); // Detener el cron�metro
	            btnIniciar.setEnabled(true);
	            btnDetener.setEnabled(false);
	        });

	        // A�adir componentes a la ventana
	        ventana.add(labelTiempo);
	        ventana.add(btnIniciar);
	        ventana.add(btnDetener);

	        // Hacer visible la ventana
	        ventana.setVisible(true);
	    }
	

	}


