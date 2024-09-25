package programa2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		/* PROGRAMA 2
		 * - pedir por teclado el tipo de cliente (normal, socio, vip)
		 * - pedir por teclado el importe de la compra
		 * - mostrar el total a pagar por el cliente
		 * - sabiendo que normal no se aplica descuento, socio es un 5%, vip es un 20%
		 */
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Introduce el tipo de cliente:");
		String tipoCliente = entrada.next();
		System.out.println("Importe de la compra:");
		float importe = entrada.nextFloat();
		
		float descuentoVip = 0.20f;
		float descuentoSocio = 0.05f;
		
		if(tipoCliente.equals("vip")) {
			System.out.println("Importe final: "+importe*(1-descuentoVip));
		}else if(tipoCliente.equals("socio")) {
			System.out.println("Importe final: "+importe*(1-descuentoSocio));
		} else if(tipoCliente.equals("normal")) {
			System.out.println("Importe final: "+importe);
		} else {
			System.out.println("Error en el tipo de cliente");
		}
		
	}

}
