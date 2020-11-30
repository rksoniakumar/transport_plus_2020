package trans_controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import trans_dao.DriverDao;
import trans_model.Driver;

/**
 * Servlet implementation class DriverDetails
 */
@WebServlet("/driverDetails")
public class DriverDetails extends HttpServlet {
//	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DriverDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
			ArrayList<Driver> drivers = new ArrayList<>();
		  drivers = DriverDao.getDrivers(0);
		  request.setAttribute("driverList", drivers);
		  System.out.println("Drivers data size: "+drivers.size());
		/***********/
		
			        //forward to the desired view
			        //this is the real JSP that has the content to display to user
			        request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
