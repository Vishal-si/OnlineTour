<%@page import="Model.UserModel"%>
<%@page import="java.util.List"%>
<%@page import="Service.AdminService"%>
<%@ include file="../Assest/Properties/Header.jsp" %>
<div class="container-fluid">
<%@ include file="../Assest/Properties/AdminNavBar.jsp" %>


<table class="table">
<thead class="bg-danger text-white text-center">
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

<tbody class="bg-white">
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
</div>
<%@ include file="../Assest/Properties/Footer.jsp" %>