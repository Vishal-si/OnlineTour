<%@ include file="../Assest/Properties/Header.jsp" %>
<%@page import="Model.AgentModel"%>
<%@page import="java.util.List"%>
<%@page import="Service.AdminService"%>
 
<div class="container-fluid">
<%@ include file="../Assest/Properties/AdminNavBar.jsp" %>

<table class="table">
<thead class="bg-danger text-white text-center">
<tr>
<th>Image</th>
<th>Agent Id</th>
<th>Agent Name</th>
<th>Agent Email</th>
<th>Age </th>
<th>Agent Phone</th>
<th>Shop Name</th>
<th>Shop Address</th>
</tr>
</thead>
<%
AdminService asobj = new AdminService();
List<AgentModel> alist = asobj.agentList();
for(AgentModel amobj:alist)
{%>
<tbody class="bg-white">
<tr>
<td><img src="../Assest/UploadImage/<%=amobj.getSphoto() %>" class="image image-rounded"></td>
<td><%=amobj.getId() %></td>
<td><%=amobj.getName() %></td>
<td><%=amobj.getEmail() %></td>
<td><%=amobj.getAge() %></td>
<td><%=amobj.getPhone() %></td>
<td><%=amobj.getSname() %></td>
<td><%=amobj.getSaddress() %></td>
</tr>
</tbody>
<%} %>
</table>
</div>
<%@ include file="../Assest/Properties/Footer.jsp" %>
