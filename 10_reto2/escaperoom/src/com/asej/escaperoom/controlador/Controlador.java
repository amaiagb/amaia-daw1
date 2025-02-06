package com.asej.escaperoom.controlador;

import com.asej.escaperoom.view.PanelOpciones;
import com.asej.escaperoom.view.Ventana;

public class Controlador {

	private Ventana ventana;
	private PanelOpciones panelOpciones;
	
	public Controlador(Ventana ventana) {
		this.ventana = ventana;
		this.panelOpciones = ventana.getPanelOpciones();
	}

	public void mostrarOpciones() {
		panelOpciones.setVisible(true);
		
	}

}
