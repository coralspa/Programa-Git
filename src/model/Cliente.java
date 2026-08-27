package model;

import java.time.LocalDate;

public class Cliente {

    private int idCliente;
    private int idUsuario;
    private int idPais;
    private String nombre;
    private String apellido;
    private String telefono;
    private String direccion;
    private LocalDate fechaNacimiento;

    public Cliente() {
    }

    public Cliente(int idUsuario, int idPais, String nombre, String apellido,
                   String telefono, String direccion, LocalDate fechaNacimiento) {
        this.idUsuario = idUsuario;
        this.idPais = idPais;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Cliente(int idCliente, int idUsuario, int idPais, String nombre,
                   String apellido, String telefono, String direccion,
                   LocalDate fechaNacimiento) {
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.idPais = idPais;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", idUsuario=" + idUsuario +
                ", idPais=" + idPais +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion='" + direccion + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                '}';
    }
}