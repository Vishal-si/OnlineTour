<%@page import="Service.AgentService"%>
<%@page import="Model.RequestTourModel"%>
<%@page import="java.util.List"%>
<%@include file="../Assest/Properties/Header.jsp" %>


<div class="container-fluid">
<%@include file="../Assest/Properties/AgentNavBar.jsp" %>
<div class="jumbotron bg-danger mt-2">


</div>

<table class="table">
<thead class="text-center bg-danger text-white">
<tr>
<th>Tour Id</th>
<th>Image</th>
<th>Tour Name</th>
<th>Place & city</th>
<th>Pincode</th>
<th>Day</th>
<th>Price</th>
<th>Hotel</th>
<th>Address & pincode</th>
<th>Manager</th>
<th>Phone</th>
</tr>
</thead>

<tbody class="text-center">
<%
int agentId = Integer.parseInt(request.getParameter("agentId"));
AgentService asobj = new AgentService();
List<RequestTourModel> tlist = asobj.getDetailOfTourByAgengId(agentId);
for(RequestTourModel rmobj:tlist)
{
%>
<tr>
<td><%=rmobj.getId() %></td>
<td><img src="../Assest/UploadImage/<%=rmobj.getImage() %>" style="width:200px; height:150px" ></td>
<td><%=rmobj.getTourname() %></td>
<td><%=rmobj.getPlace()%>&<%=rmobj.getCity() %></td>
<td><%=rmobj.getPincode() %></td>
<td><%=rmobj.getDay() %></td>
<td><%=rmobj.getPrice() %></td>
<td><%=rmobj.getHname() %></td>
<td><%=rmobj.getHaddress() %>  <%=rmobj.getHpincode()%></td>
<td><%=rmobj.getHotel_manager_name() %></td>
<td><%=rmobj.getHphone() %></td>

</tr>
<%}%>

</tbody>
</table>
</div>
<%@include file="../Assest/Properties/Footer.jsp" %>