package Controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import Model.RequestTourModel;
import Service.AgentService;

/**
 * Servlet implementation class AcceptAndRejectOperation
 */
@WebServlet("/AcceptAndRejectOperation")
public class AcceptAndRejectOperation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptAndRejectOperation() {
        super();
        // TODO Auto-generated constructor stub
    }
   	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		Map<String, String[]> reqobj = request.getParameterMap(); 
		String btn = request.getParameter("btn");
		int registerId = Integer.parseInt(reqobj.get("registerId")[0]);
		AgentService asobj = null;
		switch(btn)
		{
		case "accept":
			RequestTourModel rmobj = new RequestTourModel();
			rmobj.setAgent_id(Integer.parseInt(reqobj.get("agentId")[0]));
			rmobj.setImage(reqobj.get("image")[0]);
			rmobj.setTourname(reqobj.get("tname")[0]);
			rmobj.setPrice(Float.parseFloat(reqobj.get("price")[0]));
			rmobj.setCity(reqobj.get("city")[0]);
			rmobj.setPincode(reqobj.get("pincode")[0]);
			rmobj.setDay(reqobj.get("day")[0]);
			rmobj.setPlace(reqobj.get("state")[0]);
			rmobj.setHname(reqobj.get("hname")[0]);
			rmobj.setHaddress(reqobj.get("haddress")[0]);
			rmobj.setHpincode(reqobj.get("hpincode")[0]);
			rmobj.setHotel_manager_name(reqobj.get("mangername")[0]);
			rmobj.setHphone(reqobj.get("hphone")[0]);
			rmobj.setDescribeTour(reqobj.get("tdescription")[0]);
			asobj = new AgentService();
			if(asobj.insertTour(rmobj))
			{
				if(asobj.deleteRequestTour(registerId))
				{
					response.sendRedirect("Admin/AdminDashboard.jsp");
				}
				else
				{
					out.println("Error");
				}
			}
						
			break;
			
		case "reject":
			 asobj = new AgentService();
			 if(asobj.deleteRequestTour(registerId))
			 {
				 response.sendRedirect("Admin/AdminDashboard.jsp");
			 }
			
			break;
		
		}
	}

}
