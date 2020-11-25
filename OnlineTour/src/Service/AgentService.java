package Service;

import ConnectionManagement.ConnectionClass;
import Model.AgentModel;
import Model.RequestTourModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AgentService extends ConnectionClass
{
	
	//FirstMethod
	public boolean createAgent(AgentModel amobj)
	{
		String query= "INSERT INTO agent(name,email,password,age,phone,shop_name,shop_address,agent_image) VALUE(?,?,?,?,?,?,?,?)";
		try
		{
			Connection conn = getConn();
			PreparedStatement pst= conn.prepareStatement(query);
			pst.setString(1,amobj.getName());
			pst.setString(2,amobj.getEmail());
			pst.setString(3,amobj.getPassword());
			pst.setInt(4,amobj.getAge());
			pst.setString(5,amobj.getPhone());
			pst.setString(6,amobj.getSname());
			pst.setString(7,amobj.getSaddress());
			pst.setString(8,amobj.getSphoto());
			int x = pst.executeUpdate();
			if(x>0)
			{
				return true;
			}
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return false;
	}
	
	
	//SecondMethod
	public boolean login(AgentModel amobj)
	{
		String query="SELECT *FROM agent WHERE email = ? AND password = ?";
		
		try
		{
			Connection conn = getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,amobj.getEmail());
			pst.setString(2,amobj.getPassword());
			ResultSet rs = pst.executeQuery();
			if(rs.next())
			{
				return true;
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return false;
	}
	
	//ThridMethod
	public List<AgentModel> getIdByEmail(String aemail)
	{
		List<AgentModel> alist = new ArrayList<AgentModel>();
		try
		{
			AgentModel amobj = new AgentModel();
			String query = "SELECT id FROM agent WHERE email =?";
			Connection conn = getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,aemail);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				amobj.setId(rs.getInt("id"));
				alist.add(amobj);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return alist;
	}
	
	
	//FouthMethod
	public boolean requestTourSubmit(RequestTourModel rtmobj)
	{
		String query="INSERT INTO requesttour(agent_id,image,shop_name,tour_name,place,city,pincode,day,price,hotel_name,hotel_address,hotel_manager,hotel_pincode,hotel_phone,description)"
				+ "VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try
		{
			Connection conn = getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1,rtmobj.getAgent_id());
			pst.setString(2,rtmobj.getImage());
			pst.setString(3,rtmobj.getSname());
			pst.setString(4,rtmobj.getTourname());
			pst.setString(5,rtmobj.getPlace());
			pst.setString(6,rtmobj.getCity());
			pst.setString(7,rtmobj.getPincode());
			pst.setString(8,rtmobj.getDay());
			pst.setFloat(9,rtmobj.getPrice());
			pst.setString(10,rtmobj.getHname());
			pst.setString(11,rtmobj.getHaddress());
			pst.setString(12,rtmobj.getHotel_manager_name());
			pst.setString(13,rtmobj.getHpincode());
			pst.setString(14,rtmobj.getHphone());
			pst.setString(15,rtmobj.getDescribeTour());
			
			int x= pst.executeUpdate();
			if(x>0)
			{
				return true;
			}
		}

		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return false;
	}
	public List<RequestTourModel> getRequestById( int requestId)
	{
		List<RequestTourModel> tlist = new ArrayList<RequestTourModel>();
		String query ="SELECT *FROM requesttour WHERE id = ?";
		try
		{
			RequestTourModel rmobj = new RequestTourModel();
			Connection conn = getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1,requestId);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				rmobj.setReq_id(rs.getInt("id"));
				rmobj.setAgent_id(rs.getInt("agent_id"));
				rmobj.setSname(rs.getString("shop_name"));
				rmobj.setTourname(rs.getString("tour_name"));
				rmobj.setPlace(rs.getString("place"));
				rmobj.setCity(rs.getString("city"));
				rmobj.setPincode(rs.getString("pincode"));
				rmobj.setDay(rs.getString("day"));
				rmobj.setPrice(rs.getFloat("price"));
				rmobj.setHname(rs.getString("hotel_name"));
				rmobj.setHaddress(rs.getString("hotel_address"));
				rmobj.setHotel_manager_name(rs.getString("hotel_manager"));
				rmobj.setHpincode(rs.getString("hotel_pincode"));
				rmobj.setHphone(rs.getString("hotel_phone"));
				rmobj.setDescribeTour(rs.getString("description"));
				rmobj.setImage(rs.getString("image"));
				tlist.add(rmobj);
			}
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return tlist;
	}
	
	public boolean insertTour(RequestTourModel rmobj)
	{
		String query="INSERT INTO tour(agent_id,image,tour_name,place,city,pincode,day,price,hotel_name,hotel_address,hotel_manager,hotel_pincode,hotel_phone,description)"
				+ "VALUE(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		try
		{
			Connection conn = getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1,rmobj.getAgent_id());
			pst.setString(2,rmobj.getImage());
			pst.setString(3,rmobj.getTourname());
			pst.setString(4,rmobj.getPlace());
			pst.setString(5,rmobj.getCity());
			pst.setString(6,rmobj.getPincode());
			pst.setString(7,rmobj.getDay());
			pst.setFloat(8,rmobj.getPrice());
			pst.setString(9,rmobj.getHname());
			pst.setString(10,rmobj.getHaddress());
			pst.setString(11,rmobj.getHotel_manager_name());
			pst.setString(12,rmobj.getHpincode());
			pst.setString(13,rmobj.getHphone());
			pst.setString(14,rmobj.getDescribeTour());
			
			int x= pst.executeUpdate();
			if(x>0)
			{
				return true;
			}
		}

		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return false;
	}
	
	public boolean deleteRequestTour( int request_id)
	{
		String query="DELETE FROM requesttour WHERE id = ?";
		try
		{
			Connection conn = getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1,request_id);
			int x = pst.executeUpdate();
			if(x>0)
			{
				return true;
			}
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return false;
		
	}

}
