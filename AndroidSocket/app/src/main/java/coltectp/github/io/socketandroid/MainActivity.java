package coltectp.github.io.socketandroid;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class MainActivity extends AppCompatActivity {

    private Button sendButton;
    private EditText messageEditText;

    private static final String IP = "192.168.25.147";
    private static Socket client;
    private static PrintStream channel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendButton = findViewById(R.id.send_btn);
        messageEditText = findViewById(R.id.message_et);

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendMessage sendMessageTask = new SendMessage();
                sendMessageTask.execute();
            }
        });
    }

    class SendMessage extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {

            try {
                client = new Socket(IP, 12000);

                PrintStream channel = new PrintStream(client.getOutputStream());
                channel.println(messageEditText.getText().toString());

                client.close();
                channel.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}


