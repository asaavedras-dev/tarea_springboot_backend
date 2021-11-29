package com.asaavedras.tarea.services;

import com.asaavedras.tarea.repository.ITareaRepository;
import com.asaavedras.tarea.model.Tarea;
import com.asaavedras.tarea.repository.*;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ITareaServiceImpl implements ITareaService {

	private ITareaRepository tareaRepository;

    public ITareaServiceImpl(ITareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }
	
	
	public List<Tarea> obtenerTareas(){
		return tareaRepository.findAll();
	}
	
	public void agregarTarea(Tarea tarea) {
		tareaRepository.save(tarea);
	}
	
	public void eliminarTarea(Integer id) {
		tareaRepository.deleteById(id);
	}
	
	public void actualizarTarea(Tarea tarea) {
		tareaRepository.save(tarea);
	}
	
	

}
