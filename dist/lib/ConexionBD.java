/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metodoso_SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author luisf
 */
public class ConexionBD {
    public static String url= "jdbc:mysql://localhost/GestFrog";
    public static String usuario="root";
    public static String contraseña="sasa";
    public static String clase="com.mysql.cj.jdbc.Driver";
    
    
    public static Connection conectar (){
    Connection conexion =null;
      
     try{
         Class.forName(clase);
         conexion =(Connection) DriverManager.getConnection(url,usuario,contraseña);
         System.out.println("ConexionEstablecida");
     } catch(ClassNotFoundException | SQLException e){
         
         System.out.println(e);
     }
     return conexion;
    }
}
