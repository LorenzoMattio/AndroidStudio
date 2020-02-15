package it.denina.rivoira.clientrubrica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Objects;

public class Activity_visualizza extends AppCompatActivity {

    private TextView textView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizza);

        textView = findViewById(R.id.txtVisualizza);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String dati = Objects.requireNonNull(getIntent().getExtras()).getString("dati");
        textView.setText(dati);
    }
}
