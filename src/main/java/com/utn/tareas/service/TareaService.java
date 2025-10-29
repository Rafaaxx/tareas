package com.utn.tareas.service;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import com.utn.tareas.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TareaService {
    private final TareaRepository tareaRepository;
    @Value("${app.max-tareas}")
    int maxTareas;
    @Value("${app.mostrar-estadisticas}")
    boolean mostrarEstadisticas;
    public TareaService(TareaRepository tareaRepository) {
        this.tareaRepository=tareaRepository;
    }
    public void agregarTarea(String descripcion, Prioridad prioridad){
        if (tareaRepository.obtenerTodas().size()>=maxTareas){
            System.out.println("Error al agregar tarea: no se puede superar el maximo de tareas.");
        }else {
            tareaRepository.guardar(new Tarea(null,descripcion,false,prioridad));
            System.out.println("La tarea "+ descripcion+" fue agregada");
        }
    }
    public void listarTareas(){
     List<Tarea>listaTareas=tareaRepository.obtenerTodas();
     listaTareas.forEach(System.out::println);
    }
    public List<Tarea> listarTareasPendientes(){
     List<Tarea>tareasPendientes=tareaRepository.obtenerTodas().stream()
             .filter(tarea -> !tarea.isCompletada())
             .toList();
     return tareasPendientes;
    }
    public List<Tarea> listarTareasCompletadas(){
        List<Tarea>tareasCompletadas=tareaRepository.obtenerTodas().stream()
                .filter(tarea -> tarea.isCompletada())
                .toList();
        return tareasCompletadas;
    }
    public void marcarComoCompletada(Long id){
    Optional<Tarea> tareaPorActualizar=tareaRepository.buscarPorId(id);
    if(tareaPorActualizar.isPresent()){
        tareaPorActualizar.get().setCompletada(true);
        System.out.println("La tarea "+ tareaPorActualizar.get().getDescripcion() +", de id "+ tareaPorActualizar.get().getId()+" fue marcada como completa");
    }else {
        System.out.println("No se encontro la tarea.");
    }
    }
    public String obtenerEstadisticas(){
        if (mostrarEstadisticas){
            int totalTareas=tareaRepository.obtenerTodas().size();
            int completadas=listarTareasCompletadas().size();
            int pendientes=listarTareasPendientes().size();
            return String.format("Total: %d , Completadas: %d , Pendientes: %d",totalTareas,completadas,pendientes);

        }else {
            return "Estadisticas desactivadas debido a la configuracion (modo produccion).";
        }
    }
    public void imprimirConfiguracion(){
        System.out.println("Maximo de tareas actual: "+maxTareas);
        System.out.println("Mostrar estadisticas: "+mostrarEstadisticas);
    }

}
