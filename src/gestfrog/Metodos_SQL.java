/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestfrog;

import java.sql.*;

/**
 *
 * @author luisf
 */
public class Metodos_SQL {

    public static ConexionBD conexion = new ConexionBD();

    public static PreparedStatement sentencia_preparada;
    public static ResultSet resultado;
    public static String sql;
    public static int resultado_numero = 0;
    public static PreparedStatement tamaño_busc;

    public String busqueda_usuarios = null;
    public String busqueda_desc = null;
    public boolean busqueda_disp;
    public int tamaño_tabla_grup = 0;

    public static int guardar(String usuario, String correo, String Contraseña, String Nombre) {
        int resultado = 0;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement("INSERT INTO usuarios(usuario, correo, contraseña, nombre ) VALUES(?,?,?,?)");
            sentencia_preparada.setString(1, usuario);
            sentencia_preparada.setString(2, correo);
            sentencia_preparada.setString(3, Contraseña);
            sentencia_preparada.setString(4, Nombre);

            resultado = sentencia_preparada.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }

    public static String buscarUsuario(String usuario) {
        String busqueda_usuario = null;
        Connection conexion = null;
        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar = ("SELECT correo,nombre FROM usuarios WHERE usuario= '" + usuario + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String correo = resultado.getString("correo");
                String nombre = resultado.getString("nombre");
                busqueda_usuario = (nombre);
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_usuario;
    }

    public static int guardarTarea(String titulo, String fecha1, String fecha2, String desc) {
        int resultado = 0;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement("INSERT INTO tareas(titulo, fecha_inicio, fecha_final, descripción ) VALUES(?,?,?,?)");
            sentencia_preparada.setString(1, titulo);
            sentencia_preparada.setString(2, fecha1);
            sentencia_preparada.setString(3, fecha2);
            sentencia_preparada.setString(4, desc);

            resultado = sentencia_preparada.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }

    public int guardarGrupo(String usuarios, String desc, boolean disp, int id) {
        int resultado = 0;
        Connection conexion = null;

        try {
            conexion = ConexionBD.conectar();
            sentencia_preparada = conexion.prepareStatement("INSERT INTO grupo(usuarios, descipcion, disponible, id) VALUES(?,?,?,?)");

            sentencia_preparada.setString(1, usuarios);
            sentencia_preparada.setString(2, desc);
            sentencia_preparada.setBoolean(3, disp);
            sentencia_preparada.setInt(4, id);
            tamaño_busc = conexion.prepareStatement(" select count(*) from grupo");
            tamaño_tabla_grup = tamaño_busc.getUpdateCount();
            resultado = sentencia_preparada.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }
        return resultado;
    }

    public String buscarUsuarioRegistrado(String usuario, String contraseña) {
        String busqueda_usuarioR = null;
        Connection conexion = null;
        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscarUR = ("SELECT usuario, nombre, correo, contraseña FROM usuarios WHERE usuario= '" + usuario + "' && contraseña = '" + contraseña + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscarUR);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                busqueda_usuarioR = "Usuario encontrado";
            } else {
                busqueda_usuarioR = "Usuario No encontrado";
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return busqueda_usuarioR;

    }

    public void buscarGrupo(int id) {

        Connection conexion = null;
        try {
            conexion = ConexionBD.conectar();
            String sentencia_buscar = ("SELECT usuarios,descipcion,disponible FROM grupo WHERE id = '" + id + "'");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            if (resultado.next()) {
                String usu = resultado.getString("usuarios");
                String desc = resultado.getString("descipcion");
                boolean disp = resultado.getBoolean("disponible");
                busqueda_usuarios = (usu);
                busqueda_desc = (desc);
                busqueda_disp = (disp);
            }
            conexion.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public int getTamañoTablaGrupo() {
        return tamaño_tabla_grup;
    }

    public void actualizarTamañoGrupo() {

        Connection conexion = null;

        try {

            conexion = ConexionBD.conectar();
            String sentencia_buscar = ("SELECT usuarios,descipcion,disponible FROM grupo");
            sentencia_preparada = conexion.prepareStatement(sentencia_buscar);
            resultado = sentencia_preparada.executeQuery();
            while (resultado.next()) {
                tamaño_tabla_grup++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
