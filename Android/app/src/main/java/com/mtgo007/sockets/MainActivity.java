package com.mtgo007.sockets;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ClientSocket socket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        socket = new ClientSocket("192.168.1.5", 3000);
        socket.execute();

        final EditText input = findViewById(R.id.input);
        final Button send = findViewById(R.id.btnSend);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = input.getText().toString();
                socket.enviarMensagem(msg);
                input.setText("");
                Toast.makeText(MainActivity.this, "Mensagem Enviada!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
