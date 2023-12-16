package com.ruslan.salaCine;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "CineApp.db";
    private static final String TABLE_NAME = "usuarios";
    private static final String  COL_EMAIL= "correo";
    private static final String COL_PASS = "password";

    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + COL_EMAIL + " TEXT PRIMARY KEY, " + COL_PASS + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(("DROP TABLE IF EXISTS " + TABLE_NAME));
        onCreate(db);

    }

    public boolean agregarUsuario (String correo, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_EMAIL, correo);
        contentValues.put(COL_PASS, password);
        long resultado = db.insert(TABLE_NAME, null, contentValues);
        return resultado != -1; // Si es -1, no se insertó el usuario en la base de datos
    }

    public boolean checkUsuario(String correo, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COL_EMAIL + " =? AND " + COL_PASS + " =? ", new String[]{correo, password});
        if (cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
