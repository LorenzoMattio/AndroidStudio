package it.denina.rivoira.clientrubrica;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity {

    private Button btnVisualizza = null;
    private Button btnOrdina = null;
    private Button btnCarica = null;
    private Button btnElimina = null;
    private RequestQueue coda = null;
    private Intent intent = null;
    public String server = "http://192.168.76.206:1391";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCarica = findViewById(R.id.btnCarica);
        btnVisualizza = findViewById(R.id.btnVisualizza);
        btnOrdina = findViewById(R.id.btnOrdina);
        btnElimina = findViewById(R.id.btnElimina);
        coda = Volley.newRequestQueue(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnVisualizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
