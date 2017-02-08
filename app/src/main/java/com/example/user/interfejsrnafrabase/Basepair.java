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

public class Basepair extends AppCompatActivity {
    Intent i;
    String value;
    String url = "http://rnafrabase.cs.put.poznan.pl/";
    ProgressDialog bProgressDialog;
    String Re1, Re2, ExB, W, Sae, Sh, St, Sta, Bu, Op, P;
    String[] westhof = {"Any","H/H cis", "H/H tran", "H/S cis", "H/S tran", "H/W cis", "H/W tran",
            "S/H cis", "S/H tran", "S/S cis", "S/S tran", "S/W cis", "S/W tran", "W/H cis",
            "W/H tran", "W/S cis", "W/S tran", "W/W cis", "W/W tran", "Unclassified"};
    String[] saenger= {"Any", "XI", "XXIV", "XVII", "II", "XII, XIII", "V", "I", "XIX", "XXVIII",
            "XIV, XV", "XVII", "III", "XXIII", "VII", " ", "VIII", "XVI", "X", "XI"};
    String[] res_str1 = {"Any","A", "C", "G", "U", "a", "c", "g", "u"};
    String[] res_str2 = {"Any","A", "C", "G", "U", "a", "c", "g", "u"};
    String[] exp_base = {"Any","X-Ray", "NMR", "Electron Microscopy", "Other"};
    String[] shear = {"Any", "<-180°, -0,52°>","<-0,52°, -0,17°>", "<-0,17°, 0°>", "<0°, 0,16°>",
            "<0,16°, 0,56°>", "<0,56°, 180°>"};
    String[] stretch = {"Any", "<-180°, -0,51°>","<-0,51°, -0,23°>", "<-0,23°, -0,15°>",
            "<-0,15°, -0,09°>", "<-0,09°, -0,01°>", "<-0,01°, 180°>"};
    String[] stagger = {"Any", "<-180°, -0,5°>","<-0,5°, -0,22°>", "<-0,22°, -0,07°>",
            "<-0,07°, 0,06°>", "<0,06°, 0,31°>", "<0,31°, 180°>"};
    String[] buckle = {"Any", "<-180°, -8,97°>","<-8,97°, -3,08°>", "<-3,08°, 0,07°>",
            "<0,07°, 3,49°>", "<3,49°, 9,44°>", "<9,44°, 180°>"};
    String[] propeller = {"Any", "<-180°, -15,03°>","<-15,03°, -9,37°>", "<-9,37°, -4,62°>",
            "<-4,62°, -1,21°>", "<-1,21°, 2,49°>", "<2,49°, 180°>"};
    String[] opening = {"Any", "<-180°, -5,64°>","<-5,64°, -2°>", "<-2°, -0,11°>",
            "<-0,11°, 1,76°>", "<1,76°, 4,7°>", "<4,7°, 180°>"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basepair);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button search = (Button) findViewById(R.id.button4);

