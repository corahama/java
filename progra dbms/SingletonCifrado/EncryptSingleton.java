package SingletonCifrado;

import java.util.Base64;
import java.util.Arrays;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EncryptSingleton {
    private String secretKey = "password";

    private Connection conn;
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String url = "jdbc:mysql://localhost:3306/world?useLegacyDatetimeCode=false&serverTimezone=UTC";
    private String user = "root";
    private String password = "root";

    EncryptSingleton() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Conectado al servidor de MySQL correctamente!");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    void encryptNameTable() {
        try {
            PreparedStatement ps = conn.prepareStatement("select id, name from city");
            ResultSet rs = ps.executeQuery();

            int id; String text, encryptText;
            while(rs.next()) {
                id = Integer.parseInt(rs.getString("id"));
                text = rs.getString("name");
                encryptText = encrypt(text);
                
                PreparedStatement ps2 = conn.prepareStatement("update city set encrypt_name=? where id=?");                
                ps2.setString(1, encryptText);
                ps2.setInt(2, id);
                ps2.executeUpdate();
            }

            System.out.println("Tabla actualizada correctamente");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void decryptNameTable() {
        try {
            PreparedStatement ps = conn.prepareStatement("select id, encrypt_name from city");
            ResultSet rs = ps.executeQuery();

            int id; String text, decryptText;
            while(rs.next()) {
                id = Integer.parseInt(rs.getString("id"));
                text = rs.getString("encrypt_name");
                decryptText = decrypt(text);
                
                PreparedStatement ps2 = conn.prepareStatement("update city set encrypt_name=? where id=?");                
                ps2.setString(1, decryptText);
                ps2.setInt(2, id);
                ps2.executeUpdate();
            }

            System.out.println("Tabla actualizada correctamente");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    String encrypt(String str) { 
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] keyDigestBytes = md.digest(secretKey.getBytes("utf-8"));

            SecretKey key = new SecretKeySpec(Arrays.copyOf(keyDigestBytes, 24), "DESede");
            Cipher cipher = Cipher.getInstance("DESede");
            cipher.init(Cipher.ENCRYPT_MODE, key);
 
            byte[] plainTextBytes = str.getBytes("utf-8");
            byte[] buf = cipher.doFinal(plainTextBytes);

            return Base64.getEncoder().encodeToString(buf);

        } catch (Exception ex) {
            System.out.println(ex);
            return null;

        }
    }

    String decrypt(String str) { 
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] keyDigestBytes = md.digest(secretKey.getBytes("utf-8"));

            SecretKey key = new SecretKeySpec(Arrays.copyOf(keyDigestBytes, 24), "DESede");
            Cipher decipher = Cipher.getInstance("DESede");
            decipher.init(Cipher.DECRYPT_MODE, key);

            byte[] message = Base64.getDecoder().decode(str.getBytes("utf-8"));
            byte[] plainText = decipher.doFinal(message);
            
            return new String(plainText, "utf-8");
            
        } catch (Exception ex) {
            System.out.println(ex);
            return null;

        }
    }

}
