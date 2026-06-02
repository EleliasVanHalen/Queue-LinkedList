package models;

public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private int prioridad;

    public Paciente(String nombre, int prioridad) {
        this.nombre = nombre;
        this.prioridad = prioridad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public String getGravedad() {
        switch (prioridad) {
            case 1: return "Emergencia";
            case 2: return "Urgente";
            case 3: return "Consulta general";
            default: return "Desconocida";
        }
    }

    @Override
    public int compareTo(Paciente otro) {
        return Integer.compare(this.prioridad, otro.prioridad);
    }
}