package io.gegen07.github;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12000);

        while (true) {
            Socket client = serverSocket.accept();
            System.out.println("Nova conexão com o cliente " + client.getInetAddress().getHostAddress());

            ClientHandler handler = new ClientHandler(client);
            handler.start();
        }
    }
}
