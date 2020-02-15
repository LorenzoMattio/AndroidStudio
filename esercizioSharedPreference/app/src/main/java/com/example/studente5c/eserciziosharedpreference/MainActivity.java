package com.example.studente5c.eserciziosharedpreference;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.print.PrintAttributes;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private NotificationManager mioManager =null;           // serve per passare la notifica al O.S.
    private NotificationCompat.Builder miaNotifica = null;
    private NotificationChannel canale = null;
    private Intent mioIntent = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences pippo = getSharedPreferences("nome",MODE_PRIVATE);   //richiama una shared preference e lo salva dentro pippo   il primo è un nome, il secondo se può essere visto da tutte le altre apllicazioni o no
        SharedPreferences pippo1 = getSharedPreferences("cognome",MODE_PRIVATE);
        // MODE_PRIVATE significa che queste preferenze possono essere utilizzate solo per questa applicazione

        SharedPreferences.Editor mioEditor = pippo.edit(); //ritorna un oggetto di tipo shared preference quest'operazione deve sempre essere fatta quando memorizziamo stringhe all'interno di questa variabile
        SharedPreferences.Editor mioEditor1 = pippo1.edit();

        mioEditor.putString("nome","ITIS"); // memorizzo in mioEditor Chiave e Valore
        mioEditor1.putString("cognome","Rivoira");

        pippo.getString("nome","stringa di default");       //defValue è il valore di default
        pippo1.getString("cognome","stringa di default");


        //Intent futuri: sono Intent che dipendono dal programmatore
        mioIntent = new Intent(getApplicationContext(),seconda.class);
        PendingIntent nome = PendingIntent.getActivity(getApplicationContext(),015,mioIntent,PendingIntent.FLAG_UPDATE_CURRENT);


        //PER GESTIRE LE NOTIFICHE ABBIAMO BISOGNO DI 3 CLASSI: notificationMangager, notificationCompact, notificationChannel (Questa da Android 8 in poi)
        mioManager = (NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);  //lega la nostra applicazione al O.S.
        miaNotifica = new NotificationCompat.Builder(getApplicationContext());           //crea la notifica, però questa notifica non ha una forma
        miaNotifica.setSmallIcon(R.drawable.ic_launcher_background);
        miaNotifica.setContentTitle("Sono il titolo");
        miaNotifica.setContentText("io sono la descrizione della notifica");
        miaNotifica.setContentIntent(nome);
        //mioManager.notify(0,miaNotifica.build());    Scritto così è deprecato da Android 8
        //Build.VERSION_CODES.O ==> Android  8 Oreo
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){      //Build.VERSION.SDK_INT recupera la versione del nostro Sistema Operativo
            canale = new NotificationChannel("1001","pincopallino",NotificationManager.IMPORTANCE_HIGH);
            canale.enableLights(true);
            canale.setLightColor(Color.GREEN);
            canale.enableVibration(true);
            miaNotifica.setChannelId("1001");
            mioManager.createNotificationChannel(canale);
        }
        mioManager.notify(0,miaNotifica.build());    //passa la notifica al O.S.
    }
}