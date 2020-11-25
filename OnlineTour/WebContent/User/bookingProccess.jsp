<%@page import="Model.AgentTourViewModel"%>
<%@page import="Service.UserService"%>
<%@page import="Model.UserModel"%>
<%@page import="java.util.List"%>
<%@ include file="../Assest/Properties/Header.jsp" %>
<form action="../BookingProccessController" method="post">

<h2>Booking Proccess</h2>


<% 
String email = (String)session.getAttribute("uemail");
if((email==null)||(email==""))
{
	response.sendRedirect("login.jsp");
}
UserService usobj = new UserService();
List<UserModel> ulist = usobj.getUserList(email);
for(UserModel umobj:ulist)
{
%>

<input type="hidden" value=<%=umobj.getId() %> name="userId">
<label>Phone Number</label>
<input type="text" value=<%=umobj.getPhone() %>> 
<button>Change Number</button>
<label>Enter the new Phone number</label>
<input type="text" name="newPhone">
<button type="submit" name="btn" value="newPhoneNumber">submit</button>
<%}%>


<label>Total Member</label>
<input type="number" name="total_member">

<label>Adults</label>
<input type="number" name="adult">

<label>Children</label>
<input type="number" name="child">

<label>Citizen</label>
<input type="number" name="citizen">

<%
int tour_id = Integer.parseInt(request.getParameter("tour_id"));
List<AgentTourViewModel> tlist = usobj.tourDetail(tour_id);
for(AgentTourViewModel amobj :tlist)
{
%>
<label>Tour Name</label>
<select name="tourname">
<option><%=amobj.getTour_name() %></option>
</select>

<label>Tour Place</label>
<select name="place">
<option><%=amobj.getPlace() %></option>
</select>

<label>Tour city</label>
<select name="city">
<option><%=amobj.getCity() %></option>
</select>

<label>Price Per Person</label>
<select name="price">
<option><%=amobj.getPrice() %></option>
</select>

<label>Hotel Name</label>
<select name="hotelname">
<option><%=amobj.getHotel_name() %></option>
</select>

<label>Hotel Address</label>
<select name="hoteladdress">
<option><%=amobj.getHotel_address() %>
</select>

<label>Hotel Contact</label>
<select name="hotelphone">
<option><%=amobj.getHotel_phone() %></option>
</select>

<label>Agency Name</label>
<select name="shop_name">
<option><%=amobj.getShop_name() %></option>
</select>

<label>Agency Contact</label>
<select name="shop_phone">
<option><%=amobj.getPhone() %>
</select>

<input type="hidden" value=<%=amobj.getId() %> name="agentId"> <!--Agent Id -->

<input type="hidden" value=<%=amobj.getTour_id() %> name="tourId"> <!--Tour Id -->

<%} %>

<button type="submit" name="btn" value="booking">Confirm</button>




</form>
<%@ include file="../Assest/Properties/Footer.jsp" %>
