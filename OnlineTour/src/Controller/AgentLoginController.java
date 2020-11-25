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

import Model.AgentModel;
import Service.AgentService;

/**
 * Servlet implementation class AgentLoginController
 */
@WebServlet("/AgentLoginController")
public class AgentLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AgentLoginController() {
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
		AgentModel amobj = new AgentModel();
		amobj.setEmail(reqobj.get("email")[0]);
		amobj.setPassword(reqobj.get("password")[0]);
		AgentService asobj = new AgentService();
		if(asobj.login(amobj))
		{
			HttpSession session = request.getSession();
			session.setAttribute("aemail", reqobj.get("email")[0]);
			response.sendRedirect("Agent/agentDashboard.jsp");
		}
		else
		{
			out.println("Failed");
		}
		
	}

}
