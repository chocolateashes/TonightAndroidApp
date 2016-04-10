package com.example.chocolateashes.tonightapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by Ashwini on 4/10/16.
 */
public class Search extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.searching);
    }
    public void menusearch(View v){
        if(v.getId()== R.id.homeb)
        {
            Intent i = new Intent(Search.this, MapsActivity.class);
            startActivity(i);
        }
        if(v.getId()==R.id.topb)
        {
            Intent i = new Intent(Search.this, MainActivity.class);
            startActivity(i);
        }
        if(v.getId()==R.id.searchb)
        {
            Intent i = new Intent(Search.this, Search.class);
            startActivity(i);
        }

        if(v.getId()==R.id.profileb)
        {
            Intent i = new Intent(Search.this, Profile.class);
            startActivity(i);
        }
    }


}
