/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package latihanKu;

import javax.swing.table.DefaultTableModel;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author ASUS
 */
public class kelasPanel extends javax.swing.JPanel {

    /**
     * Creates new form kelasPanel
     */
    public kelasPanel() {
        initComponents();
        reset();
        load_table_kelas();
        comboJurusan();
        comboWali();
    }

    
    void reset(){
        txtKodeKelas.setText(null);
        txtKodeKelas.setEditable(true);
        txtNamaKelas.setText(null);
        cbJurusan.setSelectedItem(null);
        cbTingkatan.setSelectedItem(null);
        cbWaliKelas.setSelectedItem(null);
    }
    
    void load_table_kelas(){
        
        DefaultTableModel model = new DefaultTableModel();
        
        model.addColumn("Kode Kelas");
        model.addColumn("Nama Kelas");
        model.addColumn("Tingkatan");
        model.addColumn("Jurusan");
        model.addColumn("Wali Kelas");
        
        
        String sql = "SELECT kelas.id_kelas, kelas.nama_kelas, kelas.tingkatan, jurusan.nama_jurusan, guru.nama_guru"
                + " FROM kelas LEFT JOIN jurusan ON kelas.kode_jur = jurusan.kode_jur"
                + " LEFT JOIN guru ON kelas.nip_wali_kelas = guru.nip";
        try {
        Connection cnVar = koneksi.getKoneksi();
        
            Statement stVar = cnVar.createStatement();
            ResultSet rsVar = stVar.executeQuery(sql);
            
            while (rsVar.next()) {                
                String idKelas = rsVar.getString("id_kelas");
                String namaKelas = rsVar.getString("nama_kelas");
                String tingkatan = rsVar.getString("tingkatan");
                String namaJurusan = rsVar.getString("nama_jurusan");
                String namaGuru = rsVar.getString("nama_guru");
                
                Object[] baris = {idKelas, namaKelas, tingkatan, namaJurusan, namaGuru};
                model.addRow(baris);
            }
            
        } catch (SQLException sQLException) {
        }
        tabelKelas.setModel(model);
    }
    
    void comboJurusan(){
        try {
            String sql = "SELECT * FROM jurusan";
            
            Connection cnVar = koneksi.getKoneksi();
            Statement stVar = cnVar.createStatement();
            ResultSet rsVar = stVar.executeQuery(sql);
            
            while (rsVar.next()) {
               cbJurusan.addItem(rsVar.getString("nama_jurusan"));
            }
            
        } catch (SQLException sQLException) {
        }
        cbJurusan.setSelectedItem(null);
    }    
    
    void comboWali(){
        try {
            String sql = "SELECT * FROM guru";
            
            Connection cnVar = koneksi.getKoneksi();
            Statement stVar = cnVar.createStatement();
            ResultSet rsVar = stVar.executeQuery(sql);
            
            while (rsVar.next()) {
               cbWaliKelas.addItem(rsVar.getString("nama_guru"));
            }
            
        } catch (SQLException sQLException) {
        }
        cbWaliKelas.setSelectedItem(null);
    }
    
    
    String kodeJurusan(String namaJurusan){
        try {
            String sql = "SELECT * FROM jurusan WHERE nama_jurusan = ?";
            
            Connection cnVar = koneksi.getKoneksi();
            PreparedStatement psVar = cnVar.prepareStatement(sql);
            psVar.setString(1, namaJurusan);
            ResultSet rsVar = psVar.executeQuery();
            
            while (rsVar.next()) {
              return rsVar.getString("kode_jur");
            }
            
        } catch (SQLException sQLException) {
            return "";
        }
        
            return "";
    }
    
    String NIP(String namaGuru){
        try {
            String sql = "SELECT * FROM guru WHERE nama_guru = ?";
            
            Connection cnVar = koneksi.getKoneksi();
            PreparedStatement psVar = cnVar.prepareStatement(sql);
            psVar.setString(1, namaGuru);
            ResultSet rsVar = psVar.executeQuery();
            
            while (rsVar.next()) {
              return rsVar.getString("nip");
            }
            
        } catch (SQLException sQLException) {
            return "";
        }
        
            return "";
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        closeLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtKodeKelas = new javax.swing.JTextField();
        txtNamaKelas = new javax.swing.JTextField();
        cbJurusan = new javax.swing.JComboBox<>();
        cbWaliKelas = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelKelas = new javax.swing.JTable();
        buttonTambah = new javax.swing.JButton();
        buttonUbah = new javax.swing.JButton();
        buttonHapus = new javax.swing.JButton();
        buttonReset = new javax.swing.JButton();
        cbTingkatan = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(204, 204, 204));
        setForeground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 153, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DATA KELAS");

        closeLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/latihanKu/image/icons8-close2-20.png"))); // NOI18N
        closeLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 665, Short.MAX_VALUE)
                .addComponent(closeLabel2)
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(closeLabel2))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("KODE KELAS");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("NAMA KELAS");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("TINGKATAN");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("JURUSAN");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("WALI KELAS");

        txtKodeKelas.setBackground(new java.awt.Color(255, 255, 255));
        txtKodeKelas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        txtNamaKelas.setBackground(new java.awt.Color(255, 255, 255));
        txtNamaKelas.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));

        cbJurusan.setBackground(new java.awt.Color(255, 255, 255));
        cbJurusan.setForeground(new java.awt.Color(0, 0, 0));

        cbWaliKelas.setBackground(new java.awt.Color(255, 255, 255));
        cbWaliKelas.setForeground(new java.awt.Color(0, 0, 0));

        tabelKelas.setBackground(new java.awt.Color(255, 255, 255));
        tabelKelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabelKelas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelKelasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelKelas);

        buttonTambah.setBackground(new java.awt.Color(0, 153, 0));
        buttonTambah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonTambah.setForeground(new java.awt.Color(255, 255, 255));
        buttonTambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/latihanKu/image/icons8-add-16.png"))); // NOI18N
        buttonTambah.setText("TAMBAH");
        buttonTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonTambahActionPerformed(evt);
            }
        });

        buttonUbah.setBackground(new java.awt.Color(255, 153, 0));
        buttonUbah.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonUbah.setForeground(new java.awt.Color(255, 255, 255));
        buttonUbah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/latihanKu/image/icons8-edit-16.png"))); // NOI18N
        buttonUbah.setText("UBAH");
        buttonUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUbahActionPerformed(evt);
            }
        });

        buttonHapus.setBackground(new java.awt.Color(255, 0, 0));
        buttonHapus.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonHapus.setForeground(new java.awt.Color(255, 255, 255));
        buttonHapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/latihanKu/image/icons8-delete-16.png"))); // NOI18N
        buttonHapus.setText("HAPUS");
        buttonHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonHapusActionPerformed(evt);
            }
        });

        buttonReset.setBackground(new java.awt.Color(51, 153, 255));
        buttonReset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonReset.setForeground(new java.awt.Color(255, 255, 255));
        buttonReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/latihanKu/image/icons8-reset-16.png"))); // NOI18N
        buttonReset.setText("RESET");
        buttonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonResetActionPerformed(evt);
            }
        });

        cbTingkatan.setBackground(new java.awt.Color(255, 255, 255));
        cbTingkatan.setForeground(new java.awt.Color(0, 0, 0));
        cbTingkatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "11", "12" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbJurusan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNamaKelas, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(txtKodeKelas, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                            .addComponent(cbWaliKelas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbTingkatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtKodeKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtNamaKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbTingkatan, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cbJurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbWaliKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonReset, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void closeLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeLabel2MouseClicked
        // TODO add your handling code here:
          removeAll();
         revalidate();
         repaint();
    }//GEN-LAST:event_closeLabel2MouseClicked

    private void tabelKelasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelKelasMouseClicked
        // TODO add your handling code here:
        int barisYangDipilih = tabelKelas.rowAtPoint(evt.getPoint());
        
        String kodeKelas = tabelKelas.getValueAt(barisYangDipilih, 0).toString();
        String namaKelas = tabelKelas.getValueAt(barisYangDipilih, 1).toString();
        String tingkatan = tabelKelas.getValueAt(barisYangDipilih, 2).toString();
        String jurusan = tabelKelas.getValueAt(barisYangDipilih, 3).toString();
        String waliKelas; 
        
        if (tabelKelas.getValueAt(barisYangDipilih, 4)!= null) {
            waliKelas = tabelKelas.getValueAt(barisYangDipilih, 4).toString();
        } else {
            waliKelas = null;
        }
        
        txtKodeKelas.setText(kodeKelas);
        txtKodeKelas.setEditable(false);
        
        txtNamaKelas.setText(namaKelas);
        
        cbTingkatan.setSelectedItem(tingkatan);
        cbJurusan.setSelectedItem(jurusan);
        cbWaliKelas.setSelectedItem(waliKelas);
    }//GEN-LAST:event_tabelKelasMouseClicked

    private void buttonTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonTambahActionPerformed
        // TODO add your handling code here:
        if (txtKodeKelas.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harap mengisi data secara keseluruhan", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        String kodeKelas = txtKodeKelas.getText();
        String namaKelas = txtNamaKelas.getText();
        String tingkatan = cbTingkatan.getSelectedItem().toString();
        
        String jurusan = kodeJurusan(cbJurusan.getSelectedItem().toString());
        String wali = NIP(cbWaliKelas.getSelectedItem().toString());        
        
        try {
            String sql = "INSERT INTO kelas (id_kelas, nama_kelas, tingkatan, kode_jur, nip_wali_kelas)"
                    + "VALUES (?, ?, ?, ?, ?)";
            
            Connection cnVar = koneksi.getKoneksi();
            PreparedStatement psVar = cnVar.prepareStatement(sql);
            
            psVar.setString(1, kodeKelas);
            psVar.setString(2, namaKelas);
            psVar.setString(3, tingkatan);
            psVar.setString(4, jurusan);
            psVar.setString(5, wali);
            psVar.execute();
            
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data gagal disimpan" + sQLException.getMessage());
        } 
//        
        load_table_kelas();
        reset();
    }//GEN-LAST:event_buttonTambahActionPerformed

    private void buttonHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonHapusActionPerformed
        // TODO add your handling code here:
         if (txtKodeKelas.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harap memilih data yang ingin dihapus", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        int yesOrNo = JOptionPane.showConfirmDialog(null, "Apakah anda yakin ingin menghapus data ini?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        
        if (yesOrNo == JOptionPane.YES_OPTION) {
            String kodeKelas = txtKodeKelas.getText();
           
        
        try {
            String sql = "DELETE FROM kelas WHERE id_kelas = ?";
            
            Connection cnVar = koneksi.getKoneksi();
            PreparedStatement psVar = cnVar.prepareStatement(sql);
            
            psVar.setString(1, kodeKelas);
            
            psVar.execute();
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data gagal dihapus " + sQLException.getMessage());
        }
        
        }
        
        load_table_kelas();
        reset();
    }//GEN-LAST:event_buttonHapusActionPerformed

    private void buttonUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUbahActionPerformed
        // TODO add your handling code here:
         if (txtKodeKelas.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harap memilih data yang ingin diubah", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        String kodeKelas = txtKodeKelas.getText();
        String namaKelas = txtNamaKelas.getText();
        String tingkatan = cbTingkatan.getSelectedItem().toString();
        
        String jurusan = kodeJurusan(cbJurusan.getSelectedItem().toString());
        String wali = NIP(cbWaliKelas.getSelectedItem().toString());        
        
        try {
            String sql = "UPDATE kelas SET nama_kelas = ?, tingkatan = ?,"
                    + "kode_jur = ?, nip_wali_kelas = ? WHERE id_kelas = ?";
            
            Connection cnVar = koneksi.getKoneksi();
            PreparedStatement psVar = cnVar.prepareStatement(sql);
            
            psVar.setString(1, namaKelas);
            psVar.setString(2, tingkatan);
            psVar.setString(3, jurusan);
            psVar.setString(4, wali);
            psVar.setString(5, kodeKelas);
            psVar.execute();
            
            JOptionPane.showMessageDialog(null, "Data berhasil diubah");
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, "Data gagal diubah" + sQLException.getMessage());
        }
        
        load_table_kelas();
        reset();
    }//GEN-LAST:event_buttonUbahActionPerformed

    private void buttonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonResetActionPerformed
        // TODO add your handling code here:
        reset();
    }//GEN-LAST:event_buttonResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonHapus;
    private javax.swing.JButton buttonReset;
    private javax.swing.JButton buttonTambah;
    private javax.swing.JButton buttonUbah;
    private javax.swing.JComboBox<String> cbJurusan;
    private javax.swing.JComboBox<String> cbTingkatan;
    private javax.swing.JComboBox<String> cbWaliKelas;
    private javax.swing.JLabel closeLabel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelKelas;
    private javax.swing.JTextField txtKodeKelas;
    private javax.swing.JTextField txtNamaKelas;
    // End of variables declaration//GEN-END:variables
}
