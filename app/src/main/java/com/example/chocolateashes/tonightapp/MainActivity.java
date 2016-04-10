package com.example.chocolateashes.tonightapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends Activity {

    String[] barnames;
    int[] images = {R.drawable.tonightmoon};
    ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topp);


        Resources res = getResources();
        barnames = res.getStringArray(R.array.barnames);

        list = (ListView)findViewById(R.id.listView);
        vizAdapter adapter = new vizAdapter(this, barnames, images);
        list.setAdapter(adapter);
        list.setBackgroundColor(Color.BLACK);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, BarProfile.class);
                String x = (String)(list.getItemAtPosition(position));
                intent.putExtra("name", x);
                startActivity(intent);
            }

        });
/*        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BarProfile.class);
                intent.putExtra("name", "Nellie's Sports Bar");
                startActivity(intent);
            }
        });*/


}
    public void listmenu(View v){
        if(v.getId()== R.id.homeb)
        {
            Intent i = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(i);
        }
        if(v.getId()==R.id.topb)
        {
            Intent i = new Intent(MainActivity.this, MainActivity.class);
            startActivity(i);
        }
        if(v.getId()==R.id.searchb)
        {
            Intent i = new Intent(MainActivity.this, Search.class);
            startActivity(i);
        }

        if(v.getId()==R.id.profileb)
        {
            Intent i = new Intent(MainActivity.this, Profile.class);
            startActivity(i);
        }
    }



}
class vizAdapter extends ArrayAdapter<String>
{
    public static Typeface otherTypeface;
    Context context;
    int [] images;
    String [] bararray;

    vizAdapter(Context c, String[] barnames, int imgs[])
    {
        super(c, R.layout.row, R.id.barname, barnames); // calling adapter here
        this.context=c;
        this.images=imgs;
        this.bararray= barnames;
    }

    public View getView(int position, View convertView, ViewGroup parent, Context myContext){ //called for every row

        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.row, parent, false); //row object ref to layout
        //otherTypeface = Typeface.createFromAsset(myContext.getAssets(), "assets/hsi.ttf");

        Typeface myTypeface = Typeface.createFromAsset(myContext.getAssets(), "assets/tcmc.ttf");

        ImageView myImage= (ImageView) row.findViewById(R.id.moon);
        TextView myTitle =(TextView) row.findViewById(R.id.barname);

        myTitle.setTypeface(myTypeface);


        myImage.setImageResource(images[0]);
        myTitle.setText(bararray[position]);

        return row;
    }
}
