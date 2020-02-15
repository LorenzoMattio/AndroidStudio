package it.denina.rivoira.mattioverifica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView txtRisultati = null;
    private Intent intentRisultati = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txtRisultati = findViewById(R.id.txtRisultati);
    }

    @Override
    protected void onResume() {
        super.onResume();
        intentRisultati = getIntent();
        String strRisultati = "Capacita max:" + intentRisultati.getStringExtra("max") +  "Batteria attuale: " + intentRisultati.getStringExtra("attuale") + "Livello temperatura: " + intentRisultati.getStringExtra("volt") + "Livello volt: " + intentRisultati.getStringExtra("temperatura");
        txtRisultati.setText(strRisultati);

    }
}
