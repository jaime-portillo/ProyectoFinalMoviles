package com.my.first.vistaapp20.models;

public class CitaModel {
    private int CitaId;
    private String Nombre;
    private String Fecha;
    private String Hora;

    public int getCitaId() {
        return CitaId;
    }

    public void setCitaId(int citaId) {
        CitaId = citaId;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getHora() {
        return Hora;
    }

    public void setHora(String hora) {
        Hora = hora;
    }
}
