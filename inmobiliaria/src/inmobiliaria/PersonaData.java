/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inmobiliaria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import inmobiliaria.Conexion;
/**
 *
 * @author Ro
 */
public class PersonaData {
    private Connection connection = null;
    
      
    public PersonaData(Conexion conexion) {
        try{
            connection = conexion.getConexion();
        } catch (SQLException e){
            System.out.println("Error al obtener la conexión");
        }
    }
    public PersonaData(){}
    
    public void guardarPersona (Persona persona){
        try{
            
            String sql = "INSERT INTO persona (nombreCompleto,documento,celular) VALUES (?,?,?)";
            
            
            PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, persona.getNombreCompleto());
            pstmt.setInt(2, persona.getDocumento());
            pstmt.setString(3, persona.getCelular());
            
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();
            
            if (rs.next()){
                persona.setId(rs.getInt(1));
            } else{
                System.out.println("No se pudo obtener el id luego de insertar una persona");
            }
            pstmt.close();
            } 
        catch(SQLException ex){
            System.out.println("Error al insertar una persona: " + ex.getMessage());
        }
    }
    
    public void eliminarPersona(Persona persona){
        try{
            String sql = "DELETE FROM persona WHERE (id) = ?)";
            
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, persona.getId());
            
            pstmt.executeUpdate();
            
            pstmt.close();
        }
        catch (SQLException ex){
            System.out.println("Error al eliminar una persona: " + ex.getMessage());
        }
        
    }
    
    
    public Persona obtenerPersonaPorId (int id_persona){
        
        Persona p;
                
        try{
            
            String sql = "SELECT * FROM `persona` WHERE id = ?";
            
            
            PreparedStatement stmt = Conexion.getConexionS().prepareStatement(sql);
            stmt.setInt(1,id_persona);
            
            ResultSet rs = stmt.executeQuery();
            rs.next();
            
            p = new Persona(rs.getInt("id"),rs.getString("nombreCompleto"),rs.getInt("documento"),rs.getString("celular"));
            
            stmt.close();
            return p;
            } 
        catch(SQLException ex){
            System.out.println("Error al obtener una persona: " + ex.getMessage());
            return null;
        }
    }
      
    public Persona obtenerPersonas (String nombreCompleto){
        
        Persona p;
                
        try{
            
           
            
            
            PreparedStatement stmt = Conexion.getConexionS().prepareStatement("SELECT * FROM `persona` WHERE nombreCompleto = ?");
            stmt.setString(1,nombreCompleto);
            
            ResultSet rs = stmt.executeQuery();
            rs.next();
            
            p = new Persona(rs.getInt("id"),rs.getString("nombreCompleto"),rs.getInt("documento"),rs.getString("celular"));
            
            stmt.close();
            return p;
            } 
        catch(SQLException ex){
            System.out.println("Error al obtener una persona: " + ex.getMessage());
            return null;
        }
    }
    
    
    public List<Persona> obtenerPersonas(){
        List<Persona> personas = new ArrayList<Persona>(); 
        
        try {
            String sql = "SELECT * FROM persona;";
            PreparedStatement statement = Conexion.getConexionS().prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            Persona persona;
            while(resultSet.next()){
                persona = new Persona();
                persona.setId(resultSet.getInt("id"));
                persona.setNombreCompleto(resultSet.getString("nombreCompleto"));
                persona.setDocumento(resultSet.getInt("documento"));
                persona.setCelular(resultSet.getString("celular"));

                personas.add(persona);
            }      
            statement.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener las personas: " + ex.getMessage());
        }       
        return personas;
    }
}
