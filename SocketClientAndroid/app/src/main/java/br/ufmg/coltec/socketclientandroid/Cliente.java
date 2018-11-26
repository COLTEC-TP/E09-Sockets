package br.ufmg.coltec.socketclientandroid;


import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

class Cliente {

    private Socket cliente;

    public Cliente(String ip, int port){
        try {
            InetAddress serverAddr = InetAddress.getByName(ip);
            this.cliente = new Socket(serverAddr, port);
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
    public void enviaMensagem (String mensagem)  {
        PrintWriter out = null;
        try {
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.cliente.getOutputStream())), true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.println(mensagem);
    }



}
