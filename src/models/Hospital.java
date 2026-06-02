package models;

import java.util.PriorityQueue;

public class Hospital {
    private PriorityQueue<Paciente> salaEspera;

    public Hospital() {
        this.salaEspera = new PriorityQueue<>();
    }

    public void registrarPaciente(Paciente paciente) {
        salaEspera.offer(paciente);
    }

    public String obtenerOrdenAtencion() {
        if (salaEspera.isEmpty()) {
            return "La sala de espera está vacía.";
        }

        StringBuilder reporte = new StringBuilder("--- ORDEN FINAL DE ATENCIÓN ---\n\n");

        while (!salaEspera.isEmpty()) {
            Paciente p = salaEspera.poll();
            reporte.append("Prioridad ").append(p.getPrioridad())
                    .append(" [").append(p.getGravedad()).append("] -> ")
                    .append(p.getNombre()).append("\n");
        }

        return reporte.toString();
    }
}