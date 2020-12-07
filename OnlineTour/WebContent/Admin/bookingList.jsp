<%@page import="Model.BookingModel"%>
<%@page import="java.util.List"%>
<%@page import="Service.AdminService"%>
<%@ include file="../Assest/Properties/Header.jsp" %>


<div class="container-fluid">
<%@ include file="../Assest/Properties/AdminNavBar.jsp" %>

<%
String admin_email = (String)session.getAttribute("admin_email");
if(admin_email==null || admin_email == "")
{
	response.sendRedirect("AdminLogin.jsp");
}
%>

<table class="table table-hover table-sm">
<caption>List Of Booking</caption>
<thead class="bg-danger text-white text-center">
<tr>
<th>Booking Id</th>
<th>User Id</th>
<th>Tour Id</th>
<th>Adult</th>
<th>Children</th>
<th>Citizen</th>
<th>Total Member</th>
</tr>
</thead>
<%

AdminService asobj = new AdminService();
List<BookingModel> blist = asobj.bookingList();
for(BookingModel bmobj:blist)
{%>


<tbody class="bg-white">
<tr>
<td><%=bmobj.getBooking_id() %></td>
<td><%=bmobj.getUserId() %></td>
<td><%=bmobj.getTour_id() %></td>
<td><%=bmobj.getAdult() %></td>
<td><%=bmobj.getChild() %></td>
<td><%=bmobj.getCitizen() %></td>
<td><%=bmobj.getTotal_member() %></td>
</tr>
</tbody>


<%} %>
</table>
</div>
<%@ include file="../Assest/Properties/Footer.jsp" %>