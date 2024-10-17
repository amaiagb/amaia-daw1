package variables;

public class Main {

	public static void main(String[] args) {
		//variables
		/*
		Tipos de datos primitivos
			int
			short
			long
			double
			float
			char
			byte
			boolean
			
		Tipos de datos referencia
			Integer
			Short
			Long
			Double
			Float
			Character
			String
			Byte
			Boolean
		*/
		char caracter = 'a';
		
		int numero = 3;
		Integer numero2 = 3;
		String cadena = "cadena de texto";
		
		//System.out.println(cadena.charAt(1));
		
		for(int i=0; i<cadena.length(); i++) {
			System.out.println(cadena.charAt(i));
			
		}
	
		
	}

}
