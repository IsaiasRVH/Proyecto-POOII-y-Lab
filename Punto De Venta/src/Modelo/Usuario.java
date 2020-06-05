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
public class Usuario {
    //Campos de la tabla usuarios
    private int idUsuario;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String email;
    private String calleYNumero;
    private String colonia;
    private String codigoPostal;
    private String ciudad;
    private String estado;
    private String pais;
    private Double salario;
    private String contrasenia;

    
    /**
     * Constructor con 12 parametros
     * @param nombre Nombre(s) del usuario
     * @param apellidos Apellidos del usuario
     * @param telefono Telefono del usuario
     * @param email Correo Electronico del usuario
     * @param calleYNumero Calle y numero donde vive
     * @param colonia Colonia donde vive
     * @param codigoPostal Codigo postal del lugar donde vive
     * @param ciudad Ciudad donde vive
     * @param estado Estado donde vive
     * @param pais Pais donde vive
     * @param salario Salario del usuario
     * @param contrasenia Contraseña del usuario
     */
    public Usuario(String nombre, String apellidos, String telefono, String email, String calleYNumero, String colonia, String codigoPostal, String ciudad, String estado, String pais, Double salario, String contrasenia) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
        this.calleYNumero = calleYNumero;
        this.colonia = colonia;
        this.codigoPostal = codigoPostal;
        this.ciudad = ciudad;
        this.estado = estado;
        this.pais = pais;
        this.salario = salario;
        this.contrasenia = contrasenia;
    }

    public Usuario() {

    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
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

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    
    
    
    
}
