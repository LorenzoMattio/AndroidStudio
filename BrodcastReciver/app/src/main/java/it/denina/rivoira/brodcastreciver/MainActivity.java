package it.denina.rivoira.brodcastreciver;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    // Autorizazioni pericolose: sensori corporei, calendario, contatti, posizione, microfono, telefono, sms, archiviazione, videocamera
    // i permessi devono essere dichiarati all'interndo dell'activity

    IntentFilter mioIntentFilter = null;
    MyReciverWiFi mioReciver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.BATTERY_STATS}, 1);
        mioIntentFilter = new IntentFilter();
        mioIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        mioReciver = new MyReciverWiFi();
        mioIntentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(mioReciver,mioIntentFilter);
    }
}
