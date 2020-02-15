package it.denina.rivoira.clientrubrica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;


public class MainActivity extends AppCompatActivity {

    private Button btnVisualizza = null;
    private Button btnOrdina = null;
    private Button btnCarica = null;
    private Button btnElimina = null;
    private RequestQueue requestQueue = null;
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
        requestQueue = Volley.newRequestQueue(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        btnVisualizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request = new StringRequest(Request.Method.POST, server + "/visualizza", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        intent = new Intent(getApplicationContext(), Activity_visualizza.class);
                        intent.putExtra("dati", response);
                        startActivity(intent);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
                requestQueue.add(request);
            }
        });

        btnElimina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), Activity_elimina.class);
                intent.putExtra("server", server);
                startActivity(intent);
            }
        });

        btnCarica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(getApplicationContext(), Activity_carica.class);
                intent.putExtra("server", server);
                startActivity(intent);
            }
        });

        btnOrdina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request = new StringRequest(Request.Method.POST, server + "/ordina", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
                requestQueue.add(request);
                Toast.makeText(getApplicationContext(), "RUBRICA ORDINATA!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
