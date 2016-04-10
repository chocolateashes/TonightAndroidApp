package com.example.chocolateashes.tonightapp;/*
package com.example.chocolateashes.tonightapp;

*/
/**
 * Created by James on 4/9/2016.
 */

public class Bar {

    static final int LIT = 3;
    static final int NEUTRAL = 2;
    static final int DEAD = 1;

    private float xPos;
    private float yPos;
    private String name;
    private int rating;

    public Bar(float xPos, float yPos, String name, int rating){
        this.xPos = xPos;
        this.yPos = yPos;
        this.name = name;
        this.rating = rating;
    }

    public float getxPos(){
        return xPos;
    }

    public float getyPos(){
        return yPos;
    }

    public int rating(){
        return rating;
    }

    public String name(){
        return name;
    }
}

