import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class RunnableCliente implements Runnable {
    private Socket cliente;
    private int id;

    RunnableCliente(Socket cliente, int id){
        this.cliente = cliente;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            Scanner s = new Scanner (cliente.getInputStream());
            while (s.hasNextLine()) {
                System.out.println ("Cliente " + id + ":  " + s.nextLine());
            }
            s.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
