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
public class Producto {
    private String codigo;
    private String modelo;
    private String marca;
    private String color;
    private String estilo;
    private double existencias;
    private double precio;
    private int idProveedor;

    public Producto(String codigo, String modelo, String marca, String color, String estilo, double existencias, double precio, int idProveedor) {
        this.codigo = codigo;
        this.modelo = modelo;
        this.marca = marca;
        this.color = color;
        this.estilo = estilo;
        this.existencias = existencias;
        this.precio = precio;
        this.idProveedor = idProveedor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public double getExistencias() {
        return existencias;
    }

    public void setExistencias(double existencias) {
        this.existencias = existencias;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    
    
}
