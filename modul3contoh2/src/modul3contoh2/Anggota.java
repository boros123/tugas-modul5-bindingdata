/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul3contoh2;

/**
 *
 * @author Lenovo
 */
public class Anggota {
    private String id;  
    private String id_kota;
    private String id_organisasi;  
    private String nama;
    private String alamat;  
    private String telpon;
    private String email;  
    private String tanggal_daftar;
    private String jenis_kelamin;  
    private String jenis;  
    private String nama_kota;       // Nama kota (dari tabel kota)
    private String nama_organisasi; // Nama organisasi (dari tabel organisasi)
    
    // Konstruktor lengkap dengan nama kota dan nama organisasi
    public Anggota(String id, String id_kota, String id_organisasi, String nama, 
                   String alamat, String telpon, String email, String tanggal_daftar, 
                   String jenis_kelamin, String jenis, String nama_kota, String nama_organisasi) {
        this.id = id;
        this.id_kota = id_kota;
        this.id_organisasi = id_organisasi;
        this.nama = nama;
        this.alamat = alamat;
        this.telpon = telpon;
        this.email = email;
        this.tanggal_daftar = tanggal_daftar;
        this.jenis_kelamin = jenis_kelamin;
        this.jenis = jenis;
        this.nama_kota = nama_kota;
        this.nama_organisasi = nama_organisasi;
    }

    // Konstruktor tanpa ID, jika diperlukan
    public Anggota(String id_kota, String id_organisasi, String nama, 
                   String alamat, String telpon, String email, String tanggal_daftar, 
                   String jenis_kelamin, String jenis) {
        this.id_kota = id_kota;
        this.id_organisasi = id_organisasi;
        this.nama = nama;
        this.alamat = alamat;
        this.telpon = telpon;
        this.email = email;
        this.tanggal_daftar = tanggal_daftar;
        this.jenis_kelamin = jenis_kelamin;
        this.jenis = jenis;
     
    }

    public String getId() {
        return id;
    }

    public String getId_kota() {
        return id_kota;
    }

    public void setId_kota(String id_kota) {
        this.id_kota = id_kota;
    }

    public String getId_organisasi() {
        return id_organisasi;
    }

    public void setId_organisasi(String id_organisasi) {
        this.id_organisasi = id_organisasi;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelpon() {
        return telpon;
    }

    public void setTelpon(String telpon) {
        this.telpon = telpon;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTanggal_daftar() {
        return tanggal_daftar;
    }

    public void setTanggal_daftar(String tanggal_daftar) {
        this.tanggal_daftar = tanggal_daftar;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getNama_kota() {
        return nama_kota;
    }

    public void setNama_kota(String nama_kota) {
        this.nama_kota = nama_kota;
    }

    public String getNamaOrganisasi() {
        return nama_organisasi;
    }

    public void setNamaOrganisasi(String nama_organisasi) {
        this.nama_organisasi = nama_organisasi;
    }
  
}
