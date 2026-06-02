import models.GestorTareas;

import javax.swing.JOptionPane;

public class Ejercicio4 {
    public static void main(String[] args) {
        GestorTareas gestor = new GestorTareas();
        String[] opciones = {"Ingresar Normal", "Ingresar Urgente", "Procesar y Salir"};

        JOptionPane.showMessageDialog(null,
                "Gestor de tareas en línea.\nListo para recibir instrucciones.",
                "Sistema Inicializado",
                JOptionPane.INFORMATION_MESSAGE);

        while (true) {
            int eleccion = JOptionPane.showOptionDialog(null,
                    "Seleccione el tipo de tarea que desea registrar:",
                    "Panel de Control de Tareas",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            if (eleccion == 0) {
                String tarea = JOptionPane.showInputDialog(null,
                        "Describa la tarea NORMAL:",
                        "Registro Rutinario",
                        JOptionPane.PLAIN_MESSAGE);

                if (tarea != null && !tarea.trim().isEmpty()) {
                    gestor.agregarNormal(tarea.trim());
                }

            } else if (eleccion == 1) {
                String tarea = JOptionPane.showInputDialog(null,
                        "Describa la tarea URGENTE:",
                        "Alerta Máxima",
                        JOptionPane.WARNING_MESSAGE);

                if (tarea != null && !tarea.trim().isEmpty()) {
                    gestor.agregarUrgente(tarea.trim());
                }

            } else {
                String reporte = gestor.procesarTodas();
                JOptionPane.showMessageDialog(null,
                        reporte,
                        "Reporte de Ejecución",
                        JOptionPane.INFORMATION_MESSAGE);
                break;
            }
        }
    }
}