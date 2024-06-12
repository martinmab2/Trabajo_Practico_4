package ar.edu.unju.fi.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import ar.edu.unju.fi.model.Alumno;

public class AlumnoCollection {
		
	private static List<Alumno> alumnos = new ArrayList<Alumno>();
	
    static {
    	alumnos = new ArrayList<>();
    	alumnos.add(new Alumno(44477373, "Martin Alejandro", "Bonari Figueredo", "asaasado253@gmail.com", "+54 9 3884478119", LocalDate.of(2002, 11,19), "Calle Avellaneda 702", "APU004495"));
    	alumnos.add(new Alumno(43876521, "Pablo Andrés", "Martinez Rojas", "pablo.martinez@example.com","+54 9 3412345678", LocalDate.of(2000, 7, 22),"Calle Belgrano 456", "LU002345"));
    	alumnos.add(new Alumno(45098734, "Luciana Fernanda", "Gonzalez Diaz", "luciana.gonzalez@example.com", "+54 9 1145689234", LocalDate.of(2001, 4, 15), "Calle San Martín 123", "LU001234"));
    	alumnos.add(new Alumno(43876521, "Pablo Andrés", "Martinez Rojas", "pablo.martinez@example.com", "+54 9 3412345678", LocalDate.of(2000, 7, 22), "Calle Belgrano 456", "LU002345"));
    	alumnos.add(new Alumno(42789654, "Carolina Beatriz", "Lopez Fernandez", "carolina.lopez@example.com", "+54 9 2613456789", LocalDate.of(1999, 3, 10), "Calle Mitre 789", "LU003456"));
    	alumnos.add(new Alumno(40567891, "Ana Isabel", "Perez Gutierrez", "ana.perez@example.com", "+54 9 3487654321", LocalDate.of(2003, 5, 5), "Calle Rivadavia 202", "LU005678"));
    	alumnos.add(new Alumno(41678932, "Federico Manuel", "Ramirez Sanchez", "federico.ramirez@example.com", "+54 9 3812345678", LocalDate.of(2002, 11, 19), "Calle Sarmiento 101", "LU004567"));
    }

    public static List<Alumno> getAlumnos() {
        return alumnos;
    }
    
    public static Alumno buscarAlumnoPorLU(String LU) {
		for (Alumno alumno : alumnos) {
			if(alumno.getLU().equals(LU)) {
				return alumno;
			}
		}
		return null;
	}
    
    public static void agregarAlumno(Alumno alumno) {
		alumnos.add(alumno);
	}
    
    public static void modificarAlumno(Alumno alumnoModificado) {
    	Alumno alumnoExistente = buscarAlumnoPorLU(alumnoModificado.getLU());
		if (alumnoExistente != null) {
			alumnoExistente.setDni(alumnoModificado.getDni());
			alumnoExistente.setNombre(alumnoModificado.getNombre());
			alumnoExistente.setApellido(alumnoModificado.getApellido());
			alumnoExistente.setEmail(alumnoModificado.getEmail());
			alumnoExistente.setTelefono(alumnoModificado.getTelefono());
			alumnoExistente.setFechaNacimiento(alumnoModificado.getFechaNacimiento());
			alumnoExistente.setDomicilio(alumnoModificado.getDomicilio());
			alumnoExistente.setLU(alumnoModificado.getLU());
		}
	}
    
    public static void eliminarAlumno(String LU) {
		Alumno alumno = buscarAlumnoPorLU(LU);
		if (alumno != null) {
			alumnos.remove(alumno);
		}
	}
}