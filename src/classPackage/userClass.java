/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class userClass extends connectionClass {
    
    private String username, password, lastUsername, newUsername, newPassword, pengguna;
    
    private final Connection cnVar;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLastUsername() {
        return lastUsername;
    }

    public void setLastUsername(String lastUsername) {
        this.lastUsername = lastUsername;
    }

    public String getNewUsername() {
        return newUsername;
    }

    public void setNewUsername(String newUsername) {
        this.newUsername = newUsername;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getPengguna() {
        return pengguna;
    }

    public void setPengguna(String pengguna) {
        this.pengguna = pengguna;
    }
    
    public userClass(){
        this.cnVar = super.getConnection();
    }
    
    
    public boolean loginApp(){
        
        try {
            this.query = "SELECT * FROM user WHERE username = ? AND password = SHA2(?, 384)";
            this.psVar = this.cnVar.prepareStatement(query);
            this.psVar.setString(1, this.username);
            this.psVar.setString(2, this.password);
            this.rsVar = this.psVar.executeQuery();
            
            return this.rsVar.next();
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Error : " + sQLException.getMessage());
            return false;
        }
    }
    
    
    @Override
    public ResultSet showData(){
        
        return this.rsVar;
    }
    
    @Override
    public void saveData(){
        
    }
    
    @Override
    public void deleteData(){
        
    }
    
}
