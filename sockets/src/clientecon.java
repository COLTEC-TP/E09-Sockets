package veazey.github.io;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

    public class clientecon extends Thread  {
    private Socket cliente;
    public ConectaCliente(Socket cliente) { this.cliente = cliente;

    }

    @Override


    public void run() {  Scanner entrada = null;

        try {
            in = new Scanner(cliente.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        String clienteIp = cliente.getInetAddress().getHostAddress();
        System.out.println("Cliente (" + clienteIp + ") conexão estabelecida");
        while (in.hasNextLine()) {
            System.out.println(clienteIp +  in.nextLine()); }
    }
}