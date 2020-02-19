package it.denina.rivoira.clientrubrica;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.ArrayList;
import java.util.Objects;

public class Activity_visualizza extends AppCompatActivity {

    private ListView listView = null;
    public String server = "http://192.168.76.206:1391";
    private ArrayList<Contatto> contatti = null;
    private RequestQueue requestQueue = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizza);

        listView = findViewById(R.id.listView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        StringRequest request = new StringRequest(Request.Method.POST, server + "/visualizza", new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                String[] rubrica = response.split("\n");
                contatti = new ArrayList<>();
                for (String contatto : rubrica) {
                    String[] campo = contatto.split(";");
                    if(!campo[0].isEmpty() && !campo[1].isEmpty() && !campo[2].isEmpty()) {
                        contatti.add(new Contatto(campo[0], campo[1], campo[2]));
                    }
                }
                CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), R.layout.layout_listview, contatti);
                listView.setAdapter(customAdapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        requestQueue.add(request);
    }
}
