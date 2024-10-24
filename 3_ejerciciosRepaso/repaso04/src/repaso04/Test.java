package repaso04;

import java.util.ArrayList;
import java.util.Arrays;

public class Test {

	public static void main(String[] args) {
		int[] array1 = {7,4,1,5};
		ArrayList<Integer> array2 = new ArrayList<>();
		array2.add(7);
		Arrays.sort(array1);
		
	}
	
	private static void ordenarArray(int[] array, String modoOrden) {
		for(int j=0; j<array.length; j++) {
			for(int i=0; i<array.length-1; i++) {
				if(array[i] > array [i+1]) {
					int aux = array[i+1];
					array[i+1] = array[i];
					array[i] = aux;
				}
			}
		}
		mostrarArray(array);
	}
	
	public static void mostrarArray(int[] array) {
		System.out.print("Valores del array [");
		
		for(int i=0; i<array.length;i++) {
			System.out.print(array[i]);
			
			if(i != array.length-1) { //si no es el ultimo elemento del array añade una coma
				System.out.print(",");
			}
		}
		System.out.print("]");
		System.out.println();
	}

}
