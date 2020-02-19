package it.denina.rivoira.clientrubrica;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter<Contatto> {
    public CustomAdapter(@NonNull Context context, int resource, @NonNull List<Contatto> objects) {
        super(context, resource, objects);
    }

    @SuppressLint({"ViewHolder", "InflateParams"})
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = Objects.requireNonNull(inflater).inflate(R.layout.layout_listview, null);

        TextView txtNome = convertView.findViewById(R.id.txtNomeL);
        TextView txtCognome = convertView.findViewById(R.id.txtCognomeL);
        TextView txtTelefono = convertView.findViewById(R.id.txtTelefonoL);

        txtNome.setText(Objects.requireNonNull(getItem(position)).getNome());
        txtCognome.setText(Objects.requireNonNull(getItem(position)).getCognome());
        txtTelefono.setText(Objects.requireNonNull(getItem(position)).getTelefono());

        return convertView;
    }

}
