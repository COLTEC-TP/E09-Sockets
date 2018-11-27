package br.ufmg.coltec.socketclientandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    public static final int PORT = 4444;
    public static final String IP = "192.168.43.76";
    protected Cliente client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(new ClientThread()).start();

        Button enviar = findViewById(R.id.enviar);

        enviar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                TextView text = findViewById(R.id.mensagem);
                String mensagem = text.getText().toString();
                client.enviaMensagem(mensagem);
            }
        });

    }


    class ClientThread implements Runnable {
        @Override
        public void run() {
            client = new Cliente(IP, PORT);
        }

    }

}
