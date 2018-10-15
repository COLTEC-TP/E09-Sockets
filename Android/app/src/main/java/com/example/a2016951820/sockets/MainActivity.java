package com.example.a2016951820.sockets;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText txtInfo = findViewById(R.id.txt_info);
        Button btnEnviar = findViewById(R.id.btn_enviar);

        final Cliente cliente = new Cliente(this, btnEnviar, txtInfo);
        new Thread(cliente).start();

    }

}
