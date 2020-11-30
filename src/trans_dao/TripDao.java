package trans_dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import trans_db.TransConnection;
import trans_model.Driver;
import trans_model.Trip;

public class TripDao {
	
	public int createTrip(ArrayList<Trip> trip) {
		int tripId = 0;
		Connection con = null;
		TransConnection tc = new TransConnection();
		
		 try {
			con=TransConnection.getDbConnection();
if (trip != null ) {
	for (int i=0; i<trip.size(); i++){
		int driverID = trip.get(i).getDriver_id();
		String fromLoc = trip.get(i).getFrom_loc();
		String toLoc = trip.get(i).getTo_loc();
		
		System.out.println("Inside Insert Data: ");
		  //Write SQL query to insert data
		  PreparedStatement pst = con.prepareStatement("insert into transplus.trip  (driver_id,from_loc,to_loc) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
//		  pst.setInt(1,Integer.parseInt(tripID));
		  pst.setInt(1,driverID);
		  pst.setString(2, fromLoc);
		  pst.setString(3, toLoc);
//		  System.out.println("tripID : "+tripID);
		  System.out.println("driverID : "+driverID);
		  System.out.println("fromLoc : "+fromLoc);
		  System.out.println("toLoc : "+toLoc);

		  
		  int affectedRows = pst.executeUpdate();
		  System.out.println("Data inserted successfully affectedRows value : "+affectedRows);
		  
		  if (affectedRows == 0) {
	            throw new SQLException("Creating user failed, no rows affected.");
	        }

	        try (ResultSet generatedKeys = pst.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	            	tripId = (int) generatedKeys.getLong(1);
	            }
	            else {
	                throw new SQLException("Creating trip failed, no ID obtained.");
	            }
    }
	
			  //Check if values are saved successfully or not
//			  ArrayList<Driver> drivers = new ArrayList<>();
//			  drivers = Driver_DAO.getDrivers();
//			  System.out.println("Drivers data size: "+drivers.size());
			
			
//			if(drivers.size() > 0) {
//				writer.println("<h1>Driver Details :: Driver ID  " + drivers.get(0).getDriver_id() + "Driver First Name  " +drivers.get(0).getDriver_first_name() +"Driver Last Name  "+drivers.get(0).getDriver_last_name()+ "</h1>");
//					
//			}
//				else
//					writer.println("<h1>Driver Values not fetched </h1>");
				
	
}
}

		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			 System.out.println("NumberFormatException 222 : "+e);
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("SQLException 222 : "+e);
			e.printStackTrace();
		
		}
		 System.out.println("Trip ID created :: *** :: " +tripId);
		return tripId;
		
	}
	
	public static ArrayList<Trip> getTripDetails(int tripID) {
		ArrayList<Trip> tripList = new ArrayList<Trip>();
		Connection con = null;
  		
	  	//TransConnection tc = new TransConnection();
	
	  		 try {
	  			con=TransConnection.getDbConnection();
	  			  System.out.println("con in Trip dao : "+con);
	  			  //Write SQL query to insert data
	  			  PreparedStatement pst = con.prepareStatement("select * from transplus.trip where trip_id="+tripID);
	  			  ResultSet rs = pst.executeQuery();
	  			  System.out.println("Resultsize : "+rs.getFetchSize());
	  	          while(rs.next()) {
	  	              Trip d = new Trip();
	  	              d.setTrip_id(rs.getInt("trip_id"));
	  	            System.out.println("trip_id : "+rs.getInt("trip_id"));   	  	          
	  	          d.setFrom_loc(rs.getString("from_loc"));
	  	            System.out.println("from_loc : "+rs.getString("from_loc"));
	  	              d.setTo_loc(rs.getString("to_loc"));
	  	            System.out.println("to_loc : "+rs.getString("to_loc"));
	  	            d.setCreated_by(rs.getString("created_by"));
	  	          System.out.println("created_by : "+rs.getString("created_by"));
	  	              d.setCreated_date(rs.getString("created_date"));
	  	            System.out.println("created_date : "+rs.getString("created_date"));
	  	            d.setLast_updated_by(rs.getString("last_updated_by"));
	  	          System.out.println("last_updated_by : "+rs.getString("last_updated_by"));
	  	              d.setLast_updated_date(rs.getString("last_updated_date"));
	  	            System.out.println("last_updated_date : "+rs.getString("last_updated_date"));
	  	            // to fetch driver details
	  	            if(rs.getInt("driver_id") != 0)
	  	            {
	  	            	d.setDriver_id(rs.getInt("driver_id"));
	  	            	ArrayList<Driver> driver = new ArrayList<Driver>();
	  	            	driver = DriverDao.getDrivers(rs.getInt("driver_id"));
	  	            	d.setDriver(driver);
	  	            	 System.out.println("driver array size in trip_details : "+driver.size());
	  	            }
	  	              d.setTrip_details(rs.getString("trip_details"));
	  	            System.out.println("trip_details : "+rs.getString("trip_details"));
	  	            d.setComments(rs.getString("comments"));
	  	          System.out.println("comments : "+rs.getString("comments"));
	  	              	  	             
	  	          tripList.add(d);
	  			  
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
		  		System.out.println("TripList size in dao : "+tripList.size());
	  		return tripList;
	}
}
