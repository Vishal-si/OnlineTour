<%@page import="Model.UserModel"%>
<%@page import="java.util.List"%>
<%@page import="Service.AdminService"%>
<%@ include file="../Assest/Properties/Header.jsp" %>

<h2>User List</h2>
<table>
<thead>
<tr>
<th>User ID</th>
<th>Name</th>
<th>Email</th>
<th>Date of birth</th>
<th>Contact</th>
</tr>
</thead>
<%
AdminService asobj = new AdminService();
List<UserModel> ulist = asobj.userList();
for(UserModel umobj:ulist)
{%>



<tbody>
<tr>
<td><%=umobj.getId() %></td>
<td><%=umobj.getName() %></td>
<td><%=umobj.getEmail() %></td>
<td><%=umobj.getDob() %></td>
<td><%=umobj.getPhone() %></td>
</tr>
</tbody>


<%} %>
</table>

<%@ include file="../Assest/Properties/Footer.jsp" %>