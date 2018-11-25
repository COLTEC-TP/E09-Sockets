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
        ServerSocket servidor = new ServerSocket (12345) ;
        System.out.println(" Porta 12345 aberta !");
   
        Socket cliente = servidor.accept();
        System.out.println(" Nova conexão com o cliente " +cliente.getInetAddress().getHostAddress()); 
        
        Scanner scanner = new Scanner(cliente.getInputStream());
        while(scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
        
        scanner.close();
        cliente.close();
        servidor.close();
    }
}