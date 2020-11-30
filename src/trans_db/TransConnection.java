package trans_db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TransConnection {
	static Connection conn = null;
	
//	public static void main(String[] args) {
//		 System.out.println("Connection 11 : "+conn);
//		getDbConnection();
//		if (conn != null)
//			try {
//				conn.close();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	}
	
	public static  Connection getDbConnection() {
		 System.out.println("Connection 222 : "+conn);
		
	try {
        
		
		//Connection con=DriverManager.getConnection(  "jdbc:mysql://localhost:port/databasename","un","pwd");  
      
        Class.forName("com.mysql.cj.jdbc.Driver");
       // mysql@127.0.0.1:3306@192.241.131.250
        System.out.println("Connection 333 : "+conn);
//         conn = DriverManager.getConnection("jdbc:mysql://192.241.131.250:3306/transportplus","root","laljit31");
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","transplus");
         System.out.println("Connection: "+conn);
    } catch (Exception ex) {
        // handle the error
    	 System.out.println("Connection Exception : "+ex);
    }
	return conn;
	}

}
