import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class cliente {

    public static void main(String[] args) throws UnknownHostException, IOException {

        Socket cliente = new Socket("127.0.0.1", 3000);
        System.out.println("O clinte se conectou");

        Scanner scanner = new Scanner(System.in);
        PrintStream data = new PrintStream(cliente.getOutputStream());

        while(scanner.hasNextLine()){
            data.println(scanner.nextLine());
        }

        data.close();
        scanner.close();
        cliente.close();

    }
}
