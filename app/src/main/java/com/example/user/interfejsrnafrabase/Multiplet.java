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

public class Multiplet extends AppCompatActivity {

    Intent i;
    String value;
    String url = "http://rnafrabase.cs.put.poznan.pl/";
    ProgressDialog muProgressDialog;
    String R1, R2, R3, ExM;
    String[] res_str1 = {"Any","A", "C", "G", "U", "a", "c", "g", "u"};
    String[] res_str2 = {"Any","A", "C", "G", "U", "a", "c", "g", "u"};
    String[] res_str3 = {"Any","A", "C", "G", "U", "a", "c", "g", "u"};
    String[] exp_meth = {"Any","X-Ray", "NMR", "Electron Microscopy", "Other"};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button search = (Button) findViewById(R.id.button5);


        Spinner spinnerR1 = (Spinner) findViewById(R.id.spinner22);
        ArrayAdapter<String> adapterR1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, res_str1);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerR1.setAdapter(adapterR1);
        spinnerR1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        R1 = res_str1[0];
                        break;
                    case 1:
                        R1= res_str1[1];
                        break;
                    case 2:
                        R1 = res_str1[2];
                        break;
                    case 3:
                        R1 = res_str1[3];
                        break;
                    case 4:
                        R1 = res_str1[4];
                        break;
                    case 5:
                        R1 = res_str1[5];
                        break;
                    case 6:
                        R1 = res_str1[6];
                        break;
                    case 7:
                        R1 = res_str1[7];
                        break;
                    case 8:
                        R1 = res_str1[8];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                R1 = "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerR3 = (Spinner) findViewById(R.id.spinner20);
        ArrayAdapter<String> adapterR3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, res_str3);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerR3.setAdapter(adapterR3);
        spinnerR3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        R3 = res_str3[0];
                        break;
                    case 1:
                        R3= res_str3[1];
                        break;
                    case 2:
                        R3 = res_str3[2];
                        break;
                    case 3:
                        R3 = res_str3[3];
                        break;
                    case 4:
                        R3 = res_str3[4];
                        break;
                    case 5:
                        R3 = res_str3[5];
                        break;
                    case 6:
                        R3 = res_str3[6];
                        break;
                    case 7:
                        R3 = res_str3[7];
                        break;
                    case 8:
                        R3 = res_str3[8];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                R3 = "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerR2 = (Spinner) findViewById(R.id.spinner21);
        ArrayAdapter<String> adapterR2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, res_str2);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerR2.setAdapter(adapterR2);
        spinnerR2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        R2 = res_str2[0];
                        break;
                    case 1:
                        R2= res_str2[1];
                        break;
                    case 2:
                        R2 = res_str2[2];
                        break;
                    case 3:
                        R2 = res_str2[3];
                        break;
                    case 4:
                        R2 = res_str2[4];
                        break;
                    case 5:
                        R2 = res_str2[5];
                        break;
                    case 6:
                        R2 = res_str2[6];
                        break;
                    case 7:
                        R2 = res_str2[7];
                        break;
                    case 8:
                        R2 = res_str2[8];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                R2 = "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerE = (Spinner) findViewById(R.id.spinner19);
        ArrayAdapter<String> adapterE = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, exp_meth);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerE.setAdapter(adapterE);
        spinnerE.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        ExM = exp_meth[0];
                        break;
                    case 1:
                        ExM = exp_meth[1];
                        break;
                    case 2:
                        ExM = exp_meth[2];
                        break;
                    case 3:
                        ExM = exp_meth[3];
                        break;
                    case 4:
                        ExM = exp_meth[4];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                ExM = "Any";
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
            muProgressDialog = new ProgressDialog(Multiplet.this);
            muProgressDialog.setTitle("RNA frabase");
            muProgressDialog.setMessage("Searching...");
            muProgressDialog.setIndeterminate(false);
            muProgressDialog.show();
        }

        @Override
        protected void onPostExecute(Void result) {

            muProgressDialog.dismiss();
        }

    }

}
