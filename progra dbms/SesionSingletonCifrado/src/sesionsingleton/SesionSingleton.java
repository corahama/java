/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesionsingleton;

/**
 *
 * @author SistemasUG
 */
import java.sql.*;

public class SesionSingleton {

    /**
     * @param args the command line arguments
     */
    public Connection conn = null;
    public static void main(String[] args) {
        // TODO code application logic here
        EjemploSingleton obj = new EjemploSingleton();
    }  
}
