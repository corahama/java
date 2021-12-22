package singletonpostgres;

import java.sql.Connection;
import java.sql.DriverManager;

public class Singleton {
    private String driver = "org.postgresql.Driver";
    private String url = "jdbc:postgresql://localhost/test";
    private String user = "java";
    private String password = "root";
        
    public Connection connect() {
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado al servidor de PostgreSQL correctamente!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

}
