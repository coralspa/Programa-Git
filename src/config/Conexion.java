package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://localhost:3306/coral_spa";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "30351268";

    public static Connection conectar() {
        try {
            Connection conexion = DriverManager.getConnection(
                URL,
                USUARIO,
                PASSWORD
            );

            System.out.println("Conexion exitosa a la base de datos coral_spa.");
            return conexion;

        } catch (SQLException e) {
            System.out.println("Error al conectar con la base de datos.");
            System.out.println("Mensaje: " + e.getMessage());
            return null;
        }
    }
}