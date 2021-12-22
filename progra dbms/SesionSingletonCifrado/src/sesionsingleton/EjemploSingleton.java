/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sesionsingleton;

import java.util.Arrays;
import java.util.Base64;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author SistemasUG
 */
public class EjemploSingleton {

    private Connection conn = null;
    private String driver;
    private String url;
    private String usuario;
    private String password;

    // Constructor
    public EjemploSingleton() {
        String secretKey = "contrasena";
        String Texto = "";
        int id=0;
        String TextoCifrado = "";
        
        String url = "jdbc:mysql://localhost:3306/world?useLegacyDatetimeCode=false&serverTimezone=UTC";
        String driver = "com.mysql.jdbc.Driver";
        String usuario = "root";
        String password = "Root";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
            
            //ejecutamos la consulta
            PreparedStatement ps = conn.prepareStatement("select id,name from city");
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                id=Integer.parseInt(rs.getString("id"));
                Texto=rs.getString("name");                              
                TextoCifrado = Encriptar(Texto,secretKey);
                
                //System.out.println("Ciudad: " + Texto + ", ciudad cifrada: " + TextoCifrado );
                
                PreparedStatement ps2 = conn.prepareStatement("update city set nombre_cifrada=? where id=?");
                
                ps2.setString(1, TextoCifrado);
                ps2.setInt(2, id);
                ps2.executeUpdate();
            }
            System.out.println("Actualizado");
            
            PreparedStatement ps3 = conn.prepareStatement("select name,nombre_cifrada from city");
            ResultSet rs3 = ps3.executeQuery();
            
            while(rs3.next())
            {
                System.out.println("Ciudad: " + rs3.getString("name") + ", ciudad cifrada: " + rs3.getString("nombre_cifrada")  );
            }
            
        } 
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    } // Fin constructor

    // Métodos
    public Connection getConnection() {

        if (conn == null) {
            new EjemploSingleton();
        }

        return conn;
    } // Fin getConnection
    
    
    public static String Encriptar(String texto,String secretKey) {
        String base64EncryptedString = ""; 
        try {
 
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digestOfPassword = md.digest(secretKey.getBytes("utf-8"));
            byte[] keyBytes = Arrays.copyOf(digestOfPassword, 24);
 
            SecretKey key = new SecretKeySpec(keyBytes, "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);
 
            byte[] plainTextBytes = texto.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);
            byte[] base64Bytes = Base64.encodeBase64(buf);
            
            //salida codificada en base64 (en base de 64bits)
            base64EncryptedString = new String(base64Bytes);
 
        } catch (Exception ex) {
        }
        return base64EncryptedString;
    }
 
    
    
    
}
