/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classPackage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ASUS
 */
public abstract class connectionClass {

    private String host = "localhost";
    private String port = "3306";
    private String db = "buku_oop";
    private String user = "root";
    private String password = "";
    private String url = "jdbc:mysql://" + host + ":" + port + "/" + db;

    private Connection cnVar;
    protected PreparedStatement psVar;
    protected Statement stVar;
    protected ResultSet rsVar;
    protected String query;

    public Connection getConnection() {

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            cnVar = DriverManager.getConnection(url, user, password);

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Error, Gagal terkoneksi ke Database : " + sQLException.getMessage());

        }

        return cnVar;
    }

    public abstract ResultSet showData();

    public abstract void saveData();

    public abstract void deleteData();

}
