package com.my.first.vistaapp20.models;

public class PacienteModel {
    private int PacienteId;
    private String Nombre;
    private String FechaNacimiento;
    private int Edad;
    private String Dui;
    private String Telefono;

    public int getPacienteId() {
        return PacienteId;
    }

    public void setPacienteId(int pacienteId) {
        PacienteId = pacienteId;
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
}
