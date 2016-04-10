package com.example.chocolateashes.tonightapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by Ashwini on 4/9/16.
 */
public class BarProfile extends Activity {
    public TextView showName, showClosing, showAddress;
    DBHandler db = new DBHandler(this);



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barprofile);





        Intent in = getIntent();
        String name = (String) in.getExtras().get("name");

        BarData bar1 = db.getBarData(name);
        String closing = bar1.getClosing();
        String address = bar1.getAddress();

        //Typeface mytypeface = vizAdapter.otherTypeface;
        //showName.setTypeface(vizAdapter.otherTypeface);

        showName = (TextView) findViewById(R.id.barName);

        showClosing = (TextView) findViewById(R.id.closinghr);
        showAddress = (TextView) findViewById(R.id.address);

        Typeface otherTypeface = Typeface.createFromAsset(getAssets(), "hsi.ttf");
        Typeface face = Typeface.createFromAsset(getAssets(), "tcmc.ttf");
        showName.setTypeface(otherTypeface);
        showClosing.setTypeface(face);
        showAddress.setTypeface(face);

        showName.setText(name);
        showAddress.setText(address);
        showClosing.setText(closing);


    }
    public void barmenu(View v){
        if(v.getId()== R.id.homeb)
        {
            Intent i = new Intent(BarProfile.this, MapsActivity.class);
            startActivity(i);
        }
        if(v.getId()==R.id.topb)
        {
            Intent i = new Intent(BarProfile.this, MainActivity.class);
            startActivity(i);
        }
        if(v.getId()==R.id.searchb)
        {
            Intent i = new Intent(BarProfile.this, Home.class);
            startActivity(i);
        }

        if(v.getId()==R.id.profileb)
        {
            Intent i = new Intent(BarProfile.this, Profile.class);
            startActivity(i);
        }
    }



}

