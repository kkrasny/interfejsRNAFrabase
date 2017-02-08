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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DinuclStep extends AppCompatActivity {

    Intent i;
    String value;
    String Rd1, Rd2, Rd3, Rd4, ExD, Shi, Sli, Ris, Ti, Ro, Tw;
    String[] res_dinucl = {"Any","A", "C", "G", "U", "a", "c", "g", "u"};   // dla wszystkich 4 spinnerów te same wartości
    String[] exp_din = {"Any","X-Ray", "NMR", "Electron Microscopy", "Other"};
    String[] shift = {"Any", "<-10A, -0,73A>","<-0,73A, 10,29A>", "<-0,29A, 0A>", "<0A, 0,3A>", "<0,3A, 0,73A>", "<0,73A, 10A>"};
    String[] slide = {"Any", "<-10A, -2,09A>","<-2,09A, -1,74A>", "<-1,74A, -1,43A>", "<-1,43A, -1,07A>", "<-1,07A, -0,42A>", "<-0,42A, 10A>"};
    String[] rise = {"Any", "<-10A, 3A>","<3A, 3,16A>", "<3,16A, 3,28A>", "<3,28A, 3,41A>", "<3,41A, 3,65A>", "<3,65A, 10A>"};
    String[] tilt = {"Any", "<-180°, -4.41°>","<-4,41°, -1,74°>", "<-1,74°, 0°>", "<0°, 1,74°>", "<1,74°, 4,54°>", "<4,54°, 180°>"};
    String[] roll = {"Any", "<-180°, -0,46°>","<-0,46°, 3,34°>", "<3,34°, 6,31°>", "<6,31°, 9,32°>", "<9,32°, 13,6°>", "<13,6°, 180°>"};
    String[] twist = {"Any", "<-180°, 26,83°>","<26,83°, 30,5°>", "<30,5°, 33,07°>", "<33,07°, 36,25°>", "<36,25°, 42,68°>", "<42,68°, 180°>"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinucl_step);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Spinner spinnerRd1 = (Spinner) findViewById(R.id.spinner33);
        ArrayAdapter<String> adapterRd1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, res_dinucl);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerRd1.setAdapter(adapterRd1);
        spinnerRd1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        Rd1 = res_dinucl[0];
                        break;
                    case 1:
                        Rd1= res_dinucl[1];
                        break;
                    case 2:
                        Rd1 = res_dinucl[2];
                        break;
                    case 3:
                        Rd1 = res_dinucl[3];
                        break;
                    case 4:
                        Rd1 = res_dinucl[4];
                        break;
                    case 5:
                        Rd1 = res_dinucl[5];
                        break;
                    case 6:
                        Rd1 = res_dinucl[6];
                        break;
                    case 7:
                        Rd1 = res_dinucl[7];
                        break;
                    case 8:
                        Rd1 = res_dinucl[8];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Rd1 = "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerRd2 = (Spinner) findViewById(R.id.spinner36);
        ArrayAdapter<String> adapterRd2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, res_dinucl);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerRd2.setAdapter(adapterRd2);
        spinnerRd2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        Rd1 = res_dinucl[0];
                        break;
                    case 1:
                        Rd2= res_dinucl[1];
                        break;
                    case 2:
                        Rd2 = res_dinucl[2];
                        break;
                    case 3:
                        Rd2 = res_dinucl[3];
                        break;
                    case 4:
                        Rd2 = res_dinucl[4];
                        break;
                    case 5:
                        Rd2 = res_dinucl[5];
                        break;
                    case 6:
                        Rd2 = res_dinucl[6];
                        break;
                    case 7:
                        Rd2 = res_dinucl[7];
                        break;
                    case 8:
                        Rd2 = res_dinucl[8];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Rd2 = "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerRd3 = (Spinner) findViewById(R.id.spinner35);
        ArrayAdapter<String> adapterRd3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, res_dinucl);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerRd3.setAdapter(adapterRd3);
        spinnerRd3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        Rd3 = res_dinucl[0];
                        break;
                    case 1:
                        Rd3= res_dinucl[1];
                        break;
                    case 2:
                        Rd3 = res_dinucl[2];
                        break;
                    case 3:
                        Rd3 = res_dinucl[3];
                        break;
                    case 4:
                        Rd3 = res_dinucl[4];
                        break;
                    case 5:
                        Rd3 = res_dinucl[5];
                        break;
                    case 6:
                        Rd3 = res_dinucl[6];
                        break;
                    case 7:
                        Rd3 = res_dinucl[7];
                        break;
                    case 8:
                        Rd3 = res_dinucl[8];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Rd3 = "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerRd4 = (Spinner) findViewById(R.id.spinner34);
        ArrayAdapter<String> adapterRd4 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, res_dinucl);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerRd4.setAdapter(adapterRd4);
        spinnerRd4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        Rd4 = res_dinucl[0];
                        break;
                    case 1:
                        Rd4= res_dinucl[1];
                        break;
                    case 2:
                        Rd4 = res_dinucl[2];
                        break;
                    case 3:
                        Rd4 = res_dinucl[3];
                        break;
                    case 4:
                        Rd4 = res_dinucl[4];
                        break;
                    case 5:
                        Rd4 = res_dinucl[5];
                        break;
                    case 6:
                        Rd4 = res_dinucl[6];
                        break;
                    case 7:
                        Rd4 = res_dinucl[7];
                        break;
                    case 8:
                        Rd4 = res_dinucl[8];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Rd4 = "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });


        Spinner spinnerE = (Spinner) findViewById(R.id.spinner26);
        ArrayAdapter<String> adapterE = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, exp_din);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerE.setAdapter(adapterE);
        spinnerE.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        ExD = exp_din[0];
                        break;
                    case 1:
                        ExD = exp_din[1];
                        break;
                    case 2:
                        ExD = exp_din[2];
                        break;
                    case 3:
                        ExD = exp_din[3];
                        break;
                    case 4:
                        ExD = exp_din[4];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                ExD = "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerShi = (Spinner) findViewById(R.id.spinner28);
        ArrayAdapter<String> adapterShi = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, shift);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerShi.setAdapter(adapterShi);
        spinnerShi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        Shi = shift[0];
                        break;
                    case 1:
                        Shi = shift[1];
                        break;
                    case 2:
                        Shi = shift[2];
                        break;
                    case 3:
                        Shi = shift[3];
                        break;
                    case 4:
                        Shi = shift[4];
                        break;
                    case 5:
                        Shi = shift[5];
                        break;
                    case 6:
                        Shi = shift[6];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Shi = "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerSli = (Spinner) findViewById(R.id.spinner27);
        ArrayAdapter<String> adapterSli = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, slide);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerSli.setAdapter(adapterSli);
        spinnerSli.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        Sli = slide[0];
                        break;
                    case 1:
                        Sli = slide[1];
                        break;
                    case 2:
                        Sli = slide[2];
                        break;
                    case 3:
                        Sli = slide[3];
                        break;
                    case 4:
                        Sli = slide[4];
                        break;
                    case 5:
                        Sli = slide[5];
                        break;
                    case 6:
                        Sli = slide[6];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Sli = "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerRis = (Spinner) findViewById(R.id.spinner29);
        ArrayAdapter<String> adapterRis = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, rise);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerRis.setAdapter(adapterRis);
        spinnerRis.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        Ris = rise[0];
                        break;
                    case 1:
                        Ris = rise[1];
                        break;
                    case 2:
                        Ris = rise[2];
                        break;
                    case 3:
                        Ris = rise[3];
                        break;
                    case 4:
                        Ris = rise[4];
                        break;
                    case 5:
                        Ris = rise[5];
                        break;
                    case 6:
                        Ris = rise[6];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Ris = "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerTi = (Spinner) findViewById(R.id.spinner30);
        ArrayAdapter<String> adapterTi = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tilt);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerTi.setAdapter(adapterTi);
        spinnerTi.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        Ti = tilt[0];
                        break;
                    case 1:
                        Ti = tilt[1];
                        break;
                    case 2:
                        Ti = tilt[2];
                        break;
                    case 3:
                        Ti = tilt[3];
                        break;
                    case 4:
                        Ti = tilt[4];
                        break;
                    case 5:
                        Ti = tilt[5];
                        break;
                    case 6:
                        Ti = tilt[6];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Ti = "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });


        Spinner spinnerRo = (Spinner) findViewById(R.id.spinner32);
        ArrayAdapter<String> adapterRo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, roll);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerRo.setAdapter(adapterRo);
        spinnerRo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        Ro = roll[0];
                        break;
                    case 1:
                        Ro = roll[1];
                        break;
                    case 2:
                        Ro = roll[2];
                        break;
                    case 3:
                        Ro = roll[3];
                        break;
                    case 4:
                        Ro = roll[4];
                        break;
                    case 5:
                        Ro = roll[5];
                        break;
                    case 6:
                        Ro = roll[6];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Ro = "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
            }
        });

        Spinner spinnerTw = (Spinner) findViewById(R.id.spinner31);
        ArrayAdapter<String> adapterTw = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, roll);
        //final Spinner spinnerE = (Spinner)findViewById(R.id.spinner2);
        spinnerTw.setAdapter(adapterTw);
        spinnerTw.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int id, long position) {
                // ta metoda wykonuje się za każdym razem, gdy zostanie wybrany jakiś element z naszej listy
                switch ((int) position) {        //tutaj musimy przerzutować wartośc position na int, bo jest ona typu long, a typu long nie można używać do instrukcji switch

                    case 0:
                        Tw = twist[0];
                        break;
                    case 1:
                        Tw = twist[1];
                        break;
                    case 2:
                        Tw = twist[2];
                        break;
                    case 3:
                        Tw = twist[3];
                        break;
                    case 4:
                        Tw = twist[4];
                        break;
                    case 5:
                        Tw = twist[5];
                        break;
                    case 6:
                        Tw = twist[6];
                        break;

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
                Tw = "Any";
                // ta metoda wykonuje sie gdy lista zostanie wybrana, ale nie zostanie wybrany żaden element z listy
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
