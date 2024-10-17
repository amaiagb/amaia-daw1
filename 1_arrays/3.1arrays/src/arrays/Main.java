package arrays;

public class Main {

	public static void main(String[] args) {
		int[] enteros = {};
		String[] semana = new String[7];
		String[] semana2 = {"lunes", "martes", "miercoles", "jueves", "viernes", "sabado", "domingo"};
		
		//los arrays son mutables pueden cambiar el valor
		//los arrays no se pueden redimensionar, tienen que tener siempre la dimension declarada
		
		semana[0]="Lunes";
		semana[1]="Martes";
		semana[1]="Otro Valor";
		
		System.out.println(semana[1]);
		System.out.println(semana.length);
	}

}
