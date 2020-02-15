package it.denina.rivoira.mattioverifica;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.os.BatteryManager;
import android.os.Build;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

public class BatteryReciver extends BroadcastReceiver {
    NotificationManager mioManager;
    PendingIntent mioPending = null;

    // Notifiche
    NotificationCompat.Builder miaNotifica = null;
    NotificationChannel canale = null;
    Intent mioIntent = null;

    @Override
    public void onReceive(Context context, Intent intent) {

        String azione = intent.getAction();
        if (intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)) {
            Integer livelloMassimo = intent.getIntExtra(BatteryManager.EXTRA_SCALE,0);
            Integer livelloAttuale = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            Integer livelloVolt = intent.getIntExtra(BatteryManager.EXTRA_VOLTAGE,0);
            Integer livelloTemperatura = intent.getIntExtra(BatteryManager.EXTRA_TEMPERATURE,0);

            mioIntent = new Intent(context,Main2Activity.class);
            mioIntent.putExtra("max", livelloMassimo.toString());
            mioIntent.putExtra("attuale", livelloAttuale.toString());
            mioIntent.putExtra("volt", livelloVolt.toString());
            mioIntent.putExtra("temperatura", livelloTemperatura.toString());

            PendingIntent nome = PendingIntent.getActivity(context,015,mioIntent,PendingIntent.FLAG_UPDATE_CURRENT);

            mioManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
            miaNotifica = new NotificationCompat.Builder(context);
            miaNotifica.setSmallIcon(R.drawable.ic_launcher_background);
            miaNotifica.setContentTitle("Risultati batteira");
            miaNotifica.setContentText("Premi per visualizzare");
            miaNotifica.setContentIntent(nome);

            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                canale = new NotificationChannel("1001","Risultati batteria",NotificationManager.IMPORTANCE_HIGH);
                canale.enableLights(true);
                canale.setLightColor(Color.RED);
                canale.enableVibration(true);
                miaNotifica.setChannelId("1001");
                mioManager.createNotificationChannel(canale);
            }
            mioManager.notify(0,miaNotifica.build());
        }

    }
}
