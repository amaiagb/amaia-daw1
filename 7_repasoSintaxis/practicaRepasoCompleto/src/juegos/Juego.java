package juegos;

public abstract class Juego {
	
	//atributos
	private int vidas;
	private int vidasIniciales;
	private static int record = 0;
	
	//constructor
	public Juego(int vidas) {
		this.vidasIniciales = vidas;
		this.vidas = vidas;
	}
	
	//getters & setters
	public int getVidas() {
		return vidas;
	}

	public void setVidas(int vidas) {
		this.vidas = vidas;
	}

	public int getVidasIniciales() {
		return vidasIniciales;
	}

	public void setVidasIniciales(int vidasIniciales) {
		this.vidasIniciales = vidasIniciales;
	}

	public static int getRecord() {
		return record;
	}

	public static void setRecord(int record) {
		Juego.record = record;
	}
	

	//metodos
	public void muestraVidasRestantes() {
		System.out.println(vidas);
	}
	
	public boolean quitaVida() {
		vidas--;
		if(vidas>0) {
			return true;
		}else {
			System.out.println("Juego terminado");
			return false;
		}
	}
	
	public void reiniciaPartida() {
		this.vidas = vidasIniciales;
	}

	public void actualizaRecord() {
		if(vidas == record) {
			System.out.println("Se ha alcanzado el record");
		} else if(vidas > record) {
			record = vidas;
			System.out.println("Se ha batido el record! Nuevo valor: "+record);
		}
	}
	
}
