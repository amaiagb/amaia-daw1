package com.centrosanluis.tiendaBD.dto;

public class ProductoDTO {

	private int id;
	private String nombre, categoria, descripcion, color, estado;
	private float precio;
	private boolean descuento;
	private int valorDescuento;
	
	public ProductoDTO(String nombre, String categoria, String descripcion, String color, String estado,
			float precio, boolean descuento, int valorDescuento) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.color = color;
		this.estado = estado;
		this.precio = precio;
		this.descuento = descuento;
		this.valorDescuento = valorDescuento;
	}

	public ProductoDTO() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
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

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public boolean isDescuento() {
		return descuento;
	}

	public void setDescuento(boolean descuento) {
		this.descuento = descuento;
	}

	public int getValorDescuento() {
		return valorDescuento;
	}

	public void setValorDescuento(int valorDescuento) {
		this.valorDescuento = valorDescuento;
	}

	@Override
	public String toString() {
		return "ProductoDTO [id=" + id + ", nombre=" + nombre + ", categoria=" + categoria + ", descripcion="
				+ descripcion + ", color=" + color + ", estado=" + estado + ", precio=" + precio + ", descuento="
				+ descuento + ", valorDescuento=" + valorDescuento + "]";
	}
	
	
}
