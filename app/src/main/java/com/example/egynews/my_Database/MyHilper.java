package com.example.egynews.my_Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.egynews.StaticKyes;

public class MyHilper extends SQLiteOpenHelper {

    public  MyHilper(Context context){

        super(context, StaticKyes.DataBaseName,null,StaticKyes.DatabaseV);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

          String sql="CREATE TABLE IF NOT EXISTS "+StaticKyes.TableName+"("+ StaticKyes._id +"INTEGER PRIMARY KEY AUTOINCREMENT,"
                + StaticKyes._title +"text," +
                ""+StaticKyes._content +"text," +
                ""+StaticKyes._time+"Real," +
                ""+StaticKyes._photoPath+"text"+StaticKyes._type +"INTEGER)";
db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
