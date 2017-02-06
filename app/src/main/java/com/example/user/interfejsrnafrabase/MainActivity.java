
package com.example.user.interfejsrnafrabase;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // URL Address
    String url = "http://rnafrabase.cs.put.poznan.pl/";
    ProgressDialog mProgressDialog;
    Intent i;
    String value;


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

        // Capture button click
        choosebutton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                // Execute Title AsyncTask
                new ChooseFile().execute();
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


    // Title AsyncTask
    private class ChooseFile extends AsyncTask<Void, Void, Void> {
        String title;

        @Override
        protected Void doInBackground(Void... params) {
            try {
                // Connect to the web site
                Document document = Jsoup.connect(url).get();
                // Get the html document title
                title = document.title();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Set title into TextView
            TextView txttitle = (TextView) findViewById(R.id.insert);
            txttitle.setText(title);
            mProgressDialog.dismiss();
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
                // Using Elements to get the Meta data
                Element search = document.getElementById("send");
                //           .select("meta[name=description]");
                // Locate the content attribute
                //desc =
                search.attr("content");
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

    }

    // Logo AsyncTask
    private class AdvSearch extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {

            try {
                // Connect to the web site
                Document document = Jsoup.connect(url).get();
                // Using Elements to get the class data
                Elements img = document.select("a[class=brand brand-image] img[src]");

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

//        @Override
//        protected void onPostExecute(Void result) {
        // Set downloaded image into ImageView
//            ImageView logoimg = (ImageView) findViewById(R.id.logo);
//            logoimg.setImageBitmap(bitmap);
//            mProgressDialog.dismiss();
    }
}
