<%@page import="Model.AgentTourViewModel"%>
<%@page import="java.util.List"%>
<%@page import="Service.UserService"%>
<%@ include file="../Assest/Properties/Header.jsp" %>
<form action="" method="post">

<%
String email = (String)session.getAttribute("uemail");
out.println(email);
if((email == null) || (email==""))
{
	response.sendRedirect("login.jsp");
}
	

int tour_id = Integer.parseInt(request.getParameter("tour_id"));

UserService usobj = new UserService();
List<AgentTourViewModel> tlist = usobj.tourDetail(tour_id);
for(AgentTourViewModel amobj :tlist)
{
%>

<img src="../Assest/UploadImage/<%=amobj.getImage() %>" width="400px" height="400px">

<label>Agent Id</label>
<textarea name="agentId"><%=amobj.getId()%></textarea>

<label>Agent Name</label>
<textarea name="agentname"><%=amobj.getName() %></textarea>

<label>Shop Name</label>
<textarea name="shopname"><%=amobj.getShop_name() %></textarea>

<label>Agent Email</label>
<textarea name="agentemail"><%=amobj.getEmail() %></textarea>

<label>Agent Phone</label>
<textarea name="agentphone"><%=amobj.getPhone() %></textarea>

<label>shop Address</label>
<textarea name="shopaddress"><%=amobj.getShop_address() %></textarea>

<label>tour Id</label>
<textarea name="tourid"><%=amobj.getTour_id() %></textarea>

<label>Name of tour</label>
<textarea name="tourname"><%=amobj.getShop_name()%></textarea>

<label>Tour Place</label>
<textarea  name="place"><%=amobj.getPlace() %></textarea>

<label>City</label>
<textarea  name="city"><%=amobj.getCity() %></textarea>

<label>Pincode</label>
<textarea name="pincode"><%=amobj.getPincode() %></textarea>

<label>day</label>
<textarea name="day"><%=amobj.getDay() %></textarea>

<label>Price</label>
<input type="text" value=<%=amobj.getPrice() %> name="price">

<label>Hotel Name</label>
<textarea name="hotelname"><%=amobj.getHotel_name() %></textarea>

<label>Hotel Address</label>
<textarea name="hoteladdress"><%=amobj.getHotel_address() %></textarea>

<label>Hotel Pincode</label>
<textarea name="hotelpincode"><%=amobj.getHotel_pincode() %></textarea>

<label>Hotel Manager</label>
<textarea name="hotelmanager"><%=amobj.getHotel_manager() %></textarea>

<label>Hotel Phone</label>
<textarea name="hotelphone"><%=amobj.getHotel_phone() %></textarea>

<label>Description</label>
<textarea name="description"><%=amobj.getDescription() %></textarea>

<a href="bookingProccess.jsp?tour_id=<%=amobj.getTour_id() %>">Next></a>

<%} %>
</form>
<%@ include file="../Assest/Properties/Footer.jsp" %>
