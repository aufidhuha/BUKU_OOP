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
public class bukuClass extends connectionClass {

    private String idBuku, namaBuku, kategori, penulis, terbit;

    private final Connection cnVar;

    public bukuClass() {
        this.cnVar = super.getConnection();
    }

    public String getIdBuku() {
        return idBuku;
    }

    public void setIdBuku(String idBuku) {
        this.idBuku = idBuku;
    }

    public String getNamaBuku() {
        return namaBuku;
    }

    public void setNamaBuku(String namaBuku) {
        this.namaBuku = namaBuku;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getTerbit() {
        return terbit;
    }

    public void setTerbit(String terbit) {
        this.terbit = terbit;
    }

    @Override
    public ResultSet showData() {

        try {
            this.query = "SELECT buku.id_buku, buku.nama_buku, kategori.nama_kategori, penulis.nama_penulis, buku.terbit FROM buku JOIN kategori ON buku.kategori = kategori.id JOIN penulis ON buku.penulis = penulis.nip";
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
            this.query = "SELECT * FROM buku WHERE id_buku = ?";
            this.stVar = this.cnVar.createStatement();
            this.rsVar = this.stVar.executeQuery(query);

            if (!this.rsVar.next()) {

                this.query = "INSERT INTO buku VALUES (?, ?, ?, ?, ?)";
                this.psVar = this.cnVar.prepareStatement(query);
                this.psVar.setString(1, this.idBuku);
                this.psVar.setString(2, this.namaBuku);
                this.psVar.setString(3, this.kategori);
                this.psVar.setString(4, this.penulis);
                this.psVar.setString(5, this.terbit);
                this.psVar.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");

            } else {

                this.query = "UPDATE buku SET nama_buku = ?, kategori = ?, penulis = ?, terbit = ? WHERE id_buku = ?";
                this.psVar = this.cnVar.prepareStatement(query);
                this.psVar.setString(1, this.namaBuku);
                this.psVar.setString(2, this.kategori);
                this.psVar.setString(3, this.penulis);
                this.psVar.setString(4, this.terbit);
                this.psVar.setString(5, this.idBuku);
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
            this.query = "DELETE FROM buku WHERE id_buku = ?";
            this.psVar = this.cnVar.prepareStatement(query);
            this.psVar.setString(1, this.idBuku);

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
