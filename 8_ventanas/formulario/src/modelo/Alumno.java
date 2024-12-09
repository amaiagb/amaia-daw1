package modelo;

import java.util.ArrayList;

public class Alumno {

	public int id;
	public String nombre;
	public String apellido1;
	public String apellido2;
	public String ciclo;
	public String curso;
	public String modelo;
	public String observaciones;
	private ArrayList<String> hobbies;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido1() {
		return apellido1;
	}
	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	public String getApellido2() {
		return apellido2;
	}
	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	public String getCiclo() {
		return ciclo;
	}
	public void setCiclo(String ciclo) {
		this.ciclo = ciclo;
	}
	public String getCurso() {
		return curso;
	}
	public void setCurso(String curso) {
		this.curso = curso;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}	
	
	public ArrayList<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	
	@Override
	public String toString() {
		String infoPersonal = nombre+" "+apellido1+" "+apellido2+": "+curso+"º "+ciclo+" ("+modelo+") \n";
		String infoHobbies = "Hobbies: "+hobbies.toString()+"\n";
		String infoObservaciones = "Observaciones: "+observaciones;
		
		return infoPersonal+infoHobbies+infoObservaciones;
	}
	
	
}
