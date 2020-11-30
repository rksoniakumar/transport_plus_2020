package trans_controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import trans_dao.TripDao;
import trans_email_service.SendEmail;
import trans_model.Trip;

/**
 * Servlet implementation class CreateTrip
 */
@WebServlet("/createTrip")
public class CreateTrip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTrip() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		String driver_id = request.getParameter("driver");
		String fromLoc = request.getParameter("from_loc");
		String toLoc = request.getParameter("to_loc");
		int tripId = 0;
		ArrayList<Trip> createTripList = new ArrayList<Trip>();
		Trip trip = new Trip();
		TripDao tripdao = new TripDao();
		SendEmail sendemail = new SendEmail();
		System.out.println("driver_id : " +driver_id);
		System.out.println("fromLoc : " +fromLoc);
		System.out.println("toLoc : " +toLoc);
		if (driver_id != null)
				trip.setDriver_id(Integer.parseInt(driver_id));
		if(fromLoc != null)
				trip.setFrom_loc(fromLoc);
		if(toLoc != null)
			trip.setTo_loc(toLoc);
		
		createTripList.add(trip);
		
		System.out.println("CreateTripList Size in createtrip: " +createTripList.size());
		if (createTripList != null) {
			tripId = tripdao.createTrip(createTripList);
			if(tripId != 0) {
				
				SendEmail.send("rksoniakumar@gmail.com","wziwauaaxijvblhl","rksoniakumar@gmail.com","Trip ID "+tripId +" created","Trip ID "+tripId +" created successfully");  
			     
			}
		}
		
		  System.out.println("Returned tripId value: "+tripId);
//		  HttpSession session = request.getSession(true);
//		    session.setAttribute("tripId1", tripId);
		  request.setAttribute("tripId", tripId);
		  request.getRequestDispatcher("/index.jsp").forward(request, response);
//		  request.getRequestDispatcher(session.getAttribute("jspName").toString()).forward(request,response);
	}
//	
	

}
