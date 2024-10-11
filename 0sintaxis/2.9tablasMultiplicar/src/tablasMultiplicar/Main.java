package tablasMultiplicar;

public class Main {

	public static void main(String[] args) {

		//Tablas de multiplicar
		
		for(int i=1; i<=10; i++) { //recorre el 1er numero
			for(int j=1; j<=10; j++) { //recorre el 2o numero
				System.out.println(i+"x"+j+"="+i*j);
			}
		}
	}

}
