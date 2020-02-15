package it.denina.rivoira.app_client;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebBackForwardList;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnConnect;
    private TextView txtLog;
    private WebView webView;
    private static final String server = "http://192.168.76.206:1391";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnConnect = findViewById(R.id.btnConnect);
        txtLog = findViewById(R.id.txtLog);
        webView = findViewById(R.id.webView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnConnect:
                webView.loadUrl(server);
                webView.setWebViewClient(new WebViewClient());
                break;
        }
    }
}
