import java.util.HashSet;

public class Main {

	public static void main(String[] args) {
		HashSet<String> dnis = new HashSet<>();
		
		dnis.add("12345678A");
		dnis.add("11122233B");
		dnis.add("78945612C");
		dnis.add("12345678A");
		
		System.out.println("Los DNI son: ");
		for(String dni : dnis) {
			System.out.println(dni);
		}
	}

}
