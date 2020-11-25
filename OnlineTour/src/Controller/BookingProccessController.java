package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.BookingModel;
import Model.UserModel;
import Service.BookingService;
import Service.UserService;

/**
 * Servlet implementation class BookingProccessController
 */
@WebServlet("/BookingProccessController")
public class BookingProccessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookingProccessController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		Map<String,String[]> reqobj = request.getParameterMap();
		String btn = request.getParameter("btn");
		switch(btn)
		{
		case "newPhoneNumber":
			int userId = Integer.parseInt(reqobj.get("userId")[0]);
			int tourId = Integer.parseInt(reqobj.get("tourId")[0]);
			UserModel umobj = new UserModel();
			umobj.setPhone(reqobj.get("newPhone")[0]);
			UserService usobj = new UserService();
			if(usobj.phoneNumberUpdate(umobj,userId))
			{
				response.sendRedirect("User/bookingProccess.jsp?tour_id="+tourId+"");
				
			}
			
			break;
			
		case "booking":
			BookingModel bmobj = new BookingModel();
			int tour_Id = Integer.parseInt(reqobj.get("tourId")[0]);
			int user_Id = Integer.parseInt(reqobj.get("userId")[0]);
			bmobj.setTour_id(Integer.parseInt(reqobj.get("tourId")[0]));
			bmobj.setUserId(Integer.parseInt(reqobj.get("userId")[0]));
			bmobj.setAdult(Integer.parseInt(reqobj.get("adult")[0]));
			bmobj.setChild(Integer.parseInt(reqobj.get("child")[0]));
			bmobj.setCitizen(Integer.parseInt(reqobj.get("citizen")[0]));
			bmobj.setTotal_member(Integer.parseInt(reqobj.get("total_member")[0]));
			float amount =  (Float.parseFloat(reqobj.get("price")[0]))*(Integer.parseInt(reqobj.get("total_member")[0]));
			BookingService bsobj = new BookingService();
			if(bsobj.bookingRequest(bmobj))
			{
				RequestDispatcher rd = request.getRequestDispatcher("User/payment.jsp?amount="+amount+"&tourId="+tour_Id+"&userId="+user_Id+"");
				rd.forward(request, response);
	
			}
			
			
			break;
		}
	}

}
