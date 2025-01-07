package colegio;

import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JFrame;

import colegio.model.Estudiante;
import colegio.ui.estudiante.AltaEstudiante;
import colegio.ui.estudiante.ListadoEstudiante;

public class App {

	public static void main(String[] args) {
		
		ArrayList<Estudiante> estudiantes = new ArrayList<Estudiante>();
		
		/**TODO
		 * añadir estudiantes al arraylist (new estudiante...)
		 *  
		 */
		Estudiante estudiante1 = new Estudiante();
		estudiante1.setNombre("Juan");
		estudiante1.setApellidos("Pérez");
		estudiante1.setDni("44102030J");
		estudiante1.setEmail("jperez@gmail.com");
		estudiante1.setNecesidadesEspeciales("");
		estudiante1.setTerminosAceptados(true);
		estudiante1.setCurso("DAW");
		estudiante1.setGenero(0);
		estudiante1.setFechaNacimiento(LocalDate.of(1997, 02, 21));
		
		Estudiante estudiante2 = new Estudiante();
		estudiante2.setNombre("Miren");
		estudiante2.setApellidos("García");
		estudiante2.setDni("14978654A");
		estudiante2.setEmail("mgarcia@gmail.com");
		estudiante2.setNecesidadesEspeciales("");
		estudiante2.setTerminosAceptados(true);
		estudiante2.setCurso("DAW");
		estudiante2.setGenero(1);
		estudiante2.setFechaNacimiento(LocalDate.of(2003, 05, 26));
		
		Estudiante estudiante3 = new Estudiante();
		estudiante3.setNombre("Alex");
		estudiante3.setApellidos("Etxebarria");
		estudiante3.setDni("78456123X");
		estudiante3.setEmail("aetxebarria@gmail.com");
		estudiante3.setNecesidadesEspeciales("");
		estudiante3.setTerminosAceptados(true);
		estudiante3.setCurso("DAW");
		estudiante3.setGenero(2);
		estudiante3.setFechaNacimiento(LocalDate.of(2001, 10, 9));
		
		Estudiante estudiante4 = new Estudiante("44523671S", "Maialen", "Olabarria", "molabarria@gmail.com", 1, LocalDate.of(1999,10,11), "ASIR", "", true);
		
		estudiantes.add(estudiante1);
		estudiantes.add(estudiante2);
		estudiantes.add(estudiante3);
		estudiantes.add(estudiante4);
		
		AltaEstudiante ventana = new AltaEstudiante(estudiantes);

		ListadoEstudiante ventana2 = new ListadoEstudiante(estudiantes);
		
		ventana.setVisible(true);
		ventana2.setVisible(true);
		
	}

}
