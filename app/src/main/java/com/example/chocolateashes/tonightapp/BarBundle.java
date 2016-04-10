/*
package com.example.chocolateashes.tonightapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

*/
/**
 * Created by Ashwini on 4/9/16.
 *//*

public class BarBundle extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DBHandler db = new DBHandler(this);

        Bundle b = new Bundle();

        db.addBarData(new BarData("Jojo", "2am"));
        db.addBarData(new BarData("Saloon", "1am"));
        db.addBarData(new BarData("Brixton", "11pm"));

        Log.d("Reading: ", "Reading all contacts...");
        List<BarData> bars = db.getAllBarData();

        for(BarData bd: bars){
            String log = "Id: " + bd.getTaskId()+" ,Name: "+ bd.getName()+ " ,Closing: "
                    +bd.getClosing();
            Log.d("Name: ", log);
        }

    }
    }
*/
