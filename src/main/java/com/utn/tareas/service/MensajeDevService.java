package com.utn.tareas.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class MensajeDevService implements MensajeService{
    @Override
    public void mostrarBienvenida() {
        System.out.println("Bienvenido al sistema de tareas [DEV]! Esta aplicacion tiene el fin de ayudarte con el desarrollo y anotacion de tus tareas.");
    }

    @Override
    public void mostrarDespedida() {
        System.out.println("Fin del programa (modo desarrollo)!. Esperamos que te haya resultado util!");
    }
}
