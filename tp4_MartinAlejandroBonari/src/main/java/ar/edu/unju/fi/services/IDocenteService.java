package ar.edu.unju.fi.services;

import java.util.List;

import ar.edu.unju.fi.dto.DocenteDTO;

public interface IDocenteService {
	public void guardarDocente(DocenteDTO docentedto);
    public List<DocenteDTO> mostrarDocentes();
    public List<DocenteDTO> mostrarDocentesNoAsignados();
    public void EliminarDocente(Long id);
    public void modificarDocente(DocenteDTO docentedto);
    public DocenteDTO buscarDocente(Long id);

}