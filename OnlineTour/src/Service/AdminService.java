package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ConnectionManagement.ConnectionClass;
import Model.AdminModel;
import Model.AgentModel;
import Model.BookingModel;
import Model.PaymentModel;
import Model.RequestTourModel;
import Model.UserModel;

public class AdminService extends ConnectionClass{
	
	public boolean adminLogin(AdminModel amobj)
	{
		String query="SELECT *FROM admin WHERE admin_email = ? AND admin_password = ?";
		try
		{
			Connection conn = getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,amobj.getAdmin_email());
			pst.setString(2,amobj.getAdmin_password());
			ResultSet rs = pst.executeQuery();
			if(rs.next())
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
	
	public List<RequestTourModel> reqTourList()
	{
		List<RequestTourModel> rtlist = new ArrayList<RequestTourModel>();
		String query="SELECT id,shop_name,tour_name,place,price,image FROM requesttour";
		RequestTourModel robj = new RequestTourModel();
		try
		{
			Connection conn = getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				robj.setReq_id(rs.getInt("id"));
				robj.setSname(rs.getString("shop_name"));
				robj.setTourname(rs.getString("tour_name"));
				robj.setPlace(rs.getString("place"));
				robj.setPrice(rs.getFloat("price"));
				robj.setImage(rs.getString("image"));
				rtlist.add(robj);
			}
					
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return rtlist;
		
		
	}
	public List<UserModel> userList()
	{
		List<UserModel> ulist = new ArrayList<UserModel>();
		String query="SELECT *FROM user";
		try
		{
			Connection conn = getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				UserModel umobj = new UserModel();
				umobj.setId(rs.getInt("id"));
				umobj.setName(rs.getString("name"));
				umobj.setEmail(rs.getString("email"));
				umobj.setPassword(rs.getString("password"));
				umobj.setDob(rs.getDate("dob"));
				umobj.setPhone(rs.getString("phone"));
				ulist.add(umobj);
				
			}
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return ulist;
	}
	

	
	public List<RequestTourModel> tourList()
	{
		List<RequestTourModel> tlist = new ArrayList<RequestTourModel>();
		String query="SELECT *FROM tour";
		try
		{
			Connection conn = getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				RequestTourModel rmobj = new RequestTourModel();
				rmobj.setId(rs.getInt("tour_id"));
				rmobj.setAgent_id(rs.getInt("agent_id"));
				rmobj.setTourname(rs.getString("tour_name"));
				rmobj.setImage(rs.getString("image"));
				rmobj.setPlace(rs.getString("place"));
				rmobj.setCity(rs.getString("city"));
				rmobj.setPincode(rs.getString("pincode"));
				rmobj.setDay(rs.getString("day"));
				rmobj.setPrice(rs.getFloat("price"));
				rmobj.setHname(rs.getString("hotel_name"));
				rmobj.setHaddress(rs.getString("hotel_address"));
				rmobj.setHpincode(rs.getString("hotel_pincode"));
				rmobj.setHphone(rs.getString("hotel_phone"));
				rmobj.setHotel_manager_name(rs.getString("hotel_manager"));
				rmobj.setDescribeTour(rs.getString("description"));
				tlist.add(rmobj);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return tlist;
	}
	
	public List<BookingModel> bookingList()
	{
		List<BookingModel> blist = new ArrayList<BookingModel>();
		String query="SELECT *FROM booking";
		try
		{
			Connection conn = getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				BookingModel bmobj = new BookingModel();
				bmobj.setBooking_id(rs.getInt("booking_id"));
				bmobj.setTour_id(rs.getInt("tourid"));
				bmobj.setUserId(rs.getInt("userid"));
				bmobj.setTotal_member(rs.getInt("total_member"));
				bmobj.setChild(rs.getInt("child"));
				bmobj.setAdult(rs.getInt("adult"));
				bmobj.setCitizen(rs.getInt("citizen"));
				blist.add(bmobj);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return blist;
	}
	public List<AgentModel> agentList()
	{
		List<AgentModel> alist = new ArrayList<AgentModel>();
		String query = "SELECT *FROM agent";
		try
		{
			Connection conn = getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				AgentModel amobj = new AgentModel();
				amobj.setId(rs.getInt("id"));
				amobj.setName(rs.getString("name"));
				amobj.setEmail(rs.getString("email"));
				amobj.setAge(rs.getInt("age"));
				amobj.setPhone(rs.getString("phone"));
				amobj.setSname(rs.getString("shop_name"));
				amobj.setSaddress(rs.getString("shop_address"));
				amobj.setSphoto(rs.getString("agent_image"));
				alist.add(amobj);			
			}
			
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return alist;
	}
	
	
	public List<PaymentModel> paymentList()
	{
		List<PaymentModel> plist = new ArrayList<PaymentModel>();
		String query = "SELECT *FROM payment";
		try
		{
			Connection conn = getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rst = pst.executeQuery();
			while(rst.next())
			{
				PaymentModel pmobj = new PaymentModel();
				pmobj.setPayId(rst.getInt("payId"));
				pmobj.setUserId(rst.getInt("userId"));
				pmobj.setTourId(rst.getInt("tourId"));
				pmobj.setAmount(rst.getFloat("amount"));
				pmobj.setPaymentType(rst.getString("paymentType"));
				plist.add(pmobj);
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return plist;
	}
	
}
