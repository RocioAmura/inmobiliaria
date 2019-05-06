/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inmobiliaria;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Ro
 */
public class Conexion {
    private String url="jdbc:mysql://localhost/inmobiliaria";
    private String usuario="root";
    private String password="";
    private static Connection con;
    private static Conexion conexion = null;


    
    public Conexion(String url, String usuario, String password) throws ClassNotFoundException {
        this.url = url;
        this.usuario = usuario;
        this.password = password;

        //Cargamos las clases de mariadb que implementan JDBC
        Class.forName("org.mariadb.jdbc.Driver");

    }
       private Conexion(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            con = DriverManager.getConnection(url, usuario, password);
            
        } catch (SQLException ex) {
               System.out.println("Error al al hacer la conexion");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error al pasar nombre de driver");
        }
        
    }
    
    public Connection getConexion() throws SQLException{
        if(con == null){
                    // Setup the connection with the DB
            con = DriverManager
                .getConnection(url + "?useLegacyDatetimeCode=false&serverTimezone=UTC"
                        + "&user=" + usuario + "&password=" + password);
        }
        return con;
    }
        public static Connection getConexionS(){
      
            try {
                 if(conexion == null || con.isClosed()|| !con.isValid(0)) {
                    conexion = new Conexion();
                 }

            } catch (SQLException ex) {
                System.out.println("Fallo en getConexion\n");
            }
        
        return con;
    }
}
