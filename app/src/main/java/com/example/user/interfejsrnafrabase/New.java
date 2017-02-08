package com.example.user.interfejsrnafrabase;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.os.AsyncTask;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.URL;

public class New extends AppCompatActivity {

    Intent i;
    String url_help = "http://rnafrabase.cs.put.poznan.pl/?act=help";
    String url_about = "http://rnafrabase.cs.put.poznan.pl/?act=about";
    String url_links = "http://rnafrabase.cs.put.poznan.pl/?act=links";
    String url_contact = "http://rnafrabase.cs.put.poznan.pl/?act=contact%20us";
    Document help;
    Document about;
    Document links;
    Document contact;
    Document doc;
    Element cont;

    WebView web;
    String value = "Help";





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        web=(WebView)findViewById(R.id.webView);

        if(value == "Help"){
            new getHelp().execute();
            web.loadUrl(url_about);
        }
        else if(value == "About"){
            new getAbout().execute();
            web.loadUrl(url_about);
        }
        else if(value == "Links"){
            new getLinks().execute();
            web.loadUrl(url_about);
        }
        else if(value == "Contact"){
            new getContact().execute();
            web.loadUrl(url_contact);
        }

        //cont = doc.getElementById("framain");
        //String elem = cont.html();
        //web.loadData(elem, "text/html", "UTF-8");

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



    private class getHelp extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                // Connect to the web site
                doc = Jsoup.connect(url_help).get();
                //Element help =
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private class getAbout extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                // Connect to the web site
                doc = Jsoup.connect(url_about).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private class getLinks extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                // Connect to the web site
                doc = Jsoup.connect(url_links).get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

    private class getContact extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                // Connect to the web site
                doc = Jsoup.connect(url_contact).get();
                // Using Elements to get the class data
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }
}
