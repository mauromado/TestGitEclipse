package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.eclipse.jdt.internal.compiler.problem.AbortCompilation;

public class DbConnection {
	private Connection connection;
	private String userDirString = System.getProperty("user.dir");
	private String workSpaceDirString = "WSBucci";
	private String projectNameString = "PctoBucciNew";
	private String dbName = "UsersDB.db";
	
	
	private Connection connect() {
	    try {
	      Class.forName("org.sqlite.JDBC");
	      
	      //Capire come fare cercare il db all'interno del progetto
	      //connection =  DriverManager.getConnection("jdbc:sqlite:C:/Users/ADMIN/Desktop/WSBucci/FirstDb.db");
	      connection =  DriverManager.getConnection("jdbc:sqlite:" + userDirString + "/"+workSpaceDirString+"/"+projectNameString+"/"+dbName);
	      System.out.println("Connected!");
	    } catch (ClassNotFoundException | SQLException e ) {
	      // TODO Auto-generated catch block
	      System.out.println(e+"");
	    }
	    
	    return connection; 
	  }
	
	public void insert(String nome, String cognome, String paese) {
        String sql = "INSERT INTO Users(nome,cognome,paese) VALUES(?,?,?)";

        try (
        	Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nome);
            pstmt.setString(2, cognome);
            pstmt.setString(3, paese);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	public void delete(int id) {
        String sql = "DELETE FROM Users WHERE id = ?";

        try (
        	Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	
	public void close() {
		try {
			this.connection.close();
			System.out.println("Disconnected!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
