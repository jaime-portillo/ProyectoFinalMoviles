package com.my.first.vistaapp20.services;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.my.first.vistaapp20.database.DatabaseDriver;
import com.my.first.vistaapp20.models.AsesorModel;

import java.util.List;

public class AsesoresService {
    private DatabaseDriver databaseDriver;
    private SQLiteDatabase sqLiteDatabase;
    private ContentValues contentValues;

    public AsesoresService() {
        this.databaseDriver = new DatabaseDriver(null, "opticaVistaDb", null, 1);
        this.sqLiteDatabase = databaseDriver.getWritableDatabase();
    }

    //
    // Metodo para crear Asesores
    //
    public int createAsesor(AsesorModel asesorModel) {
        contentValues = new ContentValues();
        contentValues.put("Nombre", asesorModel.getNombre());
        contentValues.put("FechaNacimiento", asesorModel.getFechaNacimiento().toString());
        contentValues.put("Edad", asesorModel.getEdad());
        contentValues.put("Dui", asesorModel.getDui());
        contentValues.put("Telefono", asesorModel.getTelefono());

        return (int) this.sqLiteDatabase.insert("Asesores", null, contentValues);
    }

    //
    // Metodo para modificar Asesores
    //
    public int updateAsesor(AsesorModel asesorModel) {
        return 0;
    }

    //
    // Metodo para eliminar Asesores
    //
    public int deleteAsesor(int asesorId) {
        return 0;
    }

    //
    // Metodo para obtener Asesor por Id
    //
    public AsesorModel asesorById(int asesorId) {
        return new AsesorModel();
    }

    //
    // Metodo para obtener la lista de Asesores
    //
    public List<AsesorModel> asesoresList() {
        return null;
    }
}
