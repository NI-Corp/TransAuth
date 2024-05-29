package com.nicorp.transauth;

import static com.nicorp.transauth.TransAuth.getAppId;
import static com.nicorp.transauth.TransAuth.getPermissions;
import static com.nicorp.transauth.TransAuth.getSecretKey;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;


import java.io.IOException;

// Класс сервиса для отправки данных
public class TransAuthService extends Service {
    Permission[] permissions;
    String appId;
    String secretKey;

    public TransAuthService() {
        Log.d("TransAuth", "TransAuthService created");
        this.permissions = getPermissions();
        this.appId = getAppId();
        this.secretKey = getSecretKey();
    }

    private boolean checkPossibility() {
        // TODO: проверить возможность использования сервиса
        if (appId == null || secretKey == null) {
            return false;
        }
        return true;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void sendData(Context context, String data, String receiverPackageName) {
        Intent intent = new Intent();
        intent.setAction("com.nicorp.DATA_SEND_ACTION");
        intent.setPackage(receiverPackageName);
        intent.putExtra("data", data);
        context.sendBroadcast(intent);
        // Log
        Log.d("TransAuth", "Data sent: " + data);
        Log.d("TransAuth", "Receiver package name: " + receiverPackageName);
    }
}