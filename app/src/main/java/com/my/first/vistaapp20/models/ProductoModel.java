package com.my.first.vistaapp20.models;

public class ProductoModel {
    private int ProductoId;
    private String Descripcio;
    private String Caracteristicas;
    private double Precio;

    public int getProductoId() {
        return ProductoId;
    }

    public void setProductoId(int productoId) {
        ProductoId = productoId;
    }

    public String getDescripcio() {
        return Descripcio;
    }

    public void setDescripcio(String descripcio) {
        Descripcio = descripcio;
    }

    public String getCaracteristicas() {
        return Caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        Caracteristicas = caracteristicas;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double precio) {
        Precio = precio;
    }
}
