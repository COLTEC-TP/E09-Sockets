import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class tratamentoSocket implements Runnable {
    private Socket s;
    private Thread t;

    tratamentoSocket(Socket client){
        this.s = client;
    }
    public void setThread(Thread t){
        this.t = t;
    }

    @Override
    public void run() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(this.s.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(scanner.hasNextLine()){
            System.out.println(this.s.getInetAddress().getHostAddress()+" : "+scanner.nextLine());
        }

        scanner.close();
        try {
            this.s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.t.interrupt();
    }
}
