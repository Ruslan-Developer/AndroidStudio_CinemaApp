package com.ruslan.salaCine;


import java.io.Serializable;

public class Reserva implements Serializable {
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String pelicula = "";
    private String sala = "";
    private String fecha;
    private String hora;
    private String asientos;

    private String fila;
    private String numeroAsiento;

    public Reserva(){

    }

    public Reserva(String nombre, String apellido, String email, String telefono, String pelicula, String sala, String fecha, String hora, String asientos, String fila, String numeroAsiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.pelicula = pelicula;
        this.sala = sala;
        this.fecha = fecha;
        this.hora = hora;
        this.asientos = asientos;
        this.fila = fila;
        this.numeroAsiento = numeroAsiento;
    }
    /*

    public Reserva() {
        this.nombre = "";
        this.apellido = "";
        this.email = "";
        this.telefono = "";
        this.pelicula = "";
        this.sala = "";
        this.fecha = "";
        this.hora = "";
        this.asientos = "";
    }

     */


    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail(){
        return email;
    }

    public String getTelefono(){
        return telefono;
    }

    public String getTituloPelicula(){
        return pelicula;
    }

    public String getSala(){
        return sala;
    }

    public String getFecha(){
        return fecha;
    }

    public String getHora(){
        return hora;
    }
    public String getFila() {
        return fila;
    }

    public String getNumeroAsiento() {
        return numeroAsiento;
    }

    public String getAsientos(){
        return asientos;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setApellido(String apellido){
        this.apellido = apellido;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }

    public void setPelicula(String pelicula){
        this.pelicula = pelicula;
    }

    public void setSala(String sala){
        this.sala = sala;
    }

    public void setFecha(String fecha){
        this.fecha = fecha;
    }

    public void setHora(String hora){
        this.hora = hora;
    }

    public void setAsientos(String asientos){
        this.asientos = asientos;
    }

    public void setFila(String fila) {
        this.fila = fila;
    }
    public void setNumeroAsiento(String numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }


}
