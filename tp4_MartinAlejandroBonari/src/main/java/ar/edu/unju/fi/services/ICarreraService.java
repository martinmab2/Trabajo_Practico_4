package ar.edu.unju.fi.services;

import java.util.List;

import ar.edu.unju.fi.dto.CarreraDTO;

public interface ICarreraService {
	public void añadirCarrera(CarreraDTO carreraDTO);
	
	public List<CarreraDTO> getAllCarreras();
	
	public CarreraDTO buscarCarrera(Long id);
	
	public void deleteCarrera(Long id);
	
	public void modificarCarrera(CarreraDTO carreraDTO);
}