package com.ruslan.salaCine;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *  Clase que crea la base de datos y gestiona las consultas
 *  Clase que hereda de SQLiteOpenHelper para crear la base de datos
 *  @see SQLiteOpenHelper
 *  @autor Ruslan Tejerina Zapico
 *  @version 2.0
 *
 */
public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "CineApp.db";
    private static final String TABLE_NAME = "usuarios";
    private static final String  COL_EMAIL= "correo";
    private static final String COL_PASS = "password";

    /**
     * Constructor de la clase
     * @param context   Contexto de la aplicación
     */
    public DatabaseHelper(Context context){
        super(context, DB_NAME, null, 1);
    }

    /**
     * Método que crea la tabla de usuarios en la base de datos
     * @param db La base de datos.
     * @return void
     *
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        // Creamos la tabla de usuarios con los campos correo y contraseña
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (" + COL_EMAIL + " TEXT PRIMARY KEY, " + COL_PASS + " TEXT)");
    }

    /**
     * Método que actualiza la base de datos
     * @param db La base de datos que vamos a actualizar
     * @param oldVersion Versión antigua de la base de datos
     * @param newVersion Versión nueva de la base de datos
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Borramos la tabla si existe
        db.execSQL(("DROP TABLE IF EXISTS " + TABLE_NAME));
        // Llamamos al método onCreate para crear la tabla de nuevo,
        // es util para actualizar la base de datos si hay cambios en la estructura de la tabla.
        onCreate(db);

    }
    /**
     * Método que agrega un usuario a la base de datos
     * @param correo    Correo del usuario
     * @param password  Contraseña del usuario
     * @return boolean  True si se ha agregado el usuario, false si no
     */
    public boolean agregarUsuario (String correo, String password) {
        // Obtenemos la base de datos en modo escritura
        SQLiteDatabase db = this.getWritableDatabase();
        // Creamos un objeto datos para agregar los datos del usuario
        ContentValues datos = new ContentValues();
        datos.put(COL_EMAIL, correo);
        datos.put(COL_PASS, password);
        long resultado = db.insert(TABLE_NAME, null, datos);
        // Si es -1, no se insertó el usuario en la base de datos y devolvemos false
        return resultado != -1;
    }

    /**
     * Método que comprueba si el usuario existe en la base de datos
     * @param correo   Correo del usuario
     * @param password Contraseña del usuario
     * @return boolean True si el usuario existe, false si no
     */
    public boolean checkUsuario(String correo, String password) {
        // Obtenemos la base de datos en modo lectura
        SQLiteDatabase db = this.getReadableDatabase();
        // Creamos un cursor para obtener los datos del usuario de la base de datos
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE " + COL_EMAIL + " =? AND " + COL_PASS + " =? ", new String[]{correo, password});
        // Si el cursor tiene más de 0 filas, significa que el usuario existe en la base de datos
        if (cursor.getCount() > 0) {
            return true; // El usuario existe
        } else {
            return false; // El usuario no existe
        }
    }
}
