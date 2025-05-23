package com.example.s08_notificacion;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Handler;

import androidx.core.app.NotificationCompat;

public class NotificacionHelper {

    public static final String CHANNEL_ID = "canal_boot";
    private static final int NOTIF_ID = 1;

    public static void mostrarNotificacion(Context context, String mensaje) {
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel canal = new NotificationChannel(CHANNEL_ID, "Notificación de inicio", NotificationManager.IMPORTANCE_DEFAULT);
            manager.createNotificationChannel(canal);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(android.R.drawable.ic_dialog_info)
                .setContentTitle("Sistema iniciado")
                .setContentText(mensaje)
                .setAutoCancel(true);

        manager.notify(NOTIF_ID, builder.build());

        new Handler().postDelayed(() -> manager.cancel(NOTIF_ID), 5000);
    }
}
