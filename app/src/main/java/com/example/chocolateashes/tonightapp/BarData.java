package com.example.chocolateashes.tonightapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;

/**
 * Created by Ashwini on 4/9/16.
 */
public class BarData extends Activity {
    //private variables
    String _name;
    String _closing;
    String _address;

    // Empty constructor
    public BarData(){

    }
    // constructor
    public BarData(String name, String _closing, String _address){
        this._name = name;
        this._closing = _closing;
        this._address = _address;
    }

    // getting name
    public String getName(){
        return this._name;
    }

    // setting name
    public void setName(String name){
        this._name = name;
    }

    // getting closing time
    public String getClosing(){
        return this._closing;
    }

    // setting closing time
    public void setClosing(String closing){
        this._closing = closing;
    }

    // getting address
    public String getAddress(){
        return this._address;
    }

    // setting address
    public void setAddress(String address){
        this._address = address;
    }
}

