<%@page import="Model.BookingModel"%>
<%@page import="java.util.List"%>
<%@page import="Service.AgentService"%>
<%@include file="../Assest/Properties/Header.jsp" %>

<div class="container-fluid">
<%@include file="../Assest/Properties/AgentNavBar.jsp" %>
<div class="jumbotron bg-danger mt-2">


</div>


<table class="table">
<thead class="text-center bg-danger text-white">
<tr>
<th>Booking id</th>
<th>Tour Id</th>
<th>Total Member</th>

</tr>
</thead>

<%
int tourId = Integer.parseInt(request.getParameter("tourId"));
AgentService asobj = new AgentService();
List<BookingModel> blist = asobj.getDetailOfBookingByTourId(tourId);
for(BookingModel bmobj:blist)
{
%>
<tbody class="text-center">
<tr>
<td><%=bmobj.getBooking_id() %></td>
<td><%=bmobj.getTour_id() %></td>
<td><%=bmobj.getTotal_member() %></td>
</tr>
</tbody>
<%} %>
</table>
</div>
<%@include file="../Assest/Properties/Footer.jsp" %>