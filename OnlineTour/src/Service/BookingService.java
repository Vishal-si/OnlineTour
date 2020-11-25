package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;

import ConnectionManagement.ConnectionClass;
import Model.BookingModel;

public class BookingService extends ConnectionClass {
	
	public boolean bookingRequest(BookingModel bmobj )
	{
		String query="INSERT INTO booking(tourId,userid,total_member,child,adult,citizen)VALUE(?,?,?,?,?,?)";
		try
		{
			Connection conn = getConn();
			PreparedStatement pst =conn.prepareStatement(query);
			pst.setInt(1, bmobj.getTour_id());
			pst.setInt(2, bmobj.getUserId());
			pst.setInt(3, bmobj.getTotal_member());
			pst.setInt(4, bmobj.getChild());
			pst.setInt(5, bmobj.getAdult());
			pst.setInt(6, bmobj.getCitizen());
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
