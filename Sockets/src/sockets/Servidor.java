/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sockets;

import java.net.*;
import java.util.*;
import java.io.*;
import java.net.ServerSocket;


public class Servidor {
    public static void main ( String args []) throws IOException {
        ServerSocket servidor = new ServerSocket (4444) ;
        System.out.println(" Porta 4444 aberta !");
        while(true){
            Socket cliente = servidor.accept();
            TratamentoClass tratamento = new TratamentoClass(cliente);
            Thread t = new Thread(tratamento);
            t.start();

            //servidor.close();
        }
    }
}