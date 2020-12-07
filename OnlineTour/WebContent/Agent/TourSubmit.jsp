<%@page import="Model.AgentModel"%>
<%@page import="Service.AgentService"%>
<%@page import="java.util.List"%>
<%@ include file="../Assest/Properties/Header.jsp" %>

<div class="container-fluid">
<%@ include file="../Assest/Properties/AgentNavBar.jsp" %>
<div class="jumbotron mt-2 bg-danger">

</div>
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
<input type="hidden" name="agentId" value=<%=amobj.getId()%>>
<%}%>


<div class="form-group">

<label for="image">Upload image</label>
<input type="file" name="image" class="form-control" id="image" required>

<label for="sname">Shop name</label>
<input type="text" name="sname" class="form-control" id="sname" required>


<label for="tname">Tour Name</label>
<input type="text" name="tname" class="form-control" id="tname" required>

<label>Tour State</label>
<select name="place" class="form-control" required>
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

<label for="city">City</label>
<input type="text" name="city" class="form-control" id="city" required>

<label for="pincode">Pincode</label>
<input type="text" name="pincode" class="form-control" id="pincode" required>

<label for="day">Tour Day</label>
<input type="text" name="day" class="form-control" id="day" required>

<label for="price">Price</label>
<input type="number" name="price" class="form-control" id="price" required>

<label for="hotelname">Hotel Name</label>
<input type="text" name="hotelname" class="form-control" id="hotelname" required>

<label for="hoteladdress">Hotel Address</label>
<input type="text" name="hoteladdress" class="form-control" id="hoteladdress" required>

<label for="hotelpincode">Hotel Address pincode number</label>
<input type="text" name="hotelpincode" class="form-control" id="hotelpincode" required>

<label for="hotelmanager">Hotel Manager Name</label>
<input type="text" name="hotelmanager" class="form-control" id="hotelmanager" required>

<label for="hotelphone">Hotel Contact Number</label>
<input type="text" name="hotelphone" class="form-control" id="hotelphone" required>

<label for="describe">Describe the tour</label>
<textarea  name="describe" class="form-control" id="describe" required></textarea><br>

<button type="submit" class="btn btn-primary">Submit</button>
</div>
</form>
</div>
<%@ include file="../Assest/Properties/Footer.jsp" %>
