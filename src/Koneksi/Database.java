
package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class Database {
    
    private Connection koneksi;
    public Connection con;
    public Statement stm;
public Connection connect(){
    try{ Class.forName("com.mysql.cj.jdbc.Driver");
    System.out.println("koneksi berhasil");
    }
    catch (ClassNotFoundException ex){
        System.out.println("koneksi Gagal"+ex);
    }
    String url="jdbc:mysql://localhost/perpustakaan";
    try{koneksi = DriverManager.getConnection(url,"root","");
    System.out.print("berhasil koneksi database");
    }
    catch(SQLException ex){
        System.out.print("gagal koneksi database");
       
    }
    return koneksi;
}
}
