package it.denina.rivoira.clientrubrica;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Activity_carica extends AppCompatActivity {

    private Button btnCarica = null;
    private EditText edtCognome = null;
    private EditText edtNome = null;
    private EditText edtNumero = null;
    private RequestQueue coda = null;
    private Context context = this;
    private String server = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__carica);
        btnCarica = findViewById(R.id.btn_carica1);
        edtCognome = findViewById(R.id.edt_cognome);
        edtNome = findViewById(R.id.edt_nome);
        edtNumero = findViewById(R.id.edt_telefono);
        coda = Volley.newRequestQueue(this);

    }

    @Override
    protected void onResume() {
        super.onResume();
        server = Objects.requireNonNull(getIntent().getExtras()).getString("server");
        btnCarica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request = new StringRequest(Request.Method.POST, server + "/carica", new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() {
                        Map<String, String> dati = new HashMap<>();
                        dati.put("nome", edtNome.getText().toString());
                        dati.put("cognome", edtCognome.getText().toString());
                        dati.put("telefono", edtNumero.getText().toString());
                        return dati;
                    }
                };
                coda.add(request);
                AlertDialog.Builder messaggio = new AlertDialog.Builder(context);
                messaggio.setTitle("CARICAMETO AVVENUTO CON SUCCESSO!");
                messaggio.setNeutralButton("Pagina iniziale", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                messaggio.show();
            }
        });
    }
}
