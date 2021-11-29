package com.asaavedras.tarea;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.asaavedras.tarea.repository.ITareaRepository;
import com.asaavedras.tarea.services.ITareaService;
import com.asaavedras.tarea.services.ITareaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.asaavedras.tarea.model.Tarea;

@ExtendWith(MockitoExtension.class)
public class TareaServiceTest {
	
	@Mock
    private ITareaRepository iTareaRepository;

	ITareaService tareaService;

    @BeforeEach
    void initUseCase() {
    	tareaService = new ITareaServiceImpl(iTareaRepository);
    }
    
    @Test
    public void guardarTarea_Correcto() {
        Tarea tarea = new Tarea();
        tarea.setId(19);;
        tarea.setDescripcion("Organizar");;
        tarea.setFechaCreacion(new Date());
        tarea.setVigente(true);

        when(iTareaRepository.save(any(Tarea.class))).thenReturn(tarea);

        Tarea guardarTarea = iTareaRepository.save(tarea);
        assertThat(guardarTarea.getId()).isNotNull();
    }

    @Test
    public void buscartTodas_Correcto() {
    	 Tarea tarea = new Tarea();
         tarea.setId(19);;
         tarea.setDescripcion("Organizar");;
         tarea.setFechaCreacion(new Date());
         tarea.setVigente(true);
	     List<Tarea> tareas = new ArrayList<>();
	     tareas.add(tarea);

        // providing knowledge
        when(iTareaRepository.findAll()).thenReturn(tareas);

        List<Tarea> tareasObtenidas = tareaService.obtenerTareas();
        assertThat(tareasObtenidas.size()).isGreaterThan(0);
    }
    
}
