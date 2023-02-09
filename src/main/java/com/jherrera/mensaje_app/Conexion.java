package com.jherrera.mensaje_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public Connection get_connetion(){
        Connection conection = null;
        try{
            conection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensaje_app", "root", "");
        }catch(SQLException e) {
            System.out.println(e);
        }
        return conection;
    }
}
