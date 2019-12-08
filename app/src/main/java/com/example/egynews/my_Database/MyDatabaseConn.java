package com.example.egynews.my_Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.egynews.StaticKyes;

import java.util.ArrayList;
import java.util.List;


public class MyDatabaseConn {
    private static   MyDatabaseConn  obj  ;

   public   static synchronized MyDatabaseConn getInstance() {

        if (obj==null){

            obj=new MyDatabaseConn();

        }
        return obj;
    }

    private MyDatabaseConn() {
    }


     SQLiteDatabase dp;

    public MyDatabaseConn connect(Context context){
MyHilper hilper=new MyHilper(context);
dp=hilper.getReadableDatabase();

       return obj;

    }

    public boolean insertToDatabase(OffLineOneNew news){

        ContentValues values= new ContentValues();
        values.put(StaticKyes._title,news.getTitle());
        values.put(StaticKyes._content,news.getContent());
        values.put(StaticKyes._time,news.getTime());
        values.put(StaticKyes._photoPath,news.getPhotoPath());
        values.put(StaticKyes._type,news.getType());


        return   dp.insert(StaticKyes.TableName,null,values)>-1;

    }

   public List<OffLineOneNew> getAllOffLineNews(){


       List<OffLineOneNew>  ret=new ArrayList<>();

String SQL="SeLeCT * From  "+ StaticKyes.TableName;
Cursor cursor= dp.rawQuery(SQL,null);
cursor.moveToFirst();

if (!cursor.isAfterLast()){

    OffLineOneNew data= new OffLineOneNew();
    data.setId(cursor.getInt(cursor.getColumnIndex(StaticKyes._id)));

    data.setTime(cursor.getInt(cursor.getColumnIndex(StaticKyes._time)));

    data.setType(cursor.getString(cursor.getColumnIndex(StaticKyes._type)));
    data.setContent(cursor.getString(cursor.getColumnIndex(StaticKyes._content)));
    data.setTitle(cursor.getString(cursor.getColumnIndex(StaticKyes._title)));
    data.setPhotoPath(cursor.getString(cursor.getColumnIndex(StaticKyes._photoPath)));

    ret.add(data);


}


cursor.close();
       return  ret;


   }


}
