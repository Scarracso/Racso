/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Popup;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import Koneksi.Database;
import perpustakaanproject.Pengembalian_buku;
/**
 *
 * @author oscar
 */
public class popuppeminjaman extends javax.swing.JFrame {
private Connection conn = new Database().connect();
private DefaultTableModel tabmode;
public Pengembalian_buku pinjam1 = null;


    public popuppeminjaman() {
        initComponents();
        datatable();
    }
public void removeTable(){
    try{
         for(int t=tabmode.getRowCount();t>0;t--) {tabmode.removeRow(0);}    }
    catch(Exception ex){ System.out.println(ex);  } }


protected void datatable(){
      removeTable();
        int jumdata=0;
     Object[] Baris ={"No Pinjam,","Tanggal Peminjaman","Tanggal Pengembalian","Jumlah Peminjaman","Nomor Buku","Judul Buku","Nomor Anggota","Nama Anggota"};
    tabmode = new DefaultTableModel(null, Baris);
    Table.setModel(tabmode);
    String sql = "select * from data_peminjaman";
    try{
        java.sql.Statement stat = conn.createStatement();
        ResultSet hasil = stat.executeQuery(sql);
         while (hasil.next()){
            String a    = hasil.getString("no_pinjam");
            String b    = hasil.getString("tglpinjam");
            String c    = hasil.getString("tglkembali");
            String d    = hasil.getString("jml_pinjam");
            String e    = hasil.getString("no_buku");
            String f    = hasil.getString("jdl_buku");
            String g    = hasil.getString("no_ang");
            String h    = hasil.getString("nama_ang");
            
           
            String data[]={a,b,c,d,e,f,g,h};
            tabmode.addRow(data);
            jumdata=jumdata+1;
            }
        }
    
    catch(SQLException sqle){
        jumdata=0;
        JOptionPane.showMessageDialog(null,"Data Gagal Masuk Tabel"+sqle);
        }
    
 jml.setText(jumdata+  " Data Pinjam");
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Table = new javax.swing.JTable();
        jml = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Table.setModel(new javax.swing.table.DefaultTableModel(
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
        Table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(Table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 252, 900, 250));

        jml.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jml.setForeground(new java.awt.Color(255, 255, 255));
        jml.setText("Jml");
        getContentPane().add(jml, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 230, -1, -1));

        jPanel1.setBackground(new java.awt.Color(51, 255, 51));

        jLabel2.setFont(new java.awt.Font("Goudy Stout", 1, 24)); // NOI18N
        jLabel2.setText("DATA PEMINJAMAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(32, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 510, 80));

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/icons-back.png"))); // NOI18N
        jButton1.setText("KEMBALI");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 40, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Gambar/Background popup.jpg"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableMouseClicked
        // TODO add your handling code here:
        int tebel1 = Table.getSelectedRow();
pinjam1.nomorpinjam = Table.getValueAt(tebel1, 0).toString();
pinjam1.tgl_kembali = Table.getValueAt(tebel1, 2).toString();
pinjam1.nomorbuku = Table.getValueAt(tebel1, 4).toString();
pinjam1.judulbuku = Table.getValueAt(tebel1, 5).toString();
pinjam1.nomoranggota = Table.getValueAt(tebel1, 6).toString();
pinjam1.namaanggota = Table.getValueAt(tebel1, 7).toString();
pinjam1.jmlahpinjam = Table.getValueAt(tebel1, 3).toString();
pinjam1.popuppeminjaman();
this.dispose();
    }//GEN-LAST:event_TableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(popuppeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(popuppeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(popuppeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(popuppeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new popuppeminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Table;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jml;
    // End of variables declaration//GEN-END:variables
}
