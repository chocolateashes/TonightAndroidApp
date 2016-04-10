package com.example.chocolateashes.tonightapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;

public class Stars extends Activity implements OnClickListener {
    Button butn1;
    Button butn2;
    Button butn3;
    Button butn4;
    Button butn5;
    Button butn6;
    Button butn7;
    Button butn8;
    EditText scoreText;
    EditText scoreText1;
    EditText scoreText2;
    EditText scoreText3;
    EditText scoreText4;
    EditText scoreText5;
    EditText scoreText6;
    EditText scoreText7;
    int counter =0;
    ImageView star;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barprofile);

        butn1=(Button)findViewById(R.id.touristb);
        butn2=(Button)findViewById(R.id.collegeb);
        butn3=(Button)findViewById(R.id.danceb);
        butn4=(Button)findViewById(R.id.longlineb);
        butn5=(Button)findViewById(R.id.hiphopb);
        butn6=(Button)findViewById(R.id.coverb);
        butn7=(Button)findViewById(R.id.technob);
        butn8=(Button)findViewById(R.id.LGBTb);

        star = (ImageView)findViewById(R.id.imageView);
        butn1.setOnClickListener(this);
        butn2.setOnClickListener(this);
        butn3.setOnClickListener(this);
        butn4.setOnClickListener(this);
        butn5.setOnClickListener(this);
        butn6.setOnClickListener(this);
        butn7.setOnClickListener(this);
        butn8.setOnClickListener(this);


    }
    @Override

    public void onClick(View v)
    {
        if(v==butn1)
        {
            star.setVisibility(View.VISIBLE);

        }
        if(v==butn2)
        {
            star.setVisibility(View.VISIBLE);
        }
        if(v==butn3)
        {
            star.setVisibility(View.VISIBLE);

        }
        if(v==butn4)
        {
            star.setVisibility(View.VISIBLE);


        }
        if(v==butn5)
        {
            star.setVisibility(View.VISIBLE);

        }
        if(v==butn6)
        {
            star.setVisibility(View.VISIBLE);

        }
        if(v==butn7)
        {
            star.setVisibility(View.VISIBLE);


        }
        if(v==butn8)
        {
            star.setVisibility(View.VISIBLE);

        }
    }



}