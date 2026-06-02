package models;

import java.util.Deque;
import java.util.LinkedList;

public class GestorTareas {
    private Deque<String> tareas;

    public GestorTareas() {
        this.tareas = new LinkedList<>();
    }

    public void agregarNormal(String tarea) {
        tareas.offerLast("[Normal] " + tarea);
    }

    public void agregarUrgente(String tarea) {
        tareas.offerFirst("[Urgente] " + tarea);
    }

    public String procesarTodas() {
        if (tareas.isEmpty()) {
            return "Sistema inactivo. No hay tareas pendientes.";
        }

        StringBuilder logEjecucion = new StringBuilder("--- INICIANDO PROCESAMIENTO ---\n\n");

        while (!tareas.isEmpty()) {
            String tareaActual = tareas.pollFirst();
            logEjecucion.append("Ejecutando -> ").append(tareaActual).append("\n");
        }

        logEjecucion.append("\nProtocolo finalizado. Bandeja limpia.");
        return logEjecucion.toString();
    }
}