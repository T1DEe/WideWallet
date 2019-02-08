package com.markovsky.widewallet;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

public class SpendingDBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "spends";
    private static final int DB_VERSION = 1;

    SpendingDBHelper (Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE SPENDS("
                + "_id INTEGER PRIMARY KEY AUTOINCREMENT, "
                + "DATE NUMERIC, "
                + "NAME TEXT, "
                + "PRICE INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public static void insertLine(SQLiteDatabase db, Date date, String name, int price)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("DATE", "NULL"); //??
        contentValues.put("NAME", name);
        contentValues.put("PRICE", price);

        db.insert("SPENDS", null, contentValues);
    }
}
