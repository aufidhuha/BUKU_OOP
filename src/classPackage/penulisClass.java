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

        try {
            this.query = "SELECT * FROM penulis";
            this.stVar = this.cnVar.createStatement();
            this.rsVar = this.stVar.executeQuery(query);

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Error : " + sQLException.getMessage());
        }

        return this.rsVar;
    }

    @Override
    public void saveData() {
        try {
            this.query = "SELECT * FROM penulis WHERE nip = ?";
            this.stVar = this.cnVar.createStatement();
            this.rsVar = this.stVar.executeQuery(query);

            if (!this.rsVar.next()) {

                this.query = "INSERT INTO penulis VALUES (?, ?)";
                this.psVar = this.cnVar.prepareStatement(query);
                this.psVar.setString(1, this.nipPenulis);
                this.psVar.setString(2, this.namaPenulis);
                this.psVar.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            } else {

                this.query = "UPDATE penulis SET nama_penulis = ? WHERE nip = ?";
                this.psVar = this.cnVar.prepareStatement(query);
                this.psVar.setString(1, this.nipPenulis);
                this.psVar.setString(2, this.namaPenulis);
                this.psVar.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data berhasil diubah");

            }

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Error : " + sQLException.getMessage());
        }

    }

    @Override
    public void deleteData() {
        try {
            this.query = "DELETE FROM kategorij WHERE id = ?";
            this.psVar = this.cnVar.prepareStatement(query);
            this.psVar.setString(1, this.nipPenulis);

            int yesOrNo = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION);

            if (yesOrNo == JOptionPane.YES_OPTION) {
                this.psVar.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
            }

        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Error : " + sQLException.getMessage());
        }

    }

}
