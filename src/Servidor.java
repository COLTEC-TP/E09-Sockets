import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) throws
            IOException {

        ServerSocket servidor = new ServerSocket(12345);
        System.out.println("Porta 12345 aberta!");

        Socket cliente = servidor.accept();
        System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());

        Scanner scanner = new Scanner (cliente.getInputStream());
        while(scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }

        scanner.close();
        servidor.close();
        cliente.close();
    }
}