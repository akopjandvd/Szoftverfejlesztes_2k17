package com.example.david.foodadviser;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.R.attr.id;
import static android.R.attr.name;


/**
 * Created by David on 2017. 10. 23..
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME= "FoodAdviser.db";
    public static final String TABLE_NAME= "Foods_table";
    public static final String COL_1= "Name";
    public static final String COL_2= "Recipe";
    public static final String COL_3= "Ingredients";
    public static final String COL_4= "Rating";
    public static final String COL_5= "Favourite";
    public static final String COL_6= "LastMade";
    public static final String COL_7= "Picture";




    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table Foods_table (NAME TEXT PRIMARY KEY, RECIPE TEXT, INGREDIENTS TEXT, RATING REAL, FAVOURITE INTEGER, LASTMADE INTEGER, PICTURE BLOB)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String name,String recipe,String ingredients) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,name);
        contentValues.put(COL_2,recipe);
        contentValues.put(COL_3,ingredients);
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }


    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
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

    public Integer deleteData (String name) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "name = ?",new String[] {String.valueOf(id)});
    }
}
