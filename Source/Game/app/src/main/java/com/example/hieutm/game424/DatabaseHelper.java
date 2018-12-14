package com.example.hieutm.game424;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME = "playerlist";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "player";
    private static final String ID = "id";
    private static final String NAME = "name" ;
    private static final String SCORE = "score" ;

    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String sqlQuery="CREATE TABLE "+TABLE_NAME+"("+ID+" INTEGER PRIMARY KEY AUTOINCREMENT," +
                NAME+" TEXT NOT NULL," +
                SCORE +" INTERGER);";

        db.execSQL(sqlQuery);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    void SqlQueryNonGetValue(String sql){
        SQLiteDatabase db= getWritableDatabase();
        db.execSQL(sql);
    }

    Cursor SqlQueryGetValue(String sql){
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery(sql,null);
    }
    void addPlayer(Player player){
        SQLiteDatabase db =getWritableDatabase();
        db.execSQL("Insert into "+TABLE_NAME+" ("+ID+","+NAME+","+SCORE+" ) VALUES(null,'"+player.getName()+"',"+player.getScore()+") ");
    }
    void sortPlayer(){
        SQLiteDatabase db= getWritableDatabase();
        db.rawQuery("select * from player order by score",new String[]{});
    }
    Player getFirst(){
        SQLiteDatabase db=getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,"score desc",null);
        if (cursor ==null||!cursor.moveToFirst()) return null;
        cursor.moveToFirst();
        Player player = new Player(cursor.getInt(0),cursor.getString(1),cursor.getInt(2));
        cursor.close();
        return player;
    }
    Cursor loadAllPlayer(){
        SQLiteDatabase db =getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,"score desc",null);
        if (cursor==null||!cursor.moveToFirst()) return null;
        return cursor;
    }
}