        Spinner spinnerR1 = (Spinner) findViewById(R.id.spinner8);
        ArrayAdapter<String> adapterR1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, res_str1);
        spinnerR1.setAdapter(adapterR1);
        spinnerR1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        Re1 = res_str1[0];
                        break;
                    case 1:
                        Re1 = res_str1[1];
                        break;
                    case 2:
                        Re1 = res_str1[2];
                        break;
                    case 3:
                        Re1 = res_str1[3];
                        break;
                    case 4:
                        Re1 = res_str1[4];
                        break;
                    case 5:
                        Re1 = res_str1[5];
                        break;
                    case 6:
                        Re1 = res_str1[6];
                        break;
                    case 7:
                        Re1 = res_str1[7];
                        break;
                    case 8:
                        Re1 = res_str1[8];
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Re1= "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerR2 = (Spinner) findViewById(R.id.spinner9);
        ArrayAdapter<String> adapterR2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, res_str2);
        //final Spinner spinnerR = (Spinner)findViewById(R.id.spinner2);
        spinnerR2.setAdapter(adapterR2);
        spinnerR2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        Re2 = res_str2[0];
                        break;
                    case 1:
                        Re2 = res_str2[1];
                        break;
                    case 2:
                        Re2 = res_str2[2];
                        break;
                    case 3:
                        Re2 = res_str2[3];
                        break;
                    case 4:
                        Re2 = res_str2[4];
                        break;
                    case 5:
                        Re2 = res_str2[5];
                        break;
                    case 6:
                        Re2 = res_str2[6];
                        break;
                    case 7:
                        Re2 = res_str2[7];
                        break;
                    case 8:
                        Re2 = res_str2[8];
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Re2= "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerE = (Spinner) findViewById(R.id.spinner10);
        ArrayAdapter<String> adapterE = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, exp_base);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerE.setAdapter(adapterE);
        spinnerE.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        ExB = exp_base[0];
                        break;
                    case 1:
                        ExB = exp_base[1];
                        break;
                    case 2:
                        ExB = exp_base[2];
                        break;
                    case 3:
                        ExB = exp_base[3];
                        break;
                    case 4:
                        ExB = exp_base[4];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                ExB= "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerW = (Spinner) findViewById(R.id.spinner11);
        ArrayAdapter<String> adapterW = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, westhof);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerW.setAdapter(adapterW);
        spinnerW.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        W = westhof[0];
                        break;
                    case 1:
                        W = westhof[1];
                        break;
                    case 2:
                        W = westhof[2];
                        break;
                    case 3:
                        W = westhof[3];
                        break;
                    case 4:
                        W = westhof[4];
                        break;
                    case 5:
                        W = westhof[5];
                        break;
                    case 6:
                        W = westhof[6];
                        break;
                    case 7:
                        W = westhof[7];
                        break;
                    case 8:
                        W = westhof[8];
                        break;
                    case 9:
                        W = westhof[9];
                        break;
                    case 10:
                        W = westhof[10];
                        break;
                    case 11:
                        W = westhof[11];
                        break;
                    case 12:
                        W = westhof[12];
                        break;
                    case 13:
                        W = westhof[13];
                        break;
                    case 14:
                        W = westhof[14];
                        break;
                    case 15:
                        W = westhof[15];
                        break;
                    case 16:
                        W = westhof[16];
                        break;
                    case 17:
                        W = westhof[17];
                        break;
                    case 18:
                        W = westhof[18];
                        break;
                    case 19:
                        W = westhof[19];
                        break;


                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                W= "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerSae = (Spinner) findViewById(R.id.spinner12);
        ArrayAdapter<String> adapterSae = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, saenger);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerSae.setAdapter(adapterSae);
        spinnerSae.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        Sae = saenger[0];
                        break;
                    case 1:
                        Sae = saenger[1];
                        break;
                    case 2:
                        Sae = saenger[2];
                        break;
                    case 3:
                        Sae = saenger[3];
                        break;
                    case 4:
                        Sae = saenger[4];
                        break;
                    case 5:
                        Sae = saenger[5];
                        break;
                    case 6:
                        Sae = saenger[6];
                        break;
                    case 7:
                        Sae = saenger[7];
                        break;
                    case 8:
                        Sae = saenger[8];
                        break;
                    case 9:
                        Sae = saenger[9];
                        break;
                    case 10:
                        Sae = saenger[10];
                        break;
                    case 11:
                        Sae = saenger[11];
                        break;
                    case 12:
                        Sae = saenger[12];
                        break;
                    case 13:
                        Sae = saenger[13];
                        break;
                    case 14:
                        Sae = saenger[14];
                        break;
                    case 15:
                        Sae = saenger[15];
                        break;
                    case 16:
                        Sae = saenger[16];
                        break;
                    case 17:
                        Sae = saenger[17];
                        break;
                    case 18:
                        Sae = saenger[18];
                        break;
                    case 19:
                        Sae = saenger[19];
                        break;
                    case 20:
                        Sae = saenger[20];
                        break;
                    case 21:
                        Sae = saenger[21];
                        break;


                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Sae = "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerSh = (Spinner) findViewById(R.id.spinner13);
        ArrayAdapter<String> adapterSh = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, shear);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerSh.setAdapter(adapterSh);
        spinnerSh.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        Sh = shear[0];
                        break;
                    case 1:
                        Sh = shear[1];
                        break;
                    case 2:
                        Sh = shear[2];
                        break;
                    case 3:
                        Sh = shear[3];
                        break;
                    case 4:
                        Sh = shear[4];
                        break;
                    case 5:
                        Sh = shear[5];
                        break;
                    case 6:
                        Sh = shear[6];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Sh = "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerSt = (Spinner) findViewById(R.id.spinner14);
        ArrayAdapter<String> adapterSt = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stretch);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerSt.setAdapter(adapterSt);
        spinnerSt.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        St = stretch[0];
                        break;
                    case 1:
                        St = stretch[1];
                        break;
                    case 2:
                        St = stretch[2];
                        break;
                    case 3:
                        St = stretch[3];
                        break;
                    case 4:
                        St = stretch[4];
                        break;
                    case 5:
                        St = stretch[5];
                        break;
                    case 6:
                        St = stretch[6];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                St = "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerX = (Spinner) findViewById(R.id.spinner15);
        ArrayAdapter<String> adapterX = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stagger);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerX.setAdapter(adapterX);
        spinnerX.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        Sta = stagger[0];
                        break;
                    case 1:
                        Sta = stagger[1];
                        break;
                    case 2:
                        Sta = stagger[2];
                        break;
                    case 3:
                        Sta = stagger[3];
                        break;
                    case 4:
                        Sta = stagger[4];
                        break;
                    case 5:
                        Sta = stagger[5];
                        break;
                    case 6:
                        Sta = stagger[6];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Sta = "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerBu = (Spinner) findViewById(R.id.spinner16);
        ArrayAdapter<String> adapterBu = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, buckle);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerBu.setAdapter(adapterBu);
        spinnerBu.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        Bu = buckle[0];
                        break;
                    case 1:
                        Bu = buckle[1];
                        break;
                    case 2:
                        Bu = buckle[2];
                        break;
                    case 3:
                        Bu = buckle[3];
                        break;
                    case 4:
                        Bu = buckle[4];
                        break;
                    case 5:
                        Bu = buckle[5];
                        break;
                    case 6:
                        Bu = buckle[6];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Bu = "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });


        Spinner spinnerP = (Spinner) findViewById(R.id.spinner17);
        ArrayAdapter<String> adapterP = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, propeller);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerP.setAdapter(adapterP);
        spinnerP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        P = propeller[0];
                        break;
                    case 1:
                        P = propeller[1];
                        break;
                    case 2:
                        P = propeller[2];
                        break;
                    case 3:
                        P = propeller[3];
                        break;
                    case 4:
                        P = propeller[4];
                        break;
                    case 5:
                        P = propeller[5];
                        break;
                    case 6:
                        P = propeller[6];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                P = "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });


        Spinner spinnerO = (Spinner) findViewById(R.id.spinner18);
        ArrayAdapter<String> adapterO = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opening);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerO.setAdapter(adapterO);
        spinnerO.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        Op = opening[0];
                        break;
                    case 1:
                        Op = opening[1];
                        break;
                    case 2:
                        Op = opening[2];
                        break;
                    case 3:
                        Op = opening[3];
                        break;
                    case 4:
                        Op = opening[4];
                        break;
                    case 5:
                        Op = opening[5];
                        break;
                    case 6:
                        Op = opening[6];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Op = "Any";
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
            bProgressDialog = new ProgressDialog(Basepair.this);
            bProgressDialog.setTitle("RNA frabase");
            bProgressDialog.setMessage("Searching...");
            bProgressDialog.setIndeterminate(false);
            bProgressDialog.show();
        }

        @Override
        protected void onPostExecute(Void result) {

            bProgressDialog.dismiss();
        }

    }
}
