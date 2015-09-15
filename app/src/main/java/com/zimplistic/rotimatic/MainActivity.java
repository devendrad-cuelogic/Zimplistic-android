package com.zimplistic.rotimatic;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URISyntaxException;

import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;

public class MainActivity extends AppCompatActivity{

    TextView command_text;
    Button send_btn;
    String command = "";

    private Socket mSocket;

    {
        try {
            mSocket = IO.socket(Constants.ROTIMATIC_SERVER_URL);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        send_btn = (Button) findViewById(R.id.button);
        command_text = (TextView) findViewById(R.id.editText);
        mSocket.on("command", onNewMessage);
        mSocket.on("status", onNewStatus);

        mSocket.connect();
        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                command = command_text.getText().toString();
                mSocket.emit("command", command);
            }
        });
    }

    private Emitter.Listener onNewStatus = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), args[0].toString(), Toast.LENGTH_LONG).show();
                }
            });
        }
    };

    private Emitter.Listener onNewMessage = new Emitter.Listener() {
        @Override
        public void call(final Object... args) {

            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(getApplicationContext(), args[0].toString(), Toast.LENGTH_LONG).show();
                }
            });
        }
    };

}
