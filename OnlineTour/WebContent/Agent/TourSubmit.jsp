<%@page import="Model.AgentModel"%>
<%@page import="Service.AgentService"%>
<%@page import="java.util.List"%>
<%@ include file="../Assest/Properties/Header.jsp" %>
<form action="../TourController" method="post" enctype="multipart/form-data">
<input type="hidden" name="task" value="submitTour">

<%
String aemail = (String)session.getAttribute("aemail");
AgentService asobj = new AgentService();
List<AgentModel> alist = asobj.getIdByEmail(aemail);

for(AgentModel amobj:alist)
{
%>

<!-- Agent Id -->
<input type="hidden" name="agentId" value=<%=amobj.getId()%>
<%}%>


<label>Upload image</label>
<input type="file" name="image">

<label>Shop name</label>
<input type="text" name="sname">


<label>Tour Name</label>
<input type="text" name="tname">

<label>Tour State</label>
<select name="place">
<option>select</option>
<option>Andaman and Nicobar</option>
<option>Andhra Pradesh</option>
<option>Arunachal Pradesh</option>
<option>Assam</option>
<option>Bihar</option>
<option>Chandigarh</option>
<option>Chhattisgarh</option>
<option>Dadar and Nagar Haveli</option>
<option>Daman and Diu</option>
<option>Delhi</option>
<option>Goa</option>
<option>Gujarat</option>
<option>Harayan</option>
<option>Himachal Pradesh</option>
<option>Jharkhand</option>
<option>Jammu and Kashmir</option>
<option>Karnataka</option>
<option>Kerala</option>
<option>Lakshadweep</option>
<option>Madhya Pradesh</option>
<option>Maharashtra</option>
<option>Manipur</option>
<option>Meghalaya</option>
<option>Mizoram</option>
<option>Nagaland</option>
<option>Odisha</option>
<option>Punjab</option>
<option>Puducherry</option>
<option>Rajasthan</option>
<option>Sikkim</option>
<option>Tamil Nadu</option>
<option>Telangana</option>
<option>Tripura</option>
<option>Uttar Pradesh</option>
<option>Uttarakhand</option>
<option>WestBengal</option>
</select>

<label>City</label>
<input type="text" name="city">

<label>Pincode</label>
<input type="text" name="pincode">

<label>Tour Day</label>
<input type="text" name="day">

<label>Price</label>
<input type="number" name="price">

<label>Hotel Name</label>
<input type="text" name="hotelname">

<label>Hotel Address</label>
<input type="text" name="hoteladdress">

<label>Hotel Address pincode number</label>
<input type="text" name="hotelpincode">

<label>Hotel Manager Name</label>
<input type="text" name="hotelmanager">

<label>Hotel Contact Number</label>
<input type="text" name="hotelphone">

<label>Describe the tour</label>
<textarea  name="describe"></textarea>

<button type="submit">Submit</button>

</form>
<%@ include file="../Assest/Properties/Footer.jsp" %>
