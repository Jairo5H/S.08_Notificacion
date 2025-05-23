package com.example.s08_notificacion;

import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

public class MiServicio extends Service {

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, NotificacionHelper.CHANNEL_ID)
                    .setContentTitle("Servicio en ejecución")
                    .setContentText("Registrando bienvenida...")
                    .setSmallIcon(android.R.drawable.ic_dialog_info);

            //startForeground(2, builder.build());
        }

        Log.d("MiServicio", "Bienvenida registrada en el LogCat");

        new Handler().postDelayed(this::stopSelf, 2000);

        return START_NOT_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
