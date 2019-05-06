/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inmobiliaria;
import inmobiliaria.Conexion;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Ro
 */
public class Inmobiliaria {
    /**
     * @param args the command line arguments
     */
    @SuppressWarnings("empty-statement")
    
    /*public static void main(String[] args) {
        // TODO code application logic here
       try {
        Conexion cn = new Conexion("jdbc:mysql://localhost/inmobiliaria","root","");
        PersonaData personaData = new PersonaData(cn);
        
        //Persona p = new Persona("Rogelio Funes", 24444444, "26539066668");
        //personaData.guardarPersona(p);
        //System.out.println(p.getId());
        
        personaData.obtenerPersonas().forEach(persona -> {
                System.out.println("Nombre: " + persona.getNombreCompleto() );
            };
                 
                
        //Conexion
        
       //Class.forName("org.mariadb.jdbc.Driver");
       //String url = "jdbc:mysql://localhost/inmobiliaria";
       //String user = "root";
       //String password = "";
       //Connection conexion =  DriverManager.getConnection(url, user, password);
       
       //Sentencias con HTML
       
       //PreparedStatement pstmt = conexion.prepareStatement("SELECT* ");
       //int resultado = pstmt.executeUpdate("INSERT INTO persona VALUES (null,'Lucas Perez', 32453123, 2445175689)");
       //resultado = pstmt.executeUpdate("INSERT INTO persona VALUES (null,'Juana Gonzalez', 24645102, 2643097856)");
       //resultado = pstmt.executeUpdate("DELETE* FROM persona p WHERE id.p = 2 ");
       //resultado = pstmt.executeUpdate("INSERT INTO persona VALUES (null,'Marcos Ortiz', 2513678902, 32485673)");
       //resultado = pstmt.executeUpdate("UPDATE persona SET nombreCompleto = 'Luana Martinez' WHERE id = 1 ");
       //ResultSet rs = pstmt.executeQuery("SELECT * FROM persona");
       //while(rs.next());
       //System.out.println("Nombre y Apellido: " + rs.getString(2) + "Documento: " + rs.getString(3));
       //rs.close();
       //pstmt.close();
       //conexion.close();
       }
        catch(Exception e) //Generalmente hay un catch para detectar los errores.
        {
         System.out.println("Error al instanciar la clase conexion: " + e.getMessage());
        }
    }*/
    
 
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        //ventana vn = new ventana();
        //vn.mostrarVentana();
        //VentanaPrincipal vn1 = new VentanaPrincipal();
        //vn1.setVisible(true);
        try{ 
       Conexion con = new Conexion("jdbc:mysql://localhost/inmobiliaria","root","");
        Persona ps = new Persona("Pepe", 12345, "2456733");
        PersonaData dtp = new PersonaData(con);
        dtp.guardarPersona(ps);
        
        Inmueble inm = new Inmueble("Av. lafinur", 2, true,ps);
        InmuebleData dti = new InmuebleData(con);
        dti.guardarInmueble(inm);
        
        
        //Al querer hacer un LocalDate, hay que poner.parse(y aca entre comillas el formato de fecha de EEUU con 01,09, es decir no puede ser 1,9)
        Alquiler al;
        al = new Alquiler(ps, inm,"Prueba, ojala funcione",20000,LocalDate.parse("2019-09-01"), LocalDate.parse("2020-12-08"));
        AlquilerData dta = new AlquilerData(con);
        dta.ingresarAlquiler(al);
        
        dta.obtenerAlquileres().forEach(a -> System.out.println("La persona que alquila es:"+a.getPersona().getNombreCompleto()+" y la direccion es: "+a.getInmueble().getDireccion()));
        } catch (SQLException ex) {
            System.out.println("Error en main "+ ex.getMessage());
        }
    }
}