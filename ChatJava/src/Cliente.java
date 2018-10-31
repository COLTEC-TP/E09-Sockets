import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main ( String [] args ) throws IOException {

        Socket cliente = new Socket ("127.0.0.1", 8080);
        System.out.println("Cliente se comunicou ao servidor!");
        Scanner teclado = new Scanner ( System.in );
        PrintStream saida = new PrintStream (cliente.getOutputStream());

         while ( teclado.hasNextLine() ) {
            saida.println ( teclado.nextLine() );
         }

         saida.close();
         teclado.close();
         cliente.close();

    }
}
