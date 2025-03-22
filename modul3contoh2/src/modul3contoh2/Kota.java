/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul3contoh2;

/**
 *
 * @author Lenovo
 */
public class Kota {
    
   private String id;  
    private String nama;  


    public Kota(String id,String nama) {
        this.id=id;
        this.nama = nama;  
    }
//    // Konstruktor untuk data baru (tanpa ID karena ID auto-increment)
    public Kota(String nama) {  
        this.nama = nama;  
    }
//    

    public String getId() { 
        return id; 
    }  
    public String getNama() { 
        return nama;
    }  
    public void setNama(String nama) { this.nama = nama; }
    
    
    @Override
 public String toString() {
 return nama; }
    
}
