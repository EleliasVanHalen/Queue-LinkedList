package models;

import java.util.Deque;
import java.util.LinkedList;

public class Navegador {
    private Deque<String> historial;
    private int paginasAdelante;

    public Navegador() {
        this.historial = new LinkedList<>();
        this.paginasAdelante = 0;
    }

    public String visitar(String pagina) {
        while (paginasAdelante > 0) {
            historial.removeLast();
            paginasAdelante--;
        }

        historial.addFirst(pagina);
        return "Visitando: " + pagina;
    }

    public String retroceder() {
        if (historial.size() - paginasAdelante > 1) {
            String paginaActual = historial.removeFirst();
            historial.addLast(paginaActual);
            paginasAdelante++;
            return "[Acción: Retroceder]\n" + obtenerPaginaActual();
        } else {
            return "Límite alcanzado. No hay páginas anteriores.";
        }
    }

    public String avanzar() {
        if (paginasAdelante > 0) {
            String paginaAdelante = historial.removeLast();
            historial.addFirst(paginaAdelante);
            paginasAdelante--;
            return "[Acción: Avanzar]\n" + obtenerPaginaActual();
        } else {
            return "No hay páginas hacia adelante.";
        }
    }

    public String obtenerPaginaActual() {
        if (!historial.isEmpty()) {
            return "-> Página actual: " + historial.peekFirst();
        }
        return "-> El navegador está en blanco.";
    }
}