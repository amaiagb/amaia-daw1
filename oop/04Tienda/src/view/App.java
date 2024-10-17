package view;

import model.Cliente;
import model.Vendedor;

public class App {

	public static void main(String[] args) {
		
		Cliente c1 = new Cliente("Juan",50);
		Vendedor v1 = new Vendedor("Pedro");
		
		System.out.println(c1.nombre);
		System.out.println(c1.saldo);
		
		c1.comprar("pan", v1, 1.5f, 3);
		
	}

}
