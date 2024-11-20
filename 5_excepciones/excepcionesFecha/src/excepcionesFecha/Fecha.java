package excepcionesFecha;

import java.util.HashMap;

public class Fecha {
	private int ano = 0;
	private int mes = 1;
	private int dia = 1;
	public static final int MESES_AÑO = 12;
	
	public static boolean esBisiesto(int año) {
		
		return true;
	}
	public Fecha() {
		
	}
	public Fecha(int año, int mes, int dia) {
		
	}
	public Fecha(Fecha f) {
		
	}
	public boolean esBisiesto() {
		return true;
	}
	public void setAño(int año) {
		
	}
	public int getAno() {
		return ano;
	}
	public void setMes(int mes) {
		
	}
	public int getMes() {
		return mes;
	}
	public void setDia(int dia) {
		
	}
	public int getDia() {
		return dia;
	}
	public void set(int ano, int mes, int dia) {
		
	}
	public void set(Fecha f) {
		
	}
	/*
	public String toString() {
		
	}
	public boolean equals(Object o) {
		
	}
	*/
	
	public void validarFecha(int dia, int mes, int ano) throws FechaException{
		
		HashMap<Integer, Integer> diasMes = new HashMap<Integer, Integer>();
		
		diasMes.put(1, 31);
		if(esBisiesto(ano)) {
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
		
	
		if(mes <1 || mes >12) {
			throw new FechaException("Mes incorrecto (1-12)");
		}
		
		
		
		if(dia> diasMes.get(mes) || dia < 1) {
			throw new FechaException("Día incorrecto");
		}
	}
}
