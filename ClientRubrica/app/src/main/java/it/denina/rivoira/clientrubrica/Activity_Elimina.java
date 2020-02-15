package it.denina.rivoira.clientrubrica;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.Objects;

public class Activity_elimina extends AppCompatActivity {

    private EditText edtElimina = null;
    private Button btnElimina = null;
    private RequestQueue coda = null;
    private Context context = this;
    private String server = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elimina);

        edtElimina = findViewById(R.id.edt_cognome1);
        btnElimina = findViewById(R.id.btn_elimina1);
        coda = Volley.newRequestQueue(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        server = Objects.requireNonNull(getIntent().getExtras()).getString("server");
        btnElimina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringRequest request = new StringRequest(Request.Method.POST, server + "/elimina?cognome=" + edtElimina.getText().toString(), new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                });
                coda.add(request);
                AlertDialog.Builder messaggio = new AlertDialog.Builder(context);
                messaggio.setTitle("Eliminazione effettuata!");
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
