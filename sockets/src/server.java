import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
class Server {

    public static void main (String[] args) throws
            IOException {
        ServerSocket servidor = new ServerSocket (666);
        System.out.println(" Porta 666 aberta !");

        Socket cliente = servidor . accept () ;
        System.out.println("Estabelecendo nova conexão com o CLIENTE" +
                cliente.getInetAddress().getHostAddress()
        );


        Scanner s = new Scanner(cliente.getInputStream());

        while (s.hasNextLine()) {
            System.out.println(s.nextLine());
        }

        s.close();
        servidor.close();
        cliente.close() ;
    }
}