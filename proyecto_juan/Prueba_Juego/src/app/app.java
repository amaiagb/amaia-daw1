package app;
//import view.view_portada; 
import view_nv1.view_cocina;
import view_nv1.view_habitacion;
import view_nv1.view_lore1;
import view_nv1.view_primeraPantalla;
public class app {

	public static void main(String[] args) {
//		view_portada portada = new view_portada();
//		portada.setVisible(false);
		
		view_primeraPantalla primera = new view_primeraPantalla();
		primera.setVisible(false);
		
		view_habitacion hab = new view_habitacion();
		hab.setVisible(false);
		
		view_lore1 lore = new view_lore1();
		lore.setVisible(true);
		
		view_cocina cocina = new view_cocina();
		cocina.setVisible(false);
	}

}
