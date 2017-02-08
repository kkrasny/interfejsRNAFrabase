package com.example.user.interfejsrnafrabase;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;

public class AdvancedSearchActivity extends AppCompatActivity {
    Intent i;
    String url = "http://rnafrabase.cs.put.poznan.pl/";
    ProgressDialog aProgressDialog;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advanced_search);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button search = (Button) findViewById(R.id.button2);

        boolean Case = ((CheckBox) findViewById(R.id.checkCase)).isChecked();
        boolean Add = ((CheckBox) findViewById(R.id.checkAdd)).isChecked();
        boolean Include = ((CheckBox) findViewById(R.id.checkInclude)).isChecked();
        boolean Strand = ((CheckBox) findViewById(R.id.checkStrand)).isChecked();
        boolean Xray = ((CheckBox) findViewById(R.id.checkXray)).isChecked();
        boolean NMR = ((CheckBox) findViewById(R.id.checkNMR)).isChecked();
        boolean Electron = ((CheckBox) findViewById(R.id.checkElectron)).isChecked();
        boolean Other = ((CheckBox) findViewById(R.id.checkOther)).isChecked();
        final EditText sequence = (EditText) findViewById(R.id.editText3);
        sequence.setText(Html.fromHtml(getString(R.string.table)));





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
            aProgressDialog = new ProgressDialog(AdvancedSearchActivity.this);
            aProgressDialog.setTitle("RNA frabase");
            aProgressDialog.setMessage("Searching...");
            aProgressDialog.setIndeterminate(false);
            aProgressDialog.show();
        }

        @Override
        protected void onPostExecute(Void result) {

            aProgressDialog.dismiss();
        }

    }



}
