package calculadora.enums;

public enum Operacion {
	
	SUMA("+"),
	RESTA("-"),
	MULTIPLICACION("*"),
	DIVISION("/");

	private final String simbolo;
	
	Operacion(String simbolo) {
		this.simbolo = simbolo;
	}

	public String getSimbolo() {
		return this.simbolo;
	}

}
