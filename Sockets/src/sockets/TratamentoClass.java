/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Mateu
 */
public class TratamentoClass implements Runnable {
    private Socket cliente; 
    public TratamentoClass(Socket cliente) {
        this.cliente = cliente;

    }
    @Override
        public void run() {
            try{
                System.out.println(" Nova conexão com o cliente " +cliente.getInetAddress().getHostAddress()); 
                Scanner scanner = new Scanner(cliente.getInputStream());
                while(scanner.hasNextLine()){
                    System.out.println(scanner.nextLine());
                }
                scanner.close();
                cliente.close();
            }catch(IOException e){
                System.out.println(e);
            };
        }
}
