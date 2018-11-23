import java.io.IOException;
import java.net.*;
import java.sql.Connection;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) throws
            IOException {

        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("A porta para a conexão foi aberta! (12345)");

        while (true) {
            Socket cliente = servidor.accept();
            System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());

            Connections conexao = new Connections(cliente);

            Thread thread = new Thread(conexao);
            thread.start();
        }
    }
}