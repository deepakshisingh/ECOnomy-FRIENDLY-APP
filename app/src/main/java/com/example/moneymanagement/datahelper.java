package com.example.moneymanagement;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class datahelper extends SQLiteOpenHelper{
    public datahelper(Context context){
        super(context,"database.db",null,1);
        //SQLiteDatabase db= this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(sno text primary key, item text)");
        db.execSQL("Create table info(sub1 text,sub2 text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        //db.execSQL("drop table if exists user");
        //db.execSQL("drop table if exists info");

    }

    public boolean insertinfo(String s1, String s2) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalue = new ContentValues();
        contentvalue.put("sno", s1);
        contentvalue.put("item", s2);
        long result = db.insert("user", null, contentvalue);
        if (result == -1)
            return false;
        else  return true;
    }
}
