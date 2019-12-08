package com.example.egynews;

import android.content.Context;
import android.content.SharedPreferences;

public class MoveObjct {
    private static MoveObjct moveObjct;
    private MoveObjct(){

    }

    public static MoveObjct getInstance(){
if (moveObjct==null){
    moveObjct=new MoveObjct();

}
return  moveObjct;
    }


    SharedPreferences sh;
SharedPreferences.Editor editor;

public  MoveObjct Start(Context context){
sh=context.getSharedPreferences("MoveData",0);
    editor=sh.edit();
    editor.apply();

return  moveObjct;


}
 private String photo, type, date,title,content;

public void setDATAtoMove(String photo, String type,String date,String title,String content){
editor.putString("photo",photo);
    editor.putString("type",type);
    editor.putString("date",date);
    editor.putString("title",title);
    editor.putString("content",content);
    editor.apply();


}

    public String getPhoto() {
        return sh.getString("photo","");
    }

    public String getType() {
        return sh.getString("type","");    }

    public String getDate() {
        return sh.getString("date","");
    }

    public String getTitle() {
        return sh.getString("title","");    }

    public String getContent() {
        return sh.getString("content","");
    }
}
