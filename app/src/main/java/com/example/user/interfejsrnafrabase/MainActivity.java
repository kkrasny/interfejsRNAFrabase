
package com.example.user.interfejsrnafrabase;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import android.text.Html;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // URL Address
    String url = "http://rnafrabase.cs.put.poznan.pl";
    ProgressDialog mProgressDialog;
    Intent i;
    String value;
    String insert;
    String P;
    String seqText;
    String[] elements = {"1 (tRNA) ","2 (hairpin loop)", "3 (bulge) ",
            "4 (Non symmetrical internal loop) ", "5 (Three-way junction) ", "6 (Kissing loops) "};


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Locate the Buttons in activity_main.xml
        Button searchbutton = (Button) findViewById(R.id.search_button);
        Button choosebutton = (Button) findViewById(R.id.choose_button);
        Button advsearchbutton = (Button) findViewById(R.id.adv_search_button);

        final EditText sequence = (EditText) findViewById(R.id.editText);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, elements);
        final Spinner spinnerP = (Spinner)findViewById(R.id.spinner);
        spinner.setAdapter(adapter);
        spinnerP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        P = elements[0];
                        sequence.setText(Html.fromHtml(getString(R.string.example1)));
                        break;
                    case 1:
                        P = elements[1];
                        sequence.setText(Html.fromHtml(getString(R.string.example2)));
                        break;
                    case 2:
                        P = elements[2];
                        sequence.setText(Html.fromHtml(getString(R.string.example3)));
                        break;
                    case 3:
                        P = elements[3];
                        sequence.setText(Html.fromHtml(getString(R.string.example4)));
                        break;
                    case 4:
                        P = elements[4];
                        sequence.setText(Html.fromHtml(getString(R.string.example5)));
                        break;
                    case 5:
                        P = elements[5];
                        sequence.setText(Html.fromHtml(getString(R.string.example6)));
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                P= "X";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });
        // Capture button click
        choosebutton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {

            }
        });

        // Capture button click
        searchbutton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // Execute Description AsyncTask
                new SearchFrabase().execute();
            }
        });

        // Capture button click
        advsearchbutton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // Execute Logo AsyncTask
                Intent i = new Intent(getApplicationContext(), AdvancedSearchActivity.class);
                startActivity(i);
                seqText = String.valueOf(sequence.getText());
                i.putExtra(insert, seqText);
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
                i = new Intent(getApplicationContext(), SecondaryStruct.class);
                startActivity(i);
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




    // Description AsyncTask
    private class SearchFrabase extends AsyncTask<Void, Void, Void> {
        String desc;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(MainActivity.this);
            mProgressDialog.setTitle("RNA frabase");
            mProgressDialog.setMessage("Searching...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

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
        protected void onPostExecute(Void result) {
            mProgressDialog.dismiss();
        }

    }

}
