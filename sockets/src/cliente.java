package veazey.github.io;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


    public class cliente {
        public static void main(String[] args) throws IOException {
        Socket cliente = new Socket("10.0.0.35", 25525); System.out.println("Cliente conectado com sucesso!!!");
        Scanner in = new Scanner(System.in);
        PrintStream out = new PrintStream(cliente.getOutputStream());

        while (entrada.hasNextLine()) {
            saida.println(entrada.nextLine());
        }

        out.close();
        in.close();
        cliente.close();
    }
}