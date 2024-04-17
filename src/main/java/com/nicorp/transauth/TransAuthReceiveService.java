package com.nicorp.transauth;

import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Arrays;
import java.util.List;

// Класс сервиса для приема данных
public class TransAuthReceiveService extends Service {

    private BroadcastReceiver dataReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            if ("com.nicorp.DATA_SEND_ACTION".equals(intent.getAction())) {
                String data = intent.getStringExtra("data");
                // Обработка принятых данных
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        IntentFilter intentFilter = new IntentFilter("com.nicorp.DATA_SEND_ACTION");
        registerReceiver(dataReceiver, intentFilter);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        unregisterReceiver(dataReceiver);
    }
}