package com.example.s08_notificacion;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

public class BootReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Log.d("BootReceiver", "Sistema iniciado, lanzando servicio y mostrando notificación.");

            Intent servicioIntent = new Intent(context, MiServicio.class);

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                context.startForegroundService(servicioIntent);
            } else {
                context.startService(servicioIntent);
            }

            NotificacionHelper.mostrarNotificacion(context, "Bienvenido, el sistema ha iniciado correctamente");
        }
    }
}
