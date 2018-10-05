package ibryans.github.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) throws IOException {

        ServerSocket server = new ServerSocket(10123);

        System.out.println("Servidor aberto na porta 10123");

        while (true) {

            // Conectando ao servidor
            Socket cliente = server.accept();

            ConectaCliente conexao = new ConectaCliente(cliente);

            conexao.start();

        }

    }

}
