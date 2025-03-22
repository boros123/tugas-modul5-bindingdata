/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul3contoh2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Lenovo
 */
public class OrganisasiDAO {
      public static ObservableList<Organisasi> getOrganisasi() {
        // ObservableList untuk menyimpan data user
        ObservableList<Organisasi> organisasiList = FXCollections.observableArrayList();
        String query = "select * from Organisasi";

        try {
            // Membuat koneksi ke database
            Connection koneksi = DBConnection.getConnection();
            // Membuat statement
            Statement stmt = koneksi.createStatement();
            // Query untuk mengambil data user
            ResultSet rs = stmt.executeQuery(query);
            
             // Menambahkan data ke ObservableList
              while (rs.next()) {
            String id = rs.getString("id");  
            String nama = rs.getString("nama");  
            String jenis = rs.getString("jenis");

            organisasiList.add(new Organisasi(id,nama,jenis));
        }

            // Menutup koneksi
            rs.close();
            stmt.close();
            koneksi.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        
     
        return organisasiList;
    }
    
    public static void addOrganisasi(Organisasi organisasi) {
        String query = "INSERT INTO organisasi (nama,jenis) VALUES (?,?)";
    
    try {
        Connection koneksi = DBConnection.getConnection();
        PreparedStatement smt = koneksi.prepareStatement(query);
        
        smt.setString(1, organisasi.getNama());
        smt.setString(2, organisasi.getJenis());
       
        
        smt.executeUpdate();
        
        smt.close();
        koneksi.close();
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    
    
      public static void updateOrganisasi(Organisasi organisasi) {
    String query = "UPDATE organisasi SET nama = ?, jenis = ? WHERE id = ?";

    try (Connection koneksi = DBConnection.getConnection()) {
        PreparedStatement mst = koneksi.prepareStatement(query);
        mst.setString(1, organisasi.getNama()); 
        mst.setString(2, organisasi.getJenis()); 
        mst.setString(3, organisasi.getId()); 

        mst.executeUpdate();
        mst.close();
        koneksi.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public static void deleteOrganisasi(String nama) {
    String query = "DELETE FROM organisasi WHERE nama = ?";

    try (Connection koneksi = DBConnection.getConnection()) {
        PreparedStatement mst = koneksi.prepareStatement(query);
        mst.setString(1, nama);

        mst.executeUpdate();
        mst.close();
        koneksi.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
