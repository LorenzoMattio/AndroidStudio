package it.denina.rivoira.brodcastreciver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.widget.Toast;

public class MyReciverWiFi extends BroadcastReceiver {
    ConnectivityManager mioManager;

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        String azione = intent.getAction();
        if (("android.net.conn.CONNECTIVITY_CHANGE").equals((azione))) {
            mioManager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
            NetworkInfo mioNetwork = mioManager.getActiveNetworkInfo();
            if (mioNetwork != null) {
                if (mioNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                    Toast.makeText(context, "prova", Toast.LENGTH_LONG).show();
                }
            }
        }
        if (intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)) {

            Integer livelloMax = intent.getIntExtra(BatteryManager.EXTRA_SCALE,0);
            Integer livelloAttuale = intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            Integer livelloConnessione = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, 0);
            Integer stato = intent.getIntExtra(BatteryManager.EXTRA_STATUS,0);
            Toast.makeText(context, "Batteria" + livelloAttuale.toString() + "/" + livelloMax.toString(), Toast.LENGTH_LONG).show();

        }
    }
}
