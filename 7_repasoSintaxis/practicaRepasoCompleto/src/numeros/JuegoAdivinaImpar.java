package numeros;

public class JuegoAdivinaImpar extends JuegoAdivinaNumero{

	public JuegoAdivinaImpar(int vidas) {
		super(vidas);
	}
	
	@Override
	public boolean validaNumero(int numeroIntroducido) {
		if(numeroIntroducido%2 != 0) {
			return true;
		}  else {
			System.out.println("Error: numero par");
			return false;
		}
	}
}
