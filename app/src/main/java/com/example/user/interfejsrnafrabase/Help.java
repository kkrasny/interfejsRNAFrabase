package com.example.user.interfejsrnafrabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class Help extends AppCompatActivity {

    String url_help = "http://rnafrabase.cs.put.poznan.pl/index.php?act=help";
    Document help = Jsoup.connect(url_help).get();
    Element content_help = help.getElementById("framain");

    public Help() throws IOException {
    }
    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        web=(WebView)findViewById(R.id.webView);
        web.loadUrl(url_help);
    }
}
