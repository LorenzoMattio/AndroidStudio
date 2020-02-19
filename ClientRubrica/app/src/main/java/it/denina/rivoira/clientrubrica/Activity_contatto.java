package it.denina.rivoira.clientrubrica;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Objects;

public class Activity_contatto extends AppCompatActivity {

    private TextView txtNome = null;
    private TextView txtCognome = null;
    private TextView txtTelefono = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contatto);

        txtNome = findViewById(R.id.txtNomeC);
        txtCognome = findViewById(R.id.txtCognomeC);
        txtTelefono = findViewById(R.id.txtTelefonoC);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String nome = Objects.requireNonNull(getIntent().getExtras()).getString("nome");
        String numero = Objects.requireNonNull(getIntent().getExtras()).getString("telefono");
        String cognome = Objects.requireNonNull(getIntent().getExtras()).getString("cognome");

        txtNome.setText(nome);
        txtCognome.setText(cognome);
        txtTelefono.setText(numero);
    }

}
