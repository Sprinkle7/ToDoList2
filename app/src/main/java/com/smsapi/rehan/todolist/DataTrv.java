package com.smsapi.rehan.todolist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
/**
 * Created by MUSHAHID KHAN on 4/18/2015.
 */
public class DataTrv {

    private DbHelper dbHelper;
    private SQLiteDatabase database;
    public DataTrv(Context ctx, String value)
    {
        dbHelper = new DbHelper(ctx);
        database = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("LIST",value);
        database.insert("ACTIVITY","",values);
        database.close();
    }
    public DataTrv() {
    }

    public String[] GetList(Context ctx)
    {
        dbHelper = new DbHelper(ctx);
        database = dbHelper.getReadableDatabase();
        Cursor cur = dbHelper.query(database,"SELECT * FROM ACTIVITY");
        cur.moveToFirst();
        String List[] = new String[cur.getCount()];
        int i=0;
        while (cur.moveToNext()){
            List[i]  = cur.getString(cur.getColumnIndex("LIST"));
            i++;
        }
        return List;
    }
}





