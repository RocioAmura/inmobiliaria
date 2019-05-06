/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inmobiliaria;

import java.time.LocalDate;

/**
 *
 * @author Pedro
 */
public class Alquiler {
   private Persona persona;
   private Inmueble inmueble;
   private int id = -1;
   private String observaciones;
   private LocalDate fechaInicio, fechaFin;
   private long precio;
   
   Alquiler(int id, Persona persona, Inmueble inmueble, LocalDate fechaInicio,LocalDate fechaFin, String observaciones, long precio){
       this.id = id;
       this.inmueble = inmueble;
       this.persona = persona;
       this.observaciones = observaciones;
       this.precio = precio;
       this.fechaInicio = fechaInicio;
       this.fechaFin = fechaFin;
   }
   Alquiler(Persona persona, Inmueble inmueble, String observaciones, long precio, LocalDate fechaInicio,LocalDate fechaFin){
       this.id = -1;
       this.inmueble = inmueble;
       this.persona = persona;
       this.observaciones = observaciones;
       this.precio = precio;
       this.fechaInicio = fechaInicio;
       this.fechaFin = fechaFin;
   }
   Alquiler(){
       this.id = -1;
   }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Inmueble getInmueble() {
        return inmueble;
    }

    public void setInmueble(Inmueble inmueble) {
        this.inmueble = inmueble;
    }
   

    public long getPrecio() {
        return precio;
    }

    public void setPrecio(long precio) {
        this.precio = precio;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }  
}
