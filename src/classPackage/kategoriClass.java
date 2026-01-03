/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classPackage;

import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author ASUS
 */
public class kategoriClass extends connectionClass{
    
    private String idKategori, namaKategori;
    private final Connection cnVar;

    public kategoriClass() {
        this.cnVar = super.getConnection();
    }

    public String getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(String idKategori) {
        this.idKategori = idKategori;
    }

    public String getNamaKategori() {
        return namaKategori;
    }

    public void setNamaKategori(String namaKategori) {
        this.namaKategori = namaKategori;
    }

    @Override
    public ResultSet showData() {
       
        return this.rsVar;
    }

    @Override
    public void saveData() {
        
    }

    @Override
    public void deleteData() {
        
    }
    
}
