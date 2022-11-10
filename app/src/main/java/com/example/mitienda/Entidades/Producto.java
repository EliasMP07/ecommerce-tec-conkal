package com.example.mitienda.Entidades;

public class Producto {

    private String nombre;
    private String descripcion;
    private int imagenId;

    public Producto(){}

    public Producto(final String nombre, final String descripcion, final int imagenId) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.imagenId = imagenId;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(final String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return this.descripcion;
    }

    public void setDescripcion(final String descripcion) {
        this.descripcion = descripcion;
    }

    public int getImagenId() {
        return this.imagenId;
    }

    public void setImagenId(final int imagenId) {
        this.imagenId = imagenId;
    }
}
