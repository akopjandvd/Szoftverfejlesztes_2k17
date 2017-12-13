package com.jelenleti.foodadviser;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by David on 2017. 10. 23..
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME= "FoodAdviser.db";
    public static final String TABLE_NAME= "Foods_table";
    public static final String COL_1= "Name";
    public static final String COL_2= "Recipe";
    public static final String COL_3= "Ingredients";
    public static List list = new ArrayList();






    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);

    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Foods_table (NAME TEXT PRIMARY KEY, RECIPE TEXT, INGREDIENTS TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Foods_table");
        onCreate(db);
    }

    public boolean insertData(String name,String recipe,String ingredients) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,recipe);
        contentValues.put(COL_3,ingredients);

        Cursor cursor = db.rawQuery("select * from Foods_table ",null);
        if (cursor.moveToFirst()){
            while (!cursor.isAfterLast()){
                String nev=cursor.getString(cursor.getColumnIndex("NAME"));
                list.add(nev);
                cursor.moveToNext();
            }
        }


        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    public boolean updateData(String id,String name,String recipe,String ingredients) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,recipe);
        contentValues.put(COL_3,ingredients);
        db.update(TABLE_NAME, contentValues, "NAME = ?",new String[] { name });
        return true;
    }



    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }
}
