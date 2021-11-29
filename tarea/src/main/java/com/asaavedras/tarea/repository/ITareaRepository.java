package com.asaavedras.tarea.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asaavedras.tarea.model.Tarea;

public interface ITareaRepository extends JpaRepository<Tarea, Integer> {

}
