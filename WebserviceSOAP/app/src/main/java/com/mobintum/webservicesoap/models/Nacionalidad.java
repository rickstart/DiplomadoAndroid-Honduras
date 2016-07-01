package com.mobintum.webservicesoap.models;

/**
 * Created by Rick on 30/06/16.
 * email: ricardo.centeno@mobintum.com
 */
public class Nacionalidad {
    private String codigo;
    private String nombre;

    public Nacionalidad() {
    }

    public Nacionalidad(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
