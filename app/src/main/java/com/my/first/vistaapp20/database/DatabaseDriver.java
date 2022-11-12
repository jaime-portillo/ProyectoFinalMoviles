package com.my.first.vistaapp20.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseDriver extends SQLiteOpenHelper {
    public DatabaseDriver(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //
        // Creacion de la tabla para Asesores
        //
        sqLiteDatabase.execSQL("CREATE TABLE Asesores(AsesorId PRIMARY KEY AUTOINCREMENT," +
                "Nombre TEXT," +
                "FechaNacimiento TEXT," +
                "Edad INTEGER," +
                "Dui TEXT," +
                "Telefono TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
