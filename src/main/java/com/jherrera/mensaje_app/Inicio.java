package com.jherrera.mensaje_app;

import java.sql.Connection;
import java.util.Scanner;

public class Inicio {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do{

            System.out.println("--------------------------");
            System.out.println("Aplicacion de mensaje");
            System.out.println("1. crear mensaje");
            System.out.println("2. listar los mensajes");
            System.out.println("3. Eliminar mensaje");
            System.out.println("4. ediar los mensajes");
            System.out.println("5. salir");

            opcion = scanner.nextInt();

            switch (opcion){
                case 1:
                    MensajeService.crearMensaje();
                    break;
                case 2:
                    MensajeService.listarMensajes();
                    break;
                case 3:
                    MensajeService.borrarMensaje();
                    break;
                case 4:
                    MensajeService.editarMensaje();
                    break;
                case 5:
                    break;
                default:
                    break;
            }

        }while (opcion != 5);

        Conexion conexion = new Conexion();
        try(Connection cnx = conexion.get_connetion()){

        }catch (Exception e){
            System.out.println(e);
        }
    }
}
