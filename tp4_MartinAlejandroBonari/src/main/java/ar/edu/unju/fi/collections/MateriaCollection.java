package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;
import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.model.Modalidad;
import ar.edu.unju.fi.model.Docente;

@Component
public class MateriaCollection {
	private List<Materia> materias = new ArrayList<>();
	private DocenteCollection docenteCollection;
	private CarreraCollection carreraCollection; 

	public MateriaCollection(DocenteCollection docenteCollection, CarreraCollection carreraCollection) { 
		this.docenteCollection = docenteCollection;
		this.carreraCollection = carreraCollection;
		List<Docente> docentes = DocenteCollection.getDocentes();
		List<Carrera> carreras = CarreraCollection.getCarreras(); 

		materias.add(new Materia(101, "Botánica", "1°Año", 60, Modalidad.BIMODAL, docentes.get(0), carreras.get(0)));
		materias.add(
				new Materia(102, "Base de Datos I", "1°Año", 35, Modalidad.BIMODAL, docentes.get(2), carreras.get(1)));
		materias.add(new Materia(103, "Programacion Estructurada", "1°Año", 55, Modalidad.VIRTUAL, docentes.get(1),
				carreras.get(2)));
		materias.add(
				new Materia(106, "Algebra II", "1°Año", 40, Modalidad.PRESENCIAL, docentes.get(3), carreras.get(3)));
		materias.add(new Materia(105, "Redes I", "1°Año", 45, Modalidad.PRESENCIAL, docentes.get(3), carreras.get(4)));
		materias.add(new Materia(207, "Programacion Visual", "2°Año", 50, Modalidad.VIRTUAL, docentes.get(2),
				carreras.get(5)));
		materias.add(new Materia(301, "Programacion y Servicios Web", "3°Año", 65, Modalidad.BIMODAL, docentes.get(1),
				carreras.get(6)));
		materias.add(new Materia(502, "Legislacion y Ejercicio Profesional", "5°Año", 35, Modalidad.VIRTUAL,
				docentes.get(6), carreras.get(7)));
		materias.add(new Materia(502, "Legislacion y Ejercicio Profesional", "5°Año", 35, Modalidad.VIRTUAL,
				docentes.get(2), carreras.get(8)));
		materias.add(new Materia(502, "Legislacion y Ejercicio Profesional", "5°Año", 35, Modalidad.VIRTUAL,
				docentes.get(5), carreras.get(9)));
		materias.add(new Materia(502, "Legislacion y Ejercicio Profesional", "5°Año", 35, Modalidad.VIRTUAL,
				docentes.get(1), carreras.get(6)));
	}

	public List<Materia> getMaterias() {
		return materias;
	}

	public void setMaterias(List<Materia> materias) {
		this.materias = materias;
	}

	public List<Materia> listarMaterias() {
		return materias;
	}

	public Materia buscarMateriaPorCodigo(int codigo) {
		for (Materia materia : materias) {
			if (materia.getCodigo() == (codigo)) {
				return materia;
			}
		}
		return null;
	}

	public void modificarMateria(Materia materiaModificada) {
		Materia materiaExistente = buscarMateriaPorCodigo(materiaModificada.getCodigo());
		if (materiaExistente != null) {
			materiaExistente.setCodigo(materiaModificada.getCodigo());
			materiaExistente.setNombre(materiaModificada.getNombre());
			materiaExistente.setDocente(materiaModificada.getDocente());
			materiaExistente.setCurso(materiaModificada.getCurso());
			materiaExistente.setCantidadHoras(materiaModificada.getCantidadHoras());
			materiaExistente.setModalidad(materiaModificada.getModalidad());
		}
	}

	public void eliminarMateria(int codigo) {
		Materia materia = buscarMateriaPorCodigo(codigo);
		if (materia != null) {
			materias.remove(materia);
		}
	}

	public void guardarMateria(Materia materia) {
		materias.add(materia);
	}

	public DocenteCollection getDocenteCollection() {
		return docenteCollection;
	}

	public void setDocenteCollection(DocenteCollection docenteCollection) {
		this.docenteCollection = docenteCollection;
	}

	public CarreraCollection getCarreraCollection() {
		return carreraCollection;
	}

	public void setCarreraCollection(CarreraCollection carreraCollection) { 
		this.carreraCollection = carreraCollection;
	}

}