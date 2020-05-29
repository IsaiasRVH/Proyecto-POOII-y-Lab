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
public class Cliente {
    //Campos de la tabla Cliente
    private Integer idCliente;
    private String nombre;
    private String apellidos;
    private String calleYNumero;
    private String colonia;
    private String ciudad;
    private String codigoPostal;
    private String estado;
    private String pais;
    private String telefono;
    private String email;
    private String adeudo;

    public Cliente(String nombre, String apellidos, String calleYNumero, String colonia, String ciudad, String codigoPostal, String estado, String pais, String telefono, String email, String adeudo) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.calleYNumero = calleYNumero;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.codigoPostal = codigoPostal;
        this.estado = estado;
        this.pais = pais;
        this.telefono = telefono;
        this.email = email;
        this.adeudo = adeudo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCalleYNumero() {
        return calleYNumero;
    }

    public void setCalleYNumero(String calleYNumero) {
        this.calleYNumero = calleYNumero;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdeudo() {
        return adeudo;
    }

    public void setAdeudo(String adeudo) {
        this.adeudo = adeudo;
    }
    
    
    
}
