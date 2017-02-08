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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Residue extends AppCompatActivity {
    Intent i;
    String value;
    String url = "http://rnafrabase.cs.put.poznan.pl/";
    ProgressDialog rProgressDialog;
    String Re, Ex, P, Tm, X, Y;
    String[] resid = {"Any","A", "C", "G", "U", "a", "c", "g", "u"};
    String[] experim = {"Any", "X-ray","NMR", "Electron Microscopy", "Other"};
    String[] sugarP = {"Any", "North     <-45,  45>", "East   <45, 135>", "South   <135, -135>", "West  <-135, -45>"};
    String[] sugarTm = {"Any", "<-90, 15>", "<15, 30>", "<30, 50>", "<50, 90>"};
    String[] torsionX = {"Any", "Syn     <-90, 90>", "Anti    <90, -90>"};
    String[] torsionY = {"Any", "gauche+  <-120, 0>", "gauche-  <0, 120>", "trans <120, -120>"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_residue);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button search = (Button) findViewById(R.id.button8);

        Spinner spinnerR = (Spinner) findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, resid);
        //final Spinner spinnerR = (Spinner)findViewById(R.id.spinner2);
        spinnerR.setAdapter(adapter);
        spinnerR.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        Re = resid[0];
                        break;
                    case 1:
                        Re = resid[1];
                        break;
                    case 2:
                        Re = resid[2];
                        break;
                    case 3:
                        Re = resid[3];
                        break;
                    case 4:
                        Re = resid[4];
                        break;
                    case 5:
                        Re = resid[5];
                        break;
                    case 6:
                        Re = resid[6];
                        break;
                    case 7:
                        Re = resid[7];
                        break;
                    case 8:
                        Re = resid[8];
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Re= "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerE = (Spinner) findViewById(R.id.spinner3);
        ArrayAdapter<String> adapterE = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, experim);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerE.setAdapter(adapterE);
        spinnerE.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        Ex = experim[0];
                        break;
                    case 1:
                        Ex = experim[1];
                        break;
                    case 2:
                        Ex = experim[2];
                        break;
                    case 3:
                        Ex = experim[3];
                        break;
                    case 4:
                        Ex = experim[4];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Ex= "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerP = (Spinner) findViewById(R.id.spinner5);
        ArrayAdapter<String> adapterP = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sugarP);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerP.setAdapter(adapterP);
        spinnerP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        P = sugarP[0];
                        break;
                    case 1:
                        P = sugarP[1];
                        break;
                    case 2:
                        P = sugarP[2];
                        break;
                    case 3:
                        P = sugarP[3];
                        break;
                    case 4:
                        P = sugarP[4];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                P= "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerTm = (Spinner) findViewById(R.id.spinner6);
        ArrayAdapter<String> adapterTm = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, sugarTm);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerTm.setAdapter(adapterTm);
        spinnerTm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        Tm = sugarTm[0];
                        break;
                    case 1:
                        Tm = sugarTm[1];
                        break;
                    case 2:
                        Tm = sugarTm[2];
                        break;
                    case 3:
                        Tm = sugarTm[3];
                        break;
                    case 4:
                        Tm = sugarTm[4];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Tm= "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerX = (Spinner) findViewById(R.id.spinner4);
        ArrayAdapter<String> adapterX = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, torsionX);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerX.setAdapter(adapterX);
        spinnerX.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        X = torsionX[0];
                        break;
                    case 1:
                        X = torsionX[1];
                        break;
                    case 2:
                        X = torsionX[2];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                X= "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerY = (Spinner) findViewById(R.id.spinner7);
        ArrayAdapter<String> adapterY = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, torsionY);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerY.setAdapter(adapterY);
        spinnerY.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        Y = torsionY[0];
                        break;
                    case 1:
                        Y = torsionY[1];
                        break;
                    case 2:
                        Y = torsionY[2];
                        break;
                    case 3:
                        Y = torsionY[3];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Y= "Any";
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
            rProgressDialog = new ProgressDialog(Residue.this);
            rProgressDialog.setTitle("RNA frabase");
            rProgressDialog.setMessage("Searching...");
            rProgressDialog.setIndeterminate(false);
            rProgressDialog.show();
        }

        @Override
        protected void onPostExecute(Void result) {

            rProgressDialog.dismiss();
        }

    }

}
