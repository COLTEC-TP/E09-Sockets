package com.example.a2016951820.sockets;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Objects;

/**
 * Created by a2016951820 on 15/10/18.
 */

public class Cliente implements Runnable {
    Button btn;
    EditText text;
    Activity activity;

    Cliente(Activity activity, Button btn, EditText text){
        this.activity = activity;
        this.btn = btn;
        this.text = text;
    }

    @Override
    public void run() {

        Socket trysocket = null;
        try {
            trysocket = new Socket("10.0.2.2", 8080);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final Socket socket = trysocket;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    PrintStream saida = new PrintStream(socket.getOutputStream());
                    saida.println(text.getText().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Toast.makeText(activity, "Mensagem enviada com sucesso", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
