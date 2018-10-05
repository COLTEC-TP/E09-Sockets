package ibryans.github.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(10123);

        System.out.println("Servidor aberto na porta 10123");

        // Conectando ao servidor
        Socket cliente = server.accept();

        Scanner entrada = new Scanner(cliente.getInputStream());
        String clienteIp = cliente.getInetAddress().getHostAddress();

        System.out.println("Cliente (" + clienteIp + ") conectado");

        while(entrada.hasNextLine()) {
            System.out.println(clienteIp + ": " + entrada.nextLine());
        }

        entrada.close();
        cliente.close();
        server.close();

    }

}
