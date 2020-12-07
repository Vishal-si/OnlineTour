<%@ include file="../Assest/Properties/Header.jsp" %>
<%@page import="Service.AdminService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.RequestTourModel"%>
<%@ page import="java.util.List" %>

<div class="container-fluid">
<%@ include file="../Assest/Properties/AdminNavBar.jsp" %>

<%
String admin_email = (String)session.getAttribute("admin_email");
if(admin_email==null || admin_email == "")
{
	response.sendRedirect("AdminLogin.jsp");
}

%>

<table class="table">
<thead class="bg-danger text-white text-center text-center">
<tr>
<th>Image</th>
<th>Request Id</th>
<th>Shop Agency </th>
<th>Tour</th>
<th>Place</th>
<th>Price</th>
</tr>
</thead>

<%
AdminService asobj = new AdminService();
List<RequestTourModel> tlist = asobj.reqTourList();
for(RequestTourModel rtobj :tlist)
{
%>
<tbody>
<tr>
<td><img src="../Assest/UploadImage/<%=rtobj.getImage()%>" width="100px" height="100px" name="image"></td>
<td><a href="requestDetail.jsp?registerId=<%=rtobj.getReq_id()%>"><%=rtobj.getReq_id() %></a></td>
<td><%=rtobj.getSname() %></td>
<td><%=rtobj.getTourname() %></td>
<td><%=rtobj.getPlace() %></td>
<td><%=rtobj.getPrice() %></td>
</tr>
</tbody>

<%} %>
</table>
</div>

<%@ include file="../Assest/Properties/Footer.jsp" %>
