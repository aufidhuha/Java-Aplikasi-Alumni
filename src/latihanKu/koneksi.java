/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihanKu;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class koneksi {
    
    static Connection cnVar;
    
    public static Connection getKoneksi(){
        try {
            String url = "jdbc:mysql://localhost:3306/alumni_202457201015";
            String user = "root";
            String pass = "";
            
            cnVar = DriverManager.getConnection(url, user, pass);
            
        } catch (SQLException sQLException) {
            
            JOptionPane.showMessageDialog(null, "Tidak dapat terkoneksi");
            
        }
            return cnVar;
    }
    
}
