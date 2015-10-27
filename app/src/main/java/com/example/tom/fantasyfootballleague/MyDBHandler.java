package com.example.tom.fantasyfootballleague;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper{

    //version must be updated every time the file is updated
    private static final int DATABASE_VERSION = 1;  //version must be updated every time the file is updated
    private static final String DATABASE_NAME = "FANTASYFOOTBALLLEAGUE.db"; //Name of the database
    public static final String TABLE_TEAM = "TEAM";
    public static final String TABLE_NFL_TEAM = "NFL_TEAM";
    public static final String TABLE_PLAYER = "PLAYER";
    public static final String TABLE_POSITION = "POSITION";




}
