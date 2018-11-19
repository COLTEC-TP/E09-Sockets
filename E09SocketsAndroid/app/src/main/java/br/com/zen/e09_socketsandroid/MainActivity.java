package br.com.zen.e09_socketsandroid;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Socket socket;
    ObjectOutputStream canalSaida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (ContextCompat.checkSelfPermission(MainActivity.this,
                Manifest.permission.INTERNET)
                != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                    Manifest.permission.INTERNET)) {
            } else {
                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.INTERNET},
                        0);
            }
        }

        button = findViewById(R.id.buttonWrite);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ClienteThread().execute();
            }
        });
    }

    private class ClienteThread extends AsyncTask<Void, Void, Boolean> {

        @Override
        protected Boolean doInBackground(Void... voids) {
            try {
                socket = new Socket("10.0.2.2", 12345);
                canalSaida = new ObjectOutputStream(socket.getOutputStream());
                canalSaida.writeObject("Teste");
                socket.close();
            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return true;
        }
    }

}
