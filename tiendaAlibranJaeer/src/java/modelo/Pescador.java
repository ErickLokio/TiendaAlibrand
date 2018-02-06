/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Walter
 */
public class Pescador {
    private int idPescador;
    private String nombrePescador;
    private int idTalla;
    private int idSucursal;
    private double precioVenta;
    private double precioCosto;
    private String descripcion;
    private int catidad;
    private double margenGanancia;

    public double getMargenGanancia() {
        return margenGanancia;
    }

    public void setMargenGanancia(double margenGanancia) {
        this.margenGanancia = margenGanancia;
    }

    public int getIdPescador() {
        return idPescador;
    }

    public void setIdPescador(int idPescador) {
        this.idPescador = idPescador;
    }

    public String getNombrePescador() {
        return nombrePescador;
    }

    public void setNombrePescador(String nombrePescador) {
        this.nombrePescador = nombrePescador;
    }

    public int getIdTalla() {
        return idTalla;
    }

    public void setIdTalla(int idTalla) {
        this.idTalla = idTalla;
    }

    public int getIdSucursal() {
        return idSucursal;
    }

    public void setIdSucursal(int idSucursal) {
        this.idSucursal = idSucursal;
    }

    public double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public double getPrecioCosto() {
        return precioCosto;
    }

    public void setPrecioCosto(double precioCosto) {
        this.precioCosto = precioCosto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCatidad() {
        return catidad;
    }

    public void setCatidad(int catidad) {
        this.catidad = catidad;
    }    
}
