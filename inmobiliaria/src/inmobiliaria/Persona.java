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
public class Persona {
    private int id = -1;
    private String nombreCompleto;
    private int documento;
    private String celular;
            
    public Persona(int id, String nombreCompleto,int documento, String celular){
       this.id = id;
       this.nombreCompleto = nombreCompleto;
       this.documento = documento;
       this.celular = celular;
    }       
    
    public Persona(String nombreCompleto,int documento, String celular){
        this.nombreCompleto = nombreCompleto;
        this.documento = documento;
        this.celular = celular;
    }
    
    public Persona(){
        this.id = -1;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }
    
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getDocumento() {
        return documento;
    }
    
    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
