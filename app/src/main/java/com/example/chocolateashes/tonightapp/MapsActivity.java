
package com.example.chocolateashes.tonightapp;

import android.content.Intent;
import android.graphics.Matrix;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MapsActivity extends AppCompatActivity {

    private FrameLayout frameLayout;
    private List<Bar> barList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sactivity_main);
        mockBarList();
        frameLayout = (FrameLayout) findViewById(R.id.frame_layout);

        final RelativeLayout barView = (RelativeLayout) findViewById(R.id.street_layout);
        final TextView barTextView =  (TextView) findViewById(R.id.bar_title);
        final ImageButton barButton = (ImageButton) findViewById(R.id.see_more);
        if (barView == null){
            System.out.println("BarView is null");
        }

        for (final Bar bar : barList){
            final ImageView imageView = new ImageView(this);
            imageView.setImageResource(R.drawable.tonightpin);
            imageView.setX(bar.getxPos());
            imageView.setY(bar.getyPos());
            imageView.setTag(R.string.bar_name, bar.name());
            imageView.setTag(R.string.bar_rating, bar.rating());
            FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(100, 100);
            frameLayout.addView(imageView, params);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    barTextView.setText((String) v.getTag(R.string.bar_name));
                    if (((int) v.getTag(R.string.bar_rating)) == 1) {
                        barButton.setImageResource(R.drawable.ic_trending_down_white_24dp);
                    } else if (((int) v.getTag(R.string.bar_rating)) == 2) {
                        barButton.setImageResource(R.drawable.ic_trending_flat_white_24dp);
                    } else {
                        barButton.setImageResource(R.drawable.ic_trending_up_white_24dp);
                    }
                    barView.setVisibility(View.VISIBLE);
                    if (imageView.getWidth()<10){
                        barView.setX(v.getX() - 50);
                        barView.setY(v.getY() - 50);
                    }
                    else {
                        barView.setX(v.getX() - imageView.getWidth());
                        barView.setY(v.getY() - barView.getHeight());
                    }
                }
            });

        }


/**
         frameLayout.setOnTouchListener(new View.OnTouchListener() {
        @Override
        public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN){
        barView.setX(event.getX() - (barView.getWidth()/2));
        barView.setY(event.getY()- barView.getHeight());
        }

        return true;
        }
        });
         */

    }

    public void mockBarList(){
        barList = new ArrayList<>();
        Bar mockBar = new Bar(260, 857, "Nellie's Sports Bar", Bar.LIT);
        barList.add(mockBar);
        mockBar = new Bar(340, 365, "Velvet Lounge", Bar.LIT);
        barList.add(mockBar);
        mockBar = new Bar(600, 500, "Twin's Jazz", Bar.DEAD);
        barList.add(mockBar);
        mockBar = new Bar(400, 650, "The Prospect", Bar.LIT);
        barList.add(mockBar);
        mockBar = new Bar(200, 200, "Lost Society", Bar.NEUTRAL);
        barList.add(mockBar);
        mockBar = new Bar(610, 900, "Cloak & Dagger", Bar.NEUTRAL);
        barList.add(mockBar);


    }

    public void menumap(View v){
        if(v.getId()== R.id.homeb)
        {
            Intent i = new Intent(MapsActivity.this, MapsActivity.class);
            startActivity(i);
        }
        if(v.getId()==R.id.topb)
        {
            Intent i = new Intent(MapsActivity.this, MainActivity.class);
            startActivity(i);
        }
        if(v.getId()==R.id.searchb)
        {
            Intent i = new Intent(MapsActivity.this, Search.class);
            startActivity(i);
        }

        if(v.getId()==R.id.profileb)
        {
            Intent i = new Intent(MapsActivity.this, Profile.class);
            startActivity(i);
        }
    }
}

