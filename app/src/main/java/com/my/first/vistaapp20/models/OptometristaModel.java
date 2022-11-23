package com.my.first.vistaapp20.models;

public class OptometristaModel {
    private int OptometristaId;
    private String Nombre;
    private String FechaNacimiento;
    private int Edad;
    private String Jvpm;
    private String Direccion;
    private String Dui;
    private String Telefono;
    private int Foto;

    public int getOptometristaId() {
        return OptometristaId;
    }

    public void setOptometristaId(int optometristaId) {
        OptometristaId = optometristaId;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getFechaNacimiento() {
        return FechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        FechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public String getJvpm() {
        return Jvpm;
    }

    public void setJvpm(String jvpm) {
        Jvpm = jvpm;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String direccion) {
        Direccion = direccion;
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

    public int getFoto() {
        return Foto;
    }

    public void setFoto(int foto) {
        Foto = foto;
    }
}
