package ibryans.github.io;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws IOException {

        Socket cliente = new Socket("127.0.0.1", 10123);

        System.out.println("Cliente conectado ao servidor!");

        Scanner entrada = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());

        while (entrada.hasNextLine()) {
            saida.println(entrada.nextLine());
        }

        saida.close();
        entrada.close();
        cliente.close();

    }

}
