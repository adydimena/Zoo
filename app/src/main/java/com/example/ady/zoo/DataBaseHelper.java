package com.example.ady.zoo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Ady on 11/14/2017.
 */

public class DataBaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_BASE ="MENU.DB";
    public static final String TABLE_NAME = "MENU_TABLE";
    public static final String COL_1 = "Invertebrates";
    public static final String COL_2 = "Fish";
    public static final String COL_3 = "Amphibians";
    public static final String COL_4 = "Reptiles";
    public static final String COL_5 = "Birds";
    public static final String COL_6 = "Mammals";

    public DataBaseHelper(Context context) {
        super(context, DATABASE_BASE, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME +
                " (Invertebrates TEXT PRIMARY KEY," +
                " Fish TEXT," +
                " Amphibians TEXT," +
                " Reptiles TEXT," +
                " Birds TEXT," +
                " Mammals TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
    public boolean insertData (String Invertebrates, String Fish, String Amphibians,
                               String Reptiles, String Birds, String Mammals ){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1,Invertebrates);
        contentValues.put(COL_2,Fish);
       contentValues.put(COL_3,Amphibians);
       contentValues.put(COL_4,Reptiles);
       contentValues.put(COL_5,Birds);
       contentValues.put(COL_6,Mammals);
        long row  = database.insert(TABLE_NAME,null,contentValues);

        if (row == -1)
            return false;
        else
            return true;
    }
    public Cursor getallgata(String ColunmName)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor results = database.rawQuery("SELECT " +ColunmName+  " FROM "+ TABLE_NAME,null);
        return  results;
    }
}
