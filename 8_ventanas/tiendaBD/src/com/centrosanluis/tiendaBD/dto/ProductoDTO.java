package com.centrosanluis.tiendaBD.dto;

public class ProductoDTO {
	private String id;
	private String nombre;
	private String descripcion;
	private String color;
	
	public ProductoDTO(String id, String nombre, String descripcion, String color) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.color = color;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	
	
}
