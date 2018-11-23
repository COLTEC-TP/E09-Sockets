import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args)
            throws IOException {

        Socket cliente = new Socket("127.0.0.5", 12345);
        System.out.println("O cliente se conectou ao servidor!");

        Scanner mensagens = new Scanner(System.in);
        PrintStream saida = new PrintStream(cliente.getOutputStream());

        while (mensagens.hasNextLine()) {
            saida.println(mensagens.nextLine());
        }

        saida.close();
        mensagens.close();
        cliente.close();
    }
}