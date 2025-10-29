package com.utn.tareas.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class MensajeProdService implements MensajeService {
    @Override
    public void mostrarBienvenida() {
        System.out.println("Inicio del programa (modo produccion).");
    }

    @Override
    public void mostrarDespedida() {
        System.out.println("Fin del programa (modo produccion).");
    }
}
