package com.mtgo007.sockets;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by mtgo0 on 16/11/2018.
 */

public class ClientSocket extends AsyncTask {

    private static String ip = "[IP]";
    private static int porta = 4500;
    private Socket socket = null;
    private PrintStream out = null;


    ClientSocket(String  ip, int porta){
        this.ip = ip;
        this.porta = porta;
    }

    @Override
    protected Object doInBackground(Object[] objects) {
        try {
            socket = new Socket(this.ip, this.porta);
            out = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.e("","Do in backdround");
        return null;
    }

    public void enviarMensagem(String mensagem){
        this.out.println(mensagem);
    }

    private void closeSocket() throws IOException {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
