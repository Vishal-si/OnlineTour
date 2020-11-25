package Controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
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

import Model.AgentModel;
import Service.AgentService;

/**
 * Servlet implementation class AgentController
 */
@WebServlet("/AgentController")
public class AgentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AgentController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    //Now first task create some type of reference variable and variable
    
    private  boolean isMultiPath;
    private String uploadPath;
    private int maxMemSize;
    private int maxFileSize;
    private File file;
    private List<String> content_type_list = null;
    
    public void init()
	{
		ServletContext context = getServletContext();
		uploadPath = context.getInitParameter("UPLOAD_PATH");
		maxFileSize = Integer.parseInt(context.getInitParameter("MAX_FILE_SIZE"));
		maxMemSize = Integer.parseInt(context.getInitParameter("MAX_MEM_SIZE"));
		content_type_list = new ArrayList<String>();
		content_type_list.add("image/jpeg");
		content_type_list.add("image/gif");
		content_type_list.add("image/png");
		content_type_list.add("image/x-png");
		
	}
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		Map<String, String> reqobj = new HashMap<String,String>();
		PrintWriter out = response.getWriter();
		isMultiPath = ServletFileUpload.isMultipartContent(request);
		if(!isMultiPath)
		{
			out.println("<DOCTYPE HTML>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>BharatMart</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h3>Image Error</h3>");
			out.println("<p>Image Error generate</p>");
			out.println("</body>");
			out.println("</html>");
		}
		String newFileName = "";
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(maxMemSize);
		factory.setRepository(new File("\\tmp"));
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(maxFileSize);
		
		try 
		
		{
			List<FileItem>fileItems = upload.parseRequest(request);
			Iterator<FileItem> i = fileItems.iterator();
			 while ( i.hasNext () ) {
		            FileItem fi = (FileItem)i.next();
		            if ( fi.isFormField () ) {
		            	System.out.println(fi.getFieldName());
		            	System.out.println(fi.getString());
		            	reqobj.put(fi.getFieldName(), fi.getString());
		            } else {
		               // Get the uploaded file parameters
		            	System.out.println(fi);
		               String fieldName = fi.getFieldName();
		               System.out.println("fieldName : " + fieldName);
		               String fileName = fi.getName();
		               System.out.println("fileName : " + fileName);
		               String contentType = fi.getContentType();
		               System.out.println("contentType : " + contentType);
		               
		               if(!content_type_list.contains(contentType)) {
		            	   System.out.println("Error: NOT AN IMAGE");
		            	   out.println("Error: NOT AN IMAGE");
		            	   return;
		               }
		               boolean isInMemory = fi.isInMemory();
		               System.out.println("isInMemory : " + isInMemory);
		               long sizeInBytes = fi.getSize();
		               System.out.println("sizeInBytes : " + sizeInBytes);
		               
		               if(sizeInBytes > maxFileSize) {
		            	   System.out.println("Error: File Size Exceeds Limit");
		            	   out.println("Error: File Size Exceeds Limit");
		            	   return;
		               }
		               
		            	   newFileName = reqobj.get("email")+"_photo.jpg";
		    
		               
		               // Write the file
		               file = new File(uploadPath + newFileName);
		               
		               fi.write( file ) ;
		               System.out.println("Uploaded Filename: " + newFileName);
		               reqobj.put(fi.getFieldName(), newFileName);
		            }
		         }
	    	AgentModel amobj = new AgentModel();
		    amobj.setName(reqobj.get("name"));
		    amobj.setEmail(reqobj.get("email"));
		    amobj.setPassword(reqobj.get("password"));
		    amobj.setPhone(reqobj.get("phone"));
		    amobj.setAge(Integer.parseInt((reqobj.get("age"))));
		    amobj.setSaddress(reqobj.get("saddress"));
		    amobj.setSname(reqobj.get("sname"));
		    amobj.setSphoto(reqobj.get("sphoto"));
		    AgentService asobj = new AgentService();
		    if(asobj.createAgent(amobj))
		    {
		    	out.println("Submit");
		    }
		    else
		    {
		    	out.println("Failed");
		    }
	    }
	    catch(Exception e)
	    {
	    	System.out.println(e.getMessage());
	    	System.out.println(this.getClass().getName());
	    }
	    
	    
	   
	}

}
