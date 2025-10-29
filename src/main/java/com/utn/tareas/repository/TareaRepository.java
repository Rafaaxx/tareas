package com.utn.tareas.repository;

import com.utn.tareas.TareasApplication;
import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class TareaRepository {
    private List<Tarea> tareas=new ArrayList<>();
    private AtomicLong contador=new AtomicLong(1);
    public TareaRepository(){
        tareas.add(new Tarea(contador.getAndIncrement(), "Estudiar Spring Boot", false, Prioridad.ALTA));
        tareas.add(new Tarea(contador.getAndIncrement(), "Hacer ejercicio", false, Prioridad.MEDIA));
        tareas.add(new Tarea(contador.getAndIncrement(), "Hacer tarea de base de datos", true, Prioridad.BAJA));
    }
   public void guardar(Tarea tarea){
        tarea.setId(contador.getAndIncrement());
        tareas.add(tarea);
   }
   public List<Tarea>obtenerTodas(){
       return tareas;
   }
   public Optional<Tarea>buscarPorId(Long idABuscar){
        Optional<Tarea>tareaBuscada=tareas.stream()
                .filter(tarea -> tarea.getId().equals(idABuscar))
                .findFirst();
        return tareaBuscada;
   }
   public void eliminarPorId(Long idAEliminar){
            Optional<Tarea> tareaAEliminar=buscarPorId(idAEliminar);
            if (tareaAEliminar.isPresent()) {
                tareas.remove(tareaAEliminar.get());
                System.out.println("Tarea con el id " + idAEliminar + " eliminada exitosamente.");
            }
            else {
                System.out.println("No se encontró la tarea a eliminar.");
            }
   }
}
