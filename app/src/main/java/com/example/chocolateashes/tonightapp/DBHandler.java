package com.example.chocolateashes.tonightapp;

/**
 * Created by Ashwini on 4/9/16.
 */
import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 2;

    // Database Name
    private static final String DATABASE_NAME = "tonightBars";

    // Contacts table name
    private static final String TABLE = "bars";

    // Contacts Table Columns names
    private static final String KEY_NAME = "name";
    private static final String KEY_CLOSING = "closing";
    private static final String KEY_ADDRESS = "address";


    //SQLiteDatabase db;

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_BAR_PROFILE = "CREATE TABLE " + TABLE + "("
                + KEY_NAME + " TEXT,"
                + KEY_CLOSING + " TEXT,"
                + KEY_ADDRESS + " TEXT" + ")";
        db.execSQL(CREATE_BAR_PROFILE);

    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE);

        // Create tables again
        onCreate(db);
    }
    public void addBarData(BarData bar) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put(KEY_NAME, bar.getName()); // Bar Name
        values.put(KEY_CLOSING, bar.getClosing()); // Bar Closing
        values.put(KEY_ADDRESS, bar.getAddress()); // Bar Address


        // Inserting Row
        db.insert(TABLE, null, values);
        db.close(); // Closing database connection
    }

    public BarData getBarData(String name) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE, new String[]{
                        KEY_NAME, KEY_CLOSING, KEY_ADDRESS}, KEY_NAME + "=?",
                new String[]{String.valueOf(name)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        BarData bar = new BarData(cursor.getString(0), cursor.getString(1), cursor.getString(2));
      return bar;
    }

    public List<BarData> getAllBarData() {
        List<BarData> contactList = new ArrayList<BarData>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                BarData contact = new BarData();
                contact.setName(cursor.getString(0));
                contact.setClosing(cursor.getString(1));
                contact.setAddress(cursor.getString(2));
                // Adding contact to list
                contactList.add(contact);
            } while (cursor.moveToNext());
        }

        return contactList;
    }

    public int updateBarData(BarData bar) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, bar.getName());
        values.put(KEY_CLOSING, bar.getClosing());
        values.put(KEY_ADDRESS, bar.getAddress());


        // updating row
        return db.update(TABLE, values, KEY_NAME + " = ?",
                new String[] { String.valueOf(bar.getName()) });
    }

    public void deleteBarData(BarData bar) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE, KEY_NAME + " = ?",
                new String[]{String.valueOf(bar.getName())});
        db.close();
    }


    public int getBarDataCount() {
        String countQuery = "SELECT  * FROM " + TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        // return count
        return cursor.getCount();
    }



}