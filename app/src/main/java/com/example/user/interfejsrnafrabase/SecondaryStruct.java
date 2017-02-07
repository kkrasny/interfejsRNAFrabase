package com.example.user.interfejsrnafrabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SecondaryStruct extends AppCompatActivity {

    Intent i;
    String value;
    Document doc;
    Element cont;
    WebView web;
    String url_sec = "http://rnafrabase.cs.put.poznan.pl/?act=secondary%20structures";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary_struct);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        web=(WebView)findViewById(R.id.webView);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.menu_search:
                i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                return true;
            case R.id.menu2_residue:
                i = new Intent(getApplicationContext(), Residue.class);
                startActivity(i);
                return true;
            case R.id.menu2_base:
                i = new Intent(getApplicationContext(), Basepair.class);
                startActivity(i);
                return true;
            case R.id.menu2_multi:
                i = new Intent(getApplicationContext(), Multiplet.class);
                startActivity(i);
                return true;
            case R.id.menu2_dinucl:
                i = new Intent(getApplicationContext(), DinuclStep.class);
                startActivity(i);
                return true;
            case R.id.menu2_stem:
                i = new Intent(getApplicationContext(), Stem.class);
                startActivity(i);
                return true;
            case R.id.menu2_loop:
                i = new Intent(getApplicationContext(), Loop.class);
                startActivity(i);
                return true;
            case R.id.menu_secondary:
                Intent ijj = new Intent(getApplicationContext(), SecondaryStruct.class);
                startActivity(ijj);
                return true;
            case R.id.menu_help:
                i = new Intent(getApplicationContext(), New.class);
                startActivity(i);
                i.putExtra(value, "Help");
                return true;
            case R.id.menu_about:
                i = new Intent(getApplicationContext(), New.class);
                startActivity(i);
                i.putExtra(value, "About");
                return true;
            case R.id.menu_contact:
                i = new Intent(getApplicationContext(), New.class);
                startActivity(i);
                i.putExtra(value, "Contact");
                return true;
            case R.id.menu_links:
                i = new Intent(getApplicationContext(), New.class);
                startActivity(i);
                i.putExtra(value, "Links");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
