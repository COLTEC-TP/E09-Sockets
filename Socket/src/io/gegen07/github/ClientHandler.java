package io.gegen07.github;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler extends Thread{

    private Socket client;

    public ClientHandler(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            Scanner s = new Scanner(client.getInputStream());
            while(s.hasNextLine()) {
                System.out.println(s.nextLine());
            }
            s.close();
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
