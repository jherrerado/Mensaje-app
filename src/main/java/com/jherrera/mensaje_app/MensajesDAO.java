package com.jherrera.mensaje_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajesDAO {
    public static void crearMensajeDB(Mensaje mensaje){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connetion()){
            PreparedStatement ps = null;
            try{
                String query = "INSERT INTO `mensaje` (`mensaje`, `auto_mensaje`) VALUES (?,?);";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("mensaje creado correctamente");
            }catch (SQLException ex){
                System.out.println(ex);
            }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void leerMensajeDB(){
        Conexion db_connect = new Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;


        try(Connection conexion = db_connect.get_connetion()){
            String query = "SELECT * FROM mensaje";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();

            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("auto_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                System.out.println(" ");
            }
        }catch (SQLException e){
            System.out.println("no se pudo traer los mensajes");
            System.out.println(e);
        }
    }

    public static void borrarMensajeDB(int id_mensaje){
        Conexion db_connect = new Conexion();

        try(Connection conexion = db_connect.get_connetion()){
            PreparedStatement ps = null;
                try{
                    String query = "DELETE FROM mensaje WHERE mensaje.id_mensaje = ?";
                    ps = conexion.prepareStatement(query);
                    ps.setInt(1, id_mensaje);
                    ps.executeUpdate();
                    System.out.println("El mensaje fue borrado");
                }catch(SQLException e){
                    System.out.println(e);
                    System.out.println("No se pudo borrar el mensaje");
                }
        }catch (SQLException e){
            System.out.println(e);
        }
    }

    public static void actualizarMensajeDB(Mensaje mensaje){
        Conexion db_connect = new Conexion();
        try(Connection conexion = db_connect.get_connetion()){
            PreparedStatement ps = null;
            try{
               String query = "UPDATE mensaje SET mensaje = ? WHERE mensaje.id_mensaje = ?";
               ps = conexion.prepareStatement(query);
               ps.setString(1, mensaje.getMensaje());
               ps.setInt(2, mensaje.getId_mensaje());
               ps.executeUpdate();
                System.out.println("El mensaje fue actualizado");

            }catch (SQLException e){
                System.out.println(e);
                System.out.println("El mensaje no pudo ser actualizado");
            }
        }catch(SQLException e){
            System.out.println(e);
            System.out.println("No se pudo borrar el mensaje");
        }
    }
}
