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
public class kategoriClass extends connectionClass {

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
        try {

            this.query = "SELECT * FROM kategori";
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
            this.query = "SELECT * FROM kategori WHERE id = ?";
            this.stVar = this.cnVar.createStatement();
            this.rsVar = this.stVar.executeQuery(query);

            if (!this.rsVar.next()) {

                this.query = "INSERT INTO kategori VALUES (?, ?)";
                this.psVar = this.cnVar.prepareStatement(query);
                this.psVar.setString(1, this.idKategori);
                this.psVar.setString(2, this.namaKategori);
                this.psVar.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
            } else {

                this.query = "UPDATE kategori SET nama_kategori = ? WHERE id = ?";
                this.psVar = this.cnVar.prepareStatement(query);
                this.psVar.setString(1, this.namaKategori);
                this.psVar.setString(2, this.idKategori);
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
            this.psVar.setString(1, idKategori);
            
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
