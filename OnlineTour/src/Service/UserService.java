package Service;


import ConnectionManagement.ConnectionClass;
import Model.AgentModel;
import Model.AgentTourViewModel;
import Model.PaymentModel;
import Model.RequestTourModel;
import Model.UserModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserService extends ConnectionClass
{
	public boolean createAccount(UserModel uobj)
	{
		String query = "INSERT INTO user(name,email,password,dob,phone) VALUE(?,?,?,?,?)";
		try
		{
			Connection conn = getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,uobj.getName());
			pst.setString(2,uobj.getEmail());
			pst.setString(3,uobj.getPassword());
			pst.setDate(4,uobj.getDob());
			pst.setString(5,uobj.getPhone());
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
	
	public boolean login(UserModel uobj)
	{
		String query="SELECT *FROM user WHERE email = ? AND password = ?";
		try
		{
			Connection conn = getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,uobj.getEmail());
			pst.setString(2,uobj.getPassword());
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
	
	public List<RequestTourModel> dashboardTour()
	{
		List<RequestTourModel> tlist = new ArrayList<RequestTourModel>();
		String query ="SELECT tour_id,image,tour_name,place,price FROM tour ORDER BY tour_id DESC LIMIT 4";
		try
		{
			Connection conn = getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				RequestTourModel rmobj = new RequestTourModel();
				rmobj.setId(rs.getInt("tour_id"));
				rmobj.setImage(rs.getString("image"));
				rmobj.setTourname(rs.getString("tour_name"));
				rmobj.setPlace(rs.getString("place"));
				rmobj.setPrice(rs.getFloat("price"));
				tlist.add(rmobj);
			}
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			System.out.println(this.getClass().getName());
		}
		return tlist;
		
	}
	public List<AgentTourViewModel> tourDetail( int tour_id)
	{
		List<AgentTourViewModel> tlist = new ArrayList<AgentTourViewModel>();
		String query="SELECT *FROM agent_tour_view WHERE tour_id = ?";
		try
		{
			Connection conn = getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1,tour_id);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				AgentTourViewModel amobj = new AgentTourViewModel();
				amobj.setId(rs.getInt("id"));//agent Id
				amobj.setName(rs.getString("name")); // agent_name
				amobj.setShop_name(rs.getString("shop_name")); //agent shop name
				amobj.setEmail(rs.getString("email"));//agent Email
				amobj.setPhone(rs.getString("phone"));//agent Phone number
				amobj.setShop_address(rs.getString("shop_address"));//agent shop address
				amobj.setTour_id(rs.getInt("tour_id"));//tour id
				amobj.setImage(rs.getString("image"));
				amobj.setTour_name(rs.getString("tour_name"));
				amobj.setCity(rs.getString("city"));
				amobj.setPlace(rs.getString("place"));
				amobj.setPincode(rs.getString("pincode"));
				amobj.setDay(rs.getString("day"));
				amobj.setPrice(rs.getFloat("price"));
				amobj.setHotel_name(rs.getString("hotel_name"));
				amobj.setHotel_address(rs.getString("hotel_address"));
				amobj.setHotel_pincode(rs.getString("hotel_pincode"));
				amobj.setHotel_phone(rs.getString("hotel_phone"));
				amobj.setHotel_manager(rs.getString("hotel_manager"));
				amobj.setDescription(rs.getString("description"));
				
				tlist.add(amobj);
			}
			
		}catch(Exception e)
		{
			System.out.println(e.getMessage());
			
		}
		return tlist;
	}
	
	public List<UserModel> getUserList(String email)
	{
		List<UserModel> ulist = new ArrayList<UserModel>();
		String query = "SELECT *FROM  user WHERE email = ?";
		try
		{
			Connection conn = getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,email);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				UserModel umobj =new UserModel();
				umobj.setId(rs.getInt("id"));
				umobj.setName(rs.getString("name"));
				umobj.setEmail(rs.getString("email"));
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
	
	public boolean phoneNumberUpdate(UserModel umobj,int userId)
	{
		String query="UPDATE user SET phone = ? WHERE id = ?";
		try
		{
			
			Connection conn = getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1,umobj.getPhone());
			pst.setInt(2,userId);
			int x = pst.executeUpdate();
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
	
	public boolean paymentPay(PaymentModel pmobj)
	{
		String query="INSERT INTO payment(userId,tourId,amount,paymenttype) value(?,?,?,?)";
		try
		{
			Connection conn= getConn();
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setInt(1,pmobj.getUserId());
			pst.setInt(2,pmobj.getTourId());
			pst.setFloat(3,pmobj.getAmount());
			pst.setString(4,pmobj.getPaymentType());
			int x = pst.executeUpdate();
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
	
	
	
	
	

}
