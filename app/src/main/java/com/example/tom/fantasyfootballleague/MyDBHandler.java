package com.example.tom.fantasyfootballleague;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

public class MyDBHandler extends SQLiteOpenHelper{

    //TODO Add a league table with a league name
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

    //Create team table
    public static final String TABLE_LEAGUE = "LEAGUE";
    public static final String COLUMN_LEAGUE_ID = "LEAGUE_ID";
    public static final String COLUMN_LEAGUE_NAME = "LEAGUE_NAME";


    //create player table
    public static final String TABLE_PLAYER = "PLAYER";
    public static final String COLUMN_PLAYER_ID = "PLAYER_ID";
    public static final String COLUMN_PLAYER_NAME = "PLAYER_NAME";
    public static final String COLUMN_PLAYER_NFL_TEAM = "NFL_TEAM";
    public static final String COLUMN_PLAYER_POSITION = "POSITION";
    public static final String COLUMN_PLAYER_TEAM_ID = "TEAM_ID";




    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }


    //the first time this is run, the onCreate gets called;
    @Override
    public void onCreate(SQLiteDatabase db) {
        //create each table separately for error checking purposes
        //create and write league table sql
        String query = "CREATE TABLE " + TABLE_LEAGUE + "(" +
                COLUMN_LEAGUE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_LEAGUE_NAME + " TEXT NOT NULL " +
                ");";

        db.execSQL(query);


        //create and execute team table sql
        query = "CREATE TABLE " + TABLE_TEAM + "(" +
                COLUMN_TEAM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_TEAM_NAME + " TEXT NOT NULL, " +
                COLUMN_LEAGUE_ID + " INT NOT NULL, " +
                COLUMN_TEAM_SEASON + " TEXT NOT NULL " +
                "FOREIGN KEY(TABLE_LEAGUE_FK) REFERENCES LEAGUE(LEAGUE_ID)" +
                ");";

        db.execSQL(query);



        //create and write player table sql
        query = "CREATE TABLE " + TABLE_PLAYER + "(" +
                COLUMN_PLAYER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_PLAYER_NAME + " TEXT NOT NULL, " +
                COLUMN_PLAYER_NFL_TEAM + " TEXT NOT NULL, " +
                COLUMN_PLAYER_POSITION + " TEXT NOT NULL, " +
                COLUMN_PLAYER_TEAM_ID + " INTEGER NOT NULL " +
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
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAYER);
        onCreate(db);
    }

    //Add a row to the team table
    public void addTeam(Team team){
        ContentValues values = new ContentValues();

        //put the values into the values variable. Prepare to insert
        values.put(TABLE_TEAM, team.getName());
        values.put(TABLE_TEAM, team.getLeague());
        values.put(TABLE_TEAM, team.getSeason());

        //connects to the database (so you can write into it)
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_TEAM, null, values);
        db.close();

    }

    //Delete a row from the team table
    public void deleteTeam(String teamName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_TEAM + " WHERE " + COLUMN_TEAM_NAME + "=\"" + teamName + "\";");

    }


    //Add a row to the position table
    public void addPosition(League league){
        ContentValues values = new ContentValues();

        //put the values into the values variable. Prepare to insert
        values.put(TABLE_LEAGUE, league.getName());


        //connects to the database (so you can write into it)
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_LEAGUE, null, values);
        db.close();
    }

    //Delete a row from the position table
    public void deletePosition(String leagueName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_LEAGUE + " WHERE " + COLUMN_LEAGUE_NAME + "=\"" + leagueName + "\";");

    }

    //Add a row to the player table
    public void addPlayer(Player player){
        ContentValues values = new ContentValues();

        //put the values into the values variable. Prepare to insert
        values.put(TABLE_PLAYER, player.getName());
        values.put(TABLE_PLAYER, player.getNflTeamId());
        values.put(TABLE_PLAYER, player.getPositionId());
        values.put(TABLE_PLAYER, player.getTeamId());


        //connects to the database (so you can write into it)
        SQLiteDatabase db = getWritableDatabase();
        db.insert(TABLE_PLAYER, null, values);
        db.close();
    }

    //Delete a row from the player table
    public void deletePlayer(String playerName){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_PLAYER + " WHERE " + COLUMN_PLAYER_NAME + "=\"" + playerName + "\";");

    }

    //Display Team table
    //TODO Change the name of the method to select from

    public String teamToString(){
        String dbString = "";
        SQLiteDatabase db = getWritableDatabase();

        String query = "SELECT * FROM " + TABLE_TEAM;

        //Cursor points to a location in your results
        Cursor c = db.rawQuery(query, null);

        //Move the cursor to the first row in your results
        c.moveToFirst();
        //TODO store all of the results in arrays. One array per column. Do not return String
        //TODO Create a 2d array consisting of the columns and the rows
        //Add makeshift table lables
        dbString = "Name";


        //while the cursor is not after the last item (aka you are not at the end of the list)
        while(!c.isAfterLast()){
            if(c.getString(c.getColumnIndex("TEAM_NAME"))!= null
                    && c.getString(c.getColumnIndex("LEAGUE_ID"))!= null
                    && c.getString(c.getColumnIndex("TEAM_SEASON"))!= null){
                dbString += c.getString(c.getColumnIndex("TEAM_NAME"));
                dbString += "\n";
            }
        }


        return dbString;
    }


    //TODO Display League Table

    //TODO Display Player table

    //TODO Display Entire Database

}
