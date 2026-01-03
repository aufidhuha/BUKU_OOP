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
public class penulisClass extends connectionClass {

    private String nipPenulis, namaPenulis;
    private Connection cnVar;

    public penulisClass() {
        this.cnVar = super.getConnection();
    }

    public String getNipPenulis() {
        return nipPenulis;
    }

    public void setNipPenulis(String nipPenulis) {
        this.nipPenulis = nipPenulis;
    }

    public String getNamaPenulis() {
        return namaPenulis;
    }

    public void setNamaPenulis(String namaPenulis) {
        this.namaPenulis = namaPenulis;
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
