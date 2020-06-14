/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

/**
 *
 * @author Isaías Ricardo Valdivia Hernández
 */
public class DetalleVenta {
    private int idVenta;
    private String codigo;
    private int cantidad;
    private double precio;
    private double importe;

    public DetalleVenta(String codigo, int cantidad, double precio, double importe) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.importe = importe;
    }

    public DetalleVenta() {

    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    
}
