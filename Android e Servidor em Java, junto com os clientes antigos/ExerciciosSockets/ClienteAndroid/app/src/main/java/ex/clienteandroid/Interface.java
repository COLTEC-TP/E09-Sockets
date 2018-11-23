package ex.clienteandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Interface extends AppCompatActivity {
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_cliente);

            final EditText mensagem = findViewById(R.id.mensagem);
            Button botao = findViewById(R.id.botao);

            final Cliente cliente = new Cliente(this, mensagem, botao);
            new Thread(cliente).start();
        }
}
