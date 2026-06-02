import models.Navegador;

import javax.swing.JOptionPane;

public class Ejercicio2 {
    public static void main(String[] args) {
        Navegador chrome = new Navegador();
        String[] opciones = {"Visitar nueva página", "Retroceder", "Avanzar", "Cerrar Navegador"};

        JOptionPane.showMessageDialog(null,
                "Navegador inicializado.\nListo para operar.",
                "Sistema en línea",
                JOptionPane.INFORMATION_MESSAGE);

        while (true) {
            String estadoActual = chrome.obtenerPaginaActual();

            int eleccion = JOptionPane.showOptionDialog(null,
                    estadoActual + "\n\n¿Qué acción desea ejecutar?",
                    "Panel de Navegación",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opciones,
                    opciones[0]);

            if (eleccion == 0) { // Visitar
                String nuevaPagina = JOptionPane.showInputDialog(null,
                        "Ingrese la URL o nombre del sitio:",
                        "Nueva Pestaña",
                        JOptionPane.QUESTION_MESSAGE);

                if (nuevaPagina != null && !nuevaPagina.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, chrome.visitar(nuevaPagina.trim()));
                }
            } else if (eleccion == 1) { // Retroceder
                JOptionPane.showMessageDialog(null, chrome.retroceder(), "Historial", JOptionPane.INFORMATION_MESSAGE);
            } else if (eleccion == 2) { // Avanzar
                JOptionPane.showMessageDialog(null, chrome.avanzar(), "Historial", JOptionPane.INFORMATION_MESSAGE);
            } else { // Cerrar o presionar la 'X'
                JOptionPane.showMessageDialog(null, "Apagando sistema de navegación. Buen día, señor.", "Desconexión", JOptionPane.WARNING_MESSAGE);
                break;
            }
        }
    }
}