import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Connections implements Runnable  {

    private Socket cliente;

    Connections(Socket cliente){
        this.cliente = cliente;
    }

    @Override
    public void run(){
        Scanner mensagens = null;
        try {
            mensagens = new Scanner(cliente.getInputStream());
            while(mensagens.hasNextLine()){
                System.out.println(mensagens.nextLine());
            }
            mensagens.close();
        }  catch (IOException in) {
            in.printStackTrace();
        }

    }
}