package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.model.Modalidad;

public class MateriaCollection {
	private static List<Materia> materias = new ArrayList<Materia>();
	
	public static List<Materia> listaMaterias(){
		
		List<Docente> listaDocente = DocenteCollection.getDocentes();
			Docente docente1 = listaDocente.get(0);
			Docente docente2 = listaDocente.get(1);
			Docente docente3 = listaDocente.get(2);
			Docente docente4 = listaDocente.get(3);
			Docente docente5 = listaDocente.get(4);
			Docente docente6 = listaDocente.get(5);
			Docente docente7 = listaDocente.get(6);
			
		List<Carrera> listaCarrera = CarreraCollection.getCarreras();
		
			Carrera carrera1 = listaCarrera.get(0);
			Carrera carrera2 = listaCarrera.get(1);
			Carrera carrera3 = listaCarrera.get(2);
			Carrera carrera4 = listaCarrera.get(3);
			Carrera carrera5 = listaCarrera.get(4);
			Carrera carrera6 = listaCarrera.get(5);
			Carrera carrera7 = listaCarrera.get(6);
			Carrera carrera8 = listaCarrera.get(7);
			Carrera carrera9 = listaCarrera.get(8);
			Carrera carrera10 = listaCarrera.get(9);
			
		if(materias.isEmpty()) {
			materias.add(new Materia(101, "Base de Datos I", "1°Año", 35, Modalidad.BIMODAL, docente1, carrera1));
			materias.add(new Materia(102, "Programacion Estructurada", "1°Año", 55, Modalidad.VIRTUAL, docente2, carrera2));
			materias.add(new Materia(106, "Algebra II", "1°Año", 40, Modalidad.PRESENCIAL, docente3, carrera3));
			materias.add(new Materia(105, "Redes I", "1°Año", 45, Modalidad.PRESENCIAL, docente4, carrera4));
			materias.add(new Materia(207, "Programacion Visual", "2°Año", 50, Modalidad.VIRTUAL, docente5, carrera5));
			materias.add(new Materia(301, "Programacion y Servicios Web", "3°Año", 65, Modalidad.BIMODAL, docente6, carrera6));
			materias.add(new Materia(502, "Legislacion y Ejercicio Profesional", "5°Año", 35, Modalidad.VIRTUAL, docente7, carrera7));
			materias.add(new Materia(502, "Legislacion y Ejercicio Profesional", "5°Año", 35, Modalidad.VIRTUAL, docente1, carrera8));
			materias.add(new Materia(502, "Legislacion y Ejercicio Profesional", "5°Año", 35, Modalidad.VIRTUAL, docente2, carrera9));
			materias.add(new Materia(502, "Legislacion y Ejercicio Profesional", "5°Año", 35, Modalidad.VIRTUAL, docente3, carrera10));
		}
		return materias;
	}
}
