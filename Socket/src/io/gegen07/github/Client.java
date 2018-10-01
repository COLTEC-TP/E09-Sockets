package io.gegen07.github;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1", 12000);

        Scanner teclado = new Scanner(System.in);
        PrintStream channel = new PrintStream(client.getOutputStream());

        while(true) {
            String s = teclado.nextLine();
            if (s.equals("quit")) {
                break;
            } else {
                channel.println(s);
            }
        }

        teclado.close();
        channel.close();
        client.close();
    }
}
