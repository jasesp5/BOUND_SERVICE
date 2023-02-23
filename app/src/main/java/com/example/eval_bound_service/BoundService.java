package com.example.eval_bound_service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class BoundService extends Service {

    private final IBinder binder = new LocalBinder();
    private boolean isBound = false;

    public class LocalBinder extends Binder {
        BoundService getService() {
            return BoundService.this;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        isBound = true;
        Toast.makeText(this, "servicio enlazado", Toast.LENGTH_SHORT).show();
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        isBound = false;
        Toast.makeText(this, "servicio desenlazado", Toast.LENGTH_SHORT).show();
        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Toast.makeText(this, "servicio destruido", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    public boolean isBound() {
        return isBound;
    }
}

