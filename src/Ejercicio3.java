import models.Hospital;
import models.Paciente;

import javax.swing.JOptionPane;

public class Ejercicio3 {
    public static void main(String[] args) {
        Hospital emergencias = new Hospital();
        int pacientesRegistrados = 0;
        int minimoPacientes = 6;

        JOptionPane.showMessageDialog(null,
                "Protocolo de Triaje activado.\nProceda a registrar un mínimo de 6 pacientes.",
                "Sistema Hospitalario",
                JOptionPane.INFORMATION_MESSAGE);

        while (pacientesRegistrados < minimoPacientes) {
            String nombre = JOptionPane.showInputDialog(null,
                    "Paciente (" + (pacientesRegistrados + 1) + " de " + minimoPacientes + ")\nIngrese el nombre:",
                    "Registro de Ingreso",
                    JOptionPane.QUESTION_MESSAGE);

            if (nombre == null) {
                JOptionPane.showMessageDialog(null, "Registro cancelado por el operador. Abortando.", "Alerta", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (nombre.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Dato inválido. El nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            String[] niveles = {"1 - Emergencia", "2 - Urgente", "3 - Consulta General"};
            int seleccion = JOptionPane.showOptionDialog(null,
                    "Seleccione el nivel de gravedad para: " + nombre.trim(),
                    "Clasificación",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.WARNING_MESSAGE,
                    null,
                    niveles,
                    niveles[0]);

            if (seleccion == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(null, "Operación cancelada.", "Alerta", JOptionPane.WARNING_MESSAGE);
                return;
            }

            int prioridad = seleccion + 1;

            emergencias.registrarPaciente(new Paciente(nombre.trim(), prioridad));
            pacientesRegistrados++;
        }

        JOptionPane.showMessageDialog(null,
                emergencias.obtenerOrdenAtencion(),
                "Tablero de Turnos",
                JOptionPane.INFORMATION_MESSAGE);
    }
}