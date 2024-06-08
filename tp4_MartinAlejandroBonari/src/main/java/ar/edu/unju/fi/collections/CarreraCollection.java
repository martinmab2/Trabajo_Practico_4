package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import ar.edu.unju.fi.model.Carrera;

@Component

public class CarreraCollection {
	private static List<Carrera> carreras = new ArrayList<Carrera>();
	
	public static List<Carrera> getCarreras(){
		if(carreras.isEmpty()) {
			carreras.add(new Carrera("IIF00033", "Ingenieria Informatica", 5, "ACTIVO"));
			carreras.add(new Carrera("IQM00002", "Ingenieria Quimica", 5, "ACTIVO"));
			carreras.add(new Carrera("APU00001", "Analista Programador Universitario", 3, "ACTIVO"));
			carreras.add(new Carrera("IID00011", "Ingenieria Industrial", 5, "ACTIVO"));
			carreras.add(new Carrera("IMI00015", "Ingenieria en Minas", 5, "ACTIVO"));
			carreras.add(new Carrera("LICG0007", "Licenciatura en Ciencias Geologicas", 5, "ACTIVO"));
			carreras.add(new Carrera("LITA0010", "Licenciatura en Tecnologia de los Alimentos", 4, "ACTIVO"));
			carreras.add(new Carrera("LISI0009", "Licenciatura en Sistemas", 5, "ACTIVO"));
			carreras.add(new Carrera("TUDIVJ12", "Tecnicatura Universitaria en Diseño de Videojuegos", 3, "ACTIVO"));
			carreras.add(new Carrera("TUPE0019", "Tecnicatura Universitario en Perforaciones", 3, "ACTIVO"));
		}
	return carreras;
	}
}
