/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modul3contoh2;

/**
 *
 * @author Lenovo
 */
public class Organisasi {
     private String id;  
    private String nama;
    private String jenis;


    public Organisasi(String id,String nama,String jenis) {
        this.id=id;
        this.nama = nama; 
        this.jenis = jenis;
    }

    public Organisasi(String nama, String jenis) {  
        this.nama = nama;  
        this.jenis =jenis;
    }
//    

    public String getId() { 
        return id; 
    }  
    public String getNama() { 
        return nama;
    }  
    public void setNama(String nama) { 
        this.nama = nama; 
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }
    
    
    @Override
 public String toString() {
 return nama; }
}
