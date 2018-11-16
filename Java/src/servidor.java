import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor {
    public static void main ( String args []) throws IOException {
        ServerSocket servidor = new ServerSocket(3000) ;
        System.out.println ("Servidor inicioado na porta 3000");

        while(true) {
            Socket client = servidor.accept();
            System.out.println("Cliente conectado: "
                    + client.getInetAddress().getHostAddress());

            tratamentoSocket tratamento = new tratamentoSocket(client);
            Thread t = new Thread(tratamento);
            tratamento.setThread(t);
            t.start();
        }
    }
}
