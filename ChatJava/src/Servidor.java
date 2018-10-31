import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

    public static void main(String[] args) throws IOException{

        ServerSocket servidor = new ServerSocket(8080);
        System.out.println("8080 foi aberta ");

        for(int id =1; id <10; id++) {

            Socket cliente = servidor.accept();
            System.out.println("Conexão Cliente " + cliente.getInetAddress().getHostAddress());

            RunnableCliente runnableCliente = new RunnableCliente(cliente, id);
            Thread thread = new Thread(runnableCliente);
            thread.start();
        }

        servidor.close();

    }
}
