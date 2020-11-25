package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.UserModel;
import Service.UserService;


/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
		//doGet(request, response);
		
		PrintWriter out = response.getWriter();
		Map<String,String[]> reqobj = request.getParameterMap();
		UserModel uobj = new UserModel();
		UserService usobj = new UserService();
		if(reqobj.get("task")[0].equals("login"))
		{
			uobj.setEmail(reqobj.get("email")[0]);
			uobj.setPassword(reqobj.get("password")[0]);
			if(usobj.login(uobj))
			{
				HttpSession session = request.getSession();
				session.setAttribute("uemail",reqobj.get("email")[0]);
				response.sendRedirect("User/userDashboard.jsp");
			}
			else
			{
				out.println("Failed");
			}
			
			
			
		}
		else if(reqobj.get("task")[0].equals("create"))
		{
			uobj.setName(reqobj.get("name")[0]);
			uobj.setEmail(reqobj.get("email")[0]);
			uobj.setPassword(reqobj.get("password")[0]);
			uobj.setDob(Date.valueOf(reqobj.get("date")[0]));
			uobj.setPhone(reqobj.get("phone")[0]);
			if(usobj.createAccount(uobj))
			{
				out.println("User/login.jsp");
			}
			else
			{
				out.println("Failed");
			}
			
		}
		else
		{
			response.sendRedirect("User/login.jsp");
		}
	}

}
