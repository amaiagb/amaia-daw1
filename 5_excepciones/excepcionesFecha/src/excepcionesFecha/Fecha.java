package excepcionesFecha;

import java.util.HashMap;

public class Fecha {
	private int anio = 0;
	private int mes = 1;
	private int dia = 1;
	public static final int MESES_ANIO = 12;

	//Constructores
	public Fecha() {
		
	}
	public Fecha(int anio, int mes, int dia) {
		setAnio(anio);
		setMes(mes);
		setDia(dia);
	}
	public Fecha(Fecha f) {
		setAnio(f.getAnio());
		setMes(f.getMes());
		setDia(f.getDia());
	}

	//Método de clase esBisiesto()
	public static boolean esBisiesto(int anio) {
		if(anio%4==0 && anio%100!=0 || anio%400==0) {
			return true;
		}
		return false;
	}
	
	//Método de instancia esBisiesto()
	public boolean esBisiesto() {
		if(anio%4==0 && anio%100!=0 || anio%400==0) {
			return true;
		}
		return false;
	}
	//Getters & Setters
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public int getAnio() {
		return this.anio;
	}
	public void setMes(int mes) throws FechaException{
		if(mes>0 && mes<=MESES_ANIO) {
			this.mes = mes;
		} else {
			throw new FechaException("Mes incorrecto: "+mes);
		}
	}
	public int getMes() {
		return this.mes;
	}
	
	public void setDia(int dia) throws FechaException{
		HashMap<Integer, Integer> diasMes = new HashMap<Integer, Integer>();
		diasMes.put(1, 31);
		if(esBisiesto()) {
			diasMes.put(2, 29);
		} else {
			diasMes.put(2, 28);
		}
		diasMes.put(3, 31);
		diasMes.put(4, 30);
		diasMes.put(5, 31);
		diasMes.put(6, 30);
		diasMes.put(7, 31);
		diasMes.put(8, 31);
		diasMes.put(9, 30);
		diasMes.put(10, 31);
		diasMes.put(11, 30);
		diasMes.put(12, 31);
		
		if(dia >0 && dia<=diasMes.get(this.mes)) {
			this.dia = dia;
		} else {
			throw new FechaException("Día incorrecto: "+dia+"/"+mes);
		}
	}
	
	public int getDia() {
		return this.dia;
	}
	public void set(int anio, int mes, int dia) {
		setAnio(anio);
		setMes(mes);
		setDia(dia);
	}
	public void set(Fecha f) {
		setAnio(f.getAnio());
		setMes(f.getMes());
		setDia(f.getDia());
	}
	
	@Override
	public String toString() {
		return this.dia+"/"+this.mes+"/"+this.anio;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Fecha) {
			Fecha f = (Fecha) o;
			if(this.getAnio()==f.getAnio() && this.getMes()==f.getMes() && this.getDia()==f.getDia()) {
				return true;
			}
		}
		return false;
	}
	
	/*
	//Opcion 2: con switch y metodo de comprobarDia()
	public void setDia(int dia) {
		switch (this.mes) {
			case 1,3,5,7,8,10,12 -> comprobarDia(dia,31);
			case 4,6,9,11 -> comprobarDia(dia,30);
			case 2 -> {
				if(this.esBisiesto()) {
					comprobarDia(dia,29);
				}else {
					comprobarDia(dia,28);
				}
			}
		}
	}
	public void comprobarDia(int dia, int diasMax) {
		if(dia >0 && dia<=diasMax) {
			this.dia = dia;
		} else {
			throw new FechaException("Día incorrecto: "+dia+"/"+mes);
		}
	}
	*/

}
