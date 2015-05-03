package com.smsapi.rehan.todolist;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by MUSHAHID KHAN on 4/18/2015.
 */
public class DbHelper extends SQLiteOpenHelper {

    public static final String TAG = "DBHelper";
    public static final String DB_NAME = "TODOLIST";
    public static final String TABLE = "ACTIVITY";
    public static final int DB_VAR = 1;
    public static final boolean DEBUG = false;
    public DbHelper(Context context) {
        super(context, DB_NAME, null,DB_VAR);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String QUERY = "Create Table " + TABLE + "(ID INTEGER PRIMARY KEY AUTOINCREMENT, LIST TEXT)";
        db.execSQL(QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor query(SQLiteDatabase db, String query) {
        Cursor cur = db.rawQuery(query,null);
        return cur;
    }
}
