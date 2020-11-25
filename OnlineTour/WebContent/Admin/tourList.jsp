<%@page import="Model.RequestTourModel"%>
<%@page import="java.util.List"%>
<%@page import="Service.AdminService"%>
<%@ include file="../Assest/Properties/Header.jsp" %>
<table>
<thead>
<tr>
<th>Tour Id</th>
<th>Agent Id</th>
<th>Image</th>
<th>Tour Name</th>
<th>Place</th>
<th>City</th>
<th>Picode</th>
<th>Day</th>
<th>Price</th>
<th>Hotel Name</th>
<th>Hotel Address</th>
<th>Hotel Pincode</th>
<th>Hotel Manager Name</th>
<th>Contact Number</th>
</tr>
</thead>
<%
AdminService asobj = new AdminService();
List<RequestTourModel> tlist = asobj.tourList();
for(RequestTourModel rmobj:tlist)
{
%>
<tbody>
<tr>
<td><%=rmobj.getId() %></td>
<td><%=rmobj.getAgent_id() %></td>
<td><img src="../Assest/UploadImage/<%=rmobj.getImage() %>" width="200px" height="200px"></td>
<td><%=rmobj.getTourname() %></td>
<td><%=rmobj.getPlace() %></td>
<td><%=rmobj.getCity() %></td>
<td><%=rmobj.getPincode() %></td>
<td><%=rmobj.getDay() %></td>
<td><%=rmobj.getPrice() %></td>
<td><%=rmobj.getHname() %></td>
<td><%=rmobj.getHaddress() %></td>
<td><%=rmobj.getPincode() %></td>
<td><%=rmobj.getHotel_manager_name() %></td>
<td><%=rmobj.getHphone() %></td>

</tr>
</tbody>



<%} %>
</table>
<%@ include file="../Assest/Properties/Footer.jsp" %>