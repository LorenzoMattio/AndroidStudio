package it.denina.rivoira.mattioverifica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;

import android.Manifest;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.os.BatteryManager;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    IntentFilter mioIntentFilter = null;
    BatteryReciver mioReciver;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.BATTERY_STATS}, 1);
        mioIntentFilter = new IntentFilter();
        mioIntentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        mioReciver = new BatteryReciver();
        mioIntentFilter.addAction(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(mioReciver,mioIntentFilter);
    }

}

// Intent.action_battery_change
// Manifest runtime manifest.permission.battery_:states
//
