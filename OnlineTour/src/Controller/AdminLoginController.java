package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.AdminModel;
import Service.AdminService;

/**
 * Servlet implementation class AdminLoginController
 */
@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminLoginController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Map<String,String[]> reqobj = request.getParameterMap();
		if(reqobj.get("task")[0].equals("login"))
		{
			AdminModel amobj = new AdminModel();
			amobj.setAdmin_email(reqobj.get("email")[0]);
			amobj.setAdmin_password(reqobj.get("password")[0]);
			
			AdminService asobj = new AdminService();
			if(asobj.adminLogin(amobj))
			{
				HttpSession session = request.getSession();
				session.setAttribute("admin_email", reqobj.get("email")[0]);
				response.sendRedirect("Admin/AdminDashboard.jsp");
			}
			else
			{
				out.println("Error");
			}
			
		}
		
	}

}
