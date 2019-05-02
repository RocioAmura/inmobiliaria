/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inmobiliaria;

/**
 *
 * @author Ro
 */
public class Inmueble {
    private int id;
    private String direccion;
    private int cantAmbientes;
    private boolean disponibilidad;
    private int id_persona;
   
    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }
    
    Inmueble(int id, String direccion, int cantAmbientes, boolean disponibilidad, int id_persona) {
       this.id = id;
       this.direccion = direccion;
       this.cantAmbientes = cantAmbientes;
       this.disponibilidad = disponibilidad;
       this.id_persona = id_persona;       
    }
    
    public Inmueble(int id, String direccion,int cantAmbientes, boolean disponibilidad){
       this.id = id;
       this.direccion = direccion;
       this.cantAmbientes = cantAmbientes;
       this.disponibilidad = disponibilidad;
    }
    
    public Inmueble(String direccion,int cantAmbientes, boolean disponibilidad){
        this.direccion = direccion;
        this.cantAmbientes = cantAmbientes;
        this.disponibilidad = disponibilidad;
    }
    
    public Inmueble(){
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getCantAmbientes() {
        return cantAmbientes;
    }
    
    public void setCantAmbientes(int cantAmbientes) {
        this.cantAmbientes = cantAmbientes;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }     
}
