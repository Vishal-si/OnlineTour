<%@page import="Model.RequestTourModel"%>
<%@page import="java.util.List"%>
<%@page import="Service.UserService"%>
<%@ include file="../Assest/Properties/Header.jsp" %>

<ul>
<li><a href="#">Home</a></li>
<li><a href="#">Tour</a></li>
<li><a href="#">Account</a></li>
<li><a href="#">Change Password</a></li>
<li><a href="#">Contact</a></li>
<li><a href="logout.jsp">Logout</a></li>
</ul>

<h2>Latest Tour</h2>
<%
UserService usobj = new UserService();
List<RequestTourModel> tlist = usobj.dashboardTour();
for(RequestTourModel rmobj :tlist)
{ %>
<table>
<tr>
<td><a href="tourDetail.jsp?tour_id=<%=rmobj.getId()%>"><img src="../Assest/UploadImage/<%=rmobj.getImage()%>" width="200px" height="200px" ></a></td>
<td><%=rmobj.getTourname() %></td>
<td><%=rmobj.getPlace() %></td>
<td><%=rmobj.getPrice() %></td>
</tr>


</table>
<%} %>

<%@ include file="../Assest/Properties/Footer.jsp" %>
