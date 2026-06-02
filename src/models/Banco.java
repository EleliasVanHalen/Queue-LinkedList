package models;

import java.util.LinkedList;
import java.util.Queue;
import javax.swing.JOptionPane;

public class Banco {
    private Queue<String> filaClientes;
    private final int LIMITE = 8;

    public Banco() {
        this.filaClientes = new LinkedList<>();
    }

    public void registrarCliente(String nombre) {
        if (filaClientes.size() < LIMITE) {
            filaClientes.offer(nombre);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Límite alcanzado. No se pueden encolar más de " + LIMITE + " clientes.",
                    "Aviso del Sistema",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public void iniciarAtencion() {
        System.out.println("--- INICIANDO ATENCIÓN EN VENTANILLA ---");

        while (!filaClientes.isEmpty()) {
            System.out.println("\nCliente en espera: " + filaClientes.peek());

            String clienteAtendido = filaClientes.poll();
            System.out.println("Atendiendo a: " + clienteAtendido);

            System.out.println("Cantidad de clientes restantes: " + filaClientes.size());
        }

        System.out.println("\n--- PROTOCOLO FINALIZADO. LA FILA ESTÁ VACÍA ---");
    }
}