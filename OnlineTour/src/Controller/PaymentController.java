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

import Model.PaymentModel;
import Service.UserService;

/**
 * Servlet implementation class PaymentController
 */
@WebServlet("/PaymentController")
public class PaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PaymentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();
		Map<String, String[]> reqobj = request.getParameterMap();
		PaymentModel pmobj = new PaymentModel();
		pmobj.setUserId(Integer.parseInt(reqobj.get("userId")[0]));
		pmobj.setTourId(Integer.parseInt(reqobj.get("tourId")[0]));
		pmobj.setPaymentType(reqobj.get("payment")[0]);
		pmobj.setAmount(Float.parseFloat(reqobj.get("amount")[0]));
		UserService usobj = new UserService();
		if(usobj.paymentPay(pmobj))
		{
			response.sendRedirect("User/userDashboard.jsp");
		}
		else
		{
			out.println("Error");
		}
	
			
		
		
	}

}
