/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package e09.sockets;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author riversong
 */
public class Servidor {
    
    public static void main ( String args []) throws IOException {
        ServerSocket servidor = new ServerSocket (3000);
        System.out.println(" Porta 3000 aberta !");
        
        
        while(true){
            Socket cliente = servidor.accept();
            System.out.println("Nova conexão com o cliente " + cliente.getInetAddress().getHostAddress());

            TratamentoClass tratamento = new TratamentoClass (cliente);
            tratamento.start();
        }
        
    }
}
