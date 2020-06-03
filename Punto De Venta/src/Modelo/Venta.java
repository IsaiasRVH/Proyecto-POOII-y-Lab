/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Modelo;

import java.util.Date;

/**
 *
 * @author Isaías Ricardo Valdivia Hernández
 */
public class Venta {
    private int idVenta;
    private int idUsuario;
    private int idCliente;
    private Date fecha;
    private double total;
    private String tipoVenta;

    public Venta(int idUsuario, int idCliente, Date fecha, double total, String tipoVenta) {
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.total = total;
        this.tipoVenta = tipoVenta;
    }

    public Venta() {
        
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }
    
}
