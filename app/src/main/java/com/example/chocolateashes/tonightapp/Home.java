package com.example.chocolateashes.tonightapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

/**
 * Created by Ashwini on 4/9/16.
 */
public class Home extends Activity {

    DBHandler db = new DBHandler(this);


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        populateDB();

    }
    public void buttonlogin(View v){
        if(v.getId()== R.id.login)
        {
            Intent i = new Intent(Home.this, MapsActivity.class);
            startActivity(i);
        }
    }
    /*
        Button button = (Button) findViewById(R.id.login);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.topp);

            }
        });

    } */

    public void populateDB(){
        db.addBarData(new BarData("Nellie's Sports Bar", "3am", "900 U St"));
        db.addBarData(new BarData("Velvet Lounge", "3am", "915 U St"));
        db.addBarData(new BarData("Dodge City", "3am", "917 U St"));
        db.addBarData(new BarData("Lounge of Three", "3am", "1013 U St"));
        db.addBarData(new BarData("Twins Jazz", "1am", "1344 U St"));
        db.addBarData(new BarData("Cloak and Dagger", "3am", "1359 U St"));
        db.addBarData(new BarData("Tropicalia", "3am", "2001 14th St"));
        db.addBarData(new BarData("Pure Lounge", "3am", "1326 U St"));
        db.addBarData(new BarData("The Prospect", "3am", "1214 U St"));
        db.addBarData(new BarData("Lost Society", "3am", "2002 9th St"));


    }
}
