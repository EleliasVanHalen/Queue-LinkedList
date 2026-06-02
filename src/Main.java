import models.Banco;

import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        Banco sucursal = new Banco();
        int contador = 0;
        int limite = 8;

        JOptionPane.showMessageDialog(null,
                "Sistema inicializado. Proceda a ingresar un máximo de 8 clientes.",
                "Gestión de Turnos",
                JOptionPane.INFORMATION_MESSAGE);

        while (contador < limite) {
            String nombre = JOptionPane.showInputDialog(null,
                    "Ingrese el nombre del cliente (" + (contador + 1) + " de " + limite + "):",
                    "Registro de Clientes",
                    JOptionPane.QUESTION_MESSAGE);

            if (nombre == null) {
                JOptionPane.showMessageDialog(null, "Ingreso de clientes detenido por el usuario.");
                break;
            }

            if (!nombre.trim().isEmpty()) {
                sucursal.registrarCliente(nombre.trim());
                contador++;
            } else {
                JOptionPane.showMessageDialog(null,
                        "Dato inválido. El nombre no puede estar vacío.",
                        "Error de Entrada",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        JOptionPane.showMessageDialog(null,
                "Registro completado. El sistema procesará la fila ahora.\n(Revise la consola para ver el informe de atención).",
                "Procesando",
                JOptionPane.INFORMATION_MESSAGE);

        sucursal.iniciarAtencion();
    }
}