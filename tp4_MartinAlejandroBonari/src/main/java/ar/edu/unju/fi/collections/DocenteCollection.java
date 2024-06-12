package ar.edu.unju.fi.collections;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Docente;
@Component
public class DocenteCollection {
	private static List<Docente> docentes = new ArrayList<Docente>();

    static {
        docentes.add(new Docente("DOC01", "Carolina", "Apaza", "caro_apaza@gmail.com", "+54 9 3458745118"));
        docentes.add(new Docente("DOC03", "Juan Carlos", "Rodriguez", "jcrodriguez@gmail.com", "+54 9 3482349218"));
        docentes.add(new Docente("DOC02", "Ariel", "Vega", "vega_ariel@gmail.com", "+54 9 3882196727"));
        docentes.add(new Docente("DOC07", "Gustavo", "Sosa", "gustavo_sosa@gmail.com", "+54 9 3892463433"));
        docentes.add(new Docente("DOC05", "Hector Pedro", "Liberatori", "hp_liberatori@gmail.com", "+54 9 3812313479"));
        docentes.add(new Docente("DOC06", "Gustavo", "Zapana", "gus_zapana@gmail.com", "+54 9 3874412425"));
        docentes.add(new Docente("DOC04", "Carolina Vanesa", "Brouchy", "caro_vb@gmail.com", "+54 9 3885296412"));
    }

    public static List<Docente> getDocentes() {
        return new ArrayList<>(docentes);
    }
	
	public static Docente buscarDocentePorLegajo(String legajo) {
		for (Docente docente : docentes) {
			if(docente.getLegajo().equals(legajo)) {
				return docente;
			}
		}
		return null;
	}
	
	public static void agregarDocente(Docente docente) {
		docentes.add(docente);
	}
    
    public static void modificarDocente(Docente docenteModificado) {
    	Docente docenteExistente = buscarDocentePorLegajo(docenteModificado.getLegajo());
		if (docenteExistente != null) {
			docenteExistente.setLegajo(docenteModificado.getLegajo());
			docenteExistente.setNombre(docenteModificado.getNombre());
			docenteExistente.setApellido(docenteModificado.getApellido());
			docenteExistente.setEmail(docenteModificado.getEmail());
			docenteExistente.setTelefono(docenteModificado.getTelefono());
		}
	}
    
    public static void eliminarDocente(String legajo) {
		Docente docente = buscarDocentePorLegajo(legajo);
		if (docente != null) {
			docentes.remove(docente);
		}
	}
}