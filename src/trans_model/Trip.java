package trans_model;

import java.util.ArrayList;

public class Trip {
	int trip_id;
	int driver_id;  
	String from_loc; 
	String to_loc; 
	String created_by;
	String created_date; 
	String last_updated_by;
	String last_updated_date; 
	String trip_details;
	String comments;
	ArrayList<Driver> driver;
	
	
	public int getTrip_id() {
		return trip_id;
	}
	public void setTrip_id(int trip_id) {
		this.trip_id = trip_id;
	}
	public int getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(int driver_id) {
		this.driver_id = driver_id;
	}
	public String getFrom_loc() {
		return from_loc;
	}
	public void setFrom_loc(String from_loc) {
		this.from_loc = from_loc;
	}
	public String getTo_loc() {
		return to_loc;
	}
	public void setTo_loc(String to_loc) {
		this.to_loc = to_loc;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	public String getLast_updated_by() {
		return last_updated_by;
	}
	public void setLast_updated_by(String last_updated_by) {
		this.last_updated_by = last_updated_by;
	}
	public String getLast_updated_date() {
		return last_updated_date;
	}
	public void setLast_updated_date(String last_updated_date) {
		this.last_updated_date = last_updated_date;
	}
	public String getTrip_details() {
		return trip_details;
	}
	public void setTrip_details(String trip_details) {
		this.trip_details = trip_details;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}

	public ArrayList<Driver> getDriver() {
		return driver;
	}
	public void setDriver(ArrayList<Driver> driver) {
		this.driver = driver;
	}
}
