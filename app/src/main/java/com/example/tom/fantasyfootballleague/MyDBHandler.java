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

    //NEED FOREIGN KEYS relationships!

    //create team table
    public static final String TABLE_TEAM = "TEAM";
    public static final String COLUMN_TEAM_ID = "TEAM_ID";
    public static final String COLUMN_TEAM_NAME = "TEAM_NAME";
    public static final String COLUMN_TEAM_SEASON = "TEAM_SEASON";
    public static final String COLUMN_TEAM_LEAGUE = "TEAM_LEAGUE";


    //create nfl_team table
    public static final String TABLE_NFL_TEAM = "NFL_TEAM";
    public static final String COLUMN_NFL_TEAM_ID = "NFL_TEAM_ID";
    public static final String COLUMN_NFL_TEAM_NAME = "NFL_TEAM_NAME";
    public static final String COLUMN_NFL_TEAM_STATE = "NFL_TEAM_STATE"; //state that the team belongs to

    //create position table
    public static final String TABLE_POSITION = "POSITION";
    public static final String COLUMN_POSITION_ID = "POSITION_ID";
    public static final String COLUMN_POSITION_NAME = "POSITION_NAME";

    //create player table
    public static final String TABLE_PLAYER = "PLAYER";
    public static final String COLUMN_PLAYER_ID = "PLAYER_ID";
    public static final String COLUMN_PLAYER_NAME = "PLAYER_NAME";
    public static final String COLUMN_PLAYER_NFL_TEAM_ID = "NFL_TEAM_ID";
    public static final String COLUMN_PLAYER_POSITION_ID = "POSITION_ID";





    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
