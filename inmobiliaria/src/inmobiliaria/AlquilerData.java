/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inmobiliaria;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pedro
 */
public class AlquilerData {
   private Connection connection = null;
   private Conexion con;
 
   AlquilerData(Conexion con){
       try{
           connection = con.getConexion();
           this.con = con;
       }
       catch(SQLException ex){
           System.out.println("Error de conexion");
       }
    }
   public AlquilerData(){}
   
   public List<Alquiler> obtenerAlquileres(){
       List<Alquiler> alquileres = new ArrayList<Alquiler>();
       
       try{
           PreparedStatement stms = Conexion.getConexionS().prepareStatement("SELECT * FROM alquiler;");
           ResultSet rs = stms.executeQuery();
           Alquiler alqui;
           while(rs.next()){
               alqui = new Alquiler();
               alqui.setId(rs.getInt("id"));
               alqui.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
               alqui.setFechaFin(rs.getDate("fechaFin").toLocalDate());
               alqui.setPrecio(rs.getLong("precio"));
               alqui.setObservaciones(rs.getString("observaciones"));
               //crear un objeto inmueble con el id del resultset
               InmuebleData dt = new InmuebleData();
               Inmueble in = new Inmueble();
               in=dt.obtenerInmueblePorId(rs.getInt("id_inmueble"));
               alqui.setInmueble(in);
               
               PersonaData pd = new PersonaData();
               Persona per = new Persona();
               per=pd.obtenerPersonaPorId(rs.getInt("id_persona"));
               alqui.setPersona(per);
               
               alquileres.add(alqui);
               
           } 
           stms.close();
           
           
       } catch (SQLException ex){
           System.out.print("Error en obtener los datos de alquileres "+ ex.getMessage());
       }
       return alquileres;
   }
   
   
   
      
   
   
   
   
     public List<Alquiler> obtenerAlquileresDireccion(String direccion){
       List<Alquiler> alquileres = new ArrayList<Alquiler>();
       InmuebleData id = new InmuebleData();
       
       try{
           PreparedStatement stms = Conexion.getConexionS().prepareStatement("SELECT * FROM alquiler WHERE id_inmueble = ?;");
           stms.setInt(1, id.obtenerInmuebles(direccion).get(0).getId());
           ResultSet rs = stms.executeQuery();
           Alquiler alqui;
           while(rs.next()){
               alqui = new Alquiler();
               alqui.setId(rs.getInt("id"));
               alqui.setFechaInicio(rs.getDate("fechaInicio").toLocalDate());
               alqui.setFechaFin(rs.getDate("fechaFin").toLocalDate());
               alqui.setPrecio(rs.getLong("precio"));
               alqui.setObservaciones(rs.getString("observaciones"));
               //crear un objeto inmueble con el id del resultset
               InmuebleData dt = new InmuebleData();
               Inmueble in = new Inmueble();
               in=dt.obtenerInmueblePorId(rs.getInt("id_inmueble"));
               alqui.setInmueble(in);
               
               PersonaData pd = new PersonaData();
               Persona per = new Persona();
               per=pd.obtenerPersonaPorId(rs.getInt("id_persona"));
               alqui.setPersona(per);
               
               alquileres.add(alqui);
               
           } 
           stms.close();
           
           
       } catch (SQLException ex){
           System.out.print("Error en obtener los datos de alquileres "+ ex.getMessage());
       }
       return alquileres;
   }
   
   
   
   
   public void ingresarAlquiler(Alquiler alquiler){
       try{
       PreparedStatement statement = Conexion.getConexionS().prepareStatement("INSERT INTO `alquiler`(`fechaInicio`, `fechaFin`, `precio`, `observaciones`, `id_inmueble`, `id_persona`) VALUES (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
       statement.setDate(1, Date.valueOf(alquiler.getFechaInicio()));
       statement.setDate(2, Date.valueOf(alquiler.getFechaFin()));
       statement.setLong(3, alquiler.getPrecio());
       statement.setString(4, alquiler.getObservaciones());
       statement.setInt(5, alquiler.getInmueble().getId());
       statement.setInt(6, alquiler.getPersona().getId());
       
       statement.executeUpdate();
       
       ResultSet rs=statement.getGeneratedKeys();
       
       if(rs.next()){
           alquiler.setId(rs.getInt(1));
       } else{
           System.err.print("Error al obtener el id de alquiler");
       }
       statement.close();
   } catch (SQLException ex){
       System.out.println("Error al ingresar nuevo alquiler "+ex.getMessage());
   }
   }
   public void eliminarAlquiler(int id) throws SQLException{
       try{
       PreparedStatement statement = Conexion.getConexionS().prepareStatement("DELETE FROM `alquiler` WHERE ?", Statement.RETURN_GENERATED_KEYS);
       statement.setInt(1,id);
       statement.executeUpdate();
       
       ResultSet rs = statement.getGeneratedKeys();
       System.out.print(rs.getInt(1));
       statement.close();
       } catch (SQLException ex){
           System.out.print("Error en eliminar el alquiler "+ex.getMessage());
       }
   }
   
   public void modificarObservaciones(int id, String obs) throws SQLException{
       try{
       PreparedStatement sts = Conexion.getConexionS().prepareStatement("UPDATE `alquiler` SET `observaciones`= ? WHERE id = ?", Statement.RETURN_GENERATED_KEYS);
       sts.setString(1, obs);
       sts.setInt(2, id);
       sts.executeUpdate();
       ResultSet rs = sts.getGeneratedKeys();
       if(rs.next()){
           System.out.print(rs.getInt(1));
       } else {
           System.out.println("Error en recuperar claves");
       }
       } catch (SQLException ex){
           System.out.print("Error en modificar "+ ex.getMessage());
       }
       
   }
   
   public void modificarFechaFinal(int id, Date date){
        try{
       PreparedStatement sts = Conexion.getConexionS().prepareStatement("UPDATE `alquiler` SET `fechaFin`=? WHERE id=?", Statement.RETURN_GENERATED_KEYS);
       sts.setDate(1, date);
       sts.setInt(2, id);
       sts.executeUpdate();
       ResultSet rs = sts.getGeneratedKeys();
       if(rs.next()){
           System.out.print(rs.getInt(1));
       } else {
           System.out.println("Error en recuperar claves fecha");
       }
       } catch (SQLException ex){
           System.out.print("Error en modificar Fecha "+ ex.getMessage());
       }
      }


public void modificarPrecio(int id, long precio){
    try{
       PreparedStatement sts = Conexion.getConexionS().prepareStatement("UPDATE `alquiler` SET `precio`= ? WHERE id=?", Statement.RETURN_GENERATED_KEYS);
       sts.setLong(1, precio);
       sts.setInt(2, id);
       sts.executeUpdate();
       ResultSet rs = sts.getGeneratedKeys();
       if(rs.next()){
           System.out.print(rs.getInt(1));
       } else {
           System.out.println("Error en recuperar claves precio");
       }
       } catch (SQLException ex){
           System.out.print("Error en modificar precio "+ ex.getMessage());
       }
      }
}
