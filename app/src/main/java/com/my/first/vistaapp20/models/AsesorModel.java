package com.my.first.vistaapp20.models;

public class AsesorModel {
    private int AsesorId;
    private String Nombre;
    private String FechaNacimiento;
    private int Edad;
    private String Dui;
    private String Telefono;
    private int foto;


    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getDui() {
        return Dui;
    }

    public void setDui(String dui) {
        Dui = dui;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public int getAsesorId() {
        return AsesorId;
    }

    public void setAsesorId(int asesorId) {
        AsesorId = asesorId;
    }
}
