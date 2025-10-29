package com.utn.tareas;

import com.utn.tareas.model.Prioridad;
import com.utn.tareas.model.Tarea;
import com.utn.tareas.service.MensajeService;
import com.utn.tareas.service.TareaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class TareasApplication implements CommandLineRunner {
	private final TareaService tareaService;
	private final MensajeService mensajeService;

	public TareasApplication(TareaService tareaService, MensajeService mensajeService) {
		this.mensajeService=mensajeService;
		this.tareaService=tareaService;
	}

	public static void main(String[] args) {
		SpringApplication.run(TareasApplication.class, args);
	}

	@Override
	public void run(String... args) {
		mensajeService.mostrarBienvenida();

		System.out.println("Configuracion: ");
		tareaService.imprimirConfiguracion();

		System.out.println("Listar tareas iniciales: ");
		tareaService.listarTareas();

		System.out.println("Agregar nueva tarea: ");
		tareaService.agregarTarea("Lavar platos", Prioridad.BAJA);

		System.out.println("Agregar nueva tarea: ");
		tareaService.agregarTarea("Limpiar el piso", Prioridad.BAJA);

		System.out.println("Tareas pendientes: ");
		List<Tarea>tareasPendientes=tareaService.listarTareasPendientes();
		tareasPendientes.forEach(System.out::println);

		System.out.println("Marcar una tarea como completada: ");
		tareaService.marcarComoCompletada(1L);

		System.out.println("Estadisticas: ");
		System.out.println(tareaService.obtenerEstadisticas());

		System.out.println("Tareas completadas: ");
		List<Tarea>tareasCompletadas=tareaService.listarTareasCompletadas();
		tareasCompletadas.forEach(System.out::println);

		mensajeService.mostrarDespedida();
	}
}
