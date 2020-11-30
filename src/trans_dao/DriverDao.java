package trans_dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import trans_db.TransConnection;
import trans_model.Driver;

public class DriverDao {
	  	public static ArrayList<Driver> getDrivers(int driverID){

	  		Connection con = null;
	  		 PreparedStatement pst = null;
	  		
	  	//TransConnection tc = new TransConnection();
	  	ArrayList<Driver> drivers = new ArrayList<>();
	  		
	  		 try {
	  			con=TransConnection.getDbConnection();
	  			  System.out.println("con in driver dao : "+con);
	  			  //Write SQL query to insert data
	  			  if(driverID !=0)
	  				pst = con.prepareStatement("select * from transplus.driver where driver_id = "+driverID);
	  			  else
	  			  pst = con.prepareStatement("select * from transplus.driver");
	  			  ResultSet rs = pst.executeQuery();
	  			  System.out.println("Resultsize : "+rs.getFetchSize());
	  	          while(rs.next()) {
	  	              Driver d = new Driver();
	  	              d.setDriverId(rs.getInt("driver_id"));
	  	            System.out.println("driver_id : "+rs.getInt("driver_id"));
	  	              d.setDriverFirstName(rs.getString("driver_first_name"));
	  	            System.out.println("driver_first_name : "+rs.getString("driver_first_name"));
	  	              d.setDriverLastName(rs.getString("driver_last_name"));
	  	            System.out.println("driver_last_name : "+rs.getString("driver_last_name"));
	  	            d.setAddress1(rs.getString("address_1"));
	  	          System.out.println("address_1 : "+rs.getString("address_1"));
	  	              d.setAddress2(rs.getString("address_2"));
	  	            System.out.println("address_2 : "+rs.getString("address_2"));
	  	            d.setCity(rs.getString("city"));
	  	          System.out.println("city : "+rs.getString("city"));
	  	              d.setState(rs.getString("state"));
	  	            System.out.println("state : "+rs.getString("state"));
	  	            
	  	              d.setCountry(rs.getString("country"));
	  	            System.out.println("country : "+rs.getString("country"));
	  	            d.setContactNo(rs.getString("contact_no"));
	  	          System.out.println("contact_no : "+rs.getString("contact_no"));
	  	              d.setAlternateContactNo(rs.getString("alternate_contact_no"));
	  	            System.out.println("alternate_contact_no : "+rs.getString("alternate_contact_no"));
	  	              d.setEmailId(rs.getString("email_id"));
	  	            System.out.println("email_id : "+rs.getString("email_id"));
	  	             
	  	              
	  	             
//	  	              d.setZipcode(rs.getString("driver_last_name"));
	  	              	  	             
	  	          drivers.add(d);
	  			  
	  			  System.out.println("Data fetched successfully: ");
	  			  //Check if values are saved successfully or not
	  			  
	  			
	  			
	  		}
	  		 }catch (NumberFormatException e) {
	  			// TODO Auto-generated catch block
	  			 System.out.println("NumberFormatException 222 : "+e);
	  			e.printStackTrace();
	  		} catch (SQLException e) {
	  			// TODO Auto-generated catch block
	  			System.out.println("SQLException 222 : "+e);
	  			e.printStackTrace();
	  		} 
	  		System.out.println("drivers size in dao : "+drivers.size());
	  		 return drivers;

	  	}
	   
	   public void createDriver(Driver driver) {
		   
	   }
	   public void updateDriver(Driver driver) {
		   
	   }
	   public void deleteDriver(Driver driver) {
	   
 }
}
