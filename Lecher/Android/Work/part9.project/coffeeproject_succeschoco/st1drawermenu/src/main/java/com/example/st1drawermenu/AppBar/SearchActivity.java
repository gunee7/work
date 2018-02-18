package com.example.st1drawermenu.AppBar;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.st1drawermenu.R;

import java.util.ArrayList;
import java.util.List;


public class SearchActivity extends AppCompatActivity {


    private Button btn_add;
    private ImageView btnPrev;
    private EditText txtUrl;
    private WebView webView;
    private ListView list_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add = findViewById(R.id.btn_add);
        btnPrev = findViewById(R.id.btnPrev);

        ButtonInner bi = new ButtonInner();

        btn_add.setOnClickListener(bi);
        btnPrev.setOnClickListener(bi);

        webView = findViewById(R.id.webView);

        webView.setWebViewClient(new MyWebClient());
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setBuiltInZoomControls(true);
    }

    private class ButtonInner implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_add:
                    String url = txtUrl.getText().toString();
                    webView.loadUrl("http://" + url);
                    break;

                case R.id.btnPrev:
                    webView.goBack();
                    break;
            }
        }
    }

    private class MyWebClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }



    private List<String> makeData() {
        List<String> data = new ArrayList<>();
        data.add("item 01");
        data.add("item 02");
        data.add("item 03");
        data.add("item 04");
        data.add("item 05");
        data.add("item 06");
        data.add("item 07");
        data.add("item 08");
        data.add("item 09");
        data.add("item 10");
        data.add("item 11");
        data.add("item 12");
        data.add("item 13");
        data.add("item 14");
        data.add("item 15");
        data.add("item 16");
        data.add("item 17");
        data.add("item 18");
        data.add("item 19");
        data.add("item 20");
        return data;
    }
}





