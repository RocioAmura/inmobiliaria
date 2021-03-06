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
public class InmuebleData {
    private Connection connection = null;
    private Conexion conexion;
    
    
    public InmuebleData(Conexion conexion) {
        try{
            connection = conexion.getConexion();
            this.conexion = conexion;
        } catch (SQLException e){
            System.out.println("Error al obtener la conexión");
        }
    }
    
    public InmuebleData(){}
    
    
    public void guardarInmueble (Inmueble inmueble){
        try{
            
            String sql = "INSERT INTO inmueble (direccion,cantAmbientes,disponibilidad,id_persona) VALUES (?,?,?,?)";
            
            
            PreparedStatement pstmt = Conexion.getConexionS().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            pstmt.setString(1,inmueble.getDireccion());
            pstmt.setInt(2,inmueble.getCantAmbientes());
            pstmt.setBoolean(3, inmueble.isDisponibilidad());
            pstmt.setInt(4,inmueble.getpersona().getId());
                      
            pstmt.executeUpdate();
            
            ResultSet rs = pstmt.getGeneratedKeys();
            
            if (rs.next()){
                inmueble.setId(rs.getInt(1));
            } else{
                System.out.println("No se pudo obtener el id luego de insertar un inmueble");
            }
            pstmt.close();
            } 
        catch(SQLException ex){
            System.out.println("Error al insertar un inmueble: " + ex.getMessage());
        }
    }
    
    public void eliminarInmueble (Inmueble inmueble){
        try{
            
            String sql = "DELETE FROM inmueble WHERE (id) VALUES = ?)";
            
            
            PreparedStatement pstmt = Conexion.getConexionS().prepareStatement(sql);
            pstmt.setInt(1, inmueble.getId());
            
            pstmt.executeUpdate();
           
            pstmt.close();
            } 
        catch(SQLException ex){
            System.out.println("Error al eliminar un inmueble: " + ex.getMessage());
        }
    }
    
    
        public void eliminarInmueble (String direccion){
        try{
            
            String sql = "DELETE FROM `inmueble` WHERE `direccion`=?";
            
            
            PreparedStatement pstmt = Conexion.getConexionS().prepareStatement(sql);
            pstmt.setString(1, direccion);
            
            pstmt.executeUpdate();
           
            pstmt.close();
            } 
        catch(SQLException ex){
            System.out.println("Error al eliminar un inmueble: " + ex.getMessage());
        }
    }
    
    
    public Inmueble obtenerInmueblePorId (int id_inmueble){
       
        Inmueble i;
        try{
            
            String sql = "SELECT * FROM `inmueble` WHERE id=?";
            
            
            PreparedStatement pstmt = Conexion.getConexionS().prepareStatement(sql);
            pstmt.setInt(1,id_inmueble);
            
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            PersonaData pd = new PersonaData();
            Persona ps = pd.obtenerPersonaPorId(rs.getInt("id_persona"));
            
            i = new Inmueble(rs.getInt("id"),rs.getString("direccion"),rs.getInt("cantAmbientes"),rs.getBoolean("disponibilidad"),ps);
            
            pstmt.close();
            return i;
            } 
        catch(SQLException ex){
            System.out.println("Error al obtener un inmueble: " + ex.getMessage());
            return null;
        }
    }
    
    
    public List<Inmueble> obtenerInmuebles (String direccion){
        
       // Inmueble i;
                
        //try{
            
          //  String sql = "SELECT * FROM `inmueble` WHERE direccion = ?";
            
            
            //PreparedStatement pstmt = connection.prepareStatement(sql);
            //pstmt.setString(1,direccion);
            
            //ResultSet rs = pstmt.executeQuery();
            //rs.next();
            //PersonaData pd = new PersonaData(conexion);
            //Persona ps = pd.obtenerPersonaPorId(rs.getInt("id_persona"));
            
            //i = new Inmueble(rs.getInt("id"),rs.getString("direccion"),rs.getInt("cantAmbientes"),rs.getBoolean("disponibilidad"), ps);
            
            //pstmt.close();
            //return i;
            //} 
        //catch(SQLException ex){
            //System.out.println("Error al obtener un inmueble: " + ex.getMessage());
            //return null;
        //}
        
        
        
                List<Inmueble> inmuebles = new ArrayList<Inmueble>(); 
        
        try {
            String sql = "SELECT * FROM inmueble WHERE direccion = ?;";
            PreparedStatement pstmt = Conexion.getConexionS().prepareStatement(sql);
            pstmt.setString(1, direccion);

            
            ResultSet resultSet = pstmt.executeQuery();
            Inmueble inmueble;
            PersonaData pd = new PersonaData();
            
            
            while(resultSet.next()){
                Persona pers = pd.obtenerPersonaPorId(resultSet.getInt("id_persona"));
                inmueble = new Inmueble();
                inmueble.setId(resultSet.getInt("id"));
                inmueble.setDireccion(resultSet.getString("direccion"));
                inmueble.setCantAmbientes(resultSet.getInt("cantAmbientes"));
                inmueble.setDisponibilidad(resultSet.getBoolean("disponibilidad"));
                inmueble.setpersona(pers);
                

                inmuebles.add(inmueble);
            }      
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los inmuebles: " + ex.getMessage());
        }
        
        
        return inmuebles;
    }
    
    
    
    
    
    
    
    public List<Inmueble> obtenerInmuebles(){
        List<Inmueble> inmuebles = new ArrayList<Inmueble>(); 
        
        try {
            String sql = "SELECT * FROM inmueble;";
            PreparedStatement pstmt = Conexion.getConexionS().prepareStatement(sql);

            
            ResultSet resultSet = pstmt.executeQuery();
            Inmueble inmueble;
            PersonaData pd = new PersonaData();
            
            
            while(resultSet.next()){
                Persona pers = pd.obtenerPersonaPorId(resultSet.getInt("id_persona"));
                inmueble = new Inmueble();
                inmueble.setId(resultSet.getInt("id"));
                inmueble.setDireccion(resultSet.getString("direccion"));
                inmueble.setCantAmbientes(resultSet.getInt("cantAmbientes"));
                inmueble.setDisponibilidad(resultSet.getBoolean("disponibilidad"));
                inmueble.setpersona(pers);
                

                inmuebles.add(inmueble);
            }      
            pstmt.close();
        } catch (SQLException ex) {
            System.out.println("Error al obtener los inmuebles: " + ex.getMessage());
        }
        
        
        return inmuebles;
    }
}
