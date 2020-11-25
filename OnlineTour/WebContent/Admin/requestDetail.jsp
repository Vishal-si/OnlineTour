<%@page import="Model.RequestTourModel"%>
<%@page import="java.util.List"%>
<%@ include file="../Assest/Properties/Header.jsp" %>
<%@page import="Service.AgentService"%>


<%
int id = Integer.parseInt(request.getParameter("registerId"));
AgentService asobj = new AgentService();
List<RequestTourModel> rlist = asobj.getRequestById(id);
for(RequestTourModel rmobj:rlist)
{
%>
<form action="../AcceptAndRejectOperation" method="post" >



<label>Register Id</label>
<input type="text" name="registerId" value=<%=rmobj.getReq_id() %> ><br>

<label>Agent id number</label>
<textarea rows="" cols="" name="agentId"><%=rmobj.getAgent_id() %></textarea><br>

<label>Image</label>
<input type="text" value=<%=rmobj.getImage()%> name="image">

<label>Shop Name</label>
<textarea rows="" cols="" name="sname"><%=rmobj.getSname() %></textarea><br>

<label>Tour Title(Name)</label>
<textarea rows="" cols="" name="tname"><%=rmobj.getTourname() %></textarea><br>

<label>Tour State(place)</label>
<textarea rows="" cols="" name="state"><%=rmobj.getPlace() %></textarea><br>

<label>City</label>
<textarea rows="" cols="" name="city"><%=rmobj.getCity() %></textarea><br>

<label>Pincode</label>
<textarea rows="" cols="" name="pincode"><%=rmobj.getPincode() %></textarea><br>

<label>Day</label>
<textarea rows="" cols="" name="day"><%=rmobj.getDay() %></textarea><br>

<label>Amount Per Peson</label>
<textarea rows="" cols="" name="price"><%=rmobj.getPrice() %></textarea><br>

<label>Hotel Name</label>
<textarea rows="" cols="" name="hname"><%=rmobj.getHname() %></textarea><br>

<label>Manager Name</label>
<textarea rows="" cols="" name="mangername"><%=rmobj.getHotel_manager_name() %></textarea><br>

<label>Hotel Address</label>
<textarea rows="" cols="" name="haddress"><%=rmobj.getHaddress() %></textarea><br>

<label>Hotel Pincode</label>
<textarea rows="" cols="" name="hpincode"><%=rmobj.getHpincode() %></textarea><br>

<label>Hotel Contact Number</label>
<textarea rows="" cols="" name="hphone"><%=rmobj.getHphone() %></textarea><br>

<label>Tour Description</label>
<textarea rows="" cols="" name="tdescription"><%=rmobj.getDescribeTour() %></textarea><br>

<button name="btn" value="accept">Accept</button>
<button name="btn" value="reject">Reject</button>

<%} %>
</form>


<%@ include file="../Assest/Properties/Footer.jsp" %>