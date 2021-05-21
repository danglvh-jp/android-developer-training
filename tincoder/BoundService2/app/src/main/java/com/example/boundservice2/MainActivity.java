package com.example.boundservice2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Messenger mMessenger;
    private boolean isServiceConnected;

    private Button btnStartService;
    private Button btnStopService;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            mMessenger = new Messenger(service);
            isServiceConnected = true;
            // send message play music
            sendMessagePlayMusic();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            mMessenger = null;
            isServiceConnected = false;
        }
    };

    private void sendMessagePlayMusic() {
        Message message = Message.obtain(null, MusicService.MSG_PLAY_MUSIC, 0, 0);
        try {
            mMessenger.send(message);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStartService = findViewById(R.id.btn_start_service);
        btnStopService = findViewById(R.id.btn_stop_service);

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickStartService();
            }
        });

        btnStopService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickStopService();
            }
        });
    }

    private void onClickStartService() {
        Intent intent = new Intent(MainActivity.this, MusicService.class);
        bindService(intent, mServiceConnection, Context.BIND_AUTO_CREATE);
    }

    private void onClickStopService() {
        if (isServiceConnected) {
            unbindService(mServiceConnection);
            isServiceConnected = false;
        }
    }
}