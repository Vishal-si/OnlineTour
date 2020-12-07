package Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.AgentModel;
import Service.AgentService;

/**
 * Servlet implementation class ChangePassword
 */
@WebServlet("/ChangePassword")
public class ChangePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
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
		String password = null;
		AgentModel amobj =null;
		AgentService asobj = new AgentService();
		
		if(reqobj.get("task")[0].equals("agentPassword"))
		{
			if(reqobj.get("new_password")[0].equals(reqobj.get("confirm_password")[0]))
			{
				out.println(reqobj.get("email")[0]);
				List<AgentModel> alist = asobj.getPasswordByEmail(reqobj.get("email")[0]);
				for(AgentModel amobj1:alist)
				{
					password = amobj1.getPassword();
				}
				if(reqobj.get("old_password")[0].equals(password))
				{
					amobj = new AgentModel();
					amobj.setPassword(reqobj.get("new_password")[0]);
					if(asobj.changePassword(reqobj.get("email")[0], amobj));
					{
						response.sendRedirect("Agent/agentDashboard.jsp");
					}
						
				}
				else
				{
					out.println("Old Password does not match");
				}
				
				
			}
			else
			{
				out.println("New Password and Confirm Password do not match");
			}
				
			
		}
		else
		{
			out.println("Error");
		}
	}

}
