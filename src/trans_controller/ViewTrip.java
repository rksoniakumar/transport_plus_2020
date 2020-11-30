package trans_controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trans_dao.DriverDao;
import trans_dao.TripDao;
import trans_model.Driver;
import trans_model.Trip;

/**
 * Servlet implementation class ViewTrip
 */
@WebServlet(name = "viewTrip", urlPatterns = { "/viewTrip" })
public class ViewTrip extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewTrip() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String trip_id = request.getParameter("tripid");
		System.out.println("Trip ID value entered by user :: "+trip_id);
		
		ArrayList<Trip> tripDetails = new ArrayList<Trip>();
		tripDetails = TripDao.getTripDetails(Integer.parseInt(trip_id));
		  request.setAttribute("tripDetails", tripDetails);
		  System.out.println("TripDetails data size: "+tripDetails.size());
		/***********/
		
			        //forward to the desired view
			        //this is the real JSP that has the content to display to user
		
			        request.getRequestDispatcher("/viewTrip.jsp").forward(request, response);
	}

}
