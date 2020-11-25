<%@ include file="../Assest/Properties/Header.jsp" %>
<%@page import="Service.AdminService"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.RequestTourModel"%>
<%@ page import="java.util.List" %>
<form method="post">
<h3>Request Tour List</h3>
<%
AdminService asobj = new AdminService();
List<RequestTourModel> tlist = asobj.reqTourList();
for(RequestTourModel rtobj :tlist)
{
%>
<table>
<tr>
<th>Image</th>
<th>Request Id</th>
<th>Shop Agency </th>
<th>Tour</th>
<th>Place</th>
<th>Price</th>
</tr>

<tr>
<td><img src="../Assest/UploadImage/<%=rtobj.getImage()%>" width="100px" height="100px" name="image"></td>
<td><a href="requestDetail.jsp?registerId=<%=rtobj.getReq_id()%>"><%=rtobj.getReq_id() %></a></td>
<td><%=rtobj.getSname() %></td>
<td><%=rtobj.getTourname() %></td>
<td><%=rtobj.getPlace() %></td>
<td><%=rtobj.getPrice() %></td>
</tr>

</table>
<%} %>


</form>
<%@ include file="../Assest/Properties/Footer.jsp" %>
