package operadores;

public class Main {

	public static void main(String[] args) {
		
		 // Operadores aritmeticos
		 //	+	 
			int n1 = 3;
			int n2 = 4;
			int n3 = 6;
			float n4 = 3.5f; //se pueden sumar tipos distintos de numeros
			
			int suma = n1 + n2;
			float suma2 = n3 + n4;
			
			System.out.println(n1+" + "+n2+" = "+suma);
			System.out.println(n3+" + "+n4+" = "+suma2);
			
		 //	- 	
			int resta = n1 - n2;
			float resta2 = n3 - n4;
			
			System.out.println(n1+" - "+n2+" = "+resta);
			System.out.println(n3+" - "+n4+" = "+resta2);
			
		 //	*	
			int mult = n1 * n2;
			float mult2 = n3 * n4;
			
			System.out.println(n1+" * "+n2+" = "+mult);
			System.out.println(n3+" * "+n4+" = "+mult2);
			
		 //	/	
			int div = n2 / n1;
			float div2 = n3 / n4;
			
			System.out.println(n2+" / "+n1+" = "+div);
			System.out.println(n3+" / "+n4+" = "+div2);
			
		 //	%	
			int modulo = n2 % n1;
			float modulo2 = n3 % n4;
			
			System.out.println(n2+" % "+n1+" = "+modulo);

			
		 //	++	
			int n7 = 8;
			n7++;
			System.out.println("incremento: "+n7);
			
		 //	--	
			n7--;
			System.out.println("decremento: "+n7);
			

		 // Operadores relacionales
			// ==
			System.out.println(1==1);
			System.out.println(1==3);
			
			//!=
			System.out.println(1!=2);
			
			//>
			System.out.println(1>0); //true
			System.out.println(1>1); //false
			System.out.println(1>2); //false
			
			//>
			System.out.println(1<0); //false
			System.out.println(1<1); //false
			System.out.println(1<2); //true
			
			//>=
			System.out.println(1>=0); //true
			System.out.println(1>=1); //true
			System.out.println(1>=2); //false
			
			//<=
			System.out.println(1<=0); //false
			System.out.println(1<=1); //true
			System.out.println(1<=2); //true
			
			
		 // Operadores logicos
			// &&
			 	System.out.println((1<0) && (1<2)); //false
			 	
			// ||
			 	System.out.println(1<0 || 1<2); //true
			 	
			// !	
			 	System.out.println(!(1<=0)); //true
			 
		
		

	}

}
