
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

    public class Tratamento extends Thread{
    private Socket cliente;

    Tratamento(Socket c){
        this.cliente = c;
    }

    public void run(){

        try {
            Scanner s = new Scanner (cliente.getInputStream());
            while (s.hasNextLine()) {
                System.out.println (s.nextLine());
            }
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(Tratamento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}