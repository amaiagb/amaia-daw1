package arrays5;

public class Main {
	// EJERCICIO 5
	//Escribe un programa que tome un array de 6 elementos y lo invierta. 
	//Es decir, el primer elemento pasa a ser el último y viceversa
	public static void main(String[] args) {
		//int numeros[] = {10,20,30,40,50,60};
		int numeros[] = new int[6];
		int reverso[]  = new int[6];
		
		System.out.println("Array numeros: ");
		for(int i=0; i<numeros.length; i++) {
			numeros[i] = (int) ((Math.random()*10)+1);
			System.out.println(numeros[i]);
		}

		//DAR LA VUELTA AL ARRAY
		for(int i=0; i<numeros.length; i++) {
			reverso[(reverso.length-1)-i] = numeros[i];
		}
		
		System.out.println("Array reverso: ");
		for(int i=0; i<reverso.length; i++) {
			System.out.println(reverso[i]);
		}
	}

}
