package com.example.user.interfejsrnafrabase;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Stem extends AppCompatActivity {

    Intent i;
    String value;
    String url = "http://rnafrabase.cs.put.poznan.pl/";
    ProgressDialog sProgressDialog;
    String ExS, L;
    String[] exp_stem = {"Any","X-Ray", "NMR", "Electron Microscopy", "Other"};
    String[] length = {"Exact length", "Interval (from, to)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stem);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button search = (Button) findViewById(R.id.button7);

        Spinner spinnerE = (Spinner) findViewById(R.id.spinner24);
        ArrayAdapter<String> adapterE = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, exp_stem);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerE.setAdapter(adapterE);
        spinnerE.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        ExS = exp_stem[0];
                        break;
                    case 1:
                        ExS = exp_stem[1];
                        break;
                    case 2:
                        ExS = exp_stem[2];
                        break;
                    case 3:
                        ExS = exp_stem[3];
                        break;
                    case 4:
                        ExS = exp_stem[4];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                ExS = "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerL = (Spinner) findViewById(R.id.spinner25);
        ArrayAdapter<String> adapterL = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, length);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerL.setAdapter(adapterL);
        spinnerL.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        L = length[0];
                        break;
                    case 1:
                        L = length[1];
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                L = "Exact length";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });


        search.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // Execute Description AsyncTask

                new Search().execute();
            }
        });
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
                i = new Intent(getApplicationContext(), Help.class);
                startActivity(i);
                return true;
            case R.id.menu_about:
                i = new Intent(getApplicationContext(), About.class);
                startActivity(i);
                return true;
            case R.id.menu_contact:
                i = new Intent(getApplicationContext(), Contact.class);
                startActivity(i);
                return true;
            case R.id.menu_links:
                i = new Intent(getApplicationContext(), Links.class);
                startActivity(i);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private class Search extends AsyncTask<Void, Void, Void> {
        @Override
        protected Void doInBackground(Void... params) {
            try {
                // Connect to the web site
                Document document = Jsoup.connect(url).get();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            sProgressDialog = new ProgressDialog(Stem.this);
            sProgressDialog.setTitle("RNA frabase");
            sProgressDialog.setMessage("Searching...");
            sProgressDialog.setIndeterminate(false);
            sProgressDialog.show();
        }

        @Override
        protected void onPostExecute(Void result) {

            sProgressDialog.dismiss();
        }

    }
}
