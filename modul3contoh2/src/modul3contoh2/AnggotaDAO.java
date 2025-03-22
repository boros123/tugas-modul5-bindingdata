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
public class AnggotaDAO {
public static ObservableList<Anggota> getAnggota() {
      // ObservableList untuk menyimpan data anggta
    ObservableList<Anggota> anggotaList = FXCollections.observableArrayList();
    String query = "SELECT anggota.*, kota.nama AS nama_kota, organisasi.nama AS nama_organisasi " +
                   "FROM anggota " +
                   "INNER JOIN kota ON anggota.id_kota = kota.id " +
                   "INNER JOIN organisasi ON anggota.id_organisasi = organisasi.id";

    try {
        Connection koneksi = DBConnection.getConnection();
        Statement stmt = koneksi.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            String id = rs.getString("id");
            String id_kota = rs.getString("id_kota");
            String id_organisasi = rs.getString("id_organisasi");
            String nama = rs.getString("nama");
            String alamat = rs.getString("alamat");
            String telpon = rs.getString("telpon");
            String email = rs.getString("email");
            String tanggal_daftar = rs.getString("tanggal_daftar");
            String jenis_kelamin = rs.getString("jenis_kelamin");
            String jenis = rs.getString("jenis");
            String nama_kota = rs.getString("nama_kota");
            String nama_organisasi = rs.getString("nama_organisasi");

       
            anggotaList.add(new Anggota(id, id_kota, id_organisasi, nama, alamat, telpon, email, 
                                        tanggal_daftar, jenis_kelamin, jenis, nama_kota, nama_organisasi));
        }

        rs.close();
        stmt.close();
        koneksi.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return anggotaList;
}


    public static void addAnggota(Anggota anggota) {
    String query = "INSERT INTO anggota (id_kota, id_organisasi, nama, alamat, telpon, email, tanggal_daftar, jenis_kelamin, jenis) VALUES (?,?,?,?,?,?,?,?,?)";
    
    try {
        Connection koneksi = DBConnection.getConnection();
        PreparedStatement smt = koneksi.prepareStatement(query);
        
        smt.setString(1, anggota.getId_kota());        // ID Kota
        smt.setString(2, anggota.getId_organisasi());  // ID Organisasi
        smt.setString(3, anggota.getNama());          // Nama
        smt.setString(4, anggota.getAlamat());        // Alamat
        smt.setString(5, anggota.getTelpon());        // Telepon
        smt.setString(6, anggota.getEmail());         // Email
        smt.setString(7, anggota.getTanggal_daftar()); // Tanggal Daftar
        smt.setString(8, anggota.getJenis_kelamin());  // Jenis Kelamin
        smt.setString(9, anggota.getJenis());         // Jenis
        
        smt.executeUpdate();
        
        smt.close();
        koneksi.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
      public static void updateAnggota(Anggota anggota) {
    String query = "UPDATE anggota SET id_kota = ?, id_organisasi = ?, nama = ?, alamat = ?, telpon = ?, email = ?, tanggal_daftar = ?, jenis_kelamin = ?, jenis = ? WHERE id = ?";

    try (Connection koneksi = DBConnection.getConnection()) {
        PreparedStatement smt = koneksi.prepareStatement(query);

        smt.setString(1, anggota.getId_kota());        // ID Kota
        smt.setString(2, anggota.getId_organisasi());  // ID Organisasi
        smt.setString(3, anggota.getNama());           // Nama
        smt.setString(4, anggota.getAlamat());         // Alamat
        smt.setString(5, anggota.getTelpon());         // Telepon
        smt.setString(6, anggota.getEmail());          // Email
        smt.setString(7, anggota.getTanggal_daftar()); // Tanggal Daftar
        smt.setString(8, anggota.getJenis_kelamin());  // Jenis Kelamin
        smt.setString(9, anggota.getJenis());          // Jenis
        smt.setString(10, anggota.getId());              

        smt.executeUpdate();
        smt.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public static void deleteAnggota(String nama) {
    String query = "DELETE FROM anggota WHERE nama = ?";

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
