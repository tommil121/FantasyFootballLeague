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
    public static final String COLUMN_PLAYER_TEAM_ID = "TEAM_ID";




    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    //the first time this is run, the onCreate gets called;
    @Override
    public void onCreate(SQLiteDatabase db) {
        //create each table separately for error checking purposes

        //create and execute team table sql
        String query = "CREATE TABLE " + TABLE_TEAM + "(" +
                COLUMN_TEAM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TEAM_NAME + " TEXT NOT NULL, " +
                COLUMN_TEAM_LEAGUE + " TEXT NOT NULL, " +
                COLUMN_TEAM_SEASON + " TEXT NOT NULL " +
                ");";

        db.execSQL(query);

        //create and execute nfl_team table sql
        query = "CREATE TABLE " + TABLE_NFL_TEAM + "(" +
                COLUMN_NFL_TEAM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NFL_TEAM_NAME + " TEXT NOT NULL, " +
                COLUMN_NFL_TEAM_STATE + " TEXT NOT NULL " +
                ");";

        db.execSQL(query);

        //create and execute position table sql
        query = "CREATE TABLE " + TABLE_POSITION + "(" +
                COLUMN_POSITION_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_POSITION_NAME + " TEXT NOT NULL " +
                ");";

        db.execSQL(query);

        //create and write player table sql
        query = "CREATE TABLE " + TABLE_PLAYER + "(" +
                COLUMN_PLAYER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PLAYER_NAME + " TEXT NOT NULL, " +
                COLUMN_PLAYER_NFL_TEAM_ID + " INTEGER NOT NULL, " +
                COLUMN_PLAYER_POSITION_ID + " INTEGER NOT NULL, " +
                COLUMN_PLAYER_TEAM_ID + " INTEGER NOT NULL " +
                "FOREIGN KEY(PLAYER_NFL_TEAM_FK) REFERENCES NFL_TEAM(NFL_TEAM_ID)" +
                "FOREIGN KEY(PLAYER_POSITION_FK) REFERENCES POSITION(POSITION_ID)" +
                "FOREIGN KEY(PLAYER_TEAM_FK) REFERENCES TEAM(TEAM_ID)" +
                ");";

        db.execSQL(query);

    }

    //If any database structure is changed, call this method
    //, and it will drop the tables and recreated it with the updated
    //onCreate method
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TEAM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NFL_TEAM);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_POSITION);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYER);
        onCreate(db);
    }

    //TODO Add a row to the team table

    //TODO Add a row to the nfl team table

    //TODO Add a row to the position table

    //TODO add a row to the player table


}
