package com.example.admin.game;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "playerlist";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "player";
    private static final String ID = "id";
    private static final String NAME = "name" ;
    private static final String SCORE = "score" ;
    private static final String RANK = "rank";

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sqlQuery="CREATE TABLE " + TABLE_NAME + "("+
                ID+"INTEGER PRIMARY KEY,"+NAME+"TEXT,"+SCORE+"INTEGER,"+RANK+"INTEGER)";

        db.execSQL(sqlQuery);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

}
