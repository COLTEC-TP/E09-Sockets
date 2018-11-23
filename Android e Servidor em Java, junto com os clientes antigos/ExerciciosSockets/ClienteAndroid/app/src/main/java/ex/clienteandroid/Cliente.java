package ex.clienteandroid;

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

public class Cliente implements Runnable {
    Activity interfacex;
    EditText mensagem;
    Button botao;

    Cliente(Activity interfacex, EditText mensagem, Button botao){
        this.interfacex = interfacex;
        this.botao = botao;
        this.mensagem = mensagem;
    }

    @Override
    public void run() {

        Socket socket = null;
        try {
            socket = new Socket("127.0.0.1", 8080);
        } catch (IOException in) {
            in.printStackTrace();
        }

        final Socket finalsocket = socket;

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    PrintStream saida = new PrintStream(finalsocket.getOutputStream());
                    saida.println(mensagem.getText().toString());
                } catch (IOException in) {
                    in.printStackTrace();
                }
                Toast.makeText(interfacex, "Mensagem enviada ao servidor Java", Toast.LENGTH_SHORT).show();
            }
        });

    }
}