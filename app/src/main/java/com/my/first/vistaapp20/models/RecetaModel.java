package com.my.first.vistaapp20.models;

public class RecetaModel {
    private int RecetaId;
    private String Fecha;
    private boolean Diabetico;
    private boolean Hipertenso;
    private boolean IrritacionOcular;
    private boolean Cefalea;
    private String Comentarios;
    private String EsfOd;
    private String CilOd;
    private String EjeOd;
    private String EsfOi;
    private String CilOi;
    private String EjeOi;
    private String AgudezaVisualSinCorrecion;
    private String AgudezaVisualConCorrecion;
    private int OptometristaId;
    private int PacienteId;

    public int getRecetaId() {
        return RecetaId;
    }

    public void setRecetaId(int recetaId) {
        RecetaId = recetaId;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public boolean isDiabetico() {
        return Diabetico;
    }

    public void setDiabetico(boolean diabetico) {
        Diabetico = diabetico;
    }

    public boolean isHipertenso() {
        return Hipertenso;
    }

    public void setHipertenso(boolean hipertenso) {
        Hipertenso = hipertenso;
    }

    public boolean isIrritacionOcular() {
        return IrritacionOcular;
    }

    public void setIrritacionOcular(boolean irritacionOcular) {
        IrritacionOcular = irritacionOcular;
    }

    public boolean isCefalea() {
        return Cefalea;
    }

    public void setCefalea(boolean cefalea) {
        Cefalea = cefalea;
    }

    public String getComentarios() {
        return Comentarios;
    }

    public void setComentarios(String comentarios) {
        Comentarios = comentarios;
    }

    public String getEsfOd() {
        return EsfOd;
    }

    public void setEsfOd(String esfOd) {
        EsfOd = esfOd;
    }

    public String getCilOd() {
        return CilOd;
    }

    public void setCilOd(String cilOd) {
        CilOd = cilOd;
    }

    public String getEjeOd() {
        return EjeOd;
    }

    public void setEjeOd(String ejeOd) {
        EjeOd = ejeOd;
    }

    public String getEsfOi() {
        return EsfOi;
    }

    public void setEsfOi(String esfOi) {
        EsfOi = esfOi;
    }

    public String getCilOi() {
        return CilOi;
    }

    public void setCilOi(String cilOi) {
        CilOi = cilOi;
    }

    public String getEjeOi() {
        return EjeOi;
    }

    public void setEjeOi(String ejeOi) {
        EjeOi = ejeOi;
    }

    public String getAgudezaVisualSinCorrecion() {
        return AgudezaVisualSinCorrecion;
    }

    public void setAgudezaVisualSinCorrecion(String agudezaVisualSinCorrecion) {
        AgudezaVisualSinCorrecion = agudezaVisualSinCorrecion;
    }

    public String getAgudezaVisualConCorrecion() {
        return AgudezaVisualConCorrecion;
    }

    public void setAgudezaVisualConCorrecion(String agudezaVisualConCorrecion) {
        AgudezaVisualConCorrecion = agudezaVisualConCorrecion;
    }

    public int getOptometristaId() {
        return OptometristaId;
    }

    public void setOptometristaId(int optometristaId) {
        OptometristaId = optometristaId;
    }

    public int getPacienteId() {
        return PacienteId;
    }

    public void setPacienteId(int pacienteId) {
        PacienteId = pacienteId;
    }
}
